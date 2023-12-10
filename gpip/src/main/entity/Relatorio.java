package main.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Relatorio {
    private Patrimonio patrimonio;

    private static List<Patrimonio> relatorios = new ArrayList<>();

    public Relatorio() {
    }

    public void addPatrimonio(Patrimonio patrimonio){
        relatorios.add(patrimonio);
    }

    public List<Patrimonio> listarRelatorios() {
        return relatorios;
    }
}
