package com.avito.android.lib.design.deprecated.select;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/lib/design/deprecated/select/InputDrawableHolder;", "Lcom/avito/android/lib/design/deprecated/select/DrawableHolder;", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "Lcom/avito/android/lib/design/deprecated/select/SelectState;", "state", "Landroid/content/Context;", "context", "", "setState", "(Lcom/avito/android/lib/design/deprecated/select/SelectState;Landroid/content/Context;)V", "Landroid/graphics/drawable/ShapeDrawable;", AuthSource.SEND_ABUSE, "Landroid/graphics/drawable/ShapeDrawable;", "drawable", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class InputDrawableHolder implements DrawableHolder {
    public final ShapeDrawable a;

    public InputDrawableHolder(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        float dimension = resources.getDimension(R.dimen.design_button_corner_radius);
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = dimension;
        }
        this.a = new ShapeDrawable(new RoundRectShape(fArr, null, null));
    }

    @Override // com.avito.android.lib.design.deprecated.select.DrawableHolder
    @NotNull
    public Drawable getDrawable() {
        return this.a;
    }

    @Override // com.avito.android.lib.design.deprecated.select.DrawableHolder
    public void setState(@NotNull SelectState selectState, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(selectState, "state");
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = this.a.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "drawable.paint");
        paint.setColor(Contexts.getColorByAttr(context, selectState.getNormalBackgroundAttr()));
        this.a.invalidateSelf();
    }
}
