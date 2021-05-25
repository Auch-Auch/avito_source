package a2.g.k;

import com.facebook.internal.Utility;
import java.io.Serializable;
public class a implements Serializable {
    private static final long serialVersionUID = 1;
    public final String a;
    public final String b;

    public static class b implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        public final String a;
        public final String b;

        public b(String str, String str2, C0025a aVar) {
            this.a = str;
            this.b = str2;
        }

        private Object readResolve() {
            return new a(this.a, this.b);
        }
    }

    public a(String str, String str2) {
        this.a = Utility.isNullOrEmpty(str) ? null : str;
        this.b = str2;
    }

    private Object writeReplace() {
        return new b(this.a, this.b, null);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!Utility.areObjectsEqual(aVar.a, this.a) || !Utility.areObjectsEqual(aVar.b, this.b)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode ^ i;
    }
}
