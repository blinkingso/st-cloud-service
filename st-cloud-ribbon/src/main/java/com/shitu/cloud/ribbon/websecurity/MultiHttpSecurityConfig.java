//package com.shitu.cloud.ribbon.websecurity;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
///**
// * Web Security Configuration
// *
// * @author andrew
// * @date 2019/07/24
// */
//@EnableWebSecurity
//public class MultiHttpSecurityConfig {
//
//    @Configuration
//    @Order(1)
//    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.csrf().disable()
//                    .authorizeRequests().anyRequest().permitAll()
//                    .and()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
//        }
//    }
//
//
////    @Configuration
////    @EnableWebMvc
////    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////
////        @Override
////        protected void configure(HttpSecurity http) throws Exception {
////            http.csrf().disable()
////                    .authorizeRequests().antMatchers("/page/login").permitAll()
////                    .anyRequest().authenticated()
////                    .and()
////                    .formLogin()
////                    .loginProcessingUrl("/login")
////                    .loginPage("/page/login")
////                    .and()
////                    .logout()
////                    .invalidateHttpSession(true)
////                    .clearAuthentication(true)
////                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                    .logoutSuccessUrl("/page/logout-success").permitAll()
////                    .and()
////                    .httpBasic();
////        }
////
////        @Override
////        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
////            //provider.setUserDetailsService(new InMemoryUserDetailsManager(User.builder().username("admin").password("12345").authorities("USER", "ADMIN").build()));
////            provider.setUserDetailsService(myUserDetailsService());
//////        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
////            provider.setPasswordEncoder(new BCryptPasswordEncoder());
////            auth.authenticationProvider(provider);
////        }
////
////        @Bean
////        public MyUserDetailsService myUserDetailsService() {
////            return new MyUserDetailsService();
////        }
////
////        private final class MyUserDetailsService implements UserDetailsService {
////
////            @Override
////            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////                if ("admin".equals(username)) {
////                    return new UserDetails() {
////                        private static final long serialVersionUID = -2862807901193947474L;
////
////                        @Override
////                        public Collection<? extends GrantedAuthority> getAuthorities() {
////                            return Stream.of(new SimpleGrantedAuthority("USER"),
////                                    new SimpleGrantedAuthority("ADMIN")).collect(Collectors.toList());
////                        }
////
////                        @Override
////                        public String getPassword() {
////                            return "$2a$12$roZoWIZ3KLgyED8d.G/Y9OdMittH21XqRH3QkFqnnopRTTMh1GYau";
////                        }
////
////                        @Override
////                        public String getUsername() {
////                            return "admin";
////                        }
////
////                        @Override
////                        public boolean isAccountNonExpired() {
////                            return true;
////                        }
////
////                        @Override
////                        public boolean isAccountNonLocked() {
////                            return true;
////                        }
////
////                        @Override
////                        public boolean isCredentialsNonExpired() {
////                            return true;
////                        }
////
////                        @Override
////                        public boolean isEnabled() {
////                            return true;
////                        }
////                    };
////                }
////
////                throw new UsernameNotFoundException("username not found");
////            }
////        }
////    }
//
//}
