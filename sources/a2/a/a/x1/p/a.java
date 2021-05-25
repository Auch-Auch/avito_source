package a2.a.a.x1.p;

import androidx.lifecycle.Observer;
import com.avito.android.photo_picker.gallery.GalleryPickerFragment;
import com.avito.android.photo_picker.gallery.GalleryPickerViewModel;
public final class a<T> implements Observer<GalleryPickerViewModel.ViewState> {
    public final /* synthetic */ GalleryPickerFragment a;

    public a(GalleryPickerFragment galleryPickerFragment) {
        this.a = galleryPickerFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(GalleryPickerViewModel.ViewState viewState) {
        GalleryPickerViewModel.ViewState viewState2 = viewState;
        if (viewState2 instanceof GalleryPickerViewModel.ViewState.UpdatePhotos) {
            this.a.c(((GalleryPickerViewModel.ViewState.UpdatePhotos) viewState2).getPhotos());
        } else if (viewState2 instanceof GalleryPickerViewModel.ViewState.ShowNoPermission) {
            GalleryPickerFragment.access$showNoPermission(this.a, ((GalleryPickerViewModel.ViewState.ShowNoPermission) viewState2).getButtonTextResId());
        } else if (viewState2 instanceof GalleryPickerViewModel.ViewState.HideNoPermission) {
            GalleryPickerFragment.access$hideNoPermission(this.a);
        } else if (viewState2 instanceof GalleryPickerViewModel.ViewState.ShowNoPhotos) {
            GalleryPickerFragment.access$showNoPhotos(this.a);
        } else if (viewState2 instanceof GalleryPickerViewModel.ViewState.HideNoPhotos) {
            GalleryPickerFragment.access$hideNoPhotos(this.a);
        } else if (viewState2 instanceof GalleryPickerViewModel.ViewState.InitialDataLoaded) {
            GalleryPickerViewModel.ViewState.InitialDataLoaded initialDataLoaded = (GalleryPickerViewModel.ViewState.InitialDataLoaded) viewState2;
            GalleryPickerFragment.access$onInitialDataLoaded(this.a, initialDataLoaded.getPhotos(), initialDataLoaded.getFolders());
        } else if (viewState2 instanceof GalleryPickerViewModel.ViewState.SelectFolder) {
            GalleryPickerFragment.access$selectFolder(this.a, ((GalleryPickerViewModel.ViewState.SelectFolder) viewState2).getFolderName());
        }
    }
}
