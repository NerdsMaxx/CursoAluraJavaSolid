package br.com.alura.rh.interfaces;

import br.com.alura.rh.arguments.ValidacaoReajusteArgs;
import br.com.alura.rh.models.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {
    public void validar( ValidacaoReajusteArgs args );
}