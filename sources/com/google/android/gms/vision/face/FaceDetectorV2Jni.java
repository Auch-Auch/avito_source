package com.google.android.gms.vision.face;

import android.content.res.AssetManager;
import android.os.RemoteException;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.vision.zzcb;
import com.google.android.gms.internal.vision.zzci;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.vision.L;
import java.nio.ByteBuffer;
public class FaceDetectorV2Jni {
    private final zzho zzcu;

    public FaceDetectorV2Jni() {
        zzho zzge = zzho.zzge();
        this.zzcu = zzge;
        zzge.zza(zzci.zzjg);
    }

    @Keep
    private native void closeDetectorJni(long j);

    @Keep
    private native byte[] detectFacesImageByteArrayJni(long j, byte[] bArr, byte[] bArr2);

    @Keep
    private native byte[] detectFacesImageByteArrayMultiPlanesJni(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr4);

    @Keep
    private native byte[] detectFacesImageByteBufferJni(long j, ByteBuffer byteBuffer, byte[] bArr);

    @Keep
    private native byte[] detectFacesImageByteBufferMultiPlanesJni(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr);

    @Keep
    private native long initDetectorJni(byte[] bArr, AssetManager assetManager);

    public final long zza(zzci.zzd zzd, AssetManager assetManager) {
        L.v("%s initialize.start()", "FaceDetectorV2Jni");
        long initDetectorJni = initDetectorJni(zzd.toByteArray(), assetManager);
        L.v("%s initialize.end()", "FaceDetectorV2Jni");
        return initDetectorJni;
    }

    @Nullable
    public final zzci.zzc zza(long j, ByteBuffer byteBuffer, zzcb zzcb) throws RemoteException {
        L.v("%s detectFacesImageByteBuffer.start()", "FaceDetectorV2Jni");
        zzci.zzc zzc = null;
        try {
            byte[] detectFacesImageByteBufferJni = detectFacesImageByteBufferJni(j, byteBuffer, zzcb.toByteArray());
            if (detectFacesImageByteBufferJni != null && detectFacesImageByteBufferJni.length > 0) {
                zzc = zzci.zzc.zza(detectFacesImageByteBufferJni, this.zzcu);
            }
        } catch (zzin e) {
            L.e("%s detectFacesImageByteBuffer failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
        }
        L.v("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
        return zzc;
    }

    @Nullable
    public final zzci.zzc zza(long j, byte[] bArr, zzcb zzcb) throws RemoteException {
        L.v("%s detectFacesImageByteArray.start()", "FaceDetectorV2Jni");
        zzci.zzc zzc = null;
        try {
            byte[] detectFacesImageByteArrayJni = detectFacesImageByteArrayJni(j, bArr, zzcb.toByteArray());
            if (detectFacesImageByteArrayJni != null && detectFacesImageByteArrayJni.length > 0) {
                zzc = zzci.zzc.zza(detectFacesImageByteArrayJni, this.zzcu);
            }
        } catch (zzin e) {
            L.e("%s detectFacesImageByteArray failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
        }
        L.v("%s detectFacesImageByteArray.end()", "FaceDetectorV2Jni");
        return zzc;
    }

    @Nullable
    public final zzci.zzc zza(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6, zzcb zzcb) {
        zzin e;
        L.v("%s detectFacesImageByteBufferMultiPlanes.start()", "FaceDetectorV2Jni");
        zzci.zzc zzc = null;
        try {
            byte[] detectFacesImageByteBufferMultiPlanesJni = detectFacesImageByteBufferMultiPlanesJni(j, byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3, i4, i5, i6, zzcb.toByteArray());
            if (detectFacesImageByteBufferMultiPlanesJni == null || detectFacesImageByteBufferMultiPlanesJni.length <= 0) {
                L.v("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
                return zzc;
            }
            try {
                zzc = zzci.zzc.zza(detectFacesImageByteBufferMultiPlanesJni, this.zzcu);
            } catch (zzin e2) {
                e = e2;
                L.e("%s detectFacesImageByteBufferMultiPlanes failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
                L.v("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
                return zzc;
            }
            L.v("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
            return zzc;
        } catch (zzin e3) {
            e = e3;
            L.e("%s detectFacesImageByteBufferMultiPlanes failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
            L.v("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
            return zzc;
        }
    }

    @Nullable
    public final zzci.zzc zza(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6, zzcb zzcb) {
        zzin e;
        L.v("%s detectFacesImageByteArrayMultiPlanes.start()", "FaceDetectorV2Jni");
        zzci.zzc zzc = null;
        try {
            byte[] detectFacesImageByteArrayMultiPlanesJni = detectFacesImageByteArrayMultiPlanesJni(j, bArr, bArr2, bArr3, i, i2, i3, i4, i5, i6, zzcb.toByteArray());
            if (detectFacesImageByteArrayMultiPlanesJni == null || detectFacesImageByteArrayMultiPlanesJni.length <= 0) {
                L.v("%s detectFacesImageByteArrayMultiPlanes.end()", "FaceDetectorV2Jni");
                return zzc;
            }
            try {
                zzc = zzci.zzc.zza(detectFacesImageByteArrayMultiPlanesJni, this.zzcu);
            } catch (zzin e2) {
                e = e2;
                L.e("%s detectFacesImageByteArrayMultiPlanes failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
                L.v("%s detectFacesImageByteArrayMultiPlanes.end()", "FaceDetectorV2Jni");
                return zzc;
            }
            L.v("%s detectFacesImageByteArrayMultiPlanes.end()", "FaceDetectorV2Jni");
            return zzc;
        } catch (zzin e3) {
            e = e3;
            L.e("%s detectFacesImageByteArrayMultiPlanes failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
            L.v("%s detectFacesImageByteArrayMultiPlanes.end()", "FaceDetectorV2Jni");
            return zzc;
        }
    }

    public final void zza(long j) throws RemoteException {
        L.v("%s closeDetector.start()", "FaceDetectorV2Jni");
        closeDetectorJni(j);
        L.v("%s closeDetector.end()", "FaceDetectorV2Jni");
    }
}
