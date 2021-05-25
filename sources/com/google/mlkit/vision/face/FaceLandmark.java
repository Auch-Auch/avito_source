package com.google.mlkit.vision.face;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_face.zzd;
import com.vk.sdk.api.VKApiConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class FaceLandmark {
    public static final int LEFT_CHEEK = 1;
    public static final int LEFT_EAR = 3;
    public static final int LEFT_EYE = 4;
    public static final int MOUTH_BOTTOM = 0;
    public static final int MOUTH_LEFT = 5;
    public static final int MOUTH_RIGHT = 11;
    public static final int NOSE_BASE = 6;
    public static final int RIGHT_CHEEK = 7;
    public static final int RIGHT_EAR = 9;
    public static final int RIGHT_EYE = 10;
    public final int a;
    public final PointF b;

    @Retention(RetentionPolicy.CLASS)
    public @interface LandmarkType {
    }

    public FaceLandmark(@LandmarkType int i, @NonNull PointF pointF) {
        this.a = i;
        this.b = pointF;
    }

    @LandmarkType
    public int getLandmarkType() {
        return this.a;
    }

    @NonNull
    public PointF getPosition() {
        return this.b;
    }

    public String toString() {
        return zzd.zza("FaceLandmark").zza("type", this.a).zza(VKApiConst.POSITION, this.b).toString();
    }
}
