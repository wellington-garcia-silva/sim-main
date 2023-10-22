package io.sim3;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder


public class Cheque {
    private Date data;
    private Integer numeroCheque;
    private String nome;
    private BigDecimal valor;
    private String status;
    private Integer qtdeParcelas;
    private String formulaTotal;
}
