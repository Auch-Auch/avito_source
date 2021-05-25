package a2.a.a.x1.q.m;

import android.graphics.Bitmap;
import android.net.Uri;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class h<T, R> implements Function<Bitmap, Uri> {
    public final /* synthetic */ CameraItemPresenterImpl a;

    public h(CameraItemPresenterImpl cameraItemPresenterImpl) {
        this.a = cameraItemPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Uri apply(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        Intrinsics.checkNotNullParameter(bitmap2, "it");
        return SharedPhotosStorage.DefaultImpls.addImage$default(this.a.D, bitmap2, null, null, null, null, 30, null);
    }
}
