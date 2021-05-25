package a2.a.a.x1.q.n;

import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegateImpl;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<File, ObservableSource<? extends String>> {
    public final /* synthetic */ ImageUploadServiceDelegateImpl a;
    public final /* synthetic */ PhotoUpload b;

    public c(ImageUploadServiceDelegateImpl imageUploadServiceDelegateImpl, PhotoUpload photoUpload) {
        this.a = imageUploadServiceDelegateImpl;
        this.b = photoUpload;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends String> apply(File file) {
        File file2 = file;
        Intrinsics.checkNotNullParameter(file2, "file");
        return this.a.b.getUploadInteractor(this.b.getType()).uploadFile(file2).toObservable();
    }
}
