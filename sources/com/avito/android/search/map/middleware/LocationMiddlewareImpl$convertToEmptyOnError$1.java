package com.avito.android.search.map.middleware;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/avito/android/search/map/action/MapAction;", "T", "", "kotlin.jvm.PlatformType", "it", "", "accept", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class LocationMiddlewareImpl$convertToEmptyOnError$1<T> implements Consumer<Throwable> {
    public static final LocationMiddlewareImpl$convertToEmptyOnError$1 INSTANCE = new LocationMiddlewareImpl$convertToEmptyOnError$1();

    public final void accept(Throwable th) {
        Logs.error(th);
    }
}
