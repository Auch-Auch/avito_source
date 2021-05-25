package a2.e.a;

import a2.e.a.f;
import com.caverock.androidsvg.SVG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
public class b {
    public f a = null;
    public u b = null;
    public boolean c = false;

    /* renamed from: a2.e.a.b$b  reason: collision with other inner class name */
    public static class C0020b {
        public final String a;
        public final c b;
        public final String c;

        public C0020b(String str, c cVar, String str2) {
            this.a = str;
            this.b = cVar;
            this.c = str2;
        }
    }

    public enum c {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    public static class d extends f.i {

        public static class a {
            public int a;
            public int b;

            public a(int i, int i2) {
                this.a = i;
                this.b = i2;
            }
        }

        public d(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        public final int s(int i) {
            if (i >= 48 && i <= 57) {
                return i - 48;
            }
            int i2 = 65;
            if (i < 65 || i > 70) {
                i2 = 97;
                if (i < 97 || i > 102) {
                    return -1;
                }
            }
            return (i - i2) + 10;
        }

        public String t() {
            int s;
            if (f()) {
                return null;
            }
            char charAt = this.a.charAt(this.b);
            if (!(charAt == '\'' || charAt == '\"')) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.b++;
            int intValue = h().intValue();
            while (intValue != -1 && intValue != charAt) {
                if (intValue == 92) {
                    intValue = h().intValue();
                    if (intValue != -1) {
                        if (intValue == 10 || intValue == 13 || intValue == 12) {
                            intValue = h().intValue();
                        } else {
                            int s2 = s(intValue);
                            if (s2 != -1) {
                                for (int i = 1; i <= 5 && (s = s((intValue = h().intValue()))) != -1; i++) {
                                    s2 = (s2 * 16) + s;
                                }
                                sb.append((char) s2);
                            }
                        }
                    }
                }
                sb.append((char) intValue);
                intValue = h().intValue();
            }
            return sb.toString();
        }

        public String u() {
            int i;
            int i2;
            if (f()) {
                i = this.b;
            } else {
                int i3 = this.b;
                int charAt = this.a.charAt(i3);
                if (charAt == 45) {
                    charAt = a();
                }
                if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                    i2 = i3;
                } else {
                    int a3 = a();
                    while (true) {
                        if ((a3 < 65 || a3 > 90) && ((a3 < 97 || a3 > 122) && !((a3 >= 48 && a3 <= 57) || a3 == 45 || a3 == 95))) {
                            break;
                        }
                        a3 = a();
                    }
                    i2 = this.b;
                }
                this.b = i3;
                i = i2;
            }
            int i4 = this.b;
            if (i == i4) {
                return null;
            }
            String substring = this.a.substring(i4, i);
            this.b = i;
            return substring;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:290:0x007e */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x008c */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x00b2 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x00dd */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:293:0x0244 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:275:0x0471 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:286:0x007e */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX DEBUG: Type inference failed for r3v7. Raw type applied. Possible types: java.util.List<a2.e.a.b$t>, java.util.List */
        /* JADX WARN: Type inference failed for: r7v2, types: [a2.e.a.b$e] */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r8v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v5, types: [a2.e.a.b$a, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19, types: [a2.e.a.b$t] */
        /* JADX WARN: Type inference failed for: r2v21, types: [a2.e.a.b$t] */
        /* JADX WARN: Type inference failed for: r2v22, types: [a2.e.a.b$t] */
        /* JADX WARN: Type inference failed for: r2v24, types: [a2.e.a.b$t] */
        /* JADX WARN: Type inference failed for: r2v25, types: [a2.e.a.b$t] */
        /* JADX WARN: Type inference failed for: r2v26, types: [a2.e.a.b$t] */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r3v47, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v49 */
        /* JADX WARN: Type inference failed for: r8v26 */
        /* JADX WARN: Type inference failed for: r3v56 */
        /* JADX WARN: Type inference failed for: r9v22, types: [a2.e.a.b$t] */
        /* JADX WARN: Type inference failed for: r8v29 */
        /* JADX WARN: Type inference failed for: r3v57 */
        /* JADX WARN: Type inference failed for: r3v58 */
        /* JADX WARN: Type inference failed for: r8v31 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v7, types: [a2.e.a.b$e] */
        /* JADX WARN: Type inference failed for: r7v8, types: [a2.e.a.b$e] */
        /* JADX WARNING: Removed duplicated region for block: B:226:0x03e6  */
        /* JADX WARNING: Removed duplicated region for block: B:229:0x03eb  */
        /* JADX WARNING: Removed duplicated region for block: B:243:0x0445  */
        /* JADX WARNING: Removed duplicated region for block: B:247:0x0457  */
        /* JADX WARNING: Removed duplicated region for block: B:250:0x045e  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:262:0x0484  */
        /* JADX WARNING: Removed duplicated region for block: B:266:0x0474 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:274:0x03ff A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0084  */
        /* JADX WARNING: Unknown variable types count: 4 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<a2.e.a.b.s> v() throws a2.e.a.a {
            /*
            // Method dump skipped, instructions count: 1212
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.e.a.b.d.v():java.util.List");
        }
    }

    public enum e {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    public enum f {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    public interface g {
        boolean a(q qVar, SVG.j0 j0Var);
    }

    public static class h implements g {
        public int a;
        public int b;
        public boolean c;
        public boolean d;
        public String e;

        public h(int i, int i2, boolean z, boolean z2, String str) {
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = z2;
            this.e = str;
        }

        @Override // a2.e.a.b.g
        public boolean a(q qVar, SVG.j0 j0Var) {
            int i;
            int i2;
            String m = (!this.d || this.e != null) ? this.e : j0Var.m();
            SVG.h0 h0Var = j0Var.b;
            if (h0Var != null) {
                Iterator<SVG.l0> it = h0Var.getChildren().iterator();
                i2 = 0;
                i = 0;
                while (it.hasNext()) {
                    SVG.j0 j0Var2 = (SVG.j0) it.next();
                    if (j0Var2 == j0Var) {
                        i2 = i;
                    }
                    if (m == null || j0Var2.m().equals(m)) {
                        i++;
                    }
                }
            } else {
                i2 = 0;
                i = 1;
            }
            int i3 = this.c ? i2 + 1 : i - i2;
            int i4 = this.a;
            if (i4 != 0) {
                int i5 = this.b;
                if ((i3 - i5) % i4 != 0) {
                    return false;
                }
                if (Integer.signum(i3 - i5) == 0 || Integer.signum(i3 - this.b) == Integer.signum(this.a)) {
                    return true;
                }
                return false;
            } else if (i3 == this.b) {
                return true;
            } else {
                return false;
            }
        }

        public String toString() {
            String str = this.c ? "" : "last-";
            if (this.d) {
                return String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.e);
            }
            return String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.a), Integer.valueOf(this.b));
        }
    }

    public static class i implements g {
        public i(a aVar) {
        }

        @Override // a2.e.a.b.g
        public boolean a(q qVar, SVG.j0 j0Var) {
            if (!(j0Var instanceof SVG.h0) || ((SVG.h0) j0Var).getChildren().size() == 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "empty";
        }
    }

    public enum j {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;
        
        public static final Map<String, j> z = new HashMap();

        /* access modifiers changed from: public */
        static {
            j[] values = values();
            for (int i = 0; i < 25; i++) {
                j jVar = values[i];
                if (jVar != UNSUPPORTED) {
                    z.put(jVar.name().replace('_', '-'), jVar);
                }
            }
        }
    }

    public static class k implements g {
        public List<s> a;

        public k(List<s> list) {
            this.a = list;
        }

        @Override // a2.e.a.b.g
        public boolean a(q qVar, SVG.j0 j0Var) {
            for (s sVar : this.a) {
                if (b.i(qVar, sVar, j0Var)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return a2.b.a.a.a.w(a2.b.a.a.a.L("not("), this.a, ")");
        }
    }

    public static class l implements g {
        public String a;

        public l(String str) {
            this.a = str;
        }

        @Override // a2.e.a.b.g
        public boolean a(q qVar, SVG.j0 j0Var) {
            return false;
        }

        public String toString() {
            return this.a;
        }
    }

    public static class m implements g {
        public boolean a;
        public String b;

        public m(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        @Override // a2.e.a.b.g
        public boolean a(q qVar, SVG.j0 j0Var) {
            int i;
            String m = (!this.a || this.b != null) ? this.b : j0Var.m();
            SVG.h0 h0Var = j0Var.b;
            if (h0Var != null) {
                Iterator<SVG.l0> it = h0Var.getChildren().iterator();
                i = 0;
                while (it.hasNext()) {
                    SVG.j0 j0Var2 = (SVG.j0) it.next();
                    if (m == null || j0Var2.m().equals(m)) {
                        i++;
                    }
                }
            } else {
                i = 1;
            }
            if (i == 1) {
                return true;
            }
            return false;
        }

        public String toString() {
            if (this.a) {
                return String.format("only-of-type <%s>", this.b);
            }
            return String.format("only-child", new Object[0]);
        }
    }

    public static class n implements g {
        public n(a aVar) {
        }

        @Override // a2.e.a.b.g
        public boolean a(q qVar, SVG.j0 j0Var) {
            return j0Var.b == null;
        }

        public String toString() {
            return "root";
        }
    }

    public static class o implements g {
        public o(a aVar) {
        }

        @Override // a2.e.a.b.g
        public boolean a(q qVar, SVG.j0 j0Var) {
            return qVar != null && j0Var == qVar.a;
        }

        public String toString() {
            return "target";
        }
    }

    public static class p {
        public s a = null;
        public SVG.Style b = null;
        public u c;

        public p(s sVar, SVG.Style style, u uVar) {
            this.a = sVar;
            this.b = style;
            this.c = uVar;
        }

        public String toString() {
            return String.valueOf(this.a) + " {...} (src=" + this.c + ")";
        }
    }

    public static class q {
        public SVG.j0 a;

        public String toString() {
            SVG.j0 j0Var = this.a;
            return j0Var != null ? String.format("<%s id=\"%s\">", j0Var.m(), this.a.c) : "";
        }
    }

    public static class r {
        public List<p> a = null;

        public void a(p pVar) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            for (int i = 0; i < this.a.size(); i++) {
                if (this.a.get(i).a.b > pVar.a.b) {
                    this.a.add(i, pVar);
                    return;
                }
            }
            this.a.add(pVar);
        }

        public void b(r rVar) {
            if (rVar.a != null) {
                if (this.a == null) {
                    this.a = new ArrayList(rVar.a.size());
                }
                for (p pVar : rVar.a) {
                    a(pVar);
                }
            }
        }

        public String toString() {
            if (this.a == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (p pVar : this.a) {
                sb.append(pVar.toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    public static class t {
        public e a = null;
        public String b = null;
        public List<C0020b> c = null;
        public List<g> d = null;

        public t(e eVar, String str) {
            this.a = eVar == null ? e.DESCENDANT : eVar;
            this.b = str;
        }

        public void a(String str, c cVar, String str2) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(new C0020b(str, cVar, str2));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            e eVar = this.a;
            if (eVar == e.CHILD) {
                sb.append("> ");
            } else if (eVar == e.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.b;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            List<C0020b> list = this.c;
            if (list != null) {
                for (C0020b bVar : list) {
                    sb.append('[');
                    sb.append(bVar.a);
                    int ordinal = bVar.b.ordinal();
                    if (ordinal == 1) {
                        sb.append('=');
                        sb.append(bVar.c);
                    } else if (ordinal == 2) {
                        sb.append("~=");
                        sb.append(bVar.c);
                    } else if (ordinal == 3) {
                        sb.append("|=");
                        sb.append(bVar.c);
                    }
                    sb.append(']');
                }
            }
            List<g> list2 = this.d;
            if (list2 != null) {
                for (g gVar : list2) {
                    sb.append(':');
                    sb.append(gVar);
                }
            }
            return sb.toString();
        }
    }

    public enum u {
        Document,
        RenderOptions
    }

    public b(u uVar) {
        f fVar = f.screen;
        this.a = fVar;
        this.b = uVar;
    }

    public static int a(List<SVG.h0> list, int i2, SVG.j0 j0Var) {
        int i3 = 0;
        if (i2 < 0) {
            return 0;
        }
        SVG.h0 h0Var = list.get(i2);
        SVG.h0 h0Var2 = j0Var.b;
        if (h0Var != h0Var2) {
            return -1;
        }
        for (SVG.l0 l0Var : h0Var2.getChildren()) {
            if (l0Var == j0Var) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static boolean b(List<f> list, f fVar) {
        for (f fVar2 : list) {
            if (fVar2 == f.all) {
                return true;
            }
            if (fVar2 == fVar) {
                return true;
            }
        }
        return false;
    }

    public static List<f> e(d dVar) {
        ArrayList arrayList = new ArrayList();
        while (!dVar.f()) {
            String str = null;
            if (!dVar.f()) {
                int i2 = dVar.b;
                char charAt = dVar.a.charAt(i2);
                if ((charAt < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z')) {
                    dVar.b = i2;
                } else {
                    int a3 = dVar.a();
                    while (true) {
                        if ((a3 < 65 || a3 > 90) && (a3 < 97 || a3 > 122)) {
                            break;
                        }
                        a3 = dVar.a();
                    }
                    str = dVar.a.substring(i2, dVar.b);
                }
            }
            if (str != null) {
                try {
                    arrayList.add(f.valueOf(str));
                } catch (IllegalArgumentException unused) {
                }
                if (!dVar.q()) {
                    break;
                }
            } else {
                break;
            }
        }
        return arrayList;
    }

    public static boolean h(q qVar, s sVar, int i2, List<SVG.h0> list, int i3, SVG.j0 j0Var) {
        t tVar = sVar.a.get(i2);
        if (!k(qVar, tVar, j0Var)) {
            return false;
        }
        e eVar = tVar.a;
        if (eVar == e.DESCENDANT) {
            if (i2 == 0) {
                return true;
            }
            while (i3 >= 0) {
                if (j(qVar, sVar, i2 - 1, list, i3)) {
                    return true;
                }
                i3--;
            }
            return false;
        } else if (eVar == e.CHILD) {
            return j(qVar, sVar, i2 - 1, list, i3);
        } else {
            int a3 = a(list, i3, j0Var);
            if (a3 <= 0) {
                return false;
            }
            return h(qVar, sVar, i2 - 1, list, i3, (SVG.j0) j0Var.b.getChildren().get(a3 - 1));
        }
    }

    public static boolean i(q qVar, s sVar, SVG.j0 j0Var) {
        int i2;
        ArrayList arrayList = new ArrayList();
        SVG.h0 h0Var = j0Var.b;
        while (true) {
            i2 = 0;
            if (h0Var == null) {
                break;
            }
            arrayList.add(0, h0Var);
            h0Var = ((SVG.l0) h0Var).b;
        }
        int size = arrayList.size() - 1;
        List<t> list = sVar.a;
        if ((list == null ? 0 : list.size()) == 1) {
            return k(qVar, sVar.b(0), j0Var);
        }
        List<t> list2 = sVar.a;
        if (list2 != null) {
            i2 = list2.size();
        }
        return h(qVar, sVar, i2 - 1, arrayList, size, j0Var);
    }

    public static boolean j(q qVar, s sVar, int i2, List<SVG.h0> list, int i3) {
        t tVar = sVar.a.get(i2);
        SVG.j0 j0Var = (SVG.j0) list.get(i3);
        if (!k(qVar, tVar, j0Var)) {
            return false;
        }
        e eVar = tVar.a;
        if (eVar == e.DESCENDANT) {
            if (i2 == 0) {
                return true;
            }
            while (i3 > 0) {
                i3--;
                if (j(qVar, sVar, i2 - 1, list, i3)) {
                    return true;
                }
            }
            return false;
        } else if (eVar == e.CHILD) {
            return j(qVar, sVar, i2 - 1, list, i3 - 1);
        } else {
            int a3 = a(list, i3, j0Var);
            if (a3 <= 0) {
                return false;
            }
            return h(qVar, sVar, i2 - 1, list, i3, (SVG.j0) j0Var.b.getChildren().get(a3 - 1));
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (La2/e/a/b$q;La2/e/a/b$t;Ljava/util/List<Lcom/caverock/androidsvg/SVG$h0;>;ILcom/caverock/androidsvg/SVG$j0;)Z */
    public static boolean k(q qVar, t tVar, SVG.j0 j0Var) {
        List<String> list;
        String str = tVar.b;
        if (!(str == null || str.equals(j0Var.m().toLowerCase(Locale.US)))) {
            return false;
        }
        List<C0020b> list2 = tVar.c;
        if (list2 != null) {
            for (C0020b bVar : list2) {
                String str2 = bVar.a;
                str2.hashCode();
                if (!str2.equals("id")) {
                    if (!(str2.equals("class") && (list = j0Var.g) != null && list.contains(bVar.c))) {
                        return false;
                    }
                } else if (!bVar.c.equals(j0Var.c)) {
                    return false;
                }
            }
        }
        List<g> list3 = tVar.d;
        if (list3 == null) {
            return true;
        }
        for (g gVar : list3) {
            if (!gVar.a(qVar, j0Var)) {
                return false;
            }
        }
        return true;
    }

    public r c(String str) {
        d dVar = new d(str);
        dVar.r();
        return g(dVar);
    }

    public final void d(r rVar, d dVar) throws a {
        int intValue;
        char charAt;
        int s2;
        String u2 = dVar.u();
        dVar.r();
        if (u2 != null) {
            int i2 = 0;
            if (!this.c && u2.equals("media")) {
                List<f> e2 = e(dVar);
                if (dVar.d('{')) {
                    dVar.r();
                    if (b(e2, this.a)) {
                        this.c = true;
                        rVar.b(g(dVar));
                        this.c = false;
                    } else {
                        g(dVar);
                    }
                    if (!dVar.f() && !dVar.d('}')) {
                        throw new a("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new a("Invalid @media rule: missing rule set");
                }
            } else if (this.c || !u2.equals("import")) {
                String.format("Ignoring @%s rule", u2);
                while (!dVar.f() && ((intValue = dVar.h().intValue()) != 59 || i2 != 0)) {
                    if (intValue != 123) {
                        if (intValue == 125 && i2 > 0 && i2 - 1 == 0) {
                            break;
                        }
                    } else {
                        i2++;
                    }
                }
            } else {
                String str = null;
                if (!dVar.f()) {
                    int i3 = dVar.b;
                    if (dVar.e("url(")) {
                        dVar.r();
                        String t2 = dVar.t();
                        if (t2 == null) {
                            StringBuilder sb = new StringBuilder();
                            while (!dVar.f() && (charAt = dVar.a.charAt(dVar.b)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !dVar.g(charAt) && !Character.isISOControl((int) charAt)) {
                                dVar.b++;
                                if (charAt == '\\') {
                                    if (!dVar.f()) {
                                        String str2 = dVar.a;
                                        int i4 = dVar.b;
                                        dVar.b = i4 + 1;
                                        charAt = str2.charAt(i4);
                                        if (!(charAt == '\n' || charAt == '\r' || charAt == '\f')) {
                                            int s3 = dVar.s(charAt);
                                            if (s3 != -1) {
                                                for (int i5 = 1; i5 <= 5 && !dVar.f() && (s2 = dVar.s(dVar.a.charAt(dVar.b))) != -1; i5++) {
                                                    dVar.b++;
                                                    s3 = (s3 * 16) + s2;
                                                }
                                                sb.append((char) s3);
                                            }
                                        }
                                    }
                                }
                                sb.append((char) charAt);
                            }
                            t2 = sb.length() == 0 ? null : sb.toString();
                        }
                        if (t2 == null) {
                            dVar.b = i3;
                        } else {
                            dVar.r();
                            if (dVar.f() || dVar.e(")")) {
                                str = t2;
                            } else {
                                dVar.b = i3;
                            }
                        }
                    }
                }
                if (str == null) {
                    str = dVar.t();
                }
                if (str != null) {
                    dVar.r();
                    List<f> e3 = e(dVar);
                    if (!dVar.f() && !dVar.d(';')) {
                        throw new a("Invalid @media rule: expected '}' at end of rule set");
                    } else if (SVG.g != null && b(e3, this.a)) {
                        String resolveCSSStyleSheet = SVG.g.resolveCSSStyleSheet(str);
                        if (resolveCSSStyleSheet != null) {
                            rVar.b(c(resolveCSSStyleSheet));
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new a("Invalid @import rule: expected string or url()");
                }
            }
            dVar.r();
            return;
        }
        throw new a("Invalid '@' rule");
    }

    public final boolean f(r rVar, d dVar) throws a {
        List<s> v = dVar.v();
        if (v == null || v.isEmpty()) {
            return false;
        }
        if (dVar.d('{')) {
            dVar.r();
            SVG.Style style = new SVG.Style();
            do {
                String u2 = dVar.u();
                dVar.r();
                if (dVar.d(':')) {
                    dVar.r();
                    String str = null;
                    if (!dVar.f()) {
                        int i2 = dVar.b;
                        int charAt = dVar.a.charAt(i2);
                        int i3 = i2;
                        while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33) {
                            if (charAt == 10 || charAt == 13) {
                                break;
                            }
                            if (!dVar.g(charAt)) {
                                i3 = dVar.b + 1;
                            }
                            charAt = dVar.a();
                        }
                        if (dVar.b > i2) {
                            str = dVar.a.substring(i2, i3);
                        } else {
                            dVar.b = i2;
                        }
                    }
                    if (str != null) {
                        dVar.r();
                        if (dVar.d('!')) {
                            dVar.r();
                            if (dVar.e("important")) {
                                dVar.r();
                            } else {
                                throw new a("Malformed rule set: found unexpected '!'");
                            }
                        }
                        dVar.d(';');
                        f.J(style, u2, str);
                        dVar.r();
                        if (dVar.f()) {
                            break;
                        }
                    } else {
                        throw new a("Expected property value");
                    }
                } else {
                    throw new a("Expected ':'");
                }
            } while (!dVar.d('}'));
            dVar.r();
            for (s sVar : v) {
                rVar.a(new p(sVar, style, this.b));
            }
            return true;
        }
        throw new a("Malformed rule block: expected '{'");
    }

    public final r g(d dVar) {
        r rVar = new r();
        while (!dVar.f()) {
            try {
                if (!dVar.e("<!--")) {
                    if (!dVar.e("-->")) {
                        if (!dVar.d('@')) {
                            if (!f(rVar, dVar)) {
                                break;
                            }
                        } else {
                            d(rVar, dVar);
                        }
                    }
                }
            } catch (a e2) {
                e2.getMessage();
            }
        }
        return rVar;
    }

    public static class s {
        public List<t> a = null;
        public int b = 0;

        public s() {
        }

        public void a() {
            this.b += 1000;
        }

        public t b(int i) {
            return this.a.get(i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (t tVar : this.a) {
                sb.append(tVar);
                sb.append(' ');
            }
            sb.append('[');
            return a2.b.a.a.a.i(sb, this.b, ']');
        }

        public s(a aVar) {
        }
    }

    public b(f fVar, u uVar) {
        this.a = fVar;
        this.b = uVar;
    }
}
