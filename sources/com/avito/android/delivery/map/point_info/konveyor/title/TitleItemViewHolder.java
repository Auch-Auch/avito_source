package com.avito.android.delivery.map.point_info.konveyor.title;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.map.point_info.konveyor.title.TitleItemView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/title/TitleItemViewHolder;", "Lcom/avito/android/delivery/map/point_info/konveyor/title/TitleItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "", "setText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "t", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class TitleItemViewHolder extends BaseViewHolder implements TitleItemView {
    public final TextView s;
    public final AttributedTextFormatter t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleItemViewHolder(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.t = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TitleItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.title.TitleItemView
    public void setText(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        TextView textView = this.s;
        AttributedTextFormatter attributedTextFormatter = this.t;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "titleView.context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }
}
