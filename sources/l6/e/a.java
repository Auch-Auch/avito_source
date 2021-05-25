package l6.e;

import androidx.collection.ArraySet;
import java.util.Map;
public class a extends c<E, E> {
    public final /* synthetic */ ArraySet d;

    public a(ArraySet arraySet) {
        this.d = arraySet;
    }

    @Override // l6.e.c
    public void a() {
        this.d.clear();
    }

    @Override // l6.e.c
    public Object b(int i, int i2) {
        return this.d.b[i];
    }

    @Override // l6.e.c
    public Map<E, E> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // l6.e.c
    public int d() {
        return this.d.c;
    }

    @Override // l6.e.c
    public int e(Object obj) {
        return this.d.indexOf(obj);
    }

    @Override // l6.e.c
    public int f(Object obj) {
        return this.d.indexOf(obj);
    }

    @Override // l6.e.c
    public void g(E e, E e2) {
        this.d.add(e);
    }

    @Override // l6.e.c
    public void h(int i) {
        this.d.removeAt(i);
    }

    @Override // l6.e.c
    public E i(int i, E e) {
        throw new UnsupportedOperationException("not a map");
    }
}
