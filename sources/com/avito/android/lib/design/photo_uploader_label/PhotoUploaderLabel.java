package com.avito.android.lib.design.photo_uploader_label;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.avito.android.lib.design.R;
import com.avito.android.util.Views;
import com.avito.android.util.drawable.RoundStateDrawable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/lib/design/photo_uploader_label/PhotoUploaderLabel;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoUploaderLabel extends AppCompatTextView {
    @JvmOverloads
    public PhotoUploaderLabel(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public PhotoUploaderLabel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public PhotoUploaderLabel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoUploaderLabel(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.photoUploaderLabel : i, (i3 & 8) != 0 ? R.style.Design_Widget_PhotoUploaderLabel : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PhotoUploaderLabel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PhotoUploaderLabel, i, i2);
        setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        int i3 = R.styleable.PhotoUploaderLabel_photoUploaderLabel_backgroundColor;
        if (obtainStyledAttributes.hasValue(i3)) {
            Views.setBackgroundCompat(this, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, obtainStyledAttributes.getColorStateList(i3), null, obtainStyledAttributes.getDimensionPixelSize(R.styleable.PhotoUploaderLabel_photoUploaderLabel_cornerRadius, 0), null, 0, 0, 0, 122, null));
        }
        Views.changeMargin(this, obtainStyledAttributes.getDimensionPixelSize(R.styleable.PhotoUploaderLabel_android_layout_marginLeft, 0), obtainStyledAttributes.getDimensionPixelSize(R.styleable.PhotoUploaderLabel_android_layout_marginTop, 0), obtainStyledAttributes.getDimensionPixelSize(R.styleable.PhotoUploaderLabel_android_layout_marginRight, 0), obtainStyledAttributes.getDimensionPixelSize(R.styleable.PhotoUploaderLabel_android_layout_marginBottom, 0));
        obtainStyledAttributes.recycle();
    }
}
