package herozero.project.community.logic;

import herozero.project.community.view.BonusTeamView;
import herozero.project.community.view.ErrorStyleView;
import herozero.project.community.model.FichaPersonagem;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Classe com método que pergunta armazena o valor referente ao 
 * bônus de time que o personagem recebe.
 * 
 * @author André Lauterjung
 */
public class Time
{
    private int bonusTime; 
    
    public void verificarBonusTime(Scanner sc, FichaPersonagem fichaPersonagem)
    {
        BonusTeamView perguntaBonusTime = new BonusTeamView();
        ErrorStyleView errorMensagem = new ErrorStyleView();
        
        boolean isVerificandoPergunta = true; 
        boolean isVerificandoValor = true;
   
        while(isVerificandoPergunta)
        {
            perguntaBonusTime.perguntaPersonagemTime();
            String analiseJogadorEquipe = sc.nextLine(); // Armazena o 'sim' ou 'nao'
            String editAnaliseJogadorEquipe = analiseJogadorEquipe.toLowerCase(); // transforma toda a String em letras minúsculas e atribui a uma nova variável

            if(editAnaliseJogadorEquipe.equals("sim")) // Início da primeira estrutura condicional.
            {  
                isVerificandoPergunta = false;
                
                while(isVerificandoValor)
                {
                    try
                    {
                        perguntaBonusTime.mensagemTime(); // pergunta o total de bônus que a equipe dá às habilidades básicas do personagem
                        int valorBonusTime = sc.nextInt();
                        sc.nextLine();
                    
                        if(valorBonusTime < 0 ||valorBonusTime >50) // Início da segunda estrutura condicional.
                        {                  
                            errorMensagem.mensagemNumeroInvalido();
                        }
            
                        else // Caso ele digite um valor maior ou igual a zero ou menor igual a 50
                        {
                            this.bonusTime = valorBonusTime;
                
                            fichaPersonagem.getBonusTotal().setBonusTotalForca(this.bonusTime);
                            fichaPersonagem.getBonusTotal().setBonusTotalVigor(this.bonusTime);
                            fichaPersonagem.getBonusTotal().setBonusTotalCerebro(this.bonusTime);
                            fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(this.bonusTime);
                
                            System.out.printf("O personagem recebe um bônus de %d%% do time nas habilidades básicas!\n", this.bonusTime);
                            isVerificandoValor = false;
                            
                        } // Fim da segunda estrutura condicional.
                    }
                    catch(InputMismatchException e)
                    {
                        errorMensagem.mensagemEntradaInvalida();
                        sc.nextLine();
                    }
                    
                } // Fim do primeiro loop while
                
            } // Fechamento da primeira estrutura condicional;
        
            if(editAnaliseJogadorEquipe.equals("nao") || editAnaliseJogadorEquipe.equals("não")) // caso o usuário digite 'não'
            {
                perguntaBonusTime.semBonusTime();
           
                fichaPersonagem.getBonusTotal().setBonusTotalForca(0);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(0);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(0);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(0);
                
                isVerificandoPergunta = false;
       
            } // Fechamento da segunda estrutura condicional. 
        
        } //Fim do segundo loop while
        
    } // Fechamento do método verificarBonusTime
    
} // Fechamento da classe.