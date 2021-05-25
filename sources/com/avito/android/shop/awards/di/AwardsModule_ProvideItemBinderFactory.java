package com.avito.android.shop.awards.di;

import com.avito.android.shop.awards.item.action.ActionItemBlueprint;
import com.avito.android.shop.awards.item.award.AwardItemBlueprint;
import com.avito.android.shop.awards.item.subtitle.SubtitleItemBlueprint;
import com.avito.android.shop.awards.item.title.TitleItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AwardsModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<TitleItemBlueprint> a;
    public final Provider<SubtitleItemBlueprint> b;
    public final Provider<AwardItemBlueprint> c;
    public final Provider<ActionItemBlueprint> d;

    public AwardsModule_ProvideItemBinderFactory(Provider<TitleItemBlueprint> provider, Provider<SubtitleItemBlueprint> provider2, Provider<AwardItemBlueprint> provider3, Provider<ActionItemBlueprint> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AwardsModule_ProvideItemBinderFactory create(Provider<TitleItemBlueprint> provider, Provider<SubtitleItemBlueprint> provider2, Provider<AwardItemBlueprint> provider3, Provider<ActionItemBlueprint> provider4) {
        return new AwardsModule_ProvideItemBinderFactory(provider, provider2, provider3, provider4);
    }

    public static ItemBinder provideItemBinder(TitleItemBlueprint titleItemBlueprint, SubtitleItemBlueprint subtitleItemBlueprint, AwardItemBlueprint awardItemBlueprint, ActionItemBlueprint actionItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(AwardsModule.provideItemBinder(titleItemBlueprint, subtitleItemBlueprint, awardItemBlueprint, actionItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
