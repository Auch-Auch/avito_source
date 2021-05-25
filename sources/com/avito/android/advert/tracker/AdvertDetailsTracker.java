package com.avito.android.advert.tracker;

import android.net.Uri;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\bJ\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\bJ\u001d\u0010\"\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H&¢\u0006\u0004\b$\u0010\b¨\u0006%"}, d2 = {"Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", "", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startLoadingAdvert", "trackAdvertLoaded", "trackAdvertPrepare", "trackAdvertDraw", "trackAdvertLoadError", "trackAdvertErrorPrepare", "trackAdvertErrorDraw", "startComplementaryLoading", "trackComplementaryLoaded", "startComplementaryPrepare", "trackComplementaryPrepare", "trackComplementaryDraw", "trackComplementaryLoadError", "trackComplementaryErrorPrepare", "trackComplementaryErrorDraw", "clickTime", "trackClickToDrawing", "restart", "stop", "attach", "detach", "", "Landroid/net/Uri;", "mainUris", "registerAdvertUris", "(Ljava/util/Set;)V", "destroy", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsTracker {
    void attach();

    void destroy();

    void detach();

    void registerAdvertUris(@NotNull Set<? extends Uri> set);

    void restart();

    void startComplementaryLoading();

    void startComplementaryPrepare();

    void startInit();

    void startLoadingAdvert();

    void stop();

    void trackAdvertDraw();

    void trackAdvertErrorDraw();

    void trackAdvertErrorPrepare();

    void trackAdvertLoadError();

    void trackAdvertLoaded();

    void trackAdvertPrepare();

    void trackClickToDrawing(long j);

    void trackComplementaryDraw();

    void trackComplementaryErrorDraw();

    void trackComplementaryErrorPrepare();

    void trackComplementaryLoadError();

    void trackComplementaryLoaded();

    void trackComplementaryPrepare();

    void trackDiInject(long j);

    void trackInit();
}
