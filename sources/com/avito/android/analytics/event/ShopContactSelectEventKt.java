package com.avito.android.analytics.event;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002¨\u0006\u0004"}, d2 = {"", "PHONE_CONTACT", "Ljava/lang/String;", "WEB_CONTACT", "shop_release"}, k = 2, mv = {1, 4, 2})
public final class ShopContactSelectEventKt {
    @NotNull
    public static final String PHONE_CONTACT = "phone";
    @NotNull
    public static final String WEB_CONTACT = "web";

    public static final Map access$createParams(String str, String str2) {
        return r.mutableMapOf(TuplesKt.to("contact_type", str), TuplesKt.to("sid", str2));
    }
}
