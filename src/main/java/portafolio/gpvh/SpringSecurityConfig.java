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

    @Autowired
    CustomAuthentication customAuthentication;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(customAuthentication);
    }


    @Override
    protected void configure(HttpSecurity http)throws Exception{

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**","/fonts/**","/images/**","/js/**","/vendor/**").permitAll()
                .antMatchers("/**").authenticated()//.permitAll()//.hasAnyRole("ADMIN","USER")
                //.antMatchers("/solicitud").authenticated()//.hasAnyRole("ADMIN")
                .anyRequest().authenticated()
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
