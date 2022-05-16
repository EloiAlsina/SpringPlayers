package cat.itb.jugadorsspring.model.repositoris;

import cat.itb.jugadorsspring.model.entitats.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoriPlayers extends JpaRepository<Player, String> {

    List<Player> findByEquip(String e);

    long countByEquip(String equip);
}
