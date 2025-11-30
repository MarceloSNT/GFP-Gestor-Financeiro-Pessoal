package projeto.gfp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBROLE")
public class RoleModel {
    @Column(name = "CDROLE")
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdRole;

    @Column(name = "NMROLE")
    private String nmRole;
}
