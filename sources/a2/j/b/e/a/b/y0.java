package a2.j.b.e.a.b;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
public final /* synthetic */ class y0 implements h1 {
    public final i1 a;
    public final List b;

    public y0(i1 i1Var, List list) {
        this.a = i1Var;
        this.b = list;
    }

    @Override // a2.j.b.e.a.b.h1
    public final Object a() {
        i1 i1Var = this.a;
        List list = this.b;
        Objects.requireNonNull(i1Var);
        HashMap hashMap = new HashMap();
        for (f1 f1Var : i1Var.e.values()) {
            String str = f1Var.c.a;
            if (list.contains(str)) {
                f1 f1Var2 = (f1) hashMap.get(str);
                if ((f1Var2 != null ? f1Var2.a : -1) < f1Var.a) {
                    hashMap.put(str, f1Var);
                }
            }
        }
        return hashMap;
    }
}
