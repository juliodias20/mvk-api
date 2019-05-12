package br.com.maverick.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

import static br.com.maverick.api.security.JwtConstants.SECRET;

@Component
public class JwtTokenUtil {
    public String generateToken(CurrentUser currentUser) {
        Claims claims = Jwts.claims().setSubject(currentUser.getUsername());
        claims.put("id", currentUser.getId());
        claims.put("name", currentUser.getName());
        claims.put("companyId", currentUser.getCompanyId());
        claims.put("cpf", currentUser.getCpf());

        return Jwts.builder()
                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public Integer getIdFromToken(String token) {
        return (Integer) this.getAllClaimsFromToken(token).get("id");
    }

    public Integer getCompanyIdFromToken(String token) {
        return (Integer) this.getAllClaimsFromToken(token).get("companyId");
    }

    public String getNameFromToken(String token) {
        return (String) this.getAllClaimsFromToken(token).get("name");
    }

    public String getCpfFromToken(String token) {
        return (String) this.getAllClaimsFromToken(token).get("cpf");
    }

    public String getImageUrlFromToken(String token) {
        return (String) this.getAllClaimsFromToken(token).get("imageUrl");
    }

    public String getUsernameFromToken(String token) {
        return this.getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
