package ru.avito.component.serp;

import com.avito.konveyor.ItemBinder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lru/avito/component/serp/ImageGalleryItemBinderFactory;", "", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "", "getPhotoViewType", "()I", "photoViewType", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ImageGalleryItemBinderFactory {
    @NotNull
    ItemBinder getItemBinder();

    int getPhotoViewType();
}
