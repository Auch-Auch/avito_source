package a2.j.b.b.u0.j;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public abstract class e {
    public final int a;

    public static final class a extends e {
        public final long b;
        public final List<b> c = new ArrayList();
        public final List<a> d = new ArrayList();

        public a(int i, long j) {
            super(i);
            this.b = j;
        }

        @Nullable
        public a b(int i) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.d.get(i2);
                if (aVar.a == i) {
                    return aVar;
                }
            }
            return null;
        }

        @Nullable
        public b c(int i) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.c.get(i2);
                if (bVar.a == i) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // a2.j.b.b.u0.j.e
        public String toString() {
            return e.a(this.a) + " leaves: " + Arrays.toString(this.c.toArray()) + " containers: " + Arrays.toString(this.d.toArray());
        }
    }

    public static final class b extends e {
        public final ParsableByteArray b;

        public b(int i, ParsableByteArray parsableByteArray) {
            super(i);
            this.b = parsableByteArray;
        }
    }

    public e(int i) {
        this.a = i;
    }

    public static String a(int i) {
        StringBuilder L = a2.b.a.a.a.L("");
        L.append((char) ((i >> 24) & 255));
        L.append((char) ((i >> 16) & 255));
        L.append((char) ((i >> 8) & 255));
        L.append((char) (i & 255));
        return L.toString();
    }

    public String toString() {
        return a(this.a);
    }
}
