package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.wf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
public class xt {
    private final acb<String, xy> a = new acb<>();
    private final HashMap<String, yc> b = new HashMap<>();
    private final ya c = new ya() { // from class: com.yandex.metrica.impl.ob.xt.1
        @Override // com.yandex.metrica.impl.ob.ya
        public void a(@NonNull String str, @NonNull yb ybVar) {
            for (xy xyVar : a(str)) {
                xyVar.a(ybVar);
            }
        }

        @Override // com.yandex.metrica.impl.ob.ya
        public void a(@NonNull String str, @NonNull xv xvVar, @Nullable yb ybVar) {
            for (xy xyVar : a(str)) {
                xyVar.a(xvVar, ybVar);
            }
        }

        @NonNull
        public List<xy> a(@NonNull String str) {
            synchronized (xt.this.b) {
                Collection a3 = xt.this.a.a((acb) str);
                if (a3 == null) {
                    return new ArrayList();
                }
                return new ArrayList(a3);
            }
        }
    };

    public static final class a {
        public static final xt a = new xt();
    }

    public static final xt a() {
        return a.a;
    }

    @VisibleForTesting
    public yc b(@NonNull Context context, @NonNull fb fbVar, @NonNull wf.a aVar) {
        return new yc(context, fbVar.b(), aVar, this.c);
    }

    @VisibleForTesting
    public yc a(@NonNull Context context, @NonNull fb fbVar, @NonNull wf.a aVar) {
        yc ycVar = this.b.get(fbVar.b());
        boolean z = true;
        if (ycVar == null) {
            synchronized (this.b) {
                ycVar = this.b.get(fbVar.b());
                if (ycVar == null) {
                    yc b2 = b(context, fbVar, aVar);
                    this.b.put(fbVar.b(), b2);
                    ycVar = b2;
                    z = false;
                }
            }
        }
        if (z) {
            ycVar.a(aVar);
        }
        return ycVar;
    }

    @NonNull
    public yc a(@NonNull Context context, @NonNull fb fbVar, @NonNull xy xyVar, @NonNull wf.a aVar) {
        yc a3;
        synchronized (this.b) {
            this.a.a(fbVar.b(), xyVar);
            a3 = a(context, fbVar, aVar);
        }
        return a3;
    }
}
