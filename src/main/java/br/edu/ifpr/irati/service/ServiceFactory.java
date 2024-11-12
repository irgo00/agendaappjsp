package br.edu.ifpr.irati.service;

public class ServiceFactory {

    public static Service getService(String nome){

        switch (nome){
            case "professor":
                return new ProfessorService();
            case "tarefa":
                return new TarefaService();
            default:
                break;
        }
        return new TarefaService();

    }

}
