package com.google.android.gms.vision.face;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzbw;
import com.google.android.gms.internal.vision.zzcb;
import com.google.android.gms.internal.vision.zzcc;
import com.google.android.gms.internal.vision.zzci;
import com.google.android.gms.internal.vision.zzck;
import com.google.android.gms.internal.vision.zzcp;
import com.google.android.gms.internal.vision.zzct;
import com.google.android.gms.internal.vision.zzfl;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzls;
import com.google.android.gms.internal.vision.zzma;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
public final class NativeFaceDetectorV2Impl extends zzg {
    private static final GmsLogger zzcy = new GmsLogger("NativeFaceDetectorV2Imp", "");
    private final long zzcz;
    private final DynamiteClearcutLogger zzda;
    private final zzci.zzd zzdb;
    private final FaceDetectorV2Jni zzdc;

    /* renamed from: com.google.android.gms.vision.face.NativeFaceDetectorV2Impl$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] zzdd;
        public static final /* synthetic */ int[] zzde;

        static {
            zzci.zzb.zzc.values();
            int[] iArr = new int[16];
            zzde = iArr;
            try {
                zzci.zzb.zzc zzc = zzci.zzb.zzc.FACE_OVAL;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = zzde;
                zzci.zzb.zzc zzc2 = zzci.zzb.zzc.LEFT_EYEBROW_TOP;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = zzde;
                zzci.zzb.zzc zzc3 = zzci.zzb.zzc.LEFT_EYEBROW_BOTTOM;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = zzde;
                zzci.zzb.zzc zzc4 = zzci.zzb.zzc.RIGHT_EYEBROW_TOP;
                iArr4[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = zzde;
                zzci.zzb.zzc zzc5 = zzci.zzb.zzc.RIGHT_EYEBROW_BOTTOM;
                iArr5[5] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = zzde;
                zzci.zzb.zzc zzc6 = zzci.zzb.zzc.LEFT_EYE;
                iArr6[6] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = zzde;
                zzci.zzb.zzc zzc7 = zzci.zzb.zzc.RIGHT_EYE;
                iArr7[7] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = zzde;
                zzci.zzb.zzc zzc8 = zzci.zzb.zzc.UPPER_LIP_TOP;
                iArr8[8] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = zzde;
                zzci.zzb.zzc zzc9 = zzci.zzb.zzc.UPPER_LIP_BOTTOM;
                iArr9[9] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = zzde;
                zzci.zzb.zzc zzc10 = zzci.zzb.zzc.LOWER_LIP_TOP;
                iArr10[10] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = zzde;
                zzci.zzb.zzc zzc11 = zzci.zzb.zzc.LOWER_LIP_BOTTOM;
                iArr11[11] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                int[] iArr12 = zzde;
                zzci.zzb.zzc zzc12 = zzci.zzb.zzc.NOSE_BRIDGE;
                iArr12[12] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                int[] iArr13 = zzde;
                zzci.zzb.zzc zzc13 = zzci.zzb.zzc.NOSE_BOTTOM;
                iArr13[13] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                int[] iArr14 = zzde;
                zzci.zzb.zzc zzc14 = zzci.zzb.zzc.LEFT_CHEEK_CENTER;
                iArr14[14] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                int[] iArr15 = zzde;
                zzci.zzb.zzc zzc15 = zzci.zzb.zzc.RIGHT_CHEEK_CENTER;
                iArr15[15] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            zzls.zze.zza.values();
            int[] iArr16 = new int[39];
            zzdd = iArr16;
            try {
                zzls.zze.zza zza = zzls.zze.zza.LEFT_EYE;
                iArr16[0] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                int[] iArr17 = zzdd;
                zzls.zze.zza zza2 = zzls.zze.zza.RIGHT_EYE;
                iArr17[1] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                int[] iArr18 = zzdd;
                zzls.zze.zza zza3 = zzls.zze.zza.NOSE_TIP;
                iArr18[7] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                int[] iArr19 = zzdd;
                zzls.zze.zza zza4 = zzls.zze.zza.LOWER_LIP;
                iArr19[9] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                int[] iArr20 = zzdd;
                zzls.zze.zza zza5 = zzls.zze.zza.MOUTH_LEFT;
                iArr20[10] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                int[] iArr21 = zzdd;
                zzls.zze.zza zza6 = zzls.zze.zza.MOUTH_RIGHT;
                iArr21[11] = 6;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                int[] iArr22 = zzdd;
                zzls.zze.zza zza7 = zzls.zze.zza.LEFT_EAR_TRAGION;
                iArr22[26] = 7;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                int[] iArr23 = zzdd;
                zzls.zze.zza zza8 = zzls.zze.zza.RIGHT_EAR_TRAGION;
                iArr23[27] = 8;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                int[] iArr24 = zzdd;
                zzls.zze.zza zza9 = zzls.zze.zza.LEFT_CHEEK_CENTER;
                iArr24[34] = 9;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                int[] iArr25 = zzdd;
                zzls.zze.zza zza10 = zzls.zze.zza.RIGHT_CHEEK_CENTER;
                iArr25[35] = 10;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                int[] iArr26 = zzdd;
                zzls.zze.zza zza11 = zzls.zze.zza.LEFT_EAR_TOP;
                iArr26[36] = 11;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                int[] iArr27 = zzdd;
                zzls.zze.zza zza12 = zzls.zze.zza.RIGHT_EAR_TOP;
                iArr27[37] = 12;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    public NativeFaceDetectorV2Impl(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzf, FaceDetectorV2Jni faceDetectorV2Jni) {
        zzci.zzg zzg = (zzci.zzg) ((zzid) zzci.zzg.zzbz().zzk("models").zzgw());
        zzci.zzd.zza zzf2 = zzci.zzd.zzbt().zza(zzci.zze.zzbv().zzh(zzg).zzi(zzg).zzj(zzg)).zza(zzci.zza.zzbh().zzc(zzg).zzd(zzg)).zza(zzci.zzf.zzbx().zzk(zzg).zzl(zzg).zzm(zzg).zzn(zzg)).zzd(zzf.zzcv).zze(zzf.trackingEnabled).zze(zzf.proportionalMinFaceSize).zzf(true);
        int i = zzf.mode;
        if (i == 0) {
            zzf2.zzb(zzct.FAST);
        } else if (i == 1) {
            zzf2.zzb(zzct.ACCURATE);
        } else if (i == 2) {
            zzf2.zzb(zzct.SELFIE);
        }
        int i2 = zzf.landmarkType;
        if (i2 == 0) {
            zzf2.zzb(zzcp.NO_LANDMARK);
        } else if (i2 == 1) {
            zzf2.zzb(zzcp.ALL_LANDMARKS);
        } else if (i2 == 2) {
            zzf2.zzb(zzcp.CONTOUR_LANDMARKS);
        }
        int i3 = zzf.zzcw;
        if (i3 == 0) {
            zzf2.zzb(zzck.NO_CLASSIFICATION);
        } else if (i3 == 1) {
            zzf2.zzb(zzck.ALL_CLASSIFICATIONS);
        }
        zzci.zzd zzd = (zzci.zzd) ((zzid) zzf2.zzgw());
        this.zzdb = zzd;
        this.zzcz = faceDetectorV2Jni.zza(zzd, context2.getAssets());
        this.zzda = dynamiteClearcutLogger;
        this.zzdc = faceDetectorV2Jni;
    }

    private static zzcc zze(int i) {
        if (i == 0) {
            return zzcc.ROTATION_0;
        }
        if (i == 1) {
            return zzcc.ROTATION_270;
        }
        if (i == 2) {
            return zzcc.ROTATION_180;
        }
        if (i == 3) {
            return zzcc.ROTATION_90;
        }
        throw new IllegalArgumentException("Unsupported rotation degree.");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i, int i2, int i3, int i4, int i5, int i6, zzu zzu) {
        zzci.zzc zzc;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            ByteBuffer byteBuffer = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper);
            ByteBuffer byteBuffer2 = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper2);
            ByteBuffer byteBuffer3 = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper3);
            zzcb.zza zzb = zzcb.zzam().zzj(zzu.width).zzk(zzu.height).zzb(zze(zzu.rotation));
            long j = zzu.zzaz;
            if (j > 0) {
                zzb.zzc(j * 1000);
            }
            zzcb zzcb = (zzcb) ((zzid) zzb.zzgw());
            if (byteBuffer.isDirect()) {
                zzc = this.zzdc.zza(this.zzcz, byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3, i4, i5, i6, zzcb);
            } else if (!byteBuffer.hasArray() || byteBuffer.arrayOffset() != 0) {
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                byteBuffer.get(bArr);
                byteBuffer.get(bArr);
                zzc = this.zzdc.zza(this.zzcz, bArr, new byte[byteBuffer2.remaining()], new byte[byteBuffer3.remaining()], i, i2, i3, i4, i5, i6, zzcb);
            } else {
                byte[] bArr2 = null;
                byte[] array = (byteBuffer2 == null || !byteBuffer2.hasArray() || byteBuffer2.arrayOffset() != 0) ? null : byteBuffer2.array();
                if (byteBuffer3 != null && byteBuffer3.hasArray() && byteBuffer3.arrayOffset() == 0) {
                    bArr2 = byteBuffer3.array();
                }
                zzc = this.zzdc.zza(this.zzcz, byteBuffer.array(), array, bArr2, i, i2, i3, i4, i5, i6, zzcb);
            }
            FaceParcel[] zza = zza(zzc, this.zzdb.zzbs(), this.zzdb.zzbr());
            zza(this.zzda, zzu, zza, null, SystemClock.elapsedRealtime() - elapsedRealtime);
            return zza;
        } catch (Exception e) {
            zzcy.e("NativeFaceDetectorV2Imp", "Native face detection v2 failed", e);
            return new FaceParcel[0];
        }
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zzc(IObjectWrapper iObjectWrapper, zzu zzu) throws RemoteException {
        zzci.zzc zzc;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            ByteBuffer byteBuffer = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper);
            zzcb.zza zzb = zzcb.zzam().zzj(zzu.width).zzk(zzu.height).zzb(zze(zzu.rotation)).zzb(zzbw.NV21);
            long j = zzu.zzaz;
            if (j > 0) {
                zzb.zzc(j * 1000);
            }
            zzcb zzcb = (zzcb) ((zzid) zzb.zzgw());
            if (byteBuffer.isDirect()) {
                zzc = this.zzdc.zza(this.zzcz, byteBuffer, zzcb);
            } else if (!byteBuffer.hasArray() || byteBuffer.arrayOffset() != 0) {
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                zzc = this.zzdc.zza(this.zzcz, bArr, zzcb);
            } else {
                zzc = this.zzdc.zza(this.zzcz, byteBuffer.array(), zzcb);
            }
            FaceParcel[] zza = zza(zzc, this.zzdb.zzbs(), this.zzdb.zzbr());
            zza(this.zzda, zzu, zza, null, SystemClock.elapsedRealtime() - elapsedRealtime);
            return zza;
        } catch (Exception e) {
            zzcy.e("NativeFaceDetectorV2Imp", "Native face detection v2 failed", e);
            return new FaceParcel[0];
        }
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final boolean zzd(int i) throws RemoteException {
        return true;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final void zzo() throws RemoteException {
        this.zzdc.zza(this.zzcz);
    }

    private static FaceParcel[] zza(zzci.zzc zzc, zzck zzck, zzcp zzcp) {
        float f;
        float f2;
        float f3;
        zzma zzma;
        LandmarkParcel[] landmarkParcelArr;
        zza[] zzaArr;
        int i;
        zzma zzma2;
        List<zzls.zze> list;
        int i2;
        zzcp zzcp2 = zzcp;
        zzma zzbp = zzc.zzbp();
        FaceParcel[] faceParcelArr = new FaceParcel[zzbp.zzkg()];
        int i3 = 0;
        while (i3 < zzbp.zzkg()) {
            zzls zzcj = zzbp.zzcj(i3);
            zzls.zzb zzjm = zzcj.zzjm();
            float zzjz = ((zzjm.zzjz() - zzjm.zzjx()) / 2.0f) + zzjm.zzjx();
            float zzka = ((zzjm.zzka() - zzjm.zzjy()) / 2.0f) + zzjm.zzjy();
            float zzjz2 = zzjm.zzjz() - zzjm.zzjx();
            float zzka2 = zzjm.zzka() - zzjm.zzjy();
            if (zzck == zzck.ALL_CLASSIFICATIONS) {
                float f4 = -1.0f;
                float f5 = -1.0f;
                float f6 = -1.0f;
                for (zzls.zza zza : zzcj.zzjs()) {
                    if (zza.getName().equals("joy")) {
                        f6 = zza.getConfidence();
                    } else if (zza.getName().equals("left_eye_closed")) {
                        f4 = 1.0f - zza.getConfidence();
                    } else if (zza.getName().equals("right_eye_closed")) {
                        f5 = 1.0f - zza.getConfidence();
                    }
                }
                f3 = f4;
                f2 = f5;
                f = f6;
            } else {
                f3 = -1.0f;
                f2 = -1.0f;
                f = -1.0f;
            }
            float confidence = zzcj.zzjo() ? zzcj.getConfidence() : -1.0f;
            if (zzcp2 == zzcp.ALL_LANDMARKS) {
                List<zzls.zze> zzjn = zzcj.zzjn();
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                while (i4 < zzjn.size()) {
                    zzls.zze zze = zzjn.get(i4);
                    zzls.zze.zza zzke = zze.zzke();
                    switch (AnonymousClass1.zzdd[zzke.ordinal()]) {
                        case 1:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 4;
                            break;
                        case 2:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 10;
                            break;
                        case 3:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 6;
                            break;
                        case 4:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 0;
                            break;
                        case 5:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 5;
                            break;
                        case 6:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 11;
                            break;
                        case 7:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 3;
                            break;
                        case 8:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 9;
                            break;
                        case 9:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 1;
                            break;
                        case 10:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 7;
                            break;
                        case 11:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 2;
                            break;
                        case 12:
                            zzma2 = zzbp;
                            list = zzjn;
                            i2 = 8;
                            break;
                        default:
                            GmsLogger gmsLogger = zzcy;
                            String valueOf = String.valueOf(zzke);
                            zzma2 = zzbp;
                            list = zzjn;
                            StringBuilder sb = new StringBuilder(valueOf.length() + 23);
                            sb.append("Unknown landmark type: ");
                            sb.append(valueOf);
                            gmsLogger.d("NativeFaceDetectorV2Imp", sb.toString());
                            i2 = -1;
                            break;
                    }
                    if (i2 >= 0) {
                        arrayList.add(new LandmarkParcel(-1, zze.getX(), zze.getY(), i2));
                    }
                    i4++;
                    zzjn = list;
                    zzbp = zzma2;
                }
                zzma = zzbp;
                landmarkParcelArr = (LandmarkParcel[]) arrayList.toArray(new LandmarkParcel[0]);
            } else {
                zzma = zzbp;
                landmarkParcelArr = new LandmarkParcel[0];
            }
            if (zzcp2 == zzcp.CONTOUR_LANDMARKS) {
                List list2 = (List) zzcj.zzc(zzci.zzjg);
                zza[] zzaArr2 = new zza[list2.size()];
                int i5 = 0;
                while (i5 < list2.size()) {
                    zzci.zzb zzb = (zzci.zzb) list2.get(i5);
                    PointF[] pointFArr = new PointF[zzb.zzbl()];
                    int i6 = 0;
                    while (i6 < zzb.zzbl()) {
                        zzci.zzb.C0269zzb zzb2 = zzb.zzbk().get(i6);
                        pointFArr[i6] = new PointF(zzb2.getX(), zzb2.getY());
                        i6++;
                        list2 = list2;
                    }
                    zzci.zzb.zzc zzbj = zzb.zzbj();
                    switch (AnonymousClass1.zzde[zzbj.ordinal()]) {
                        case 1:
                            i = 1;
                            break;
                        case 2:
                            i = 2;
                            break;
                        case 3:
                            i = 3;
                            break;
                        case 4:
                            i = 4;
                            break;
                        case 5:
                            i = 5;
                            break;
                        case 6:
                            i = 6;
                            break;
                        case 7:
                            i = 7;
                            break;
                        case 8:
                            i = 8;
                            break;
                        case 9:
                            i = 9;
                            break;
                        case 10:
                            i = 10;
                            break;
                        case 11:
                            i = 11;
                            break;
                        case 12:
                            i = 12;
                            break;
                        case 13:
                            i = 13;
                            break;
                        case 14:
                            i = 14;
                            break;
                        case 15:
                            i = 15;
                            break;
                        default:
                            GmsLogger gmsLogger2 = zzcy;
                            int zzak = zzbj.zzak();
                            StringBuilder sb2 = new StringBuilder(33);
                            sb2.append("Unknown contour type: ");
                            sb2.append(zzak);
                            gmsLogger2.e("NativeFaceDetectorV2Imp", sb2.toString());
                            i = -1;
                            break;
                    }
                    zzaArr2[i5] = new zza(pointFArr, i);
                    i5++;
                    list2 = list2;
                }
                zzaArr = zzaArr2;
            } else {
                zzaArr = new zza[0];
            }
            faceParcelArr[i3] = new FaceParcel(3, (int) zzcj.zzjt(), zzjz, zzka, zzjz2, zzka2, zzcj.zzjq(), -zzcj.zzjp(), zzcj.zzjr(), landmarkParcelArr, f3, f2, f, zzaArr, confidence);
            i3++;
            zzcp2 = zzcp;
            zzbp = zzma;
        }
        return faceParcelArr;
    }

    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, zzu zzu, FaceParcel[] faceParcelArr, @Nullable String str, long j) {
        if (zzu.id <= 2 || faceParcelArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (FaceParcel faceParcel : faceParcelArr) {
                arrayList.add((zzfl.zzn) ((zzid) zzfl.zzn.zzea().zza(zzfl.zzd.zzdh().zzb((zzfl.zzm) ((zzid) zzfl.zzm.zzdy().zzaf((int) (faceParcel.centerX - (faceParcel.width / 2.0f))).zzag((int) (faceParcel.centerY - (faceParcel.height / 2.0f))).zzgw())).zzb((zzfl.zzm) ((zzid) zzfl.zzm.zzdy().zzaf((int) ((faceParcel.width / 2.0f) + faceParcel.centerX)).zzag((int) (faceParcel.centerY - (faceParcel.height / 2.0f))).zzgw())).zzb((zzfl.zzm) ((zzid) zzfl.zzm.zzdy().zzaf((int) ((faceParcel.width / 2.0f) + faceParcel.centerX)).zzag((int) ((faceParcel.height / 2.0f) + faceParcel.centerY)).zzgw())).zzb((zzfl.zzm) ((zzid) zzfl.zzm.zzdy().zzaf((int) (faceParcel.centerX - (faceParcel.width / 2.0f))).zzag((int) ((faceParcel.height / 2.0f) + faceParcel.centerY)).zzgw()))).zzah(faceParcel.id).zzb((zzfl.zzh) ((zzid) zzfl.zzh.zzdo().zzj(faceParcel.zzdh).zzk(faceParcel.zzdi).zzl(faceParcel.zzdj).zzg(faceParcel.zzcm).zzh(faceParcel.zzcn).zzi(faceParcel.zzco).zzgw())).zzgw()));
            }
            int length = faceParcelArr.length;
            zzfl.zzi.zza zzdr = zzfl.zzi.zzdr();
            zzfl.zzf.zza zze = zzfl.zzf.zzdk().zzq("face").zzd(j).zze((long) length);
            zze.zzc(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add((zzfl.zzf) ((zzid) zze.zzgw()));
            dynamiteClearcutLogger.zza(3, (zzfl.zzo) ((zzid) zzfl.zzo.zzec().zzb((zzfl.zzi) ((zzid) zzdr.zze(arrayList2).zza((zzfl.zzj) ((zzid) zzfl.zzj.zzdt().zzi((long) zzu.height).zzh((long) zzu.width).zzj((long) zzu.id).zzk(zzu.zzaz).zzgw())).zzgw())).zzgw()));
        }
    }
}
