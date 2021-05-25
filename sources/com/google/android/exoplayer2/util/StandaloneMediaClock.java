package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackParameters;
public final class StandaloneMediaClock implements MediaClock {
    public final Clock a;
    public boolean b;
    public long c;
    public long d;
    public PlaybackParameters e = PlaybackParameters.DEFAULT;

    public StandaloneMediaClock(Clock clock) {
        this.a = clock;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        long j;
        long j2 = this.c;
        if (!this.b) {
            return j2;
        }
        long elapsedRealtime = this.a.elapsedRealtime() - this.d;
        PlaybackParameters playbackParameters = this.e;
        if (playbackParameters.speed == 1.0f) {
            j = C.msToUs(elapsedRealtime);
        } else {
            j = playbackParameters.getMediaTimeUsForPlayoutTimeMs(elapsedRealtime);
        }
        return j2 + j;
    }

    public void resetPosition(long j) {
        this.c = j;
        if (this.b) {
            this.d = this.a.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (this.b) {
            resetPosition(getPositionUs());
        }
        this.e = playbackParameters;
    }

    public void start() {
        if (!this.b) {
            this.d = this.a.elapsedRealtime();
            this.b = true;
        }
    }

    public void stop() {
        if (this.b) {
            resetPosition(getPositionUs());
            this.b = false;
        }
    }
}
