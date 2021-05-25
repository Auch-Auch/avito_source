package com.avito.android.payment.wallet.history.details.item;

import android.view.View;
import android.widget.TextView;
import com.avito.android.payment.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u001e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/item/SimpleItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/payment/wallet/history/details/item/SimpleItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "value", "setValue", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/TextView;", "valueTextView", "s", "titleTextView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Companion", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleItemViewHolder extends BaseViewHolder implements SimpleItemView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int u = R.layout.payment_history_details_simple_item;
    public final TextView s;
    public final TextView t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/item/SimpleItemViewHolder$Companion;", "", "", "LAYOUT_ID", "I", "getLAYOUT_ID", "()I", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final int getLAYOUT_ID() {
            return SimpleItemViewHolder.u;
        }

        public Companion(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.title_text_view);
        this.t = (TextView) view.findViewById(R.id.value_text_view);
    }

    @Override // com.avito.android.payment.wallet.history.details.item.SimpleItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "titleTextView");
        textView.setText(str);
    }

    @Override // com.avito.android.payment.wallet.history.details.item.SimpleItemView
    public void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "valueTextView");
        textView.setText(str);
    }
}
