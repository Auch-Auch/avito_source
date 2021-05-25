package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;
public final class DefaultMediaClock implements MediaClock {
    public final StandaloneMediaClock a;
    public final PlaybackParametersListener b;
    @Nullable
    public Renderer c;
    @Nullable
    public MediaClock d;
    public boolean e = true;
    public boolean f;

    public interface PlaybackParametersListener {
        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);
    }

    public DefaultMediaClock(PlaybackParametersListener playbackParametersListener, Clock clock) {
        this.b = playbackParametersListener;
        this.a = new StandaloneMediaClock(clock);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        MediaClock mediaClock = this.d;
        if (mediaClock != null) {
            return mediaClock.getPlaybackParameters();
        }
        return this.a.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (this.e) {
            return this.a.getPositionUs();
        }
        return ((MediaClock) Assertions.checkNotNull(this.d)).getPositionUs();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.d;
        if (mediaClock != null) {
            mediaClock.setPlaybackParameters(playbackParameters);
            playbackParameters = this.d.getPlaybackParameters();
        }
        this.a.setPlaybackParameters(playbackParameters);
    }
}
