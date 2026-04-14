package com.programacion4.unidad4ej5.feature.socio.dtos.request;


import java.util.List;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor 
@AllArgsConstructor
public class PlanCreateRequestDto {
    
    // Crear el atributo Objetivo
    @NotBlank(message="El objetivo es requerido")
    // Se usa Size para indicar el tamaño
    @Size(min=10,max=200,message="El objetivo debe tener entre 10 y 200 caracteres")
    private String objetivo;

    // Crear la frecuencia semanal, teniendo en cunta que deberia tener un nuemro de
    // entre 1 y 7.

    @NotBlank(message="La frecuencia semanal es requerido")
    @Min(1) // Esto me permite establecer el minimo
    @Max(7) // Esto me permite establecer el maximo
    private Integer frecuenciaSemanal;

    @NotNull(message="El peso inicial es requerido") // recordar que para otra cosa que no
    // sea string se usa NotNull
    // Hay anotaciones exclusivas para los numeros decimales para identificar el minimo o max
    @DecimalMin(value ="30.0", message="El peso minimo es 30.0")
    @DecimalMax(value ="250.0", message="El peso maximo es 250.0")
    private Double pesoinicial;

    //Ahora la altura, se deberia poder hacer de manera similar a la del peso.

    @NotNull(message="La altura es requerida")
    @DecimalMin(value="1.0",message="La altura minima es  1.0")
    @DecimalMax(value="2.5", message="La altura maxima es 2.5")
    private Double altura;


    // ahora deberiamos crear el atributo de lista de ejercicios 
    @NotEmpty(message="La lista de ejercicio no puede estar vacia")
    @Size(min=3,message="La lista de ejercicio debe tener al menos 3 ejercicios")
    private List<String> listaejercicio;

}
