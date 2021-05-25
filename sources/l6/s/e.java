package l6.s;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;
public class e<T> {
    public static final e e = new e(Collections.emptyList(), 0);
    public static final e f = new e(Collections.emptyList(), 0);
    @NonNull
    public final List<T> a;
    public final int b;
    public final int c;
    public final int d;

    public static abstract class a<T> {
        @MainThread
        public abstract void a(int i, @NonNull e<T> eVar);
    }

    public e(@NonNull List<T> list, int i, int i2, int i3) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Result ");
        L.append(this.b);
        L.append(", ");
        L.append(this.a);
        L.append(", ");
        L.append(this.c);
        L.append(", offset ");
        L.append(this.d);
        return L.toString();
    }

    public e(@NonNull List<T> list, int i) {
        this.a = list;
        this.b = 0;
        this.c = 0;
        this.d = i;
    }
}
