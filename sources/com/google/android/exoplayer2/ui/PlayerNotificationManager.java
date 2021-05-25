package com.google.android.exoplayer2.ui;

import a2.j.b.b.k0;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
public class PlayerNotificationManager {
    public static final String ACTION_FAST_FORWARD = "com.google.android.exoplayer.ffwd";
    public static final String ACTION_NEXT = "com.google.android.exoplayer.next";
    public static final String ACTION_PAUSE = "com.google.android.exoplayer.pause";
    public static final String ACTION_PLAY = "com.google.android.exoplayer.play";
    public static final String ACTION_PREVIOUS = "com.google.android.exoplayer.prev";
    public static final String ACTION_REWIND = "com.google.android.exoplayer.rewind";
    public static final String ACTION_STOP = "com.google.android.exoplayer.stop";
    public static final String EXTRA_INSTANCE_ID = "INSTANCE_ID";
    public static int M;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public int G;
    public int H;
    @DrawableRes
    public int I;
    public int J;
    public int K;
    public boolean L;
    public final Context a;
    public final String b;
    public final int c;
    public final MediaDescriptionAdapter d;
    @Nullable
    public final CustomActionReceiver e;
    public final Handler f;
    public final NotificationManagerCompat g;
    public final IntentFilter h;
    public final Player.EventListener i;
    public final b j;
    public final Map<String, NotificationCompat.Action> k;
    public final Map<String, NotificationCompat.Action> l;
    public final PendingIntent m;
    public final int n;
    public final Timeline.Window o;
    @Nullable
    public NotificationCompat.Builder p;
    @Nullable
    public List<NotificationCompat.Action> q;
    @Nullable
    public Player r;
    @Nullable
    public PlaybackPreparer s;
    public ControlDispatcher t;
    public boolean u;
    public int v;
    @Nullable
    public NotificationListener w;
    @Nullable
    public MediaSessionCompat.Token x;
    public boolean y;
    public boolean z;

    public final class BitmapCallback {
        public final int a;

        public BitmapCallback(int i, a aVar) {
            this.a = i;
        }

        public void onBitmap(Bitmap bitmap) {
            if (bitmap != null) {
                PlayerNotificationManager playerNotificationManager = PlayerNotificationManager.this;
                playerNotificationManager.f.obtainMessage(1, this.a, -1, bitmap).sendToTarget();
            }
        }
    }

    public interface CustomActionReceiver {
        Map<String, NotificationCompat.Action> createCustomActions(Context context, int i);

        List<String> getCustomActions(Player player);

        void onCustomAction(Player player, String str, Intent intent);
    }

    public interface MediaDescriptionAdapter {
        @Nullable
        PendingIntent createCurrentContentIntent(Player player);

        @Nullable
        CharSequence getCurrentContentText(Player player);

        CharSequence getCurrentContentTitle(Player player);

        @Nullable
        Bitmap getCurrentLargeIcon(Player player, BitmapCallback bitmapCallback);

        @Nullable
        CharSequence getCurrentSubText(Player player);
    }

    public interface NotificationListener {
        @Deprecated
        void onNotificationCancelled(int i);

        void onNotificationCancelled(int i, boolean z);

        void onNotificationPosted(int i, Notification notification, boolean z);

        @Deprecated
        void onNotificationStarted(int i, Notification notification);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {
    }

