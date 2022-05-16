package cat.itb.jugadorsspring.model.serveis;
import cat.itb.jugadorsspring.model.entitats.Player;
import cat.itb.jugadorsspring.model.repositoris.RepositoriPlayers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiPlayers {
    private final RepositoriPlayers repositoriPlayers;

    public List<Player> llistarPlayer(String id) {
        return repositoriPlayers.findAll();
    }
    public Player consultarPlayer(String id) {
        return repositoriPlayers.findById(id).orElse(null);
    }

    public List<Player> llistarPlayersPerEquip(String equip) {
        return repositoriPlayers.findByEquip(equip);
    }

    public List<Player> llistatPerPlayerRetirat(String equip) {
        return repositoriPlayers.findByEquip(equip);
    }

    public long comptarPerEquip(String equip) {return repositoriPlayers.countByEquip(equip);}

    public Player afegirPlayer(Player it) {
        return repositoriPlayers.save(it);
    }

    public Player eliminarPlayer(String id) {
        Player res=repositoriPlayers.findById(id).orElse(null);
        if(res!=null) repositoriPlayers.deleteById(id);
        return res;
    }

    public Player modificarPlayer(Player mod) {
        Player aux=null;
        if(repositoriPlayers.existsById(mod.getIdPlayer())) aux=repositoriPlayers.save(mod);
        return aux;
    }

    public List<Player> consultarPlayers() {
        return repositoriPlayers.findAll();
    }
}