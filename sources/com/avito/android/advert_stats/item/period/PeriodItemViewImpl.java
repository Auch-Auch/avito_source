package com.avito.android.advert_stats.item.period;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_stats.R;
import com.avito.android.remote.model.Sort;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert_stats/item/period/PeriodItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert_stats/item/period/PeriodItemView;", "", "period", "", "setPeriod", "(Ljava/lang/String;)V", "", PanelStateKt.PANEL_HIDDEN, "setHidden", "(Z)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", Sort.DATE, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class PeriodItemViewImpl extends BaseViewHolder implements PeriodItemView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeriodItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.date);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.date)");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.android.advert_stats.item.period.PeriodItemView
    public void setHidden(boolean z) {
        if (z) {
            Views.conceal(this.s);
        } else {
            Views.show(this.s);
        }
    }

    @Override // com.avito.android.advert_stats.item.period.PeriodItemView
    public void setPeriod(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "period");
        this.s.setText(str);
    }
}
