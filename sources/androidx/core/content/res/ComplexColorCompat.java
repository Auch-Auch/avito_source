package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Shader;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ComplexColorCompat {
    public final Shader a;
    public final ColorStateList b;
    public int c;

    public ComplexColorCompat(Shader shader, ColorStateList colorStateList, @ColorInt int i) {
        this.a = shader;
        this.b = colorStateList;
        this.c = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0168, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r2.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.content.res.ComplexColorCompat a(@androidx.annotation.NonNull android.content.res.Resources r27, @androidx.annotation.ColorRes int r28, @androidx.annotation.Nullable android.content.res.Resources.Theme r29) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
        // Method dump skipped, instructions count: 555
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ComplexColorCompat.a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.core.content.res.ComplexColorCompat");
    }

    @Nullable
    public static ComplexColorCompat inflate(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) {
        try {
            return a(resources, i, theme);
        } catch (Exception unused) {
            return null;
        }
    }

    @ColorInt
    public int getColor() {
        return this.c;
    }

    @Nullable
    public Shader getShader() {
        return this.a;
    }

    public boolean isGradient() {
        return this.a != null;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        return this.a == null && (colorStateList = this.b) != null && colorStateList.isStateful();
    }

    public boolean onStateChanged(int[] iArr) {
        if (isStateful()) {
            ColorStateList colorStateList = this.b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.c) {
                this.c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void setColor(@ColorInt int i) {
        this.c = i;
    }

    public boolean willDraw() {
        return isGradient() || this.c != 0;
    }
}
