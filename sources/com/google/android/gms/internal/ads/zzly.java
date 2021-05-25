package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class zzly {
    private static final zzlr zzbct = zzlr.zzbb("OMX.google.raw.decoder");
    private static final Pattern zzbcu = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<zza, List<zzlr>> zzbcv = new HashMap<>();
    private static final SparseIntArray zzbcw;
    private static final SparseIntArray zzbcx;
    private static final Map<String, Integer> zzbcy;
    private static int zzbcz = -1;

    public static final class zza {
        public final String mimeType;
        public final boolean zzbbb;

        public zza(String str, boolean z) {
            this.mimeType = str;
            this.zzbbb = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == zza.class) {
                zza zza = (zza) obj;
                if (TextUtils.equals(this.mimeType, zza.mimeType) && this.zzbbb == zza.zzbbb) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.mimeType;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.zzbbb ? 1231 : 1237);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zzbcw = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        zzbcx = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        zzbcy = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        a.D0(256, hashMap, "L93", 1024, "L120", 4096, "L123", 16384, "L150");
        a.D0(65536, hashMap, "L153", 262144, "L156", 1048576, "L180", 4194304, "L183");
        a.D0(16777216, hashMap, "L186", 2, "H30", 8, "H60", 32, "H63");
        a.D0(128, hashMap, "H90", 512, "H93", 2048, "H120", 8192, "H123");
        a.D0(32768, hashMap, "H150", 131072, "H153", 524288, "H156", 2097152, "H180");
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f8, code lost:
        if ("SO-02E".equals(r15) == false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0126, code lost:
        if ("C1605".equals(r14) == false) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0167, code lost:
        if (r12.startsWith("t0") == false) goto L_0x016a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01cb A[Catch:{ Exception -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0227 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.android.gms.internal.ads.zzlr> zza(com.google.android.gms.internal.ads.zzly.zza r17, com.google.android.gms.internal.ads.zzmb r18) throws com.google.android.gms.internal.ads.zzlz {
        /*
        // Method dump skipped, instructions count: 570
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzly.zza(com.google.android.gms.internal.ads.zzly$zza, com.google.android.gms.internal.ads.zzmb):java.util.List");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r3.equals("avc1") == false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzbe(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzly.zzbe(java.lang.String):android.util.Pair");
    }

    public static zzlr zzc(String str, boolean z) throws zzlz {
        List<zzlr> zzd = zzd(str, z);
        if (zzd.isEmpty()) {
            return null;
        }
        return zzd.get(0);
    }

    private static synchronized List<zzlr> zzd(String str, boolean z) throws zzlz {
        synchronized (zzly.class) {
            zza zza2 = new zza(str, z);
            HashMap<zza, List<zzlr>> hashMap = zzbcv;
            List<zzlr> list = hashMap.get(zza2);
            if (list != null) {
                return list;
            }
            int i = zzpq.SDK_INT;
            List<zzlr> zza3 = zza(zza2, i >= 21 ? new zzmd(z) : new zzma());
            if (z && zza3.isEmpty() && 21 <= i && i <= 23) {
                zza3 = zza(zza2, new zzma());
                if (!zza3.isEmpty()) {
                    String str2 = zza3.get(0).name;
                    String.valueOf(str).length();
                    String.valueOf(str2).length();
                }
            }
            List<zzlr> unmodifiableList = Collections.unmodifiableList(zza3);
            hashMap.put(zza2, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static zzlr zzhh() {
        return zzbct;
    }

    public static int zzhi() throws zzlz {
        if (zzbcz == -1) {
            int i = 0;
            zzlr zzc = zzc(MimeTypes.VIDEO_H264, false);
            if (zzc != null) {
                MediaCodecInfo.CodecProfileLevel[] zzha = zzc.zzha();
                int length = zzha.length;
                int i2 = 0;
                while (i < length) {
                    int i3 = zzha[i].level;
                    int i4 = 9437184;
                    if (i3 == 1 || i3 == 2) {
                        i4 = 25344;
                    } else {
                        switch (i3) {
                            case 8:
                            case 16:
                            case 32:
                                i4 = 101376;
                                continue;
                            case 64:
                                i4 = 202752;
                                continue;
                            case 128:
                            case 256:
                                i4 = 414720;
                                continue;
                            case 512:
                                i4 = 921600;
                                continue;
                            case 1024:
                                i4 = 1310720;
                                continue;
                            case 2048:
                            case 4096:
                                i4 = 2097152;
                                continue;
                            case 8192:
                                i4 = 2228224;
                                continue;
                            case 16384:
                                i4 = 5652480;
                                continue;
                            case 32768:
                            case 65536:
                                break;
                            default:
                                i4 = -1;
                                continue;
                        }
                    }
                    i2 = Math.max(i4, i2);
                    i++;
                }
                i = Math.max(i2, zzpq.SDK_INT >= 21 ? 345600 : 172800);
            }
            zzbcz = i;
        }
        return zzbcz;
    }

    private static Pair<Integer, Integer> zza(String str, String[] strArr) {
        Integer num;
        Integer num2;
        if (strArr.length < 2) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Ignoring malformed AVC codec string: ".concat(valueOf);
            } else {
                new String("Ignoring malformed AVC codec string: ");
            }
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                num = Integer.valueOf(Integer.parseInt(strArr[2]));
                num2 = valueOf2;
            } else {
                String valueOf3 = String.valueOf(str);
                if (valueOf3.length() != 0) {
                    "Ignoring malformed AVC codec string: ".concat(valueOf3);
                } else {
                    new String("Ignoring malformed AVC codec string: ");
                }
                return null;
            }
            Integer valueOf4 = Integer.valueOf(zzbcw.get(num2.intValue()));
            if (valueOf4 == null) {
                String.valueOf(num2).length();
                return null;
            }
            Integer valueOf5 = Integer.valueOf(zzbcx.get(num.intValue()));
            if (valueOf5 != null) {
                return new Pair<>(valueOf4, valueOf5);
            }
            String.valueOf(num).length();
            return null;
        } catch (NumberFormatException unused) {
            String valueOf6 = String.valueOf(str);
            if (valueOf6.length() != 0) {
                "Ignoring malformed AVC codec string: ".concat(valueOf6);
            } else {
                new String("Ignoring malformed AVC codec string: ");
            }
            return null;
        }
    }
}
