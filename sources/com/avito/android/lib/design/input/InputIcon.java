package com.avito.android.lib.design.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\t\u0010\rB#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/lib/design/input/InputIcon;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "extraSpace", "", "onCreateDrawableState", "(I)[I", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class InputIcon extends AppCompatImageView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputIcon(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ImageView, android.view.View
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputIcon(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputIcon(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
