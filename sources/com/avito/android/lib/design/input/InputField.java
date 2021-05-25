package com.avito.android.lib.design.input;

import android.content.Context;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatEditText;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'B\u001b\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b&\u0010*B#\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\b&\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fRk\u0010\u001b\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006-"}, d2 = {"Lcom/avito/android/lib/design/input/InputField;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "extraSpace", "", "onCreateDrawableState", "(I)[I", "selStart", "selEnd", "", "onSelectionChanged", "(II)V", "direction", "Landroid/view/View;", "focusSearch", "(I)Landroid/view/View;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "text", "e", "Lkotlin/jvm/functions/Function3;", "getOnSelectionChangedListener", "()Lkotlin/jvm/functions/Function3;", "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function3;)V", "onSelectionChangedListener", "Lcom/avito/android/lib/design/input/FormatterType;", "d", "Lcom/avito/android/lib/design/input/FormatterType;", "getInnerFormatterType", "()Lcom/avito/android/lib/design/input/FormatterType;", "setInnerFormatterType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "innerFormatterType", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class InputField extends AppCompatEditText {
    @Nullable
    public FormatterType d;
    @Nullable
    public Function3<? super CharSequence, ? super Integer, ? super Integer, Unit> e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputField(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    @Nullable
    public View focusSearch(int i) {
        return null;
    }

    @Nullable
    public final FormatterType getInnerFormatterType() {
        return this.d;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function3<? super java.lang.CharSequence, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit>, kotlin.jvm.functions.Function3<java.lang.CharSequence, java.lang.Integer, java.lang.Integer, kotlin.Unit> */
    @Nullable
    public final Function3<CharSequence, Integer, Integer, Unit> getOnSelectionChangedListener() {
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    @NotNull
    public int[] onCreateDrawableState(int i) {
        int[] iArr;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ViewParent parent = getParent();
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view = (View) parent;
        if (view == null || (iArr = view.getDrawableState()) == null) {
            iArr = new int[0];
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i);
        linkedHashSet.addAll(ArraysKt___ArraysKt.toSet(iArr));
        Intrinsics.checkNotNullExpressionValue(onCreateDrawableState, "thisState");
        linkedHashSet.addAll(ArraysKt___ArraysKt.toSet(onCreateDrawableState));
        return CollectionsKt___CollectionsKt.toIntArray(linkedHashSet);
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        MaskParameters maskParameters;
        int i3;
        Function3<? super CharSequence, ? super Integer, ? super Integer, Unit> function3 = this.e;
        if (function3 != null) {
            function3.invoke(getText(), Integer.valueOf(i), Integer.valueOf(i2));
        }
        if (this.d != null) {
            CharSequence text = getText();
            if (text == null) {
                text = "";
            }
            FormatterType formatterType = this.d;
            if (formatterType == null || (maskParameters = formatterType.getMaskParameters()) == null) {
                maskParameters = new MaskParameters(null, false, null, null, false, null, false, false, null, null, 0, 0, 4095, null);
            }
            String prefix = maskParameters.getPrefix();
            String postfix = maskParameters.getPostfix();
            boolean z = true;
            int i4 = 0;
            if (prefix.length() == 0) {
                if (postfix.length() != 0) {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            if (i < prefix.length() || i2 > text.length() - postfix.length()) {
                boolean isPrefixSelectionAllowed = maskParameters.isPrefixSelectionAllowed();
                boolean isPostfixSelectionAllowed = maskParameters.isPostfixSelectionAllowed();
                if (isPrefixSelectionAllowed) {
                    i3 = 0;
                } else {
                    i3 = prefix.length();
                }
                if (!isPostfixSelectionAllowed) {
                    i4 = postfix.length();
                }
                int max = Math.max(i3, Math.min(i, text.length() - i4));
                int max2 = Math.max(max, Math.min(text.length() - i4, i2));
                if (i == i2) {
                    if (isPrefixSelectionAllowed) {
                        max = Math.max(prefix.length(), Math.min(i, text.length() - i4));
                        max2 = max;
                    } else {
                        max = max2;
                    }
                }
                if (text.length() >= max2 && text.length() >= max) {
                    Selection.setSelection(getText(), max, max2);
                }
                super.onSelectionChanged(i, i2);
            }
        }
    }

    public final void setInnerFormatterType(@Nullable FormatterType formatterType) {
        this.d = formatterType;
    }

    public final void setOnSelectionChangedListener(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Unit> function3) {
        this.e = function3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputField(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputField(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
