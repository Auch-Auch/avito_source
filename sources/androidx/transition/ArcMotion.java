package androidx.transition;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import l6.z.j;
import org.xmlpull.v1.XmlPullParser;
public class ArcMotion extends PathMotion {
    public static final float g = ((float) Math.tan(Math.toRadians(35.0d)));
    public float a = 0.0f;
    public float b = 0.0f;
    public float c = 70.0f;
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = g;

    public ArcMotion() {
    }

    public static float a(float f2) {
        if (f2 >= 0.0f && f2 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f2 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public float getMaximumAngle() {
        return this.c;
    }

    public float getMinimumHorizontalAngle() {
        return this.a;
    }

    public float getMinimumVerticalAngle() {
        return this.b;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        Path path = new Path();
        path.moveTo(f2, f3);
        float f9 = f4 - f2;
        float f10 = f5 - f3;
        float f11 = (f10 * f10) + (f9 * f9);
        float f12 = (f2 + f4) / 2.0f;
        float f13 = (f3 + f5) / 2.0f;
        float f14 = 0.25f * f11;
        boolean z = f3 > f5;
        if (Math.abs(f9) < Math.abs(f10)) {
            float abs = Math.abs(f11 / (f10 * 2.0f));
            if (z) {
                f8 = abs + f5;
                f7 = f4;
            } else {
                f8 = abs + f3;
                f7 = f2;
            }
            f6 = this.e;
        } else {
            float f15 = f11 / (f9 * 2.0f);
            if (z) {
                f8 = f3;
                f7 = f15 + f2;
            } else {
                f7 = f4 - f15;
                f8 = f5;
            }
            f6 = this.d;
        }
        float f16 = f14 * f6 * f6;
        float f17 = f12 - f7;
        float f18 = f13 - f8;
        float f19 = (f18 * f18) + (f17 * f17);
        float f20 = this.f;
        float f21 = f14 * f20 * f20;
        if (f19 >= f16) {
            f16 = f19 > f21 ? f21 : 0.0f;
        }
        if (f16 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f16 / f19));
            f7 = a.b(f7, f12, sqrt, f12);
            f8 = a.b(f8, f13, sqrt, f13);
        }
        path.cubicTo((f2 + f7) / 2.0f, (f3 + f8) / 2.0f, (f7 + f4) / 2.0f, (f8 + f5) / 2.0f, f4, f5);
        return path;
    }

    public void setMaximumAngle(float f2) {
        this.c = f2;
        this.f = a(f2);
    }

    public void setMinimumHorizontalAngle(float f2) {
        this.a = f2;
        this.d = a(f2);
    }

    public void setMinimumVerticalAngle(float f2) {
        this.b = f2;
        this.e = a(f2);
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }
}
