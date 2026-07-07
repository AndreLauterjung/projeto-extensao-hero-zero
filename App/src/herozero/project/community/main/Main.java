package herozero.project.community.main;

import herozero.project.community.logic.EnergeticoDeHabilidade; 
import herozero.project.community.logic.Liga; 
import herozero.project.community.logic.Time; 
import herozero.project.community.logic.EsconderijoHeroico; 
import herozero.project.community.logic.HabilidadePet;
import herozero.project.community.logic.Temporada;
import herozero.project.community.logic.BonusEquipamentos;
import herozero.project.community.logic.HabilidadeTotalLogic;
import herozero.project.community.logic.AtributosEquipamentosPet;
import herozero.project.community.logic.CalculoFinalHabilidadeBasica;

import herozero.project.community.model.FichaPersonagem;

import herozero.project.community.view.ConsoleStyleView;

import java.util.Scanner;

/**=== HISTÓRICO DE VERSÕES ===

[v1.1.0] - 07/07/2026
* Projeto: Calculadora de Habilidade básica Hero Zero
* Versão atual: 1.1.0
* Desenvolvedor: André Lauterjung
* 
* Novidades: Agora é possível saber a quantidade total de bônus que uma habilidade 
* recebe, a quantitade total de pontos dos atributos que uma habilidade recebe
* e também o programa realiza um cálculo retornando a habilidade total aproximada
* que o personagem possui, o que valida o resultado da habilidade básica calculada.
* 
* Também é possível escolher se deseja calcular com ou sem o bônus de temporada.
* 
* Foi adicionado também o tratamento de erros para evitar que o programa pare
* quando um valor inválido for digitado, tornando a utilização da ferramenta mais 
* entendível e evitando que resultados errados sejam retornados.
*/

public class Main
{
    public static void main(String[] args)
    {
        EnergeticoDeHabilidade energetico = new EnergeticoDeHabilidade();
        Liga liga = new Liga();
        Time time = new Time();
        EsconderijoHeroico esconderijo = new EsconderijoHeroico();
        HabilidadePet habilidadePet = new HabilidadePet();
        Temporada temporada = new Temporada();
        BonusEquipamentos bonusEquipamentos = new BonusEquipamentos();
        HabilidadeTotalLogic habilidadeTotal = new HabilidadeTotalLogic();
        AtributosEquipamentosPet atributosEquipamentosPet = new AtributosEquipamentosPet();
        CalculoFinalHabilidadeBasica calculoFinal = new CalculoFinalHabilidadeBasica();
        
        FichaPersonagem fichaPersonagem = new FichaPersonagem();
        
        ConsoleStyleView consoleStyle = new ConsoleStyleView();
        
        Scanner sc = new Scanner(System.in);
        
 
        consoleStyle.mensagemInicio();
              
        // Calcular o bônus de temporada. 
        temporada.verificacaoBonusTemporada(sc, fichaPersonagem); 
        consoleStyle.linhaVisualDivisoriaAst();
        
        
        /* Calculando o bônus que o energético de habilidade acrescenta nas 
        habilidades básicas do personagem. */
        energetico.verificarEnergetico(sc, fichaPersonagem);
        consoleStyle.linhaVisualDivisoriaAst();
        
       
        /* Calculando o bônus que a Liga acrescenta nas habilidades básicas 
        do personagem. */
        liga.verificarLiga(sc, fichaPersonagem);
        consoleStyle.linhaVisualDivisoriaAst();

        
        // Calcular bônus que o time atribui às habilidades básicas.
        time.verificarBonusTime(sc, fichaPersonagem);
        consoleStyle.linhaVisualDivisoriaAst();
        
        
        /* Calculando bônus que o Laboratório de Pesquisa cibernético 
        acrescenta às habilidades básicas do personagem. */
        esconderijo.verificarBonusEsconderijo(sc, fichaPersonagem);
        consoleStyle.linhaVisualDivisoriaAst();
        
        
        // Calcular bônus da habilidade do pet equipado.
        habilidadePet.escolhaHabilidade(sc, fichaPersonagem);
        consoleStyle.linhaVisualDivisoriaAst();
        

        // Calcular bônus do conjunto de equipamentos equipados.
        bonusEquipamentos.verificarConjuntos(sc, fichaPersonagem);    
        consoleStyle.linhaVisualDivisoriaAst();
        
    
        /* Perguntar ao usuário qual habilidade a ser calculada e solicitar 
        que o usuário informe o valor de habilidade total. */
        habilidadeTotal.armazenarHabilidadeTotal(sc, fichaPersonagem);
        consoleStyle.linhaVisualDivisoriaAst();
        
        
        // Calcular atributos dos equipamentos e pet equipados no personagem.
        atributosEquipamentosPet.calcularAtributosEquipPet(sc, habilidadeTotal, fichaPersonagem); 
        consoleStyle.linhaVisualDivisoriaAst();
        

        // Parte final do programa, onde são excutados os calculos finais.
        calculoFinal.calculoFinalHabilidadeBasica(habilidadeTotal, fichaPersonagem);
        
        consoleStyle.mensagemEncerramento();
        
        sc.close();
        
    }
    
} // Fechamento da classe Main.