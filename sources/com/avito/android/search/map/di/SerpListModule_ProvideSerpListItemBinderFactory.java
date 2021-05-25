package com.avito.android.search.map.di;

import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallDoubleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentDoubleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedDoubleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallListBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentListBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallDoubleItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallListItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallSingleItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentDoubleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentListBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentSingleGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdRichStubBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubGridBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubListBlueprint;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemBlueprint;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemBlueprint;
import com.avito.android.serp.adapter.map_banner.MapBannerItemBlueprint;
import com.avito.android.serp.adapter.promo_card.PromoCardBlueprint;
import com.avito.android.serp.adapter.rich_snippets.YandexAppInstallRichBlueprint;
import com.avito.android.serp.adapter.rich_snippets.YandexContentRichBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertVipRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemBlueprint;
import com.avito.android.serp.adapter.snippet.SnippetBlueprint;
import com.avito.android.serp.adapter.title.GroupTitleItemBlueprint;
import com.avito.android.serp.adapter.warning.SerpWarningItemBlueprint;
import com.avito.android.serp.adapter.witcher.WitcherItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpListModule_ProvideSerpListItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<EmptyAdStubItemBlueprint> A;
    public final Provider<SerpWarningItemBlueprint> B;
    public final Provider<SnippetBlueprint> C;
    public final Provider<GroupTitleItemBlueprint> D;
    public final Provider<EmptyPlaceholderItemBlueprint> E;
    public final Provider<YandexContentListBlueprint> F;
    public final Provider<YandexAppInstallListItemBlueprint> G;
    public final Provider<DfpUnifiedListBlueprint> H;
    public final Provider<DfpContentListBlueprint> I;
    public final Provider<DfpAppInstallListBlueprint> J;
    public final Provider<MyTargetContentListBlueprint> K;
    public final Provider<MyTargetAppInstallListBlueprint> L;
    public final Provider<NotLoadAdStubListBlueprint> M;
    public final Provider<NotLoadAdRichStubBlueprint> N;
    public final Provider<WitcherItemBlueprint> O;
    public final Provider<PromoCardBlueprint> P;
    public final Provider<MapBannerItemBlueprint> Q;
    public final Provider<AdvertItemGridBlueprint> a;
    public final Provider<AdvertItemListBlueprint> b;
    public final Provider<AdvertItemDoubleBlueprint> c;
    public final Provider<AdvertXlItemBlueprint> d;
    public final Provider<AdvertVipRichItemBlueprint> e;
    public final Provider<AdvertXlRichItemBlueprint> f;
    public final Provider<AdvertRichItemBlueprint> g;
    public final Provider<YandexContentSingleGridBlueprint> h;
    public final Provider<YandexContentDoubleGridBlueprint> i;
    public final Provider<YandexContentRichBlueprint> j;
    public final Provider<YandexAppInstallSingleItemBlueprint> k;
    public final Provider<YandexAppInstallDoubleItemBlueprint> l;
    public final Provider<YandexAppInstallRichBlueprint> m;
    public final Provider<AdfoxSingleGridBlueprint> n;
    public final Provider<AdfoxSingleListBlueprint> o;
    public final Provider<DfpUnifiedDoubleBlueprint> p;
    public final Provider<DfpAppInstallDoubleBlueprint> q;
    public final Provider<DfpAppInstallSingleBlueprint> r;
    public final Provider<DfpUnifiedSingleGridBlueprint> s;
    public final Provider<DfpContentSingleGridBlueprint> t;
    public final Provider<DfpContentDoubleGridBlueprint> u;
    public final Provider<MyTargetContentBlueprint> v;
    public final Provider<MyTargetAppInstallSingleBlueprint> w;
    public final Provider<MyTargetAppInstallBlueprint> x;
    public final Provider<MyTargetContentSingleBlueprint> y;
    public final Provider<NotLoadAdStubGridBlueprint> z;

    public SerpListModule_ProvideSerpListItemBinderFactory(Provider<AdvertItemGridBlueprint> provider, Provider<AdvertItemListBlueprint> provider2, Provider<AdvertItemDoubleBlueprint> provider3, Provider<AdvertXlItemBlueprint> provider4, Provider<AdvertVipRichItemBlueprint> provider5, Provider<AdvertXlRichItemBlueprint> provider6, Provider<AdvertRichItemBlueprint> provider7, Provider<YandexContentSingleGridBlueprint> provider8, Provider<YandexContentDoubleGridBlueprint> provider9, Provider<YandexContentRichBlueprint> provider10, Provider<YandexAppInstallSingleItemBlueprint> provider11, Provider<YandexAppInstallDoubleItemBlueprint> provider12, Provider<YandexAppInstallRichBlueprint> provider13, Provider<AdfoxSingleGridBlueprint> provider14, Provider<AdfoxSingleListBlueprint> provider15, Provider<DfpUnifiedDoubleBlueprint> provider16, Provider<DfpAppInstallDoubleBlueprint> provider17, Provider<DfpAppInstallSingleBlueprint> provider18, Provider<DfpUnifiedSingleGridBlueprint> provider19, Provider<DfpContentSingleGridBlueprint> provider20, Provider<DfpContentDoubleGridBlueprint> provider21, Provider<MyTargetContentBlueprint> provider22, Provider<MyTargetAppInstallSingleBlueprint> provider23, Provider<MyTargetAppInstallBlueprint> provider24, Provider<MyTargetContentSingleBlueprint> provider25, Provider<NotLoadAdStubGridBlueprint> provider26, Provider<EmptyAdStubItemBlueprint> provider27, Provider<SerpWarningItemBlueprint> provider28, Provider<SnippetBlueprint> provider29, Provider<GroupTitleItemBlueprint> provider30, Provider<EmptyPlaceholderItemBlueprint> provider31, Provider<YandexContentListBlueprint> provider32, Provider<YandexAppInstallListItemBlueprint> provider33, Provider<DfpUnifiedListBlueprint> provider34, Provider<DfpContentListBlueprint> provider35, Provider<DfpAppInstallListBlueprint> provider36, Provider<MyTargetContentListBlueprint> provider37, Provider<MyTargetAppInstallListBlueprint> provider38, Provider<NotLoadAdStubListBlueprint> provider39, Provider<NotLoadAdRichStubBlueprint> provider40, Provider<WitcherItemBlueprint> provider41, Provider<PromoCardBlueprint> provider42, Provider<MapBannerItemBlueprint> provider43) {
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
        this.r = provider18;
        this.s = provider19;
        this.t = provider20;
        this.u = provider21;
        this.v = provider22;
        this.w = provider23;
        this.x = provider24;
        this.y = provider25;
        this.z = provider26;
        this.A = provider27;
        this.B = provider28;
        this.C = provider29;
        this.D = provider30;
        this.E = provider31;
        this.F = provider32;
        this.G = provider33;
        this.H = provider34;
        this.I = provider35;
        this.J = provider36;
        this.K = provider37;
        this.L = provider38;
        this.M = provider39;
        this.N = provider40;
        this.O = provider41;
        this.P = provider42;
        this.Q = provider43;
    }

    public static SerpListModule_ProvideSerpListItemBinderFactory create(Provider<AdvertItemGridBlueprint> provider, Provider<AdvertItemListBlueprint> provider2, Provider<AdvertItemDoubleBlueprint> provider3, Provider<AdvertXlItemBlueprint> provider4, Provider<AdvertVipRichItemBlueprint> provider5, Provider<AdvertXlRichItemBlueprint> provider6, Provider<AdvertRichItemBlueprint> provider7, Provider<YandexContentSingleGridBlueprint> provider8, Provider<YandexContentDoubleGridBlueprint> provider9, Provider<YandexContentRichBlueprint> provider10, Provider<YandexAppInstallSingleItemBlueprint> provider11, Provider<YandexAppInstallDoubleItemBlueprint> provider12, Provider<YandexAppInstallRichBlueprint> provider13, Provider<AdfoxSingleGridBlueprint> provider14, Provider<AdfoxSingleListBlueprint> provider15, Provider<DfpUnifiedDoubleBlueprint> provider16, Provider<DfpAppInstallDoubleBlueprint> provider17, Provider<DfpAppInstallSingleBlueprint> provider18, Provider<DfpUnifiedSingleGridBlueprint> provider19, Provider<DfpContentSingleGridBlueprint> provider20, Provider<DfpContentDoubleGridBlueprint> provider21, Provider<MyTargetContentBlueprint> provider22, Provider<MyTargetAppInstallSingleBlueprint> provider23, Provider<MyTargetAppInstallBlueprint> provider24, Provider<MyTargetContentSingleBlueprint> provider25, Provider<NotLoadAdStubGridBlueprint> provider26, Provider<EmptyAdStubItemBlueprint> provider27, Provider<SerpWarningItemBlueprint> provider28, Provider<SnippetBlueprint> provider29, Provider<GroupTitleItemBlueprint> provider30, Provider<EmptyPlaceholderItemBlueprint> provider31, Provider<YandexContentListBlueprint> provider32, Provider<YandexAppInstallListItemBlueprint> provider33, Provider<DfpUnifiedListBlueprint> provider34, Provider<DfpContentListBlueprint> provider35, Provider<DfpAppInstallListBlueprint> provider36, Provider<MyTargetContentListBlueprint> provider37, Provider<MyTargetAppInstallListBlueprint> provider38, Provider<NotLoadAdStubListBlueprint> provider39, Provider<NotLoadAdRichStubBlueprint> provider40, Provider<WitcherItemBlueprint> provider41, Provider<PromoCardBlueprint> provider42, Provider<MapBannerItemBlueprint> provider43) {
        return new SerpListModule_ProvideSerpListItemBinderFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37, provider38, provider39, provider40, provider41, provider42, provider43);
    }

    public static ItemBinder provideSerpListItemBinder(AdvertItemGridBlueprint advertItemGridBlueprint, AdvertItemListBlueprint advertItemListBlueprint, AdvertItemDoubleBlueprint advertItemDoubleBlueprint, AdvertXlItemBlueprint advertXlItemBlueprint, AdvertVipRichItemBlueprint advertVipRichItemBlueprint, AdvertXlRichItemBlueprint advertXlRichItemBlueprint, AdvertRichItemBlueprint advertRichItemBlueprint, YandexContentSingleGridBlueprint yandexContentSingleGridBlueprint, YandexContentDoubleGridBlueprint yandexContentDoubleGridBlueprint, YandexContentRichBlueprint yandexContentRichBlueprint, YandexAppInstallSingleItemBlueprint yandexAppInstallSingleItemBlueprint, YandexAppInstallDoubleItemBlueprint yandexAppInstallDoubleItemBlueprint, YandexAppInstallRichBlueprint yandexAppInstallRichBlueprint, AdfoxSingleGridBlueprint adfoxSingleGridBlueprint, AdfoxSingleListBlueprint adfoxSingleListBlueprint, DfpUnifiedDoubleBlueprint dfpUnifiedDoubleBlueprint, DfpAppInstallDoubleBlueprint dfpAppInstallDoubleBlueprint, DfpAppInstallSingleBlueprint dfpAppInstallSingleBlueprint, DfpUnifiedSingleGridBlueprint dfpUnifiedSingleGridBlueprint, DfpContentSingleGridBlueprint dfpContentSingleGridBlueprint, DfpContentDoubleGridBlueprint dfpContentDoubleGridBlueprint, MyTargetContentBlueprint myTargetContentBlueprint, MyTargetAppInstallSingleBlueprint myTargetAppInstallSingleBlueprint, MyTargetAppInstallBlueprint myTargetAppInstallBlueprint, MyTargetContentSingleBlueprint myTargetContentSingleBlueprint, NotLoadAdStubGridBlueprint notLoadAdStubGridBlueprint, EmptyAdStubItemBlueprint emptyAdStubItemBlueprint, SerpWarningItemBlueprint serpWarningItemBlueprint, SnippetBlueprint snippetBlueprint, GroupTitleItemBlueprint groupTitleItemBlueprint, EmptyPlaceholderItemBlueprint emptyPlaceholderItemBlueprint, YandexContentListBlueprint yandexContentListBlueprint, YandexAppInstallListItemBlueprint yandexAppInstallListItemBlueprint, DfpUnifiedListBlueprint dfpUnifiedListBlueprint, DfpContentListBlueprint dfpContentListBlueprint, DfpAppInstallListBlueprint dfpAppInstallListBlueprint, MyTargetContentListBlueprint myTargetContentListBlueprint, MyTargetAppInstallListBlueprint myTargetAppInstallListBlueprint, NotLoadAdStubListBlueprint notLoadAdStubListBlueprint, NotLoadAdRichStubBlueprint notLoadAdRichStubBlueprint, WitcherItemBlueprint witcherItemBlueprint, PromoCardBlueprint promoCardBlueprint, MapBannerItemBlueprint mapBannerItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(SerpListModule.provideSerpListItemBinder(advertItemGridBlueprint, advertItemListBlueprint, advertItemDoubleBlueprint, advertXlItemBlueprint, advertVipRichItemBlueprint, advertXlRichItemBlueprint, advertRichItemBlueprint, yandexContentSingleGridBlueprint, yandexContentDoubleGridBlueprint, yandexContentRichBlueprint, yandexAppInstallSingleItemBlueprint, yandexAppInstallDoubleItemBlueprint, yandexAppInstallRichBlueprint, adfoxSingleGridBlueprint, adfoxSingleListBlueprint, dfpUnifiedDoubleBlueprint, dfpAppInstallDoubleBlueprint, dfpAppInstallSingleBlueprint, dfpUnifiedSingleGridBlueprint, dfpContentSingleGridBlueprint, dfpContentDoubleGridBlueprint, myTargetContentBlueprint, myTargetAppInstallSingleBlueprint, myTargetAppInstallBlueprint, myTargetContentSingleBlueprint, notLoadAdStubGridBlueprint, emptyAdStubItemBlueprint, serpWarningItemBlueprint, snippetBlueprint, groupTitleItemBlueprint, emptyPlaceholderItemBlueprint, yandexContentListBlueprint, yandexAppInstallListItemBlueprint, dfpUnifiedListBlueprint, dfpContentListBlueprint, dfpAppInstallListBlueprint, myTargetContentListBlueprint, myTargetAppInstallListBlueprint, notLoadAdStubListBlueprint, notLoadAdRichStubBlueprint, witcherItemBlueprint, promoCardBlueprint, mapBannerItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideSerpListItemBinder(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get(), this.x.get(), this.y.get(), this.z.get(), this.A.get(), this.B.get(), this.C.get(), this.D.get(), this.E.get(), this.F.get(), this.G.get(), this.H.get(), this.I.get(), this.J.get(), this.K.get(), this.L.get(), this.M.get(), this.N.get(), this.O.get(), this.P.get(), this.Q.get());
    }
}
