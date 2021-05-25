package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.pc;
import java.util.Map;
public class wh implements wj<Map<pc.a, pc>> {
    @NonNull
    private final Map<pc.a, String> a;
    @NonNull
    private final Map<pc.a, String> b;

    public wh() {
        this(wg.a, wg.b);
    }

    public void a(@NonNull Uri.Builder builder, @NonNull Map<pc.a, pc> map) {
        pc.a[] values = pc.a.values();
        for (int i = 0; i < 2; i++) {
            pc.a aVar = values[i];
            String str = this.a.get(aVar);
            String str2 = this.b.get(aVar);
            pc pcVar = map.get(aVar);
            if (pcVar == null) {
                builder.appendQueryParameter(str, "");
                builder.appendQueryParameter(str2, "");
            } else {
                builder.appendQueryParameter(str, pcVar.b);
                builder.appendQueryParameter(str2, a(pcVar.c));
            }
        }
    }

    @VisibleForTesting
    public wh(@NonNull Map<pc.a, String> map, @NonNull Map<pc.a, String> map2) {
        this.a = map;
        this.b = map2;
    }

    @VisibleForTesting
    public static String a(Boolean bool) {
        if (bool == null) {
            return "";
        }
        return bool.booleanValue() ? "1" : "0";
    }
}
