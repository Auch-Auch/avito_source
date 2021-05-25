package com.sumsub.sns.camera.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.avito.android.remote.model.Navigation;
import com.sumsub.sns.camera.R;
import com.sumsub.sns.core.presentation.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/camera/base/SNSFrameView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "sns-camera_release"}, k = 1, mv = {1, 4, 2})
public class SNSFrameView extends FrameLayout {
    @JvmOverloads
    public SNSFrameView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public SNSFrameView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public SNSFrameView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSFrameView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.snsFrameViewStyle : i, (i3 & 8) != 0 ? R.style.SNSFrameViewStyle : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SNSFrameView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSFrameView, i, i2);
        Drawable drawable = AppCompatResources.getDrawable(context, obtainStyledAttributes.getResourceId(R.styleable.SNSFrameView_snsFrameDrawable, -1));
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, Navigation.ATTRIBUTES);
        setForeground(new SNSFrameDrawable(drawable, ExtensionsKt.getStyledColor(obtainStyledAttributes, R.styleable.SNSFrameView_snsFrameFillColor, ViewCompat.MEASURED_STATE_MASK), obtainStyledAttributes.getDimension(R.styleable.SNSFrameView_snsFramePaddingLeft, 0.0f), obtainStyledAttributes.getDimension(R.styleable.SNSFrameView_snsFramePaddingTop, 0.0f), obtainStyledAttributes.getDimension(R.styleable.SNSFrameView_snsFramePaddingRight, 0.0f), obtainStyledAttributes.getDimension(R.styleable.SNSFrameView_snsFramePaddingBottom, 0.0f)));
        obtainStyledAttributes.recycle();
    }
}
