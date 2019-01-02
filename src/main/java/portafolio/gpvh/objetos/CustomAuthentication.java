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
import org.springframework.validation.BeanPropertyBindingResult;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.controlAccesoWS.service.ConsultaControlAccesoServicio;
import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.service.FuncionarioService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthentication implements AuthenticationProvider  {

    /**
     * Inyecta el la interfaz que maneja la implementación del webservice
     */
    @Autowired
    private ConsultaControlAccesoServicio consulta;

    @Autowired
    private transient Validator validator;

    @Autowired
    private FuncionarioService funcionario;

    /**
     * Sobreescribe la autenticación de spring security para ser utilizada en el archivo de configuración de spring.
     * Este metodo hace la validación contra el webservice y genera un token de autenticación, además entrega un rol
     * al usuario que ha ingresado.
     * @param authentication
     * @return auth  retorna un token con la autenticación del usuario
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //int username = Integer.parseInt(authentication.getName());
        if (tryParseInt(authentication.getName())){
            int username = Integer.parseInt(authentication.getName());

            String password = authentication.getCredentials().toString();

            ValidacionLogin validacionLogin = new ValidacionLogin();
            validacionLogin.setRut(username);
            validacionLogin.setPassword(password);

            BeanPropertyBindingResult errors = new BeanPropertyBindingResult(validacionLogin, "login");

            if (errors.hasErrors()){
                throw  new
                        BadCredentialsException("Autenticación fallida");
            }

            Persona persona = consulta.externalLogin(username,password);

            if (persona != null){
                List<GrantedAuthority> grantedAuths = new ArrayList<>();
                int rut = persona.getRut();
                String rol = (funcionario.buscarPorRut(rut).getRolId().getNombre()).toUpperCase();
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_"+rol));
                Authentication auth = new UsernamePasswordAuthenticationToken(username,password,grantedAuths);
                return auth;
                //return new UsernamePasswordAuthenticationToken(username,password, Collections.emptyList());
            }else{
                throw new
                        BadCredentialsException("Autenticación fallida");
            }
        }else{
            throw  new
                    BadCredentialsException("Autenticación fallida");
        }

    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

    public boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
