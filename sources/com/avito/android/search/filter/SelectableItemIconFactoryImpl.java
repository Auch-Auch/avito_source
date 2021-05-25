package com.avito.android.search.filter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/search/filter/SelectableItemIconFactoryImpl;", "Lcom/avito/android/search/filter/SelectableItemIconFactory;", "", "color", "Landroid/graphics/drawable/Drawable;", "createIcon", "(I)Landroid/graphics/drawable/Drawable;", "Lcom/avito/android/search/filter/SelectableItemIconFactoryResourceProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/filter/SelectableItemIconFactoryResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/search/filter/SelectableItemIconFactoryResourceProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableItemIconFactoryImpl implements SelectableItemIconFactory {
    public final SelectableItemIconFactoryResourceProvider a;

    @Inject
    public SelectableItemIconFactoryImpl(@NotNull SelectableItemIconFactoryResourceProvider selectableItemIconFactoryResourceProvider) {
        Intrinsics.checkNotNullParameter(selectableItemIconFactoryResourceProvider, "resourceProvider");
        this.a = selectableItemIconFactoryResourceProvider;
    }

    @Override // com.avito.android.search.filter.SelectableItemIconFactory
    @NotNull
    public Drawable createIcon(@ColorInt int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        int iconSize = this.a.getIconSize();
        gradientDrawable.setSize(iconSize, iconSize);
        gradientDrawable.setColor(i);
        float f = fArr[1];
        if (fArr[2] <= 0.9f || f > 0.05f) {
            return gradientDrawable;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        int iconSize2 = this.a.getIconSize();
        gradientDrawable2.setSize(iconSize2, iconSize2);
        gradientDrawable2.setColor(0);
        gradientDrawable2.setStroke(this.a.getStrokeWidth(), this.a.getOutlineColor());
        return new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
    }
}
