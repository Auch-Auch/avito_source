package com.google.android.exoplayer2.ui;

import a2.j.b.b.k0;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
public class PlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    public final Drawable A;
    public final Drawable B;
    public final float C;
    public final float D;
    public final String E;
    public final String F;
    @Nullable
    public Player G;
    public ControlDispatcher H;
    @Nullable
    public ProgressUpdateListener I;
    @Nullable
    public PlaybackPreparer J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public long W;
    public final b a;
    public long[] a0;
    public final CopyOnWriteArrayList<VisibilityListener> b;
    public boolean[] b0;
    @Nullable
    public final View c;
    public long[] c0;
    @Nullable
    public final View d;
    public boolean[] d0;
    @Nullable
    public final View e;
    public long e0;
    @Nullable
    public final View f;
    @Nullable
    public final View g;
    @Nullable
    public final View h;
    @Nullable
    public final ImageView i;
    @Nullable
    public final ImageView j;
    @Nullable
    public final View k;
    @Nullable
    public final TextView l;
    @Nullable
    public final TextView m;
    @Nullable
    public final TimeBar n;
    public final StringBuilder o;
    public final Formatter p;
    public final Timeline.Period q;
    public final Timeline.Window r;
    public final Runnable s;
    public final Runnable t;
    public final Drawable u;
    public final Drawable v;
    public final Drawable w;
    public final String x;
    public final String y;
    public final String z;

    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    public final class b implements Player.EventListener, TimeBar.OnScrubListener, View.OnClickListener {
        public b(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerControlView playerControlView = PlayerControlView.this;
            Player player = playerControlView.G;
            if (player != null) {
                if (playerControlView.d == view) {
                    playerControlView.H.dispatchNext(player);
                } else if (playerControlView.c == view) {
                    playerControlView.H.dispatchPrevious(player);
                } else if (playerControlView.g == view) {
                    if (player.getPlaybackState() != 4) {
                        PlayerControlView.this.H.dispatchFastForward(player);
                    }
                } else if (playerControlView.h == view) {
                    playerControlView.H.dispatchRewind(player);
                } else if (playerControlView.e == view) {
                    playerControlView.a(player);
                } else if (playerControlView.f == view) {
                    playerControlView.H.dispatchSetPlayWhenReady(player, false);
                } else if (playerControlView.i == view) {
                    playerControlView.H.dispatchSetRepeatMode(player, RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), PlayerControlView.this.Q));
                } else if (playerControlView.j == view) {
                    playerControlView.H.dispatchSetShuffleModeEnabled(player, !player.getShuffleModeEnabled());
                }
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
            k0.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            k0.$default$onIsLoadingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onIsPlayingChanged(boolean z) {
            PlayerControlView playerControlView = PlayerControlView.this;
            int i = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.i();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onLoadingChanged(boolean z) {
            k0.$default$onLoadingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            k0.$default$onMediaItemTransition(this, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            PlayerControlView playerControlView = PlayerControlView.this;
            int i2 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.h();
            PlayerControlView.this.i();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            k0.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            PlayerControlView playerControlView = PlayerControlView.this;
            int i2 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.h();
            PlayerControlView.this.i();
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
        public void onPositionDiscontinuity(int i) {
            PlayerControlView playerControlView = PlayerControlView.this;
            int i2 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.g();
            PlayerControlView.this.l();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
            PlayerControlView playerControlView = PlayerControlView.this;
            int i2 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.j();
            PlayerControlView.this.g();
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubMove(TimeBar timeBar, long j) {
            PlayerControlView playerControlView = PlayerControlView.this;
            TextView textView = playerControlView.m;
            if (textView != null) {
                textView.setText(Util.getStringForTime(playerControlView.o, playerControlView.p, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStart(TimeBar timeBar, long j) {
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.N = true;
            TextView textView = playerControlView.m;
            if (textView != null) {
                textView.setText(Util.getStringForTime(playerControlView.o, playerControlView.p, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStop(TimeBar timeBar, long j, boolean z) {
            Player player;
            PlayerControlView playerControlView = PlayerControlView.this;
            int i = 0;
            playerControlView.N = false;
            if (!z && (player = playerControlView.G) != null) {
                Timeline currentTimeline = player.getCurrentTimeline();
                if (playerControlView.M && !currentTimeline.isEmpty()) {
                    int windowCount = currentTimeline.getWindowCount();
                    while (true) {
                        long durationMs = currentTimeline.getWindow(i, playerControlView.r).getDurationMs();
                        if (j < durationMs) {
                            break;
                        } else if (i == windowCount - 1) {
                            j = durationMs;
                            break;
                        } else {
                            j -= durationMs;
                            i++;
                        }
                    }
                } else {
                    i = player.getCurrentWindowIndex();
                }
                if (!playerControlView.H.dispatchSeekTo(player, i, j)) {
                    playerControlView.i();
                }
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            k0.$default$onSeekProcessed(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            PlayerControlView playerControlView = PlayerControlView.this;
            int i = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.k();
            PlayerControlView.this.g();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, int i) {
            PlayerControlView playerControlView = PlayerControlView.this;
            int i2 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.g();
            PlayerControlView.this.l();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
            k0.$default$onTimelineChanged(this, timeline, obj, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            k0.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    public final void a(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            PlaybackPreparer playbackPreparer = this.J;
            if (playbackPreparer != null) {
                playbackPreparer.preparePlayback();
            } else {
                this.H.dispatchPrepare(player);
            }
        } else if (playbackState == 4) {
            this.H.dispatchSeekTo(player, player.getCurrentWindowIndex(), C.TIME_UNSET);
        }
        this.H.dispatchSetPlayWhenReady(player, true);
    }

    public void addVisibilityListener(VisibilityListener visibilityListener) {
        Assertions.checkNotNull(visibilityListener);
        this.b.add(visibilityListener);
    }

    public final void b() {
        removeCallbacks(this.t);
        if (this.O > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = this.O;
            this.W = uptimeMillis + ((long) i2);
            if (this.K) {
                postDelayed(this.t, (long) i2);
                return;
            }
            return;
        }
        this.W = C.TIME_UNSET;
    }

    public final void c() {
        View view;
        View view2;
        boolean d2 = d();
        if (!d2 && (view2 = this.e) != null) {
            view2.requestFocus();
        } else if (d2 && (view = this.f) != null) {
            view.requestFocus();
        }
    }

    public final boolean d() {
        Player player = this.G;
        if (player == null || player.getPlaybackState() == 4 || this.G.getPlaybackState() == 1 || !this.G.getPlayWhenReady()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View, android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.G;
        if (player != null) {
            if (keyCode == 90 || keyCode == 89 || keyCode == 85 || keyCode == 79 || keyCode == 126 || keyCode == 127 || keyCode == 87 || keyCode == 88) {
                if (keyEvent.getAction() == 0) {
                    if (keyCode == 90) {
                        if (player.getPlaybackState() != 4) {
                            this.H.dispatchFastForward(player);
                        }
                    } else if (keyCode == 89) {
                        this.H.dispatchRewind(player);
                    } else if (keyEvent.getRepeatCount() == 0) {
                        if (keyCode == 79 || keyCode == 85) {
                            int playbackState = player.getPlaybackState();
                            if (playbackState == 1 || playbackState == 4 || !player.getPlayWhenReady()) {
                                a(player);
                            } else {
                                this.H.dispatchSetPlayWhenReady(player, false);
                            }
                        } else if (keyCode == 87) {
                            this.H.dispatchNext(player);
                        } else if (keyCode == 88) {
                            this.H.dispatchPrevious(player);
                        } else if (keyCode == 126) {
                            a(player);
                        } else if (keyCode == 127) {
                            this.H.dispatchSetPlayWhenReady(player, false);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View, android.view.ViewGroup
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.t);
        } else if (motionEvent.getAction() == 1) {
            b();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e() {
        h();
        g();
        j();
        k();
        l();
    }

    public final void f(boolean z2, boolean z3, @Nullable View view) {
        if (view != null) {
            view.setEnabled(z3);
            view.setAlpha(z3 ? this.C : this.D);
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r8 = this;
            boolean r0 = r8.isVisible()
            if (r0 == 0) goto L_0x0090
            boolean r0 = r8.K
            if (r0 != 0) goto L_0x000c
            goto L_0x0090
        L_0x000c:
            com.google.android.exoplayer2.Player r0 = r8.G
            r1 = 0
            if (r0 == 0) goto L_0x0069
            com.google.android.exoplayer2.Timeline r2 = r0.getCurrentTimeline()
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0069
            boolean r3 = r0.isPlayingAd()
            if (r3 != 0) goto L_0x0069
            int r3 = r0.getCurrentWindowIndex()
            com.google.android.exoplayer2.Timeline$Window r4 = r8.r
            r2.getWindow(r3, r4)
            com.google.android.exoplayer2.Timeline$Window r2 = r8.r
            boolean r3 = r2.isSeekable
            r4 = 1
            if (r3 != 0) goto L_0x003e
            boolean r2 = r2.isDynamic
            if (r2 == 0) goto L_0x003e
            boolean r2 = r0.hasPrevious()
            if (r2 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r2 = 0
            goto L_0x003f
        L_0x003e:
            r2 = 1
        L_0x003f:
            if (r3 == 0) goto L_0x004b
            com.google.android.exoplayer2.ControlDispatcher r5 = r8.H
            boolean r5 = r5.isRewindEnabled()
            if (r5 == 0) goto L_0x004b
            r5 = 1
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            if (r3 == 0) goto L_0x0058
            com.google.android.exoplayer2.ControlDispatcher r6 = r8.H
            boolean r6 = r6.isFastForwardEnabled()
            if (r6 == 0) goto L_0x0058
            r6 = 1
            goto L_0x0059
        L_0x0058:
            r6 = 0
        L_0x0059:
            com.google.android.exoplayer2.Timeline$Window r7 = r8.r
            boolean r7 = r7.isDynamic
            if (r7 != 0) goto L_0x0065
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0066
        L_0x0065:
            r1 = 1
        L_0x0066:
            r0 = r1
            r1 = r2
            goto L_0x006d
        L_0x0069:
            r0 = 0
            r3 = 0
            r5 = 0
            r6 = 0
        L_0x006d:
            boolean r2 = r8.T
            android.view.View r4 = r8.c
            r8.f(r2, r1, r4)
            boolean r1 = r8.R
            android.view.View r2 = r8.h
            r8.f(r1, r5, r2)
            boolean r1 = r8.S
            android.view.View r2 = r8.g
            r8.f(r1, r6, r2)
            boolean r1 = r8.U
            android.view.View r2 = r8.d
            r8.f(r1, r0, r2)
            com.google.android.exoplayer2.ui.TimeBar r0 = r8.n
            if (r0 == 0) goto L_0x0090
            r0.setEnabled(r3)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.g():void");
    }

    @Nullable
    public Player getPlayer() {
        return this.G;
    }

    public int getRepeatToggleModes() {
        return this.Q;
    }

    public boolean getShowShuffleButton() {
        return this.V;
    }

    public int getShowTimeoutMs() {
        return this.O;
    }

    public boolean getShowVrButton() {
        View view = this.k;
        return view != null && view.getVisibility() == 0;
    }

    public final void h() {
        boolean z2;
        if (isVisible() && this.K) {
            boolean d2 = d();
            View view = this.e;
            int i2 = 8;
            boolean z3 = true;
            if (view != null) {
                z2 = (d2 && view.isFocused()) | false;
                this.e.setVisibility(d2 ? 8 : 0);
            } else {
                z2 = false;
            }
            View view2 = this.f;
            if (view2 != null) {
                if (d2 || !view2.isFocused()) {
                    z3 = false;
                }
                z2 |= z3;
                View view3 = this.f;
                if (d2) {
                    i2 = 0;
                }
                view3.setVisibility(i2);
            }
            if (z2) {
                c();
            }
        }
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            Iterator<VisibilityListener> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.s);
            removeCallbacks(this.t);
            this.W = C.TIME_UNSET;
        }
    }

    public final void i() {
        long j2;
        int i2;
        if (isVisible() && this.K) {
            Player player = this.G;
            long j3 = 0;
            if (player != null) {
                j3 = this.e0 + player.getContentPosition();
                j2 = this.e0 + player.getContentBufferedPosition();
            } else {
                j2 = 0;
            }
            TextView textView = this.m;
            if (textView != null && !this.N) {
                textView.setText(Util.getStringForTime(this.o, this.p, j3));
            }
            TimeBar timeBar = this.n;
            if (timeBar != null) {
                timeBar.setPosition(j3);
                this.n.setBufferedPosition(j2);
            }
            ProgressUpdateListener progressUpdateListener = this.I;
            if (progressUpdateListener != null) {
                progressUpdateListener.onProgressUpdate(j3, j2);
            }
            removeCallbacks(this.s);
            if (player == null) {
                i2 = 1;
            } else {
                i2 = player.getPlaybackState();
            }
            long j4 = 1000;
            if (player != null && player.isPlaying()) {
                TimeBar timeBar2 = this.n;
                long min = Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000, 1000 - (j3 % 1000));
                float f2 = player.getPlaybackParameters().speed;
                if (f2 > 0.0f) {
                    j4 = (long) (((float) min) / f2);
                }
                postDelayed(this.s, Util.constrainValue(j4, (long) this.P, 1000));
            } else if (i2 != 4 && i2 != 1) {
                postDelayed(this.s, 1000);
            }
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public final void j() {
        ImageView imageView;
        if (isVisible() && this.K && (imageView = this.i) != null) {
            if (this.Q == 0) {
                f(false, false, imageView);
                return;
            }
            Player player = this.G;
            if (player == null) {
                f(true, false, imageView);
                this.i.setImageDrawable(this.u);
                this.i.setContentDescription(this.x);
                return;
            }
            f(true, true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.i.setImageDrawable(this.u);
                this.i.setContentDescription(this.x);
            } else if (repeatMode == 1) {
                this.i.setImageDrawable(this.v);
                this.i.setContentDescription(this.y);
            } else if (repeatMode == 2) {
                this.i.setImageDrawable(this.w);
                this.i.setContentDescription(this.z);
            }
            this.i.setVisibility(0);
        }
    }

    public final void k() {
        ImageView imageView;
        String str;
        if (isVisible() && this.K && (imageView = this.j) != null) {
            Player player = this.G;
            if (!this.V) {
                f(false, false, imageView);
            } else if (player == null) {
                f(true, false, imageView);
                this.j.setImageDrawable(this.B);
                this.j.setContentDescription(this.F);
            } else {
                f(true, true, imageView);
                this.j.setImageDrawable(player.getShuffleModeEnabled() ? this.A : this.B);
                ImageView imageView2 = this.j;
                if (player.getShuffleModeEnabled()) {
                    str = this.E;
                } else {
                    str = this.F;
                }
                imageView2.setContentDescription(str);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l() {
        /*
        // Method dump skipped, instructions count: 356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.l():void");
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.K = true;
        long j2 = this.W;
        if (j2 != C.TIME_UNSET) {
            long uptimeMillis = j2 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.t, uptimeMillis);
            }
        } else if (isVisible()) {
            b();
        }
        e();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.K = false;
        removeCallbacks(this.s);
        removeCallbacks(this.t);
    }

    public void removeVisibilityListener(VisibilityListener visibilityListener) {
        this.b.remove(visibilityListener);
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher) {
        if (this.H != controlDispatcher) {
            this.H = controlDispatcher;
            g();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        boolean z2 = false;
        if (jArr == null) {
            this.c0 = new long[0];
            this.d0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) Assertions.checkNotNull(zArr);
            if (jArr.length == zArr2.length) {
                z2 = true;
            }
            Assertions.checkArgument(z2);
            this.c0 = jArr;
            this.d0 = zArr2;
        }
        l();
    }

    @Deprecated
    public void setFastForwardIncrementMs(int i2) {
        ControlDispatcher controlDispatcher = this.H;
        if (controlDispatcher instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher).setFastForwardIncrementMs((long) i2);
            g();
        }
    }

    @Deprecated
    public void setPlaybackPreparer(@Nullable PlaybackPreparer playbackPreparer) {
        this.J = playbackPreparer;
    }

    public void setPlayer(@Nullable Player player) {
        boolean z2 = true;
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        if (!(player == null || player.getApplicationLooper() == Looper.getMainLooper())) {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        Player player2 = this.G;
        if (player2 != player) {
            if (player2 != null) {
                player2.removeListener(this.a);
            }
            this.G = player;
            if (player != null) {
                player.addListener(this.a);
            }
            e();
        }
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener) {
        this.I = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i2) {
        this.Q = i2;
        Player player = this.G;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i2 == 0 && repeatMode != 0) {
                this.H.dispatchSetRepeatMode(this.G, 0);
            } else if (i2 == 1 && repeatMode == 2) {
                this.H.dispatchSetRepeatMode(this.G, 1);
            } else if (i2 == 2 && repeatMode == 1) {
                this.H.dispatchSetRepeatMode(this.G, 2);
            }
        }
        j();
    }

    @Deprecated
    public void setRewindIncrementMs(int i2) {
        ControlDispatcher controlDispatcher = this.H;
        if (controlDispatcher instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher).setRewindIncrementMs((long) i2);
            g();
        }
    }

    public void setShowFastForwardButton(boolean z2) {
        this.S = z2;
        g();
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        this.L = z2;
        l();
    }

    public void setShowNextButton(boolean z2) {
        this.U = z2;
        g();
    }

    public void setShowPreviousButton(boolean z2) {
        this.T = z2;
        g();
    }

    public void setShowRewindButton(boolean z2) {
        this.R = z2;
        g();
    }

    public void setShowShuffleButton(boolean z2) {
        this.V = z2;
        k();
    }

    public void setShowTimeoutMs(int i2) {
        this.O = i2;
        if (isVisible()) {
            b();
        }
    }

    public void setShowVrButton(boolean z2) {
        View view = this.k;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.P = Util.constrainValue(i2, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            f(getShowVrButton(), onClickListener != null, this.k);
        }
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            Iterator<VisibilityListener> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(getVisibility());
            }
            e();
            c();
        }
        b();
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        int i3 = R.layout.exo_player_control_view;
        int i4 = 5000;
        this.O = 5000;
        this.Q = 0;
        this.P = 200;
        this.W = C.TIME_UNSET;
        this.R = true;
        this.S = true;
        this.T = true;
        this.U = true;
        this.V = false;
        int i5 = DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.PlayerControlView, 0, 0);
            try {
                i4 = obtainStyledAttributes.getInt(R.styleable.PlayerControlView_rewind_increment, 5000);
                i5 = obtainStyledAttributes.getInt(R.styleable.PlayerControlView_fastforward_increment, DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS);
                this.O = obtainStyledAttributes.getInt(R.styleable.PlayerControlView_show_timeout, this.O);
                i3 = obtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_controller_layout_id, i3);
                this.Q = obtainStyledAttributes.getInt(R.styleable.PlayerControlView_repeat_toggle_modes, this.Q);
                this.R = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_rewind_button, this.R);
                this.S = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_fastforward_button, this.S);
                this.T = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_previous_button, this.T);
                this.U = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_next_button, this.U);
                this.V = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_shuffle_button, this.V);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R.styleable.PlayerControlView_time_bar_min_update_interval, this.P));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.b = new CopyOnWriteArrayList<>();
        this.q = new Timeline.Period();
        this.r = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.o = sb;
        this.p = new Formatter(sb, Locale.getDefault());
        this.a0 = new long[0];
        this.b0 = new boolean[0];
        this.c0 = new long[0];
        this.d0 = new boolean[0];
        b bVar = new b(null);
        this.a = bVar;
        this.H = new DefaultControlDispatcher((long) i5, (long) i4);
        this.s = new Runnable() { // from class: a2.j.b.b.c1.d
            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView playerControlView = PlayerControlView.this;
                int i6 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
                playerControlView.i();
            }
        };
        this.t = new Runnable() { // from class: a2.j.b.b.c1.a
            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView.this.hide();
            }
        };
        LayoutInflater.from(context).inflate(i3, this);
        setDescendantFocusability(262144);
        int i6 = R.id.exo_progress;
        TimeBar timeBar = (TimeBar) findViewById(i6);
        View findViewById = findViewById(R.id.exo_progress_placeholder);
        if (timeBar != null) {
            this.n = timeBar;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(i6);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.n = defaultTimeBar;
        } else {
            this.n = null;
        }
        this.l = (TextView) findViewById(R.id.exo_duration);
        this.m = (TextView) findViewById(R.id.exo_position);
        TimeBar timeBar2 = this.n;
        if (timeBar2 != null) {
            timeBar2.addListener(bVar);
        }
        View findViewById2 = findViewById(R.id.exo_play);
        this.e = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(bVar);
        }
        View findViewById3 = findViewById(R.id.exo_pause);
        this.f = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(bVar);
        }
        View findViewById4 = findViewById(R.id.exo_prev);
        this.c = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(bVar);
        }
        View findViewById5 = findViewById(R.id.exo_next);
        this.d = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(bVar);
        }
        View findViewById6 = findViewById(R.id.exo_rew);
        this.h = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(bVar);
        }
        View findViewById7 = findViewById(R.id.exo_ffwd);
        this.g = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(bVar);
        }
        ImageView imageView = (ImageView) findViewById(R.id.exo_repeat_toggle);
        this.i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(bVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_shuffle);
        this.j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(bVar);
        }
        View findViewById8 = findViewById(R.id.exo_vr);
        this.k = findViewById8;
        setShowVrButton(false);
        f(false, false, findViewById8);
        Resources resources = context.getResources();
        this.C = ((float) resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled)) / 100.0f;
        this.D = ((float) resources.getInteger(R.integer.exo_media_button_opacity_percentage_disabled)) / 100.0f;
        this.u = resources.getDrawable(R.drawable.exo_controls_repeat_off);
        this.v = resources.getDrawable(R.drawable.exo_controls_repeat_one);
        this.w = resources.getDrawable(R.drawable.exo_controls_repeat_all);
        this.A = resources.getDrawable(R.drawable.exo_controls_shuffle_on);
        this.B = resources.getDrawable(R.drawable.exo_controls_shuffle_off);
        this.x = resources.getString(R.string.exo_controls_repeat_off_description);
        this.y = resources.getString(R.string.exo_controls_repeat_one_description);
        this.z = resources.getString(R.string.exo_controls_repeat_all_description);
        this.E = resources.getString(R.string.exo_controls_shuffle_on_description);
        this.F = resources.getString(R.string.exo_controls_shuffle_off_description);
    }
}
