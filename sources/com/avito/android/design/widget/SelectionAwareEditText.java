package com.avito.android.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0012\u0010\u0016B#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0018J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/avito/android/design/widget/SelectionAwareEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "selStart", "selEnd", "", "onSelectionChanged", "(II)V", "Lcom/avito/android/design/widget/SelectionAwareEditText$SelectionListener;", "d", "Lcom/avito/android/design/widget/SelectionAwareEditText$SelectionListener;", "getSelectionListener", "()Lcom/avito/android/design/widget/SelectionAwareEditText$SelectionListener;", "setSelectionListener", "(Lcom/avito/android/design/widget/SelectionAwareEditText$SelectionListener;)V", "selectionListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SelectionListener", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SelectionAwareEditText extends AppCompatEditText {
    @Nullable
    public SelectionListener d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/SelectionAwareEditText$SelectionListener;", "", "", "selectionStart", "selectionEnd", "", "onSelectionChanged", "(II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public interface SelectionListener {
        void onSelectionChanged(int i, int i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionAwareEditText(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Nullable
    public final SelectionListener getSelectionListener() {
        return this.d;
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        SelectionListener selectionListener = this.d;
        if (selectionListener != null) {
            selectionListener.onSelectionChanged(i, i2);
        }
    }

    public final void setSelectionListener(@Nullable SelectionListener selectionListener) {
        this.d = selectionListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionAwareEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionAwareEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
