package com.avito.android.photo_picker.legacy;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraSourceImpl;", "Lcom/avito/android/photo_picker/legacy/CameraSource;", "Lcom/avito/android/photo_picker/legacy/CameraType;", "type", "Lio/reactivex/Single;", "Landroid/hardware/Camera;", "open", "(Lcom/avito/android/photo_picker/legacy/CameraType;)Lio/reactivex/Single;", "", "getAvailableCameras", "()Ljava/util/List;", "availableCameras", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"Deprecation"})
public final class CameraSourceImpl implements CameraSource {

    public static final class a<T> implements SingleOnSubscribe<Camera> {
        public final /* synthetic */ CameraType a;

        public a(CameraType cameraType) {
            this.a = cameraType;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(@NotNull SingleEmitter<Camera> singleEmitter) {
            Intrinsics.checkNotNullParameter(singleEmitter, "subscriber");
            try {
                singleEmitter.onSuccess(Camera.open(this.a.getIndex()));
            } catch (Exception e) {
                singleEmitter.onError(e);
            }
        }
    }

    @Override // com.avito.android.photo_picker.legacy.CameraSource
    @NotNull
    public List<CameraType> getAvailableCameras() {
        return CameraSourceKt.access$getFULL_CAMERA_LIST$p().subList(0, Math.min(Camera.getNumberOfCameras(), CameraSourceKt.access$getFULL_CAMERA_LIST$p().size()));
    }

    @Override // com.avito.android.photo_picker.legacy.CameraSource
    @NotNull
    public Single<Camera> open(@NotNull CameraType cameraType) {
        Intrinsics.checkNotNullParameter(cameraType, "type");
        Single<Camera> create = Single.create(new a(cameraType));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { subscrib…Error(ex)\n        }\n    }");
        return create;
    }
}
