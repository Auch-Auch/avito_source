package com.yandex.mobile.ads.video.models.vmap;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.video.models.common.Extension;
import java.util.List;
import java.util.Map;
public final class d {
    @NonNull
    public static AdBreak a(@NonNull AdSource adSource, @Nullable String str, @Nullable Long l, @NonNull TimeOffset timeOffset, @NonNull List<String> list, @NonNull List<Extension> list2, @NonNull Map<String, List<String>> map) {
        return new AdBreak(adSource, str, l, timeOffset, list, list2, map);
    }

    @NonNull
    public static AdSource a(@NonNull c cVar, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str) {
        return new AdSource(cVar, bool, bool2, str);
    }

    @NonNull
    public static c a(@NonNull String str, @NonNull String str2) {
        return new c(str, str2);
    }

    @NonNull
    public static TimeOffset a(@NonNull String str) {
        return new TimeOffset(str);
    }

    @NonNull
    public static Vmap a(@NonNull String str, @NonNull List<AdBreak> list, @NonNull List<Extension> list2) {
        return new Vmap(str, list, list2);
    }
}
