package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.uu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
public class sa {
    @NonNull
    private final lz a;
    @NonNull
    private final ly b;
    @NonNull
    private final rx c;
    @NonNull
    private final rv d;

    public sa(@NonNull Context context) {
        this(lv.a(context).g(), lv.a(context).h(), new pr(context), new rw(), new ru());
    }

    private uu.b.a[] b(Map<Long, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            uu.b.a a3 = this.d.a(entry.getKey().longValue(), entry.getValue());
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return (uu.b.a[]) arrayList.toArray(new uu.b.a[arrayList.size()]);
    }

    public rz a(int i) {
        Map<Long, String> b2 = this.a.b(i);
        Map<Long, String> b3 = this.b.b(i);
        uu.b bVar = new uu.b();
        bVar.b = a(b2);
        bVar.c = b(b3);
        return new rz(b2.isEmpty() ? -1 : ((Long) Collections.max(b2.keySet())).longValue(), b3.isEmpty() ? -1 : ((Long) Collections.max(b3.keySet())).longValue(), bVar);
    }

    @VisibleForTesting
    public sa(@NonNull lz lzVar, @NonNull ly lyVar, @NonNull pr prVar, @NonNull rw rwVar, @NonNull ru ruVar) {
        this(lzVar, lyVar, new rx(prVar, rwVar), new rv(prVar, ruVar));
    }

    @VisibleForTesting
    public sa(@NonNull lz lzVar, @NonNull ly lyVar, @NonNull rx rxVar, @NonNull rv rvVar) {
        this.a = lzVar;
        this.b = lyVar;
        this.c = rxVar;
        this.d = rvVar;
    }

    public void a(rz rzVar) {
        long j = rzVar.a;
        if (j >= 0) {
            this.a.b(j);
        }
        long j2 = rzVar.b;
        if (j2 >= 0) {
            this.b.b(j2);
        }
    }

    private uu.b.C0342b[] a(Map<Long, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            uu.b.C0342b a3 = this.c.a(entry.getKey().longValue(), entry.getValue());
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return (uu.b.C0342b[]) arrayList.toArray(new uu.b.C0342b[arrayList.size()]);
    }
}
