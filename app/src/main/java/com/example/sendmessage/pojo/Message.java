package com.example.sendmessage.pojo;

import java.io.Serializable;

/**
 * Clase Message, para encapsular
 * @author Elena G (Beelzenef)
 *
 * @see java.io.Serializable
 */

public class Message implements Serializable {

    // Campos
    private String textomsg;
    private String usuario;

    // Getters + setters
    public String getTextomsg() {
        return textomsg;
    }

    public void setTextomsg(String textomsg) {
        this.textomsg = textomsg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Constructor(es)

    public Message(String textomsg, String usuario) {
        this.textomsg = textomsg;
        this.usuario = usuario;
    }

    // Metodos

    @Override
    public String toString() {
        return "Message: " +
                "textomsg ='" + textomsg + '\'' +
                ", usuario ='" + usuario + '\'';
    }

    @Override
    public boolean equals(Object o) {

        Message msgAComparar;
        boolean resultado;

        // La direccion de memoria es la misma, hell yeah!
        if (this == o)
            resultado = true;
        // Si es null o no corresponde a la misma Clase, lolnope
        if (o == null || getClass() != o.getClass())
            resultado = false;

        // Superados los filtros
        msgAComparar = (Message) o;

        resultado = ((textomsg.equals(msgAComparar.textomsg)) && (usuario.equals(msgAComparar.usuario)));

        return resultado;
    }
}

