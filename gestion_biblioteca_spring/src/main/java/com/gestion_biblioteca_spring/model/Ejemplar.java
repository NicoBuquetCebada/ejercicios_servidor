package com.gestion_biblioteca_spring.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Ejemplar {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "isbn", nullable = false)
	@JsonBackReference("ejemplar-managed")
    @JsonIgnore
    private Libro isbn;

    @Column(name = "estado")
    @Pattern(regexp = "^(DISPONIBLE|PRESTADO|DAÑADO)$")
    private String estado;

	@OneToMany(mappedBy = "ejemplar")
	@JsonManagedReference("ejemplar-prestamo-managed")
	private Set<Prestamo> prestamos = new LinkedHashSet<>();

    @JsonProperty("isbn")
    public String getIsbnString() {
        return  isbn.getIsbn();
    }

    public Set<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Set<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Libro getIsbn() {
        return isbn;
    }

    public void setIsbn(Libro isbn) {
        this.isbn = isbn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}