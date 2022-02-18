package com.yandiradproject.budgettracker.security;

import com.yandiradproject.budgettracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author yandirad
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
    public UserService userService;
    
    // Setting Service to find User in the database.
    // And Setting PassswordEncoder
    // El numero 4 representa que tan fuerte quieres la encriptacion.
    // Se puede en un rango entre 4 y 31.
    // Si no pones un numero el programa utilizara uno aleatoriamente cada vez
    // que inicies la aplicacion, por lo cual tus contrasenas encriptadas no
    // funcionaran bien
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
            .userDetailsService(userService)
            .passwordEncoder(new BCryptPasswordEncoder(4));
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin().and()
        .authorizeRequests()
            .antMatchers("/css/*", "/js/*", "/img/*", "/**")
            .permitAll()
            .antMatchers("/admin/*")
            .hasAuthority("ADMIN")
        .and().formLogin()
            .loginPage("/auth/form/login") // Que formulario esta mi login
                .loginProcessingUrl("/auth/logincheck")
                .usernameParameter("email") // Como viajan los datos del logueo
                .passwordParameter("password")// Como viajan los datos del logueo
                .defaultSuccessUrl("/")// A que URL viaja
                .failureUrl("/login?error")
                .permitAll()
        .and().logout() // Aca configuro la salida
            .logoutUrl("/auth/logout")
            .logoutSuccessUrl("/")
            .permitAll()
        .and().csrf()
                .disable();
    }
    
}
