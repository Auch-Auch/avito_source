package a2.a.a.j.a;

import com.avito.android.app.task.LocalMessageSenderImpl;
import com.avito.android.photo_picker.PhotoUpload;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class l<T> implements Predicate<PhotoUpload> {
    public final /* synthetic */ LocalMessageSenderImpl a;

    public l(LocalMessageSenderImpl localMessageSenderImpl) {
        this.a = localMessageSenderImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(PhotoUpload photoUpload) {
        PhotoUpload photoUpload2 = photoUpload;
        Intrinsics.checkNotNullParameter(photoUpload2, "it");
        return LocalMessageSenderImpl.access$isCompletedOrFailed$p(this.a, photoUpload2);
    }
}
