package org.spongycastle.x509;

import a2.b.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
public class X509CollectionStoreParameters implements X509StoreParameters {
    public Collection a;

    public X509CollectionStoreParameters(Collection collection) {
        Objects.requireNonNull(collection, "collection cannot be null");
        this.a = collection;
    }

    public Object clone() {
        return new X509CollectionStoreParameters(this.a);
    }

    public Collection getCollection() {
        return new ArrayList(this.a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X509CollectionStoreParameters: [\n");
        StringBuilder L = a.L("  collection: ");
        L.append(this.a);
        L.append("\n");
        stringBuffer.append(L.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
