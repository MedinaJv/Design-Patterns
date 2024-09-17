/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifnmg.client;

/**
 *
 * @author jvaml
 */

// Interface Strategy: Declara o método comum que todas as estratégias irão implementar
interface Strategy {
    void execute(String data);
}

// ConcreteStrategyA: Implementa uma versão específica do algoritmo
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute(String data) {
        System.out.println("ConcreteStrategyA executando com: " + data);
    }
}

// ConcreteStrategyB: Implementa outra versão específica do algoritmo
class ConcreteStrategyB implements Strategy {
    @Override
    public void execute(String data) {
        System.out.println("ConcreteStrategyB executando com: " + data);
    }
}

// Contexto: Armazena uma referência para um objeto Strategy e chama seu método
class Context {
    private Strategy strategy;

    // Método para definir a estratégia em tempo de execução
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // Método que utiliza a estratégia definida
    public void doSomething(String data) {
        strategy.execute(data);
    }
}

// Cliente: Configura as estratégias e interage com o contexto
public class Client {
    public static void main(String[] args) {
        // Criação do contexto
        Context context = new Context();

        // Utilizando ConcreteStrategyA
        Strategy strategyA = new ConcreteStrategyA();
        context.setStrategy(strategyA);
        context.doSomething("Dados para A");

        // Alterando para ConcreteStrategyB
        Strategy strategyB = new ConcreteStrategyB();
        context.setStrategy(strategyB);
        context.doSomething("Dados para B");
    }
}

