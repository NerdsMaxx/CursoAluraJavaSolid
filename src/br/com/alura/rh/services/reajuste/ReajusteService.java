package br.com.alura.rh.services.reajuste;

import br.com.alura.rh.arguments.ValidacaoReajusteArgs;
import br.com.alura.rh.interfaces.ValidacaoReajuste;
import br.com.alura.rh.models.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {
    
    private List<ValidacaoReajuste> validacoes;
    
    public ReajusteService( List<ValidacaoReajuste> validacoes ) {
        this.validacoes = validacoes;
    }
    
    public void reajustarSalarioDoFuncionario( Funcionario funcionario,
                                               BigDecimal aumento ) {
        this.validacoes.forEach( v -> v.validar( new ValidacaoReajusteArgs( funcionario, aumento ) ) );
        
        BigDecimal salarioReajustado = funcionario.getDadosPessoais()
                                                  .getSalario()
                                                  .add( aumento );
        
        funcionario.atualizarSalario( salarioReajustado );
    }
    
}