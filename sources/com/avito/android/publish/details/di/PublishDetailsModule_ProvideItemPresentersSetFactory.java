package com.avito.android.publish.details.di;

import com.avito.android.blueprints.chips.ChipsSelectItemPresenter;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemPresenter;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.VehicleRegNumberInputItemPresenter;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemPresenter;
import com.avito.android.blueprints.range.cre_range.CreRangePresenter;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenter;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter;
import com.avito.android.blueprints.video.VideoItemPresenter;
import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemPresenter;
import com.avito.android.publish.details.adapter.multiselect.RdsMultiselectItemPresenter;
import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemPresenter;
import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotItemPresenter;
import com.avito.android.publish.slots.link.item.LinkSlotItemPresenter;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Presenter;
import com.avito.android.publish.slots.no_car.item.NoCarSlotItemPresenter;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideItemPresentersSetFactory implements Factory<Set<ItemPresenter<?, ?>>> {
    public final PublishDetailsModule a;
    public final Provider<MultiStateSelectItemPresenter> b;
    public final Provider<ChipsSelectItemPresenter> c;
    public final Provider<ChipsMultiselectItemPresenter> d;
    public final Provider<RadioGroupSelectItemPresenter> e;
    public final Provider<RdsMultiselectItemPresenter> f;
    public final Provider<MultiStateSwitcherItemPresenter> g;
    public final Provider<MultiStateInputItemPresenter> h;
    public final Provider<MultiStateObjectsItemPresenter> i;
    public final Provider<MultiStateInputWithTagsItemPresenter> j;
    public final Provider<NoCarSlotItemPresenter> k;
    public final Provider<EditCategoryItemPresenter> l;
    public final Provider<CreRangePresenter> m;
    public final Provider<VehicleRegNumberInputItemPresenter> n;
    public final Provider<VideoItemPresenter> o;
    public final Provider<LinkSlotItemPresenter> p;
    public final Provider<MarketPriceV2Presenter> q;
    public final Provider<LimitsInfoItemPresenter> r;
    public final Provider<CpaTariffSlotItemPresenter> s;

    public PublishDetailsModule_ProvideItemPresentersSetFactory(PublishDetailsModule publishDetailsModule, Provider<MultiStateSelectItemPresenter> provider, Provider<ChipsSelectItemPresenter> provider2, Provider<ChipsMultiselectItemPresenter> provider3, Provider<RadioGroupSelectItemPresenter> provider4, Provider<RdsMultiselectItemPresenter> provider5, Provider<MultiStateSwitcherItemPresenter> provider6, Provider<MultiStateInputItemPresenter> provider7, Provider<MultiStateObjectsItemPresenter> provider8, Provider<MultiStateInputWithTagsItemPresenter> provider9, Provider<NoCarSlotItemPresenter> provider10, Provider<EditCategoryItemPresenter> provider11, Provider<CreRangePresenter> provider12, Provider<VehicleRegNumberInputItemPresenter> provider13, Provider<VideoItemPresenter> provider14, Provider<LinkSlotItemPresenter> provider15, Provider<MarketPriceV2Presenter> provider16, Provider<LimitsInfoItemPresenter> provider17, Provider<CpaTariffSlotItemPresenter> provider18) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
        this.l = provider11;
        this.m = provider12;
        this.n = provider13;
        this.o = provider14;
        this.p = provider15;
        this.q = provider16;
        this.r = provider17;
        this.s = provider18;
    }

    public static PublishDetailsModule_ProvideItemPresentersSetFactory create(PublishDetailsModule publishDetailsModule, Provider<MultiStateSelectItemPresenter> provider, Provider<ChipsSelectItemPresenter> provider2, Provider<ChipsMultiselectItemPresenter> provider3, Provider<RadioGroupSelectItemPresenter> provider4, Provider<RdsMultiselectItemPresenter> provider5, Provider<MultiStateSwitcherItemPresenter> provider6, Provider<MultiStateInputItemPresenter> provider7, Provider<MultiStateObjectsItemPresenter> provider8, Provider<MultiStateInputWithTagsItemPresenter> provider9, Provider<NoCarSlotItemPresenter> provider10, Provider<EditCategoryItemPresenter> provider11, Provider<CreRangePresenter> provider12, Provider<VehicleRegNumberInputItemPresenter> provider13, Provider<VideoItemPresenter> provider14, Provider<LinkSlotItemPresenter> provider15, Provider<MarketPriceV2Presenter> provider16, Provider<LimitsInfoItemPresenter> provider17, Provider<CpaTariffSlotItemPresenter> provider18) {
        return new PublishDetailsModule_ProvideItemPresentersSetFactory(publishDetailsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    public static Set<ItemPresenter<?, ?>> provideItemPresentersSet(PublishDetailsModule publishDetailsModule, MultiStateSelectItemPresenter multiStateSelectItemPresenter, ChipsSelectItemPresenter chipsSelectItemPresenter, ChipsMultiselectItemPresenter chipsMultiselectItemPresenter, RadioGroupSelectItemPresenter radioGroupSelectItemPresenter, RdsMultiselectItemPresenter rdsMultiselectItemPresenter, MultiStateSwitcherItemPresenter multiStateSwitcherItemPresenter, MultiStateInputItemPresenter multiStateInputItemPresenter, MultiStateObjectsItemPresenter multiStateObjectsItemPresenter, MultiStateInputWithTagsItemPresenter multiStateInputWithTagsItemPresenter, NoCarSlotItemPresenter noCarSlotItemPresenter, EditCategoryItemPresenter editCategoryItemPresenter, CreRangePresenter creRangePresenter, VehicleRegNumberInputItemPresenter vehicleRegNumberInputItemPresenter, VideoItemPresenter videoItemPresenter, LinkSlotItemPresenter linkSlotItemPresenter, MarketPriceV2Presenter marketPriceV2Presenter, LimitsInfoItemPresenter limitsInfoItemPresenter, CpaTariffSlotItemPresenter cpaTariffSlotItemPresenter) {
        return (Set) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideItemPresentersSet(multiStateSelectItemPresenter, chipsSelectItemPresenter, chipsMultiselectItemPresenter, radioGroupSelectItemPresenter, rdsMultiselectItemPresenter, multiStateSwitcherItemPresenter, multiStateInputItemPresenter, multiStateObjectsItemPresenter, multiStateInputWithTagsItemPresenter, noCarSlotItemPresenter, editCategoryItemPresenter, creRangePresenter, vehicleRegNumberInputItemPresenter, videoItemPresenter, linkSlotItemPresenter, marketPriceV2Presenter, limitsInfoItemPresenter, cpaTariffSlotItemPresenter));
    }

    @Override // javax.inject.Provider
    public Set<ItemPresenter<?, ?>> get() {
        return provideItemPresentersSet(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get());
    }
}
