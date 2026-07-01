package herozero.project.community.logic;

import herozero.project.community.view.HabilidadeTotalView;
import herozero.project.community.view.ErrorStyleView;
import herozero.project.community.model.FichaPersonagem;

import java.util.Scanner;
import java.util.InputMismatchException;
        

public class HabilidadeTotalLogic
{
    boolean isProgramaExecutando = true;
    
    private int forcaTotal;
    private int vigorTotal;
    private int cerebroTotal;
    private int intuicaoTotal;
    String perguntaHabTotal;
    int valorUserForcaTotal;
    int valorUserVigorTotal;
    int valorUserCerebroTotal;
    int valorUserIntuicaoTotal;
    
    private String respHabTotalText; // armazenar resposta do usuário para utilizar na classe AtributosEquipamentosPet
      
    public void armazenarHabilidadeTotal(Scanner sc, FichaPersonagem fichaPersonagem)
    {
        HabilidadeTotalView perguntasHabilidadeTotal = new HabilidadeTotalView();
        ErrorStyleView errorMensagem = new ErrorStyleView();
        
        while(isProgramaExecutando)
        {
            perguntasHabilidadeTotal.mensagemHabToCalc();
            perguntaHabTotal = sc.nextLine(); // Armazenar a habilidade que o usuário quer calcular
            perguntaHabTotal = perguntaHabTotal.toLowerCase();
            
            if(!perguntaHabTotal.equals("forca") && !perguntaHabTotal.equals("vigor") 
            && !perguntaHabTotal.equals("cerebro") && !perguntaHabTotal.equals("intuicao"))
            {
                System.out.println("Você digitou 'forca', 'vigor', 'cerebro' ou 'intuicao' errado! Tente novamente!");
            }
            else
            {
                this.respHabTotalText = perguntaHabTotal; 
                isProgramaExecutando = false;
            }
            
        } // Fechamento do loop while.
           
            
        switch(perguntaHabTotal) 
        {
            case "forca":
                
                isProgramaExecutando = true;
                while(isProgramaExecutando)
                {
                    try
                    {
                        perguntasHabilidadeTotal.mensagemForcaTotal();
                        valorUserForcaTotal = sc.nextInt();
                        sc.nextLine();
                        
                        if(valorUserForcaTotal < 0)
                        {
                            errorMensagem.mensagemNumeroInvalido();
                        }
                        else
                        {
                            this.forcaTotal = valorUserForcaTotal;
                            fichaPersonagem.getHabilidadeTotal().setValorForcaTotal(this.forcaTotal);
            
                            System.out.println("Força total do personagem: "+this.forcaTotal);
                            isProgramaExecutando = false;
                        }   
                    }
                    catch(InputMismatchException e)
                    {
                        errorMensagem.mensagemEntradaInvalida();
                        sc.nextLine();
                    }
               
                } // Fechamento do loop while: força.
                break;
                
            case "vigor":
                
                isProgramaExecutando = true;
                while(isProgramaExecutando)
                {
                    try
                    {
                        perguntasHabilidadeTotal.mensagemVigorTotal();
                        valorUserVigorTotal = sc.nextInt();
                        sc.nextLine();
                        
                        if(valorUserVigorTotal < 0)
                        {
                            errorMensagem.mensagemNumeroInvalido();
                        }
                        else
                        {
                            this.vigorTotal = valorUserVigorTotal;
            
                            fichaPersonagem.getHabilidadeTotal().setValorVigorTotal(this.vigorTotal);
                            System.out.println("Vigor total do personagem: "+this.vigorTotal);
                            isProgramaExecutando = false;
                        }
   
                    }
                    catch(InputMismatchException e)
                    {
                        errorMensagem.mensagemEntradaInvalida();;
                        sc.nextLine();
                    }

                } // Fechamento do loop while: vigor.
                break;
                
                
    
            case "cerebro":
                
                isProgramaExecutando = true;
                while(isProgramaExecutando)
                {
                    try
                    {
                        perguntasHabilidadeTotal.mensagemCerebroTotal();            
                        valorUserCerebroTotal = sc.nextInt();
                        sc.nextLine();
                        
                        
                        if(valorUserCerebroTotal < 0)
                        {
                            errorMensagem.mensagemNumeroInvalido();
                        }
                        else
                        {
                            this.cerebroTotal = valorUserCerebroTotal;
            
                            fichaPersonagem.getHabilidadeTotal().setValorCerebroTotal(this.cerebroTotal);
                            System.out.println("Cérebro total do personagem: "+this.cerebroTotal);
                            isProgramaExecutando = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        errorMensagem.mensagemEntradaInvalida();
                        sc.nextLine();
                    }
                } // Fechamento do loop while: cérebro.    
                break;
                
            case "intuicao":
                
                isProgramaExecutando = true;
                while(isProgramaExecutando)
                {
                    try
                    {
                        perguntasHabilidadeTotal.mensagemIntuicaoTotal();
                        valorUserIntuicaoTotal = sc.nextInt();
                        sc.nextLine();
                        
                        if(valorUserIntuicaoTotal < 0)
                        {
                            errorMensagem.mensagemNumeroInvalido();
                        }
                        else
                        {
                            this.intuicaoTotal = valorUserIntuicaoTotal;
                            fichaPersonagem.getHabilidadeTotal().setValorIntuicaoTotal(this.intuicaoTotal);
                            
                            System.out.println("Intuição total do personagem: "+this.intuicaoTotal);
                            isProgramaExecutando = false;
                        }
                        
                    }
                    catch(InputMismatchException e)
                    {
                        errorMensagem.mensagemEntradaInvalida();
                        sc.nextLine();
                    }
                } // Fechamento loop while: intuição.
                break;
                
        } // Fechamento do switch case
        
    } // Fechamento do método armazenarHabilidadeTotal.
    
   
    public String getRespHabTotalText()
    {
        return this.respHabTotalText;
    }
    
}  // fechamento da classe