package com.google.mlkit.vision.face;

import a2.b.a.a.a;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_face.zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Landmark;
import com.google.mlkit.vision.face.FaceContour;
import com.google.mlkit.vision.face.FaceLandmark;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.Immutable;
@Immutable
public class Face {
    public final Rect a;
    public int b;
    public float c;
    public float d;
    public float e;
    public final float f;
    public final float g;
    public final float h;
    public final SparseArray<FaceLandmark> i = new SparseArray<>();
    public final SparseArray<FaceContour> j = new SparseArray<>();

    public Face(@NonNull com.google.android.gms.vision.face.Face face) {
        int i2;
        PointF position = face.getPosition();
        float f2 = position.x;
        this.a = new Rect((int) f2, (int) position.y, (int) (face.getWidth() + f2), (int) (face.getHeight() + position.y));
        this.b = face.getId();
        for (Landmark landmark : face.getLandmarks()) {
            if (a(landmark.getType()) && landmark.getPosition() != null) {
                this.i.put(landmark.getType(), new FaceLandmark(landmark.getType(), new PointF(landmark.getPosition().x, landmark.getPosition().y)));
            }
        }
        for (Contour contour : face.getContours()) {
            boolean z = true;
            switch (contour.getType()) {
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 3;
                    break;
                case 4:
                    i2 = 4;
                    break;
                case 5:
                    i2 = 5;
                    break;
                case 6:
                    i2 = 6;
                    break;
                case 7:
                    i2 = 7;
                    break;
                case 8:
                    i2 = 8;
                    break;
                case 9:
                    i2 = 9;
                    break;
                case 10:
                    i2 = 10;
                    break;
                case 11:
                    i2 = 11;
                    break;
                case 12:
                    i2 = 12;
                    break;
                case 13:
                    i2 = 13;
                    break;
                case 14:
                    i2 = 14;
                    break;
                case 15:
                    i2 = 15;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            if ((i2 > 15 || i2 <= 0) ? false : z) {
                PointF[] positions = contour.getPositions();
                ArrayList arrayList = new ArrayList();
                if (positions != null) {
                    for (PointF pointF : positions) {
                        arrayList.add(new PointF(pointF.x, pointF.y));
                    }
                    this.j.put(i2, new FaceContour(i2, arrayList));
                }
            }
        }
        this.f = face.getEulerX();
        this.g = face.getEulerY();
        this.h = face.getEulerZ();
        this.e = face.getIsSmilingProbability();
        this.d = face.getIsLeftEyeOpenProbability();
        this.c = face.getIsRightEyeOpenProbability();
    }

    public static boolean a(@FaceLandmark.LandmarkType int i2) {
        return i2 == 0 || i2 == 1 || i2 == 7 || i2 == 3 || i2 == 9 || i2 == 4 || i2 == 10 || i2 == 5 || i2 == 11 || i2 == 6;
    }

    @NonNull
    public List<FaceContour> getAllContours() {
        ArrayList arrayList = new ArrayList();
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(this.j.valueAt(i2));
        }
        return arrayList;
    }

    @NonNull
    public List<FaceLandmark> getAllLandmarks() {
        ArrayList arrayList = new ArrayList();
        int size = this.i.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(this.i.valueAt(i2));
        }
        return arrayList;
    }

    @NonNull
    public Rect getBoundingBox() {
        return this.a;
    }

    @Nullable
    public FaceContour getContour(@FaceContour.ContourType int i2) {
        return this.j.get(i2);
    }

    public float getHeadEulerAngleX() {
        return this.f;
    }

    public float getHeadEulerAngleY() {
        return this.g;
    }

    public float getHeadEulerAngleZ() {
        return this.h;
    }

    @Nullable
    public FaceLandmark getLandmark(@FaceLandmark.LandmarkType int i2) {
        return this.i.get(i2);
    }

    @Nullable
    public Float getLeftEyeOpenProbability() {
        float f2 = this.d;
        if (f2 == -1.0f) {
            return null;
        }
        return Float.valueOf(f2);
    }

    @Nullable
    public Float getRightEyeOpenProbability() {
        float f2 = this.c;
        if (f2 == -1.0f) {
            return null;
        }
        return Float.valueOf(f2);
    }

    @Nullable
    public Float getSmilingProbability() {
        float f2 = this.e;
        if (f2 == -1.0f) {
            return null;
        }
        return Float.valueOf(f2);
    }

    @Nullable
    public Integer getTrackingId() {
        int i2 = this.b;
        if (i2 == -1) {
            return null;
        }
        return Integer.valueOf(i2);
    }

    public String toString() {
        zzf zza = zzd.zza("Face").zza("boundingBox", this.a).zza("trackingId", this.b).zza("rightEyeOpenProbability", this.c).zza("leftEyeOpenProbability", this.d).zza("smileProbability", this.e).zza("eulerX", this.f).zza("eulerY", this.g).zza("eulerZ", this.h);
        zzf zza2 = zzd.zza("Landmarks");
        for (int i2 = 0; i2 <= 11; i2++) {
            if (a(i2)) {
                zza2.zza(a.m2(20, "landmark_", i2), getLandmark(i2));
            }
        }
        zza.zza("landmarks", zza2.toString());
        zzf zza3 = zzd.zza("Contours");
        for (int i3 = 1; i3 <= 15; i3++) {
            zza3.zza(a.m2(19, "Contour_", i3), getContour(i3));
        }
        zza.zza("contours", zza3.toString());
        return zza.toString();
    }

    public final SparseArray<FaceContour> zza() {
        return this.j;
    }

    public final void zza(SparseArray<FaceContour> sparseArray) {
        this.j.clear();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            this.j.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
        }
    }

    public final void zza(int i2) {
        this.b = -1;
    }
}
