package model;

import java.util.Date;

public class RestauranteCozinheiro {
    private String codCozRestcoz;
    private int codRestRestcoz;
    private Date dataContratacao;


    public RestauranteCozinheiro() {
    }

    public RestauranteCozinheiro(String codCozRestcoz, int codRestRestcoz, Date dataContratacao) {
        this.codCozRestcoz = codCozRestcoz;
        this.codRestRestcoz = codRestRestcoz;
        this.dataContratacao = dataContratacao;
    }

    public String getCodCozRestcoz() {
        return codCozRestcoz;
    }

    public void setCodCozRestcoz(String codCozRestcoz) {
        this.codCozRestcoz = codCozRestcoz;
    }

    public int getCodRestRestcoz() {
        return codRestRestcoz;
    }

    public void setCodRestRestcoz(int codRestRestcoz) {
        this.codRestRestcoz = codRestRestcoz;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}
