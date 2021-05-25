package com.google.mlkit.vision.face.internal;

import a2.j.h.b.b.a.a;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_face.zzbm;
import com.google.android.gms.internal.mlkit_vision_face.zzcb;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.List;
public class FaceDetectorImpl extends MobileVisionBase<List<Face>> implements FaceDetector {
    @VisibleForTesting
    public static final FaceDetectorOptions f = new FaceDetectorOptions.Builder().build();

    public static class zza {
        public final Context a;
        public final zzel b;
        public final ExecutorSelector c;

        public zza(Context context, zzel zzel, ExecutorSelector executorSelector) {
            this.a = context;
            this.b = zzel;
            this.c = executorSelector;
        }

        @NonNull
        public final FaceDetectorImpl zza() {
            return zza(FaceDetectorImpl.f);
        }

        @NonNull
        public final FaceDetectorImpl zza(@NonNull FaceDetectorOptions faceDetectorOptions) {
            Preconditions.checkNotNull(faceDetectorOptions, "You must provide a valid FaceDetectorOptions.");
            return new FaceDetectorImpl(this.a, this.b, this.c, faceDetectorOptions, null);
        }
    }

    public FaceDetectorImpl(Context context, zzel zzel, ExecutorSelector executorSelector, FaceDetectorOptions faceDetectorOptions, a aVar) {
        super(new zzb(context, zzel, faceDetectorOptions), executorSelector.getExecutorToUse(faceDetectorOptions.zzg()));
        zzel.zza(zzbm.zzad.zzb().zza((zzbm.zzap) ((zzgd) zzbm.zzap.zza().zza(faceDetectorOptions.zzh()).zzh())), zzcb.ON_DEVICE_FACE_CREATE);
    }

    @Override // com.google.mlkit.vision.face.FaceDetector
    @NonNull
    public Task<List<Face>> process(@NonNull InputImage inputImage) {
        return super.processBase(inputImage);
    }
}
