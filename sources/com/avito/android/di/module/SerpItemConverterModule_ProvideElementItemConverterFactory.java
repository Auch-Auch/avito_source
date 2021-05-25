package com.avito.android.di.module;

import com.avito.android.serp.adapter.HeaderElementConverter;
import com.avito.android.serp.adapter.SellerElementConverter;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemConverter;
import com.avito.android.serp.adapter.promo_card.PromoCardConverter;
import com.avito.android.serp.adapter.promo_card.ReportBannerConverter;
import com.avito.android.serp.adapter.snippet.SnippetConverter;
import com.avito.android.serp.adapter.title.GroupTitleItemConverter;
import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter;
import com.avito.android.serp.adapter.warning.SerpWarningConverter;
import com.avito.android.serp.adapter.witcher.WitcherElementConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideElementItemConverterFactory implements Factory<SerpElementItemConverter> {
    public final Provider<SerpAdvertConverter> a;
    public final Provider<SerpAdvertXlConverter> b;
    public final Provider<SerpCommercialBannerConverter> c;
    public final Provider<ShortcutBannerConverter> d;
    public final Provider<SerpWarningConverter> e;
    public final Provider<SnippetConverter> f;
    public final Provider<EmptySearchItemConverter> g;
    public final Provider<GroupTitleItemConverter> h;
    public final Provider<EmptyPlaceholderItemConverter> i;
    public final Provider<HeaderElementConverter> j;
    public final Provider<WitcherElementConverter> k;
    public final Provider<LocationNotificationItemConverter> l;
    public final Provider<SellerElementConverter> m;
    public final Provider<ReportBannerConverter> n;
    public final Provider<PromoCardConverter> o;
    public final Provider<MapBannerItemConverter> p;
    public final Provider<VerticalFilterItemConverter> q;

    public SerpItemConverterModule_ProvideElementItemConverterFactory(Provider<SerpAdvertConverter> provider, Provider<SerpAdvertXlConverter> provider2, Provider<SerpCommercialBannerConverter> provider3, Provider<ShortcutBannerConverter> provider4, Provider<SerpWarningConverter> provider5, Provider<SnippetConverter> provider6, Provider<EmptySearchItemConverter> provider7, Provider<GroupTitleItemConverter> provider8, Provider<EmptyPlaceholderItemConverter> provider9, Provider<HeaderElementConverter> provider10, Provider<WitcherElementConverter> provider11, Provider<LocationNotificationItemConverter> provider12, Provider<SellerElementConverter> provider13, Provider<ReportBannerConverter> provider14, Provider<PromoCardConverter> provider15, Provider<MapBannerItemConverter> provider16, Provider<VerticalFilterItemConverter> provider17) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
    }

    public static SerpItemConverterModule_ProvideElementItemConverterFactory create(Provider<SerpAdvertConverter> provider, Provider<SerpAdvertXlConverter> provider2, Provider<SerpCommercialBannerConverter> provider3, Provider<ShortcutBannerConverter> provider4, Provider<SerpWarningConverter> provider5, Provider<SnippetConverter> provider6, Provider<EmptySearchItemConverter> provider7, Provider<GroupTitleItemConverter> provider8, Provider<EmptyPlaceholderItemConverter> provider9, Provider<HeaderElementConverter> provider10, Provider<WitcherElementConverter> provider11, Provider<LocationNotificationItemConverter> provider12, Provider<SellerElementConverter> provider13, Provider<ReportBannerConverter> provider14, Provider<PromoCardConverter> provider15, Provider<MapBannerItemConverter> provider16, Provider<VerticalFilterItemConverter> provider17) {
        return new SerpItemConverterModule_ProvideElementItemConverterFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    public static SerpElementItemConverter provideElementItemConverter(SerpAdvertConverter serpAdvertConverter, SerpAdvertXlConverter serpAdvertXlConverter, SerpCommercialBannerConverter serpCommercialBannerConverter, ShortcutBannerConverter shortcutBannerConverter, SerpWarningConverter serpWarningConverter, SnippetConverter snippetConverter, EmptySearchItemConverter emptySearchItemConverter, GroupTitleItemConverter groupTitleItemConverter, EmptyPlaceholderItemConverter emptyPlaceholderItemConverter, HeaderElementConverter headerElementConverter, WitcherElementConverter witcherElementConverter, LocationNotificationItemConverter locationNotificationItemConverter, SellerElementConverter sellerElementConverter, ReportBannerConverter reportBannerConverter, PromoCardConverter promoCardConverter, MapBannerItemConverter mapBannerItemConverter, VerticalFilterItemConverter verticalFilterItemConverter) {
        return (SerpElementItemConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideElementItemConverter(serpAdvertConverter, serpAdvertXlConverter, serpCommercialBannerConverter, shortcutBannerConverter, serpWarningConverter, snippetConverter, emptySearchItemConverter, groupTitleItemConverter, emptyPlaceholderItemConverter, headerElementConverter, witcherElementConverter, locationNotificationItemConverter, sellerElementConverter, reportBannerConverter, promoCardConverter, mapBannerItemConverter, verticalFilterItemConverter));
    }

    @Override // javax.inject.Provider
    public SerpElementItemConverter get() {
        return provideElementItemConverter(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get());
    }
}
