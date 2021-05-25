package com.avito.android.connection_quality;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/connection_quality/ConnectionQualityProvider;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/connection_quality/ConnectionQuality;", "getConnectionQualityStream", "()Lio/reactivex/Observable;", "connectionQualityStream", "getCurrentConnectionQuality", "()Lcom/avito/android/connection_quality/ConnectionQuality;", "currentConnectionQuality", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
public interface ConnectionQualityProvider {
    @NotNull
    Observable<ConnectionQuality> getConnectionQualityStream();

    @NotNull
    ConnectionQuality getCurrentConnectionQuality();
}
