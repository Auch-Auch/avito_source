package com.google.android.material.internal;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeEnforcement {
    public static final int[] a = {R.attr.colorPrimary};
    public static final int[] b = {R.attr.colorPrimaryVariant};

    public static void a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                checkMaterialTheme(context);
            }
        }
        checkAppCompatTheme(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r0.getResourceId(com.google.android.material.R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(@androidx.annotation.NonNull android.content.Context r4, android.util.AttributeSet r5, @androidx.annotation.NonNull @androidx.annotation.StyleableRes int[] r6, @androidx.annotation.AttrRes int r7, @androidx.annotation.StyleRes int r8, @androidx.annotation.Nullable @androidx.annotation.StyleableRes int... r9) {
        /*
            int[] r0 = com.google.android.material.R.styleable.ThemeEnforcement
            android.content.res.TypedArray r0 = r4.obtainStyledAttributes(r5, r0, r7, r8)
            int r1 = com.google.android.material.R.styleable.ThemeEnforcement_enforceTextAppearance
            r2 = 0
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 != 0) goto L_0x0013
            r0.recycle()
            return
        L_0x0013:
            r1 = -1
            if (r9 == 0) goto L_0x0035
            int r3 = r9.length
            if (r3 != 0) goto L_0x001a
            goto L_0x0035
        L_0x001a:
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r6, r7, r8)
            int r5 = r9.length
            r6 = 0
        L_0x0020:
            if (r6 >= r5) goto L_0x0031
            r7 = r9[r6]
            int r7 = r4.getResourceId(r7, r1)
            if (r7 != r1) goto L_0x002e
            r4.recycle()
            goto L_0x003e
        L_0x002e:
            int r6 = r6 + 1
            goto L_0x0020
        L_0x0031:
            r4.recycle()
            goto L_0x003d
        L_0x0035:
            int r4 = com.google.android.material.R.styleable.ThemeEnforcement_android_textAppearance
            int r4 = r0.getResourceId(r4, r1)
            if (r4 == r1) goto L_0x003e
        L_0x003d:
            r2 = 1
        L_0x003e:
            r0.recycle()
            if (r2 == 0) goto L_0x0044
            return
        L_0x0044:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant)."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.ThemeEnforcement.b(android.content.Context, android.util.AttributeSet, int[], int, int, int[]):void");
    }

    public static void c(@NonNull Context context, @NonNull int[] iArr, String str) {
        if (!d(context, iArr)) {
            throw new IllegalArgumentException(a.e3("The style on this component requires your app theme to be ", str, " (or a descendant)."));
        }
    }

    public static void checkAppCompatTheme(@NonNull Context context) {
        c(context, a, "Theme.AppCompat");
    }

    public static void checkMaterialTheme(@NonNull Context context) {
        c(context, b, "Theme.MaterialComponents");
    }

    public static boolean d(@NonNull Context context, @NonNull int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i = 0; i < iArr.length; i++) {
            if (!obtainStyledAttributes.hasValue(i)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static boolean isAppCompatTheme(@NonNull Context context) {
        return d(context, a);
    }

    public static boolean isMaterialTheme(@NonNull Context context) {
        return d(context, b);
    }

    @NonNull
    public static TypedArray obtainStyledAttributes(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i, @StyleRes int i2, @StyleableRes int... iArr2) {
        a(context, attributeSet, i, i2);
        b(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    public static TintTypedArray obtainTintedStyledAttributes(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i, @StyleRes int i2, @StyleableRes int... iArr2) {
        a(context, attributeSet, i, i2);
        b(context, attributeSet, iArr, i, i2, iArr2);
        return TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, i2);
    }
}
