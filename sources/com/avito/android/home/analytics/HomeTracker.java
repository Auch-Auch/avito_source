package com.avito.android.home.analytics;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0019\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u001a\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u001b\u0010\u0015J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H&¢\u0006\u0004\b \u0010\bJ\u000f\u0010!\u001a\u00020\u0004H&¢\u0006\u0004\b!\u0010\bJ\u000f\u0010\"\u001a\u00020\u0004H&¢\u0006\u0004\b\"\u0010\bJ\u000f\u0010#\u001a\u00020\u0004H&¢\u0006\u0004\b#\u0010\bJ\u000f\u0010$\u001a\u00020\u0004H&¢\u0006\u0004\b$\u0010\bJ\u000f\u0010%\u001a\u00020\u0004H&¢\u0006\u0004\b%\u0010\bJ\u000f\u0010&\u001a\u00020\u0004H&¢\u0006\u0004\b&\u0010\bJ\u000f\u0010'\u001a\u00020\u0004H&¢\u0006\u0004\b'\u0010\bJ\u000f\u0010(\u001a\u00020\u0004H&¢\u0006\u0004\b(\u0010\bJ\u000f\u0010)\u001a\u00020\u0004H&¢\u0006\u0004\b)\u0010\b¨\u0006*"}, d2 = {"Lcom/avito/android/home/analytics/HomeTracker;", "", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startLoadingLocation", "", "locationIdForLoad", "trackLocationLoadedFromSave", "(Ljava/lang/String;)V", "trackLocationLoaded", "trackLocationLoadError", "startLoadingAdverts", "", "page", "trackAdvertsLoaded", "(I)V", "trackAdvertsPrepare", "startAdvertsDraw", "trackAdvertsDraw", "trackAdvertsLoadError", "trackAdvertsErrorPrepare", "trackAdvertsErrorDraw", "", ImagesContract.LOCAL, "startLoadingShortcuts", "(Z)V", "trackShortcutsLoaded", "startShortcutsPrepare", "trackShortcutsPrepare", "trackShortcutsDraw", "stopShortcutsLoad", "trackShortcutsLoadError", "stop", "attach", "detach", "destroy", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface HomeTracker {
    void attach();

    void destroy();

    void detach();

    void startAdvertsDraw();

    void startInit();

    void startLoadingAdverts();

    void startLoadingLocation();

    void startLoadingShortcuts(boolean z);

    void startShortcutsPrepare();

    void stop();

    void stopShortcutsLoad();

    void trackAdvertsDraw(int i);

    void trackAdvertsErrorDraw(int i);

    void trackAdvertsErrorPrepare(int i);

    void trackAdvertsLoadError(int i);

    void trackAdvertsLoaded(int i);

    void trackAdvertsPrepare(int i);

    void trackDiInject(long j);

    void trackInit();

    void trackLocationLoadError();

    void trackLocationLoaded();

    void trackLocationLoadedFromSave(@Nullable String str);

    void trackShortcutsDraw();

    void trackShortcutsLoadError();

    void trackShortcutsLoaded();

    void trackShortcutsPrepare();
}
