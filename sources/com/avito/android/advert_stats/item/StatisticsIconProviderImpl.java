package com.avito.android.advert_stats.item;

import com.avito.android.advert_stats.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert_stats/item/StatisticsIconProviderImpl;", "Lcom/avito/android/advert_stats/item/StatisticsIconProvider;", "", AuthSource.SEND_ABUSE, "I", "getViewsIcon", "()I", "viewsIcon", AuthSource.BOOKING_ORDER, "getContactsIcon", "contactsIcon", "c", "getFavoritesIcon", "favoritesIcon", "d", "getLegendAllViewsIcon", "legendAllViewsIcon", "e", "getLegendPredictViewsIcon", "legendPredictViewsIcon", "<init>", "()V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatisticsIconProviderImpl implements StatisticsIconProvider {
    public final int a = R.drawable.ic_views;
    public final int b = R.drawable.ic_contact;
    public final int c = R.drawable.ic_heart;
    public final int d = R.drawable.ic_legend_vies;
    public final int e = R.drawable.ic_legend_predicts;

    @Override // com.avito.android.advert_stats.item.StatisticsIconProvider
    public int getContactsIcon() {
        return this.b;
    }

    @Override // com.avito.android.advert_stats.item.StatisticsIconProvider
    public int getFavoritesIcon() {
        return this.c;
    }

    @Override // com.avito.android.advert_stats.item.StatisticsIconProvider
    public int getLegendAllViewsIcon() {
        return this.d;
    }

    @Override // com.avito.android.advert_stats.item.StatisticsIconProvider
    public int getLegendPredictViewsIcon() {
        return this.e;
    }

    @Override // com.avito.android.advert_stats.item.StatisticsIconProvider
    public int getViewsIcon() {
        return this.a;
    }
}
