package com.avito.android.developments_catalog.items.photoGallery;

import com.avito.android.developments_catalog.DevelopmentsCatalogRouter;
import com.avito.android.photo_gallery.common.GalleryActionListener;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryView;", "Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryItem;", "Lcom/avito/android/photo_gallery/common/GalleryActionListener;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "router", "", "attachRouter", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;)V", "detachRouter", "()V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoGalleryPresenter extends ItemPresenter<PhotoGalleryView, PhotoGalleryItem>, GalleryActionListener {
    void attachRouter(@Nullable DevelopmentsCatalogRouter developmentsCatalogRouter);

    void detachRouter();
}
