package com.avito.android.advert_core.discount.di;

import com.avito.android.advert_core.discount.item.contact.ContactItemBlueprint;
import com.avito.android.advert_core.discount.item.discount.DiscountItemBlueprint;
import com.avito.android.advert_core.discount.item.divider.DividerItemBlueprint;
import com.avito.android.advert_core.discount.item.information.InformationItemBlueprint;
import com.avito.android.advert_core.discount.item.title.TitleItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertDiscountDetailsModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<TitleItemBlueprint> a;
    public final Provider<DiscountItemBlueprint> b;
    public final Provider<DividerItemBlueprint> c;
    public final Provider<InformationItemBlueprint> d;
    public final Provider<ContactItemBlueprint> e;

    public AdvertDiscountDetailsModule_ProvideItemBinderFactory(Provider<TitleItemBlueprint> provider, Provider<DiscountItemBlueprint> provider2, Provider<DividerItemBlueprint> provider3, Provider<InformationItemBlueprint> provider4, Provider<ContactItemBlueprint> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertDiscountDetailsModule_ProvideItemBinderFactory create(Provider<TitleItemBlueprint> provider, Provider<DiscountItemBlueprint> provider2, Provider<DividerItemBlueprint> provider3, Provider<InformationItemBlueprint> provider4, Provider<ContactItemBlueprint> provider5) {
        return new AdvertDiscountDetailsModule_ProvideItemBinderFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static ItemBinder provideItemBinder(TitleItemBlueprint titleItemBlueprint, DiscountItemBlueprint discountItemBlueprint, DividerItemBlueprint dividerItemBlueprint, InformationItemBlueprint informationItemBlueprint, ContactItemBlueprint contactItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(AdvertDiscountDetailsModule.provideItemBinder(titleItemBlueprint, discountItemBlueprint, dividerItemBlueprint, informationItemBlueprint, contactItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
