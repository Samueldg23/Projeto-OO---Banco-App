package com.unisales.service;

import java.util.List;

import com.unisales.domain.ContaBancaria;
import com.unisales.domain.ContaCorrente;
import com.unisales.domain.ContaPoupanca;

public class OperacaoService {

    public void aplicarCicloMensal(List<ContaBancaria> contas) {
        for (ContaBancaria c : contas) {
            if (!c.isAtiva()) continue;

            if (c instanceof ContaPoupanca cp) {
                cp.depositar(cp.calcularRendimento().doubleValue());
            }

            if (c instanceof ContaCorrente cc) {
                cc.taxarConta();
            }
        }
    }

}
