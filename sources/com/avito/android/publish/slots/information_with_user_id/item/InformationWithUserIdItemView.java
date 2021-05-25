package com.avito.android.publish.slots.information_with_user_id.item;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/publish/slots/information_with_user_id/item/InformationWithUserIdItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "", "setText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "u", "Lcom/avito/android/util/text/AttributedTextFormatter;", "formatter", "Landroid/content/Context;", "t", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InformationWithUserIdItemView extends BaseViewHolder implements ItemView {
    public final TextView s;
    public final Context t;
    public final AttributedTextFormatter u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InformationWithUserIdItemView(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "formatter");
        this.u = attributedTextFormatter;
        TextView textView = (TextView) view;
        this.s = textView;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.t = context;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemView.DefaultImpls.onUnbind(this);
    }

    public final void setText(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        this.s.setText(this.u.format(this.t, attributedText));
    }
}
