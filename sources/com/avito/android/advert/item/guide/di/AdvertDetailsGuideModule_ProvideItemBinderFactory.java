package com.avito.android.advert.item.guide.di;

import com.avito.android.advert.item.guide.section.GuideSectionItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertDetailsGuideModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<GuideSectionItemBlueprint> a;

    public AdvertDetailsGuideModule_ProvideItemBinderFactory(Provider<GuideSectionItemBlueprint> provider) {
        this.a = provider;
    }

    public static AdvertDetailsGuideModule_ProvideItemBinderFactory create(Provider<GuideSectionItemBlueprint> provider) {
        return new AdvertDetailsGuideModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(GuideSectionItemBlueprint guideSectionItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(AdvertDetailsGuideModule.INSTANCE.provideItemBinder(guideSectionItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
