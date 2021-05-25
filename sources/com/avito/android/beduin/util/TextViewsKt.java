package com.avito.android.beduin.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import androidx.core.view.GravityCompat;
import com.avito.android.beduin.core.model.icon.IconBase64;
import com.avito.android.beduin.core.model.icon.IconPosition;
import com.avito.android.beduin.core.model.icon.LocalIcon;
import com.avito.android.beduin.core.model.text.Alignment;
import com.avito.android.lib.design.text_view.AvitoTextView;
import com.avito.android.util.TextViews;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\f\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/lib/design/text_view/AvitoTextView;", "Lcom/avito/android/beduin/core/model/text/Alignment;", "alignment", "", "setAlignment", "(Lcom/avito/android/lib/design/text_view/AvitoTextView;Lcom/avito/android/beduin/core/model/text/Alignment;)V", "Lcom/avito/android/beduin/core/model/icon/LocalIcon;", "localIcon", "Lcom/avito/android/beduin/core/model/icon/IconBase64;", "base64Icon", "Lcom/avito/android/beduin/core/model/icon/IconPosition;", "iconPosition", "bindIcon", "(Lcom/avito/android/lib/design/text_view/AvitoTextView;Lcom/avito/android/beduin/core/model/icon/LocalIcon;Lcom/avito/android/beduin/core/model/icon/IconBase64;Lcom/avito/android/beduin/core/model/icon/IconPosition;)V", "beduin_release"}, k = 2, mv = {1, 4, 2})
public final class TextViewsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            IconPosition.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            IconPosition iconPosition = IconPosition.LEFT;
            iArr[0] = 1;
            Alignment.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[2] = 1;
            iArr2[1] = 2;
        }
    }

    public static final void bindIcon(@NotNull AvitoTextView avitoTextView, @Nullable LocalIcon localIcon, @Nullable IconBase64 iconBase64, @Nullable IconPosition iconPosition) {
        SpannableStringBuilder spannableStringBuilder;
        Intrinsics.checkNotNullParameter(avitoTextView, "$this$bindIcon");
        Context context = avitoTextView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Drawable loadIcon = ImageUtilKt.loadIcon(context, localIcon, iconBase64);
        if (loadIcon != null) {
            float intrinsicWidth = ((float) loadIcon.getIntrinsicWidth()) / ((float) loadIcon.getIntrinsicHeight());
            double textSize = ((double) avitoTextView.getTextSize()) * 0.6d;
            loadIcon.setBounds(0, 0, (int) (((double) intrinsicWidth) * textSize), (int) textSize);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (iconPosition != null && iconPosition.ordinal() == 0) {
                spannableStringBuilder2.append((CharSequence) "_ ");
                spannableStringBuilder2.append(avitoTextView.getText()).setSpan(new ImageSpan(loadIcon, 1), 0, 1, 34);
                spannableStringBuilder = spannableStringBuilder2;
            } else {
                spannableStringBuilder2.append(avitoTextView.getText());
                spannableStringBuilder2.append((CharSequence) " _").setSpan(new ImageSpan(loadIcon, 1), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 34);
                spannableStringBuilder = spannableStringBuilder2;
            }
        } else {
            spannableStringBuilder = avitoTextView.getText();
        }
        TextViews.bindText$default(avitoTextView, spannableStringBuilder, false, 2, null);
    }

    public static final void setAlignment(@NotNull AvitoTextView avitoTextView, @Nullable Alignment alignment) {
        int i;
        Intrinsics.checkNotNullParameter(avitoTextView, "$this$setAlignment");
        if (alignment != null) {
            int ordinal = alignment.ordinal();
            if (ordinal == 1) {
                i = 17;
            } else if (ordinal == 2) {
                i = GravityCompat.END;
            }
            avitoTextView.setGravity(i);
        }
        i = GravityCompat.START;
        avitoTextView.setGravity(i);
    }
}
