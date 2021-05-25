package com.google.android.exoplayer2.video;

import a2.j.b.b.t0.l;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
public abstract class DecoderVideoRenderer extends BaseRenderer {
    @Nullable
    public DrmSession A;
    @Nullable
    public DrmSession B;
    public int C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public long H;
    public long I = C.TIME_UNSET;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public long O;
    public int P;
    public int Q;
    public int R;
    public long S;
    public long T;
    public DecoderCounters decoderCounters;
    public final long m;
    public final int n;
    public final VideoRendererEventListener.EventDispatcher o;
    public final TimedValueQueue<Format> p;
    public final DecoderInputBuffer q;
    public Format r;
    public Format s;
    public Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> t;
    public VideoDecoderInputBuffer u;
    public VideoDecoderOutputBuffer v;
    @Nullable
    public Surface w;
    @Nullable
    public VideoDecoderOutputBufferRenderer x;
    @Nullable
    public VideoFrameMetadataListener y;
    public int z;

    public DecoderVideoRenderer(long j, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        super(2);
        this.m = j;
        this.n = i;
        a();
        this.p = new TimedValueQueue<>();
        this.q = DecoderInputBuffer.newFlagsOnlyInstance();
        this.o = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.C = 0;
        this.z = -1;
    }

    public static boolean d(long j) {
        return j < -30000;
    }

