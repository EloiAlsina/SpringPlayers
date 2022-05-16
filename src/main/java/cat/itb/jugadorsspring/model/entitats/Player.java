package cat.itb.jugadorsspring.model.entitats;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Player {

    @Id
    private String idPlayer;
    private String nom;
    private String equip;
    private String rol;
}