package a2.j.k.g.e.b;

import com.avito.android.BuildConfig;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
public final class a {
    public final DataCharacter a;
    public final DataCharacter b;
    public final FinderPattern c;

    public a(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern, boolean z) {
        this.a = dataCharacter;
        this.b = dataCharacter2;
        this.c = finderPattern;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!a(this.a, aVar.a) || !a(this.b, aVar.b) || !a(this.c, aVar.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (b(this.a) ^ b(this.b)) ^ b(this.c);
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.a);
        sb.append(" , ");
        sb.append(this.b);
        sb.append(" : ");
        FinderPattern finderPattern = this.c;
        if (finderPattern == null) {
            obj = BuildConfig.ADJUST_DEFAULT_TRACKER;
        } else {
            obj = Integer.valueOf(finderPattern.getValue());
        }
        return a2.b.a.a.a.r(sb, obj, " ]");
    }
}
