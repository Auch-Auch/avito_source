package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class f4<V> extends h4<Collection<V>> {
    private static final long serialVersionUID = 0;

    public class a extends b5<Collection<V>, Collection<V>> {
        public a(Iterator it) {
            super(it);
        }

        @Override // a2.j.d.c.b5
        public Object a(Object obj) {
            return AppCompatDelegateImpl.i.d((Collection) obj, f4.this.b);
        }
    }

    public f4(Collection<Collection<V>> collection, @NullableDecl Object obj) {
        super(collection, obj, null);
    }

    @Override // a2.j.d.c.h4, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Collection<V>> iterator() {
        return new a(super.iterator());
    }
}
