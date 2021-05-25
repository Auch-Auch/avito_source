package a2.a.a.j.a;

import com.avito.android.photo_picker.UploadingState;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class r0<T> implements Predicate<UploadingState> {
    public static final r0 a = new r0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(UploadingState uploadingState) {
        UploadingState uploadingState2 = uploadingState;
        Intrinsics.checkNotNullParameter(uploadingState2, "it");
        return uploadingState2 instanceof UploadingState.HasUploadData;
    }
}
