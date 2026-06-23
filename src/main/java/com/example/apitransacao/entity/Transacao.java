package com.example.apitransacao.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Transacao {
    Double valor;
    OffsetDateTime dataHora;
}
