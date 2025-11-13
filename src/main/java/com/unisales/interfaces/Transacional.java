package com.unisales.interfaces;

import com.unisales.domain.ContaBancaria;

public interface Transacional {
    boolean depositar(double valor);
    boolean sacar(double valor);
    boolean transferir(ContaBancaria destino, double valor);
}
