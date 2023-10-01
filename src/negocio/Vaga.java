package negocio;
/**
 * Representa as informações relativas à vga do estacionamento ou status de ocupação
 * 
 * 
 * 
 */
public class Vaga {
    public static int totalVagas = 50;
    private static int vagasOcupadas = 0; //usado para todas instancias

    private Vaga(){} // Metodo contrutor.

    /**  
    * Verificar a existencia de alguma vaga livre no estacionamento
    *True se houver vagas ou false caso contrário
    */
    public static boolean temVagaLivre(){
        //TODO implementar este método.
        return false;
    }
    

    /**
     * Busca  o status atual da vaga do estacionamento
     */
    public static void inicializarOcupadas(){
        //TODO implementar

    }
    /**
     * Retorna o numero total de vagas ocupadas
     * @return numero total de vagas num determinado instante
     */
    public static int ocupadas(){
        return Vaga.vagasOcupadas;
    }
    
      /**
     * Retorna o numero total de vagas livres
     * @return numero total de vagas num determinado instante
     */
    public static int livres(){
        return totalVagas - Vaga.vagasOcupadas;
    }

    /**
     * Atualiza o numero total de vagas após a entrada do veículo.
     */
    public static void entrou(){
        Vaga.vagasOcupadas ++;
    }


}
