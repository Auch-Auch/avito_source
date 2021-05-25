package com.avito.android.performance;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/performance/ScreenTracker;", "", "", "stop", "()V", "resetSession", "Lcom/avito/android/performance/SimpleTracker;", "getInit", "()Lcom/avito/android/performance/SimpleTracker;", "init", "Lcom/avito/android/performance/DiInjectTracker;", "getDiInject", "()Lcom/avito/android/performance/DiInjectTracker;", "diInject", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public interface ScreenTracker {
    @NotNull
    DiInjectTracker getDiInject();

    @NotNull
    SimpleTracker getInit();

    void resetSession();

    void stop();
}
