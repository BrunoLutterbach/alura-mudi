package br.com.brunolutterbach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Esse é um método que é chamado pelo Spring Security para configurar o filtro de segurança.
        http
                .authorizeRequests()
                .anyRequest().authenticated() // Todas as requisições devem ser autenticadas.
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout"));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Cria um usuário padrão para o Spring Security.
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("bruno")
                .password("123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}

