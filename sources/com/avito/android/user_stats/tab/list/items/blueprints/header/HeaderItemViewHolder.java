package com.avito.android.user_stats.tab.list.items.blueprints.header;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.user_stats.R;
import com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemView;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012¨\u0006!"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/header/HeaderItemViewHolder;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/header/HeaderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "setValue", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "setRelativeValue", "Lcom/avito/android/util/text/AttributedTextFormatter;", "w", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleTextView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", VKApiConst.VERSION, "relativeValueTextView", "u", "valueTextView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItemViewHolder extends BaseViewHolder implements HeaderItemView {
    public final Context s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final AttributedTextFormatter w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderItemViewHolder(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.w = attributedTextFormatter;
        this.s = view.getContext();
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.value);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.value)");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.value_relative);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.value_relative)");
        this.v = (TextView) findViewById3;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        HeaderItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemView
    public void setRelativeValue(@Nullable AttributedText attributedText) {
        TextView textView = this.v;
        AttributedTextFormatter attributedTextFormatter = this.w;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(attributedTextFormatter.format(context, attributedText));
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.t.setText(str);
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemView
    public void setValue(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        TextView textView = this.u;
        AttributedTextFormatter attributedTextFormatter = this.w;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(attributedTextFormatter.format(context, attributedText));
    }
}
