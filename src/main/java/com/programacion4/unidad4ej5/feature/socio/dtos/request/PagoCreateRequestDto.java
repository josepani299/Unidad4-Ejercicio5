package com.programacion4.unidad4ej5.feature.socio.dtos.request;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class PagoCreateRequestDto {
    
    // El monto debe ser minimo de 1000 y deberia tener dos digitos
    @NotNull(message = "El monto es requerido")
    @DecimalMin(value = "1000.00", inclusive = true,
        message = "El monto debe ser mayor o igual a 1000.00")
    @Digits(integer = 10, fraction = 2,
        message = "El monto debe tener como máximo dos decimales")
    private BigDecimal monto;

    // Ahora deberiamos el crear el codigo de transacicon

    @NotBlank(message="El codigo de transaccion es requerido")
    @Pattern(regexp="^PAY-[A-Z0-9]{4}-[A-Z0-9]{4}$",
    message="El codigo debe seguir el formato PAY-XXXX-XXXX")
    private String codigoTransaccion;
    
    // Ahrora deberiamos el usar future y el localDate
    @NotNull(message="La fecha es requerida")
    @Future(message="La fecha debe ser posterior a la actual")
    private LocalDate fechaVencimiento;

    @NotBlank(message = "El tipo de pago es requerido")
    @Pattern(
        regexp = "^(EFECTIVO|DEBITO|CREDITO|TRANSFERENCIA)$",
        message = "El tipo de pago debe ser: EFECTIVO, DEBITO, CREDITO o TRANSFERENCIA"
    )
    private String tipoPago;
}