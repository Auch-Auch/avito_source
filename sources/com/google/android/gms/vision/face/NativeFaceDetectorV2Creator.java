package com.google.android.gms.vision.face;

import android.content.Context;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.internal.vision.zzq;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;
@RetainForClient
@DynamiteApi
public class NativeFaceDetectorV2Creator extends ChimeraNativeBaseFaceDetectorCreator {
    @Override // com.google.android.gms.vision.face.ChimeraNativeBaseFaceDetectorCreator
    public final zzh zza(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzf) {
        if (!zzq.zza(context2, "face", "libface_detector_v2_jni.so")) {
            return null;
        }
        return new NativeFaceDetectorV2Impl(context, context2, dynamiteClearcutLogger, zzf, new FaceDetectorV2Jni());
    }
}
