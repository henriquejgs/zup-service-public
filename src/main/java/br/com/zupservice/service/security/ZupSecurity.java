package br.com.zupservice.service.security;

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
                .antMatchers(HttpMethod.GET, "/**").hasAnyRole("USER")
                .antMatchers(HttpMethod.POST, "/").hasAnyRole("USER")
                .antMatchers(HttpMethod.PUT, "/**").hasAnyRole("SUPERUSER")
                .antMatchers(HttpMethod.PATCH, "/**").hasAnyRole("SUPERUSER")
                .antMatchers(HttpMethod.DELETE, "/**").hasAnyRole("SUPERUSER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
