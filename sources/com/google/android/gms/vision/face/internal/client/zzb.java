package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.media.Image;
import android.os.RemoteException;
import androidx.annotation.RequiresApi;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.vision.dynamite.face.ModuleDescriptor;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.internal.vision.zzw;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import java.nio.ByteBuffer;
public final class zzb extends zzs<zzh> {
    private final zzf zzdg;

    public zzb(Context context, zzf zzf) {
        super(context, "FaceNativeHandle", "face");
        this.zzdg = zzf;
        zzr();
    }

    @RequiresApi(19)
    public final Face[] zza(Image.Plane[] planeArr, zzu zzu) {
        if (!isOperational()) {
            return new Face[0];
        }
        if (planeArr == null || planeArr.length == 3) {
            try {
                FaceParcel[] zza = ((zzh) zzr()).zza(ObjectWrapper.wrap(planeArr[0].getBuffer()), ObjectWrapper.wrap(planeArr[1].getBuffer()), ObjectWrapper.wrap(planeArr[2].getBuffer()), planeArr[0].getPixelStride(), planeArr[1].getPixelStride(), planeArr[2].getPixelStride(), planeArr[0].getRowStride(), planeArr[1].getRowStride(), planeArr[2].getRowStride(), zzu);
                Face[] faceArr = new Face[zza.length];
                for (int i = 0; i < zza.length; i++) {
                    faceArr[i] = zza(zza[i]);
                }
                return faceArr;
            } catch (RemoteException unused) {
                return new Face[0];
            }
        } else {
            throw new IllegalArgumentException("Only android.graphics.ImageFormat#YUV_420_888 is supported which should have 3 planes.");
        }
    }

    public final Face[] zzb(ByteBuffer byteBuffer, zzu zzu) {
        if (!isOperational()) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = ((zzh) zzr()).zzc(ObjectWrapper.wrap(byteBuffer), zzu);
            Face[] faceArr = new Face[zzc.length];
            for (int i = 0; i < zzc.length; i++) {
                faceArr[i] = zza(zzc[i]);
            }
            return faceArr;
        } catch (RemoteException unused) {
            return new Face[0];
        }
    }

    public final boolean zzd(int i) {
        if (!isOperational()) {
            return false;
        }
        try {
            return ((zzh) zzr()).zzd(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzs
    public final void zzp() throws RemoteException {
        ((zzh) zzr()).zzo();
    }

    private static Face zza(FaceParcel faceParcel) {
        Landmark[] landmarkArr;
        Contour[] contourArr;
        int i = faceParcel.id;
        PointF pointF = new PointF(faceParcel.centerX, faceParcel.centerY);
        float f = faceParcel.width;
        float f2 = faceParcel.height;
        float f3 = faceParcel.zzdh;
        float f4 = faceParcel.zzdi;
        float f5 = faceParcel.zzdj;
        LandmarkParcel[] landmarkParcelArr = faceParcel.zzdk;
        if (landmarkParcelArr == null) {
            landmarkArr = new Landmark[0];
        } else {
            Landmark[] landmarkArr2 = new Landmark[landmarkParcelArr.length];
            int i2 = 0;
            while (i2 < landmarkParcelArr.length) {
                LandmarkParcel landmarkParcel = landmarkParcelArr[i2];
                landmarkArr2[i2] = new Landmark(new PointF(landmarkParcel.x, landmarkParcel.y), landmarkParcel.type);
                i2++;
                landmarkParcelArr = landmarkParcelArr;
            }
            landmarkArr = landmarkArr2;
        }
        zza[] zzaArr = faceParcel.zzdl;
        if (zzaArr == null) {
            contourArr = new Contour[0];
        } else {
            Contour[] contourArr2 = new Contour[zzaArr.length];
            for (int i3 = 0; i3 < zzaArr.length; i3++) {
                zza zza = zzaArr[i3];
                contourArr2[i3] = new Contour(zza.zzdf, zza.type);
            }
            contourArr = contourArr2;
        }
        return new Face(i, pointF, f, f2, f3, f4, f5, landmarkArr, contourArr, faceParcel.zzcm, faceParcel.zzcn, faceParcel.zzco, faceParcel.zzcp);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.vision.zzs
    public final /* synthetic */ zzh zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzi zzi;
        if (zzw.zza(context, ModuleDescriptor.MODULE_ID)) {
            zzi = zzl.asInterface(dynamiteModule.instantiate("com.google.android.gms.vision.face.NativeFaceDetectorV2Creator"));
        } else {
            zzi = zzl.asInterface(dynamiteModule.instantiate("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator"));
        }
        if (zzi == null) {
            return null;
        }
        return zzi.newFaceDetector(ObjectWrapper.wrap(context), this.zzdg);
    }
}
