package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    public final int a;
    public final float pitch;
    public final float speed;

    public PlaybackParameters(float f) {
        this(f, 1.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        if (this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch) {
            return true;
        }
        return false;
    }

    public long getMediaTimeUsForPlayoutTimeMs(long j) {
        return j * ((long) this.a);
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.pitch) + ((Float.floatToRawIntBits(this.speed) + 527) * 31);
    }

    public String toString() {
        return Util.formatInvariant("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.speed), Float.valueOf(this.pitch));
    }

    public PlaybackParameters(float f, float f2) {
        boolean z = true;
        Assertions.checkArgument(f > 0.0f);
        Assertions.checkArgument(f2 <= 0.0f ? false : z);
        this.speed = f;
        this.pitch = f2;
        this.a = Math.round(f * 1000.0f);
    }
}