    public class b extends BroadcastReceiver {
        public b(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PlayerNotificationManager playerNotificationManager = PlayerNotificationManager.this;
            Player player = playerNotificationManager.r;
            if (player != null && playerNotificationManager.u && intent.getIntExtra(PlayerNotificationManager.EXTRA_INSTANCE_ID, playerNotificationManager.n) == PlayerNotificationManager.this.n) {
                String action = intent.getAction();
                if (PlayerNotificationManager.ACTION_PLAY.equals(action)) {
                    if (player.getPlaybackState() == 1) {
                        PlayerNotificationManager playerNotificationManager2 = PlayerNotificationManager.this;
                        PlaybackPreparer playbackPreparer = playerNotificationManager2.s;
                        if (playbackPreparer != null) {
                            playbackPreparer.preparePlayback();
                        } else {
                            playerNotificationManager2.t.dispatchPrepare(player);
                        }
                    } else if (player.getPlaybackState() == 4) {
                        PlayerNotificationManager.this.t.dispatchSeekTo(player, player.getCurrentWindowIndex(), C.TIME_UNSET);
                    }
                    PlayerNotificationManager.this.t.dispatchSetPlayWhenReady(player, true);
                } else if (PlayerNotificationManager.ACTION_PAUSE.equals(action)) {
                    PlayerNotificationManager.this.t.dispatchSetPlayWhenReady(player, false);
                } else if (PlayerNotificationManager.ACTION_PREVIOUS.equals(action)) {
                    PlayerNotificationManager.this.t.dispatchPrevious(player);
                } else if (PlayerNotificationManager.ACTION_REWIND.equals(action)) {
                    PlayerNotificationManager.this.t.dispatchRewind(player);
                } else if (PlayerNotificationManager.ACTION_FAST_FORWARD.equals(action)) {
                    PlayerNotificationManager.this.t.dispatchFastForward(player);
                } else if (PlayerNotificationManager.ACTION_NEXT.equals(action)) {
                    PlayerNotificationManager.this.t.dispatchNext(player);
                } else if (PlayerNotificationManager.ACTION_STOP.equals(action)) {
                    PlayerNotificationManager.this.t.dispatchStop(player, true);
                } else if ("com.google.android.exoplayer.dismiss".equals(action)) {
                    PlayerNotificationManager.this.e(true);
                } else if (action != null) {
                    PlayerNotificationManager playerNotificationManager3 = PlayerNotificationManager.this;
                    if (playerNotificationManager3.e != null && playerNotificationManager3.l.containsKey(action)) {
                        PlayerNotificationManager.this.e.onCustomAction(player, action, intent);
                    }
                }
            }
        }
    }

