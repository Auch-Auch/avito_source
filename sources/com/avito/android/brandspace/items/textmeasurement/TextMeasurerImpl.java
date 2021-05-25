package com.avito.android.brandspace.items.textmeasurement;

import android.text.TextPaint;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurerImpl;", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "", "text", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", "params", "Lcom/avito/android/remote/model/Size;", "measure", "(Ljava/lang/String;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;)Lcom/avito/android/remote/model/Size;", "Landroid/widget/TextView;", "textView", "", "maxTextWidth", "createTextParams", "(Landroid/widget/TextView;I)Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class TextMeasurerImpl implements TextMeasurer {
    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurer
    @NotNull
    public TextMeasurer.TextParams createTextParams(@NotNull TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int paddingBottom = textView.getPaddingBottom() + textView.getPaddingTop();
        int paddingRight = textView.getPaddingRight() + textView.getPaddingLeft();
        int i2 = 0;
        int i3 = (marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0) + (marginLayoutParams != null ? marginLayoutParams.topMargin : 0);
        int i4 = marginLayoutParams != null ? marginLayoutParams.leftMargin : 0;
        if (marginLayoutParams != null) {
            i2 = marginLayoutParams.rightMargin;
        }
        TextPaint paint = textView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "textView.paint");
        return new TextMeasurer.TextParams(i, paddingBottom, paddingRight, i3, i4 + i2, paint, textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier(), textView.getIncludeFontPadding(), null, null, false, 0, 0, 0, 0, null, 0, 261632, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if ((r16.length() > 0) != false) goto L_0x0018;
     */
    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurer
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.Size measure(@org.jetbrains.annotations.Nullable java.lang.String r16, @org.jetbrains.annotations.NotNull com.avito.android.brandspace.items.textmeasurement.TextMeasurer.TextParams r17) {
        /*
            r15 = this;
            java.lang.String r0 = "params"
            r1 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 1
            r2 = 0
            if (r16 == 0) goto L_0x0017
            int r3 = r16.length()
            if (r3 <= 0) goto L_0x0013
            r3 = 1
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            if (r3 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x001d
            r4 = r16
            goto L_0x001f
        L_0x001d:
            r0 = 0
            r4 = r0
        L_0x001f:
            if (r4 == 0) goto L_0x00da
            int r8 = r17.getMaxTextWidth()
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r0 < r3) goto L_0x009b
            int r3 = r4.length()
            android.text.TextPaint r5 = r17.getTextPaint()
            android.text.StaticLayout$Builder r2 = android.text.StaticLayout.Builder.obtain(r4, r2, r3, r5, r8)
            float r3 = r17.getSpacingAdd()
            float r4 = r17.getSpacingMult()
            android.text.StaticLayout$Builder r2 = r2.setLineSpacing(r3, r4)
            int r3 = r17.getBreakStrategy()
            android.text.StaticLayout$Builder r2 = r2.setBreakStrategy(r3)
            int r3 = r17.getHyphenationFrequency()
            android.text.StaticLayout$Builder r2 = r2.setHyphenationFrequency(r3)
            android.text.Layout$Alignment r3 = r17.getTextAlignment()
            android.text.StaticLayout$Builder r2 = r2.setAlignment(r3)
            android.text.TextDirectionHeuristic r3 = r17.getTextDirection()
            android.text.StaticLayout$Builder r2 = r2.setTextDirection(r3)
            int r3 = r17.getMaxLines()
            android.text.StaticLayout$Builder r2 = r2.setMaxLines(r3)
            android.text.TextUtils$TruncateAt r3 = r17.getEllipsis()
            android.text.StaticLayout$Builder r2 = r2.setEllipsize(r3)
            int r3 = r17.getEllipsisWidth()
            android.text.StaticLayout$Builder r2 = r2.setEllipsizedWidth(r3)
            r3 = 28
            if (r0 < r3) goto L_0x0086
            boolean r3 = r17.isFallbackLineSpacing()
            r2.setUseLineSpacingFromFallbacks(r3)
        L_0x0086:
            r3 = 26
            if (r0 < r3) goto L_0x0091
            int r0 = r17.getJustificationMode()
            r2.setJustificationMode(r0)
        L_0x0091:
            android.text.StaticLayout r0 = r2.build()
            java.lang.String r2 = "StaticLayout.Builder.obt…\n                .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            goto L_0x00c2
        L_0x009b:
            android.text.StaticLayout r0 = new android.text.StaticLayout
            r5 = 0
            int r6 = r4.length()
            android.text.TextPaint r7 = r17.getTextPaint()
            android.text.Layout$Alignment r9 = r17.getTextAlignment()
            float r10 = r17.getSpacingMult()
            float r11 = r17.getSpacingAdd()
            boolean r12 = r17.getIncludePad()
            android.text.TextUtils$TruncateAt r13 = r17.getEllipsis()
            int r14 = r17.getEllipsisWidth()
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x00c2:
            com.avito.android.remote.model.Size r2 = new com.avito.android.remote.model.Size
            int r3 = r0.getWidth()
            int r4 = r17.getCombinedHorizontalEdgeSpace()
            int r4 = r4 + r3
            int r0 = r0.getHeight()
            int r1 = r17.getCombinedVerticalEdgeSpace()
            int r1 = r1 + r0
            r2.<init>(r4, r1)
            goto L_0x00e0
        L_0x00da:
            com.avito.android.remote.model.Size$Companion r0 = com.avito.android.remote.model.Size.Companion
            com.avito.android.remote.model.Size r2 = r0.getZERO()
        L_0x00e0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.textmeasurement.TextMeasurerImpl.measure(java.lang.String, com.avito.android.brandspace.items.textmeasurement.TextMeasurer$TextParams):com.avito.android.remote.model.Size");
    }
}
