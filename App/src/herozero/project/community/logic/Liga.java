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
                    opcaoLiga = opcaoLiga * 3;
                    System.out.println("Bônus de liga recebido: "+opcaoLiga);
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
       
    } // Fechamento do método verificarLiga.   
} // Fechamento da classe.