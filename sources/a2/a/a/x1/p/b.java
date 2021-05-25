package a2.a.a.x1.p;

import com.avito.android.photo_picker.gallery.GalleryPickerViewModel;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ GalleryPickerViewModel a;

    public b(GalleryPickerViewModel galleryPickerViewModel) {
        this.a = galleryPickerViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        this.a.g.setValue(GalleryPickerViewModel.ViewState.ShowNoPhotos.INSTANCE);
    }
}
