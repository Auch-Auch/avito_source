package com.avito.android.util.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/view/View;", "Landroid/graphics/Bitmap;", "toBitmap", "(Landroid/view/View;)Landroid/graphics/Bitmap;", "map_release"}, k = 2, mv = {1, 4, 2})
public final class MapMarkerIconFactoryKt {
    @NotNull
    public static final Bitmap toBitmap(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$toBitmap");
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(makeMeasureSpec, makeMeasureSpec);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(0);
        view.draw(new Canvas(createBitmap));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(meas…   draw(Canvas(it))\n    }");
        return createBitmap;
    }
}
