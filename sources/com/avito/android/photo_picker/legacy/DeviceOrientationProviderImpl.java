package com.avito.android.photo_picker.legacy;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/photo_picker/legacy/DeviceOrientationProviderImpl;", "Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;", "Lio/reactivex/Observable;", "", "getOrientationObservable", "()Lio/reactivex/Observable;", "", "stop", "()V", Tracker.Events.CREATIVE_START, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "orientationStream", "com/avito/android/photo_picker/legacy/DeviceOrientationProviderImpl$listener$1", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/DeviceOrientationProviderImpl$listener$1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class DeviceOrientationProviderImpl implements DeviceOrientationProvider {
    public final BehaviorRelay<Integer> a;
    public final DeviceOrientationProviderImpl$listener$1 b;

    public DeviceOrientationProviderImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BehaviorRelay<Integer> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.a = create;
        this.b = new DeviceOrientationProviderImpl$listener$1(this, context, context);
    }

    @Override // com.avito.android.photo_picker.legacy.DeviceOrientationProvider
    @NotNull
    public Observable<Integer> getOrientationObservable() {
        return this.a;
    }

    @Override // com.avito.android.photo_picker.legacy.DeviceOrientationProvider
    public void start() {
        this.b.enable();
    }

    @Override // com.avito.android.photo_picker.legacy.DeviceOrientationProvider
    public void stop() {
        this.b.disable();
    }
}
