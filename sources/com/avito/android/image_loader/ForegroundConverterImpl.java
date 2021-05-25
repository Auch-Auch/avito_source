package com.avito.android.image_loader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.avito.android.image_loader.drawable.RoundedColorDrawable;
import com.avito.android.image_loader.drawable.TextDrawable;
import com.avito.android.image_loader_avito.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.color.ColorFormatter;
import com.avito.android.util.text.AttributedTextFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/image_loader/ForegroundConverterImpl;", "Lcom/avito/android/image_loader/ForegroundConverter;", "Landroid/content/Context;", "context", "Lcom/avito/android/image_loader/Picture;", "picture", "", "roundCorners", "Landroid/graphics/drawable/Drawable;", "convert", "(Landroid/content/Context;Lcom/avito/android/image_loader/Picture;Ljava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class ForegroundConverterImpl implements ForegroundConverter {
    public final AttributedTextFormatter a;

    public ForegroundConverterImpl(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.a = attributedTextFormatter;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0053: APUT  
      (r1v4 android.graphics.drawable.Drawable[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: com.avito.android.image_loader.drawable.TextDrawable : 0x0050: CONSTRUCTOR  (r6v6 com.avito.android.image_loader.drawable.TextDrawable) = (r0v4 java.lang.CharSequence) call: com.avito.android.image_loader.drawable.TextDrawable.<init>(java.lang.CharSequence):void type: CONSTRUCTOR)
     */
    @Override // com.avito.android.image_loader.ForegroundConverter
    @Nullable
    public Drawable convert(@NotNull Context context, @Nullable Picture picture, @Nullable Integer num) {
        ForegroundInfo foregroundInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(picture instanceof AvitoPicture)) {
            picture = null;
        }
        AvitoPicture avitoPicture = (AvitoPicture) picture;
        if (avitoPicture == null || (foregroundInfo = avitoPicture.getForegroundInfo()) == null) {
            return null;
        }
        CharSequence format = this.a.format(context, foregroundInfo.getText());
        Drawable[] drawableArr = new Drawable[2];
        drawableArr[0] = new RoundedColorDrawable(ColorFormatter.INSTANCE.formatColor(context, foregroundInfo.getColor()), (float) (num != null ? num.intValue() : context.getResources().getDimensionPixelSize(R.dimen.foreground_default_corners)));
        if (format == null) {
            format = "";
        }
        drawableArr[1] = new TextDrawable(format);
        return new LayerDrawable(drawableArr);
    }
}
