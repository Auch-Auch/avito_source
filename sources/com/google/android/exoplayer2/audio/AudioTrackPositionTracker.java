package com.google.android.exoplayer2.audio;

import a2.j.b.b.r0.m;
import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Method;
import org.spongycastle.asn1.cmc.BodyPartID;
public final class AudioTrackPositionTracker {
    public long A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public long F;
    public final Listener a;
    public final long[] b;
    @Nullable
    public AudioTrack c;
    public int d;
    public int e;
    @Nullable
    public m f;
    public int g;
    public boolean h;
    public long i;
    public float j;
    public boolean k;
    public long l;
    public long m;
    @Nullable
    public Method n;
    public long o;
    public boolean p;
    public boolean q;
    public long r;
    public long s;
    public long t;
    public long u;
    public int v;
    public int w;
    public long x;
    public long y;
    public long z;

    public interface Listener {
        void onInvalidLatency(long j);

        void onPositionAdvancing(long j);

        void onPositionFramesMismatch(long j, long j2, long j3, long j4);

        void onSystemTimeUsMismatch(long j, long j2, long j3, long j4);

        void onUnderrun(int i, long j);
    }

    public AudioTrackPositionTracker(Listener listener) {
        this.a = (Listener) Assertions.checkNotNull(listener);
        if (Util.SDK_INT >= 18) {
            try {
                this.n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.b = new long[10];
    }

    public final long a(long j2) {
        return (j2 * 1000000) / ((long) this.g);
    }

    public final long b() {
        AudioTrack audioTrack = (AudioTrack) Assertions.checkNotNull(this.c);
        if (this.x != C.TIME_UNSET) {
            return Math.min(this.A, this.z + ((((SystemClock.elapsedRealtime() * 1000) - this.x) * ((long) this.g)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = BodyPartID.bodyIdMax & ((long) audioTrack.getPlaybackHeadPosition());
        if (this.h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.u = this.s;
            }
            playbackHeadPosition += this.u;
        }
        if (Util.SDK_INT <= 29) {
            if (playbackHeadPosition == 0 && this.s > 0 && playState == 3) {
                if (this.y == C.TIME_UNSET) {
                    this.y = SystemClock.elapsedRealtime();
                }
                return this.s;
            }
            this.y = C.TIME_UNSET;
        }
        if (this.s > playbackHeadPosition) {
            this.t++;
        }
        this.s = playbackHeadPosition;
        return playbackHeadPosition + (this.t << 32);
    }

    public boolean c(long j2) {
        if (j2 <= b()) {
            if (!(this.h && ((AudioTrack) Assertions.checkNotNull(this.c)).getPlayState() == 2 && b() == 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean d() {
        return ((AudioTrack) Assertions.checkNotNull(this.c)).getPlayState() == 3;
    }

    public void e() {
        this.l = 0;
        this.w = 0;
        this.v = 0;
        this.m = 0;
        this.C = 0;
        this.F = 0;
        this.k = false;
        this.c = null;
        this.f = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if ((com.google.android.exoplayer2.util.Util.SDK_INT < 23 && (r5 == 5 || r5 == 6)) != false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.c = r3
            r2.d = r6
            r2.e = r7
            a2.j.b.b.r0.m r0 = new a2.j.b.b.r0.m
            r0.<init>(r3)
            r2.f = r0
            int r3 = r3.getSampleRate()
            r2.g = r3
            r3 = 1
            r0 = 0
            if (r4 == 0) goto L_0x0029
            int r4 = com.google.android.exoplayer2.util.Util.SDK_INT
            r1 = 23
            if (r4 >= r1) goto L_0x0025
            r4 = 5
            if (r5 == r4) goto L_0x0023
            r4 = 6
            if (r5 != r4) goto L_0x0025
        L_0x0023:
            r4 = 1
            goto L_0x0026
        L_0x0025:
            r4 = 0
        L_0x0026:
            if (r4 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            r2.h = r3
            boolean r3 = com.google.android.exoplayer2.util.Util.isEncodingLinearPcm(r5)
            r2.q = r3
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 == 0) goto L_0x0040
            int r7 = r7 / r6
            long r6 = (long) r7
            long r6 = r2.a(r6)
            goto L_0x0041
        L_0x0040:
            r6 = r4
        L_0x0041:
            r2.i = r6
            r6 = 0
            r2.s = r6
            r2.t = r6
            r2.u = r6
            r2.p = r0
            r2.x = r4
            r2.y = r4
            r2.r = r6
            r2.o = r6
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.j = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioTrackPositionTracker.f(android.media.AudioTrack, boolean, int, int, int):void");
    }
}
