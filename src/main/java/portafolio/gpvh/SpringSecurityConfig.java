package portafolio.gpvh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import portafolio.gpvh.controlAccesoWS.service.serviceIMPL.ConsultaControlAccesoServicioIMPL;
import portafolio.gpvh.objetos.CustomAuthentication;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Inyecta autenticador personalizado
     */
    @Autowired
    CustomAuthentication customAuthentication;

    /**
     * Este metodo sobreescribe la configuración de spring security para utilizar el autenticador inyectado
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(customAuthentication);
    }


    /**
     * Este metodo sobreescribe la configuración de spring security para otorgar y denegar permisos y accesos
     * a las paginas de la webapp.
     * El primer metodo utilizado implemental la seguridad a las páginas y controla el login y logout de la
     * aplicación
     * El segundo metodo utilizado maneja las sesiones
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http)throws Exception{

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**","/fonts/**","/images/**","/js/**","/vendor/**").permitAll()
                .antMatchers("/consultasReportes","/consultaResoluciones","/informePermisos").hasAnyRole("ALCALDE", "JEFE SUPERIOR")
                .antMatchers("/rrhh").hasRole("RRHH")
                .antMatchers("/uploads/**").hasRole("RRHH")
                .antMatchers("/**").authenticated()//.permitAll()//.hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/dashboard")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .maximumSessions(1)
                .expiredUrl("/login");
    }

}
