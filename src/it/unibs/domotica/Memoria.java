package it.unibs.domotica;

public interface Memoria<T> {
    boolean primaSalva(T data);
    void dopoSalva(T data);
    String getPercorso();
}
