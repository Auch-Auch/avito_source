package a2.j.b.b.d1.i;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.TreeSet;
public final class e {
    public final int a;
    public final String b;
    public final TreeSet<i> c = new TreeSet<>();
    public final ArrayList<a> d = new ArrayList<>();
    public DefaultContentMetadata e;

    public static final class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    public e(int i, String str, DefaultContentMetadata defaultContentMetadata) {
        this.a = i;
        this.b = str;
        this.e = defaultContentMetadata;
    }

    public long a(long j, long j2) {
        boolean z = true;
        Assertions.checkArgument(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        Assertions.checkArgument(z);
        i b2 = b(j, j2);
        long j3 = Long.MAX_VALUE;
        if (b2.isHoleSpan()) {
            if (!b2.isOpenEnded()) {
                j3 = b2.length;
            }
            return -Math.min(j3, j2);
        }
        long j4 = j + j2;
        if (j4 >= 0) {
            j3 = j4;
        }
        long j5 = b2.position + b2.length;
        if (j5 < j3) {
            for (i iVar : this.c.tailSet(b2, false)) {
                long j6 = iVar.position;
                if (j6 > j5) {
                    break;
                }
                j5 = Math.max(j5, j6 + iVar.length);
                if (j5 >= j3) {
                    break;
                }
            }
        }
        return Math.min(j5 - j, j2);
    }

    public i b(long j, long j2) {
        long j3;
        i iVar = new i(this.b, j, -1, C.TIME_UNSET, null);
        i floor = this.c.floor(iVar);
        if (floor != null && floor.position + floor.length > j) {
            return floor;
        }
        i ceiling = this.c.ceiling(iVar);
        if (ceiling != null) {
            long j4 = ceiling.position - j;
            if (j2 == -1) {
                j3 = j4;
                return new i(this.b, j, j3, C.TIME_UNSET, null);
            }
            j2 = Math.min(j4, j2);
        }
        j3 = j2;
        return new i(this.b, j, j3, C.TIME_UNSET, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        if ((r11 + r13) <= (r5 + r3)) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
        if (r11 >= r2.a) goto L_0x0021;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A[LOOP:0: B:1:0x0002->B:17:0x003b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(long r11, long r13) {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            java.util.ArrayList<a2.j.b.b.d1.i.e$a> r2 = r10.d
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x003e
            java.util.ArrayList<a2.j.b.b.d1.i.e$a> r2 = r10.d
            java.lang.Object r2 = r2.get(r1)
            a2.j.b.b.d1.i.e$a r2 = (a2.j.b.b.d1.i.e.a) r2
            long r3 = r2.b
            r5 = -1
            r7 = 1
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x0025
            long r2 = r2.a
            int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0023
        L_0x0021:
            r2 = 1
            goto L_0x0038
        L_0x0023:
            r2 = 0
            goto L_0x0038
        L_0x0025:
            int r8 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x002a
            goto L_0x0023
        L_0x002a:
            long r5 = r2.a
            int r2 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x0023
            long r8 = r11 + r13
            long r5 = r5 + r3
            int r2 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r2 > 0) goto L_0x0023
            goto L_0x0021
        L_0x0038:
            if (r2 == 0) goto L_0x003b
            return r7
        L_0x003b:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.d1.i.e.c(long, long):boolean");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.a != eVar.a || !this.b.equals(eVar.b) || !this.c.equals(eVar.c) || !this.e.equals(eVar.e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.e.hashCode() + a2.b.a.a.a.B0(this.b, this.a * 31, 31);
    }
}
