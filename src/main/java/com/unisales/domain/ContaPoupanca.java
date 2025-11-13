package com.unisales.domain;

import java.math.BigDecimal;
import com.unisales.interfaces.Rendivel;

public class ContaPoupanca extends ContaBancaria implements Rendivel {

    private double taxaRendimentoMensal;
    private int diaAniversario;

    public ContaPoupanca() {
        super();
        setTipo(TipoConta.POUPANCA);
        this.taxaRendimentoMensal = 0.006;
        this.diaAniversario = 1;
    }

    public ContaPoupanca(String numero, Cliente cliente, double saldoInicial,
                         double taxaRendimentoMensal, int diaAniversario) {
        super(numero, TipoConta.POUPANCA, cliente);
        setSaldo(saldoInicial);
        this.taxaRendimentoMensal = Math.max(0.0, taxaRendimentoMensal);
        this.diaAniversario = (diaAniversario < 1 || diaAniversario > 31) ? 1 : diaAniversario;
    }

    @Override
    public BigDecimal calcularRendimento() {
        return BigDecimal.valueOf(getSaldo() * taxaRendimentoMensal);
    }

    public void render() {
        depositar(calcularRendimento().doubleValue());
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== Conta Poupança ===");
        System.out.println("Número : " + getNumero());
        System.out.println("Cliente: " + (getCliente() != null ? getCliente().getNome() : "-"));
        System.out.println("Saldo  : R$ " + getSaldo());
        System.out.println("Ativa  : " + (isAtiva() ? "Sim" : "Não"));
        System.out.println("Taxa Rendimento Mensal: " + taxaRendimentoMensal);
        System.out.println("Dia de Aniversário    : " + diaAniversario);
    }

    public double getTaxaRendimentoMensal() { return taxaRendimentoMensal; }
    public void setTaxaRendimentoMensal(double taxaRendimentoMensal) { this.taxaRendimentoMensal = Math.max(0.0, taxaRendimentoMensal); }

    public int getDiaAniversario() { return diaAniversario; }
    public void setDiaAniversario(int diaAniversario) { this.diaAniversario = (diaAniversario < 1 || diaAniversario > 31) ? 1 : diaAniversario; }
}
