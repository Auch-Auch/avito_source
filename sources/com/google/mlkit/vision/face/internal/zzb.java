package com.google.mlkit.vision.face.internal;

import a2.b.a.a.a;
import a2.j.h.b.b.a.b;
import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.vision.dynamite.face.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_face.zzbm;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzcb;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.android.gms.internal.mlkit_vision_face.zzep;
import com.google.android.gms.internal.mlkit_vision_face.zzg;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.BitmapInStreamingChecker;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.google.mlkit.vision.face.internal.zzb;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
public final class zzb extends MLTask<List<Face>, InputImage> {
    @VisibleForTesting
    public static final AtomicBoolean j = new AtomicBoolean(true);
    public static final ImageUtils k = ImageUtils.getInstance();
    public final Context c;
    public final FaceDetectorOptions d;
    public final zzel e;
    @GuardedBy("this")
    public FaceDetector f;
    @GuardedBy("this")
    public FaceDetector g;
    public zzg<Boolean> h = zzg.zzb();
    public final BitmapInStreamingChecker i = new BitmapInStreamingChecker();

    public zzb(@NonNull Context context, @NonNull zzel zzel, @NonNull FaceDetectorOptions faceDetectorOptions) {
        Preconditions.checkNotNull(context, "Application context can not be null");
        Preconditions.checkNotNull(zzel, "MlStatsLogger can not be null");
        Preconditions.checkNotNull(faceDetectorOptions, "FaceDetectorOptions can not be null");
        this.c = context;
        this.d = faceDetectorOptions;
        this.e = zzel;
    }

    @VisibleForTesting
    public static int a(@FaceDetectorOptions.LandmarkMode int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        throw new IllegalArgumentException(a.m2(34, "Invalid landmark type: ", i2));
    }

    public static void d(@NonNull List<Face> list) {
        for (Face face : list) {
            face.zza(-1);
        }
    }

    public static int e(@FaceDetectorOptions.PerformanceMode int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        throw new IllegalArgumentException(a.m2(30, "Invalid mode type: ", i2));
    }

    @VisibleForTesting
    public static int f(@FaceDetectorOptions.ClassificationMode int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        throw new IllegalArgumentException(a.m2(40, "Invalid classification type: ", i2));
    }

