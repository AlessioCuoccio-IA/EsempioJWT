package EsempioJWT.Service;

import EsempioJWT.domain.Role;
import EsempioJWT.domain.Utente;

import java.util.List;

public interface ServiceUtente {
    Utente saveUtente(Utente utente);
    Role saveRole(Role role);
    void addRoleToUtente(String username, String roleName);
    Utente getUtente(String username);
    List<Utente> getUtenti();
}
