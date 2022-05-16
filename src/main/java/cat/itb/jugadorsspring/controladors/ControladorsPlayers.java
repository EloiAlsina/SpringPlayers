package cat.itb.jugadorsspring.controladors;

import cat.itb.jugadorsspring.model.entitats.Player;
import cat.itb.jugadorsspring.model.serveis.ServeiPlayers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorsPlayers {

    private final ServeiPlayers serveiPlayers;

    @GetMapping("/players/{id}")
    public ResponseEntity<?> consultarPlayer(@PathVariable String id) {
        Player res = serveiPlayers.consultarPlayer(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @GetMapping("/players/")
    public ResponseEntity<?> consultarPlayers() {
        List<Player> res = serveiPlayers.consultarPlayers();
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @GetMapping("/players/equip/{equip}")
    public List<Player>llistarPlayersPerEquip(@PathVariable String equip){return serveiPlayers.llistarPlayersPerEquip(equip);
    }

    @GetMapping("/players/comptar/{equip}")
    public long comptarPerRol(@PathVariable String equip){
        return serveiPlayers.comptarPerEquip(equip);
    }

    @PostMapping("/players")
    public ResponseEntity<?> crearPlayer(@RequestBody Player nou){
        Player res=serveiPlayers.afegirPlayer(nou);
        return new ResponseEntity<Player>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<?>eliminarPlayer(@PathVariable String id) {
        Player res = serveiPlayers.eliminarPlayer(id);
        if (res == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(res);
    }

    @PutMapping("/players")
    public ResponseEntity<?>modificarPlayer(Player mod){
        Player res = serveiPlayers.modificarPlayer(mod);
        if(res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

}