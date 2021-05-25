package org.junit.runner.manipulation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.junit.runner.Description;
public final class Orderer {
    public final Ordering a;

    public Orderer(Ordering ordering) {
        this.a = ordering;
    }

    public void apply(Object obj) throws InvalidOrderingException {
        if (obj instanceof Orderable) {
            ((Orderable) obj).order(this);
        }
    }

    public List<Description> order(Collection<Description> collection) throws InvalidOrderingException {
        List<Description> orderItems = this.a.orderItems(Collections.unmodifiableCollection(collection));
        if (!this.a.a()) {
            return orderItems;
        }
        HashSet hashSet = new HashSet(collection);
        if (hashSet.containsAll(orderItems)) {
            HashSet hashSet2 = new HashSet(orderItems);
            if (hashSet2.size() != orderItems.size()) {
                throw new InvalidOrderingException("Ordering duplicated items");
            } else if (hashSet2.containsAll(hashSet)) {
                return orderItems;
            } else {
                throw new InvalidOrderingException("Ordering removed items");
            }
        } else {
            throw new InvalidOrderingException("Ordering added items");
        }
    }
}
