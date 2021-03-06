package com.mvm.MVM.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .anonymous().and().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/auth/registration").permitAll()
                .antMatchers(HttpMethod.GET,"/category/all").permitAll()
                .anyRequest().authenticated();
        // @formatter:on
    }

}
