package com.avito.android.publish.analytics;

import com.avito.android.publish.NavigationProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/publish/analytics/PhotoPickerOnPublishEventTracker;", "", "Lcom/avito/android/publish/NavigationProvider;", "navigationProvider", "", "subscribe", "(Lcom/avito/android/publish/NavigationProvider;)V", "unsubscribe", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoPickerOnPublishEventTracker {
    void subscribe(@NotNull NavigationProvider navigationProvider);

    void unsubscribe();
}
