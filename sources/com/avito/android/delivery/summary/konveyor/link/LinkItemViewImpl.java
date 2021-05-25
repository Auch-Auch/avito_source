package com.avito.android.delivery.summary.konveyor.link;

import android.text.method.MovementMethod;
import android.view.View;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.summary.konveyor.link.LinkItemView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/link/LinkItemViewImpl;", "Lcom/avito/android/delivery/summary/konveyor/link/LinkItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "Landroid/text/method/MovementMethod;", "movementMethod", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;Landroid/text/method/MovementMethod;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "titleTextView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "t", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class LinkItemViewImpl extends BaseViewHolder implements LinkItemView {
    public final TextView s;
    public final AttributedTextFormatter t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.t = attributedTextFormatter;
        this.s = (TextView) view.findViewById(R.id.title);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        LinkItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.delivery.summary.konveyor.link.LinkItemView
    public void setTitle(@NotNull AttributedText attributedText, @NotNull MovementMethod movementMethod) {
        Intrinsics.checkNotNullParameter(attributedText, "title");
        Intrinsics.checkNotNullParameter(movementMethod, "movementMethod");
        TextView textView = this.s;
        TextViewsKt.bindAttributedText(textView, attributedText, this.t);
        textView.setMovementMethod(movementMethod);
    }
}
