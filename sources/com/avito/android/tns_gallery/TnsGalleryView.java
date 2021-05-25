package com.avito.android.tns_gallery;

import com.avito.android.remote.model.TnsGalleryImage;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/tns_gallery/TnsGalleryView;", "", "", "Lcom/avito/android/remote/model/TnsGalleryImage;", "items", "", "showGallery", "(Ljava/util/List;)V", "hideGallery", "()V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public interface TnsGalleryView {
    void hideGallery();

    void showGallery(@NotNull List<TnsGalleryImage> list);
}
