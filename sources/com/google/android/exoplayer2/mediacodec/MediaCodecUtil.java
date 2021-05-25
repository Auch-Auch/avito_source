package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {
    public static final Pattern a = Pattern.compile("^\\D?(\\d+)$");
    public static final HashMap<b, List<MediaCodecInfo>> b = new HashMap<>();
    public static int c = -1;

    public static class DecoderQueryException extends Exception {
        public DecoderQueryException(Throwable th, a aVar) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public static final class b {
        public final String a;
        public final boolean b;
        public final boolean c;

        public b(String str, boolean z, boolean z2) {
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            if (TextUtils.equals(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int B0 = (a2.b.a.a.a.B0(this.a, 31, 31) + (this.b ? 1231 : 1237)) * 31;
            if (!this.c) {
                i = 1237;
            }
            return B0 + i;
        }
    }

    public interface c {
        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean c();

        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i);
    }

    public static final class d implements c {
        public d(a aVar) {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c() {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo getCodecInfoAt(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }
    }

    @RequiresApi(21)
    public static final class e implements c {
        public final int a;
        @Nullable
        public MediaCodecInfo[] b;

        public e(boolean z, boolean z2) {
            this.a = (z || z2) ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c() {
            return true;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int getCodecCount() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.a).getCodecInfos();
            }
            return this.b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo getCodecInfoAt(int i) {
            if (this.b == null) {
                this.b = new MediaCodecList(this.a).getCodecInfos();
            }
            return this.b[i];
        }
    }

    public interface f<T> {
        int a(T t);
    }

    public static void a(String str, List<MediaCodecInfo> list) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (Util.SDK_INT < 26 && Util.DEVICE.equals("R9") && list.size() == 1 && list.get(0).name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(MediaCodecInfo.newInstance("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
            }
            f(list, a2.j.b.b.v0.b.a);
        }
        int i = Util.SDK_INT;
        if (i < 21 && list.size() > 1) {
            String str2 = list.get(0).name;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                f(list, a2.j.b.b.v0.c.a);
            }
        }
        if (i < 30 && list.size() > 1 && "OMX.qti.audio.decoder.flac".equals(list.get(0).name)) {
            list.add(list.remove(0));
        }
    }

    @Nullable
    public static String b(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
        for (String str3 : supportedTypes) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(MimeTypes.VIDEO_DOLBY_VISION)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        } else if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (!str2.equals(MimeTypes.AUDIO_FLAC) || !"OMX.lge.flac.decoder".equals(str)) {
                return null;
            }
            return "audio/x-lg-flac";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ef, code lost:
        if (r1.b == false) goto L_0x00f1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x019a A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ed A[SYNTHETIC, Splitter:B:61:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> c(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b r26, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c r27) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
        // Method dump skipped, instructions count: 455
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c(com.google.android.exoplayer2.mediacodec.MediaCodecUtil$b, com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c):java.util.ArrayList");
    }

    public static boolean d(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = Util.SDK_INT;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = Util.DEVICE;
            if ("a70".equals(str3) || ("Xiaomi".equals(Util.MANUFACTURER) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = Util.DEVICE;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = Util.DEVICE;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util.MANUFACTURER))) {
            String str6 = Util.DEVICE;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util.MANUFACTURER)) {
            String str7 = Util.DEVICE;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if (!MimeTypes.AUDIO_E_AC3_JOC.equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean e(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        String lowerInvariant = Util.toLowerInvariant(mediaCodecInfo.getName());
        if (lowerInvariant.startsWith("arc.")) {
            return false;
        }
        if (lowerInvariant.startsWith("omx.google.") || lowerInvariant.startsWith("omx.ffmpeg.") || ((lowerInvariant.startsWith("omx.sec.") && lowerInvariant.contains(".sw.")) || lowerInvariant.equals("omx.qcom.video.decoder.hevcswvdec") || lowerInvariant.startsWith("c2.android.") || lowerInvariant.startsWith("c2.google.") || (!lowerInvariant.startsWith("omx.") && !lowerInvariant.startsWith("c2.")))) {
            return true;
        }
        return false;
    }

    public static <T> void f(List<T> list, f<T> fVar) {
        Collections.sort(list, new Comparator() { // from class: a2.j.b.b.v0.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                MediaCodecUtil.f fVar2 = MediaCodecUtil.f.this;
                Pattern pattern = MediaCodecUtil.a;
                return fVar2.a(obj2) - fVar2.a(obj);
            }
        });
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0405, code lost:
        if (r0.equals("L150") == false) goto L_0x0509;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x035c A[Catch:{ NumberFormatException -> 0x036c }] */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x05c5  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x05cb  */
    /* JADX WARNING: Removed duplicated region for block: B:489:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010e  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> getCodecProfileAndLevel(com.google.android.exoplayer2.Format r15) {
        /*
        // Method dump skipped, instructions count: 2366
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(com.google.android.exoplayer2.Format):android.util.Pair");
    }

    @Nullable
    public static MediaCodecInfo getDecoderInfo(String str, boolean z, boolean z2) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(str, z, z2);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2) throws DecoderQueryException {
        c cVar;
        synchronized (MediaCodecUtil.class) {
            b bVar = new b(str, z, z2);
            HashMap<b, List<MediaCodecInfo>> hashMap = b;
            List<MediaCodecInfo> list = hashMap.get(bVar);
            if (list != null) {
                return list;
            }
            int i = Util.SDK_INT;
            if (i >= 21) {
                cVar = new e(z, z2);
            } else {
                cVar = new d(null);
            }
            ArrayList<MediaCodecInfo> c2 = c(bVar, cVar);
            if (z && c2.isEmpty() && 21 <= i && i <= 23) {
                c2 = c(bVar, new d(null));
                if (!c2.isEmpty()) {
                    Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + c2.get(0).name);
                }
            }
            a(str, c2);
            List<MediaCodecInfo> unmodifiableList = Collections.unmodifiableList(c2);
            hashMap.put(bVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    @CheckResult
    public static List<MediaCodecInfo> getDecoderInfosSortedByFormatSupport(List<MediaCodecInfo> list, Format format) {
        ArrayList arrayList = new ArrayList(list);
        f(arrayList, new f() { // from class: a2.j.b.b.v0.d
            @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
            public final int a(Object obj) {
                Format format2 = Format.this;
                com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo = (com.google.android.exoplayer2.mediacodec.MediaCodecInfo) obj;
                Pattern pattern = MediaCodecUtil.a;
                try {
                    return mediaCodecInfo.isFormatSupported(format2) ? 1 : 0;
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                    return -1;
                }
            }
        });
        return arrayList;
    }

    @Nullable
    public static MediaCodecInfo getDecryptOnlyDecoderInfo() throws DecoderQueryException {
        return getDecoderInfo(MimeTypes.AUDIO_RAW, false, false);
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        int i;
        if (c == -1) {
            int i2 = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo(MimeTypes.VIDEO_H264, false, false);
            if (decoderInfo != null) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = profileLevels[i2].level;
                    if (i4 == 1 || i4 == 2) {
                        i = 25344;
                    } else {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                continue;
                            case 64:
                                i = 202752;
                                continue;
                            case 128:
                            case 256:
                                i = 414720;
                                continue;
                            case 512:
                                i = 921600;
                                continue;
                            case 1024:
                                i = 1310720;
                                continue;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                continue;
                            case 8192:
                                i = 2228224;
                                continue;
                            case 16384:
                                i = 5652480;
                                continue;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                continue;
                            default:
                                i = -1;
                                continue;
                        }
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, Util.SDK_INT >= 21 ? 345600 : 172800);
            }
            c = i2;
        }
        return c;
    }

    public static void warmDecoderInfoCache(String str, boolean z, boolean z2) {
        try {
            getDecoderInfos(str, z, z2);
        } catch (DecoderQueryException e2) {
            Log.e("MediaCodecUtil", "Codec warming failed", e2);
        }
    }
}
