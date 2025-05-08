package api.specification;

import org.springframework.data.jpa.domain.Specification;

import api.entity.Usuario;

public class UsuarioSpecification {

    public static Specification<Usuario> nomeContem(String nome) {
        return (root, query, builder) ->
            nome == null ? null : builder.like(builder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }

    public static Specification<Usuario> emailContem(String email) {
        return (root, query, builder) ->
            email == null ? null : builder.like(builder.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    }

    public static Specification<Usuario> statusIgual(String status) {
        return (root, query, builder) ->
            status == null ? null : builder.equal(root.get("status"), status);
    }

    public static Specification<Usuario> perfilIgual(String perfilNome) {
        return (root, query, builder) ->
            perfilNome == null ? null : builder.equal(root.get("perfil").get("nome"), perfilNome);
    }
}
