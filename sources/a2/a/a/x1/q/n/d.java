package a2.a.a.x1.q.n;

import a2.b.a.a.a;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegateImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ ImageUploadServiceDelegateImpl a;
    public final /* synthetic */ PhotoUpload b;
    public final /* synthetic */ String c;

    public d(ImageUploadServiceDelegateImpl imageUploadServiceDelegateImpl, PhotoUpload photoUpload, String str) {
        this.a = imageUploadServiceDelegateImpl;
        this.b = photoUpload;
        this.c = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        StringBuilder L = a.L("Failed to process or upload image: ");
        L.append(this.b.getContentUri());
        Timber.d(th2, L.toString(), new Object[0]);
        ImageUploadServiceDelegateImpl imageUploadServiceDelegateImpl = this.a;
        String str = this.c;
        PhotoUpload photoUpload = this.b;
        Intrinsics.checkNotNullExpressionValue(th2, "throwable");
        ImageUploadServiceDelegateImpl.access$processUploadError(imageUploadServiceDelegateImpl, str, photoUpload, th2);
    }
}
