package com.avito.android.analytics.provider.pixel;

import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/provider/pixel/PixelInteractor;", "", "", "", "queryMap", "Lio/reactivex/Observable;", "", "sendAd", "(Ljava/util/Map;)Lio/reactivex/Observable;", "analytics_release"}, k = 1, mv = {1, 4, 2})
public interface PixelInteractor {
    @NotNull
    Observable<Unit> sendAd(@NotNull Map<String, String> map);
}
