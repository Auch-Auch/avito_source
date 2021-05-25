package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;
public class DefaultControlDispatcher implements ControlDispatcher {
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REWIND_MS = 5000;
    public final Timeline.Window a;
    public long b;
    public long c;

    public DefaultControlDispatcher() {
        this(15000, 5000);
    }

    public static void a(Player player, long j) {
        long currentPosition = player.getCurrentPosition() + j;
        long duration = player.getDuration();
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        player.seekTo(player.getCurrentWindowIndex(), Math.max(currentPosition, 0L));
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchFastForward(Player player) {
        if (!isFastForwardEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        a(player, this.c);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchNext(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            int nextWindowIndex = player.getNextWindowIndex();
            if (nextWindowIndex != -1) {
                player.seekTo(nextWindowIndex, C.TIME_UNSET);
            } else if (currentTimeline.getWindow(currentWindowIndex, this.a).isLive) {
                player.seekTo(currentWindowIndex, C.TIME_UNSET);
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchPrepare(Player player) {
        player.prepare();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r3.isSeekable == false) goto L_0x0036;
     */
    @Override // com.google.android.exoplayer2.ControlDispatcher
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchPrevious(com.google.android.exoplayer2.Player r9) {
        /*
            r8 = this;
            com.google.android.exoplayer2.Timeline r0 = r9.getCurrentTimeline()
            boolean r1 = r0.isEmpty()
            r2 = 1
            if (r1 != 0) goto L_0x0044
            boolean r1 = r9.isPlayingAd()
            if (r1 == 0) goto L_0x0012
            goto L_0x0044
        L_0x0012:
            int r1 = r9.getCurrentWindowIndex()
            com.google.android.exoplayer2.Timeline$Window r3 = r8.a
            r0.getWindow(r1, r3)
            int r0 = r9.getPreviousWindowIndex()
            r3 = -1
            if (r0 == r3) goto L_0x003f
            long r3 = r9.getCurrentPosition()
            r5 = 3000(0xbb8, double:1.482E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0036
            com.google.android.exoplayer2.Timeline$Window r3 = r8.a
            boolean r4 = r3.isDynamic
            if (r4 == 0) goto L_0x003f
            boolean r3 = r3.isSeekable
            if (r3 != 0) goto L_0x003f
        L_0x0036:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9.seekTo(r0, r3)
            goto L_0x0044
        L_0x003f:
            r3 = 0
            r9.seekTo(r1, r3)
        L_0x0044:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultControlDispatcher.dispatchPrevious(com.google.android.exoplayer2.Player):boolean");
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchRewind(Player player) {
        if (!isRewindEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        a(player, -this.b);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSeekTo(Player player, int i, long j) {
        player.seekTo(i, j);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetPlayWhenReady(Player player, boolean z) {
        player.setPlayWhenReady(z);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetRepeatMode(Player player, int i) {
        player.setRepeatMode(i);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetShuffleModeEnabled(Player player, boolean z) {
        player.setShuffleModeEnabled(z);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchStop(Player player, boolean z) {
        player.stop(z);
        return true;
    }

    public long getFastForwardIncrementMs() {
        return this.c;
    }

    public long getRewindIncrementMs() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean isFastForwardEnabled() {
        return this.c > 0;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean isRewindEnabled() {
        return this.b > 0;
    }

    @Deprecated
    public void setFastForwardIncrementMs(long j) {
        this.c = j;
    }

    @Deprecated
    public void setRewindIncrementMs(long j) {
        this.b = j;
    }

    public DefaultControlDispatcher(long j, long j2) {
        this.c = j;
        this.b = j2;
        this.a = new Timeline.Window();
    }
}
