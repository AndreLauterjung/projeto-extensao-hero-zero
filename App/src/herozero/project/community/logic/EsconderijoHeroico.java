package herozero.project.community.logic;

import herozero.project.community.view.BonusEsconderijoView;
import herozero.project.community.model.FichaPersonagem;
import herozero.project.community.view.ErrorStyleView;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Classe com método que armazena o valor referente ao bônus de esconderijo de
 * herói que o personagem recebe.
 * 
 * @author André Lauterjung
 */
public class EsconderijoHeroico
{
    private int bonusEsconderijo;
    
    public void verificarBonusEsconderijo(Scanner sc, FichaPersonagem fichaPersonagem)
    {
        BonusEsconderijoView perguntaBonusEsconderijo = new BonusEsconderijoView();
        ErrorStyleView errorMensagem = new ErrorStyleView();
        
        int valorEntradaBonusEsconderijo;
        boolean isCalculandoBonusEsconderijo = true;
        
        while(isCalculandoBonusEsconderijo)
        {
            try
            {
                perguntaBonusEsconderijo.listaNiveisLaboratorioCibernetico();
                valorEntradaBonusEsconderijo = sc.nextInt();
                sc.nextLine();
                
                if(valorEntradaBonusEsconderijo < 0 || valorEntradaBonusEsconderijo > 25)
                {                
                    errorMensagem.mensagemNumeroInvalido();
                }

                else // Caso o usuário digite um valor maior ou igual a 0 ou menor igual a 25.
                {
                    this.bonusEsconderijo = valorEntradaBonusEsconderijo;
                    fichaPersonagem.getBonusTotal().setBonusTotalForca(this.bonusEsconderijo);
                    fichaPersonagem.getBonusTotal().setBonusTotalVigor(this.bonusEsconderijo);
                    fichaPersonagem.getBonusTotal().setBonusTotalCerebro(this.bonusEsconderijo);
                    fichaPersonagem.getBonusTotal().setBonusTotalIntuicao(this.bonusEsconderijo);
            
                    isCalculandoBonusEsconderijo = false;
                    
                } // Fim da estrutura condicional.
       
            }
            catch(InputMismatchException e)
            {
                errorMensagem.mensagemEntradaInvalida();
                sc.nextLine();
            }   
        } // Fim do loop while.
        
        System.out.printf("O personagem recebe %d%% de bônus do esconderijo heroico\n", this.bonusEsconderijo);
   
    } // Fechamento do método verificarBonusEsconderijo.

} // Fechamento da classe.