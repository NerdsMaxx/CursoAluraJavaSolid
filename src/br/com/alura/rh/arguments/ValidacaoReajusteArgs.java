package br.com.alura.rh.arguments;

import br.com.alura.rh.models.Funcionario;

import java.math.BigDecimal;

public class ValidacaoReajusteArgs {
    
    private Funcionario funcionario;
    private BigDecimal aumento;
    
    public ValidacaoReajusteArgs( Funcionario funcionario ) {
        this.funcionario = funcionario;
    }
    
    public ValidacaoReajusteArgs( Funcionario funcionario, BigDecimal aumento ) {
        this.funcionario = funcionario;
        this.aumento = aumento;
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public BigDecimal getAumento() {
        return aumento;
    }
}