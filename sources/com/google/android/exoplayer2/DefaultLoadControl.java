package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
public class DefaultLoadControl implements LoadControl {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_METADATA_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MIN_BUFFER_MS = 50000;
    public static final int DEFAULT_MIN_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_MUXED_BUFFER_SIZE = 144310272;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = false;
    public static final boolean DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME = false;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    public static final int DEFAULT_TEXT_BUFFER_SIZE = 131072;
    public static final int DEFAULT_VIDEO_BUFFER_SIZE = 131072000;
    public final DefaultAllocator a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public int j;
    public boolean k;

    public static final class Builder {
        @Nullable
        public DefaultAllocator a;
        public int b = 50000;
        public int c = 50000;
        public int d = 2500;
        public int e = 5000;
        public int f = -1;
        public boolean g = false;
        public int h = 0;
        public boolean i = false;
        public boolean j;

        public DefaultLoadControl build() {
            Assertions.checkState(!this.j);
            this.j = true;
            if (this.a == null) {
                this.a = new DefaultAllocator(true, 65536);
            }
            return new DefaultLoadControl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }

        @Deprecated
        public DefaultLoadControl createDefaultLoadControl() {
            return build();
        }

        public Builder setAllocator(DefaultAllocator defaultAllocator) {
            Assertions.checkState(!this.j);
            this.a = defaultAllocator;
            return this;
        }

        public Builder setBackBuffer(int i2, boolean z) {
            Assertions.checkState(!this.j);
            DefaultLoadControl.a(i2, 0, "backBufferDurationMs", "0");
            this.h = i2;
            this.i = z;
            return this;
        }

        public Builder setBufferDurationsMs(int i2, int i3, int i4, int i5) {
            Assertions.checkState(!this.j);
            DefaultLoadControl.a(i4, 0, "bufferForPlaybackMs", "0");
            DefaultLoadControl.a(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
            DefaultLoadControl.a(i2, i4, "minBufferMs", "bufferForPlaybackMs");
            DefaultLoadControl.a(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            DefaultLoadControl.a(i3, i2, "maxBufferMs", "minBufferMs");
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            return this;
        }

        public Builder setPrioritizeTimeOverSizeThresholds(boolean z) {
            Assertions.checkState(!this.j);
            this.g = z;
            return this;
        }

        public Builder setTargetBufferBytes(int i2) {
            Assertions.checkState(!this.j);
            this.f = i2;
            return this;
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536));
    }

    public static void a(int i2, int i3, String str, String str2) {
        boolean z = i2 >= i3;
        Assertions.checkArgument(z, str + " cannot be less than " + str2);
    }

    public final void b(boolean z) {
        int i2 = this.f;
        if (i2 == -1) {
            i2 = 13107200;
        }
        this.j = i2;
        this.k = false;
        if (z) {
            this.a.reset();
        }
    }

    public int calculateTargetBufferBytes(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = 13107200;
            if (i2 >= rendererArr.length) {
                return Math.max(13107200, i3);
            }
            if (trackSelectionArray.get(i2) != null) {
                switch (rendererArr[i2].getTrackType()) {
                    case 0:
                        i4 = DEFAULT_MUXED_BUFFER_SIZE;
                        break;
                    case 1:
                        break;
                    case 2:
                        i4 = DEFAULT_VIDEO_BUFFER_SIZE;
                        break;
                    case 3:
                    case 4:
                    case 5:
                        i4 = 131072;
                        break;
                    case 6:
                        i4 = 0;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                i3 += i4;
            }
            i2++;
        }
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public Allocator getAllocator() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        b(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        b(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        b(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        int i2 = this.f;
        if (i2 == -1) {
            i2 = calculateTargetBufferBytes(rendererArr, trackSelectionArray);
        }
        this.j = i2;
        this.a.setTargetBufferSize(i2);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long j2, long j3, float f2) {
        boolean z = true;
        boolean z2 = this.a.getTotalBytesAllocated() >= this.j;
        long j4 = this.b;
        if (f2 > 1.0f) {
            j4 = Math.min(Util.getMediaDurationForPlayoutDuration(j4, f2), this.c);
        }
        if (j3 < Math.max(j4, 500000L)) {
            if (!this.g && z2) {
                z = false;
            }
            this.k = z;
            if (!z && j3 < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= this.c || z2) {
            this.k = false;
        }
        return this.k;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j2, float f2, boolean z) {
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(j2, f2);
        long j3 = z ? this.e : this.d;
        return j3 <= 0 || playoutDurationForMediaDuration >= j3 || (!this.g && this.a.getTotalBytesAllocated() >= this.j);
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i2, int i3, int i4, int i5, int i6, boolean z) {
        this(defaultAllocator, i2, i3, i4, i5, i6, z, 0, false);
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, boolean z2) {
        a(i4, 0, "bufferForPlaybackMs", "0");
        a(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(i2, i4, "minBufferMs", "bufferForPlaybackMs");
        a(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(i3, i2, "maxBufferMs", "minBufferMs");
        a(i7, 0, "backBufferDurationMs", "0");
        this.a = defaultAllocator;
        this.b = C.msToUs((long) i2);
        this.c = C.msToUs((long) i3);
        this.d = C.msToUs((long) i4);
        this.e = C.msToUs((long) i5);
        this.f = i6;
        this.j = i6 == -1 ? 13107200 : i6;
        this.g = z;
        this.h = C.msToUs((long) i7);
        this.i = z2;
    }
}
