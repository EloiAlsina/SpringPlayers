package cat.itb.jugadorsspring.controladors;

import cat.itb.jugadorsspring.model.entitats.Player;
import cat.itb.jugadorsspring.model.serveis.ServeiPlayers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ResponseEntityController {

    private final ServeiPlayers serveiPlayers;

    @GetMapping("/player/{id}")
    public ResponseEntity<?> consultarPlayer(@PathVariable String id) {
        Player res = serveiPlayers.consultarPlayer(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @PostMapping("/player")
    public ResponseEntity<?> crearPlayer(@RequestBody Player nou){
        Player res=serveiPlayers.afegirPlayer(nou);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/player")
    public ResponseEntity<?>modificarPlayer(Player mod){
        Player res = serveiPlayers.modificarPlayer(mod);
        if(res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }
    @DeleteMapping("/player/{id}")
    public ResponseEntity<?>eliminarPlayer(@PathVariable String id) {
        Player res = serveiPlayers.eliminarPlayer(id);
        if (res == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(res);
    }

}