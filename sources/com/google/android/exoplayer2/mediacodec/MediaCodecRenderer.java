package com.google.android.exoplayer2.mediacodec;

import a2.b.a.a.a;
import a2.j.b.b.t0.l;
import a2.j.b.b.v0.i;
import a2.j.b.b.v0.j;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public abstract class MediaCodecRenderer extends BaseRenderer {
    public static final float CODEC_OPERATING_RATE_UNSET = -1.0f;
    public static final byte[] D0 = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    public static final int KEEP_CODEC_RESULT_NO = 0;
    public static final int KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION = 3;
    public static final int KEEP_CODEC_RESULT_YES_WITH_FLUSH = 1;
    public static final int KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION = 2;
    public static final int OPERATION_MODE_ASYNCHRONOUS_DEDICATED_THREAD = 2;
    public static final int OPERATION_MODE_ASYNCHRONOUS_DEDICATED_THREAD_ASYNCHRONOUS_QUEUEING = 4;
    public static final int OPERATION_MODE_SYNCHRONOUS = 0;
    @Nullable
    public DrmSession A;
    public long A0 = C.TIME_UNSET;
    @Nullable
    public DrmSession B;
    public long B0 = C.TIME_UNSET;
    @Nullable
    public MediaCrypto C;
    public int C0;
    public boolean D;
    public long E = C.TIME_UNSET;
    public float F = 1.0f;
    @Nullable
    public MediaCodec G;
    @Nullable
    public MediaCodecAdapter H;
    @Nullable
    public Format I;
    @Nullable
    public MediaFormat J;
    public boolean K;
    public float L;
    @Nullable
    public ArrayDeque<MediaCodecInfo> M;
    @Nullable
    public DecoderInitializationException N;
    @Nullable
    public MediaCodecInfo O;
    public int P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    @Nullable
    public j a0;
    public ByteBuffer[] b0;
    public ByteBuffer[] c0;
    public long d0;
    public DecoderCounters decoderCounters;
    public int e0;
    public int f0;
    @Nullable
    public ByteBuffer g0;
    public boolean h0;
    public boolean i0;
    public boolean j0;
    public boolean k0;
    public boolean l0;
    public final MediaCodecSelector m;
    public int m0;
    public final boolean n;
    public int n0;
    public final float o;
    public int o0;
    public final DecoderInputBuffer p = new DecoderInputBuffer(0);
    public boolean p0;
    public final DecoderInputBuffer q = DecoderInputBuffer.newFlagsOnlyInstance();
    public boolean q0;
    public final i r = new i();
    public boolean r0;
    public final TimedValueQueue<Format> s = new TimedValueQueue<>();
    public long s0;
    public final ArrayList<Long> t = new ArrayList<>();
    public long t0;
    public final MediaCodec.BufferInfo u = new MediaCodec.BufferInfo();
    public boolean u0;
    public final long[] v = new long[10];
    public boolean v0;
    public final long[] w = new long[10];
    public boolean w0;
    public final long[] x = new long[10];
    public boolean x0;
    @Nullable
    public Format y;
    public int y0 = 0;
    @Nullable
    public Format z;
    @Nullable
    public ExoPlaybackException z0;

    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaCodecOperationMode {
    }

    public MediaCodecRenderer(int i, MediaCodecSelector mediaCodecSelector, boolean z2, float f) {
        super(i);
        this.m = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector);
        this.n = z2;
        this.o = f;
        resetCodecStateForRelease();
    }

    public static boolean supportsFormatDrm(Format format) {
        Class<? extends ExoMediaCrypto> cls = format.exoMediaCryptoType;
        return cls == null || FrameworkMediaCrypto.class.equals(cls);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e9, code lost:
        if ((r6.limit() + r7.position()) >= 3072000) goto L_0x00eb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(long r20, long r22) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
        // Method dump skipped, instructions count: 309
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.a(long, long):boolean");
    }

    public final void b() {
        this.k0 = false;
        this.r.clear();
        this.j0 = false;
    }

    public final void c() throws ExoPlaybackException {
        if (this.p0) {
            this.n0 = 1;
            this.o0 = 3;
            return;
        }
        releaseCodec();
        maybeInitCodecOrBypass();
    }

    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        return 0;
    }

    public abstract void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodecAdapter mediaCodecAdapter, Format format, @Nullable MediaCrypto mediaCrypto, float f);

    public MediaCodecDecoderException createDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(th, mediaCodecInfo);
    }

    public final void d() throws ExoPlaybackException {
        if (Util.SDK_INT < 23) {
            c();
        } else if (this.p0) {
            this.n0 = 1;
            this.o0 = 2;
        } else {
            r();
        }
    }

    public final boolean e(long j, long j2) throws ExoPlaybackException {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        ByteBuffer byteBuffer;
        boolean z5;
        if (!(this.f0 >= 0)) {
            if (!this.V || !this.q0) {
                i = this.H.dequeueOutputBufferIndex(this.u);
            } else {
                try {
                    i = this.H.dequeueOutputBufferIndex(this.u);
                } catch (IllegalStateException unused) {
                    k();
                    if (this.v0) {
                        releaseCodec();
                    }
                    return false;
                }
            }
            if (i < 0) {
                if (i == -2) {
                    this.r0 = true;
                    MediaFormat outputFormat = this.H.getOutputFormat();
                    if (this.P != 0 && outputFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) == 32 && outputFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) == 32) {
                        this.Y = true;
                    } else {
                        if (this.W) {
                            outputFormat.setInteger("channel-count", 1);
                        }
                        this.J = outputFormat;
                        this.K = true;
                    }
                    return true;
                } else if (i == -3) {
                    if (Util.SDK_INT < 21) {
                        this.c0 = this.G.getOutputBuffers();
                    }
                    return true;
                } else {
                    if (this.Z && (this.u0 || this.n0 == 2)) {
                        k();
                    }
                    return false;
                }
            } else if (this.Y) {
                this.Y = false;
                this.G.releaseOutputBuffer(i, false);
                return true;
            } else {
                MediaCodec.BufferInfo bufferInfo = this.u;
                if (bufferInfo.size != 0 || (bufferInfo.flags & 4) == 0) {
                    this.f0 = i;
                    if (Util.SDK_INT >= 21) {
                        byteBuffer = this.G.getOutputBuffer(i);
                    } else {
                        byteBuffer = this.c0[i];
                    }
                    this.g0 = byteBuffer;
                    if (byteBuffer != null) {
                        byteBuffer.position(this.u.offset);
                        ByteBuffer byteBuffer2 = this.g0;
                        MediaCodec.BufferInfo bufferInfo2 = this.u;
                        byteBuffer2.limit(bufferInfo2.offset + bufferInfo2.size);
                    }
                    long j3 = this.u.presentationTimeUs;
                    int size = this.t.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z5 = false;
                            break;
                        } else if (this.t.get(i2).longValue() == j3) {
                            this.t.remove(i2);
                            z5 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    this.h0 = z5;
                    long j4 = this.t0;
                    long j5 = this.u.presentationTimeUs;
                    this.i0 = j4 == j5;
                    updateOutputFormatForTime(j5);
                } else {
                    k();
                    return false;
                }
            }
        }
        if (!this.V || !this.q0) {
            z3 = true;
            z2 = false;
            MediaCodec mediaCodec = this.G;
            ByteBuffer byteBuffer3 = this.g0;
            int i3 = this.f0;
            MediaCodec.BufferInfo bufferInfo3 = this.u;
            z4 = processOutputBuffer(j, j2, mediaCodec, byteBuffer3, i3, bufferInfo3.flags, 1, bufferInfo3.presentationTimeUs, this.h0, this.i0, this.z);
        } else {
            try {
                MediaCodec mediaCodec2 = this.G;
                ByteBuffer byteBuffer4 = this.g0;
                int i4 = this.f0;
                MediaCodec.BufferInfo bufferInfo4 = this.u;
                z2 = false;
                z3 = true;
                try {
                    z4 = processOutputBuffer(j, j2, mediaCodec2, byteBuffer4, i4, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.h0, this.i0, this.z);
                } catch (IllegalStateException unused2) {
                }
            } catch (IllegalStateException unused3) {
                z2 = false;
                k();
                if (this.v0) {
                    releaseCodec();
                }
                return z2;
            }
        }
        if (z4) {
            onProcessedOutputBuffer(this.u.presentationTimeUs);
            boolean z7 = (this.u.flags & 4) != 0;
            this.f0 = -1;
            this.g0 = null;
            if (!z7) {
                return z3;
            }
            k();
        }
        return z2;
    }

    public void experimentalSetMediaCodecOperationMode(int i) {
        this.y0 = i;
    }

    public final boolean f() throws ExoPlaybackException {
        ByteBuffer byteBuffer;
        if (this.G == null || this.n0 == 2 || this.u0) {
            return false;
        }
        if (this.e0 < 0) {
            int dequeueInputBufferIndex = this.H.dequeueInputBufferIndex();
            this.e0 = dequeueInputBufferIndex;
            if (dequeueInputBufferIndex < 0) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = this.p;
            if (Util.SDK_INT >= 21) {
                byteBuffer = this.G.getInputBuffer(dequeueInputBufferIndex);
            } else {
                byteBuffer = this.b0[dequeueInputBufferIndex];
            }
            decoderInputBuffer.data = byteBuffer;
            this.p.clear();
        }
        if (this.n0 == 1) {
            if (!this.Z) {
                this.q0 = true;
                this.H.queueInputBuffer(this.e0, 0, 0, 0, 4);
                m();
            }
            this.n0 = 2;
            return false;
        } else if (this.X) {
            this.X = false;
            ByteBuffer byteBuffer2 = this.p.data;
            byte[] bArr = D0;
            byteBuffer2.put(bArr);
            this.H.queueInputBuffer(this.e0, 0, bArr.length, 0, 0);
            m();
            this.p0 = true;
            return true;
        } else {
            if (this.m0 == 1) {
                for (int i = 0; i < this.I.initializationData.size(); i++) {
                    this.p.data.put(this.I.initializationData.get(i));
                }
                this.m0 = 2;
            }
            int position = this.p.data.position();
            FormatHolder formatHolder = getFormatHolder();
            int readSource = readSource(formatHolder, this.p, false);
            if (hasReadStreamToEnd()) {
                this.t0 = this.s0;
            }
            if (readSource == -3) {
                return false;
            }
            if (readSource == -5) {
                if (this.m0 == 2) {
                    this.p.clear();
                    this.m0 = 1;
                }
                onInputFormatChanged(formatHolder);
                return true;
            } else if (this.p.isEndOfStream()) {
                if (this.m0 == 2) {
                    this.p.clear();
                    this.m0 = 1;
                }
                this.u0 = true;
                if (!this.p0) {
                    k();
                    return false;
                }
                try {
                    if (!this.Z) {
                        this.q0 = true;
                        this.H.queueInputBuffer(this.e0, 0, 0, 0, 4);
                        m();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw createRendererException(e, this.y);
                }
            } else if (this.p0 || this.p.isKeyFrame()) {
                boolean isEncrypted = this.p.isEncrypted();
                if (isEncrypted) {
                    this.p.cryptoInfo.increaseClearDataFirstSubSampleBy(position);
                }
                if (this.R && !isEncrypted) {
                    NalUnitUtil.discardToSps(this.p.data);
                    if (this.p.data.position() == 0) {
                        return true;
                    }
                    this.R = false;
                }
                DecoderInputBuffer decoderInputBuffer2 = this.p;
                long j = decoderInputBuffer2.timeUs;
                j jVar = this.a0;
                if (jVar != null) {
                    Format format = this.y;
                    if (!jVar.c) {
                        ByteBuffer byteBuffer3 = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer2.data);
                        int i2 = 0;
                        for (int i3 = 0; i3 < 4; i3++) {
                            i2 = (i2 << 8) | (byteBuffer3.get(i3) & 255);
                        }
                        int parseMpegAudioFrameSampleCount = MpegAudioUtil.parseMpegAudioFrameSampleCount(i2);
                        if (parseMpegAudioFrameSampleCount == -1) {
                            jVar.c = true;
                            Log.w("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
                            j = decoderInputBuffer2.timeUs;
                        } else {
                            long j2 = jVar.a;
                            if (j2 == 0) {
                                long j3 = decoderInputBuffer2.timeUs;
                                jVar.b = j3;
                                jVar.a = ((long) parseMpegAudioFrameSampleCount) - 529;
                                j = j3;
                            } else {
                                jVar.a = j2 + ((long) parseMpegAudioFrameSampleCount);
                                j = jVar.b + ((1000000 * j2) / ((long) format.sampleRate));
                            }
                        }
                    }
                }
                if (this.p.isDecodeOnly()) {
                    this.t.add(Long.valueOf(j));
                }
                if (this.w0) {
                    this.s.add(j, this.y);
                    this.w0 = false;
                }
                if (this.a0 != null) {
                    this.s0 = Math.max(this.s0, this.p.timeUs);
                } else {
                    this.s0 = Math.max(this.s0, j);
                }
                this.p.flip();
                if (this.p.hasSupplementalData()) {
                    handleInputBufferSupplementalData(this.p);
                }
                onQueueInputBuffer(this.p);
                if (isEncrypted) {
                    try {
                        this.H.queueSecureInputBuffer(this.e0, 0, this.p.cryptoInfo, j, 0);
                    } catch (MediaCodec.CryptoException e2) {
                        throw createRendererException(e2, this.y);
                    }
                } else {
                    this.H.queueInputBuffer(this.e0, 0, this.p.data.limit(), j, 0);
                }
                m();
                this.p0 = true;
                this.m0 = 0;
                this.decoderCounters.inputBufferCount++;
                return true;
            } else {
                this.p.clear();
                if (this.m0 == 2) {
                    this.m0 = 1;
                }
                return true;
            }
        }
    }

    public final boolean flushOrReinitializeCodec() throws ExoPlaybackException {
        boolean flushOrReleaseCodec = flushOrReleaseCodec();
        if (flushOrReleaseCodec) {
            maybeInitCodecOrBypass();
        }
        return flushOrReleaseCodec;
    }

    public boolean flushOrReleaseCodec() {
        if (this.G == null) {
            return false;
        }
        if (this.o0 == 3 || this.S || ((this.T && !this.r0) || (this.U && this.q0))) {
            releaseCodec();
            return true;
        }
        try {
            this.H.flush();
            return false;
        } finally {
            resetCodecStateForFlush();
        }
    }

    public final List<MediaCodecInfo> g(boolean z2) throws MediaCodecUtil.DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(this.m, this.y, z2);
        if (decoderInfos.isEmpty() && z2) {
            decoderInfos = getDecoderInfos(this.m, this.y, false);
            if (!decoderInfos.isEmpty()) {
                StringBuilder L2 = a.L("Drm session requires secure decoder for ");
                L2.append(this.y.sampleMimeType);
                L2.append(", but no secure decoder available. Trying to proceed with ");
                L2.append(decoderInfos);
                L2.append(".");
                Log.w("MediaCodecRenderer", L2.toString());
            }
        }
        return decoderInfos;
    }

    @Nullable
    public final MediaCodec getCodec() {
        return this.G;
    }

    @Nullable
    public final MediaCodecInfo getCodecInfo() {
        return this.O;
    }

    public boolean getCodecNeedsEosPropagation() {
        return false;
    }

    public float getCodecOperatingRate() {
        return this.L;
    }

    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        return -1.0f;
    }

    @Nullable
    public final MediaFormat getCodecOutputMediaFormat() {
        return this.J;
    }

    public abstract List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z2) throws MediaCodecUtil.DecoderQueryException;

    @Nullable
    public Format getInputFormat() {
        return this.y;
    }

    public final long getLargestQueuedPresentationTimeUs() {
        return this.s0;
    }

    public float getOperatingRate() {
        return this.F;
    }

    @Nullable
    public final Format getOutputFormat() {
        return this.z;
    }

    public final long getOutputStreamOffsetUs() {
        return this.B0;
    }

    public final long getOutputStreamStartPositionUs() {
        return this.A0;
    }

    @Nullable
    public final FrameworkMediaCrypto h(DrmSession drmSession) throws ExoPlaybackException {
        ExoMediaCrypto mediaCrypto = drmSession.getMediaCrypto();
        if (mediaCrypto == null || (mediaCrypto instanceof FrameworkMediaCrypto)) {
            return (FrameworkMediaCrypto) mediaCrypto;
        }
        throw createRendererException(new IllegalArgumentException("Expecting FrameworkMediaCrypto but found: " + mediaCrypto), this.y);
    }

    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01ce, code lost:
        if ("stvm8".equals(r6) == false) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01de, code lost:
        if ("OMX.amlogic.avc.decoder.awesome.secure".equals(r8) == false) goto L_0x01e2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0171 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r18, android.media.MediaCrypto r19) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 688
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.i(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, android.media.MediaCrypto):void");
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.v0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.y == null) {
            return false;
        }
        if (!isSourceReady()) {
            if (!(this.f0 >= 0) && (this.d0 == C.TIME_UNSET || SystemClock.elapsedRealtime() >= this.d0)) {
                return false;
            }
        }
        return true;
    }

    public final void j(MediaCrypto mediaCrypto, boolean z2) throws DecoderInitializationException {
        if (this.M == null) {
            try {
                List<MediaCodecInfo> g = g(z2);
                ArrayDeque<MediaCodecInfo> arrayDeque = new ArrayDeque<>();
                this.M = arrayDeque;
                if (this.n) {
                    arrayDeque.addAll(g);
                } else if (!g.isEmpty()) {
                    this.M.add(g.get(0));
                }
                this.N = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(this.y, e, z2, -49998);
            }
        }
        if (!this.M.isEmpty()) {
            while (this.G == null) {
                MediaCodecInfo peekFirst = this.M.peekFirst();
                if (shouldInitCodec(peekFirst)) {
                    try {
                        i(peekFirst, mediaCrypto);
                    } catch (Exception e2) {
                        Log.w("MediaCodecRenderer", "Failed to initialize decoder: " + peekFirst, e2);
                        this.M.removeFirst();
                        DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.y, e2, z2, peekFirst);
                        if (this.N == null) {
                            this.N = decoderInitializationException;
                        } else {
                            DecoderInitializationException decoderInitializationException2 = this.N;
                            this.N = new DecoderInitializationException(decoderInitializationException2.getMessage(), decoderInitializationException2.getCause(), decoderInitializationException2.mimeType, decoderInitializationException2.secureDecoderRequired, decoderInitializationException2.codecInfo, decoderInitializationException2.diagnosticInfo, decoderInitializationException);
                        }
                        if (this.M.isEmpty()) {
                            throw this.N;
                        }
                    }
                } else {
                    return;
                }
            }
            this.M = null;
            return;
        }
        throw new DecoderInitializationException(this.y, (Throwable) null, z2, -49999);
    }

    @TargetApi(23)
    public final void k() throws ExoPlaybackException {
        int i = this.o0;
        if (i == 1) {
            flushOrReinitializeCodec();
        } else if (i == 2) {
            r();
        } else if (i != 3) {
            this.v0 = true;
            renderToEndOfStream();
        } else {
            releaseCodec();
            maybeInitCodecOrBypass();
        }
    }

    public final boolean l(boolean z2) throws ExoPlaybackException {
        FormatHolder formatHolder = getFormatHolder();
        this.q.clear();
        int readSource = readSource(formatHolder, this.q, z2);
        if (readSource == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        } else if (readSource != -4 || !this.q.isEndOfStream()) {
            return false;
        } else {
            this.u0 = true;
            k();
            return false;
        }
    }

    public boolean legacyKeepAvailableCodecInfosWithoutCodec() {
        return false;
    }

    public final void m() {
        this.e0 = -1;
        this.p.data = null;
    }

    public final void maybeInitCodecOrBypass() throws ExoPlaybackException {
        Format format;
        if (this.G == null && !this.j0 && (format = this.y) != null) {
            if (this.B != null || !shouldUseBypass(format)) {
                n(this.B);
                String str = this.y.sampleMimeType;
                DrmSession drmSession = this.A;
                if (drmSession != null) {
                    if (this.C == null) {
                        FrameworkMediaCrypto h = h(drmSession);
                        if (h != null) {
                            try {
                                MediaCrypto mediaCrypto = new MediaCrypto(h.uuid, h.sessionId);
                                this.C = mediaCrypto;
                                this.D = !h.forceAllowInsecureDecoderComponents && mediaCrypto.requiresSecureDecoderComponent(str);
                            } catch (MediaCryptoException e) {
                                throw createRendererException(e, this.y);
                            }
                        } else if (this.A.getError() == null) {
                            return;
                        }
                    }
                    if (FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) {
                        int state = this.A.getState();
                        if (state == 1) {
                            throw createRendererException(this.A.getError(), this.y);
                        } else if (state != 4) {
                            return;
                        }
                    }
                }
                try {
                    j(this.C, this.D);
                } catch (DecoderInitializationException e2) {
                    throw createRendererException(e2, this.y);
                }
            } else {
                Format format2 = this.y;
                b();
                String str2 = format2.sampleMimeType;
                if (MimeTypes.AUDIO_AAC.equals(str2) || MimeTypes.AUDIO_MPEG.equals(str2) || MimeTypes.AUDIO_OPUS.equals(str2)) {
                    i iVar = this.r;
                    Objects.requireNonNull(iVar);
                    Assertions.checkArgument(true);
                    iVar.g = 32;
                } else {
                    i iVar2 = this.r;
                    Objects.requireNonNull(iVar2);
                    Assertions.checkArgument(true);
                    iVar2.g = 1;
                }
                this.j0 = true;
            }
        }
    }

    public final void n(@Nullable DrmSession drmSession) {
        l.a(this.A, drmSession);
        this.A = drmSession;
    }

    public final void o(@Nullable DrmSession drmSession) {
        l.a(this.B, drmSession);
        this.B = drmSession;
    }

    public void onCodecInitialized(String str, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.y = null;
        this.A0 = C.TIME_UNSET;
        this.B0 = C.TIME_UNSET;
        this.C0 = 0;
        if (this.B == null && this.A == null) {
            flushOrReleaseCodec();
        } else {
            onReset();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z2, boolean z3) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0069, code lost:
        if (r6 != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00c2, code lost:
        if (r1.height == r2.height) goto L_0x00c6;
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onInputFormatChanged(com.google.android.exoplayer2.FormatHolder r6) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
        // Method dump skipped, instructions count: 243
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.onInputFormatChanged(com.google.android.exoplayer2.FormatHolder):void");
    }

    public void onOutputFormatChanged(Format format, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z2) throws ExoPlaybackException {
        this.u0 = false;
        this.v0 = false;
        this.x0 = false;
        if (this.j0) {
            this.r.c();
        } else {
            flushOrReinitializeCodec();
        }
        if (this.s.size() > 0) {
            this.w0 = true;
        }
        this.s.clear();
        int i = this.C0;
        if (i != 0) {
            this.B0 = this.w[i - 1];
            this.A0 = this.v[i - 1];
            this.C0 = 0;
        }
    }

    @CallSuper
    public void onProcessedOutputBuffer(long j) {
        while (true) {
            int i = this.C0;
            if (i != 0 && j >= this.x[0]) {
                long[] jArr = this.v;
                this.A0 = jArr[0];
                this.B0 = this.w[0];
                int i2 = i - 1;
                this.C0 = i2;
                System.arraycopy(jArr, 1, jArr, 0, i2);
                long[] jArr2 = this.w;
                System.arraycopy(jArr2, 1, jArr2, 0, this.C0);
                long[] jArr3 = this.x;
                System.arraycopy(jArr3, 1, jArr3, 0, this.C0);
                onProcessedStreamChange();
            } else {
                return;
            }
        }
    }

    public void onProcessedStreamChange() {
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        DrmSession drmSession = null;
        try {
            b();
            releaseCodec();
        } finally {
            o(drmSession);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) throws ExoPlaybackException {
        boolean z2 = true;
        if (this.B0 == C.TIME_UNSET) {
            if (this.A0 != C.TIME_UNSET) {
                z2 = false;
            }
            Assertions.checkState(z2);
            this.A0 = j;
            this.B0 = j2;
            return;
        }
        int i = this.C0;
        if (i == this.w.length) {
            StringBuilder L2 = a.L("Too many stream changes, so dropping offset: ");
            L2.append(this.w[this.C0 - 1]);
            Log.w("MediaCodecRenderer", L2.toString());
        } else {
            this.C0 = i + 1;
        }
        long[] jArr = this.v;
        int i2 = this.C0;
        jArr[i2 - 1] = j;
        this.w[i2 - 1] = j2;
        this.x[i2 - 1] = this.s0;
    }

    public final boolean p(long j) {
        return this.E == C.TIME_UNSET || SystemClock.elapsedRealtime() - j < this.E;
    }

    public abstract boolean processOutputBuffer(long j, long j2, @Nullable MediaCodec mediaCodec, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z2, boolean z3, Format format) throws ExoPlaybackException;

    public final void q() throws ExoPlaybackException {
        if (Util.SDK_INT >= 23) {
            float codecOperatingRateV23 = getCodecOperatingRateV23(this.F, this.I, getStreamFormats());
            float f = this.L;
            if (f != codecOperatingRateV23) {
                if (codecOperatingRateV23 == -1.0f) {
                    c();
                } else if (f != -1.0f || codecOperatingRateV23 > this.o) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", codecOperatingRateV23);
                    this.G.setParameters(bundle);
                    this.L = codecOperatingRateV23;
                }
            }
        }
    }

    @RequiresApi(23)
    public final void r() throws ExoPlaybackException {
        FrameworkMediaCrypto h = h(this.B);
        if (h == null) {
            releaseCodec();
            maybeInitCodecOrBypass();
        } else if (C.PLAYREADY_UUID.equals(h.uuid)) {
            releaseCodec();
            maybeInitCodecOrBypass();
        } else if (!flushOrReinitializeCodec()) {
            try {
                this.C.setMediaDrmSession(h.sessionId);
                n(this.B);
                this.n0 = 0;
                this.o0 = 0;
            } catch (MediaCryptoException e) {
                throw createRendererException(e, this.y);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.drm.DrmSession, android.media.MediaCrypto] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void releaseCodec() {
        /*
            r4 = this;
            r0 = 0
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r1 = r4.H     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0008
            r1.shutdown()     // Catch:{ all -> 0x0035 }
        L_0x0008:
            android.media.MediaCodec r1 = r4.G     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0017
            com.google.android.exoplayer2.decoder.DecoderCounters r2 = r4.decoderCounters     // Catch:{ all -> 0x0035 }
            int r3 = r2.decoderReleaseCount     // Catch:{ all -> 0x0035 }
            int r3 = r3 + 1
            r2.decoderReleaseCount = r3     // Catch:{ all -> 0x0035 }
            r1.release()     // Catch:{ all -> 0x0035 }
        L_0x0017:
            r4.G = r0
            r4.H = r0
            android.media.MediaCrypto r1 = r4.C     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0022
            r1.release()     // Catch:{ all -> 0x002b }
        L_0x0022:
            r4.C = r0
            r4.n(r0)
            r4.resetCodecStateForRelease()
            return
        L_0x002b:
            r1 = move-exception
            r4.C = r0
            r4.n(r0)
            r4.resetCodecStateForRelease()
            throw r1
        L_0x0035:
            r1 = move-exception
            r4.G = r0
            r4.H = r0
            android.media.MediaCrypto r2 = r4.C     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0041
            r2.release()     // Catch:{ all -> 0x004a }
        L_0x0041:
            r4.C = r0
            r4.n(r0)
            r4.resetCodecStateForRelease()
            throw r1
        L_0x004a:
            r1 = move-exception
            r4.C = r0
            r4.n(r0)
            r4.resetCodecStateForRelease()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.releaseCodec():void");
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        boolean z2 = false;
        if (this.x0) {
            this.x0 = false;
            k();
        }
        ExoPlaybackException exoPlaybackException = this.z0;
        if (exoPlaybackException == null) {
            boolean z3 = true;
            try {
                if (this.v0) {
                    renderToEndOfStream();
                } else if (this.y != null || l(true)) {
                    maybeInitCodecOrBypass();
                    if (this.j0) {
                        TraceUtil.beginSection("bypassRender");
                        while (a(j, j2)) {
                        }
                        TraceUtil.endSection();
                    } else if (this.G != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        TraceUtil.beginSection("drainAndFeed");
                        while (e(j, j2) && p(elapsedRealtime)) {
                        }
                        while (f() && p(elapsedRealtime)) {
                        }
                        TraceUtil.endSection();
                    } else {
                        this.decoderCounters.skippedInputBufferCount += skipSource(j);
                        l(false);
                    }
                    this.decoderCounters.ensureUpdated();
                }
            } catch (IllegalStateException e) {
                if (Util.SDK_INT < 21 || !(e instanceof MediaCodec.CodecException)) {
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    if (stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
                        z2 = true;
                    }
                    z3 = z2;
                }
                if (z3) {
                    throw createRendererException(createDecoderException(e, getCodecInfo()), this.y);
                }
                throw e;
            }
        } else {
            this.z0 = null;
            throw exoPlaybackException;
        }
    }

    public void renderToEndOfStream() throws ExoPlaybackException {
    }

    @CallSuper
    public void resetCodecStateForFlush() {
        m();
        this.f0 = -1;
        this.g0 = null;
        this.d0 = C.TIME_UNSET;
        this.q0 = false;
        this.p0 = false;
        this.X = false;
        this.Y = false;
        this.h0 = false;
        this.i0 = false;
        this.t.clear();
        this.s0 = C.TIME_UNSET;
        this.t0 = C.TIME_UNSET;
        j jVar = this.a0;
        if (jVar != null) {
            jVar.a = 0;
            jVar.b = 0;
            jVar.c = false;
        }
        this.n0 = 0;
        this.o0 = 0;
        this.m0 = this.l0 ? 1 : 0;
    }

    @CallSuper
    public void resetCodecStateForRelease() {
        resetCodecStateForFlush();
        this.z0 = null;
        this.a0 = null;
        this.M = null;
        this.O = null;
        this.I = null;
        this.J = null;
        this.K = false;
        this.r0 = false;
        this.L = -1.0f;
        this.P = 0;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.Z = false;
        this.l0 = false;
        this.m0 = 0;
        if (Util.SDK_INT < 21) {
            this.b0 = null;
            this.c0 = null;
        }
        this.D = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public void setOperatingRate(float f) throws ExoPlaybackException {
        this.F = f;
        if (this.G != null && this.o0 != 3 && getState() != 0) {
            q();
        }
    }

    public final void setPendingOutputEndOfStream() {
        this.x0 = true;
    }

    public final void setPendingPlaybackException(ExoPlaybackException exoPlaybackException) {
        this.z0 = exoPlaybackException;
    }

    public void setRenderTimeLimitMs(long j) {
        this.E = j;
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    public boolean shouldUseBypass(Format format) {
        return false;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) throws ExoPlaybackException {
        try {
            return supportsFormat(this.m, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw createRendererException(e, format);
        }
    }

    public abstract int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public final void updateOutputFormatForTime(long j) throws ExoPlaybackException {
        boolean z2;
        Format pollFloor = this.s.pollFloor(j);
        if (pollFloor == null && this.K) {
            pollFloor = this.s.pollFirst();
        }
        if (pollFloor != null) {
            this.z = pollFloor;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || (this.K && this.z != null)) {
            onOutputFormatChanged(this.z, this.J);
            this.K = false;
        }
    }

    public static class DecoderInitializationException extends Exception {
        @Nullable
        public final MediaCodecInfo codecInfo;
        @Nullable
        public final String diagnosticInfo;
        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DecoderInitializationException(com.google.android.exoplayer2.Format r11, @androidx.annotation.Nullable java.lang.Throwable r12, boolean r13, int r14) {
            /*
                r10 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Decoder init failed: ["
                r0.append(r1)
                r0.append(r14)
                java.lang.String r1 = "], "
                r0.append(r1)
                r0.append(r11)
                java.lang.String r3 = r0.toString()
                java.lang.String r5 = r11.sampleMimeType
                if (r14 >= 0) goto L_0x0020
                java.lang.String r11 = "neg_"
                goto L_0x0022
            L_0x0020:
                java.lang.String r11 = ""
            L_0x0022:
                java.lang.String r0 = "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_"
                java.lang.StringBuilder r11 = a2.b.a.a.a.Q(r0, r11)
                int r14 = java.lang.Math.abs(r14)
                r11.append(r14)
                java.lang.String r8 = r11.toString()
                r9 = 0
                r7 = 0
                r2 = r10
                r4 = r12
                r6 = r13
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException.<init>(com.google.android.exoplayer2.Format, java.lang.Throwable, boolean, int):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DecoderInitializationException(com.google.android.exoplayer2.Format r11, @androidx.annotation.Nullable java.lang.Throwable r12, boolean r13, com.google.android.exoplayer2.mediacodec.MediaCodecInfo r14) {
            /*
                r10 = this;
                java.lang.String r0 = "Decoder init failed: "
                java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
                java.lang.String r1 = r14.name
                r0.append(r1)
                java.lang.String r1 = ", "
                r0.append(r1)
                r0.append(r11)
                java.lang.String r3 = r0.toString()
                java.lang.String r5 = r11.sampleMimeType
                int r11 = com.google.android.exoplayer2.util.Util.SDK_INT
                r0 = 0
                r1 = 21
                if (r11 < r1) goto L_0x002d
                boolean r11 = r12 instanceof android.media.MediaCodec.CodecException
                if (r11 == 0) goto L_0x002d
                r11 = r12
                android.media.MediaCodec$CodecException r11 = (android.media.MediaCodec.CodecException) r11
                java.lang.String r11 = r11.getDiagnosticInfo()
                r8 = r11
                goto L_0x002e
            L_0x002d:
                r8 = r0
            L_0x002e:
                r9 = 0
                r2 = r10
                r4 = r12
                r6 = r13
                r7 = r14
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException.<init>(com.google.android.exoplayer2.Format, java.lang.Throwable, boolean, com.google.android.exoplayer2.mediacodec.MediaCodecInfo):void");
        }

        public DecoderInitializationException(String str, @Nullable Throwable th, String str2, boolean z, @Nullable MediaCodecInfo mediaCodecInfo, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.codecInfo = mediaCodecInfo;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }
    }
}
