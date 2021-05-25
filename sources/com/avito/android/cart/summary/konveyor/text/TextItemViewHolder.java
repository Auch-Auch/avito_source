package com.avito.android.cart.summary.konveyor.text;

import android.text.method.LinkMovementMethod;
import com.avito.android.cart.summary.konveyor.text.TextItemView;
import com.avito.android.lib.design.text_view.AvitoTextView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/text/TextItemViewHolder;", "Lcom/avito/android/cart/summary/konveyor/text/TextItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "", "setText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "t", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/lib/design/text_view/AvitoTextView;", "s", "Lcom/avito/android/lib/design/text_view/AvitoTextView;", "textView", "<init>", "(Lcom/avito/android/lib/design/text_view/AvitoTextView;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class TextItemViewHolder extends BaseViewHolder implements TextItemView {
    public final AvitoTextView s;
    public final AttributedTextFormatter t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextItemViewHolder(@NotNull AvitoTextView avitoTextView, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(avitoTextView);
        Intrinsics.checkNotNullParameter(avitoTextView, "textView");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.s = avitoTextView;
        this.t = attributedTextFormatter;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TextItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.cart.summary.konveyor.text.TextItemView
    public void setText(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        TextViewsKt.bindAttributedText(this.s, attributedText, this.t);
        this.s.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
