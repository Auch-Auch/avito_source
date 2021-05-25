package com.yandex.mobile.ads.nativeads.template.appearance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.nativeads.template.SizeConstraint;
import com.yandex.mobile.ads.nativeads.template.appearance.ImageAppearance;
import com.yandex.mobile.ads.nativeads.template.appearance.TextAppearance;
public final class a {
    public static TextAppearance a(@NonNull TextAppearance textAppearance, @Nullable TextAppearance textAppearance2) {
        if (textAppearance2 == null || textAppearance.equals(textAppearance2)) {
            return textAppearance;
        }
        int textColor = textAppearance2.getTextColor();
        float textSize = textAppearance2.getTextSize();
        String fontFamilyName = textAppearance2.getFontFamilyName();
        int fontStyle = textAppearance2.getFontStyle();
        TextAppearance.Builder builder = new TextAppearance.Builder();
        if (textColor == 0) {
            textColor = textAppearance.getTextColor();
        }
        TextAppearance.Builder textColor2 = builder.setTextColor(textColor);
        if (textSize < 1.0f) {
            textSize = textAppearance.getTextSize();
        }
        TextAppearance.Builder textSize2 = textColor2.setTextSize(textSize);
        if (TextUtils.isEmpty(fontFamilyName)) {
            fontFamilyName = textAppearance.getFontFamilyName();
        }
        return textSize2.setFontFamilyName(fontFamilyName).setFontStyle(fontStyle).build();
    }

    public static ImageAppearance a(@NonNull ImageAppearance imageAppearance, @Nullable ImageAppearance imageAppearance2) {
        if (imageAppearance2 == null || imageAppearance.equals(imageAppearance2)) {
            return imageAppearance;
        }
        SizeConstraint widthConstraint = imageAppearance2.getWidthConstraint();
        ImageAppearance.Builder builder = new ImageAppearance.Builder();
        if (widthConstraint == null) {
            widthConstraint = imageAppearance.getWidthConstraint();
        }
        return builder.setWidthConstraint(widthConstraint).build();
    }
}
