package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import android.support.annotation.NonNull;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.mobile.ads.impl.am;
import com.yandex.mobile.ads.impl.bh;
import com.yandex.mobile.ads.impl.fo;
import java.util.Map;
public final class f extends bh {
    public f(@NonNull fo foVar) {
        super(foVar);
    }

    @Override // com.yandex.mobile.ads.impl.bh, com.yandex.mobile.ads.impl.bb
    @NonNull
    public final Map<String, Object> a(@NonNull Context context) {
        Map<String, Object> a = super.a(context);
        am b = this.a.b();
        if (b != null) {
            a.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, Integer.valueOf(b.b(context)));
            a.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, Integer.valueOf(b.a(context)));
        }
        return a;
    }
}
