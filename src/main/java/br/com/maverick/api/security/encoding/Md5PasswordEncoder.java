package br.com.maverick.api.security.encoding;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;

public class Md5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        String encPass = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(charSequence.toString().getBytes());

            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }

            encPass = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encPass;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return this.encode(charSequence).equals(s);
    }
}
