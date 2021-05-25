package com.avito.android.service.short_task.metrics;

import com.avito.android.service.short_task.ShortTask;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/service/short_task/metrics/SendMetricsTaskDelegate;", "", "", "timeToInteract", "Lio/reactivex/Single;", "Lcom/avito/android/service/short_task/ShortTask$Status;", Tracker.Events.CREATIVE_START, "(Ljava/lang/String;)Lio/reactivex/Single;", "application_release"}, k = 1, mv = {1, 4, 2})
public interface SendMetricsTaskDelegate {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single start$default(SendMetricsTaskDelegate sendMetricsTaskDelegate, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return sendMetricsTaskDelegate.start(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }

    @NotNull
    Single<ShortTask.Status> start(@Nullable String str);
}
