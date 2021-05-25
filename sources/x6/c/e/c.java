package x6.c.e;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
public class c {
    public static final Comparator<b> d = new a();
    public final IdentityHashMap<Object, Integer> a = new IdentityHashMap<>();
    public final List<TestRule> b = new ArrayList();
    public final List<MethodRule> c = new ArrayList();

    public static class a implements Comparator<b> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            b bVar3 = bVar;
            b bVar4 = bVar2;
            int i = bVar3.c;
            int i2 = bVar4.c;
            int i3 = i < i2 ? 1 : i == i2 ? 0 : -1;
            return i3 != 0 ? i3 : bVar3.b - bVar4.b;
        }
    }

    public static class b {
        public final Object a;
        public final int b;
        public final int c;

        public b(Object obj, int i, Integer num) {
            this.a = obj;
            this.b = i;
            this.c = num != null ? num.intValue() : -1;
        }
    }
}
