package engenharia.software.hackatona.pucrs.controller.dto;

import java.util.ArrayList;

public class AlunosTimesDTO {

    private Integer idTime;
    private ArrayList<Integer> lista;

    public Integer getIdTime() {
        return idTime;
    }

    public void setIdTime(Integer idTime) {
        this.idTime = idTime;
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }
}
