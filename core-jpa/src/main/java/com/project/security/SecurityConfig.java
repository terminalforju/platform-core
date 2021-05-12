package com.project.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 配置类、开启 Security 服务、开启全局 Securtiy 注解
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private MyUserDetailsService userService;

//    /**
//     * 修改加密方式
//     * @param auth
//     * @throws Exception
//     */
//        @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        //校验用户
//        auth.userDetailsService( userService ).passwordEncoder( new PasswordEncoder() {
//            //对密码进行加密
//            @Override
//            public String encode(CharSequence charSequence) {
//                System.out.println(charSequence.toString());
//
//                return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
//            }
//            //对密码进行判断匹配
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                String encode = DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
//                boolean res = s.equals( encode );
//                return res;
//            }
//        } );
//
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/", "/static/**", "index", "/login", "/login-error", "/401", "/css/**", "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
//                .antMatchers("/", "/static/**", "index", "/login", "/login-error", "/401", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .and()
                .exceptionHandling().accessDeniedPage("/401");
        http.formLogin().successForwardUrl("/");
        http.logout().logoutSuccessUrl("/");
    }


}
