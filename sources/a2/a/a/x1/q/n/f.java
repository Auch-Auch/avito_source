package a2.a.a.x1.q.n;

import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegate;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<String, ImageUploadServiceDelegate.UploadingEvent.Success> {
    public static final f a = new f();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ImageUploadServiceDelegate.UploadingEvent.Success apply(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return new ImageUploadServiceDelegate.UploadingEvent.Success();
    }
}
