package a2.a.a.x1.q.n;

import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegateImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Consumer<String> {
    public final /* synthetic */ ImageUploadServiceDelegateImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PhotoUpload c;

    public e(ImageUploadServiceDelegateImpl imageUploadServiceDelegateImpl, String str, PhotoUpload photoUpload) {
        this.a = imageUploadServiceDelegateImpl;
        this.b = str;
        this.c = photoUpload;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        ImageUploadServiceDelegateImpl imageUploadServiceDelegateImpl = this.a;
        String str3 = this.b;
        PhotoUpload photoUpload = this.c;
        Intrinsics.checkNotNullExpressionValue(str2, "uploadId");
        ImageUploadServiceDelegateImpl.access$saveUploadResult(imageUploadServiceDelegateImpl, str3, photoUpload, str2);
    }
}
