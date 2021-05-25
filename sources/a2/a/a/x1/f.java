package a2.a.a.x1;

import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.legacy.PickerPhoto;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<Iterable<? extends PickerPhoto>, ObservableSource<? extends PickerPhoto>> {
    public final /* synthetic */ PhotoPickerViewModel a;

    public f(PhotoPickerViewModel photoPickerViewModel) {
        this.a = photoPickerViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.photo_picker.legacy.PhotoPickerInteractor */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends PickerPhoto> apply(Iterable<? extends PickerPhoto> iterable) {
        Iterable<? extends PickerPhoto> iterable2 = iterable;
        Intrinsics.checkNotNullParameter(iterable2, "it");
        return this.a.n.addPhotos(iterable2);
    }
}
