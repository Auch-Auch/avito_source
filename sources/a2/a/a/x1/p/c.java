package a2.a.a.x1.p;

import com.avito.android.photo_picker.gallery.GalleryPickerViewModel;
import com.avito.android.photo_picker.gallery.GalleryPickerViewModelKt;
import com.avito.android.photo_picker.gallery.data.Folder;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryUriPhotoItem;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
public final class c<T> implements Consumer<Pair<? extends List<? extends GalleryUriPhotoItem>, ? extends Set<? extends Folder>>> {
    public final /* synthetic */ GalleryPickerViewModel a;

    public c(GalleryPickerViewModel galleryPickerViewModel) {
        this.a = galleryPickerViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Pair<? extends List<? extends GalleryUriPhotoItem>, ? extends Set<? extends Folder>> pair) {
        Pair<? extends List<? extends GalleryUriPhotoItem>, ? extends Set<? extends Folder>> pair2 = pair;
        this.a.d.clear();
        for (GalleryUriPhotoItem galleryUriPhotoItem : (List) pair2.getFirst()) {
            galleryUriPhotoItem.setSelectedPosition(GalleryPickerViewModel.access$getPhotoPickerViewModel$p(this.a).isUriSelected(galleryUriPhotoItem.getImageUri()));
            this.a.d.add(galleryUriPhotoItem);
        }
        this.a.e.clear();
        this.a.e.add(new Folder(GalleryPickerViewModelKt.FOLDER_ALL_PHOTOS, null, 2, null));
        this.a.e.addAll((Collection) pair2.getSecond());
        this.a.e.add(new Folder(GalleryPickerViewModelKt.FOLDER_OTHER_SOURCE, null, 2, null));
        this.a.g.setValue(new GalleryPickerViewModel.ViewState.InitialDataLoaded(this.a.c(), this.a.e));
    }
}
