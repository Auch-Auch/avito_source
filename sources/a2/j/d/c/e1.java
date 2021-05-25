package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public class e1<K, V> extends g<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    @NullableDecl
    public final K a;
    @NullableDecl
    public final V b;

    public e1(@NullableDecl K k, @NullableDecl V v) {
        this.a = k;
        this.b = v;
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.a;
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.b;
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
