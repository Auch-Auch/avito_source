package a2.a.a.x1.q.m;

import android.net.Uri;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class i<T> implements Consumer<Uri> {
    public final /* synthetic */ CameraItemPresenterImpl a;

    public i(CameraItemPresenterImpl cameraItemPresenterImpl) {
        this.a = cameraItemPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Uri uri) {
        Uri uri2 = uri;
        CameraItemPresenterImpl cameraItemPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(uri2, "it");
        CameraItemPresenterImpl.access$onShotCompleted(cameraItemPresenterImpl, uri2);
    }
}
