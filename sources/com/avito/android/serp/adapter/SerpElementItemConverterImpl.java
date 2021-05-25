package com.avito.android.serp.adapter;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.HeaderElement;
import com.avito.android.remote.model.SellerElement;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpAdvertEmptyPlaceholder;
import com.avito.android.remote.model.SerpAdvertGroupTitle;
import com.avito.android.remote.model.SerpAdvertXl;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpPromoCardModel;
import com.avito.android.remote.model.SerpVipAdverts;
import com.avito.android.remote.model.SerpWarning;
import com.avito.android.remote.model.ShortcutBanner;
import com.avito.android.remote.model.WitcherElement;
import com.avito.android.remote.model.feature_teaser.CreReportTeaser;
import com.avito.android.remote.model.location_notification.LocationNotification;
import com.avito.android.remote.model.map_banner.MapBanner;
import com.avito.android.remote.model.serp.Snippet;
import com.avito.android.remote.model.vertical_main.SearchFormWidget;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter;
import com.avito.android.serp.adapter.empty_search.EmptySearchElement;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemConverter;
import com.avito.android.serp.adapter.promo_card.PromoCardConverter;
import com.avito.android.serp.adapter.promo_card.ReportBannerConverter;
import com.avito.android.serp.adapter.snippet.SnippetConverter;
import com.avito.android.serp.adapter.title.GroupTitleItemConverter;
import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItem;
import com.avito.android.serp.adapter.warning.SerpWarningConverter;
import com.avito.android.serp.adapter.witcher.WitcherElementConverter;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010D\u001a\u00020B\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010L\u001a\u00020I¢\u0006\u0004\bQ\u0010RJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ1\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/avito/android/serp/adapter/SerpElementItemConverterImpl;", "Lcom/avito/android/serp/adapter/SerpElementItemConverter;", "", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "convert", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)Ljava/util/List;", "", "isVip", AuthSource.SEND_ABUSE, "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;Z)Ljava/util/List;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemConverter;", "p", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemConverter;", "mapBannerItemConverter", "Lcom/avito/android/serp/adapter/promo_card/PromoCardConverter;", "o", "Lcom/avito/android/serp/adapter/promo_card/PromoCardConverter;", "promoCardConverter", "Lcom/avito/android/serp/adapter/HeaderElementConverter;", "j", "Lcom/avito/android/serp/adapter/HeaderElementConverter;", "headerElementConverter", "Lcom/avito/android/serp/adapter/witcher/WitcherElementConverter;", "k", "Lcom/avito/android/serp/adapter/witcher/WitcherElementConverter;", "witcherElementConverter", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemConverter;", "l", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemConverter;", "locationNotificationItemConverter", "Lcom/avito/android/serp/adapter/advert_xl/SerpAdvertXlConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/advert_xl/SerpAdvertXlConverter;", "serpAdvertXlConverter", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemConverter;", "i", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemConverter;", "emptyPlaceholderItemConverter", "Lcom/avito/android/serp/adapter/snippet/SnippetConverter;", "f", "Lcom/avito/android/serp/adapter/snippet/SnippetConverter;", "snippetConverter", "Lcom/avito/android/serp/adapter/promo_card/ReportBannerConverter;", "n", "Lcom/avito/android/serp/adapter/promo_card/ReportBannerConverter;", "reportBannerConverter", "Lcom/avito/android/serp/adapter/title/GroupTitleItemConverter;", "h", "Lcom/avito/android/serp/adapter/title/GroupTitleItemConverter;", "groupTitleItemConverter", "Lcom/avito/android/serp/adapter/ShortcutBannerConverter;", "d", "Lcom/avito/android/serp/adapter/ShortcutBannerConverter;", "shortcutBannerConverter", "Lcom/avito/android/serp/adapter/warning/SerpWarningConverter;", "e", "Lcom/avito/android/serp/adapter/warning/SerpWarningConverter;", "serpWarningConverter", "Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemConverter;", g.a, "Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemConverter;", "emptySearchItemConverter", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "serpAdvertConverter", "Lcom/avito/android/serp/adapter/SellerElementConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/serp/adapter/SellerElementConverter;", "sellerElementConverter", "Lcom/avito/android/serp/adapter/vertical_main/VerticalFilterItemConverter;", VKApiConst.Q, "Lcom/avito/android/serp/adapter/vertical_main/VerticalFilterItemConverter;", "verticalMainWidgetsConverter", "Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;", "c", "Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;", "serpCommercialBannerConverter", "<init>", "(Lcom/avito/android/serp/adapter/SerpAdvertConverter;Lcom/avito/android/serp/adapter/advert_xl/SerpAdvertXlConverter;Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;Lcom/avito/android/serp/adapter/ShortcutBannerConverter;Lcom/avito/android/serp/adapter/warning/SerpWarningConverter;Lcom/avito/android/serp/adapter/snippet/SnippetConverter;Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemConverter;Lcom/avito/android/serp/adapter/title/GroupTitleItemConverter;Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemConverter;Lcom/avito/android/serp/adapter/HeaderElementConverter;Lcom/avito/android/serp/adapter/witcher/WitcherElementConverter;Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemConverter;Lcom/avito/android/serp/adapter/SellerElementConverter;Lcom/avito/android/serp/adapter/promo_card/ReportBannerConverter;Lcom/avito/android/serp/adapter/promo_card/PromoCardConverter;Lcom/avito/android/serp/adapter/map_banner/MapBannerItemConverter;Lcom/avito/android/serp/adapter/vertical_main/VerticalFilterItemConverter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpElementItemConverterImpl implements SerpElementItemConverter {
    public final SerpAdvertConverter a;
    public final SerpAdvertXlConverter b;
    public final SerpCommercialBannerConverter c;
    public final ShortcutBannerConverter d;
    public final SerpWarningConverter e;
    public final SnippetConverter f;
    public final EmptySearchItemConverter g;
    public final GroupTitleItemConverter h;
    public final EmptyPlaceholderItemConverter i;
    public final HeaderElementConverter j;
    public final WitcherElementConverter k;
    public final LocationNotificationItemConverter l;
    public final SellerElementConverter m;
    public final ReportBannerConverter n;
    public final PromoCardConverter o;
    public final MapBannerItemConverter p;
    public final VerticalFilterItemConverter q;

    public SerpElementItemConverterImpl(@NotNull SerpAdvertConverter serpAdvertConverter, @NotNull SerpAdvertXlConverter serpAdvertXlConverter, @NotNull SerpCommercialBannerConverter serpCommercialBannerConverter, @NotNull ShortcutBannerConverter shortcutBannerConverter, @NotNull SerpWarningConverter serpWarningConverter, @NotNull SnippetConverter snippetConverter, @NotNull EmptySearchItemConverter emptySearchItemConverter, @NotNull GroupTitleItemConverter groupTitleItemConverter, @NotNull EmptyPlaceholderItemConverter emptyPlaceholderItemConverter, @NotNull HeaderElementConverter headerElementConverter, @NotNull WitcherElementConverter witcherElementConverter, @NotNull LocationNotificationItemConverter locationNotificationItemConverter, @NotNull SellerElementConverter sellerElementConverter, @NotNull ReportBannerConverter reportBannerConverter, @NotNull PromoCardConverter promoCardConverter, @NotNull MapBannerItemConverter mapBannerItemConverter, @NotNull VerticalFilterItemConverter verticalFilterItemConverter) {
        Intrinsics.checkNotNullParameter(serpAdvertConverter, "serpAdvertConverter");
        Intrinsics.checkNotNullParameter(serpAdvertXlConverter, "serpAdvertXlConverter");
        Intrinsics.checkNotNullParameter(serpCommercialBannerConverter, "serpCommercialBannerConverter");
        Intrinsics.checkNotNullParameter(shortcutBannerConverter, "shortcutBannerConverter");
        Intrinsics.checkNotNullParameter(serpWarningConverter, "serpWarningConverter");
        Intrinsics.checkNotNullParameter(snippetConverter, "snippetConverter");
        Intrinsics.checkNotNullParameter(emptySearchItemConverter, "emptySearchItemConverter");
        Intrinsics.checkNotNullParameter(groupTitleItemConverter, "groupTitleItemConverter");
        Intrinsics.checkNotNullParameter(emptyPlaceholderItemConverter, "emptyPlaceholderItemConverter");
        Intrinsics.checkNotNullParameter(headerElementConverter, "headerElementConverter");
        Intrinsics.checkNotNullParameter(witcherElementConverter, "witcherElementConverter");
        Intrinsics.checkNotNullParameter(locationNotificationItemConverter, "locationNotificationItemConverter");
        Intrinsics.checkNotNullParameter(sellerElementConverter, "sellerElementConverter");
        Intrinsics.checkNotNullParameter(reportBannerConverter, "reportBannerConverter");
        Intrinsics.checkNotNullParameter(promoCardConverter, "promoCardConverter");
        Intrinsics.checkNotNullParameter(mapBannerItemConverter, "mapBannerItemConverter");
        Intrinsics.checkNotNullParameter(verticalFilterItemConverter, "verticalMainWidgetsConverter");
        this.a = serpAdvertConverter;
        this.b = serpAdvertXlConverter;
        this.c = serpCommercialBannerConverter;
        this.d = shortcutBannerConverter;
        this.e = serpWarningConverter;
        this.f = snippetConverter;
        this.g = emptySearchItemConverter;
        this.h = groupTitleItemConverter;
        this.i = emptyPlaceholderItemConverter;
        this.j = headerElementConverter;
        this.k = witcherElementConverter;
        this.l = locationNotificationItemConverter;
        this.m = sellerElementConverter;
        this.n = reportBannerConverter;
        this.o = promoCardConverter;
        this.p = mapBannerItemConverter;
        this.q = verticalFilterItemConverter;
    }

    public final List<ViewTypeSerpItem> a(List<? extends SerpElement> list, SerpDisplayType serpDisplayType, boolean z) {
        VerticalFilterItem convertItem;
        ArrayList arrayList = new ArrayList(list.size());
        for (T t : list) {
            if (t instanceof SerpAdvertXl) {
                arrayList.add(this.b.convert(t, serpDisplayType));
            } else if (t instanceof SerpAdvert) {
                arrayList.add(this.a.convert(t, z, serpDisplayType));
            } else if (t instanceof SerpVipAdverts) {
                h.addAll(arrayList, a(t.getAdverts(), serpDisplayType, true));
            } else if (t instanceof SerpCommercialBanner) {
                arrayList.add(this.c.convert(t, serpDisplayType));
            } else if (t instanceof ShortcutBanner) {
                arrayList.add(ShortcutBannerConverter.DefaultImpls.convert$default(this.d, t, null, 2, null));
            } else if (t instanceof SerpWarning) {
                arrayList.add(this.e.convert(t));
            } else if (t instanceof Snippet) {
                arrayList.add(this.f.convert(t));
            } else if (t instanceof EmptySearchElement) {
                arrayList.add(this.g.convert(t));
            } else if (t instanceof SerpAdvertGroupTitle) {
                arrayList.add(this.h.convert(t));
            } else if (t instanceof SerpAdvertEmptyPlaceholder) {
                arrayList.add(this.i.convert(t));
            } else if (t instanceof HeaderElement) {
                arrayList.add(this.j.convert(t));
            } else if (t instanceof WitcherElement) {
                arrayList.add(this.k.convert(t));
            } else if (t instanceof LocationNotification) {
                arrayList.add(this.l.convert(t));
            } else if (t instanceof SellerElement) {
                arrayList.add(this.m.convert(t));
            } else if (t instanceof CreReportTeaser) {
                arrayList.add(this.n.convert(t));
            } else if (t instanceof SerpPromoCardModel) {
                arrayList.add(this.o.convert(t));
            } else if (t instanceof MapBanner) {
                arrayList.add(this.p.convert(t));
            } else if ((t instanceof SearchFormWidget) && (convertItem = this.q.convertItem(t)) != null) {
                arrayList.add(convertItem);
            }
        }
        return CollectionsKt___CollectionsKt.filterNotNull(arrayList);
    }

    @Override // com.avito.android.serp.adapter.SerpElementItemConverter
    @NotNull
    public List<ViewTypeSerpItem> convert(@NotNull List<? extends SerpElement> list, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        return a(list, serpDisplayType, false);
    }
}
