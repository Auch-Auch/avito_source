package com.avito.android.publish.details.di;

import com.avito.android.Features;
import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.chips.ChipsSelectItemBlueprint;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemBlueprint;
import com.avito.android.blueprints.input.MultiStateInputItemBlueprint;
import com.avito.android.blueprints.publish.VehicleRegNumberInputItemBlueprint;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemBlueprint;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemBlueprint;
import com.avito.android.blueprints.range.cre_range.CreRangeItemBlueprint;
import com.avito.android.blueprints.select.MultiStateSelectItemBlueprint;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemBlueprint;
import com.avito.android.blueprints.video.VideoItemBlueprint;
import com.avito.android.photo_view.blueprints.MultiStatePhotoItemBlueprint;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemBlueprint;
import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemBlueprint;
import com.avito.android.publish.details.adapter.header.HeaderWithDividerItemBlueprint;
import com.avito.android.publish.details.adapter.multiselect.MultiselectItemBlueprint;
import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemBlueprint;
import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotBlueprint;
import com.avito.android.publish.slots.infomation.item.DisclaimerBlueprint;
import com.avito.android.publish.slots.information_with_user_id.item.InformationWithUserIdBlueprint;
import com.avito.android.publish.slots.link.item.LinkSlotBlueprint;
import com.avito.android.publish.slots.market_price.item.MarketPriceBlueprint;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Blueprint;
import com.avito.android.publish.slots.no_car.item.NoCarSlotBlueprint;
import com.avito.android.publish.slots.profile_info.item.UserInfoItemBlueprint;
import com.avito.android.publish_limits_info.item.LimitsInfoItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<ChipsMultiselectItemBlueprint> A;
    public final Provider<Features> B;
    public final PublishDetailsModule a;
    public final Provider<MultiStateSelectItemBlueprint> b;
    public final Provider<ChipsSelectItemBlueprint> c;
    public final Provider<RadioGroupSelectItemBlueprint> d;
    public final Provider<MultiStateSwitcherItemBlueprint> e;
    public final Provider<MultiStateInputItemBlueprint> f;
    public final Provider<MultiStatePhotoItemBlueprint> g;
    public final Provider<DateIntervalItemBlueprint> h;
    public final Provider<EditCategoryItemBlueprint> i;
    public final Provider<MultiselectItemBlueprint> j;
    public final Provider<MultiStateObjectsItemBlueprint> k;
    public final Provider<ButtonItemBlueprint> l;
    public final Provider<MultiStateInputWithTagsItemBlueprint> m;
    public final Provider<NoCarSlotBlueprint> n;
    public final Provider<CpaTariffSlotBlueprint> o;
    public final Provider<UserInfoItemBlueprint> p;
    public final Provider<LimitsInfoItemBlueprint> q;
    public final Provider<DisclaimerBlueprint> r;
    public final Provider<MarketPriceBlueprint> s;
    public final Provider<MarketPriceV2Blueprint> t;
    public final Provider<CreRangeItemBlueprint> u;
    public final Provider<VehicleRegNumberInputItemBlueprint> v;
    public final Provider<VideoItemBlueprint> w;
    public final Provider<LinkSlotBlueprint> x;
    public final Provider<HeaderWithDividerItemBlueprint> y;
    public final Provider<InformationWithUserIdBlueprint> z;

    public PublishDetailsModule_ProvideItemBinderFactory(PublishDetailsModule publishDetailsModule, Provider<MultiStateSelectItemBlueprint> provider, Provider<ChipsSelectItemBlueprint> provider2, Provider<RadioGroupSelectItemBlueprint> provider3, Provider<MultiStateSwitcherItemBlueprint> provider4, Provider<MultiStateInputItemBlueprint> provider5, Provider<MultiStatePhotoItemBlueprint> provider6, Provider<DateIntervalItemBlueprint> provider7, Provider<EditCategoryItemBlueprint> provider8, Provider<MultiselectItemBlueprint> provider9, Provider<MultiStateObjectsItemBlueprint> provider10, Provider<ButtonItemBlueprint> provider11, Provider<MultiStateInputWithTagsItemBlueprint> provider12, Provider<NoCarSlotBlueprint> provider13, Provider<CpaTariffSlotBlueprint> provider14, Provider<UserInfoItemBlueprint> provider15, Provider<LimitsInfoItemBlueprint> provider16, Provider<DisclaimerBlueprint> provider17, Provider<MarketPriceBlueprint> provider18, Provider<MarketPriceV2Blueprint> provider19, Provider<CreRangeItemBlueprint> provider20, Provider<VehicleRegNumberInputItemBlueprint> provider21, Provider<VideoItemBlueprint> provider22, Provider<LinkSlotBlueprint> provider23, Provider<HeaderWithDividerItemBlueprint> provider24, Provider<InformationWithUserIdBlueprint> provider25, Provider<ChipsMultiselectItemBlueprint> provider26, Provider<Features> provider27) {
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
        this.t = provider19;
        this.u = provider20;
        this.v = provider21;
        this.w = provider22;
        this.x = provider23;
        this.y = provider24;
        this.z = provider25;
        this.A = provider26;
        this.B = provider27;
    }

    public static PublishDetailsModule_ProvideItemBinderFactory create(PublishDetailsModule publishDetailsModule, Provider<MultiStateSelectItemBlueprint> provider, Provider<ChipsSelectItemBlueprint> provider2, Provider<RadioGroupSelectItemBlueprint> provider3, Provider<MultiStateSwitcherItemBlueprint> provider4, Provider<MultiStateInputItemBlueprint> provider5, Provider<MultiStatePhotoItemBlueprint> provider6, Provider<DateIntervalItemBlueprint> provider7, Provider<EditCategoryItemBlueprint> provider8, Provider<MultiselectItemBlueprint> provider9, Provider<MultiStateObjectsItemBlueprint> provider10, Provider<ButtonItemBlueprint> provider11, Provider<MultiStateInputWithTagsItemBlueprint> provider12, Provider<NoCarSlotBlueprint> provider13, Provider<CpaTariffSlotBlueprint> provider14, Provider<UserInfoItemBlueprint> provider15, Provider<LimitsInfoItemBlueprint> provider16, Provider<DisclaimerBlueprint> provider17, Provider<MarketPriceBlueprint> provider18, Provider<MarketPriceV2Blueprint> provider19, Provider<CreRangeItemBlueprint> provider20, Provider<VehicleRegNumberInputItemBlueprint> provider21, Provider<VideoItemBlueprint> provider22, Provider<LinkSlotBlueprint> provider23, Provider<HeaderWithDividerItemBlueprint> provider24, Provider<InformationWithUserIdBlueprint> provider25, Provider<ChipsMultiselectItemBlueprint> provider26, Provider<Features> provider27) {
        return new PublishDetailsModule_ProvideItemBinderFactory(publishDetailsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27);
    }

    public static ItemBinder provideItemBinder(PublishDetailsModule publishDetailsModule, MultiStateSelectItemBlueprint multiStateSelectItemBlueprint, ChipsSelectItemBlueprint chipsSelectItemBlueprint, RadioGroupSelectItemBlueprint radioGroupSelectItemBlueprint, MultiStateSwitcherItemBlueprint multiStateSwitcherItemBlueprint, MultiStateInputItemBlueprint multiStateInputItemBlueprint, MultiStatePhotoItemBlueprint multiStatePhotoItemBlueprint, DateIntervalItemBlueprint dateIntervalItemBlueprint, EditCategoryItemBlueprint editCategoryItemBlueprint, MultiselectItemBlueprint multiselectItemBlueprint, MultiStateObjectsItemBlueprint multiStateObjectsItemBlueprint, ButtonItemBlueprint buttonItemBlueprint, MultiStateInputWithTagsItemBlueprint multiStateInputWithTagsItemBlueprint, NoCarSlotBlueprint noCarSlotBlueprint, CpaTariffSlotBlueprint cpaTariffSlotBlueprint, UserInfoItemBlueprint userInfoItemBlueprint, LimitsInfoItemBlueprint limitsInfoItemBlueprint, DisclaimerBlueprint disclaimerBlueprint, MarketPriceBlueprint marketPriceBlueprint, MarketPriceV2Blueprint marketPriceV2Blueprint, CreRangeItemBlueprint creRangeItemBlueprint, VehicleRegNumberInputItemBlueprint vehicleRegNumberInputItemBlueprint, VideoItemBlueprint videoItemBlueprint, LinkSlotBlueprint linkSlotBlueprint, HeaderWithDividerItemBlueprint headerWithDividerItemBlueprint, InformationWithUserIdBlueprint informationWithUserIdBlueprint, ChipsMultiselectItemBlueprint chipsMultiselectItemBlueprint, Features features) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideItemBinder(multiStateSelectItemBlueprint, chipsSelectItemBlueprint, radioGroupSelectItemBlueprint, multiStateSwitcherItemBlueprint, multiStateInputItemBlueprint, multiStatePhotoItemBlueprint, dateIntervalItemBlueprint, editCategoryItemBlueprint, multiselectItemBlueprint, multiStateObjectsItemBlueprint, buttonItemBlueprint, multiStateInputWithTagsItemBlueprint, noCarSlotBlueprint, cpaTariffSlotBlueprint, userInfoItemBlueprint, limitsInfoItemBlueprint, disclaimerBlueprint, marketPriceBlueprint, marketPriceV2Blueprint, creRangeItemBlueprint, vehicleRegNumberInputItemBlueprint, videoItemBlueprint, linkSlotBlueprint, headerWithDividerItemBlueprint, informationWithUserIdBlueprint, chipsMultiselectItemBlueprint, features));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get(), this.x.get(), this.y.get(), this.z.get(), this.A.get(), this.B.get());
    }
}
