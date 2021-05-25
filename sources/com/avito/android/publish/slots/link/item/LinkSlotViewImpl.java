package com.avito.android.publish.slots.link.item;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.avito.android.publish.R;
import com.avito.android.publish.slots.link.item.LinkSlotView;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/slots/link/item/LinkSlotViewImpl;", "Lcom/avito/android/publish/slots/link/item/LinkSlotView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class LinkSlotViewImpl extends BaseViewHolder implements LinkSlotView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkSlotViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        this.s = textView;
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        LinkSlotView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.publish.slots.link.item.LinkSlotView
    public void setText(@Nullable CharSequence charSequence) {
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        textView.setText(charSequence);
    }
}
