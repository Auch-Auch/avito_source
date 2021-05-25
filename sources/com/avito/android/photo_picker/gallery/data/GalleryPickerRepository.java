package com.avito.android.photo_picker.gallery.data;

import com.avito.android.photo_picker.gallery.gallery_list.GalleryUriPhotoItem;
import io.reactivex.Single;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00030\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/gallery/data/GalleryPickerRepository;", "", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryUriPhotoItem;", "", "Lcom/avito/android/photo_picker/gallery/data/Folder;", "loadData", "()Lio/reactivex/Single;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface GalleryPickerRepository {
    @NotNull
    Single<Pair<List<GalleryUriPhotoItem>, Set<Folder>>> loadData();
}
