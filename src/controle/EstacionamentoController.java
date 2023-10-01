package controle;

import java.time.LocalDateTime;
import java.util.List;

import negocio.Movimentacao;

/*
 * Coordena todos os fluxos dos casos de uso do sistema
 * 
 * @author Flavio de Andrade
 */


public class EstacionamentoController {

    /**
     * A partir dos dados do veiculo informado pelo operador realiza o fluxo 
     * entrada do veículo no estacionaento registrando a movumnentação
     * gerada
     *
     * @param placa
     * @param marca
     * @param cor
     * @param modelo
     */

    public void processarEntrada(String placa, String marca,String cor,String modelo){
        // verificar se o estacionamento está lotado
        // verificar o padr]ao da placa
    }
    /**
     * A partir de uma placa de veículo informada. realiza todo o fluxo de
     * saída de veículo do estacionamento
     * 
     * @param placa Placa do veículo que estiver saindo
     * @return
     */

    public Movimentacao processarSaida(String placa){
        //TODO implementar
        return null;

    }
    public List<Movimentacao> emitirRelatorio(LocalDateTime data){
        //TODO implementar
        return null;
    }
}
