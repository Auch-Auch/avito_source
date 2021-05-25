package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.util.MimeTypes;
@TargetApi(16)
public final class zzlr {
    private final String mimeType;
    public final String name;
    public final boolean zzali;
    public final boolean zzbba;
    public final boolean zzbbb;
    private final MediaCodecInfo.CodecCapabilities zzbbc;

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005a, code lost:
        if ((com.google.android.gms.internal.ads.zzpq.SDK_INT >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzlr(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzoz.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.name = r2
            r1.mimeType = r3
            r1.zzbbc = r4
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L_0x002a
            if (r4 == 0) goto L_0x002a
            int r5 = com.google.android.gms.internal.ads.zzpq.SDK_INT
            r0 = 19
            if (r5 < r0) goto L_0x0025
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x0025
            r5 = 1
            goto L_0x0026
        L_0x0025:
            r5 = 0
        L_0x0026:
            if (r5 == 0) goto L_0x002a
            r5 = 1
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            r1.zzbba = r5
            r5 = 21
            if (r4 == 0) goto L_0x0044
            int r0 = com.google.android.gms.internal.ads.zzpq.SDK_INT
            if (r0 < r5) goto L_0x003f
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r0 == 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            r1.zzali = r0
            if (r6 != 0) goto L_0x005e
            if (r4 == 0) goto L_0x005d
            int r6 = com.google.android.gms.internal.ads.zzpq.SDK_INT
            if (r6 < r5) goto L_0x0059
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L_0x0059
            r4 = 1
            goto L_0x005a
        L_0x0059:
            r4 = 0
        L_0x005a:
            if (r4 == 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            r1.zzbbb = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlr.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public static zzlr zza(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzlr(str, str2, codecCapabilities, z, z2);
    }

    public static zzlr zzbb(String str) {
        return new zzlr(str, null, null, false, false);
    }

    private final void zzbd(String str) {
        String str2 = this.name;
        String str3 = this.mimeType;
        String str4 = zzpq.zzbki;
        String.valueOf(str).length();
        String.valueOf(str2).length();
        String.valueOf(str3).length();
        String.valueOf(str4).length();
    }

    @TargetApi(21)
    public final boolean zzay(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbc;
        if (codecCapabilities == null) {
            zzbd("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzbd("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            zzbd(a.m2(31, "sampleRate.support, ", i));
            return false;
        }
    }

    @TargetApi(21)
    public final boolean zzaz(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbc;
        if (codecCapabilities == null) {
            zzbd("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzbd("channelCount.aCaps");
            return false;
        } else if (audioCapabilities.getMaxInputChannelCount() >= i) {
            return true;
        } else {
            zzbd(a.m2(33, "channelCount.support, ", i));
            return false;
        }
    }

    public final boolean zzbc(String str) {
        if (str == null || this.mimeType == null) {
            return true;
        }
        String trim = str.trim();
        String str2 = (trim.startsWith("avc1") || trim.startsWith("avc3")) ? MimeTypes.VIDEO_H264 : (trim.startsWith("hev1") || trim.startsWith("hvc1")) ? MimeTypes.VIDEO_H265 : trim.startsWith("vp9") ? MimeTypes.VIDEO_VP9 : trim.startsWith("vp8") ? MimeTypes.VIDEO_VP8 : trim.startsWith("mp4a") ? MimeTypes.AUDIO_AAC : (trim.startsWith("ac-3") || trim.startsWith("dac3")) ? MimeTypes.AUDIO_AC3 : (trim.startsWith("ec-3") || trim.startsWith("dec3")) ? MimeTypes.AUDIO_E_AC3 : (trim.startsWith("dtsc") || trim.startsWith("dtse")) ? MimeTypes.AUDIO_DTS : (trim.startsWith("dtsh") || trim.startsWith("dtsl")) ? MimeTypes.AUDIO_DTS_HD : trim.startsWith("opus") ? MimeTypes.AUDIO_OPUS : trim.startsWith("vorbis") ? MimeTypes.AUDIO_VORBIS : null;
        if (str2 == null) {
            return true;
        }
        if (!this.mimeType.equals(str2)) {
            zzbd(a.t2(str2.length() + str.length() + 13, "codec.mime ", str, ", ", str2));
            return false;
        }
        Pair<Integer, Integer> zzbe = zzly.zzbe(str);
        if (zzbe == null) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] zzha = zzha();
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzha) {
            if (codecProfileLevel.profile == ((Integer) zzbe.first).intValue() && codecProfileLevel.level >= ((Integer) zzbe.second).intValue()) {
                return true;
            }
        }
        zzbd(a.t2(str2.length() + str.length() + 22, "codec.profileLevel, ", str, ", ", str2));
        return false;
    }

    @TargetApi(21)
    public final Point zzd(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbc;
        if (codecCapabilities == null) {
            zzbd("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzbd("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzpq.zzf(i, widthAlignment) * widthAlignment, zzpq.zzf(i2, heightAlignment) * heightAlignment);
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzha() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbc;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @TargetApi(21)
    public final boolean zza(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbc;
        if (codecCapabilities == null) {
            zzbd("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzbd("sizeAndRate.vCaps");
            return false;
        } else if (zza(videoCapabilities, i, i2, d)) {
            return true;
        } else {
            if (i >= i2 || !zza(videoCapabilities, i2, i, d)) {
                StringBuilder sb = new StringBuilder(69);
                sb.append("sizeAndRate.support, ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                sb.append("x");
                sb.append(d);
                zzbd(sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("sizeAndRate.rotated, ");
            sb2.append(i);
            sb2.append("x");
            sb2.append(i2);
            sb2.append("x");
            sb2.append(d);
            String sb3 = sb2.toString();
            String str = this.name;
            String str2 = this.mimeType;
            String str3 = zzpq.zzbki;
            String.valueOf(sb3).length();
            String.valueOf(str).length();
            String.valueOf(str2).length();
            String.valueOf(str3).length();
            return true;
        }
    }

    @TargetApi(21)
    private static boolean zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }
}
