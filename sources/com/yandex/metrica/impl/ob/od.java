package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
import com.yandex.metrica.impl.ob.yb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class od implements np<yb, ve.a> {
    private ns a = new ns();
    private nu b = new nu();
    private oc c = new oc();
    private nx d = new nx();
    private nz e = new nz();
    private ni f = new ni();
    private nv g = new nv();
    private oe h = new oe();
    private oa i = new oa();
    private nn j = new nn();
    private of k = new of();
    private on l = new on();
    private om m = new om();

    @NonNull
    /* renamed from: a */
    public ve.a b(@NonNull yb ybVar) {
        ve.a aVar = new ve.a();
        aVar.C = ybVar.F;
        aVar.D = ybVar.G;
        aVar.k = new ve.a.d[ybVar.p.size()];
        int i2 = 0;
        for (qm qmVar : ybVar.p) {
            aVar.k[i2] = this.a.b(qmVar);
            i2++;
        }
        String str = ybVar.a;
        if (str != null) {
            aVar.b = str;
        }
        String str2 = ybVar.b;
        if (str2 != null) {
            aVar.y = str2;
        }
        String str3 = ybVar.c;
        if (str3 != null) {
            aVar.A = str3;
        }
        String str4 = ybVar.d;
        if (str4 != null) {
            aVar.z = str4;
        }
        List<String> list = ybVar.j;
        if (list != null) {
            aVar.h = (String[]) list.toArray(new String[list.size()]);
        }
        List<String> list2 = ybVar.k;
        if (list2 != null) {
            aVar.i = (String[]) list2.toArray(new String[list2.size()]);
        }
        List<String> list3 = ybVar.e;
        if (list3 != null) {
            aVar.d = (String[]) list3.toArray(new String[list3.size()]);
        }
        List<String> list4 = ybVar.i;
        if (list4 != null) {
            aVar.g = (String[]) list4.toArray(new String[list4.size()]);
        }
        List<String> list5 = ybVar.l;
        if (list5 != null) {
            aVar.t = (String[]) list5.toArray(new String[list5.size()]);
        }
        rr rrVar = ybVar.q;
        if (rrVar != null) {
            aVar.l = this.b.b(rrVar);
        }
        xs xsVar = ybVar.r;
        if (xsVar != null) {
            aVar.m = this.c.b(xsVar);
        }
        xo xoVar = ybVar.A;
        if (xoVar != null) {
            aVar.F = this.d.b(xoVar);
        }
        String str5 = ybVar.m;
        if (str5 != null) {
            aVar.o = str5;
        }
        String str6 = ybVar.f;
        if (str6 != null) {
            aVar.e = str6;
        }
        String str7 = ybVar.g;
        if (str7 != null) {
            aVar.f = str7;
        }
        String str8 = ybVar.h;
        if (str8 != null) {
            aVar.B = str8;
        }
        String str9 = ybVar.s;
        if (str9 != null) {
            aVar.r = str9;
        }
        String str10 = ybVar.t;
        if (str10 != null) {
            aVar.N = str10;
        }
        aVar.j = this.f.b(ybVar.o);
        String str11 = ybVar.n;
        if (str11 != null) {
            aVar.p = str11;
        }
        aVar.q = ybVar.w;
        aVar.c = ybVar.u;
        aVar.v = ybVar.v;
        xq xqVar = ybVar.E;
        aVar.I = xqVar.a;
        aVar.J = xqVar.b;
        List<xp> list6 = ybVar.x;
        if (list6 != null) {
            aVar.n = a(list6);
        }
        String str12 = ybVar.y;
        if (str12 != null) {
            aVar.s = str12;
        }
        List<sr> list7 = ybVar.B;
        if (list7 != null) {
            aVar.w = this.g.b(list7);
        }
        xr xrVar = ybVar.C;
        if (xrVar != null) {
            aVar.x = this.i.b(xrVar);
        }
        yd ydVar = ybVar.z;
        if (ydVar != null) {
            aVar.u = this.h.b(ydVar);
        }
        aVar.E = ybVar.H;
        xn xnVar = ybVar.D;
        if (xnVar != null) {
            aVar.G = this.j.b(xnVar);
        }
        xi xiVar = ybVar.I;
        if (xiVar != null) {
            aVar.H = this.k.b(xiVar);
        }
        aap aap = ybVar.J;
        if (aap != null) {
            aVar.K = this.l.b(aap);
        }
        aah aah = ybVar.K;
        if (aah != null) {
            aVar.M = this.m.b(aah);
        }
        aah aah2 = ybVar.L;
        if (aah2 != null) {
            aVar.L = this.m.b(aah2);
        }
        return aVar;
    }

    @NonNull
    public yb a(@NonNull ve.a aVar) {
        yb.a a3 = new yb.a(this.f.a(aVar.j)).a(aVar.b).b(aVar.y).c(aVar.A).d(aVar.z).h(aVar.o).e(aVar.e).a(Arrays.asList(aVar.d)).b(Arrays.asList(aVar.g)).d(Arrays.asList(aVar.i)).c(Arrays.asList(aVar.h)).f(aVar.f).g(aVar.B).e(Arrays.asList(aVar.t)).j(aVar.r).k(aVar.N).i(aVar.p).b(aVar.q).a(aVar.c).a(aVar.v).g(a(aVar.n)).b(aVar.C).c(aVar.D).l(aVar.s).c(aVar.E).a(new xq(aVar.I, aVar.J));
        if (aVar.k != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                ve.a.d[] dVarArr = aVar.k;
                if (i2 >= dVarArr.length) {
                    break;
                }
                arrayList.add(this.a.a(dVarArr[i2]));
                i2++;
            }
            a3.f(arrayList);
        }
        ve.a.m mVar = aVar.l;
        if (mVar != null) {
            a3.a(this.b.a(mVar));
        }
        ve.a.i iVar = aVar.m;
        if (iVar != null) {
            a3.a(this.c.a(iVar));
        }
        ve.a.f fVar = aVar.F;
        if (fVar != null) {
            a3.a(this.d.a(fVar));
        }
        ve.a.e[] eVarArr = aVar.w;
        if (eVarArr != null) {
            a3.h(this.g.a(eVarArr));
        }
        ve.a.h hVar = aVar.x;
        if (hVar != null) {
            a3.a(this.i.a(hVar));
        }
        ve.a.j jVar = aVar.u;
        if (jVar != null) {
            a3.a(this.h.a(jVar));
        }
        ve.a.c cVar = aVar.G;
        if (cVar != null) {
            a3.a(this.j.a(cVar));
        }
        ve.a.C0352a aVar2 = aVar.H;
        if (aVar2 != null) {
            a3.a(this.k.a(aVar2));
        }
        ve.a.l lVar = aVar.K;
        if (lVar != null) {
            a3.a(this.l.a(lVar));
        }
        ve.a.k kVar = aVar.M;
        if (kVar != null) {
            a3.a(this.m.a(kVar));
        }
        ve.a.k kVar2 = aVar.L;
        if (kVar2 != null) {
            a3.b(this.m.a(kVar2));
        }
        return a3.a();
    }

    @NonNull
    private ve.a.g[] a(@NonNull List<xp> list) {
        ve.a.g[] gVarArr = new ve.a.g[list.size()];
        int i2 = 0;
        for (xp xpVar : list) {
            gVarArr[i2] = this.e.b(xpVar);
            i2++;
        }
        return gVarArr;
    }

    @NonNull
    private List<xp> a(@NonNull ve.a.g[] gVarArr) {
        ArrayList arrayList = new ArrayList(gVarArr.length);
        for (ve.a.g gVar : gVarArr) {
            arrayList.add(this.e.a(gVar));
        }
        return arrayList;
    }
}
