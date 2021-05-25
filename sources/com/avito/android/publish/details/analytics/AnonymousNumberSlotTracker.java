package com.avito.android.publish.details.analytics;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish/details/analytics/AnonymousNumberSlotTracker;", "", "", "startAnonymousNumberSlotLoading", "()V", "trackAnonymousNumberSlotLoaded", "trackAnonymousNumberSlotLoadError", "startAnonymousNumberSlotPrepare", "trackAnonymousNumberSlotPrepare", "startAnonymousNumberSlotDraw", "trackAnonymousNumberSlotDraw", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface AnonymousNumberSlotTracker {
    void startAnonymousNumberSlotDraw();

    void startAnonymousNumberSlotLoading();

    void startAnonymousNumberSlotPrepare();

    void trackAnonymousNumberSlotDraw();

    void trackAnonymousNumberSlotLoadError();

    void trackAnonymousNumberSlotLoaded();

    void trackAnonymousNumberSlotPrepare();
}
