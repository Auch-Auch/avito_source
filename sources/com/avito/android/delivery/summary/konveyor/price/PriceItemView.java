package com.avito.android.delivery.summary.konveyor.price;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/price/PriceItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Calculation;", "price", "", "setPrice", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Calculation;)V", "Landroid/view/ViewGroup;", "u", "Landroid/view/ViewGroup;", "container", "Lcom/avito/android/util/text/AttributedTextFormatter;", VKApiConst.VERSION, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "cost", "s", "title", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class PriceItemView extends BaseViewHolder {
    public final TextView s;
    public final TextView t;
    public final ViewGroup u;
    public final AttributedTextFormatter v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PriceItemView(@NotNull ViewGroup viewGroup, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.u = viewGroup;
        this.v = attributedTextFormatter;
        View findViewById = viewGroup.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
    }

    public final void setPrice(@NotNull DeliverySummaryRds.Calculation calculation) {
        Intrinsics.checkNotNullParameter(calculation, "price");
        TextViewsKt.bindAttributedText(this.s, calculation.getTitle(), this.v);
        TextViewsKt.bindAttributedText(this.t, calculation.getDescription(), this.v);
    }
}
