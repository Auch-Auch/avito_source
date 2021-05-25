package com.avito.android.advert_stats.item;

import android.content.res.Resources;
import com.avito.android.advert_stats.R;
import com.avito.android.remote.auth.AuthSource;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0006R\u001c\u0010\u000f\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u001c\u0010\u001c\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000eR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/advert_stats/item/StatisticStringResourceProviderImpl;", "Lcom/avito/android/advert_stats/item/StatisticStringResourceProvider;", "", "count", "", "getViews", "(I)Ljava/lang/String;", "getContacts", "getFavorites", "value", AuthSource.SEND_ABUSE, "c", "Ljava/lang/String;", "getLegendGeneralViews", "()Ljava/lang/String;", "legendGeneralViews", "Ljava/util/Locale;", "Ljava/util/Locale;", "locale", "Ljava/text/DecimalFormat;", AuthSource.BOOKING_ORDER, "Ljava/text/DecimalFormat;", "defaultFormatter", "d", "getLegendPredictViews", "legendPredictViews", "e", "getTitle", "title", "Landroid/content/res/Resources;", "f", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatisticStringResourceProviderImpl implements StatisticStringResourceProvider {
    public final Locale a;
    public final DecimalFormat b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    public final Resources f;

    @Inject
    public StatisticStringResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.f = resources;
        Locale locale = new Locale("ru", "RU");
        this.a = locale;
        NumberFormat instance = DecimalFormat.getInstance(locale);
        Objects.requireNonNull(instance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) instance;
        decimalFormat.setGroupingSize(3);
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        Intrinsics.checkNotNullExpressionValue(decimalFormatSymbols, "decimalFormatSymbols");
        decimalFormatSymbols.setGroupingSeparator(Typography.nbsp);
        Unit unit = Unit.INSTANCE;
        this.b = decimalFormat;
        String string = resources.getString(R.string.legend_general_view);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.legend_general_view)");
        this.c = string;
        String string2 = resources.getString(R.string.legend_predict_views);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.legend_predict_views)");
        this.d = string2;
        String string3 = resources.getString(R.string.views_title);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.views_title)");
        this.e = string3;
    }

    public final String a(int i) {
        String format = this.b.format(Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(format, "defaultFormatter.format(value)");
        return format;
    }

    @Override // com.avito.android.advert_stats.item.StatisticStringResourceProvider
    @NotNull
    public String getContacts(int i) {
        String quantityString = this.f.getQuantityString(R.plurals.contacts, i, a(i));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…unt, formatNumber(count))");
        return quantityString;
    }

    @Override // com.avito.android.advert_stats.item.StatisticStringResourceProvider
    @NotNull
    public String getFavorites(int i) {
        String quantityString = this.f.getQuantityString(R.plurals.favorites, i, a(i));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…unt, formatNumber(count))");
        return quantityString;
    }

    @Override // com.avito.android.advert_stats.item.StatisticStringResourceProvider
    @NotNull
    public String getLegendGeneralViews() {
        return this.c;
    }

    @Override // com.avito.android.advert_stats.item.StatisticStringResourceProvider
    @NotNull
    public String getLegendPredictViews() {
        return this.d;
    }

    @Override // com.avito.android.advert_stats.item.StatisticStringResourceProvider
    @NotNull
    public String getTitle() {
        return this.e;
    }

    @Override // com.avito.android.advert_stats.item.StatisticStringResourceProvider
    @NotNull
    public String getViews(int i) {
        String quantityString = this.f.getQuantityString(R.plurals.views, i, a(i));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…unt, formatNumber(count))");
        return quantityString;
    }
}
