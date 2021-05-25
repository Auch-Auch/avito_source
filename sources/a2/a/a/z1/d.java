package a2.a.a.z1;

import android.graphics.Bitmap;
import android.net.Uri;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Bitmap, Uri> {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Uri apply(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        SharedPhotosStorage sharedPhotosStorage = this.a.a.y;
        Intrinsics.checkNotNullExpressionValue(bitmap2, "bitmap");
        Uri addImage$default = SharedPhotosStorage.DefaultImpls.addImage$default(sharedPhotosStorage, bitmap2, null, null, null, new SharedPhotosStorage.BitmapSaveProperties(Bitmap.CompressFormat.JPEG, 95), 14, null);
        bitmap2.recycle();
        return addImage$default;
    }
}
