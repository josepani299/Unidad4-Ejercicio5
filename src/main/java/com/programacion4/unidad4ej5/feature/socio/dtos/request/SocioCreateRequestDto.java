package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data  // Genera automáticamente getters, setters,
// toString(), equals() y hashCode() para todos los atributos de la clase.
@NoArgsConstructor // Genera un constructor sin argumentos (constructor vacío).
@AllArgsConstructor // Genera un constructor con todos los atributos de la clase como parámetros.

public class SocioCreateRequestDto {
    
    
    @NotBlank(message = "El nombre es requerido")  // Notblank se usa para validar String
    private String nombre;

    @NotBlank( message = "El apellido es requerido")
    private String apellido;


    // El mail deberia tener dos restricciones, que no sea null, y que tenga formato email.
    //podemos poner dos restriciiones seguidas sobre el mismo campo.
    @NotBlank(message = "El mail es requerido")
    @Email(message = "El mail debe tener un formato valido")
    private String email;

    // Ahora deberiamos poner las restricciones del DNI
    // Pattern nos permite verificar que un valor tipo string cumple con algun patron definido
    // En este caso deberia cumplir que sean digitos y que tengas una longitud de 8 digitos

    @NotBlank(message="El DNI es requerido")
    @Pattern( regexp = "d{8}", message= "El DNI debe tener exactamente 8 digitos numericos")
    private String dni;


    @NotNull(message= "La fecha  de nacimiento es requerida")
    // Past \\
    @Past(message="La fecha de nacimiento  deberia ser una fecha anterior ")
    private LocalDate fechaNacimiento;
    
    // Ahora deberia poner las restricicones del numero de telefono

    @NotBlank(message="El numero es requerido")
    @Pattern(regexp = "\\+549\\d{8,10}", 
    message = "El número debe tener formato internacional argentino (+549...)")
    private String numero;


}
