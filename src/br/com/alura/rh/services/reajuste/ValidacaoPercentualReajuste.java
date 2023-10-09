package br.com.alura.rh.services.reajuste;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.arguments.ValidacaoReajusteArgs;
import br.com.alura.rh.interfaces.ValidacaoReajuste;
import br.com.alura.rh.models.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {
    
    public void validar( ValidacaoReajusteArgs args ) {
        Funcionario funcionario = args.getFuncionario();
        BigDecimal aumento = args.getAumento();
        
        BigDecimal salarioAtual = funcionario.getDadosPessoais()
                                             .getSalario();
        
        BigDecimal percentualReajuste = aumento.divide( salarioAtual,
                                                        RoundingMode.HALF_UP );
        
        if ( percentualReajuste.compareTo( new BigDecimal( "0.4" ) ) > 0 ) {
            throw new ValidacaoException( "Reajuste não pode ser superior a 40% do salário." );
        }
    }
}