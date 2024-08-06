
package com.pss.desafiodatabinding;

import com.pss.desafiodatabinding.binding.BindingManager;


public class DesafioDataBinding {

    public static void main(String[] args) {
        Pessoa origem = new Pessoa();
        origem.setNome("João");
        origem.setIdade(30);

        Pessoa destino = new Pessoa();
        destino.setNome("Ana");
        destino.setIdade(25);

        // Configuração do Binding
        BindingManager gerenciadorDeBinding = new BindingManager(origem, destino, "nome", "nome");
        gerenciadorDeBinding.configureTwoWayBinding();

        // Atualização do objeto origem
        gerenciadorDeBinding.updateSource("Alice");
        System.out.println("Nome do destino após atualização da origem: " + destino.getNome());

        // Atualização do objeto destino
        gerenciadorDeBinding.updateTarget("Bob");
        System.out.println("Nome da origem após atualização do destino: " + origem.getNome());
    }
}


