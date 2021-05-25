package a2.a.a.x1.r;

import androidx.lifecycle.Observer;
import com.avito.android.photo_picker.photo_panel.PhotoPanelFragment;
import com.avito.android.photo_picker.photo_panel.PhotoPanelViewModel;
public final class a<T> implements Observer<PhotoPanelViewModel.ViewState> {
    public final /* synthetic */ PhotoPanelFragment a;

    public a(PhotoPanelFragment photoPanelFragment) {
        this.a = photoPanelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PhotoPanelViewModel.ViewState viewState) {
        PhotoPanelViewModel.ViewState viewState2 = viewState;
        if (viewState2 instanceof PhotoPanelViewModel.ViewState.SelectedPhotosUpdate) {
            PhotoPanelFragment.access$updateViews(this.a, (PhotoPanelViewModel.ViewState.SelectedPhotosUpdate) viewState2);
        }
    }
}
