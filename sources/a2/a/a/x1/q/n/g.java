package a2.a.a.x1.q.n;

import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegate;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import t6.n.d;
public final class g<T, R> implements Function<Throwable, ImageUploadServiceDelegate.UploadingEvent> {
    public static final g a = new g();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ImageUploadServiceDelegate.UploadingEvent apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "throwable");
        return new ImageUploadServiceDelegate.UploadingEvent.Error(d.listOf(th2));
    }
}
