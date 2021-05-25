package com.avito.android.avito_map.amenity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import com.avito.android.avito_map.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.map.MapMarkerIconFactoryKt;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactoryImpl;", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "", "type", "", "color", "Landroid/graphics/Bitmap;", "bitmap", "(Ljava/lang/String;I)Landroid/graphics/Bitmap;", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "bitmaps", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AmenityMarkerIconFactoryImpl implements AmenityMarkerIconFactory {
    public final Map<String, Bitmap> a = new LinkedHashMap();
    public final LayoutInflater b;
    public final Context c;

    @Inject
    public AmenityMarkerIconFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = context;
        this.b = LayoutInflater.from(context);
    }

    @Override // com.avito.android.avito_map.amenity.AmenityMarkerIconFactory
    @NotNull
    public Bitmap bitmap(@NotNull String str, @ColorInt int i) {
        Intrinsics.checkNotNullParameter(str, "type");
        Bitmap bitmap = this.a.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        View inflate = this.b.inflate(R.layout.amenity_pin, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.pin_bg_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(map_R.id.pin_bg_image)");
        View findViewById2 = inflate.findViewById(R.id.pin_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(map_R.id.pin_image)");
        ImageView imageView = (ImageView) findViewById2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(imageView.getContext(), com.avito.android.lib.design.avito.R.style.Theme_DesignSystem_Avito);
        Drawable drawable = contextThemeWrapper.getDrawable(R.drawable.pin_circle_white);
        Intrinsics.checkNotNull(drawable);
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "contextThemeWrapper.getD…)!!\n            .mutate()");
        findViewById.setBackground(DrawablesKt.wrapForTinting(mutate, i));
        imageView.setImageDrawable(contextThemeWrapper.getDrawable(AmenityMarkerIconFactoryKt.toPinType(str).getDrawableRes()));
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        Bitmap bitmap2 = MapMarkerIconFactoryKt.toBitmap(inflate);
        this.a.put(str, bitmap2);
        return bitmap2;
    }
}
