package com.google.android.exoplayer2.audio;

import a2.j.b.b.r0.l;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
public abstract class DecoderAudioRenderer<T extends Decoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends DecoderException>> extends BaseRenderer implements MediaClock {
    public boolean A;
    public boolean B;
    public long C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public final AudioRendererEventListener.EventDispatcher m;
    public final AudioSink n;
    public final DecoderInputBuffer o;
    public DecoderCounters p;
    public Format q;
    public int r;
    public int s;
    public boolean t;
    @Nullable
    public T u;
    @Nullable
    public DecoderInputBuffer v;
    @Nullable
    public SimpleOutputBuffer w;
    @Nullable
    public DrmSession x;
    @Nullable
    public DrmSession y;
    public int z;

    public final class b implements AudioSink.Listener {
        public b(a aVar) {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int i) {
            DecoderAudioRenderer.this.m.audioSessionId(i);
            DecoderAudioRenderer.this.onAudioSessionId(i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public /* synthetic */ void onOffloadBufferEmptying() {
            l.$default$onOffloadBufferEmptying(this);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public /* synthetic */ void onOffloadBufferFull(long j) {
            l.$default$onOffloadBufferFull(this, j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionAdvancing(long j) {
            DecoderAudioRenderer.this.m.positionAdvancing(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            DecoderAudioRenderer.this.onPositionDiscontinuity();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onSkipSilenceEnabledChanged(boolean z) {
            DecoderAudioRenderer.this.m.skipSilenceEnabledChanged(z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int i, long j, long j2) {
            DecoderAudioRenderer.this.m.underrun(i, j, j2);
        }
    }

    public DecoderAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    public final boolean a() throws ExoPlaybackException, DecoderException, AudioSink.ConfigurationException, AudioSink.InitializationException, AudioSink.WriteException {
        if (this.w == null) {
            SimpleOutputBuffer simpleOutputBuffer = (SimpleOutputBuffer) this.u.dequeueOutputBuffer();
            this.w = simpleOutputBuffer;
            if (simpleOutputBuffer == null) {
                return false;
            }
            int i = simpleOutputBuffer.skippedOutputBufferCount;
            if (i > 0) {
                this.p.skippedOutputBufferCount += i;
                this.n.handleDiscontinuity();
            }
        }
        if (this.w.isEndOfStream()) {
            if (this.z == 2) {
                releaseDecoder();
                c();
                this.B = true;
            } else {
                this.w.release();
                this.w = null;
                try {
                    this.G = true;
                    this.n.playToEndOfStream();
                } catch (AudioSink.WriteException e) {
                    throw createRendererException(e, getOutputFormat(this.u));
                }
            }
            return false;
        }
        if (this.B) {
            this.n.configure(getOutputFormat(this.u).buildUpon().setEncoderDelay(this.r).setEncoderPadding(this.s).build(), 0, null);
            this.B = false;
        }
        AudioSink audioSink = this.n;
        SimpleOutputBuffer simpleOutputBuffer2 = this.w;
        if (!audioSink.handleBuffer(simpleOutputBuffer2.data, simpleOutputBuffer2.timeUs, 1)) {
            return false;
        }
        this.p.renderedOutputBufferCount++;
        this.w.release();
        this.w = null;
        return true;
    }

    public final boolean b() throws DecoderException, ExoPlaybackException {
        T t2 = this.u;
        if (t2 == null || this.z == 2 || this.F) {
            return false;
        }
        if (this.v == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) t2.dequeueInputBuffer();
            this.v = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.z == 1) {
            this.v.setFlags(4);
            this.u.queueInputBuffer(this.v);
            this.v = null;
            this.z = 2;
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        int readSource = readSource(formatHolder, this.v, false);
        if (readSource == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        } else if (readSource != -4) {
            if (readSource == -3) {
                return false;
            }
            throw new IllegalStateException();
        } else if (this.v.isEndOfStream()) {
            this.F = true;
            this.u.queueInputBuffer(this.v);
            this.v = null;
            return false;
        } else {
            this.v.flip();
            DecoderInputBuffer decoderInputBuffer2 = this.v;
            if (this.D && !decoderInputBuffer2.isDecodeOnly()) {
                if (Math.abs(decoderInputBuffer2.timeUs - this.C) > 500000) {
                    this.C = decoderInputBuffer2.timeUs;
                }
                this.D = false;
            }
            this.u.queueInputBuffer(this.v);
            this.A = true;
            this.p.inputBufferCount++;
            this.v = null;
            return true;
        }
    }

    public final void c() throws ExoPlaybackException {
        if (this.u == null) {
            d(this.y);
            ExoMediaCrypto exoMediaCrypto = null;
            DrmSession drmSession = this.x;
            if (drmSession == null || (exoMediaCrypto = drmSession.getMediaCrypto()) != null || this.x.getError() != null) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    TraceUtil.beginSection("createAudioDecoder");
                    this.u = createDecoder(this.q, exoMediaCrypto);
                    TraceUtil.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    this.m.decoderInitialized(this.u.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.p.decoderInitCount++;
                } catch (DecoderException e) {
                    throw createRendererException(e, this.q);
                }
            }
        }
    }

    public boolean canKeepCodec(Format format, Format format2) {
        return false;
    }

    public abstract T createDecoder(Format format, @Nullable ExoMediaCrypto exoMediaCrypto) throws DecoderException;

    public final void d(@Nullable DrmSession drmSession) {
        a2.j.b.b.t0.l.a(this.x, drmSession);
        this.x = drmSession;
    }

    public final void e(@Nullable DrmSession drmSession) {
        a2.j.b.b.t0.l.a(this.y, drmSession);
        this.y = drmSession;
    }

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean z2) {
        this.t = z2;
    }

    public final void f() {
        long currentPositionUs = this.n.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.E) {
                currentPositionUs = Math.max(this.C, currentPositionUs);
            }
            this.C = currentPositionUs;
            this.E = false;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock getMediaClock() {
        return this;
    }

    public abstract Format getOutputFormat(T t2);

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.n.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            f();
        }
        return this.C;
    }

    public final int getSinkFormatSupport(Format format) {
        return this.n.getFormatSupport(format);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.n.setVolume(((Float) obj).floatValue());
        } else if (i == 3) {
            this.n.setAudioAttributes((AudioAttributes) obj);
        } else if (i == 5) {
            this.n.setAuxEffectInfo((AuxEffectInfo) obj);
        } else if (i == 101) {
            this.n.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
        } else if (i != 102) {
            super.handleMessage(i, obj);
        } else {
            this.n.setAudioSessionId(((Integer) obj).intValue());
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.G && this.n.isEnded();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.n.hasPendingData() || (this.q != null && (isSourceReady() || this.w != null));
    }

    public void onAudioSessionId(int i) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.q = null;
        this.B = true;
        try {
            e(null);
            releaseDecoder();
            this.n.reset();
        } finally {
            this.m.disabled(this.p);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z2, boolean z3) throws ExoPlaybackException {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.p = decoderCounters;
        this.m.enabled(decoderCounters);
        int i = getConfiguration().tunnelingAudioSessionId;
        if (i != 0) {
            this.n.enableTunnelingV21(i);
        } else {
            this.n.disableTunneling();
        }
    }

    public final void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        e(formatHolder.drmSession);
        Format format2 = this.q;
        this.q = format;
        if (this.u == null) {
            c();
        } else if (this.y != this.x || !canKeepCodec(format2, format)) {
            if (this.A) {
                this.z = 1;
            } else {
                releaseDecoder();
                c();
                this.B = true;
            }
        }
        Format format3 = this.q;
        this.r = format3.encoderDelay;
        this.s = format3.encoderPadding;
        this.m.inputFormatChanged(format3);
    }

    @CallSuper
    public void onPositionDiscontinuity() {
        this.E = true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z2) throws ExoPlaybackException {
        if (this.t) {
            this.n.experimentalFlushWithoutAudioTrackRelease();
        } else {
            this.n.flush();
        }
        this.C = j;
        this.D = true;
        this.E = true;
        this.F = false;
        this.G = false;
        if (this.u == null) {
            return;
        }
        if (this.z != 0) {
            releaseDecoder();
            c();
            return;
        }
        this.v = null;
        SimpleOutputBuffer simpleOutputBuffer = this.w;
        if (simpleOutputBuffer != null) {
            simpleOutputBuffer.release();
            this.w = null;
        }
        this.u.flush();
        this.A = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        this.n.play();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        f();
        this.n.pause();
    }

    public final void releaseDecoder() {
        this.v = null;
        this.w = null;
        this.z = 0;
        this.A = false;
        T t2 = this.u;
        if (t2 != null) {
            t2.release();
            this.u = null;
            this.p.decoderReleaseCount++;
        }
        d(null);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.G) {
            try {
                this.n.playToEndOfStream();
            } catch (AudioSink.WriteException e) {
                throw createRendererException(e, this.q);
            }
        } else {
            if (this.q == null) {
                FormatHolder formatHolder = getFormatHolder();
                this.o.clear();
                int readSource = readSource(formatHolder, this.o, true);
                if (readSource == -5) {
                    onInputFormatChanged(formatHolder);
                } else if (readSource == -4) {
                    Assertions.checkState(this.o.isEndOfStream());
                    this.F = true;
                    try {
                        this.G = true;
                        this.n.playToEndOfStream();
                        return;
                    } catch (AudioSink.WriteException e2) {
                        throw createRendererException(e2, null);
                    }
                } else {
                    return;
                }
            }
            c();
            if (this.u != null) {
                try {
                    TraceUtil.beginSection("drainAndFeed");
                    while (a()) {
                    }
                    while (b()) {
                    }
                    TraceUtil.endSection();
                    this.p.ensureUpdated();
                } catch (AudioSink.ConfigurationException | AudioSink.InitializationException | AudioSink.WriteException | DecoderException e3) {
                    throw createRendererException(e3, this.q);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.n.setPlaybackParameters(playbackParameters);
    }

    public final boolean sinkSupportsFormat(Format format) {
        return this.n.supportsFormat(format);
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) {
        int i = 0;
        if (!MimeTypes.isAudio(format.sampleMimeType)) {
            return 0;
        }
        int supportsFormatInternal = supportsFormatInternal(format);
        if (supportsFormatInternal <= 2) {
            return supportsFormatInternal | 0 | 0;
        }
        if (Util.SDK_INT >= 21) {
            i = 32;
        }
        return supportsFormatInternal | 8 | i;
    }

    public abstract int supportsFormatInternal(Format format);

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, null, audioProcessorArr);
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, @Nullable AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, new DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1);
        this.m = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.n = audioSink;
        audioSink.setListener(new b(null));
        this.o = DecoderInputBuffer.newFlagsOnlyInstance();
        this.z = 0;
        this.B = true;
    }
}
