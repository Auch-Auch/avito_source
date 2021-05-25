package com.google.mlkit.vision.face.internal;

import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.FaceDetectorOptions;
public class zzc extends LazyInstanceMap<FaceDetectorOptions, zzb> {
    public final MlKitContext a;

    public zzc(MlKitContext mlKitContext) {
        this.a = mlKitContext;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    public /* synthetic */ zzb create(FaceDetectorOptions faceDetectorOptions) {
        return new zzb(this.a.getApplicationContext(), (zzel) this.a.get(zzel.class), faceDetectorOptions);
    }
}
