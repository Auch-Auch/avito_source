package com.avito.android.in_app_calls.logging;

import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/in_app_calls/logging/LogStreamer;", "", "", Tracker.Events.CREATIVE_START, "()V", "stop", "Lio/reactivex/rxjava3/core/Observable;", "", "getLogsObservable", "()Lio/reactivex/rxjava3/core/Observable;", "logsObservable", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface LogStreamer {
    @NotNull
    Observable<String> getLogsObservable();

    void start();

    void stop();
}
