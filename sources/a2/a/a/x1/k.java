package a2.a.a.x1;

import com.avito.android.photo_picker.PhotoPickerViewModel;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class k<T, R> implements Function<Boolean, CompletableSource> {
    public final /* synthetic */ PhotoPickerViewModel a;

    public k(PhotoPickerViewModel photoPickerViewModel) {
        this.a = photoPickerViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "it");
        return this.a.n.commit().retry(3);
    }
}
