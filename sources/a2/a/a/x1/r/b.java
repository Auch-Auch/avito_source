package a2.a.a.x1.r;

import com.avito.android.photo_picker.photo_panel.PhotoPanelViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class b<T> implements Consumer<Unit> {
    public final /* synthetic */ PhotoPanelViewModel a;

    public b(PhotoPanelViewModel photoPanelViewModel) {
        this.a = photoPanelViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        PhotoPanelViewModel photoPanelViewModel = this.a;
        photoPanelViewModel.c(PhotoPanelViewModel.access$getPhotoPickerViewModel$p(photoPanelViewModel).getSelectedPhotos$photo_picker_release());
    }
}
