package org.junit.runner.manipulation;
public interface Orderable extends Sortable {
    void order(Orderer orderer) throws InvalidOrderingException;
}
