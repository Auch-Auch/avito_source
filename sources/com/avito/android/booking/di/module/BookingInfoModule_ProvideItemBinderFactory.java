package com.avito.android.booking.di.module;

import com.avito.android.booking.item.description.DescriptionItemBlueprint;
import com.avito.android.booking.item.padding.PaddingItemBlueprint;
import com.avito.android.booking.item.picture.PictureItemBlueprint;
import com.avito.android.booking.item.subtitle.SubtitleItemBlueprint;
import com.avito.android.booking.item.title.TitleItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BookingInfoModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<PictureItemBlueprint> a;
    public final Provider<TitleItemBlueprint> b;
    public final Provider<SubtitleItemBlueprint> c;
    public final Provider<DescriptionItemBlueprint> d;
    public final Provider<PaddingItemBlueprint> e;

    public BookingInfoModule_ProvideItemBinderFactory(Provider<PictureItemBlueprint> provider, Provider<TitleItemBlueprint> provider2, Provider<SubtitleItemBlueprint> provider3, Provider<DescriptionItemBlueprint> provider4, Provider<PaddingItemBlueprint> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static BookingInfoModule_ProvideItemBinderFactory create(Provider<PictureItemBlueprint> provider, Provider<TitleItemBlueprint> provider2, Provider<SubtitleItemBlueprint> provider3, Provider<DescriptionItemBlueprint> provider4, Provider<PaddingItemBlueprint> provider5) {
        return new BookingInfoModule_ProvideItemBinderFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static ItemBinder provideItemBinder(PictureItemBlueprint pictureItemBlueprint, TitleItemBlueprint titleItemBlueprint, SubtitleItemBlueprint subtitleItemBlueprint, DescriptionItemBlueprint descriptionItemBlueprint, PaddingItemBlueprint paddingItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(BookingInfoModule.provideItemBinder(pictureItemBlueprint, titleItemBlueprint, subtitleItemBlueprint, descriptionItemBlueprint, paddingItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
