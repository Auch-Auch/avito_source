package com.avito.android.serp.adapter.advert_xl;

import com.avito.android.remote.model.SerpAdvertXl;
import kotlin.Metadata;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class SerpAdvertXlConverterKt {
    public static final boolean access$isActive(SerpAdvertXl serpAdvertXl) {
        String status = serpAdvertXl.getStatus();
        if (status == null) {
            status = "active";
        }
        return m.equals("active", status, true);
    }
}
