package com.avito.android.user_adverts.items_search.analytics;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;", "", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startLoadingAdverts", "trackAdvertsLoadingSuccess", "trackAdvertsLoadingError", "trackAdvertsPrepareSuccess", "trackAdvertsPrepareError", "startDraw", "trackAdvertsDrawSuccess", "trackAdvertsDrawError", "attach", "detach", "destroy", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileItemsSearchTracker {
    void attach();

    void destroy();

    void detach();

    void startDraw();

    void startInit();

    void startLoadingAdverts();

    void trackAdvertsDrawError();

    void trackAdvertsDrawSuccess();

    void trackAdvertsLoadingError();

    void trackAdvertsLoadingSuccess();

    void trackAdvertsPrepareError();

    void trackAdvertsPrepareSuccess();

    void trackDiInject(long j);

    void trackInit();
}
