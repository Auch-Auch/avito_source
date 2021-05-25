package com.avito.android.advert.item.advertnumber;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert/item/advertnumber/AdvertDetailsAdvertNumberViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/advertnumber/AdvertDetailsAdvertNumberView;", "", "advertNumber", "", "showAdvertNumber", "(Ljava/lang/String;)V", "advertStats", "showAdvertStats", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "advertNumberView", "t", "advertStatsView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAdvertNumberViewImpl extends BaseViewHolder implements AdvertDetailsAdvertNumberView {
    public final TextView s;
    public final TextView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsAdvertNumberViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.advert_number);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.advert_stats);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.android.advert.item.advertnumber.AdvertDetailsAdvertNumberView
    public void showAdvertNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "advertNumber");
        TextViews.bindText$default(this.s, str, false, 2, null);
    }

    @Override // com.avito.android.advert.item.advertnumber.AdvertDetailsAdvertNumberView
    public void showAdvertStats(@Nullable String str) {
        TextViews.bindText$default(this.t, str, false, 2, null);
    }
}
