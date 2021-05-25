package ru.sravni.android.bankproduct.utils.adapter;

import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/widget/TextView;", "view", "", "textID", "", "setTextToTextView", "(Landroid/widget/TextView;Ljava/lang/Integer;)V", "textIDWithCount", "count", "setTextWithCountToTextView", "(Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/Integer;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingTextViewKt {
    @BindingAdapter({"textID"})
    public static final void setTextToTextView(@NotNull TextView textView, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        if (num != null) {
            textView.setText(textView.getResources().getString(num.intValue()));
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0027: APUT  (r1v0 java.lang.Object[]), (0 ??[int, short, byte, char]), (r5v1 java.lang.Integer) */
    @BindingAdapter({"textIDWithCount", "count"})
    public static final void setTextWithCountToTextView(@NotNull TextView textView, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        if (num != null) {
            int intValue = num.intValue();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = textView.getResources().getString(intValue);
            Intrinsics.checkExpressionValueIsNotNull(string, "view.resources.getString(it)");
            Object[] objArr = new Object[1];
            if (num2 == null) {
                num2 = 0;
            }
            objArr[0] = num2;
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            textView.setText(format);
        }
    }
}
