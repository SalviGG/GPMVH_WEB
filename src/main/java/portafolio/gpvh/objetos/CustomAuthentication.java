package portafolio.gpvh.objetos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.controlAccesoWS.service.ConsultaControlAccesoServicio;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthentication implements AuthenticationProvider {

    @Autowired
    private ConsultaControlAccesoServicio consulta;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        int username = Integer.parseInt(authentication.getName());
        String password = authentication.getCredentials().toString();

        Persona persona = consulta.externalLogin(username,password);

        if (persona != null){
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_FUNCIONARIO"));
            Authentication auth = new UsernamePasswordAuthenticationToken(username,password,grantedAuths);
            return auth;
            //return new UsernamePasswordAuthenticationToken(username,password, Collections.emptyList());
        }else{
            throw new
                    BadCredentialsException("External system authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
