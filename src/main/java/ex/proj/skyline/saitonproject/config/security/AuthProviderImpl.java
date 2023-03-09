package ex.proj.skyline.saitonproject.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav Domaniewski
 */

@Component
public class AuthProviderImpl implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
