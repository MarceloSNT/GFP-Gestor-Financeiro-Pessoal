package projeto.gfp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBSTATUS")
public class StatusModel {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDSTATUS")
    private long cdStatus;

    @Column(name = "NMSTATUS")
    private String nmStatus;
}
