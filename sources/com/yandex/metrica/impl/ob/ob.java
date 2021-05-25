package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.vd;
import java.util.ArrayList;
import java.util.List;
public class ob implements nh<wr, vd.a> {
    @NonNull
    /* renamed from: a */
    public vd.a b(@NonNull wr wrVar) {
        vd.a aVar = new vd.a();
        aVar.b = new vd.a.C0351a[wrVar.a.size()];
        for (int i = 0; i < wrVar.a.size(); i++) {
            aVar.b[i] = a(wrVar.a.get(i));
        }
        aVar.c = wrVar.b;
        aVar.d = wrVar.c;
        aVar.e = wrVar.d;
        aVar.f = wrVar.e;
        return aVar;
    }

    @NonNull
    public wr a(@NonNull vd.a aVar) {
        ArrayList arrayList = new ArrayList(aVar.b.length);
        int i = 0;
        while (true) {
            vd.a.C0351a[] aVarArr = aVar.b;
            if (i >= aVarArr.length) {
                return new wr(arrayList, aVar.c, aVar.d, aVar.e, aVar.f);
            }
            arrayList.add(a(aVarArr[i]));
            i++;
        }
    }

    @NonNull
    private vd.a.C0351a a(@NonNull wu wuVar) {
        vd.a.C0351a aVar = new vd.a.C0351a();
        aVar.b = wuVar.a;
        List<String> list = wuVar.b;
        aVar.c = new String[list.size()];
        int i = 0;
        for (String str : list) {
            aVar.c[i] = str;
            i++;
        }
        return aVar;
    }

    @NonNull
    private wu a(@NonNull vd.a.C0351a aVar) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = aVar.c;
        if (strArr != null && strArr.length > 0) {
            arrayList = new ArrayList(aVar.c.length);
            int i = 0;
            while (true) {
                String[] strArr2 = aVar.c;
                if (i >= strArr2.length) {
                    break;
                }
                arrayList.add(strArr2[i]);
                i++;
            }
        }
        return new wu(dh.a(aVar.b), arrayList);
    }
}
