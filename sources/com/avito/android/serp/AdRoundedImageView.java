package com.avito.android.serp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001d\u0010\u001fB#\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010 \u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/avito/android/serp/AdRoundedImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "", "setVisibility", "(I)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/util/AttributeSet;)V", "Landroid/graphics/RectF;", "e", "Landroid/graphics/RectF;", "rectF", "", "c", "F", "cornerRadius", "Landroid/graphics/Path;", "d", "Landroid/graphics/Path;", MessageMetaInfo.COLUMN_PATH, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdRoundedImageView extends AppCompatImageView {
    public float c;
    public final Path d = new Path();
    public final RectF e = new RectF();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdRoundedImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AdRoundedImageView);
        this.c = obtainStyledAttributes.getDimension(R.styleable.AdRoundedImageView_corner_radius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        this.e.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        this.d.rewind();
        Path path = this.d;
        RectF rectF = this.e;
        float f = this.c;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        if (canvas != null) {
            canvas.clipPath(this.d);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            super.setVisibility(i);
            setImageAlpha(255);
            return;
        }
        setImageAlpha(0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdRoundedImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdRoundedImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        a(attributeSet);
    }
}
