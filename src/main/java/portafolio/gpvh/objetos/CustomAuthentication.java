package portafolio.gpvh.objetos;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.controlAccesoWS.service.serviceIMPL.ConsultaControlAccesoServicioIMPL;

import java.util.Collections;

@Component
public class CustomAuthentication implements AuthenticationProvider {

    private ConsultaControlAccesoServicioIMPL consulta = new ConsultaControlAccesoServicioIMPL();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        int username = Integer.parseInt(authentication.getName());
        String password = authentication.getCredentials().toString();

        Persona persona = consulta.externalLogin(username,password);

        if (persona != null){
            return new UsernamePasswordAuthenticationToken(username,password, Collections.emptyList());
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
