package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user")
    private User user;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "comuna")
    private String comuna;
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "descripcion")
    private String desProblema;
    @Column(name = "tematica")
    private List<String> tematica;
    @Column(name = "fecha")
    private Date fecha;

    private Long userId;
}
