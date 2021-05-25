package com.google.android.exoplayer2.mediacodec;

import a2.b.a.a.a;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
public final class MediaCodecInfo {
    public static final int MAX_SUPPORTED_INSTANCES_UNKNOWN = -1;
    public static final String TAG = "MediaCodecInfo";
    public final boolean a;
    public final boolean adaptive;
    @Nullable
    public final MediaCodecInfo.CodecCapabilities capabilities;
    public final String codecMimeType;
    public final boolean hardwareAccelerated;
    public final String mimeType;
    public final String name;
    public final boolean secure;
    public final boolean softwareOnly;
    public final boolean tunneling;
    public final boolean vendor;

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
        if ((com.google.android.exoplayer2.util.Util.SDK_INT >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L_0x0066;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaCodecInfo(java.lang.String r1, java.lang.String r2, java.lang.String r3, @androidx.annotation.Nullable android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            r0.name = r1
            r0.mimeType = r2
            r0.codecMimeType = r3
            r0.capabilities = r4
            r0.hardwareAccelerated = r5
            r0.softwareOnly = r6
            r0.vendor = r7
            r1 = 1
            r3 = 0
            if (r8 != 0) goto L_0x0032
            if (r4 == 0) goto L_0x0032
            int r5 = com.google.android.exoplayer2.util.Util.SDK_INT
            r6 = 19
            if (r5 < r6) goto L_0x002d
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            if (r5 == 0) goto L_0x0032
            r5 = 1
            goto L_0x0033
        L_0x0032:
            r5 = 0
        L_0x0033:
            r0.adaptive = r5
            r5 = 21
            if (r4 == 0) goto L_0x004c
            int r6 = com.google.android.exoplayer2.util.Util.SDK_INT
            if (r6 < r5) goto L_0x0047
            java.lang.String r6 = "tunneled-playback"
            boolean r6 = r4.isFeatureSupported(r6)
            if (r6 == 0) goto L_0x0047
            r6 = 1
            goto L_0x0048
        L_0x0047:
            r6 = 0
        L_0x0048:
            if (r6 == 0) goto L_0x004c
            r6 = 1
            goto L_0x004d
        L_0x004c:
            r6 = 0
        L_0x004d:
            r0.tunneling = r6
            if (r9 != 0) goto L_0x0066
            if (r4 == 0) goto L_0x0065
            int r6 = com.google.android.exoplayer2.util.Util.SDK_INT
            if (r6 < r5) goto L_0x0061
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L_0x0061
            r4 = 1
            goto L_0x0062
        L_0x0061:
            r4 = 0
        L_0x0062:
            if (r4 == 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            r0.secure = r1
            boolean r1 = com.google.android.exoplayer2.util.MimeTypes.isVideo(r2)
            r0.a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecInfo.<init>(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean, boolean):void");
    }

    @RequiresApi(21)
    public static Point a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util.ceilDivide(i, widthAlignment) * widthAlignment, Util.ceilDivide(i2, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    public static boolean b(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point a3 = a(videoCapabilities, i, i2);
        int i3 = a3.x;
        int i4 = a3.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    public static MediaCodecInfo newInstance(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z, z2, z3, z4, z5);
    }

    @Nullable
    @RequiresApi(21)
    public Point alignVideoSizeV21(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return a(videoCapabilities, i, i2);
    }

    public final void c(String str) {
        StringBuilder R = a.R("NoSupport [", str, "] [");
        R.append(this.name);
        R.append(", ");
        R.append(this.mimeType);
        R.append("] [");
        R.append(Util.DEVICE_DEBUG_INFO);
        R.append("]");
        Log.d(TAG, R.toString());
    }

    public int getMaxSupportedInstances() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (Util.SDK_INT < 23 || (codecCapabilities = this.capabilities) == null) {
            return -1;
        }
        return codecCapabilities.getMaxSupportedInstances();
    }

    public MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @RequiresApi(21)
    public boolean isAudioChannelCountSupportedV21(int i) {
        int i2;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            c("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("channelCount.aCaps");
            return false;
        }
        String str = this.name;
        String str2 = this.mimeType;
        int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
        if (maxInputChannelCount <= 1 && ((Util.SDK_INT < 26 || maxInputChannelCount <= 0) && !MimeTypes.AUDIO_MPEG.equals(str2) && !MimeTypes.AUDIO_AMR_NB.equals(str2) && !MimeTypes.AUDIO_AMR_WB.equals(str2) && !MimeTypes.AUDIO_AAC.equals(str2) && !MimeTypes.AUDIO_VORBIS.equals(str2) && !MimeTypes.AUDIO_OPUS.equals(str2) && !MimeTypes.AUDIO_RAW.equals(str2) && !MimeTypes.AUDIO_FLAC.equals(str2) && !MimeTypes.AUDIO_ALAW.equals(str2) && !MimeTypes.AUDIO_MLAW.equals(str2) && !MimeTypes.AUDIO_MSGSM.equals(str2))) {
            if (MimeTypes.AUDIO_AC3.equals(str2)) {
                i2 = 6;
            } else {
                i2 = MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
            }
            StringBuilder S = a.S("AssumedMaxChannelAdjustment: ", str, ", [", maxInputChannelCount, " to ");
            S.append(i2);
            S.append("]");
            Log.w(TAG, S.toString());
            maxInputChannelCount = i2;
        }
        if (maxInputChannelCount >= i) {
            return true;
        }
        c("channelCount.support, " + i);
        return false;
    }

    @RequiresApi(21)
    public boolean isAudioSampleRateSupportedV21(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            c("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            c("sampleRate.support, " + i);
            return false;
        }
    }

    public boolean isCodecSupported(Format format) {
        String mediaMimeType;
        String str = format.codecs;
        if (str == null || this.mimeType == null || (mediaMimeType = MimeTypes.getMediaMimeType(str)) == null) {
            return true;
        }
        if (!this.mimeType.equals(mediaMimeType)) {
            StringBuilder L = a.L("codec.mime ");
            L.append(format.codecs);
            L.append(", ");
            L.append(mediaMimeType);
            c(L.toString());
            return false;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
        if (codecProfileAndLevel == null) {
            return true;
        }
        int intValue = ((Integer) codecProfileAndLevel.first).intValue();
        int intValue2 = ((Integer) codecProfileAndLevel.second).intValue();
        if (!(this.a || intValue == 42)) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] profileLevels = getProfileLevels();
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : profileLevels) {
            if (codecProfileLevel.profile == intValue && codecProfileLevel.level >= intValue2) {
                return true;
            }
        }
        StringBuilder L2 = a.L("codec.profileLevel, ");
        L2.append(format.codecs);
        L2.append(", ");
        L2.append(mediaMimeType);
        c(L2.toString());
        return false;
    }

    public boolean isFormatSupported(Format format) throws MediaCodecUtil.DecoderQueryException {
        int i;
        boolean z = false;
        if (!isCodecSupported(format)) {
            return false;
        }
        if (this.a) {
            int i2 = format.width;
            if (i2 <= 0 || (i = format.height) <= 0) {
                return true;
            }
            if (Util.SDK_INT >= 21) {
                return isVideoSizeAndRateSupportedV21(i2, i, (double) format.frameRate);
            }
            if (i2 * i <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                z = true;
            }
            if (!z) {
                StringBuilder L = a.L("legacyFrameSize, ");
                L.append(format.width);
                L.append("x");
                L.append(format.height);
                c(L.toString());
            }
            return z;
        }
        if (Util.SDK_INT >= 21) {
            int i3 = format.sampleRate;
            if (i3 != -1 && !isAudioSampleRateSupportedV21(i3)) {
                return false;
            }
            int i4 = format.channelCount;
            if (i4 != -1 && !isAudioChannelCountSupportedV21(i4)) {
                return false;
            }
        }
        return true;
    }

    public boolean isHdr10PlusOutOfBandMetadataSupported() {
        if (Util.SDK_INT >= 29 && MimeTypes.VIDEO_VP9.equals(this.mimeType)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSeamlessAdaptationSupported(Format format) {
        if (this.a) {
            return this.adaptive;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
        return codecProfileAndLevel != null && ((Integer) codecProfileAndLevel.first).intValue() == 42;
    }

    @RequiresApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            c("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("sizeAndRate.vCaps");
            return false;
        }
        if (!b(videoCapabilities, i, i2, d)) {
            if (i < i2) {
                if ((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(this.name) || !"mcv5a".equals(Util.DEVICE)) && b(videoCapabilities, i2, i, d)) {
                    StringBuilder N = a.N("sizeAndRate.rotated, ", i, "x", i2, "x");
                    N.append(d);
                    StringBuilder R = a.R("AssumedSupport [", N.toString(), "] [");
                    R.append(this.name);
                    R.append(", ");
                    R.append(this.mimeType);
                    R.append("] [");
                    R.append(Util.DEVICE_DEBUG_INFO);
                    R.append("]");
                    Log.d(TAG, R.toString());
                }
            }
            StringBuilder N2 = a.N("sizeAndRate.support, ", i, "x", i2, "x");
            N2.append(d);
            c(N2.toString());
            return false;
        }
        return true;
    }

    public String toString() {
        return this.name;
    }

    public boolean isSeamlessAdaptationSupported(Format format, Format format2, boolean z) {
        if (!this.a) {
            if (MimeTypes.AUDIO_AAC.equals(this.mimeType) && ((String) Assertions.checkNotNull(format.sampleMimeType)).equals(format2.sampleMimeType) && format.channelCount == format2.channelCount && format.sampleRate == format2.sampleRate) {
                Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
                Pair<Integer, Integer> codecProfileAndLevel2 = MediaCodecUtil.getCodecProfileAndLevel(format2);
                if (!(codecProfileAndLevel == null || codecProfileAndLevel2 == null)) {
                    int intValue = ((Integer) codecProfileAndLevel.first).intValue();
                    int intValue2 = ((Integer) codecProfileAndLevel2.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } else if (!((String) Assertions.checkNotNull(format.sampleMimeType)).equals(format2.sampleMimeType) || format.rotationDegrees != format2.rotationDegrees || ((!this.adaptive && (format.width != format2.width || format.height != format2.height)) || ((z || format2.colorInfo != null) && !Util.areEqual(format.colorInfo, format2.colorInfo)))) {
            return false;
        } else {
            return true;
        }
    }
}
