package com.avito.android.photo_picker.legacy;

import android.hardware.Camera;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraOpenInteractorImpl;", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "Lcom/avito/android/photo_picker/legacy/CameraType;", "type", "Lio/reactivex/Single;", "Lorg/funktionale/option/Option;", "Lcom/avito/android/photo_picker/legacy/CameraInteractor;", "openCamera", "(Lcom/avito/android/photo_picker/legacy/CameraType;)Lio/reactivex/Single;", "Lcom/avito/android/photo_picker/legacy/CameraSource;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/CameraSource;", "cameraSource", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analyticsUtils", "", "getAvailableCameras", "()Ljava/util/List;", "availableCameras", "<init>", "(Lcom/avito/android/photo_picker/legacy/CameraSource;Lcom/avito/android/analytics/Analytics;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraOpenInteractorImpl implements CameraOpenInteractor {
    public final CameraSource a;
    public final Analytics b;

    public static final class a<T, R> implements Function<Camera, Option<? extends CameraInteractor>> {
        public final /* synthetic */ CameraOpenInteractorImpl a;
        public final /* synthetic */ CameraType b;

        public a(CameraOpenInteractorImpl cameraOpenInteractorImpl, CameraType cameraType) {
            this.a = cameraOpenInteractorImpl;
            this.b = cameraType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends CameraInteractor> apply(Camera camera) {
            Camera camera2 = camera;
            Intrinsics.checkNotNullParameter(camera2, "camera");
            return OptionKt.toOption(new CameraInteractorImpl(camera2, this.b, this.a.b));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Cannot open camera", th);
        }
    }

    @Inject
    public CameraOpenInteractorImpl(@NotNull CameraSource cameraSource, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(cameraSource, "cameraSource");
        Intrinsics.checkNotNullParameter(analytics, "analyticsUtils");
        this.a = cameraSource;
        this.b = analytics;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraOpenInteractor
    @NotNull
    public List<CameraType> getAvailableCameras() {
        return this.a.getAvailableCameras();
    }

    @Override // com.avito.android.photo_picker.legacy.CameraOpenInteractor
    @NotNull
    public Single<Option<CameraInteractor>> openCamera(@NotNull CameraType cameraType) {
        Intrinsics.checkNotNullParameter(cameraType, "type");
        Single<R> onErrorReturnItem = this.a.open(cameraType).map(new a(this, cameraType)).doOnError(b.a).onErrorReturnItem((R) Option.None.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "cameraSource\n           …orReturnItem(Option.None)");
        return onErrorReturnItem;
    }
}
