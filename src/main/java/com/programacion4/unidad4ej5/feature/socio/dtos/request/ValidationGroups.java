package com.programacion4.unidad4ej5.feature.socio.dtos.request;

// Esta interfaz define los grupos de validación que se usarán con @Validated.
// Los grupos permiten aplicar distintas restricciones según la operación
// (creación o actualización), sin necesidad de duplicar DTOs.
public interface ValidationGroups {

    // Grupo que se activa al CREAR un recurso.
    // Las restricciones marcadas con groups = Create.class solo se validan en ese contexto.
    interface Create {}

    // Grupo que se activa al ACTUALIZAR un recurso.
    // Las restricciones marcadas con groups = Update.class solo se validan en ese contexto.
    interface Update {}
}
