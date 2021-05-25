package com.google.android.exoplayer2;

import a2.j.b.b.b0;
import a2.j.b.b.d0;
import a2.j.b.b.j0;
import a2.j.b.b.k0;
import a2.j.b.b.o0;
import a2.j.b.b.p0;
import a2.j.b.b.r;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, Player.AudioComponent, Player.VideoComponent, Player.TextComponent, Player.MetadataComponent, Player.DeviceComponent {
    @Nullable
    public DecoderCounters A;
    public int B;
    public AudioAttributes C;
    public float D;
    public boolean E;
    public List<Cue> F;
    @Nullable
    public VideoFrameMetadataListener G;
    @Nullable
    public CameraMotionListener H;
    public boolean I;
    public boolean J;
    @Nullable
    public PriorityTaskManager K;
    public boolean L;
    public boolean M;
    public DeviceInfo N;
    public final d0 a;
    public final b b;
    public final CopyOnWriteArraySet<com.google.android.exoplayer2.video.VideoListener> c;
    public final CopyOnWriteArraySet<AudioListener> d;
    public final CopyOnWriteArraySet<TextOutput> e;
    public final CopyOnWriteArraySet<MetadataOutput> f;
    public final CopyOnWriteArraySet<DeviceListener> g;
    public final CopyOnWriteArraySet<VideoRendererEventListener> h;
    public final CopyOnWriteArraySet<AudioRendererEventListener> i;
    public final AnalyticsCollector j;
    public final AudioBecomingNoisyManager k;
    public final AudioFocusManager l;
    public final StreamVolumeManager m;
    public final o0 n;
    public final p0 o;
    @Nullable
    public Format p;
    @Nullable
    public Format q;
    @Nullable
    public VideoDecoderOutputBufferRenderer r;
    public final Renderer[] renderers;
    @Nullable
    public Surface s;
    public boolean t;
    public int u;
    @Nullable
    public SurfaceHolder v;
    @Nullable
    public TextureView w;
    public int x;
    public int y;
    @Nullable
    public DecoderCounters z;

    public static final class Builder {
        public final Context a;
        public final RenderersFactory b;
        public Clock c;
        public TrackSelector d;
        public MediaSourceFactory e;
        public LoadControl f;
        public BandwidthMeter g;
        public AnalyticsCollector h;
        public Looper i;
        @Nullable
        public PriorityTaskManager j;
        public AudioAttributes k;
        public boolean l;
        public int m;
        public boolean n;
        public boolean o;
        public int p;
        public boolean q;
        public SeekParameters r;
        public boolean s;
        public boolean t;
        public boolean u;

        public Builder(Context context) {
            this(context, new DefaultRenderersFactory(context), new DefaultExtractorsFactory());
        }

        public SimpleExoPlayer build() {
            Assertions.checkState(!this.u);
            this.u = true;
            return new SimpleExoPlayer(this);
        }

        public Builder experimentalSetThrowWhenStuckBuffering(boolean z) {
            this.t = z;
            return this;
        }

        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
            Assertions.checkState(!this.u);
            this.h = analyticsCollector;
            return this;
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
            Assertions.checkState(!this.u);
            this.k = audioAttributes;
            this.l = z;
            return this;
        }

        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            Assertions.checkState(!this.u);
            this.g = bandwidthMeter;
            return this;
        }

        @VisibleForTesting
        public Builder setClock(Clock clock) {
            Assertions.checkState(!this.u);
            this.c = clock;
            return this;
        }

        public Builder setHandleAudioBecomingNoisy(boolean z) {
            Assertions.checkState(!this.u);
            this.n = z;
            return this;
        }

        public Builder setLoadControl(LoadControl loadControl) {
            Assertions.checkState(!this.u);
            this.f = loadControl;
            return this;
        }

        public Builder setLooper(Looper looper) {
            Assertions.checkState(!this.u);
            this.i = looper;
            return this;
        }

        public Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory) {
            Assertions.checkState(!this.u);
            this.e = mediaSourceFactory;
            return this;
        }

        public Builder setPauseAtEndOfMediaItems(boolean z) {
            Assertions.checkState(!this.u);
            this.s = z;
            return this;
        }

        public Builder setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
            Assertions.checkState(!this.u);
            this.j = priorityTaskManager;
            return this;
        }

        public Builder setSeekParameters(SeekParameters seekParameters) {
            Assertions.checkState(!this.u);
            this.r = seekParameters;
            return this;
        }

        public Builder setSkipSilenceEnabled(boolean z) {
            Assertions.checkState(!this.u);
            this.o = z;
            return this;
        }

        public Builder setTrackSelector(TrackSelector trackSelector) {
            Assertions.checkState(!this.u);
            this.d = trackSelector;
            return this;
        }

        public Builder setUseLazyPreparation(boolean z) {
            Assertions.checkState(!this.u);
            this.q = z;
            return this;
        }

        public Builder setVideoScalingMode(int i2) {
            Assertions.checkState(!this.u);
            this.p = i2;
            return this;
        }

        public Builder setWakeMode(int i2) {
            Assertions.checkState(!this.u);
            this.m = i2;
            return this;
        }

        public Builder(Context context, RenderersFactory renderersFactory) {
            this(context, renderersFactory, new DefaultExtractorsFactory());
        }

        public Builder(Context context, ExtractorsFactory extractorsFactory) {
            this(context, new DefaultRenderersFactory(context), extractorsFactory);
        }

        public Builder(Context context, RenderersFactory renderersFactory, ExtractorsFactory extractorsFactory) {
            this(context, renderersFactory, new DefaultTrackSelector(context), new DefaultMediaSourceFactory(context, extractorsFactory), new DefaultLoadControl(), DefaultBandwidthMeter.getSingletonInstance(context), new AnalyticsCollector(Clock.DEFAULT));
        }

        public Builder(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this.a = context;
            this.b = renderersFactory;
            this.d = trackSelector;
            this.e = mediaSourceFactory;
            this.f = loadControl;
            this.g = bandwidthMeter;
            this.h = analyticsCollector;
            this.i = Util.getCurrentOrMainLooper();
            this.k = AudioAttributes.DEFAULT;
            this.m = 0;
            this.p = 1;
            this.q = true;
            this.r = SeekParameters.DEFAULT;
            this.c = Clock.DEFAULT;
            this.t = true;
        }
    }

    @Deprecated
    public interface VideoListener extends com.google.android.exoplayer2.video.VideoListener {
    }

    public final class b implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, Player.EventListener {
        public b(a aVar) {
        }

        @Override // com.google.android.exoplayer2.AudioFocusManager.PlayerControl
        public void executePlayerCommand(int i) {
            boolean playWhenReady = SimpleExoPlayer.this.getPlayWhenReady();
            SimpleExoPlayer.this.i(playWhenReady, i, SimpleExoPlayer.b(playWhenReady, i));
        }

        @Override // com.google.android.exoplayer2.AudioBecomingNoisyManager.EventListener
        public void onAudioBecomingNoisy() {
            SimpleExoPlayer.this.i(false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j, long j2) {
            Iterator<AudioRendererEventListener> it = SimpleExoPlayer.this.i.iterator();
            while (it.hasNext()) {
                it.next().onAudioDecoderInitialized(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters) {
            Iterator<AudioRendererEventListener> it = SimpleExoPlayer.this.i.iterator();
            while (it.hasNext()) {
                it.next().onAudioDisabled(decoderCounters);
            }
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.q = null;
            simpleExoPlayer.A = null;
            simpleExoPlayer.B = 0;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.A = decoderCounters;
            Iterator<AudioRendererEventListener> it = simpleExoPlayer.i.iterator();
            while (it.hasNext()) {
                it.next().onAudioEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.q = format;
            Iterator<AudioRendererEventListener> it = simpleExoPlayer.i.iterator();
            while (it.hasNext()) {
                it.next().onAudioInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioPositionAdvancing(long j) {
            Iterator<AudioRendererEventListener> it = SimpleExoPlayer.this.i.iterator();
            while (it.hasNext()) {
                it.next().onAudioPositionAdvancing(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int i) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.B != i) {
                simpleExoPlayer.B = i;
                simpleExoPlayer.d();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioUnderrun(int i, long j, long j2) {
            Iterator<AudioRendererEventListener> it = SimpleExoPlayer.this.i.iterator();
            while (it.hasNext()) {
                it.next().onAudioUnderrun(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.F = list;
            Iterator<TextOutput> it = simpleExoPlayer.e.iterator();
            while (it.hasNext()) {
                it.next().onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i, long j) {
            Iterator<VideoRendererEventListener> it = SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                it.next().onDroppedFrames(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
            k0.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onIsLoadingChanged(boolean z) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            PriorityTaskManager priorityTaskManager = simpleExoPlayer.K;
            if (priorityTaskManager == null) {
                return;
            }
            if (z && !simpleExoPlayer.L) {
                priorityTaskManager.add(0);
                SimpleExoPlayer.this.L = true;
            } else if (!z && simpleExoPlayer.L) {
                priorityTaskManager.remove(0);
                SimpleExoPlayer.this.L = false;
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            k0.$default$onIsPlayingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onLoadingChanged(boolean z) {
            k0.$default$onLoadingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            k0.$default$onMediaItemTransition(this, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataOutput
        public void onMetadata(Metadata metadata) {
            Iterator<MetadataOutput> it = SimpleExoPlayer.this.f.iterator();
            while (it.hasNext()) {
                it.next().onMetadata(metadata);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            SimpleExoPlayer.a(SimpleExoPlayer.this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            k0.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            SimpleExoPlayer.a(SimpleExoPlayer.this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            k0.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            k0.$default$onPlayerError(this, exoPlaybackException);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            k0.$default$onPlayerStateChanged(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            k0.$default$onPositionDiscontinuity(this, i);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.s == surface) {
                Iterator<com.google.android.exoplayer2.video.VideoListener> it = simpleExoPlayer.c.iterator();
                while (it.hasNext()) {
                    it.next().onRenderedFirstFrame();
                }
            }
            Iterator<VideoRendererEventListener> it2 = SimpleExoPlayer.this.h.iterator();
            while (it2.hasNext()) {
                it2.next().onRenderedFirstFrame(surface);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onRepeatModeChanged(int i) {
            k0.$default$onRepeatModeChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            k0.$default$onSeekProcessed(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            k0.$default$onShuffleModeEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onSkipSilenceEnabledChanged(boolean z) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.E != z) {
                simpleExoPlayer.E = z;
                simpleExoPlayer.e();
            }
        }

        @Override // com.google.android.exoplayer2.StreamVolumeManager.Listener
        public void onStreamTypeChanged(int i) {
            StreamVolumeManager streamVolumeManager = SimpleExoPlayer.this.m;
            DeviceInfo deviceInfo = new DeviceInfo(0, streamVolumeManager.b(), streamVolumeManager.a());
            if (!deviceInfo.equals(SimpleExoPlayer.this.N)) {
                SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
                simpleExoPlayer.N = deviceInfo;
                Iterator<DeviceListener> it = simpleExoPlayer.g.iterator();
                while (it.hasNext()) {
                    it.next().onDeviceInfoChanged(deviceInfo);
                }
            }
        }

        @Override // com.google.android.exoplayer2.StreamVolumeManager.Listener
        public void onStreamVolumeChanged(int i, boolean z) {
            Iterator<DeviceListener> it = SimpleExoPlayer.this.g.iterator();
            while (it.hasNext()) {
                it.next().onDeviceVolumeChanged(i, z);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.h(new Surface(surfaceTexture), true);
            SimpleExoPlayer.this.c(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.h(null, true);
            SimpleExoPlayer.this.c(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.c(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            k0.$default$onTimelineChanged(this, timeline, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
            k0.$default$onTimelineChanged(this, timeline, obj, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            k0.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j, long j2) {
            Iterator<VideoRendererEventListener> it = SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                it.next().onVideoDecoderInitialized(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters) {
            Iterator<VideoRendererEventListener> it = SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                it.next().onVideoDisabled(decoderCounters);
            }
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.p = null;
            simpleExoPlayer.z = null;
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.z = decoderCounters;
            Iterator<VideoRendererEventListener> it = simpleExoPlayer.h.iterator();
            while (it.hasNext()) {
                it.next().onVideoEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoFrameProcessingOffset(long j, int i) {
            Iterator<VideoRendererEventListener> it = SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                it.next().onVideoFrameProcessingOffset(j, i);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.p = format;
            Iterator<VideoRendererEventListener> it = simpleExoPlayer.h.iterator();
            while (it.hasNext()) {
                it.next().onVideoInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            Iterator<com.google.android.exoplayer2.video.VideoListener> it = SimpleExoPlayer.this.c.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.video.VideoListener next = it.next();
                if (!SimpleExoPlayer.this.h.contains(next)) {
                    next.onVideoSizeChanged(i, i2, i3, f);
                }
            }
            Iterator<VideoRendererEventListener> it2 = SimpleExoPlayer.this.h.iterator();
            while (it2.hasNext()) {
                it2.next().onVideoSizeChanged(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.AudioFocusManager.PlayerControl
        public void setVolumeMultiplier(float f) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.g(1, 2, Float.valueOf(simpleExoPlayer.D * simpleExoPlayer.l.g));
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            SimpleExoPlayer.this.c(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.h(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.h(null, false);
            SimpleExoPlayer.this.c(0, 0);
        }
    }

    @Deprecated
    public SimpleExoPlayer(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean z2, Clock clock, Looper looper) {
        this(new Builder(context, renderersFactory).setTrackSelector(trackSelector).setMediaSourceFactory(mediaSourceFactory).setLoadControl(loadControl).setBandwidthMeter(bandwidthMeter).setAnalyticsCollector(analyticsCollector).setUseLazyPreparation(z2).setClock(clock).setLooper(looper));
    }

    public static void a(SimpleExoPlayer simpleExoPlayer) {
        int playbackState = simpleExoPlayer.getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                o0 o0Var = simpleExoPlayer.n;
                o0Var.d = simpleExoPlayer.getPlayWhenReady();
                o0Var.b();
                p0 p0Var = simpleExoPlayer.o;
                p0Var.d = simpleExoPlayer.getPlayWhenReady();
                p0Var.b();
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        o0 o0Var2 = simpleExoPlayer.n;
        o0Var2.d = false;
        o0Var2.b();
        p0 p0Var2 = simpleExoPlayer.o;
        p0Var2.d = false;
        p0Var2.b();
    }

    public static int b(boolean z2, int i2) {
        return (!z2 || i2 == 1) ? 1 : 2;
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.j.addListener(analyticsListener);
    }

    @Deprecated
    public void addAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        Assertions.checkNotNull(audioRendererEventListener);
        this.i.add(audioRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void addAudioListener(AudioListener audioListener) {
        Assertions.checkNotNull(audioListener);
        this.d.add(audioListener);
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void addDeviceListener(DeviceListener deviceListener) {
        Assertions.checkNotNull(deviceListener);
        this.g.add(deviceListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.EventListener eventListener) {
        Assertions.checkNotNull(eventListener);
        this.a.addListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void addMediaItem(MediaItem mediaItem) {
        j();
        this.a.addMediaItem(mediaItem);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(List<MediaItem> list) {
        j();
        d0 d0Var = this.a;
        d0Var.addMediaItems(d0Var.k.size(), list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(MediaSource mediaSource) {
        j();
        d0 d0Var = this.a;
        Objects.requireNonNull(d0Var);
        d0Var.addMediaSources(d0Var.k.size(), Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(List<MediaSource> list) {
        j();
        d0 d0Var = this.a;
        d0Var.addMediaSources(d0Var.k.size(), list);
    }

    @Override // com.google.android.exoplayer2.Player.MetadataComponent
    public void addMetadataOutput(MetadataOutput metadataOutput) {
        Assertions.checkNotNull(metadataOutput);
        this.f.add(metadataOutput);
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public void addTextOutput(TextOutput textOutput) {
        Assertions.checkNotNull(textOutput);
        this.e.add(textOutput);
    }

    @Deprecated
    public void addVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        Assertions.checkNotNull(videoRendererEventListener);
        this.h.add(videoRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void addVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener) {
        Assertions.checkNotNull(videoListener);
        this.c.add(videoListener);
    }

    public final void c(int i2, int i3) {
        if (i2 != this.x || i3 != this.y) {
            this.x = i2;
            this.y = i3;
            Iterator<com.google.android.exoplayer2.video.VideoListener> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().onSurfaceSizeChanged(i2, i3);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void clearAuxEffectInfo() {
        setAuxEffectInfo(new AuxEffectInfo(0, 0.0f));
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener) {
        j();
        if (this.H == cameraMotionListener) {
            g(5, 7, null);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearMediaItems() {
        j();
        d0 d0Var = this.a;
        d0Var.removeMediaItems(0, d0Var.k.size());
    }

    @Deprecated
    public void clearMetadataOutput(MetadataOutput metadataOutput) {
        removeMetadataOutput(metadataOutput);
    }

    @Deprecated
    public void clearTextOutput(TextOutput textOutput) {
        removeTextOutput(textOutput);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoDecoderOutputBufferRenderer() {
        j();
        g(2, 8, null);
        this.r = null;
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        j();
        if (this.G == videoFrameMetadataListener) {
            g(2, 6, null);
        }
    }

    @Deprecated
    public void clearVideoListener(VideoListener videoListener) {
        removeVideoListener(videoListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurface() {
        j();
        f();
        h(null, false);
        c(0, 0);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        j();
        if (surfaceHolder != null && surfaceHolder == this.v) {
            setVideoSurfaceHolder(null);
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        j();
        if (textureView != null && textureView == this.w) {
            setVideoTextureView(null);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public PlayerMessage createMessage(PlayerMessage.Target target) {
        j();
        return this.a.createMessage(target);
    }

    public final void d() {
        Iterator<AudioListener> it = this.d.iterator();
        while (it.hasNext()) {
            AudioListener next = it.next();
            if (!this.i.contains(next)) {
                next.onAudioSessionId(this.B);
            }
        }
        Iterator<AudioRendererEventListener> it2 = this.i.iterator();
        while (it2.hasNext()) {
            it2.next().onAudioSessionId(this.B);
        }
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void decreaseDeviceVolume() {
        j();
        StreamVolumeManager streamVolumeManager = this.m;
        if (streamVolumeManager.g > streamVolumeManager.b()) {
            streamVolumeManager.d.adjustStreamVolume(streamVolumeManager.f, -1, 1);
            streamVolumeManager.e();
        }
    }

    public final void e() {
        Iterator<AudioListener> it = this.d.iterator();
        while (it.hasNext()) {
            AudioListener next = it.next();
            if (!this.i.contains(next)) {
                next.onSkipSilenceEnabledChanged(this.E);
            }
        }
        Iterator<AudioRendererEventListener> it2 = this.i.iterator();
        while (it2.hasNext()) {
            it2.next().onSkipSilenceEnabledChanged(this.E);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void experimentalSetOffloadSchedulingEnabled(boolean z2) {
        this.a.f.g.obtainMessage(24, z2 ? 1 : 0, 0).sendToTarget();
    }

    public final void f() {
        TextureView textureView = this.w;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.b) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.w.setSurfaceTextureListener(null);
            }
            this.w = null;
        }
        SurfaceHolder surfaceHolder = this.v;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.b);
            this.v = null;
        }
    }

    public final void g(int i2, int i3, @Nullable Object obj) {
        Renderer[] rendererArr = this.renderers;
        for (Renderer renderer : rendererArr) {
            if (renderer.getTrackType() == i2) {
                this.a.createMessage(renderer).setType(i3).setPayload(obj).send();
            }
        }
    }

    public AnalyticsCollector getAnalyticsCollector() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.a.o;
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public AudioAttributes getAudioAttributes() {
        return this.C;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Player.AudioComponent getAudioComponent() {
        return this;
    }

    @Nullable
    public DecoderCounters getAudioDecoderCounters() {
        return this.A;
    }

    @Nullable
    public Format getAudioFormat() {
        return this.q;
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public int getAudioSessionId() {
        return this.B;
    }

    @Deprecated
    public int getAudioStreamType() {
        return Util.getStreamTypeForAudioUsage(this.C.usage);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        j();
        return this.a.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        j();
        return this.a.getContentBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        j();
        return this.a.getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        j();
        return this.a.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        j();
        return this.a.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public List<Cue> getCurrentCues() {
        j();
        return this.F;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        j();
        return this.a.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        j();
        return this.a.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        j();
        return this.a.B.a;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        j();
        return this.a.B.g;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        j();
        return this.a.getCurrentTrackSelections();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        j();
        return this.a.getCurrentWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Player.DeviceComponent getDeviceComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public DeviceInfo getDeviceInfo() {
        j();
        return this.N;
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public int getDeviceVolume() {
        j();
        return this.m.g;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        j();
        return this.a.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Player.MetadataComponent getMetadataComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean getPauseAtEndOfMediaItems() {
        j();
        return this.a.z;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        j();
        return this.a.B.j;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    @Deprecated
    public ExoPlaybackException getPlaybackError() {
        return getPlayerError();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        return this.a.f.i;
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        j();
        return this.a.B.l;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        j();
        return this.a.B.d;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        j();
        return this.a.B.k;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public ExoPlaybackException getPlayerError() {
        j();
        return this.a.B.e;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        j();
        return this.a.b.length;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i2) {
        j();
        return this.a.b[i2].getTrackType();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        j();
        return this.a.q;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public SeekParameters getSeekParameters() {
        j();
        return this.a.x;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        j();
        return this.a.r;
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public boolean getSkipSilenceEnabled() {
        return this.E;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Player.TextComponent getTextComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        j();
        return C.usToMs(this.a.B.o);
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public TrackSelector getTrackSelector() {
        j();
        return this.a.c;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Player.VideoComponent getVideoComponent() {
        return this;
    }

    @Nullable
    public DecoderCounters getVideoDecoderCounters() {
        return this.z;
    }

    @Nullable
    public Format getVideoFormat() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public int getVideoScalingMode() {
        return this.u;
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public float getVolume() {
        return this.D;
    }

    public final void h(@Nullable Surface surface, boolean z2) {
        ArrayList arrayList = new ArrayList();
        Renderer[] rendererArr = this.renderers;
        for (Renderer renderer : rendererArr) {
            if (renderer.getTrackType() == 2) {
                arrayList.add(this.a.createMessage(renderer).setType(1).setPayload(surface).send());
            }
        }
        Surface surface2 = this.s;
        if (!(surface2 == null || surface2 == surface)) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((PlayerMessage) it.next()).blockUntilDelivered();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.t) {
                this.s.release();
            }
        }
        this.s = surface;
        this.t = z2;
    }

    public final void i(boolean z2, int i2, int i3) {
        int i4 = 0;
        boolean z3 = z2 && i2 != -1;
        if (z3 && i2 != 1) {
            i4 = 1;
        }
        this.a.o(z3, i4, i3);
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void increaseDeviceVolume() {
        j();
        StreamVolumeManager streamVolumeManager = this.m;
        if (streamVolumeManager.g < streamVolumeManager.a()) {
            streamVolumeManager.d.adjustStreamVolume(streamVolumeManager.f, 1, 1);
            streamVolumeManager.e();
        }
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public boolean isDeviceMuted() {
        j();
        return this.m.h;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        j();
        return this.a.B.f;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        j();
        return this.a.isPlayingAd();
    }

    public final void j() {
        if (Looper.myLooper() == getApplicationLooper()) {
            return;
        }
        if (!this.I) {
            Log.w("SimpleExoPlayer", "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", this.J ? null : new IllegalStateException());
            this.J = true;
            return;
        }
        throw new IllegalStateException("Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread");
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void moveMediaItem(int i2, int i3) {
        j();
        this.a.moveMediaItem(i2, i3);
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i2, int i3, int i4) {
        j();
        this.a.moveMediaItems(i2, i3, i4);
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        j();
        boolean playWhenReady = getPlayWhenReady();
        int e2 = this.l.e(playWhenReady, 2);
        i(playWhenReady, e2, b(playWhenReady, e2));
        this.a.prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        j();
        this.k.a(false);
        StreamVolumeManager streamVolumeManager = this.m;
        StreamVolumeManager.b bVar = streamVolumeManager.e;
        if (bVar != null) {
            try {
                streamVolumeManager.a.unregisterReceiver(bVar);
            } catch (RuntimeException e2) {
                Log.w("StreamVolumeManager", "Error unregistering stream volume receiver", e2);
            }
            streamVolumeManager.e = null;
        }
        o0 o0Var = this.n;
        o0Var.d = false;
        o0Var.b();
        p0 p0Var = this.o;
        p0Var.d = false;
        p0Var.b();
        AudioFocusManager audioFocusManager = this.l;
        audioFocusManager.c = null;
        audioFocusManager.a();
        this.a.release();
        f();
        Surface surface = this.s;
        if (surface != null) {
            if (this.t) {
                surface.release();
            }
            this.s = null;
        }
        if (this.L) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.K)).remove(0);
            this.L = false;
        }
        this.F = Collections.emptyList();
        this.M = true;
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        this.j.removeListener(analyticsListener);
    }

    @Deprecated
    public void removeAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.i.remove(audioRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void removeAudioListener(AudioListener audioListener) {
        this.d.remove(audioListener);
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void removeDeviceListener(DeviceListener deviceListener) {
        this.g.remove(deviceListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.EventListener eventListener) {
        this.a.removeListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void removeMediaItem(int i2) {
        j();
        this.a.removeMediaItem(i2);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i2, int i3) {
        j();
        this.a.removeMediaItems(i2, i3);
    }

    @Override // com.google.android.exoplayer2.Player.MetadataComponent
    public void removeMetadataOutput(MetadataOutput metadataOutput) {
        this.f.remove(metadataOutput);
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public void removeTextOutput(TextOutput textOutput) {
        this.e.remove(textOutput);
    }

    @Deprecated
    public void removeVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.h.remove(videoRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void removeVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener) {
        this.c.remove(videoListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void retry() {
        j();
        prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i2, long j2) {
        j();
        this.j.notifySeekStarted();
        this.a.seekTo(i2, j2);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        setAudioAttributes(audioAttributes, false);
    }

    @Deprecated
    public void setAudioDebugListener(@Nullable AudioRendererEventListener audioRendererEventListener) {
        this.i.retainAll(Collections.singleton(this.j));
        if (audioRendererEventListener != null) {
            addAudioDebugListener(audioRendererEventListener);
        }
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAudioSessionId(int i2) {
        j();
        if (this.B != i2) {
            this.B = i2;
            g(1, 102, Integer.valueOf(i2));
            if (i2 != 0) {
                d();
            }
        }
    }

    @Deprecated
    public void setAudioStreamType(int i2) {
        int audioUsageForStreamType = Util.getAudioUsageForStreamType(i2);
        setAudioAttributes(new AudioAttributes.Builder().setUsage(audioUsageForStreamType).setContentType(Util.getAudioContentTypeForStreamType(i2)).build());
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        j();
        g(1, 5, auxEffectInfo);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setCameraMotionListener(CameraMotionListener cameraMotionListener) {
        j();
        this.H = cameraMotionListener;
        g(5, 7, cameraMotionListener);
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void setDeviceMuted(boolean z2) {
        j();
        StreamVolumeManager streamVolumeManager = this.m;
        Objects.requireNonNull(streamVolumeManager);
        if (Util.SDK_INT >= 23) {
            streamVolumeManager.d.adjustStreamVolume(streamVolumeManager.f, z2 ? -100 : 100, 1);
        } else {
            streamVolumeManager.d.setStreamMute(streamVolumeManager.f, z2);
        }
        streamVolumeManager.e();
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void setDeviceVolume(int i2) {
        j();
        StreamVolumeManager streamVolumeManager = this.m;
        if (i2 >= streamVolumeManager.b() && i2 <= streamVolumeManager.a()) {
            streamVolumeManager.d.setStreamVolume(streamVolumeManager.f, i2, 1);
            streamVolumeManager.e();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z2) {
        boolean z3;
        j();
        d0 d0Var = this.a;
        if (d0Var.w != z2) {
            d0Var.w = z2;
            ExoPlayerImplInternal exoPlayerImplInternal = d0Var.f;
            synchronized (exoPlayerImplInternal) {
                z3 = true;
                if (!exoPlayerImplInternal.w) {
                    if (exoPlayerImplInternal.h.isAlive()) {
                        if (z2) {
                            exoPlayerImplInternal.g.obtainMessage(13, 1, 0).sendToTarget();
                        } else {
                            AtomicBoolean atomicBoolean = new AtomicBoolean();
                            exoPlayerImplInternal.g.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
                            long j2 = exoPlayerImplInternal.L;
                            if (j2 > 0) {
                                exoPlayerImplInternal.j0(new b0(atomicBoolean), j2);
                            } else {
                                exoPlayerImplInternal.i0(new b0(atomicBoolean));
                            }
                            z3 = atomicBoolean.get();
                        }
                    }
                }
            }
            if (!z3) {
                d0Var.i(r.a);
            }
        }
    }

    public void setHandleAudioBecomingNoisy(boolean z2) {
        j();
        if (!this.M) {
            this.k.a(z2);
        }
    }

    @Deprecated
    public void setHandleWakeLock(boolean z2) {
        setWakeMode(z2 ? 1 : 0);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem) {
        j();
        this.j.resetForNewPlaylist();
        this.a.setMediaItem(mediaItem);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list) {
        j();
        this.j.resetForNewPlaylist();
        this.a.setMediaItems(list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource) {
        j();
        this.j.resetForNewPlaylist();
        d0 d0Var = this.a;
        Objects.requireNonNull(d0Var);
        d0Var.n(Collections.singletonList(mediaSource), -1, C.TIME_UNSET, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list) {
        j();
        this.j.resetForNewPlaylist();
        this.a.n(list, -1, C.TIME_UNSET, true);
    }

    @Deprecated
    public void setMetadataOutput(MetadataOutput metadataOutput) {
        this.f.retainAll(Collections.singleton(this.j));
        if (metadataOutput != null) {
            addMetadataOutput(metadataOutput);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPauseAtEndOfMediaItems(boolean z2) {
        j();
        d0 d0Var = this.a;
        if (d0Var.z != z2) {
            d0Var.z = z2;
            d0Var.f.g.obtainMessage(23, z2 ? 1 : 0, 0).sendToTarget();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z2) {
        j();
        int e2 = this.l.e(z2, getPlaybackState());
        i(z2, e2, b(z2, e2));
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters) {
        j();
        this.a.setPlaybackParameters(playbackParameters);
    }

    @RequiresApi(23)
    @Deprecated
    public void setPlaybackParams(@Nullable PlaybackParams playbackParams) {
        PlaybackParameters playbackParameters;
        if (playbackParams != null) {
            playbackParams.allowDefaults();
            playbackParameters = new PlaybackParameters(playbackParams.getSpeed(), playbackParams.getPitch());
        } else {
            playbackParameters = null;
        }
        setPlaybackParameters(playbackParameters);
    }

    public void setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
        j();
        if (!Util.areEqual(this.K, priorityTaskManager)) {
            if (this.L) {
                ((PriorityTaskManager) Assertions.checkNotNull(this.K)).remove(0);
            }
            if (priorityTaskManager == null || !isLoading()) {
                this.L = false;
            } else {
                priorityTaskManager.add(0);
                this.L = true;
            }
            this.K = priorityTaskManager;
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i2) {
        j();
        this.a.setRepeatMode(i2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(@Nullable SeekParameters seekParameters) {
        j();
        d0 d0Var = this.a;
        Objects.requireNonNull(d0Var);
        if (seekParameters == null) {
            seekParameters = SeekParameters.DEFAULT;
        }
        if (!d0Var.x.equals(seekParameters)) {
            d0Var.x = seekParameters;
            d0Var.f.g.obtainMessage(5, seekParameters).sendToTarget();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z2) {
        j();
        this.a.setShuffleModeEnabled(z2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        j();
        d0 d0Var = this.a;
        Timeline b2 = d0Var.b();
        j0 h2 = d0Var.h(d0Var.B, b2, d0Var.f(b2, d0Var.getCurrentWindowIndex(), d0Var.getCurrentPosition()));
        d0Var.s++;
        d0Var.y = shuffleOrder;
        d0Var.f.g.obtainMessage(21, shuffleOrder).sendToTarget();
        d0Var.p(h2, false, 4, 0, 1, false);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setSkipSilenceEnabled(boolean z2) {
        j();
        if (this.E != z2) {
            this.E = z2;
            g(1, 101, Boolean.valueOf(z2));
            e();
        }
    }

    @Deprecated
    public void setTextOutput(TextOutput textOutput) {
        this.e.clear();
        if (textOutput != null) {
            addTextOutput(textOutput);
        }
    }

    public void setThrowsWhenUsingWrongThread(boolean z2) {
        this.I = z2;
    }

    @Deprecated
    public void setVideoDebugListener(@Nullable VideoRendererEventListener videoRendererEventListener) {
        this.h.retainAll(Collections.singleton(this.j));
        if (videoRendererEventListener != null) {
            addVideoDebugListener(videoRendererEventListener);
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoDecoderOutputBufferRenderer(@Nullable VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        j();
        if (videoDecoderOutputBufferRenderer != null) {
            clearVideoSurface();
        }
        g(2, 8, videoDecoderOutputBufferRenderer);
        this.r = videoDecoderOutputBufferRenderer;
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        j();
        this.G = videoFrameMetadataListener;
        g(2, 6, videoFrameMetadataListener);
    }

    @Deprecated
    public void setVideoListener(@Nullable VideoListener videoListener) {
        this.c.clear();
        if (videoListener != null) {
            addVideoListener(videoListener);
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoScalingMode(int i2) {
        j();
        this.u = i2;
        g(2, 4, Integer.valueOf(i2));
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurface(@Nullable Surface surface) {
        j();
        f();
        if (surface != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        int i2 = 0;
        h(surface, false);
        if (surface != null) {
            i2 = -1;
        }
        c(i2, i2);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        j();
        f();
        if (surfaceHolder != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        this.v = surfaceHolder;
        if (surfaceHolder == null) {
            h(null, false);
            c(0, 0);
            return;
        }
        surfaceHolder.addCallback(this.b);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            h(null, false);
            c(0, 0);
            return;
        }
        h(surface, false);
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        c(surfaceFrame.width(), surfaceFrame.height());
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoTextureView(@Nullable TextureView textureView) {
        j();
        f();
        if (textureView != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        this.w = textureView;
        if (textureView == null) {
            h(null, true);
            c(0, 0);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.b);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            h(null, true);
            c(0, 0);
            return;
        }
        h(new Surface(surfaceTexture), true);
        c(textureView.getWidth(), textureView.getHeight());
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setVolume(float f2) {
        j();
        float constrainValue = Util.constrainValue(f2, 0.0f, 1.0f);
        if (this.D != constrainValue) {
            this.D = constrainValue;
            g(1, 2, Float.valueOf(this.l.g * constrainValue));
            Iterator<AudioListener> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().onVolumeChanged(constrainValue);
            }
        }
    }

    public void setWakeMode(int i2) {
        j();
        if (i2 == 0) {
            this.n.a(false);
            this.o.a(false);
        } else if (i2 == 1) {
            this.n.a(true);
            this.o.a(false);
        } else if (i2 == 2) {
            this.n.a(true);
            this.o.a(true);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean z2) {
        j();
        this.l.e(getPlayWhenReady(), 1);
        this.a.stop(z2);
        this.F = Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAudioAttributes(AudioAttributes audioAttributes, boolean z2) {
        j();
        if (!this.M) {
            if (!Util.areEqual(this.C, audioAttributes)) {
                this.C = audioAttributes;
                g(1, 3, audioAttributes);
                StreamVolumeManager streamVolumeManager = this.m;
                int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(audioAttributes.usage);
                if (streamVolumeManager.f != streamTypeForAudioUsage) {
                    streamVolumeManager.f = streamTypeForAudioUsage;
                    streamVolumeManager.e();
                    streamVolumeManager.c.onStreamTypeChanged(streamTypeForAudioUsage);
                }
                Iterator<AudioListener> it = this.d.iterator();
                while (it.hasNext()) {
                    it.next().onAudioAttributesChanged(audioAttributes);
                }
            }
            AudioFocusManager audioFocusManager = this.l;
            if (!z2) {
                audioAttributes = null;
            }
            audioFocusManager.c(audioAttributes);
            boolean playWhenReady = getPlayWhenReady();
            int e2 = this.l.e(playWhenReady, getPlaybackState());
            i(playWhenReady, e2, b(playWhenReady, e2));
        }
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void addMediaItem(int i2, MediaItem mediaItem) {
        j();
        this.a.addMediaItem(i2, mediaItem);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i2, List<MediaItem> list) {
        j();
        d0 d0Var = this.a;
        d0Var.addMediaSources(i2, d0Var.c(list));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(int i2, List<MediaSource> list) {
        j();
        this.a.addMediaSources(i2, list);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoDecoderOutputBufferRenderer(@Nullable VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        j();
        if (videoDecoderOutputBufferRenderer != null && videoDecoderOutputBufferRenderer == this.r) {
            clearVideoDecoderOutputBufferRenderer();
        }
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem, boolean z2) {
        j();
        this.j.resetForNewPlaylist();
        this.a.setMediaItem(mediaItem, z2);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, boolean z2) {
        j();
        this.j.resetForNewPlaylist();
        this.a.setMediaItems(list, z2);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurface(@Nullable Surface surface) {
        j();
        if (surface != null && surface == this.s) {
            clearVideoSurface();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, boolean z2) {
        j();
        this.j.resetForNewPlaylist();
        this.a.n(list, -1, C.TIME_UNSET, z2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(int i2, MediaSource mediaSource) {
        j();
        d0 d0Var = this.a;
        Objects.requireNonNull(d0Var);
        d0Var.addMediaSources(i2, Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem, long j2) {
        j();
        this.j.resetForNewPlaylist();
        this.a.setMediaItem(mediaItem, j2);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, int i2, long j2) {
        j();
        this.j.resetForNewPlaylist();
        d0 d0Var = this.a;
        d0Var.n(d0Var.c(list), i2, j2, false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource, boolean z2) {
        j();
        this.j.resetForNewPlaylist();
        d0 d0Var = this.a;
        Objects.requireNonNull(d0Var);
        d0Var.n(Collections.singletonList(mediaSource), -1, C.TIME_UNSET, z2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z2, boolean z3) {
        j();
        setMediaSources(Collections.singletonList(mediaSource), z2 ? 0 : -1, C.TIME_UNSET);
        prepare();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, int i2, long j2) {
        j();
        this.j.resetForNewPlaylist();
        this.a.n(list, i2, j2, false);
    }

    public SimpleExoPlayer(Builder builder) {
        AnalyticsCollector analyticsCollector = builder.h;
        this.j = analyticsCollector;
        this.K = builder.j;
        this.C = builder.k;
        this.u = builder.p;
        this.E = builder.o;
        b bVar = new b(null);
        this.b = bVar;
        CopyOnWriteArraySet<com.google.android.exoplayer2.video.VideoListener> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        this.c = copyOnWriteArraySet;
        CopyOnWriteArraySet<AudioListener> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
        this.d = copyOnWriteArraySet2;
        this.e = new CopyOnWriteArraySet<>();
        this.f = new CopyOnWriteArraySet<>();
        this.g = new CopyOnWriteArraySet<>();
        CopyOnWriteArraySet<VideoRendererEventListener> copyOnWriteArraySet3 = new CopyOnWriteArraySet<>();
        this.h = copyOnWriteArraySet3;
        CopyOnWriteArraySet<AudioRendererEventListener> copyOnWriteArraySet4 = new CopyOnWriteArraySet<>();
        this.i = copyOnWriteArraySet4;
        Handler handler = new Handler(builder.i);
        Renderer[] createRenderers = builder.b.createRenderers(handler, bVar, bVar, bVar, bVar);
        this.renderers = createRenderers;
        this.D = 1.0f;
        this.B = 0;
        this.F = Collections.emptyList();
        d0 d0Var = new d0(createRenderers, builder.d, builder.e, builder.f, builder.g, analyticsCollector, builder.q, builder.r, builder.s, builder.c, builder.i);
        this.a = d0Var;
        d0Var.addListener(bVar);
        copyOnWriteArraySet3.add(analyticsCollector);
        copyOnWriteArraySet.add(analyticsCollector);
        copyOnWriteArraySet4.add(analyticsCollector);
        copyOnWriteArraySet2.add(analyticsCollector);
        addMetadataOutput(analyticsCollector);
        AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(builder.a, handler, bVar);
        this.k = audioBecomingNoisyManager;
        audioBecomingNoisyManager.a(builder.n);
        AudioFocusManager audioFocusManager = new AudioFocusManager(builder.a, handler, bVar);
        this.l = audioFocusManager;
        audioFocusManager.c(builder.l ? this.C : null);
        StreamVolumeManager streamVolumeManager = new StreamVolumeManager(builder.a, handler, bVar);
        this.m = streamVolumeManager;
        int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(this.C.usage);
        if (streamVolumeManager.f != streamTypeForAudioUsage) {
            streamVolumeManager.f = streamTypeForAudioUsage;
            streamVolumeManager.e();
            streamVolumeManager.c.onStreamTypeChanged(streamTypeForAudioUsage);
        }
        o0 o0Var = new o0(builder.a);
        this.n = o0Var;
        o0Var.a(builder.m != 0);
        p0 p0Var = new p0(builder.a);
        this.o = p0Var;
        p0Var.a(builder.m == 2);
        this.N = new DeviceInfo(0, streamVolumeManager.b(), streamVolumeManager.a());
        if (!builder.t) {
            d0Var.f.M = false;
        }
        g(1, 3, this.C);
        g(2, 4, Integer.valueOf(this.u));
        g(1, 101, Boolean.valueOf(this.E));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource, long j2) {
        j();
        this.j.resetForNewPlaylist();
        d0 d0Var = this.a;
        Objects.requireNonNull(d0Var);
        d0Var.setMediaSources(Collections.singletonList(mediaSource), 0, j2);
    }
}