    public final void a() {
        this.M = -1;
        this.N = -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(long r19, long r21) throws com.google.android.exoplayer2.ExoPlaybackException, com.google.android.exoplayer2.decoder.DecoderException {
        /*
        // Method dump skipped, instructions count: 248
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.DecoderVideoRenderer.b(long, long):boolean");
    }

    public final boolean c() throws DecoderException, ExoPlaybackException {
        Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.t;
        if (decoder == null || this.C == 2 || this.K) {
            return false;
        }
        if (this.u == null) {
            VideoDecoderInputBuffer dequeueInputBuffer = decoder.dequeueInputBuffer();
            this.u = dequeueInputBuffer;
            if (dequeueInputBuffer == null) {
                return false;
            }
        }
        if (this.C == 1) {
            this.u.setFlags(4);
            this.t.queueInputBuffer(this.u);
            this.u = null;
            this.C = 2;
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        int readSource = readSource(formatHolder, this.u, false);
        if (readSource == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        } else if (readSource != -4) {
            if (readSource == -3) {
                return false;
            }
            throw new IllegalStateException();
        } else if (this.u.isEndOfStream()) {
            this.K = true;
            this.t.queueInputBuffer(this.u);
            this.u = null;
            return false;
        } else {
            if (this.J) {
                this.p.add(this.u.timeUs, this.r);
                this.J = false;
            }
            this.u.flip();
            VideoDecoderInputBuffer videoDecoderInputBuffer = this.u;
            videoDecoderInputBuffer.format = this.r;
            onQueueInputBuffer(videoDecoderInputBuffer);
            this.t.queueInputBuffer(this.u);
            this.R++;
            this.D = true;
            this.decoderCounters.inputBufferCount++;
            this.u = null;
            return true;
        }
    }

    public boolean canKeepCodec(Format format, Format format2) {
        return false;
    }

    public abstract Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> createDecoder(Format format, @Nullable ExoMediaCrypto exoMediaCrypto) throws DecoderException;

    public void dropOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        updateDroppedBufferCounters(1);
        videoDecoderOutputBuffer.release();
    }

    public final void e() throws ExoPlaybackException {
        if (this.t == null) {
            h(this.B);
            ExoMediaCrypto exoMediaCrypto = null;
            DrmSession drmSession = this.A;
            if (drmSession == null || (exoMediaCrypto = drmSession.getMediaCrypto()) != null || this.A.getError() != null) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    this.t = createDecoder(this.r, exoMediaCrypto);
                    setDecoderOutputMode(this.z);
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    onDecoderInitialized(this.t.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.decoderCounters.decoderInitCount++;
                } catch (DecoderException e) {
                    throw createRendererException(e, this.r);
                }
            }
        }
    }

    public final void f() {
        if (this.P > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.o.droppedFrames(this.P, elapsedRealtime - this.O);
            this.P = 0;
            this.O = elapsedRealtime;
        }
    }

    @CallSuper
    public void flushDecoder() throws ExoPlaybackException {
        this.R = 0;
        if (this.C != 0) {
            releaseDecoder();
            e();
            return;
        }
        this.u = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.v;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.v = null;
        }
        this.t.flush();
        this.D = false;
    }

    public final void g() {
        int i = this.M;
        if (i != -1 || this.N != -1) {
            this.o.videoSizeChanged(i, this.N, 0, 1.0f);
        }
    }

    public final void h(@Nullable DrmSession drmSession) {
        l.a(this.A, drmSession);
        this.A = drmSession;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setOutputSurface((Surface) obj);
        } else if (i == 8) {
            setOutputBufferRenderer((VideoDecoderOutputBufferRenderer) obj);
        } else if (i == 6) {
            this.y = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    public final void i() {
        this.I = this.m > 0 ? SystemClock.elapsedRealtime() + this.m : C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        if ((r9.z != -1) == false) goto L_0x0023;
     */
    @Override // com.google.android.exoplayer2.Renderer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isReady() {
        /*
            r9 = this;
            com.google.android.exoplayer2.Format r0 = r9.r
            r1 = 0
            r2 = 1
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0026
            boolean r0 = r9.isSourceReady()
            if (r0 != 0) goto L_0x0015
            com.google.android.exoplayer2.video.VideoDecoderOutputBuffer r0 = r9.v
            if (r0 == 0) goto L_0x0026
        L_0x0015:
            boolean r0 = r9.E
            if (r0 != 0) goto L_0x0023
            int r0 = r9.z
            r5 = -1
            if (r0 == r5) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            if (r0 != 0) goto L_0x0026
        L_0x0023:
            r9.I = r3
            return r2
        L_0x0026:
            long r5 = r9.I
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
            return r1
        L_0x002d:
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r7 = r9.I
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0038
            return r2
        L_0x0038:
            r9.I = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.DecoderVideoRenderer.isReady():boolean");
    }

    public final void j(@Nullable DrmSession drmSession) {
        l.a(this.B, drmSession);
        this.B = drmSession;
    }

    public boolean maybeDropBuffersToKeyframe(long j) throws ExoPlaybackException {
        int skipSource = skipSource(j);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.R + skipSource);
        flushDecoder();
        return true;
    }

    @CallSuper
    public void onDecoderInitialized(String str, long j, long j2) {
        this.o.decoderInitialized(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.r = null;
        a();
        this.E = false;
        try {
            j(null);
            releaseDecoder();
        } finally {
            this.o.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z2, boolean z3) throws ExoPlaybackException {
        DecoderCounters decoderCounters2 = new DecoderCounters();
        this.decoderCounters = decoderCounters2;
        this.o.enabled(decoderCounters2);
        this.F = z3;
        this.G = false;
    }

    @CallSuper
    public void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        this.J = true;
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        j(formatHolder.drmSession);
        Format format2 = this.r;
        this.r = format;
        if (this.t == null) {
            e();
        } else if (this.B != this.A || !canKeepCodec(format2, format)) {
            if (this.D) {
                this.C = 1;
            } else {
                releaseDecoder();
                e();
            }
        }
        this.o.inputFormatChanged(this.r);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z2) throws ExoPlaybackException {
        this.K = false;
        this.L = false;
        this.E = false;
        this.H = C.TIME_UNSET;
        this.Q = 0;
        if (this.t != null) {
            flushDecoder();
        }
        if (z2) {
            i();
        } else {
            this.I = C.TIME_UNSET;
        }
        this.p.clear();
    }

    @CallSuper
    public void onProcessedOutputBuffer(long j) {
        this.R--;
    }

    public void onQueueInputBuffer(VideoDecoderInputBuffer videoDecoderInputBuffer) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        this.P = 0;
        this.O = SystemClock.elapsedRealtime();
        this.S = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.I = C.TIME_UNSET;
        f();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) throws ExoPlaybackException {
        this.T = j2;
        super.onStreamChanged(formatArr, j, j2);
    }

    @CallSuper
    public void releaseDecoder() {
        this.u = null;
        this.v = null;
        this.C = 0;
        this.D = false;
        this.R = 0;
        Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.t;
        if (decoder != null) {
            decoder.release();
            this.t = null;
            this.decoderCounters.decoderReleaseCount++;
        }
        h(null);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        if (!this.L) {
            if (this.r == null) {
                FormatHolder formatHolder = getFormatHolder();
                this.q.clear();
                int readSource = readSource(formatHolder, this.q, true);
                if (readSource == -5) {
                    onInputFormatChanged(formatHolder);
                } else if (readSource == -4) {
                    Assertions.checkState(this.q.isEndOfStream());
                    this.K = true;
                    this.L = true;
                    return;
                } else {
                    return;
                }
            }
            e();
            if (this.t != null) {
                try {
                    TraceUtil.beginSection("drainAndFeed");
                    while (b(j, j2)) {
                    }
                    while (c()) {
                    }
                    TraceUtil.endSection();
                    this.decoderCounters.ensureUpdated();
                } catch (DecoderException e) {
                    throw createRendererException(e, this.r);
                }
            }
        }
    }

    public void renderOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j, Format format) throws DecoderException {
        VideoFrameMetadataListener videoFrameMetadataListener = this.y;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, System.nanoTime(), format, null);
        }
        this.S = C.msToUs(SystemClock.elapsedRealtime() * 1000);
        int i = videoDecoderOutputBuffer.mode;
        boolean z2 = i == 1 && this.w != null;
        boolean z3 = i == 0 && this.x != null;
        if (z3 || z2) {
            int i2 = videoDecoderOutputBuffer.width;
            int i3 = videoDecoderOutputBuffer.height;
            if (!(this.M == i2 && this.N == i3)) {
                this.M = i2;
                this.N = i3;
                this.o.videoSizeChanged(i2, i3, 0, 1.0f);
            }
            if (z3) {
                this.x.setOutputBuffer(videoDecoderOutputBuffer);
            } else {
                renderOutputBufferToSurface(videoDecoderOutputBuffer, this.w);
            }
            this.Q = 0;
            this.decoderCounters.renderedOutputBufferCount++;
            this.G = true;
            if (!this.E) {
                this.E = true;
                this.o.renderedFirstFrame(this.w);
                return;
            }
            return;
        }
        dropOutputBuffer(videoDecoderOutputBuffer);
    }

    public abstract void renderOutputBufferToSurface(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws DecoderException;

    public abstract void setDecoderOutputMode(int i);

    public final void setOutputBufferRenderer(@Nullable VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        if (this.x != videoDecoderOutputBufferRenderer) {
            this.x = videoDecoderOutputBufferRenderer;
            if (videoDecoderOutputBufferRenderer != null) {
                this.w = null;
                this.z = 0;
                if (this.t != null) {
                    setDecoderOutputMode(0);
                }
                g();
                this.E = false;
                if (getState() == 2) {
                    i();
                    return;
                }
                return;
            }
            this.z = -1;
            a();
            this.E = false;
        } else if (videoDecoderOutputBufferRenderer != null) {
            g();
            if (this.E) {
                this.o.renderedFirstFrame(this.w);
            }
        }
    }

    public final void setOutputSurface(@Nullable Surface surface) {
        if (this.w != surface) {
            this.w = surface;
            if (surface != null) {
                this.x = null;
                this.z = 1;
                if (this.t != null) {
                    setDecoderOutputMode(1);
                }
                g();
                this.E = false;
                if (getState() == 2) {
                    i();
                    return;
                }
                return;
            }
            this.z = -1;
            a();
            this.E = false;
        } else if (surface != null) {
            g();
            if (this.E) {
                this.o.renderedFirstFrame(this.w);
            }
        }
    }

    public boolean shouldDropBuffersToKeyframe(long j, long j2) {
        return j < -500000;
    }

    public boolean shouldDropOutputBuffer(long j, long j2) {
        return d(j);
    }

    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return d(j) && j2 > 100000;
    }

    public void skipOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.decoderCounters.skippedOutputBufferCount++;
        videoDecoderOutputBuffer.release();
    }

    public void updateDroppedBufferCounters(int i) {
        DecoderCounters decoderCounters2 = this.decoderCounters;
        decoderCounters2.droppedBufferCount += i;
        this.P += i;
        int i2 = this.Q + i;
        this.Q = i2;
        decoderCounters2.maxConsecutiveDroppedBufferCount = Math.max(i2, decoderCounters2.maxConsecutiveDroppedBufferCount);
        int i3 = this.n;
        if (i3 > 0 && this.P >= i3) {
            f();
        }
    }
}
