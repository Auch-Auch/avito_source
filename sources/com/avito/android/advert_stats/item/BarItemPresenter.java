package com.avito.android.advert_stats.item;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert_stats/item/BarItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_stats/item/BarItemView;", "Lcom/avito/android/advert_stats/item/BarItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert_stats/item/BarItemView;Lcom/avito/android/advert_stats/item/BarItem;I)V", "Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;", "dimensionsProvider", "Lcom/avito/android/advert_stats/item/OnBarItemClickListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_stats/item/OnBarItemClickListener;", "barClickListener", "<init>", "(Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;Lcom/avito/android/advert_stats/item/OnBarItemClickListener;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class BarItemPresenter implements ItemPresenter<BarItemView, BarItem> {
    public final PlotDimensionsProvider a;
    public final OnBarItemClickListener b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BarItemPresenter a;
        public final /* synthetic */ BarItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BarItemPresenter barItemPresenter, BarItem barItem) {
            super(0);
            this.a = barItemPresenter;
            this.b = barItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.b.onBarClicked(this.b);
            return Unit.INSTANCE;
        }
    }

    public BarItemPresenter(@NotNull PlotDimensionsProvider plotDimensionsProvider, @NotNull OnBarItemClickListener onBarItemClickListener) {
        Intrinsics.checkNotNullParameter(plotDimensionsProvider, "dimensionsProvider");
        Intrinsics.checkNotNullParameter(onBarItemClickListener, "barClickListener");
        this.a = plotDimensionsProvider;
        this.b = onBarItemClickListener;
    }

    public void bindView(@NotNull BarItemView barItemView, @NotNull BarItem barItem, int i) {
        String str;
        Intrinsics.checkNotNullParameter(barItemView, "view");
        Intrinsics.checkNotNullParameter(barItem, "item");
        boolean z = barItem.getCoefficient() == 0.0f;
        int emptyBarHeight = z ? this.a.getEmptyBarHeight() : Math.max((int) (barItem.getCoefficient() * ((float) this.a.getBarHeight())), this.a.getMinBarHeight());
        int barWidth = this.a.getBarWidth();
        Integer views = barItem.getViews();
        int intValue = views != null ? views.intValue() : 0;
        if (intValue < 1000) {
            str = String.valueOf(intValue);
        } else {
            double d = (double) intValue;
            int log = (int) (Math.log(d) / Math.log(1000.0d));
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
            decimalFormatSymbols.setDecimalSeparator(FormatterType.defaultDecimalSeparator);
            decimalFormatSymbols.setGroupingSeparator(FormatterType.defaultDecimalSeparator);
            str = a2.b.a.a.a.H(new Object[]{new DecimalFormat("0.#", decimalFormatSymbols).format(d / Math.pow(1000.0d, (double) log)), Character.valueOf("kMBTPE".charAt(log - 1))}, 2, "%s%c", "java.lang.String.format(format, *args)");
        }
        barItemView.setStatValue(str);
        barItemView.setWidthHeightPx(barWidth, emptyBarHeight);
        barItemView.setState(barItem.getState(), z, e.coerceIn(barItem.getVasViews() != null ? ((float) barItem.getVasViews().intValue()) / ((float) intValue) : 0.0f, 0.0f, 1.0f));
        barItemView.setOnClickListener(new a(this, barItem));
    }
}
