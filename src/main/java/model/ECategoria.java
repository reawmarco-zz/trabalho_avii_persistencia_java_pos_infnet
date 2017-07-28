package model;

import java.util.ArrayList;
import java.util.List;

public enum ECategoria {

    HATCH_COMPLETO(1,"HATCH COMPLETO"),
    HATCH_MEDIO(2,"HATCH MEDIO"),
    SEDAN_COMPLETO(3,"SEDAN COMPLETO"),
    SEDAN_MEDIO(4,"SEDAN MEDIO"),
    MINIVAN(5,"MINIVAN"),
    ESPORTIVO(6,"ESPORTIVO"),
    UTILITARIO_COMERCIAL(7,"UTILITARIO COMERCIAL");

    private String descricao;
    private int id;

    public static List<ECategoria> getListCategoria(){
        List<ECategoria> listCategoria = new ArrayList<ECategoria>();
        listCategoria.add(ECategoria.HATCH_COMPLETO);
        listCategoria.add(ECategoria.HATCH_MEDIO);
        listCategoria.add(ECategoria.SEDAN_COMPLETO);
        listCategoria.add(ECategoria.SEDAN_MEDIO);
        listCategoria.add(ECategoria.MINIVAN);
        listCategoria.add(ECategoria.ESPORTIVO);
        listCategoria.add(ECategoria.UTILITARIO_COMERCIAL);
        return listCategoria;
    }

   ECategoria(int id,String descricao){
        this.descricao = descricao;
        this.id = id;
    }

    public String getCategoria(){
        return descricao;
    }

   public int getId() {
        return id;
    }
}
