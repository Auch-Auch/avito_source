package a2.a.a.x1.q.m;

import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class j<T> implements Consumer<Throwable> {
    public final /* synthetic */ CameraItemPresenterImpl a;

    public j(CameraItemPresenterImpl cameraItemPresenterImpl) {
        this.a = cameraItemPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        CameraItemPresenterImpl cameraItemPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        CameraItemPresenterImpl.access$onShotError(cameraItemPresenterImpl, th2);
    }
}
