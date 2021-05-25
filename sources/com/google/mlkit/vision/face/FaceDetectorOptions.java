package com.google.mlkit.vision.face;

import a2.j.h.b.b.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.mlkit_vision_face.zzbm;
import com.google.android.gms.internal.mlkit_vision_face.zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
public class FaceDetectorOptions {
    public static final int CLASSIFICATION_MODE_ALL = 2;
    public static final int CLASSIFICATION_MODE_NONE = 1;
    public static final int CONTOUR_MODE_ALL = 2;
    public static final int CONTOUR_MODE_NONE = 1;
    public static final int LANDMARK_MODE_ALL = 2;
    public static final int LANDMARK_MODE_NONE = 1;
    public static final int PERFORMANCE_MODE_ACCURATE = 2;
    public static final int PERFORMANCE_MODE_FAST = 1;
    @LandmarkMode
    public final int a;
    @ContourMode
    public final int b;
    @ClassificationMode
    public final int c;
    @PerformanceMode
    public final int d;
    public final boolean e;
    public final float f;
    @Nullable
    public final Executor g;

    public static class Builder {
        @LandmarkMode
        public int a = 1;
        @ContourMode
        public int b = 1;
        @ClassificationMode
        public int c = 1;
        @PerformanceMode
        public int d = 1;
        public boolean e = false;
        public float f = 0.1f;
        @Nullable
        public Executor g;

        @NonNull
        public FaceDetectorOptions build() {
            return new FaceDetectorOptions(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        @NonNull
        public Builder enableTracking() {
            this.e = true;
            return this;
        }

        @NonNull
        public Builder setClassificationMode(@ClassificationMode int i) {
            this.c = i;
            return this;
        }

        @NonNull
        public Builder setContourMode(@ContourMode int i) {
            this.b = i;
            return this;
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            this.g = executor;
            return this;
        }

        @NonNull
        public Builder setLandmarkMode(@LandmarkMode int i) {
            this.a = i;
            return this;
        }

        @NonNull
        public Builder setMinFaceSize(float f2) {
            this.f = f2;
            return this;
        }

        @NonNull
        public Builder setPerformanceMode(@PerformanceMode int i) {
            this.d = i;
            return this;
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ClassificationMode {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ContourMode {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface LandmarkMode {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface PerformanceMode {
    }

    public FaceDetectorOptions(int i, int i2, int i3, int i4, boolean z, float f2, Executor executor, b bVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = z;
        this.f = f2;
        this.g = executor;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FaceDetectorOptions)) {
            return false;
        }
        FaceDetectorOptions faceDetectorOptions = (FaceDetectorOptions) obj;
        return Float.floatToIntBits(this.f) == Float.floatToIntBits(faceDetectorOptions.f) && this.a == faceDetectorOptions.a && this.b == faceDetectorOptions.b && this.d == faceDetectorOptions.d && this.e == faceDetectorOptions.e && this.c == faceDetectorOptions.c;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Float.floatToIntBits(this.f)), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.d), Boolean.valueOf(this.e), Integer.valueOf(this.c));
    }

    public String toString() {
        return zzd.zza("FaceDetectorOptions").zza("landmarkMode", this.a).zza("contourMode", this.b).zza("classificationMode", this.c).zza("performanceMode", this.d).zza("trackingEnabled", this.e).zza("minFaceSize", this.f).toString();
    }

    @LandmarkMode
    public final int zza() {
        return this.a;
    }

    @ContourMode
    public final int zzb() {
        return this.b;
    }

    @ClassificationMode
    public final int zzc() {
        return this.c;
    }

    @PerformanceMode
    public final int zzd() {
        return this.d;
    }

    public final boolean zze() {
        return this.e;
    }

    public final float zzf() {
        return this.f;
    }

    @Nullable
    public final Executor zzg() {
        return this.g;
    }

    public final zzbm.zzac zzh() {
        zzbm.zzac.zzd zzd;
        zzbm.zzac.zza zza;
        zzbm.zzac.zze zze;
        zzbm.zzac.zzc zzc;
        zzbm.zzac.zzb zza2 = zzbm.zzac.zza();
        int i = this.a;
        if (i == 1) {
            zzd = zzbm.zzac.zzd.NO_LANDMARKS;
        } else if (i != 2) {
            zzd = zzbm.zzac.zzd.UNKNOWN_LANDMARKS;
        } else {
            zzd = zzbm.zzac.zzd.ALL_LANDMARKS;
        }
        zzbm.zzac.zzb zza3 = zza2.zza(zzd);
        int i2 = this.c;
        if (i2 == 1) {
            zza = zzbm.zzac.zza.NO_CLASSIFICATIONS;
        } else if (i2 != 2) {
            zza = zzbm.zzac.zza.UNKNOWN_CLASSIFICATIONS;
        } else {
            zza = zzbm.zzac.zza.ALL_CLASSIFICATIONS;
        }
        zzbm.zzac.zzb zza4 = zza3.zza(zza);
        int i3 = this.d;
        if (i3 == 1) {
            zze = zzbm.zzac.zze.FAST;
        } else if (i3 != 2) {
            zze = zzbm.zzac.zze.UNKNOWN_PERFORMANCE;
        } else {
            zze = zzbm.zzac.zze.ACCURATE;
        }
        zzbm.zzac.zzb zza5 = zza4.zza(zze);
        int i4 = this.b;
        if (i4 == 1) {
            zzc = zzbm.zzac.zzc.NO_CONTOURS;
        } else if (i4 != 2) {
            zzc = zzbm.zzac.zzc.UNKNOWN_CONTOURS;
        } else {
            zzc = zzbm.zzac.zzc.ALL_CONTOURS;
        }
        return (zzbm.zzac) ((zzgd) zza5.zza(zzc).zza(this.e).zza(this.f).zzh());
    }
}
