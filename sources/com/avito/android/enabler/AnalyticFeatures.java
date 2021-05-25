package com.avito.android.enabler;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/enabler/AnalyticFeatures;", "", "", "getHasCacheForCurrentVersion", "()Z", "hasCacheForCurrentVersion", "Lio/reactivex/Observable;", "Lcom/avito/android/enabler/RemoteFeature;", "getTouchedFeatures", "()Lio/reactivex/Observable;", "touchedFeatures", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public interface AnalyticFeatures {
    boolean getHasCacheForCurrentVersion();

    @NotNull
    Observable<RemoteFeature<Object>> getTouchedFeatures();
}
