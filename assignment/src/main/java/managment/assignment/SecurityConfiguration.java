package managment.assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests((myAuth)->myAuth.requestMatchers("/admin/**")
                .hasRole("ADMIN")
                .requestMatchers("/profileCreation").hasRole("USER")
                .requestMatchers("/createProfile").hasRole("USER")
                .requestMatchers("/jobs").hasRole("USER")
                .requestMatchers("/apply/{jobId}").hasRole("USER")
                .requestMatchers("/uploadResume").hasRole("USER")
                .requestMatchers("/uploadResumeForm").hasRole("USER")
                .requestMatchers("/resumeApi").permitAll()
                .requestMatchers("/public/**")
                .permitAll().anyRequest()
                .authenticated()).formLogin();

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService usd(){
        return new MyUserDetailService();
    }
}
