package br.com.alura.rh.services.reajuste;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.arguments.ValidacaoReajusteArgs;
import br.com.alura.rh.interfaces.ValidacaoReajuste;
import br.com.alura.rh.models.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustesComAumento implements ValidacaoReajuste {
    
    public void validar( ValidacaoReajusteArgs args ) {
        Funcionario funcionario = args.getFuncionario();
        
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDoUltimoReajuste = ChronoUnit.MONTHS.between( dataUltimoReajuste, dataAtual );
    
        if(mesesDoUltimoReajuste < 6){
            throw new ValidacaoException( "Intervalo entre reajustes deve ser no mínimo de 6 meses." );
        }
    
    }
}