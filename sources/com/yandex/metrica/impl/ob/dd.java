package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.yx;
import java.util.Collection;
import java.util.List;
import java.util.Map;
public class dd implements bz {
    @NonNull
    private final yc a;
    @NonNull
    private final wf b;
    @NonNull
    private final yw c;
    @NonNull
    private final ng d;

    public dd(@NonNull yc ycVar, @NonNull wf wfVar) {
        this(ycVar, wfVar, new yw(), new ng());
    }

    @Override // com.yandex.metrica.impl.ob.bz
    public boolean a(int i, byte[] bArr, @NonNull Map<String, List<String>> map) {
        if (200 != i) {
            return false;
        }
        List<String> list = map.get("Content-Encoding");
        if (!dl.a((Collection) list) && "encrypted".equals(list.get(0))) {
            bArr = this.d.a(bArr, "hBnBQbZrmjPXEWVJ");
        }
        if (bArr == null) {
            return false;
        }
        yx a3 = this.c.a(bArr);
        if (yx.a.OK != a3.k()) {
            return false;
        }
        this.a.a(a3, this.b, map);
        return true;
    }

    @VisibleForTesting
    public dd(@NonNull yc ycVar, @NonNull wf wfVar, @NonNull yw ywVar, @NonNull ng ngVar) {
        this.a = ycVar;
        this.b = wfVar;
        this.c = ywVar;
        this.d = ngVar;
    }
}
