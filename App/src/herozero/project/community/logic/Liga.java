package herozero.project.community.logic;

import herozero.project.community.view.BonusLeagueView;
import herozero.project.community.view.ErrorStyleView;
import herozero.project.community.model.FichaPersonagem;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Classe com método que armazena valor referente ao bônus de liga que o 
 * personagem recebe.
 * 
 * @author André Lauterjung
 */
public class Liga
{
    BonusLeagueView perguntaLiga = new BonusLeagueView();
    ErrorStyleView errorMensagem = new ErrorStyleView();
    
    public void verificarLiga(Scanner sc, FichaPersonagem fichaPersonagem)
    {
        boolean isVerificandoLiga = true;
        int opcaoLiga = -1;
        
        while(isVerificandoLiga)
        {
            try
            {
                perguntaLiga.listaLigas();
                opcaoLiga = sc.nextInt();
                sc.nextLine();
                
                if(opcaoLiga >= 0 && opcaoLiga <=13)
                {      
                    isVerificandoLiga = false;
                }
                else
                {
                    opcaoLiga = -1;
                    errorMensagem.mensagemNumeroInvalido();
                }
            
            }
            catch(InputMismatchException e)
            {
                errorMensagem.mensagemEntradaInvalida();
                sc.nextLine();
            }
        }  
        
        switch(opcaoLiga)
        {
            case 0:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(0);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(0);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(0);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(0);
                System.out.println("O jogador recebe 0% de bônus da liga em todas as habilidades básicas!");    
                break;
                
            case 1:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(3);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(3);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(3);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(3);
                System.out.println("O jogador recebe 3% de bônus da liga em todas as habilidades básicas!"); 
                break;
            
            case 2:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(6);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(6);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(6);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(6);
                System.out.println("O jogador recebe 6% de bônus da liga em todas as habilidades básicas!");
                break;
                
            case 3:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(9);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(9);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(9);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(9);
                System.out.println("O jogador recebe 9% de bônus da liga em todas as habilidades básicas!");
                break;
                
            case 4:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(12);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(12);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(12);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(12);
                System.out.println("O jogador recebe 12% de bônus da liga em todas as habilidades básicas!");
                break;
            
            case 5:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(15);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(15);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(15);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(15);
                System.out.println("O jogador recebe 15% de bônus da liga em todas as habilidades básicas!");
                break;
            case 6:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(18);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(18);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(18);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(18);
                System.out.println("O jogador recebe 18% de bônus da liga em todas as habilidades básicas!");
                break;
            
            case 7: 
                fichaPersonagem.getBonusTotal().setBonusTotalForca(21);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(21);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(21);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(21);
                System.out.println("O jogador recebe 21% de bônus da liga em todas as habilidades básicas!");
                break;
                
            case 8:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(24);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(24);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(24);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(24);
                System.out.println("O jogador recebe 24% de bônus da liga em todas as habilidades básicas!");
                break;
                
            case 9:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(27);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(27);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(27);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(27);
                System.out.println("O jogador recebe 27% de bônus da liga em todas as habilidades básicas!");
                break;
            
            case 10:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(30);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(30);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(30);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(30);
                System.out.println("O jogador recebe 30% de bônus da liga em todas as habilidades básicas!");
                break;
                
             case 11:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(33);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(33);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(33);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(33);
                System.out.println("O jogador recebe 33% de bônus da liga em todas as habilidades básicas!"); 
                break;
                
            case 12:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(36);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(36);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(36);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(36);
                System.out.println("O jogador recebe 36% de bônus da liga em todas as habilidades básicas!");
                break;
            
            case 13:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(39);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(39);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(39);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(39);                
                System.out.println("O jogador recebe 39% de bônus da liga em todas as habilidades básicas!");
                break;
             
        } // Fechamento do switch case.
       
    } // Fechamento do método verificarLiga. 
    
} // Fechamento da classe.