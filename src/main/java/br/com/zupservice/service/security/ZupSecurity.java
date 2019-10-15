package br.com.zupservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ZupSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zupUser").password("{noop}zupuser").roles("USER")
                .and()
                .withUser("zupAdmin").password("{noop}zupadmin").roles("USER", "SUPERUSER");
    }

    @Override
    protected void configure(HttpSecurity auth) throws Exception {
        auth.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/clients/**").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/address/**").hasAnyRole("USER")
                .antMatchers(HttpMethod.POST, "/clients").hasAnyRole("USER")
                .antMatchers(HttpMethod.POST, "/address").hasAnyRole("USER")
                .antMatchers(HttpMethod.PUT, "/clients/**").hasAnyRole("SUPERUSER")
                .antMatchers(HttpMethod.PUT, "/address/**").hasAnyRole("SUPERUSER")
                .antMatchers(HttpMethod.DELETE, "/clients/**").hasAnyRole("SUPERUSER")
                .antMatchers(HttpMethod.DELETE, "/address/**").hasAnyRole("SUPERUSER");
    }
}
