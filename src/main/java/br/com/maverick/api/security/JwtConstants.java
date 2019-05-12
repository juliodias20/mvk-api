package br.com.maverick.api.security;

public class JwtConstants {
    public static final String SECRET = "CUr7BgSnRL4J7yyA";
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
}