    @VisibleForTesting
    @WorkerThread
    public final synchronized List<Face> b(@NonNull FaceDetector faceDetector, @NonNull InputImage inputImage, long j2) throws MlKitException {
        Frame frame;
        ArrayList arrayList;
        ByteBuffer byteBuffer;
        if (faceDetector.isOperational()) {
            if (inputImage.getFormat() == 35) {
                frame = new Frame.Builder().setPlanes(inputImage.getPlanes(), inputImage.getWidth(), inputImage.getHeight(), CommonConvertUtils.convertToAndroidImageFormat(inputImage.getFormat())).setRotation(CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees())).setTimestampMillis(SystemClock.elapsedRealtime()).build();
            } else {
                if (inputImage.getFormat() == 17) {
                    byteBuffer = inputImage.getByteBuffer();
                } else {
                    byteBuffer = ImageConvertUtils.getInstance().convertToNv21Buffer(inputImage, false);
                }
                frame = new Frame.Builder().setImageData(byteBuffer, inputImage.getWidth(), inputImage.getHeight(), 17).setRotation(CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees())).build();
            }
            SparseArray<com.google.android.gms.vision.face.Face> detect = faceDetector.detect(frame);
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < detect.size(); i2++) {
                arrayList.add(new Face(detect.get(detect.keyAt(i2))));
            }
        } else {
            c(zzbx.MODEL_NOT_DOWNLOADED, j2, inputImage, 0, 0);
            throw new MlKitException("Waiting for the face detection model to be downloaded. Please wait.", 14);
        }
        return arrayList;
    }

    @WorkerThread
    public final synchronized void c(zzbx zzbx, long j2, InputImage inputImage, int i2, int i3) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
        this.e.zza(new zzel.zzc(this, elapsedRealtime, zzbx, i2, i3, inputImage) { // from class: a2.j.h.b.b.a.c
            public final zzb a;
            public final long b;
            public final zzbx c;
            public final int d;
            public final int e;
            public final InputImage f;

            {
                this.a = r1;
                this.b = r2;
                this.c = r4;
                this.d = r5;
                this.e = r6;
                this.f = r7;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzel.zzc
            public final zzbm.zzad.zza zza() {
                zzb zzb = this.a;
                long j3 = this.b;
                zzbx zzbx2 = this.c;
                int i4 = this.d;
                int i5 = this.e;
                InputImage inputImage2 = this.f;
                Objects.requireNonNull(zzb);
                zzbm.zzap.zza zzb2 = zzbm.zzap.zza().zza(zzbm.zzaf.zza().zza(j3).zza(zzbx2).zza(zzb.j.get()).zzb(true).zzc(true)).zza(zzb.d.zzh()).zza(i4).zzb(i5);
                ImageUtils imageUtils = zzb.k;
                return zzbm.zzad.zzb().zza(zzb.h.zza(Boolean.FALSE).booleanValue()).zza((zzbm.zzap) ((zzgd) zzb2.zza(zzep.zza(imageUtils.getMobileVisionImageFormat(inputImage2), imageUtils.getMobileVisionImageSize(inputImage2))).zzh()));
            }
        }, zzcb.ON_DEVICE_FACE_DETECT);
        zzbm.zzd.zza.C0254zza zza = zzbm.zzd.zza.zza().zza(zzbx).zza(j.get());
        ImageUtils imageUtils = k;
        b bVar = new zzel.zza(this) { // from class: a2.j.h.b.b.a.b
            public final zzb a;

            {
                this.a = r1;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzel.zza
            public final zzbm.zzad.zza zza(Object obj, int i4, zzbm.zzab zzab) {
                zzb zzb = this.a;
                Objects.requireNonNull(zzb);
                return zzbm.zzad.zzb().zza(zzb.h.zza(Boolean.FALSE).booleanValue()).zza(zzbm.zzd.zza().zza(i4).zza((zzbm.zzd.zza) obj).zza(zzab));
            }
        };
        this.e.zza((zzbm.zzd.zza) ((zzgd) zza.zza(zzep.zza(imageUtils.getMobileVisionImageFormat(inputImage), imageUtils.getMobileVisionImageSize(inputImage))).zza(i2).zzb(i3).zza(this.d.zzh()).zzh()), elapsedRealtime, zzcb.AGGREGATED_ON_DEVICE_FACE_DETECTION, bVar);
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    @WorkerThread
    public final synchronized void load() {
        if (!this.h.zza()) {
            this.h = zzg.zzb(Boolean.valueOf(DynamiteModule.getLocalVersion(this.c, ModuleDescriptor.MODULE_ID) > 0));
        }
        if (this.d.zzb() == 2) {
            if (this.g == null) {
                this.g = new FaceDetector.Builder(this.c).setLandmarkType(2).setMode(2).setTrackingEnabled(false).setProminentFaceOnly(true).build();
            }
            if ((this.d.zza() == 2 || this.d.zzc() == 2 || this.d.zzd() == 2) && this.f == null) {
                this.f = new FaceDetector.Builder(this.c).setLandmarkType(a(this.d.zza())).setClassificationType(f(this.d.zzc())).setMode(e(this.d.zzd())).setMinFaceSize(this.d.zzf()).setTrackingEnabled(this.d.zze()).build();
            }
        } else if (this.f == null) {
            this.f = new FaceDetector.Builder(this.c).setLandmarkType(a(this.d.zza())).setClassificationType(f(this.d.zzc())).setMode(e(this.d.zzd())).setMinFaceSize(this.d.zzf()).setTrackingEnabled(this.d.zze()).build();
        }
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    @WorkerThread
    public final synchronized void release() {
        FaceDetector faceDetector = this.f;
        if (faceDetector != null) {
            faceDetector.release();
            this.f = null;
        }
        FaceDetector faceDetector2 = this.g;
        if (faceDetector2 != null) {
            faceDetector2.release();
            this.g = null;
        }
        j.set(true);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.mlkit.common.sdkinternal.MLTaskInput] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010b A[SYNTHETIC] */
    @Override // com.google.mlkit.common.sdkinternal.MLTask
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.mlkit.vision.face.Face> run(@androidx.annotation.NonNull com.google.mlkit.vision.common.InputImage r21) throws com.google.mlkit.common.MlKitException {
        /*
        // Method dump skipped, instructions count: 339
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.face.internal.zzb.run(com.google.mlkit.common.sdkinternal.MLTaskInput):java.lang.Object");
    }
}
