package herozero.project.community.logic;

import herozero.project.community.view.BonusTemporadaView;
import herozero.project.community.view.ErrorStyleView;
import herozero.project.community.model.FichaPersonagem;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Classe com método que pergunta e armazena o valor referente ao 
 * bônus de temporada que o personagem recebe.
 * 
 * @author André Lauterjung
 */
public class Temporada
{

    private int forcaBasica;
    private int vigorBasico;
    private int cerebroBasico;
    private int intuicaoBasica;        
    
    
    public void verificacaoBonusTemporada(Scanner sc, FichaPersonagem fichaPersonagem)
    {
        
        BonusTemporadaView perguntaBonusTemporada = new BonusTemporadaView();
        ErrorStyleView errorMensagem = new ErrorStyleView();
        
        boolean isBonusTemporada = true;
        boolean isPerguntandoTemporada = true;
        boolean isValorBonusTemporada = true;  
        boolean isNomeHabilidades = true;
        String novoNomeHabilidade = "";
        String pergunta = "";       
        int valorBonusTemporada = -1;
        
        boolean isCalculaTemporada = true;
        String perguntaCalcTemp = "";
        
           
        while(isCalculaTemporada)
        {
            try
            {
                System.out.println("Você deseja calcular as habilidades com bônus de temporada?");
                System.out.println("Digite \"sim\" ou \"não\"");
                perguntaCalcTemp = sc.nextLine();
                perguntaCalcTemp = perguntaCalcTemp.toLowerCase();
                
                if(perguntaCalcTemp.equals("sim"))
                {
                    isCalculaTemporada = false;
                }
                else if(perguntaCalcTemp.equals("nao") || perguntaCalcTemp.equals("não"))
                {
                    isCalculaTemporada = false;
                    isPerguntandoTemporada = false;
                }
                else
                {
                    errorMensagem.mensagemOpcaoErro();
                }  
            }
            catch(InputMismatchException e)
            {
                errorMensagem.mensagemEntradaInvalida();
                sc.nextLine();
            }
            
        } // Fechamento do loop while
        
        
        
        /* Loop para primeira parte referente ao bônus de temporada
        onde o usuário digitará se o personagem recebe ou não um bônus de temporada */
        while(isPerguntandoTemporada) 
        {
            
            perguntaBonusTemporada.perguntaTemporadaHabilidade(); // pergunta se a temporada acrescenta bônus nas habilidades
            pergunta = sc.nextLine();
            pergunta = pergunta.toLowerCase();
            
            
            /* Caso seja "sim", "não" ou "nao" o loop para 
            Se não for nenhuma dessas três opções, o loop continua até o usuário
            digitar corretamente a palavra. */
            if(pergunta.equals("sim") || pergunta.equals("não") || pergunta.equals("nao"))
            {
                isPerguntandoTemporada = false;
            }
            else
            {
                errorMensagem.mensagemOpcaoErro();  
            } // Fechamento da estrutura de condição.
            
        } // Fechamento do loop while referente a verificação da temporada. 
        
        
        while(isNomeHabilidades)
        {
            if(pergunta.equals("sim"))
            {
                perguntaBonusTemporada.bonusNomeHabilidadeBasica(); // pergunta em que habilidade vai o bônus de temporada
                novoNomeHabilidade = sc.nextLine();
                novoNomeHabilidade = novoNomeHabilidade.toLowerCase();
                
            
                if(novoNomeHabilidade.equals("forca") || novoNomeHabilidade.equals("vigor") || novoNomeHabilidade.equals("cerebro") || novoNomeHabilidade.equals("intuicao") || novoNomeHabilidade.equals("todas"))
                {
                    isNomeHabilidades = false;
                }
                else
                {
                    errorMensagem.mensagemErroNomeHabilidade();
                } // Fechamento da estrutura de condição. 
                
            }
            
            else
            {
                System .out.println("A temporada não acrescenta bônus às habilidades básicas do personagem!");
            
                fichaPersonagem.getBonusTotal().setBonusTotalForca(0);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(0);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(0);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(0);
                
                isNomeHabilidades = false;
                
            } // Fechamento da estrutura de condição.
            
        } // Fechamento do loop while referente ao nome da habilidade.
            
                     
        // Aqui o programa vai perguntar o total de bônus que o personagem recebe da temporada
        
        if(pergunta.equals("sim"))
        {
            while(isValorBonusTemporada)
            {
                try
                {
                    perguntaBonusTemporada.bonusTemporadaHabilidade(); // pede para o usuário digitar o valor do bônus de temporada
                    valorBonusTemporada = sc.nextInt(); 
                    sc.nextLine();
                      
                    if(valorBonusTemporada < 0 || valorBonusTemporada > 275)
                    {   
                        valorBonusTemporada = -1;
                        errorMensagem.mensagemNumeroInvalido();
                    }
                    else
                    {
                        isValorBonusTemporada = false;
                    }         
                }
                catch(InputMismatchException e)
                {
                    errorMensagem.mensagemEntradaInvalida();
                    sc.nextLine();
            
                }// Fechamento do Try-catch
                    
            } // Fechamento do terceiro loop while.  
        
        } // Fechamento da estrutura de condição.
            
        
        
        
        if(pergunta.equals("sim"))
        {
            switch (novoNomeHabilidade)
            {
                case "forca":
                    this.forcaBasica = valorBonusTemporada;
                    fichaPersonagem.getBonusTotal().setBonusTotalForca(this.forcaBasica);
                    
                    System.out.printf("O personagem recebe um bônus de %d%% na força básica!\n", valorBonusTemporada);
                    isNomeHabilidades = false;
                    break;
                
                case "vigor":
                    this.vigorBasico = valorBonusTemporada;
                    fichaPersonagem.getBonusTotal().setBonusTotalVigor(this.vigorBasico);
                    
                    System.out.printf("O personagem recebe um bônus de %d%% no vigor básico!\n", valorBonusTemporada);
                    isNomeHabilidades = false;
                    break;
                
                case "cerebro":
                    this.cerebroBasico= valorBonusTemporada;
                    fichaPersonagem.getBonusTotal().setBonusTotalCerebro(this.cerebroBasico);
                    
                    System.out.printf("O personagem recebe um bônus de %d%% no cérebro básico!\n", valorBonusTemporada);
                    isNomeHabilidades = false;
                    break;
                
                case "intuicao":
                    this.intuicaoBasica = valorBonusTemporada;
                    fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(this.intuicaoBasica);
                    
                    System.out.printf("O personagem recebe um bônus de %d%% na intuição básica!\n", valorBonusTemporada);
                    isNomeHabilidades = false;
                    break;
                
                case "todas":
                    this.forcaBasica = valorBonusTemporada;
                    this.vigorBasico = valorBonusTemporada;
                    this.cerebroBasico = valorBonusTemporada;
                    this.intuicaoBasica = valorBonusTemporada;
                    
                    fichaPersonagem.getBonusTotal().setBonusTotalForca(this.forcaBasica);
                    fichaPersonagem.getBonusTotal().setBonusTotalVigor(this.vigorBasico);
                    fichaPersonagem.getBonusTotal().setBonusTotalCerebro(this.cerebroBasico);
                    fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(this.intuicaoBasica);
                    
                    System.out.printf("O personagem recebe um bônus de %d%% em todas as habilidades básicas!\n", valorBonusTemporada);
                    isNomeHabilidades = false;
                    break;
        
            } // Fechamento do switch case.
        
        } // Fechamento da estrutura de condição.
        
    } // Fechamento do método verificacaoBonusTemporada.
    
} // Fechamento da classe.