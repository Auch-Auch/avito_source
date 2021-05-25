package a2.a.a.j.a;

import com.avito.android.photo_picker.UploadingState;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class t0<T, R> implements Function<UploadingState, Unit> {
    public static final t0 a = new t0();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(UploadingState uploadingState) {
        Intrinsics.checkNotNullParameter(uploadingState, "it");
        return Unit.INSTANCE;
    }
}
