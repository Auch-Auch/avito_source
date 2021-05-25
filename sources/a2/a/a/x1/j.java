package a2.a.a.x1;

import com.avito.android.photo_picker.PhotoPickerViewModel;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class j<T, R> implements Function<Boolean, SingleSource<? extends Boolean>> {
    public final /* synthetic */ PhotoPickerViewModel a;

    public j(PhotoPickerViewModel photoPickerViewModel) {
        this.a = photoPickerViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Boolean> apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "it");
        return PhotoPickerViewModel.access$delayIfNeeded(this.a, bool2.booleanValue());
    }
}
