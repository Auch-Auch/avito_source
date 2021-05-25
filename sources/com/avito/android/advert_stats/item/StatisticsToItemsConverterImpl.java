package com.avito.android.advert_stats.item;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.advert_stats.item.details.StatDetailItem;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerItem;
import com.avito.android.advert_stats.item.hint.HintItem;
import com.avito.android.advert_stats.item.period.PeriodItem;
import com.avito.android.advert_stats.item.title.TitleItem;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.db.FavoritesContract;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/advert_stats/item/StatisticsToItemsConverterImpl;", "Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;", "Lcom/avito/android/advert_stats/remote/model/AdvertStatistics;", "stat", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/advert_stats/remote/model/AdvertStatistics;)Ljava/util/List;", "items", "Lcom/avito/android/advert_stats/item/SelectablePlotItem;", "selectedItem", "updateItems", "(Ljava/util/List;Lcom/avito/android/advert_stats/item/SelectablePlotItem;)Ljava/util/List;", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItem;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItem;", "", "showLegend", "", "status", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/advert_stats/item/SelectablePlotItem;ZLjava/lang/String;)Ljava/util/List;", "Lcom/avito/android/advert_stats/item/StatisticDatesFormatter;", "c", "Lcom/avito/android/advert_stats/item/StatisticDatesFormatter;", "formatter", "Lcom/avito/android/advert_stats/item/StatisticsIconProvider;", "Lcom/avito/android/advert_stats/item/StatisticsIconProvider;", "iconProvider", "Lcom/avito/android/advert_stats/item/StatisticStringResourceProvider;", "Lcom/avito/android/advert_stats/item/StatisticStringResourceProvider;", "stringProvider", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "e", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "bivrostSessionStorage", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/advert_stats/item/StatisticStringResourceProvider;Lcom/avito/android/advert_stats/item/StatisticsIconProvider;Lcom/avito/android/advert_stats/item/StatisticDatesFormatter;Lcom/avito/android/Features;Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatisticsToItemsConverterImpl implements StatisticsToItemsConverter {
    public final StatisticStringResourceProvider a;
    public final StatisticsIconProvider b;
    public final StatisticDatesFormatter c;
    public final Features d;
    public final BivrostTutorialSessionStorage e;

    @Inject
    public StatisticsToItemsConverterImpl(@NotNull StatisticStringResourceProvider statisticStringResourceProvider, @NotNull StatisticsIconProvider statisticsIconProvider, @NotNull StatisticDatesFormatter statisticDatesFormatter, @NotNull Features features, @NotNull BivrostTutorialSessionStorage bivrostTutorialSessionStorage) {
        Intrinsics.checkNotNullParameter(statisticStringResourceProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(statisticsIconProvider, "iconProvider");
        Intrinsics.checkNotNullParameter(statisticDatesFormatter, "formatter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(bivrostTutorialSessionStorage, "bivrostSessionStorage");
        this.a = statisticStringResourceProvider;
        this.b = statisticsIconProvider;
        this.c = statisticDatesFormatter;
        this.d = features;
        this.e = bivrostTutorialSessionStorage;
    }

    public final NewStatisticsBannerItem a() {
        NewStatisticsBannerItem newStatisticsBannerItem = new NewStatisticsBannerItem("new_statistics_banner");
        if (this.d.getBivrostStatsTutorial().invoke().booleanValue() && this.e.getStatisticsBannerVisible()) {
            return newStatisticsBannerItem;
        }
        return null;
    }

    public final List<Item> b(SelectablePlotItem selectablePlotItem, boolean z, String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            StringBuilder L = a.L("status");
            L.append(selectablePlotItem.getStringId());
            arrayList.add(new StatDetailItem(L.toString(), str, null, null, true, false, 44, null));
        }
        Integer views = selectablePlotItem.getViews();
        if (views != null) {
            int intValue = views.intValue();
            StringBuilder L2 = a.L("views");
            L2.append(selectablePlotItem.getStringId());
            arrayList.add(new StatDetailItem(L2.toString(), this.a.getViews(intValue), Integer.valueOf(this.b.getViewsIcon()), null, false, false, 56, null));
        }
        Integer contacts = selectablePlotItem.getContacts();
        if (contacts != null) {
            int intValue2 = contacts.intValue();
            StringBuilder L3 = a.L("contacts");
            L3.append(selectablePlotItem.getStringId());
            arrayList.add(new StatDetailItem(L3.toString(), this.a.getContacts(intValue2), Integer.valueOf(this.b.getContactsIcon()), null, false, false, 56, null));
        }
        Integer favorites = selectablePlotItem.getFavorites();
        if (favorites != null) {
            int intValue3 = favorites.intValue();
            StringBuilder L4 = a.L(FavoritesContract.TABLE_NAME);
            L4.append(selectablePlotItem.getStringId());
            arrayList.add(new StatDetailItem(L4.toString(), this.a.getFavorites(intValue3), Integer.valueOf(this.b.getFavoritesIcon()), null, false, false, 56, null));
        }
        if (z) {
            String stringId = selectablePlotItem.getStringId();
            arrayList.addAll(CollectionsKt__CollectionsKt.listOf((Object[]) new StatDetailItem[]{new StatDetailItem(a.c3("predict_views", stringId), this.a.getLegendPredictViews(), Integer.valueOf(this.b.getLegendPredictViewsIcon()), null, false, false, 56, null), new StatDetailItem(a.c3("legend_views", stringId), this.a.getLegendGeneralViews(), Integer.valueOf(this.b.getLegendAllViewsIcon()), null, false, false, 56, null)}));
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x014c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v25, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.advert_stats.item.StatisticsToItemsConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.conveyor_item.Item> convert(@org.jetbrains.annotations.NotNull com.avito.android.advert_stats.remote.model.AdvertStatistics r30) {
        /*
        // Method dump skipped, instructions count: 673
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert_stats.item.StatisticsToItemsConverterImpl.convert(com.avito.android.advert_stats.remote.model.AdvertStatistics):java.util.List");
    }

    @Override // com.avito.android.advert_stats.item.StatisticsToItemsConverter
    @NotNull
    public List<Item> updateItems(@NotNull List<? extends Item> list, @NotNull SelectablePlotItem selectablePlotItem) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(selectablePlotItem, "selectedItem");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof TitleItem) {
                arrayList.add(t);
            } else if (t instanceof PeriodItem) {
                StringBuilder L = a.L("period");
                L.append(selectablePlotItem.getId());
                arrayList.add(new PeriodItem(L.toString(), selectablePlotItem.getPeriod(), false, 4, null));
            } else if (t instanceof HintItem) {
                arrayList.add(t);
            } else if (t instanceof PlotItem) {
                arrayList.add(t);
            } else if (t instanceof NewStatisticsBannerItem) {
                arrayList.add(t);
            }
        }
        if (selectablePlotItem instanceof BarItem) {
            arrayList.addAll(b(selectablePlotItem, !((BarItem) selectablePlotItem).getVasList().isEmpty(), selectablePlotItem.getStatus()));
            List<VasInfo> vasList = ((BarItem) selectablePlotItem).getVasList();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(vasList, 10));
            for (T t2 : vasList) {
                arrayList2.add(new StatDetailItem(selectablePlotItem.getStringId() + t2.getTitle(), t2.getTitle(), null, t2.getIcon(), false, false, 52, null));
            }
            arrayList.addAll(arrayList2);
        } else if (selectablePlotItem instanceof WeekItem) {
            arrayList.addAll(b(selectablePlotItem, ((WeekItem) selectablePlotItem).getShowLegend(), selectablePlotItem.getStatus()));
        }
        return arrayList;
    }
}
