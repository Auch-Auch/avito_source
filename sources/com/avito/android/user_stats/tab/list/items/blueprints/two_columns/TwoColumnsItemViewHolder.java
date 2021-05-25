package com.avito.android.user_stats.tab.list.items.blueprints.two_columns;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.user_stats.R;
import com.avito.android.user_stats.tab.list.items.blueprints.two_columns.TwoColumnsItemView;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u001e\u0010\r\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/two_columns/TwoColumnsItemViewHolder;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/two_columns/TwoColumnsItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "", "setLeftText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "setRightText", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "rightTextView", "t", "leftTextView", "Lcom/avito/android/util/text/AttributedTextFormatter;", VKApiConst.VERSION, "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class TwoColumnsItemViewHolder extends BaseViewHolder implements TwoColumnsItemView {
    public final Context s;
    public final TextView t;
    public final TextView u;
    public final AttributedTextFormatter v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TwoColumnsItemViewHolder(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.v = attributedTextFormatter;
        this.s = view.getContext();
        View findViewById = view.findViewById(R.id.left_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.left_text)");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.right_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.right_text)");
        this.u = (TextView) findViewById2;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TwoColumnsItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.two_columns.TwoColumnsItemView
    public void setLeftText(@Nullable AttributedText attributedText) {
        TextView textView = this.t;
        AttributedTextFormatter attributedTextFormatter = this.v;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(attributedTextFormatter.format(context, attributedText));
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.two_columns.TwoColumnsItemView
    public void setRightText(@Nullable AttributedText attributedText) {
        TextView textView = this.u;
        AttributedTextFormatter attributedTextFormatter = this.v;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(attributedTextFormatter.format(context, attributedText));
    }
}
