package com.google.android.exoplayer2;

import a2.j.b.b.d0;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
public interface ExoPlayer extends Player {
    void addMediaSource(int i, MediaSource mediaSource);

    void addMediaSource(MediaSource mediaSource);

    void addMediaSources(int i, List<MediaSource> list);

    void addMediaSources(List<MediaSource> list);

    PlayerMessage createMessage(PlayerMessage.Target target);

    void experimentalSetOffloadSchedulingEnabled(boolean z);

    boolean getPauseAtEndOfMediaItems();

    Looper getPlaybackLooper();

    SeekParameters getSeekParameters();

    @Deprecated
    void prepare(MediaSource mediaSource);

    @Deprecated
    void prepare(MediaSource mediaSource, boolean z, boolean z2);

    @Deprecated
    void retry();

    void setForegroundMode(boolean z);

    void setMediaSource(MediaSource mediaSource);

    void setMediaSource(MediaSource mediaSource, long j);

    void setMediaSource(MediaSource mediaSource, boolean z);

    void setMediaSources(List<MediaSource> list);

    void setMediaSources(List<MediaSource> list, int i, long j);

    void setMediaSources(List<MediaSource> list, boolean z);

    void setPauseAtEndOfMediaItems(boolean z);

    void setSeekParameters(@Nullable SeekParameters seekParameters);

    void setShuffleOrder(ShuffleOrder shuffleOrder);

    public static final class Builder {
        public final Renderer[] a;
        public Clock b;
        public TrackSelector c;
        public MediaSourceFactory d;
        public LoadControl e;
        public BandwidthMeter f;
        public Looper g;
        @Nullable
        public AnalyticsCollector h;
        public boolean i;
        public SeekParameters j;
        public boolean k;
        public boolean l;
        public long m;
        public boolean n;

        public Builder(Context context, Renderer... rendererArr) {
            this(rendererArr, new DefaultTrackSelector(context), new DefaultMediaSourceFactory(context), new DefaultLoadControl(), DefaultBandwidthMeter.getSingletonInstance(context));
        }

        public ExoPlayer build() {
            Assertions.checkState(!this.l);
            this.l = true;
            d0 d0Var = new d0(this.a, this.c, this.d, this.e, this.f, this.h, this.i, this.j, this.k, this.b, this.g);
            long j2 = this.m;
            if (j2 > 0) {
                d0Var.f.L = j2;
            }
            if (!this.n) {
                d0Var.f.M = false;
            }
            return d0Var;
        }

        public Builder experimentalSetReleaseTimeoutMs(long j2) {
            this.m = j2;
            return this;
        }

        public Builder experimentalSetThrowWhenStuckBuffering(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
            Assertions.checkState(!this.l);
            this.h = analyticsCollector;
            return this;
        }

        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            Assertions.checkState(!this.l);
            this.f = bandwidthMeter;
            return this;
        }

        @VisibleForTesting
        public Builder setClock(Clock clock) {
            Assertions.checkState(!this.l);
            this.b = clock;
            return this;
        }

        public Builder setLoadControl(LoadControl loadControl) {
            Assertions.checkState(!this.l);
            this.e = loadControl;
            return this;
        }

        public Builder setLooper(Looper looper) {
            Assertions.checkState(!this.l);
            this.g = looper;
            return this;
        }

        public Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory) {
            Assertions.checkState(!this.l);
            this.d = mediaSourceFactory;
            return this;
        }

        public Builder setPauseAtEndOfMediaItems(boolean z) {
            Assertions.checkState(!this.l);
            this.k = z;
            return this;
        }

        public Builder setSeekParameters(SeekParameters seekParameters) {
            Assertions.checkState(!this.l);
            this.j = seekParameters;
            return this;
        }

        public Builder setTrackSelector(TrackSelector trackSelector) {
            Assertions.checkState(!this.l);
            this.c = trackSelector;
            return this;
        }

        public Builder setUseLazyPreparation(boolean z) {
            Assertions.checkState(!this.l);
            this.i = z;
            return this;
        }

        public Builder(Renderer[] rendererArr, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter) {
            Assertions.checkArgument(rendererArr.length > 0);
            this.a = rendererArr;
            this.c = trackSelector;
            this.d = mediaSourceFactory;
            this.e = loadControl;
            this.f = bandwidthMeter;
            this.g = Util.getCurrentOrMainLooper();
            this.i = true;
            this.j = SeekParameters.DEFAULT;
            this.b = Clock.DEFAULT;
            this.n = true;
        }
    }
}
