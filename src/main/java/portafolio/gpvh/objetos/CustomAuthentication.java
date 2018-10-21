package portafolio.gpvh.objetos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.controlAccesoWS.service.ConsultaControlAccesoServicio;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthentication implements AuthenticationProvider {

    /**
     * Inyecta el la interfaz que maneja la implementación del webservice
     */
    @Autowired
    private ConsultaControlAccesoServicio consulta;

    /**
     * Sobreescribe la autenticación de spring security para ser utilizada en el archivo de configuración de spring.
     * Este metodo hace la validación contra el webservice y genera un token de autenticación, además entrega un rol
     * al usuario que ha ingresado.
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
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
                    BadCredentialsException("Autenticación fallida");
        }
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
