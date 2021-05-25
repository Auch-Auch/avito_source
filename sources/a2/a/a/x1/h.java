package a2.a.a.x1;

import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<Throwable> {
    public final /* synthetic */ PhotoPickerViewModel a;

    public h(PhotoPickerViewModel photoPickerViewModel) {
        this.a = photoPickerViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("Error during photo creation in SingleCachePhotoInteractor", th);
        this.a.f.setValue(PhotoPickerViewModel.RoutingAction.ToExit.INSTANCE);
    }
}
