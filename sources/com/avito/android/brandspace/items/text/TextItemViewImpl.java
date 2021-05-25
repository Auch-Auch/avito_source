package com.avito.android.brandspace.items.text;

import android.view.View;
import android.widget.TextView;
import com.avito.android.brandspace.items.text.TextItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/brandspace/items/text/TextItemViewImpl;", "Lcom/avito/android/brandspace/items/text/TextItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "value", "Lcom/avito/android/brandspace/items/text/TextItemViewStyle;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "bottomMarginRes", "", "setText", "(Ljava/lang/CharSequence;Lcom/avito/android/brandspace/items/text/TextItemViewStyle;I)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class TextItemViewImpl extends BaseViewHolder implements TextItemView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TextItemView.DefaultImpls.onUnbind(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003c, code lost:
        if ((r11.length() > 0) != false) goto L_0x0040;
     */
    @Override // com.avito.android.brandspace.items.text.TextItemView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setText(@org.jetbrains.annotations.Nullable java.lang.CharSequence r11, @org.jetbrains.annotations.NotNull com.avito.android.brandspace.items.text.TextItemViewStyle r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            android.widget.TextView r0 = r10.s
            android.content.Context r0 = r0.getContext()
            android.widget.TextView r1 = r10.s
            r1.setText(r11)
            android.widget.TextView r1 = r10.s
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r2 = r12.getTextAppearanceAttr()
            int r2 = com.avito.android.util.Contexts.getResourceIdByAttr(r0, r2)
            com.avito.android.util.TextViews.setTextAppearanceCompat(r1, r2)
            android.widget.TextView r1 = r10.s
            int r2 = r12.getTextColorAttr()
            int r0 = com.avito.android.util.Contexts.getColorByAttr(r0, r2)
            r1.setTextColor(r0)
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L_0x003f
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x003b
            r11 = 1
            goto L_0x003c
        L_0x003b:
            r11 = 0
        L_0x003c:
            if (r11 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            android.widget.TextView r11 = r10.s
            android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
            if (r0 == 0) goto L_0x004a
            r2 = -2
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            r11.height = r2
            android.widget.TextView r3 = r10.s
            r4 = 0
            android.content.res.Resources r11 = r3.getResources()
            int r12 = r12.getTopMarginRes()
            int r5 = r11.getDimensionPixelOffset(r12)
            r6 = 0
            if (r0 == 0) goto L_0x006d
            if (r13 == 0) goto L_0x006d
            android.widget.TextView r11 = r10.s
            android.content.res.Resources r11 = r11.getResources()
            int r1 = r11.getDimensionPixelOffset(r13)
            r7 = r1
            goto L_0x006e
        L_0x006d:
            r7 = 0
        L_0x006e:
            r8 = 5
            r9 = 0
            com.avito.android.util.Views.changeMargin$default(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.text.TextItemViewImpl.setText(java.lang.CharSequence, com.avito.android.brandspace.items.text.TextItemViewStyle, int):void");
    }
}
