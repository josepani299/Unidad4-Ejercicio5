package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data  // Genera automáticamente getters, setters,
// toString(), equals() y hashCode() para todos los atributos de la clase.
@NoArgsConstructor // Genera un constructor sin argumentos (constructor vacío).
@AllArgsConstructor // Genera un constructor con todos los atributos de la clase como parámetros.


public class SocioUpdateRequestDto {

    // El ID del socio:
    // - En la ACTUALIZACIÓN debe ser obligatorio (no puede ser null).
    // - En la CREACIÓN debe ser nulo (no se debe enviar).
    // Usando groups, cada restricción sabe en qué contexto aplica.

    @NotNull(
        groups = ValidationGroups.Update.class,
        message = "El ID es obligatorio para la actualización"
    )
    @Null(
        groups = ValidationGroups.Create.class,
        message = "El ID debe ser nulo al crear un socio"
    )
    private Long id;

    // La URL de la foto de perfil es opcional.
    // Pero si se proporciona, debe tener un formato de URL válido.
    
    @URL(message = "La foto debe ser una URL válida")
    private String fotoPerfil;

    // El alias también es opcional.
    // Pero si se informa, debe:
    // - Tener entre 3 y 15 caracteres (validado con @Size).
    // - No contener espacios (validado con @Pattern).

    @Size(
        min = 3, max = 15,
        message = "El alias debe tener entre 3 y 15 caracteres"
    )
    // Pattern nos permite verificar que un valor tipo string cumple con algún patrón definido.
    // En este caso verificamos que no haya ningún espacio en blanco en el alias.
    @Pattern(
        regexp = "^\\S+$",
        message = "El alias no debe contener espacios"
    )
    private String alias;

}
