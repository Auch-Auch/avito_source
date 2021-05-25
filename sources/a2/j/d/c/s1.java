package a2.j.d.c;

import com.google.common.base.Function;
import java.util.Iterator;
public final class s1 implements Function<Iterable<? extends T>, Iterator<? extends T>> {
    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return ((Iterable) obj).iterator();
    }
}
