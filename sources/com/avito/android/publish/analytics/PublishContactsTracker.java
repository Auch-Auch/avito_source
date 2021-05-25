package com.avito.android.publish.analytics;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/analytics/PublishContactsTracker;", "", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startProfileServerLoading", "trackProfileLoaded", "trackProfileLoadError", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishContactsTracker {
    void startInit();

    void startProfileServerLoading();

    void trackDiInject(long j);

    void trackInit();

    void trackProfileLoadError();

    void trackProfileLoaded();
}
