package com.avito.android.photo;

import android.hardware.Camera;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/hardware/Camera;", "Lio/reactivex/Observable;", "", "takeShotObservable", "(Landroid/hardware/Camera;)Lio/reactivex/Observable;", "", "focusObservable", "Landroid/hardware/Camera$PictureCallback;", "jpegCallback", "", "takeShot", "(Landroid/hardware/Camera;Landroid/hardware/Camera$PictureCallback;)V", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class CamerasKt {

    public static final class a<T> implements ObservableOnSubscribe<Boolean> {
        public final /* synthetic */ Camera a;

        /* renamed from: com.avito.android.photo.CamerasKt$a$a  reason: collision with other inner class name */
        public static final class C0147a implements Camera.AutoFocusCallback {
            public final /* synthetic */ ObservableEmitter a;

            public C0147a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: io.reactivex.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.hardware.Camera.AutoFocusCallback
            public final void onAutoFocus(boolean z, Camera camera) {
                ObservableEmitter observableEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(observableEmitter, "subscriber");
                if (!observableEmitter.isDisposed()) {
                    this.a.onNext(Boolean.valueOf(z));
                    this.a.onComplete();
                }
            }
        }

        public a(Camera camera) {
            this.a = camera;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Boolean> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "subscriber");
            this.a.cancelAutoFocus();
            this.a.autoFocus(new C0147a(observableEmitter));
        }
    }

    public static final class b<T> implements ObservableOnSubscribe<byte[]> {
        public final /* synthetic */ Camera a;

        public static final class a implements Camera.PictureCallback {
            public final /* synthetic */ ObservableEmitter a;

            public a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            @Override // android.hardware.Camera.PictureCallback
            public final void onPictureTaken(byte[] bArr, Camera camera) {
                ObservableEmitter observableEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(observableEmitter, "subscriber");
                if (!observableEmitter.isDisposed()) {
                    this.a.onNext(bArr);
                    this.a.onComplete();
                }
            }
        }

        public b(Camera camera) {
            this.a = camera;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<byte[]> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "subscriber");
            CamerasKt.takeShot(this.a, new a(observableEmitter));
        }
    }

    @NotNull
    public static final Observable<Boolean> focusObservable(@NotNull Camera camera) {
        Intrinsics.checkNotNullParameter(camera, "$this$focusObservable");
        Observable<Boolean> create = Observable.create(new a(camera));
        Intrinsics.checkNotNullExpressionValue(create, "create { subscriber ->\n …plete()\n        }\n    }\n}");
        return create;
    }

    public static final void takeShot(@NotNull Camera camera, @NotNull Camera.PictureCallback pictureCallback) {
        Intrinsics.checkNotNullParameter(camera, "$this$takeShot");
        Intrinsics.checkNotNullParameter(pictureCallback, "jpegCallback");
        camera.takePicture(null, null, pictureCallback);
    }

    @NotNull
    public static final Observable<byte[]> takeShotObservable(@NotNull Camera camera) {
        Intrinsics.checkNotNullParameter(camera, "$this$takeShotObservable");
        Observable<byte[]> create = Observable.create(new b(camera));
        Intrinsics.checkNotNullExpressionValue(create, "create { subscriber ->\n …lete()\n        }\n    })\n}");
        return create;
    }
}
