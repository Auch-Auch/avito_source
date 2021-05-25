package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public final class ng {
    public static void a(@NonNull p pVar, @NonNull Map<String, Bitmap> map) {
        for (ox oxVar : pVar.c().c()) {
            List<oq> c = oxVar.c();
            if (c != null && !c.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (oq oqVar : c) {
                    Object c2 = oqVar.c();
                    String b = oqVar.b();
                    if (!"image".equals(b) || !(c2 instanceof ot)) {
                        if ("media".equals(b) && (c2 instanceof ow) && ((ow) c2).b() != null) {
                            ot b2 = ((ow) c2).b();
                            if (b2 != null && a(b2, map)) {
                                arrayList.add(oqVar);
                            }
                        } else {
                            arrayList.add(oqVar);
                        }
                    } else if (a((ot) c2, map)) {
                        arrayList.add(oqVar);
                    }
                }
                oxVar.a(arrayList);
            }
        }
    }

    private static boolean a(@NonNull ot otVar, @NonNull Map<String, Bitmap> map) {
        return a(map.get(otVar.c()));
    }

    private static boolean a(@Nullable Bitmap bitmap) {
        return bitmap != null && bitmap.getWidth() > 1 && bitmap.getHeight() > 1;
    }
}
