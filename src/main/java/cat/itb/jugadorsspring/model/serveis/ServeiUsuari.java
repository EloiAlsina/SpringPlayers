package cat.itb.jugadorsspring.model.serveis;

import cat.itb.jugadorsspring.model.entitats.Usuari;
import cat.itb.jugadorsspring.model.repositoris.RepositoriUsuari;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiUsuari {

    private final RepositoriUsuari repositoriUsuari;
    private final PasswordEncoder xifrat;

    public Usuari consultarPerUsername(String username) {
        return repositoriUsuari.findByUsername(username).orElse(null);
    }

    public Usuari crearNouUsuari(Usuari nouUsuari) {
        nouUsuari.setPassword(xifrat.encode(nouUsuari.getPassword()));
        repositoriUsuari.save(nouUsuari);
        return nouUsuari;
    }

    public List<Usuari> llistarUsuaris(){
        return repositoriUsuari.findAll();
    }

}