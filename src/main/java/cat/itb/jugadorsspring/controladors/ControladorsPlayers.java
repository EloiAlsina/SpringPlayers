package cat.itb.jugadorsspring.controladors;

import cat.itb.jugadorsspring.model.entitats.Player;
import cat.itb.jugadorsspring.model.serveis.ServeiPlayers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorsPlayers {

    private final ServeiPlayers serveiPlayers;

    @CrossOrigin(origins = "http://localhost:8080")

    @GetMapping("/players")
    public List<Player> llistarPlayer(@RequestParam() String id)
    {
        return serveiPlayers.llistarPlayer(id);
    }
    @GetMapping("/players/{id}")
    public Player consultarPlayer(@PathVariable String id)
    {
        return serveiPlayers.consultarPlayer(id);
    }

    @GetMapping("/players/equip/{equip}")
    public List<Player>llistarPlayersPerEquip(@PathVariable String equip){return serveiPlayers.llistarPlayersPerEquip(equip);}
    @GetMapping("/players/comptar/{equip}")
    public long comptarPerRol(@PathVariable String equip){
        return serveiPlayers.comptarPerEquip(equip);
    }


    @PostMapping("/players")
    public Player crearPlayer(@RequestBody Player it){
        return serveiPlayers.afegirPlayer(it);
    }

    @DeleteMapping("/players/{id}")
    public Player eliminarPlayer(@PathVariable String id){
        return serveiPlayers.eliminarPlayer(id);
    }

    //per modificar un usuari existent
    @PutMapping("/players")
    public Player modificarPlayer(@RequestBody Player mod){
        return serveiPlayers.modificarPlayer(mod);
    }

}