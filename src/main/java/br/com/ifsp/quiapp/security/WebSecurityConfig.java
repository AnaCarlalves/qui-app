package br.com.ifsp.quiapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().requiresChannel(
                channel -> channel.anyRequest().requiresSecure())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authorize -> authorize
                            .requestMatchers(HttpMethod.POST, "/api/quiapp/cadastro/cadastroProfessor").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/quiapp/usuario/criar").permitAll())
                .authorizeHttpRequests(
                        authorize -> authorize
                            .requestMatchers(HttpMethod.DELETE, "/api/quiapp/jogada/deletar/{idJogada}").authenticated()
                            .requestMatchers(HttpMethod.DELETE, "/app/quiapp/pergunta/deletarPergunta/{codigo}").authenticated()
                            .requestMatchers(HttpMethod.DELETE, "/api/quiapp/delete/deleteCadastroUsuario").authenticated()
                            .requestMatchers(HttpMethod.DELETE, "/api/quiapp/deletarHistorico/{id}").authenticated()
                            .requestMatchers(HttpMethod.GET, "/app/quiapp/recupera/recuperaTabela").authenticated()
                            .requestMatchers(HttpMethod.GET, "/app/quiapp/pergunta/{codigo}").authenticated()
                            .requestMatchers(HttpMethod.GET, "/api/quiapp/listaDeAlunosCadastrados").authenticated()
                            .requestMatchers(HttpMethod.GET, "/api/quiapp/RecuperarUsuario/{id}").authenticated()
                            .requestMatchers(HttpMethod.POST, "/app/quiapp/perguntas/inserir").authenticated()
                            .requestMatchers(HttpMethod.POST, "/api/quiapp/adicionarJogada/{id}").authenticated());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("usuario")
                .password("senha")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}