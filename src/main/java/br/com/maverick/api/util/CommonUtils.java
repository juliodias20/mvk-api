package br.com.maverick.api.util;

import br.com.maverick.api.security.CurrentUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class CommonUtils {
    public static CurrentUser getCurrentUser() {
        try {
            return (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception ex) {
            return null;
        }
    }
}
