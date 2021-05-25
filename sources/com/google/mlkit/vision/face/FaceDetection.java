package com.google.mlkit.vision.face;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.internal.FaceDetectorImpl;
public class FaceDetection {
    @NonNull
    public static FaceDetector getClient() {
        return ((FaceDetectorImpl.zza) MlKitContext.getInstance().get(FaceDetectorImpl.zza.class)).zza();
    }

    @NonNull
    public static FaceDetector getClient(@NonNull FaceDetectorOptions faceDetectorOptions) {
        Preconditions.checkNotNull(faceDetectorOptions, "You must provide a valid FaceDetectorOptions.");
        return ((FaceDetectorImpl.zza) MlKitContext.getInstance().get(FaceDetectorImpl.zza.class)).zza(faceDetectorOptions);
    }
}
