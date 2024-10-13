package modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resenaID; // Identificador único
    private LocalDateTime fechaPublicacion;
    private String restaurant;
    private String categoria;
    private String contenido;

    private int contadorLikes;   // Contador de Likes
    private int contadorDislike; // Contador de Dislikes

    @ManyToOne
    @JoinColumn(name = "foro_id")
    private Foro foro;

    @OneToMany(mappedBy = "resena", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Comentario> listaComentarios = new ArrayList<>();

    // Constructor sin argumentos
    public Resena() {
        this.resenaID = UUID.randomUUID().toString(); // Genera un resenaID único y aleatorio
    }

    // Getters y Setters

    public String getResenaID() {
        return resenaID;
    }

    public void setResenaID(String resenaID) {
        this.resenaID = resenaID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getContadorLikes() {
        return contadorLikes;
    }

    public void setContadorLikes(int contadorLikes) {
        this.contadorLikes = contadorLikes;
    }

    public int getContadorDislike() {
        return contadorDislike;
    }

    public void setContadorDislike(int contadorDislike) {
        this.contadorDislike = contadorDislike;
    }

    public Foro getForo() {
        return foro;
    }

    public void setForo(Foro foro) {
        this.foro = foro;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    // Métodos para actualizar los contadores de Likes y Dislikes
    public void aumentarLikes() {
        this.contadorLikes++;
    }

    public void disminuirLikes() {
        if (this.contadorLikes > 0) {
            this.contadorLikes--;
        }
    }

    public void aumentarDislikes() {
        this.contadorDislike++;
    }

    public void disminuirDislikes() {
        if (this.contadorDislike > 0) {
            this.contadorDislike--;
        }
    }
}
