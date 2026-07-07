package herozero.project.community.logic;
import herozero.project.community.view.ConsoleStyleView;
import herozero.project.community.model.FichaPersonagem;

/**
 * Classe onde ocorre o cálculo da habilidade básica e o cálculo de habilidade 
 * total que serve para verificar se o valor aproximado de habilidade basica
 * calculada está correta.
 * 
 * @author André Lauterjung
 * 
 */
public class CalculoFinalHabilidadeBasica
{
    /* Fórmula: habilidadeBasica + bonusTotal = habilidadeTotal - pontosHailidadeEquipamentosPet
        
    Exemplo para calcular a força básica do personagem:
        
    1º Passo: habilidadeTotalForca - pontosHailidadeEquipamentosPetForca
    2º Passo: Somar todos os bônus acrescentados na força básica
    3º Passo: habilidadeBasica = resultadoSubForcaTotEquipPet / (1+(bonusTotal/100)) */
    
    public void calculoFinalHabilidadeBasica(HabilidadeTotalLogic habilidadeTotal, FichaPersonagem fichaPersonagem)
    {
        /* A variável pergunta pega a mesma resposta do nome da habilidade total
        que o usuário digitou anteriormente e aproveita para ser usada nesta classe
        seguindo uma ordem para o cálculo das habilidades. 
        
        Ou seja, se anteriormente ele digitou a força total, em seguida ele
        vai digitar os pontos de força que os equipamentos e pet acrescentam à habilidade. */
        String pergunta = habilidadeTotal.getRespHabTotalText();
        
        ConsoleStyleView styleView = new ConsoleStyleView();
        
        switch(pergunta.toLowerCase())
        {
            case "forca":
                // Pega o bônus total incrementado na força e armazena na variável.
                double bonusTotalForca = fichaPersonagem.getBonusTotal().getBonusTotalForca();
        
                // Pega a força total e armazena na variável.
                int forcaTotalPersonagem = fichaPersonagem.getHabilidadeTotal().getForcaTotal();
                
                // Pega o valor total que os equipamentos e o pet acrescentam na força.
                int totalForcaEquipamentosPet = fichaPersonagem.getAtributosEquipPet().getForcaTotalEquipamentosPet();
         
                // Subtrai o valor total que os equipamentos e pet acrescentam na força total.
                int resultadoSubForcaTotEquipPet = forcaTotalPersonagem - totalForcaEquipamentosPet;
        
                // Calcula a força básica aproximada e armazena na variável.
                double habilidadeBasicaForca = resultadoSubForcaTotEquipPet / (1+(bonusTotalForca/100)); 
            
                // Adiciona o valor da força básica na classe HabilidadeBasica.
                fichaPersonagem.getHabilidadeBasica().setForcaBasic(habilidadeBasicaForca);
                
                styleView.linhaVisualDivisoriaIg();
                System.out.println("BÔNUS TOTAL QUE O PERSONAGEM RECEBE NA FORÇA: "+bonusTotalForca+"%");
                styleView.linhaVisualDivisoriaIg();
                System.out.println("TOTAL DE PONTOS DE HABILIDADE NA FORÇA: "+forcaTotalPersonagem);
                styleView.linhaVisualDivisoriaIg();
                System.out.println("TOTAL DE PONTOS QUE OS OBJETOS ACRESCENTAM À FORÇA: "+totalForcaEquipamentosPet);
                styleView.linhaVisualDivisoriaIg();
                System.out.printf("VALOR APROXIMADO DE FORÇA BÁSICA DO PERSONAGEM: %.1f PONTOS.\n", habilidadeBasicaForca);
                styleView.linhaVisualDivisoriaIg();
                
                /* Retornar ao usuário o valor da habilidade total para que ele consiga
                verificar se o cálculo de habilidade básica funcionou corretamente. */
                double somaHabTotBonTot = habilidadeBasicaForca * (1+(bonusTotalForca/100));
                double habilidadeTotalAprox = somaHabTotBonTot + totalForcaEquipamentosPet;
        
                System.out.printf("RETORNO HABILIDADE TOTAL NA FORÇA COM BASE NOS DADOS DIGITADOS PELO USUÁRIO: %.1f\n", habilidadeTotalAprox);
                System.out.printf("ATENÇÃO: caso o valor seja próximo ou exato ao total de habilidade do personagem, \nsignifica que a habilidade básica foi calculada corretamente!\n");
                styleView.linhaVisualDivisoriaIg();
                break;
            
            case "vigor":
                // Pega o bônus total incrementado no vigor e armazena na variável.
                double bonusTotalVigor = fichaPersonagem.getBonusTotal().getBonusTotalVigor();
        
                // Pega o vigor total e armazena na variável.
                int vigorTotalPersonagem = fichaPersonagem.getHabilidadeTotal().getVigorTotal();
                
                // Pega o valor total que os equipamentos e o pet acrescentam no vigor.
                int totalVigorEquipamentosPet = fichaPersonagem.getAtributosEquipPet().getVigorTotalEquipamentosPet();
              
                // Subtrai o valor total que os equipamentos e pet acrescentam no vigor total.
                int resultadoSubVigorTotEquipPet = vigorTotalPersonagem - totalVigorEquipamentosPet;
        
                // Calcula o vigor básico aproximado e armazena na variável.
                double habilidadeBasicaVigor = resultadoSubVigorTotEquipPet / (1+(bonusTotalVigor/100));
                
                // Adiciona o valor do vigor básico na classe HabilidadeBasica.
                fichaPersonagem.getHabilidadeBasica().setVigorBasic(habilidadeBasicaVigor);
                
                styleView.linhaVisualDivisoriaIg();
                System.out.println("BÔNUS TOTAL QUE O PERSONAGEM RECEBE NO VIGOR: "+bonusTotalVigor+"%");
                styleView.linhaVisualDivisoriaIg();
                System.out.println("TOTAL DE PONTOS DE HABILIDADE NO VIGOR: "+vigorTotalPersonagem);
                styleView.linhaVisualDivisoriaIg();
                System.out.println("TOTAL DE PONTOS QUE OS OBJETOS ACRESCENTAM AO VIGOR: "+totalVigorEquipamentosPet);
                styleView.linhaVisualDivisoriaIg();
                System.out.printf("VALOR APROXIMADO DE VIGOR BÁSICO DO PERSONAGEM: %.1f PONTOS.\n", habilidadeBasicaVigor);
                styleView.linhaVisualDivisoriaIg();
                /* Retornar ao usuário o valor da habilidade total para que ele consiga
                verificar se o cálculo de habilidade básica funcionou corretamente. */
                double somaHabTotBonTotV = habilidadeBasicaVigor * (1+(bonusTotalVigor/100));
                double habilidadeTotalAproxV = somaHabTotBonTotV + totalVigorEquipamentosPet;
                
                
                System.out.printf("RETORNO HABILIDADE TOTAL NO VIGOR COM BASE NOS DADOS DIGITADOS PELO USUÁRIO: %.1f\n", habilidadeTotalAproxV);
                System.out.printf("ATENÇÃO: caso o valor seja próximo ou exato ao total de habilidade do personagem, \nsignifica que a habilidade básica foi calculada corretamente!\n");
                styleView.linhaVisualDivisoriaIg();
                break;
                
            case "cerebro":
                // Pega o bônus total incrementado no cérebro e armazena na variável.
                double bonusTotalCerebro = fichaPersonagem.getBonusTotal().getBonusTotalCerebro();
        
                // Pega o cérebro total e armazena na variável.
                int cerebroTotalPersonagem = fichaPersonagem.getHabilidadeTotal().getCerebroTotal();
                
                // Pega o valor total que os equipamentos e o pet acrescentam no cérebro.
                int totalCerebroEquipamentosPet = fichaPersonagem.getAtributosEquipPet().getCerebroTotalEquipamentosPet();
         
                // Subtrai o valor total que os equipamentos e pet acrescentam no cérebro total.
                int resultadoSubCerebroTotEquipPet = cerebroTotalPersonagem - totalCerebroEquipamentosPet;
                   
                // Calcula o cérebro básico aproximado e armazena na variável.
                double habilidadeBasicaCerebro = resultadoSubCerebroTotEquipPet / (1+(bonusTotalCerebro/100));
                            
                // Adiciona o valor do cérebro básico na classe HabilidadeBasica.
                fichaPersonagem.getHabilidadeBasica().setCerebroBasic(habilidadeBasicaCerebro);
                 
                styleView.linhaVisualDivisoriaIg();
                System.out.println("BÔNUS TOTAL QUE O PERSONAGEM RECEBE NO CÉREBRO: "+bonusTotalCerebro+"%");
                styleView.linhaVisualDivisoriaIg();
                System.out.println("TOTAL DE PONTOS DE HABILIDADE NO CÉREBRO: "+cerebroTotalPersonagem);
                styleView.linhaVisualDivisoriaIg();
                System.out.println("TOTAL DE PONTOS QUE OS OBJETOS ACRESCENTAM AO CÉREBRO: "+totalCerebroEquipamentosPet);
                styleView.linhaVisualDivisoriaIg();
                System.out.printf("VALOR APROXIMADO DE CÉREBRO BÁSICO DO PERSONAGEM: %.1f PONTOS.\n", habilidadeBasicaCerebro);
                styleView.linhaVisualDivisoriaIg();
                /* Retornar ao usuário o valor da habilidade total para que ele consiga
                verificar se o cálculo de habilidade básica funcionou corretamente. */
                double somaHabTotBonTotC = habilidadeBasicaCerebro * (1+(bonusTotalCerebro/100));
                double habilidadeTotalAproxC = somaHabTotBonTotC + totalCerebroEquipamentosPet;
        
                System.out.printf("RETORNO HABILIDADE TOTAL NO CÉREBRO COM BASE NOS DADOS DIGITADOS PELO USUÁRIO: %.1f\n", habilidadeTotalAproxC);
                System.out.printf("ATENÇÃO: caso o valor seja próximo ou exato ao total de habilidade do personagem, \nsignifica que a habilidade básica foi calculada corretamente!\n");
                styleView.linhaVisualDivisoriaIg();
                break;
                               
            case "intuicao":
                // Pega o bônus total incrementado na intuição e armazena na variável.
                double bonusTotalIntuicao = fichaPersonagem.getBonusTotal().getBonusTotalIntuicao();
        
                // Pega a intuição total e armazena na variável.
                int intuicaoTotalPersonagem = fichaPersonagem.getHabilidadeTotal().getIntuicaoTotal();
                
                // Pega o valor total que os equipamentos e o pet acrescentam na intuição.
                int totalIntuicaoEquipamentosPet = fichaPersonagem.getAtributosEquipPet().getIntuicaoTotalEquipamentosPet();
          
                // Subtrai o valor total que os equipamentos e pet acrescentam na intuição total.
                int resultadoSubIntuicaoTotEquipPet = intuicaoTotalPersonagem - totalIntuicaoEquipamentosPet;
         
                // Calcula a intuição básica aproximada e armazena na variável.
                double habilidadeBasicaIntuicao = resultadoSubIntuicaoTotEquipPet / (1+(bonusTotalIntuicao/100)); 
                  
                // Adiciona o valor da intuição básica na classe HabilidadeBasica.
                fichaPersonagem.getHabilidadeBasica().setIntuicaoBasic(habilidadeBasicaIntuicao);
                 
                styleView.linhaVisualDivisoriaIg();
                System.out.println("BONUS TOTAL QUE O PERSONAGEM RECEBE NA INTUIÇÃO: "+bonusTotalIntuicao+"%");
                styleView.linhaVisualDivisoriaIg();
                System.out.println("TOTAL DE PONTOS DE HABILIDADE NA INTUIÇÃO: "+intuicaoTotalPersonagem);
                styleView.linhaVisualDivisoriaIg();
                System.out.println("TOTAL DE PONTOS QUE OS OBJETOS ACRESCENTAM À INTUIÇÃO: "+totalIntuicaoEquipamentosPet);
                styleView.linhaVisualDivisoriaIg();
                System.out.printf("VALOR APROXIMADO DE INTUIÇÃO BÁSICA DO PERSONAGEM: %.1f PONTOS.\n", habilidadeBasicaIntuicao);
                styleView.linhaVisualDivisoriaIg();
                /* Retornar ao usuário o valor da habilidade total para que ele consiga
                verificar se o cálculo de habilidade básica funcionou corretamente. */
                double somaHabTotBonTotI = habilidadeBasicaIntuicao * (1+(bonusTotalIntuicao/100));
                double habilidadeTotalAproxI = somaHabTotBonTotI + totalIntuicaoEquipamentosPet;
        
                System.out.printf("RETORNO HABILIDADE TOTAL NA INTUIÇÃO COM BASE NOS DADOS DIGITADOS PELO USUÁRIO: %.1f\n", habilidadeTotalAproxI);
                System.out.printf("ATENÇÃO: caso o valor seja próximo ou exato ao total de habilidade do personagem, \nsignifica que a habilidade básica foi calculada corretamente!\n");
                styleView.linhaVisualDivisoriaIg();
                break;
                
        } // Fechamento do Switch case.
   
    } // Fechamento do método calculoFinalHabilidadeBasica.
    
} // Fechamento da classe.