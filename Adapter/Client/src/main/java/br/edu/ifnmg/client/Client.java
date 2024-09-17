/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifnmg.client;

/**
 *
 * @author jvaml
 */
// Serviço que queremos adaptar
class Service {
    public void serviceMethod(String specialData) {
        System.out.println("Service is processing special data: " + specialData);
    }
}

// Classe existente que utiliza um formato de dado diferente
class ExistingClass {
    public void method(int data) {
        System.out.println("Existing class method is processing data: " + data);
    }
}

// Adapter que converte o formato dos dados e chama o serviço
class Adapter extends ExistingClass {
    private Service service;

    public Adapter(Service service) {
        this.service = service;
    }

    @Override
    public void method(int data) {
        // Conversão de dados
        String specialData = convertToServiceFormat(data);
        // Chamando o serviço com o dado convertido
        service.serviceMethod(specialData);
    }

    // Método de conversão de dados
    private String convertToServiceFormat(int data) {
        return "ConvertedData: " + Integer.toString(data);
    }
}

// Cliente que utiliza a classe existente, mas agora com o Adapter
public class Client {
    public static void main(String[] args) {
        // Criando o serviço e o adaptador
        Service service = new Service();
        Adapter adapter = new Adapter(service);

        // Cliente usa o método da classe existente, que na verdade chama o serviço
        adapter.method(1234); // O método original agora adapta para o serviço
    }
}

