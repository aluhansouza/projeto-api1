package api.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditorAwareImpl")
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Aqui você pode obter o usuário logado. Exemplo:
        // return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
        
        // Para testes simples, vou retornar um nome fixo, por exemplo:
        return Optional.of("admin");
    }
}