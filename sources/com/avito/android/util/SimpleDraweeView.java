package com.avito.android.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0014B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0016B-\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0019J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0015¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/avito/android/util/SimpleDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "inflateHierarchy", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/content/res/TypedArray;", "gdhAttrs", "", "attrId", "Landroid/graphics/drawable/Drawable;", "d", "(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;", "Lcom/facebook/drawee/generic/GenericDraweeHierarchy;", "hierarchy", "<init>", "(Landroid/content/Context;Lcom/facebook/drawee/generic/GenericDraweeHierarchy;)V", "(Landroid/content/Context;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleDraweeView extends com.facebook.drawee.view.SimpleDraweeView {
    public SimpleDraweeView(@Nullable Context context, @Nullable GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
    }

    public final Drawable d(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getDrawable(resourceId);
    }

    @Override // com.facebook.drawee.view.GenericDraweeView
    @SuppressLint({"CustomViewStyleable"})
    public void inflateHierarchy(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeView#inflateHierarchy");
        }
        GenericDraweeHierarchyBuilder inflateBuilder = GenericDraweeHierarchyInflater.inflateBuilder(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GenericDraweeHierarchy);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "gdhAttrs");
            Iterator it = new IntRange(0, obtainStyledAttributes.getIndexCount()).iterator();
            while (it.hasNext()) {
                int index = obtainStyledAttributes.getIndex(((IntIterator) it).nextInt());
                if (index == R.styleable.GenericDraweeHierarchy_placeholderImage) {
                    Intrinsics.checkNotNullExpressionValue(inflateBuilder, "builder");
                    inflateBuilder.setPlaceholderImage(d(context, obtainStyledAttributes, index));
                } else if (index == R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage) {
                    Intrinsics.checkNotNullExpressionValue(inflateBuilder, "builder");
                    inflateBuilder.setPressedStateOverlay(d(context, obtainStyledAttributes, index));
                } else if (index == R.styleable.GenericDraweeHierarchy_progressBarImage) {
                    Intrinsics.checkNotNullExpressionValue(inflateBuilder, "builder");
                    inflateBuilder.setProgressBarImage(d(context, obtainStyledAttributes, index));
                } else if (index == R.styleable.GenericDraweeHierarchy_retryImage) {
                    Intrinsics.checkNotNullExpressionValue(inflateBuilder, "builder");
                    inflateBuilder.setRetryImage(d(context, obtainStyledAttributes, index));
                } else if (index == R.styleable.GenericDraweeHierarchy_failureImage) {
                    Intrinsics.checkNotNullExpressionValue(inflateBuilder, "builder");
                    inflateBuilder.setFailureImage(d(context, obtainStyledAttributes, index));
                } else if (index == R.styleable.GenericDraweeHierarchy_backgroundImage) {
                    Intrinsics.checkNotNullExpressionValue(inflateBuilder, "builder");
                    inflateBuilder.setBackground(d(context, obtainStyledAttributes, index));
                } else if (index == R.styleable.GenericDraweeHierarchy_overlayImage) {
                    inflateBuilder.setOverlay(d(context, obtainStyledAttributes, index));
                }
            }
            obtainStyledAttributes.recycle();
        }
        Intrinsics.checkNotNullExpressionValue(inflateBuilder, "builder");
        setAspectRatio(inflateBuilder.getDesiredAspectRatio());
        setHierarchy(inflateBuilder.build());
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public SimpleDraweeView(@Nullable Context context) {
        super(context);
    }

    public SimpleDraweeView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleDraweeView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SimpleDraweeView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
