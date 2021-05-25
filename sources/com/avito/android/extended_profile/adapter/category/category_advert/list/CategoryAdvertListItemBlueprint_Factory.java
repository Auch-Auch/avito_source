package com.avito.android.extended_profile.adapter.category.category_advert.list;

import androidx.recyclerview.widget.RecyclerView;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
public final class CategoryAdvertListItemBlueprint_Factory implements Factory<CategoryAdvertListItemBlueprint> {
    public final Provider<CategoryAdvertListItemPresenter> a;
    public final Provider<GalleryRatio> b;
    public final Provider<RecyclerView.RecycledViewPool> c;
    public final Provider<Boolean> d;

    public CategoryAdvertListItemBlueprint_Factory(Provider<CategoryAdvertListItemPresenter> provider, Provider<GalleryRatio> provider2, Provider<RecyclerView.RecycledViewPool> provider3, Provider<Boolean> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CategoryAdvertListItemBlueprint_Factory create(Provider<CategoryAdvertListItemPresenter> provider, Provider<GalleryRatio> provider2, Provider<RecyclerView.RecycledViewPool> provider3, Provider<Boolean> provider4) {
        return new CategoryAdvertListItemBlueprint_Factory(provider, provider2, provider3, provider4);
    }

    public static CategoryAdvertListItemBlueprint newInstance(CategoryAdvertListItemPresenter categoryAdvertListItemPresenter, GalleryRatio galleryRatio, RecyclerView.RecycledViewPool recycledViewPool, boolean z) {
        return new CategoryAdvertListItemBlueprint(categoryAdvertListItemPresenter, galleryRatio, recycledViewPool, z);
    }

    @Override // javax.inject.Provider
    public CategoryAdvertListItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get().booleanValue());
    }
}
