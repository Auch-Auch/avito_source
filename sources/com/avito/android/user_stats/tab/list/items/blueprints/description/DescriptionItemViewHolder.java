package com.avito.android.user_stats.tab.list.items.blueprints.description;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemView;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemViewHolder;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "", "setText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "textView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "u", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class DescriptionItemViewHolder extends BaseViewHolder implements DescriptionItemView {
    public final Context s;
    public final TextView t;
    public final AttributedTextFormatter u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DescriptionItemViewHolder(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.u = attributedTextFormatter;
        this.s = view.getContext();
        this.t = (TextView) view;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        DescriptionItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemView
    public void setText(@Nullable AttributedText attributedText) {
        this.t.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView = this.t;
        AttributedTextFormatter attributedTextFormatter = this.u;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(attributedTextFormatter.format(context, attributedText));
    }
}
