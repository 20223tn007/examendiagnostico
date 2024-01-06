package com.example.diagnosticoEddie.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClientesDto {
    private Integer idcliente;
    private String apellido;
    private String curp;
    private String nombre;
    private String fecha;
}
