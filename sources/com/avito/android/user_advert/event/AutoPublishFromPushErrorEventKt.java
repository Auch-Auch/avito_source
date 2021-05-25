package com.avito.android.user_advert.event;

import androidx.core.app.NotificationCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"user-advert_release"}, k = 2, mv = {1, 4, 2})
public final class AutoPublishFromPushErrorEventKt {
    public static final Map access$createParams(String str, String str2, Integer num) {
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to("iid", str));
        if (num != null) {
            mutableMapOf.put(NotificationCompat.CATEGORY_ERROR, num);
        }
        if (str2 != null) {
            mutableMapOf.put("errors_detailed", str2);
        }
        return mutableMapOf;
    }
}
