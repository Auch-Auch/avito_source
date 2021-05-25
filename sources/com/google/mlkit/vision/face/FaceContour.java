package com.google.mlkit.vision.face;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_face.zzd;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
public class FaceContour {
    public static final int FACE = 1;
    public static final int LEFT_CHEEK = 14;
    public static final int LEFT_EYE = 6;
    public static final int LEFT_EYEBROW_BOTTOM = 3;
    public static final int LEFT_EYEBROW_TOP = 2;
    public static final int LOWER_LIP_BOTTOM = 11;
    public static final int LOWER_LIP_TOP = 10;
    public static final int NOSE_BOTTOM = 13;
    public static final int NOSE_BRIDGE = 12;
    public static final int RIGHT_CHEEK = 15;
    public static final int RIGHT_EYE = 7;
    public static final int RIGHT_EYEBROW_BOTTOM = 5;
    public static final int RIGHT_EYEBROW_TOP = 4;
    public static final int UPPER_LIP_BOTTOM = 9;
    public static final int UPPER_LIP_TOP = 8;
    public final int a;
    public final List<PointF> b;

    @Retention(RetentionPolicy.CLASS)
    public @interface ContourType {
    }

    public FaceContour(@ContourType int i, @NonNull List<PointF> list) {
        this.a = i;
        this.b = list;
    }

    @ContourType
    public int getFaceContourType() {
        return this.a;
    }

    @NonNull
    public List<PointF> getPoints() {
        return this.b;
    }

    public String toString() {
        return zzd.zza("FaceContour").zza("type", this.a).zza("points", this.b.toArray()).toString();
    }
}
