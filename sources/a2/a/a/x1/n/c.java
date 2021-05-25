package a2.a.a.x1.n;

import android.graphics.Bitmap;
import android.net.Uri;
import com.avito.android.photo_picker.camera.CameraViewModel;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Bitmap, Uri> {
    public final /* synthetic */ CameraViewModel.a a;
    public final /* synthetic */ byte[] b;

    public c(CameraViewModel.a aVar, byte[] bArr) {
        this.a = aVar;
        this.b = bArr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Uri apply(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
        SharedPhotosStorage sharedPhotosStorage = this.a.a.w;
        CameraViewModel cameraViewModel = this.a.a;
        byte[] bArr = this.b;
        Intrinsics.checkNotNullExpressionValue(bArr, "photoByteArray");
        Uri addImage$default = SharedPhotosStorage.DefaultImpls.addImage$default(sharedPhotosStorage, bitmap2, null, null, CameraViewModel.access$getExifAttributes(cameraViewModel, bArr), null, 22, null);
        bitmap2.recycle();
        return addImage$default;
    }
}
