package com.avito.android.photo_picker.legacy;

import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;", "", "Lio/reactivex/Observable;", "", "getOrientationObservable", "()Lio/reactivex/Observable;", "", "stop", "()V", Tracker.Events.CREATIVE_START, "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface DeviceOrientationProvider {
    @NotNull
    Observable<Integer> getOrientationObservable();

    void start();

    void stop();
}
