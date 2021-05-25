package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    public static final int[] r1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    @Nullable
    public static final Method s1;
    public static boolean t1;
    public static boolean u1;
    public final Context E0;
    public final VideoFrameReleaseTimeHelper F0;
    public final VideoRendererEventListener.EventDispatcher G0;
    public final long H0;
    public final int I0;
    public final boolean J0;
    public CodecMaxValues K0;
    public boolean L0;
    public boolean M0;
    public Surface N0;
    public float O0;
    public Surface P0;
    public boolean Q0;
    public int R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;
    public long V0;
    public long W0;
    public long X0;
    public int Y0;
    public int Z0;
    public int a1;
    public long b1;
    public long c1;
    public int d1;
    public int e1;
    public int f1;
    public int g1;
    public float h1;
    public float i1;
    public int j1;
    public int k1;
    public int l1;
    public float m1;
    public boolean n1;
    public int o1;
    @Nullable
    public a p1;
    @Nullable
    public VideoFrameMetadataListener q1;

    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    @RequiresApi(23)
    public final class a implements MediaCodec.OnFrameRenderedListener, Handler.Callback {
        public final Handler a;

        public a(MediaCodec mediaCodec) {
            Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.a = createHandlerForCurrentLooper;
            mediaCodec.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
        }

        public final void a(long j) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this == mediaCodecVideoRenderer.p1) {
                if (j == Long.MAX_VALUE) {
                    mediaCodecVideoRenderer.setPendingOutputEndOfStream();
                    return;
                }
                try {
                    mediaCodecVideoRenderer.onProcessedTunneledBuffer(j);
                } catch (ExoPlaybackException e) {
                    MediaCodecVideoRenderer.this.setPendingPlaybackException(e);
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (Util.SDK_INT < 30) {
                this.a.sendMessageAtFrontOfQueue(Message.obtain(this.a, 0, (int) (j >> 32), (int) j));
                return;
            }
            a(j);
        }
    }

    static {
        Method method;
        if (Util.SDK_INT >= 30) {
            try {
                method = Surface.class.getMethod("setFrameRate", Float.TYPE, Integer.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            s1 = method;
        }
        method = null;
        s1 = method;
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0);
    }

    public static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return w(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
        }
        int size = format.initializationData.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += format.initializationData.get(i2).length;
        }
        return format.maxInputSize + i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:438:0x07cf, code lost:
        if (r0.equals("CP8676_I02") == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:456:0x0819, code lost:
        if (r0.equals("AFTN") == false) goto L_0x0811;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean v() {
        /*
        // Method dump skipped, instructions count: 3010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.v():boolean");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int w(MediaCodecInfo mediaCodecInfo, String str, int i, int i2) {
        char c;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.hashCode();
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(MimeTypes.VIDEO_H263)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals(MimeTypes.VIDEO_MP4V)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals(MimeTypes.VIDEO_VP8)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
                i3 = i * i2;
                i4 = 2;
                break;
            case 1:
            case 5:
                i3 = i * i2;
                break;
            case 3:
                String str2 = Util.MODEL;
                if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(Util.MANUFACTURER) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !mediaCodecInfo.secure)))) {
                    i3 = Util.ceilDivide(i2, 16) * Util.ceilDivide(i, 16) * 16 * 16;
                    i4 = 2;
                    break;
                } else {
                    return -1;
                }
                break;
            default:
                return -1;
        }
        return (i3 * 3) / (i4 * 2);
    }

    public static List<MediaCodecInfo> x(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> codecProfileAndLevel;
        String str = format.sampleMimeType;
        if (str == null) {
            return Collections.emptyList();
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, z, z2), format);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            int intValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (intValue == 16 || intValue == 256) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos(MimeTypes.VIDEO_H265, z, z2));
            } else if (intValue == 512) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos(MimeTypes.VIDEO_H264, z, z2));
            }
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    public static boolean y(long j) {
        return j < -30000;
    }

    public void A() {
        this.U0 = true;
        if (!this.S0) {
            this.S0 = true;
            this.G0.renderedFirstFrame(this.N0);
            this.Q0 = true;
        }
    }

    public final void B() {
        int i = this.e1;
        if (i != -1 || this.f1 != -1) {
            if (this.j1 != i || this.k1 != this.f1 || this.l1 != this.g1 || this.m1 != this.h1) {
                this.G0.videoSizeChanged(i, this.f1, this.g1, this.h1);
                this.j1 = this.e1;
                this.k1 = this.f1;
                this.l1 = this.g1;
                this.m1 = this.h1;
            }
        }
    }

    public final void C() {
        int i = this.j1;
        if (i != -1 || this.k1 != -1) {
            this.G0.videoSizeChanged(i, this.k1, this.l1, this.m1);
        }
    }

    public final void D(long j, long j2, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.q1;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, getCodecOutputMediaFormat());
        }
    }

    public final void E() {
        this.W0 = this.H0 > 0 ? SystemClock.elapsedRealtime() + this.H0 : C.TIME_UNSET;
    }

    @RequiresApi(30)
    public final void F(Surface surface, float f) {
        Method method = s1;
        if (method == null) {
            Log.e("MediaCodecVideoRenderer", "Failed to call Surface.setFrameRate (method does not exist)");
        }
        try {
            method.invoke(surface, Float.valueOf(f), Integer.valueOf(f == 0.0f ? 0 : 1));
        } catch (Exception e) {
            Log.e("MediaCodecVideoRenderer", "Failed to call Surface.setFrameRate", e);
        }
    }

    public final boolean G(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.n1 && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || DummySurface.isSecureSupported(this.E0));
    }

    public final void H(boolean z) {
        Surface surface;
        if (Util.SDK_INT >= 30 && (surface = this.N0) != null && surface != this.P0) {
            float operatingRate = getState() == 2 && (this.i1 > -1.0f ? 1 : (this.i1 == -1.0f ? 0 : -1)) != 0 ? getOperatingRate() * this.i1 : 0.0f;
            if (this.O0 != operatingRate || z) {
                this.O0 = operatingRate;
                F(this.N0, operatingRate);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        if (!mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, true)) {
            return 0;
        }
        int i = format2.width;
        CodecMaxValues codecMaxValues = this.K0;
        if (i > codecMaxValues.width || format2.height > codecMaxValues.height || getMaxInputSize(mediaCodecInfo, format2) > this.K0.inputSize) {
            return 0;
        }
        return format.initializationDataEquals(format2) ? 3 : 2;
    }

    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!t1) {
                u1 = v();
                t1 = true;
            }
        }
        return u1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodecAdapter mediaCodecAdapter, Format format, @Nullable MediaCrypto mediaCrypto, float f) {
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.K0 = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, f, this.J0, this.o1);
        if (this.N0 == null) {
            if (G(mediaCodecInfo)) {
                if (this.P0 == null) {
                    this.P0 = DummySurface.newInstanceV17(this.E0, mediaCodecInfo.secure);
                }
                this.N0 = this.P0;
            } else {
                throw new IllegalStateException();
            }
        }
        mediaCodecAdapter.configure(mediaFormat, this.N0, mediaCrypto, 0);
        if (Util.SDK_INT >= 23 && this.n1) {
            this.p1 = new a(mediaCodecAdapter.getCodec());
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException createDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.N0);
    }

    public void dropOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        Point point;
        int[] iArr;
        int i;
        int w;
        int i2 = format.width;
        int i3 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        boolean z = true;
        if (formatArr.length == 1) {
            if (!(maxInputSize == -1 || (w = w(mediaCodecInfo, format.sampleMimeType, format.width, format.height)) == -1)) {
                maxInputSize = Math.min((int) (((float) maxInputSize) * 1.5f), w);
            }
            return new CodecMaxValues(i2, i3, maxInputSize);
        }
        int i4 = 0;
        boolean z2 = false;
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                int i5 = format2.width;
                z2 |= i5 == -1 || format2.height == -1;
                i2 = Math.max(i2, i5);
                i3 = Math.max(i3, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z2) {
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i2 + "x" + i3);
            int i6 = format.height;
            int i7 = format.width;
            if (i6 <= i7) {
                z = false;
            }
            int i8 = z ? i6 : i7;
            if (z) {
                i6 = i7;
            }
            float f = ((float) i6) / ((float) i8);
            int[] iArr2 = r1;
            int length = iArr2.length;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                int i9 = iArr2[i4];
                int i10 = (int) (((float) i9) * f);
                if (i9 <= i8 || i10 <= i6) {
                    break;
                }
                if (Util.SDK_INT >= 21) {
                    int i11 = z ? i10 : i9;
                    if (!z) {
                        i9 = i10;
                    }
                    point = mediaCodecInfo.alignVideoSizeV21(i11, i9);
                    i = i8;
                    iArr = iArr2;
                    if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(point.x, point.y, (double) format.frameRate)) {
                        break;
                    }
                } else {
                    i = i8;
                    iArr = iArr2;
                    try {
                        int ceilDivide = Util.ceilDivide(i9, 16) * 16;
                        int ceilDivide2 = Util.ceilDivide(i10, 16) * 16;
                        if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                            int i12 = z ? ceilDivide2 : ceilDivide;
                            if (!z) {
                                ceilDivide = ceilDivide2;
                            }
                            point = new Point(i12, ceilDivide);
                        }
                    } catch (MediaCodecUtil.DecoderQueryException unused) {
                    }
                }
                i4++;
                i6 = i6;
                f = f;
                i8 = i;
                iArr2 = iArr;
            }
            point = null;
            if (point != null) {
                i2 = Math.max(i2, point.x);
                i3 = Math.max(i3, point.y);
                maxInputSize = Math.max(maxInputSize, w(mediaCodecInfo, format.sampleMimeType, i2, i3));
                Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i2 + "x" + i3);
            }
        }
        return new CodecMaxValues(i2, i3, maxInputSize);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean getCodecNeedsEosPropagation() {
        return this.n1 && Util.SDK_INT < 23;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float f2 = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return x(mediaCodecSelector, format, z, this.n1);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, format.width);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, "profile", ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger(Constants.FirelogAnalytics.PARAM_PRIORITY, 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public Surface getSurface() {
        return this.N0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.M0) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4 && b3 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    MediaCodec codec = getCodec();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    codec.setParameters(bundle);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.P0;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    MediaCodecInfo codecInfo = getCodecInfo();
                    if (codecInfo != null && G(codecInfo)) {
                        surface = DummySurface.newInstanceV17(this.E0, codecInfo.secure);
                        this.P0 = surface;
                    }
                }
            }
            if (this.N0 != surface) {
                u();
                this.N0 = surface;
                this.Q0 = false;
                H(true);
                int state = getState();
                MediaCodec codec = getCodec();
                if (codec != null) {
                    if (Util.SDK_INT < 23 || surface == null || this.L0) {
                        releaseCodec();
                        maybeInitCodecOrBypass();
                    } else {
                        setOutputSurfaceV23(codec, surface);
                    }
                }
                if (surface == null || surface == this.P0) {
                    t();
                    s();
                    return;
                }
                C();
                s();
                if (state == 2) {
                    E();
                }
            } else if (surface != null && surface != this.P0) {
                C();
                if (this.Q0) {
                    this.G0.renderedFirstFrame(this.N0);
                }
            }
        } else if (i == 4) {
            this.R0 = ((Integer) obj).intValue();
            MediaCodec codec2 = getCodec();
            if (codec2 != null) {
                codec2.setVideoScalingMode(this.R0);
            }
        } else if (i == 6) {
            this.q1 = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.S0 || (((surface = this.P0) != null && this.N0 == surface) || getCodec() == null || this.n1))) {
            this.W0 = C.TIME_UNSET;
            return true;
        } else if (this.W0 == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.W0) {
                return true;
            }
            this.W0 = C.TIME_UNSET;
            return false;
        }
    }

    public boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec, int i, long j, long j2, boolean z) throws ExoPlaybackException {
        int skipSource = skipSource(j2);
        if (skipSource == 0) {
            return false;
        }
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedToKeyframeCount++;
        int i2 = this.a1 + skipSource;
        if (z) {
            decoderCounters.skippedOutputBufferCount += i2;
        } else {
            updateDroppedBufferCounters(i2);
        }
        flushOrReinitializeCodec();
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, long j, long j2) {
        this.G0.decoderInitialized(str, j, j2);
        this.L0 = codecNeedsSetOutputSurfaceWorkaround(str);
        this.M0 = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        t();
        s();
        this.Q0 = false;
        this.F0.disable();
        this.p1 = null;
        try {
            super.onDisabled();
        } finally {
            this.G0.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        int i = this.o1;
        int i2 = getConfiguration().tunnelingAudioSessionId;
        this.o1 = i2;
        this.n1 = i2 != 0;
        if (i2 != i) {
            releaseCodec();
        }
        this.G0.enabled(this.decoderCounters);
        this.F0.enable();
        this.T0 = z2;
        this.U0 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        super.onInputFormatChanged(formatHolder);
        this.G0.inputFormatChanged(formatHolder.format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(Format format, @Nullable MediaFormat mediaFormat) {
        int i;
        int i2;
        MediaCodec codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.R0);
        }
        if (this.n1) {
            this.e1 = format.width;
            this.f1 = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            if (z) {
                i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                i = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            }
            this.e1 = i;
            if (z) {
                i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                i2 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            }
            this.f1 = i2;
        }
        float f = format.pixelWidthHeightRatio;
        this.h1 = f;
        if (Util.SDK_INT >= 21) {
            int i3 = format.rotationDegrees;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.e1;
                this.e1 = this.f1;
                this.f1 = i4;
                this.h1 = 1.0f / f;
            }
        } else {
            this.g1 = format.rotationDegrees;
        }
        this.i1 = format.frameRate;
        H(false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        s();
        this.V0 = C.TIME_UNSET;
        this.Z0 = 0;
        if (z) {
            E();
        } else {
            this.W0 = C.TIME_UNSET;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (!this.n1) {
            this.a1--;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        s();
    }

    public void onProcessedTunneledBuffer(long j) throws ExoPlaybackException {
        updateOutputFormatForTime(j);
        B();
        this.decoderCounters.renderedOutputBufferCount++;
        A();
        onProcessedOutputBuffer(j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z = this.n1;
        if (!z) {
            this.a1++;
        }
        if (Util.SDK_INT < 23 && z) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        try {
            super.onReset();
            Surface surface = this.P0;
            if (surface != null) {
                if (this.N0 == surface) {
                    this.N0 = null;
                }
                surface.release();
                this.P0 = null;
            }
        } catch (Throwable th) {
            if (this.P0 != null) {
                Surface surface2 = this.N0;
                Surface surface3 = this.P0;
                if (surface2 == surface3) {
                    this.N0 = null;
                }
                surface3.release();
                this.P0 = null;
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.Y0 = 0;
        this.X0 = SystemClock.elapsedRealtime();
        this.b1 = SystemClock.elapsedRealtime() * 1000;
        this.c1 = 0;
        this.d1 = 0;
        H(false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.W0 = C.TIME_UNSET;
        z();
        int i = this.d1;
        if (i != 0) {
            this.G0.reportVideoFrameProcessingOffset(this.c1, i);
            this.c1 = 0;
            this.d1 = 0;
        }
        u();
        super.onStopped();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0088, code lost:
        if (shouldForceRenderOutputBuffer(r1, r13) != false) goto L_0x008d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bf A[ADDED_TO_REGION] */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processOutputBuffer(long r26, long r28, @androidx.annotation.Nullable android.media.MediaCodec r30, @androidx.annotation.Nullable java.nio.ByteBuffer r31, int r32, int r33, int r34, long r35, boolean r37, boolean r38, com.google.android.exoplayer2.Format r39) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
        // Method dump skipped, instructions count: 392
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.processOutputBuffer(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, com.google.android.exoplayer2.Format):boolean");
    }

    public void renderOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        B();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.b1 = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.Z0 = 0;
        A();
    }

    @RequiresApi(21)
    public void renderOutputBufferV21(MediaCodec mediaCodec, int i, long j, long j2) {
        B();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.b1 = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.Z0 = 0;
        A();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.a1 = 0;
    }

    public final void s() {
        MediaCodec codec;
        this.S0 = false;
        if (Util.SDK_INT >= 23 && this.n1 && (codec = getCodec()) != null) {
            this.p1 = new a(codec);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public void setOperatingRate(float f) throws ExoPlaybackException {
        super.setOperatingRate(f);
        H(false);
    }

    @RequiresApi(23)
    public void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    public boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return ((j > -500000 ? 1 : (j == -500000 ? 0 : -1)) < 0) && !z;
    }

    public boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return y(j) && !z;
    }

    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return y(j) && j2 > 100000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.N0 != null || G(mediaCodecInfo);
    }

    public void skipOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return 0;
        }
        boolean z = format.drmInitData != null;
        List<MediaCodecInfo> x = x(mediaCodecSelector, format, z, false);
        if (z && x.isEmpty()) {
            x = x(mediaCodecSelector, format, false, false);
        }
        if (x.isEmpty()) {
            return 1;
        }
        if (!MediaCodecRenderer.supportsFormatDrm(format)) {
            return 2;
        }
        MediaCodecInfo mediaCodecInfo = x.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        int i2 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        if (isFormatSupported) {
            List<MediaCodecInfo> x2 = x(mediaCodecSelector, format, z, true);
            if (!x2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo2 = x2.get(0);
                if (mediaCodecInfo2.isFormatSupported(format) && mediaCodecInfo2.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return (isFormatSupported ? 4 : 3) | i2 | i;
    }

    public final void t() {
        this.j1 = -1;
        this.k1 = -1;
        this.m1 = -1.0f;
        this.l1 = -1;
    }

    public final void u() {
        Surface surface;
        if (Util.SDK_INT >= 30 && (surface = this.N0) != null && surface != this.P0 && this.O0 != 0.0f) {
            this.O0 = 0.0f;
            F(surface, 0.0f);
        }
    }

    public void updateDroppedBufferCounters(int i) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i;
        this.Y0 += i;
        int i2 = this.Z0 + i;
        this.Z0 = i2;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i2, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i3 = this.I0;
        if (i3 > 0 && this.Y0 >= i3) {
            z();
        }
    }

    public void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.c1 += j;
        this.d1++;
    }

    public final void z() {
        if (this.Y0 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.G0.droppedFrames(this.Y0, elapsedRealtime - this.X0);
            this.Y0 = 0;
            this.X0 = elapsedRealtime;
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j) {
        this(context, mediaCodecSelector, j, null, null, -1);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, mediaCodecSelector, j, false, handler, videoRendererEventListener, i);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, mediaCodecSelector, z, 30.0f);
        this.H0 = j;
        this.I0 = i;
        Context applicationContext = context.getApplicationContext();
        this.E0 = applicationContext;
        this.F0 = new VideoFrameReleaseTimeHelper(applicationContext);
        this.G0 = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.J0 = "NVIDIA".equals(Util.MANUFACTURER);
        this.W0 = C.TIME_UNSET;
        this.e1 = -1;
        this.f1 = -1;
        this.h1 = -1.0f;
        this.R0 = 1;
        t();
    }
}
