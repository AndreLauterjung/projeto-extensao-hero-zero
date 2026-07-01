package herozero.project.community.logic;

import herozero.project.community.view.BonusHabilidadePetView;
import herozero.project.community.model.FichaPersonagem;
import herozero.project.community.view.ErrorStyleView;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Classe com métodos que retornam informações ao usuário e armazena valor 
 * referente ao bônus de pet que o personagem recebe.
 * 
 * @author André Lauterjung
 */
public class HabilidadePet
{
    
    public void escolhaHabilidade (Scanner sc, FichaPersonagem fichaPersonagem)
    {
        BonusHabilidadePetView perguntaHabilidadePet = new BonusHabilidadePetView();
        ErrorStyleView errorMensagem = new ErrorStyleView();
        
        boolean isCalculandoBonusPet = true;
        int escolhaHabilidadePet = -1;
        
        while(isCalculandoBonusPet)
        {
            try
            {
                perguntaHabilidadePet.perguntaHabilidadePet();
                perguntaHabilidadePet.listaHabilidadePets();
        
                escolhaHabilidadePet = sc.nextInt(); // Armazena o número que o usuário digitou
                sc.nextLine();
                
                if(escolhaHabilidadePet < 0 || escolhaHabilidadePet > 27)
                {
                    errorMensagem.mensagemNumeroInvalido(); 
                }
                else
                {
                    isCalculandoBonusPet = false;
                    
                } // Fechamento da estrutura condicional.
            }
            catch(InputMismatchException e)
            {
                errorMensagem.mensagemEntradaInvalida();
                sc.nextLine();
            }
        } // Fechamento do loop while.
              
        switch(escolhaHabilidadePet)
        {
            case 0:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(0);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(0);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(0);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(0);
                
                System.out.println("O jogador não está com um pet equipado!");
                break;
                
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: 
                fichaPersonagem.getBonusTotal().setBonusTotalForca(20);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(20);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(20);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(20);
                System.out.println("A habilidade do pet dá um bônus de 20% em todas as habilidades básicas!");
                break;
                
            case 6: 
                fichaPersonagem.getBonusTotal().setBonusTotalForca(19);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(19);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(19);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(19);
                System.out.println("A habilidade do pet dá um bônus de 19% em todas as habilidades básicas!");
                break;
                
            case 7:
            case 8: 
                fichaPersonagem.getBonusTotal().setBonusTotalForca(18);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(18);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(18);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(18);
                System.out.println("A habilidade do pet dá um bônus de 18% em todas as habilidades básicas!");
                break;
                
            case 9:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(17);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(17);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(17);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(17);
                System.out.println("A habilidade do pet dá um bônus de 17% em todas as habilidades básicas!");
                break;
                
            case 10:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(16);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(16);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(16);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(16);
                System.out.println("A habilidade do pet dá um bônus de 16% em todas as habilidades básicas!");
                break;
                
            case 11:
            case 12:
            case 13:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(15);
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(15);
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(15);
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(15);
                System.out.println("A habilidade do pet dá um bônus de 15% em todas as habilidades básicas!");
                break;
                
            case 14:
                fichaPersonagem.getBonusTotal().setBonusTotalForca(10);
                System.out.println("A habilidade do pet dá um bônus de 10% na força básica!");
                break;
                
            case 15: 
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(25);
                System.out.println("A habilidade do pet dá um bônus de 25% no vigor básico!");
                break;
                
            case 16:
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(20);
                System.out.println("A habilidade do pet dá um bônus de 20% no vigor básico!");
                break;
                
            case 17:
                fichaPersonagem.getBonusTotal().setBonusTotalVigor(10);
                System.out.println("A habilidade do pet dá um bônus de 10% no vigor básico!");
                break;
                
            case 18:
            case 19:
            case 20:
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(20);
                System.out.println("A habilidade do pet dá um bônus de 20% no cérebro básico!");
                break;
                
            case 21:
                fichaPersonagem.getBonusTotal().setBonusTotalCerebro(10);
                System.out.println("A habilidade do pet dá um bônus de 10% no cérebro básico!");
                break;
                
            case 22:
            case 23:
            case 24:
            case 25:
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(25);
                System.out.println("A habilidade do pet dá um bônus de 25% na intuição básica!");
                break;
                
            case 26:
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(20);
                System.out.println("A habilidade do pet dá um bônus de 20% na intuição básica");
                break;
                
            case 27:
                fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(10);
                System.out.println("A habilidade do pet dá um bônus de 10% na intuição básica!");
                break;
                
        } // Fechamento do switch case.
        
    } // Fechamento do método escolhaHabilidade.
   
} // Fechamento da classe.