    public class c implements Player.EventListener {
        public c(a aVar) {
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
            PlayerNotificationManager.this.b();
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
            PlayerNotificationManager.this.b();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            PlayerNotificationManager.this.b();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            PlayerNotificationManager.this.b();
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
            PlayerNotificationManager.this.b();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
            PlayerNotificationManager.this.b();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            k0.$default$onSeekProcessed(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            PlayerNotificationManager.this.b();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, int i) {
            PlayerNotificationManager.this.b();
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

    public PlayerNotificationManager(Context context, String str, int i2, MediaDescriptionAdapter mediaDescriptionAdapter) {
        this(context, str, i2, mediaDescriptionAdapter, null, null);
    }

    public static PendingIntent a(String str, Context context, int i2) {
        Intent intent = new Intent(str).setPackage(context.getPackageName());
        intent.putExtra(EXTRA_INSTANCE_ID, i2);
        return PendingIntent.getBroadcast(context, i2, intent, 134217728);
    }

    @Deprecated
    public static PlayerNotificationManager createWithNotificationChannel(Context context, String str, @StringRes int i2, int i3, MediaDescriptionAdapter mediaDescriptionAdapter) {
        return createWithNotificationChannel(context, str, i2, 0, i3, mediaDescriptionAdapter);
    }

    public final void b() {
        if (!this.f.hasMessages(0)) {
            this.f.sendEmptyMessage(0);
        }
    }

    public final boolean c(Player player) {
        if (player.getPlaybackState() == 4 || player.getPlaybackState() == 1 || !player.getPlayWhenReady()) {
            return false;
        }
        return true;
    }

    @Nullable
    public NotificationCompat.Builder createNotification(Player player, @Nullable NotificationCompat.Builder builder, boolean z2, @Nullable Bitmap bitmap) {
        NotificationCompat.Action action;
        if (player.getPlaybackState() != 1 || !player.getCurrentTimeline().isEmpty()) {
            List<String> actions = getActions(player);
            ArrayList arrayList = new ArrayList(actions.size());
            for (int i2 = 0; i2 < actions.size(); i2++) {
                String str = actions.get(i2);
                if (this.k.containsKey(str)) {
                    action = this.k.get(str);
                } else {
                    action = this.l.get(str);
                }
                if (action != null) {
                    arrayList.add(action);
                }
            }
            if (builder == null || !arrayList.equals(this.q)) {
                builder = new NotificationCompat.Builder(this.a, this.b);
                this.q = arrayList;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    builder.addAction((NotificationCompat.Action) arrayList.get(i3));
                }
            }
            NotificationCompat.MediaStyle mediaStyle = new NotificationCompat.MediaStyle();
            MediaSessionCompat.Token token = this.x;
            if (token != null) {
                mediaStyle.setMediaSession(token);
            }
            mediaStyle.setShowActionsInCompactView(getActionIndicesForCompactView(actions, player));
            mediaStyle.setShowCancelButton(!z2);
            mediaStyle.setCancelButtonIntent(this.m);
            builder.setStyle(mediaStyle);
            builder.setDeleteIntent(this.m);
            builder.setBadgeIconType(this.E).setOngoing(z2).setColor(this.H).setColorized(this.F).setSmallIcon(this.I).setVisibility(this.J).setPriority(this.K).setDefaults(this.G);
            if (Util.SDK_INT < 21 || !this.L || !player.isPlaying() || player.isPlayingAd() || player.isCurrentWindowDynamic() || player.getPlaybackParameters().speed != 1.0f) {
                builder.setShowWhen(false).setUsesChronometer(false);
            } else {
                builder.setWhen(System.currentTimeMillis() - player.getContentPosition()).setShowWhen(true).setUsesChronometer(true);
            }
            builder.setContentTitle(this.d.getCurrentContentTitle(player));
            builder.setContentText(this.d.getCurrentContentText(player));
            builder.setSubText(this.d.getCurrentSubText(player));
            if (bitmap == null) {
                MediaDescriptionAdapter mediaDescriptionAdapter = this.d;
                int i4 = this.v + 1;
                this.v = i4;
                bitmap = mediaDescriptionAdapter.getCurrentLargeIcon(player, new BitmapCallback(i4, null));
            }
            builder.setLargeIcon(bitmap);
            builder.setContentIntent(this.d.createCurrentContentIntent(player));
            return builder;
        }
        this.q = null;
        return null;
    }

    public final void d(Player player, @Nullable Bitmap bitmap) {
        boolean ongoing = getOngoing(player);
        NotificationCompat.Builder createNotification = createNotification(player, this.p, ongoing, bitmap);
        this.p = createNotification;
        boolean z2 = false;
        if (createNotification == null) {
            e(false);
            return;
        }
        Notification build = createNotification.build();
        this.g.notify(this.c, build);
        if (!this.u) {
            this.a.registerReceiver(this.j, this.h);
            NotificationListener notificationListener = this.w;
            if (notificationListener != null) {
                notificationListener.onNotificationStarted(this.c, build);
            }
        }
        NotificationListener notificationListener2 = this.w;
        if (notificationListener2 != null) {
            int i2 = this.c;
            if (ongoing || !this.u) {
                z2 = true;
            }
            notificationListener2.onNotificationPosted(i2, build, z2);
        }
        this.u = true;
    }

    public final void e(boolean z2) {
        if (this.u) {
            this.u = false;
            this.f.removeMessages(0);
            this.g.cancel(this.c);
            this.a.unregisterReceiver(this.j);
            NotificationListener notificationListener = this.w;
            if (notificationListener != null) {
                notificationListener.onNotificationCancelled(this.c, z2);
                this.w.onNotificationCancelled(this.c);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int[] getActionIndicesForCompactView(java.util.List<java.lang.String> r7, com.google.android.exoplayer2.Player r8) {
        /*
            r6 = this;
            java.lang.String r0 = "com.google.android.exoplayer.pause"
            int r0 = r7.indexOf(r0)
            java.lang.String r1 = "com.google.android.exoplayer.play"
            int r1 = r7.indexOf(r1)
            boolean r2 = r6.A
            r3 = -1
            if (r2 == 0) goto L_0x0018
            java.lang.String r2 = "com.google.android.exoplayer.prev"
            int r2 = r7.indexOf(r2)
            goto L_0x0019
        L_0x0018:
            r2 = -1
        L_0x0019:
            boolean r4 = r6.B
            if (r4 == 0) goto L_0x0024
            java.lang.String r4 = "com.google.android.exoplayer.next"
            int r7 = r7.indexOf(r4)
            goto L_0x0025
        L_0x0024:
            r7 = -1
        L_0x0025:
            r4 = 3
            int[] r4 = new int[r4]
            r5 = 0
            if (r2 == r3) goto L_0x002e
            r4[r5] = r2
            r5 = 1
        L_0x002e:
            boolean r8 = r6.c(r8)
            if (r0 == r3) goto L_0x003c
            if (r8 == 0) goto L_0x003c
            int r8 = r5 + 1
            r4[r5] = r0
        L_0x003a:
            r5 = r8
            goto L_0x0045
        L_0x003c:
            if (r1 == r3) goto L_0x0045
            if (r8 != 0) goto L_0x0045
            int r8 = r5 + 1
            r4[r5] = r1
            goto L_0x003a
        L_0x0045:
            if (r7 == r3) goto L_0x004c
            int r8 = r5 + 1
            r4[r5] = r7
            r5 = r8
        L_0x004c:
            int[] r7 = java.util.Arrays.copyOf(r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerNotificationManager.getActionIndicesForCompactView(java.util.List, com.google.android.exoplayer2.Player):int[]");
    }

    public List<String> getActions(Player player) {
        boolean z2;
        boolean z3;
        boolean z4;
        Timeline currentTimeline = player.getCurrentTimeline();
        boolean z5 = false;
        if (currentTimeline.isEmpty() || player.isPlayingAd()) {
            z4 = false;
            z3 = false;
            z2 = false;
        } else {
            currentTimeline.getWindow(player.getCurrentWindowIndex(), this.o);
            Timeline.Window window = this.o;
            boolean z7 = window.isSeekable || !window.isDynamic || player.hasPrevious();
            z3 = this.t.isRewindEnabled();
            z2 = this.t.isFastForwardEnabled();
            if (this.o.isDynamic || player.hasNext()) {
                z5 = true;
            }
            z5 = z7;
            z4 = z5;
        }
        ArrayList arrayList = new ArrayList();
        if (this.y && z5) {
            arrayList.add(ACTION_PREVIOUS);
        }
        if (z3) {
            arrayList.add(ACTION_REWIND);
        }
        if (this.C) {
            if (c(player)) {
                arrayList.add(ACTION_PAUSE);
            } else {
                arrayList.add(ACTION_PLAY);
            }
        }
        if (z2) {
            arrayList.add(ACTION_FAST_FORWARD);
        }
        if (this.z && z4) {
            arrayList.add(ACTION_NEXT);
        }
        CustomActionReceiver customActionReceiver = this.e;
        if (customActionReceiver != null) {
            arrayList.addAll(customActionReceiver.getCustomActions(player));
        }
        if (this.D) {
            arrayList.add(ACTION_STOP);
        }
        return arrayList;
    }

    public boolean getOngoing(Player player) {
        int playbackState = player.getPlaybackState();
        return (playbackState == 2 || playbackState == 3) && player.getPlayWhenReady();
    }

    public void invalidate() {
        if (this.u) {
            b();
        }
    }

    public final void setBadgeIconType(int i2) {
        if (this.E != i2) {
            if (i2 == 0 || i2 == 1 || i2 == 2) {
                this.E = i2;
                invalidate();
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public final void setColor(int i2) {
        if (this.H != i2) {
            this.H = i2;
            invalidate();
        }
    }

    public final void setColorized(boolean z2) {
        if (this.F != z2) {
            this.F = z2;
            invalidate();
        }
    }

    public final void setControlDispatcher(ControlDispatcher controlDispatcher) {
        if (this.t != controlDispatcher) {
            this.t = controlDispatcher;
            invalidate();
        }
    }

    public final void setDefaults(int i2) {
        if (this.G != i2) {
            this.G = i2;
            invalidate();
        }
    }

    @Deprecated
    public final void setFastForwardIncrementMs(long j2) {
        ControlDispatcher controlDispatcher = this.t;
        if (controlDispatcher instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher).setFastForwardIncrementMs(j2);
            invalidate();
        }
    }

    public final void setMediaSessionToken(MediaSessionCompat.Token token) {
        if (!Util.areEqual(this.x, token)) {
            this.x = token;
            invalidate();
        }
    }

    @Deprecated
    public final void setNotificationListener(NotificationListener notificationListener) {
        this.w = notificationListener;
    }

    @Deprecated
    public void setPlaybackPreparer(@Nullable PlaybackPreparer playbackPreparer) {
        this.s = playbackPreparer;
    }

    public final void setPlayer(@Nullable Player player) {
        boolean z2 = true;
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        if (!(player == null || player.getApplicationLooper() == Looper.getMainLooper())) {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        Player player2 = this.r;
        if (player2 != player) {
            if (player2 != null) {
                player2.removeListener(this.i);
                if (player == null) {
                    e(false);
                }
            }
            this.r = player;
            if (player != null) {
                player.addListener(this.i);
                b();
            }
        }
    }

    public final void setPriority(int i2) {
        if (this.K != i2) {
            if (i2 == -2 || i2 == -1 || i2 == 0 || i2 == 1 || i2 == 2) {
                this.K = i2;
                invalidate();
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Deprecated
    public final void setRewindIncrementMs(long j2) {
        ControlDispatcher controlDispatcher = this.t;
        if (controlDispatcher instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher).setRewindIncrementMs(j2);
            invalidate();
        }
    }

    public final void setSmallIcon(@DrawableRes int i2) {
        if (this.I != i2) {
            this.I = i2;
            invalidate();
        }
    }

    public final void setUseChronometer(boolean z2) {
        if (this.L != z2) {
            this.L = z2;
            invalidate();
        }
    }

    @Deprecated
    public final void setUseNavigationActions(boolean z2) {
        setUseNextAction(z2);
        setUsePreviousAction(z2);
    }

    @Deprecated
    public final void setUseNavigationActionsInCompactView(boolean z2) {
        setUseNextActionInCompactView(z2);
        setUsePreviousActionInCompactView(z2);
    }

    public void setUseNextAction(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
            invalidate();
        }
    }

    public void setUseNextActionInCompactView(boolean z2) {
        if (this.B != z2) {
            this.B = z2;
            invalidate();
        }
    }

    public final void setUsePlayPauseActions(boolean z2) {
        if (this.C != z2) {
            this.C = z2;
            invalidate();
        }
    }

    public void setUsePreviousAction(boolean z2) {
        if (this.y != z2) {
            this.y = z2;
            invalidate();
        }
    }

    public void setUsePreviousActionInCompactView(boolean z2) {
        if (this.A != z2) {
            this.A = z2;
            invalidate();
        }
    }

    public final void setUseStopAction(boolean z2) {
        if (this.D != z2) {
            this.D = z2;
            invalidate();
        }
    }

    public final void setVisibility(int i2) {
        if (this.J != i2) {
            if (i2 == -1 || i2 == 0 || i2 == 1) {
                this.J = i2;
                invalidate();
                return;
            }
            throw new IllegalStateException();
        }
    }

    public PlayerNotificationManager(Context context, String str, int i2, MediaDescriptionAdapter mediaDescriptionAdapter, @Nullable NotificationListener notificationListener) {
        this(context, str, i2, mediaDescriptionAdapter, notificationListener, null);
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context, String str, @StringRes int i2, @StringRes int i3, int i4, MediaDescriptionAdapter mediaDescriptionAdapter) {
        NotificationUtil.createNotificationChannel(context, str, i2, i3, 2);
        return new PlayerNotificationManager(context, str, i4, mediaDescriptionAdapter);
    }

    public PlayerNotificationManager(Context context, String str, int i2, MediaDescriptionAdapter mediaDescriptionAdapter, @Nullable CustomActionReceiver customActionReceiver) {
        this(context, str, i2, mediaDescriptionAdapter, null, customActionReceiver);
    }

    public PlayerNotificationManager(Context context, String str, int i2, MediaDescriptionAdapter mediaDescriptionAdapter, @Nullable NotificationListener notificationListener, @Nullable CustomActionReceiver customActionReceiver) {
        Map<String, NotificationCompat.Action> map;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = str;
        this.c = i2;
        this.d = mediaDescriptionAdapter;
        this.w = notificationListener;
        this.e = customActionReceiver;
        this.t = new DefaultControlDispatcher();
        this.o = new Timeline.Window();
        int i3 = M;
        M = i3 + 1;
        this.n = i3;
        this.f = Util.createHandler(Looper.getMainLooper(), new Handler.Callback() { // from class: a2.j.b.b.c1.e
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                PlayerNotificationManager playerNotificationManager = PlayerNotificationManager.this;
                Objects.requireNonNull(playerNotificationManager);
                int i4 = message.what;
                if (i4 == 0) {
                    Player player = playerNotificationManager.r;
                    if (player == null) {
                        return true;
                    }
                    playerNotificationManager.d(player, null);
                    return true;
                } else if (i4 != 1) {
                    return false;
                } else {
                    Player player2 = playerNotificationManager.r;
                    if (player2 == null || !playerNotificationManager.u || playerNotificationManager.v != message.arg1) {
                        return true;
                    }
                    playerNotificationManager.d(player2, (Bitmap) message.obj);
                    return true;
                }
            }
        });
        this.g = NotificationManagerCompat.from(applicationContext);
        this.i = new c(null);
        this.j = new b(null);
        this.h = new IntentFilter();
        this.y = true;
        this.z = true;
        this.C = true;
        this.F = true;
        this.L = true;
        this.H = 0;
        this.I = R.drawable.exo_notification_small_icon;
        this.G = 0;
        this.K = -1;
        this.E = 1;
        this.J = 1;
        HashMap hashMap = new HashMap();
        hashMap.put(ACTION_PLAY, new NotificationCompat.Action(R.drawable.exo_notification_play, applicationContext.getString(R.string.exo_controls_play_description), a(ACTION_PLAY, applicationContext, i3)));
        hashMap.put(ACTION_PAUSE, new NotificationCompat.Action(R.drawable.exo_notification_pause, applicationContext.getString(R.string.exo_controls_pause_description), a(ACTION_PAUSE, applicationContext, i3)));
        hashMap.put(ACTION_STOP, new NotificationCompat.Action(R.drawable.exo_notification_stop, applicationContext.getString(R.string.exo_controls_stop_description), a(ACTION_STOP, applicationContext, i3)));
        hashMap.put(ACTION_REWIND, new NotificationCompat.Action(R.drawable.exo_notification_rewind, applicationContext.getString(R.string.exo_controls_rewind_description), a(ACTION_REWIND, applicationContext, i3)));
        hashMap.put(ACTION_FAST_FORWARD, new NotificationCompat.Action(R.drawable.exo_notification_fastforward, applicationContext.getString(R.string.exo_controls_fastforward_description), a(ACTION_FAST_FORWARD, applicationContext, i3)));
        hashMap.put(ACTION_PREVIOUS, new NotificationCompat.Action(R.drawable.exo_notification_previous, applicationContext.getString(R.string.exo_controls_previous_description), a(ACTION_PREVIOUS, applicationContext, i3)));
        hashMap.put(ACTION_NEXT, new NotificationCompat.Action(R.drawable.exo_notification_next, applicationContext.getString(R.string.exo_controls_next_description), a(ACTION_NEXT, applicationContext, i3)));
        this.k = hashMap;
        for (String str2 : hashMap.keySet()) {
            this.h.addAction(str2);
        }
        if (customActionReceiver != null) {
            map = customActionReceiver.createCustomActions(applicationContext, this.n);
        } else {
            map = Collections.emptyMap();
        }
        this.l = map;
        for (String str3 : map.keySet()) {
            this.h.addAction(str3);
        }
        this.m = a("com.google.android.exoplayer.dismiss", applicationContext, this.n);
        this.h.addAction("com.google.android.exoplayer.dismiss");
    }

    @Deprecated
    public static PlayerNotificationManager createWithNotificationChannel(Context context, String str, @StringRes int i2, int i3, MediaDescriptionAdapter mediaDescriptionAdapter, @Nullable NotificationListener notificationListener) {
        return createWithNotificationChannel(context, str, i2, 0, i3, mediaDescriptionAdapter, notificationListener);
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context, String str, @StringRes int i2, @StringRes int i3, int i4, MediaDescriptionAdapter mediaDescriptionAdapter, @Nullable NotificationListener notificationListener) {
        NotificationUtil.createNotificationChannel(context, str, i2, i3, 2);
        return new PlayerNotificationManager(context, str, i4, mediaDescriptionAdapter, notificationListener);
    }
}
