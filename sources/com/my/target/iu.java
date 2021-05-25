package com.my.target;

import a2.j.b.b.k0;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.my.target.is;
public class iu implements Player.EventListener, is {
    @NonNull
    public final ik a = ik.J(200);
    @NonNull
    public final SimpleExoPlayer b;
    @NonNull
    public final a c;
    @Nullable
    public is.a d;
    public boolean e;
    public boolean f;
    @Nullable
    public MediaSource g;
    @Nullable
    public Uri h;

    public static class a implements Runnable {
        public final int a;
        @Nullable
        public SimpleExoPlayer b;
        @Nullable
        public is.a c;
        public int d;
        public float e;

        public a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SimpleExoPlayer simpleExoPlayer = this.b;
            if (simpleExoPlayer != null) {
                try {
                    float currentPosition = ((float) simpleExoPlayer.getCurrentPosition()) / 1000.0f;
                    float duration = ((float) this.b.getDuration()) / 1000.0f;
                    if (this.e == currentPosition) {
                        this.d++;
                    } else {
                        is.a aVar = this.c;
                        if (aVar != null) {
                            aVar.a(currentPosition, duration);
                        }
                        this.e = currentPosition;
                        if (this.d > 0) {
                            this.d = 0;
                        }
                    }
                    if (this.d > this.a) {
                        is.a aVar2 = this.c;
                        if (aVar2 != null) {
                            aVar2.D();
                        }
                        this.d = 0;
                    }
                } catch (Throwable th) {
                    StringBuilder L = a2.b.a.a.a.L("ExoPlayer error: ");
                    L.append(th.getMessage());
                    String sb = L.toString();
                    ae.a(sb);
                    this.c.e(sb);
                }
            }
        }
    }

    public iu(@NonNull Context context) {
        SimpleExoPlayer newSimpleInstance = ExoPlayerFactory.newSimpleInstance(context.getApplicationContext(), new DefaultTrackSelector());
        a aVar = new a(50);
        this.b = newSimpleInstance;
        this.c = aVar;
        newSimpleInstance.addListener(this);
        aVar.b = newSimpleInstance;
    }

    public static iu ah(@NonNull Context context) {
        return new iu(context);
    }

    @Override // com.my.target.is
    public void M() {
        try {
            this.b.setVolume(0.2f);
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("ExoPlayer error: "));
        }
    }

    @Override // com.my.target.is
    public void N() {
        try {
            this.b.setVolume(0.0f);
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("ExoPlayer error: "));
        }
        is.a aVar = this.d;
        if (aVar != null) {
            aVar.d(0.0f);
        }
    }

    @Override // com.my.target.is
    public void a(@NonNull Uri uri, @NonNull Context context) {
        this.h = uri;
        ae.a("Play video in ExoPlayer");
        this.f = false;
        is.a aVar = this.d;
        if (aVar != null) {
            aVar.C();
        }
        try {
            if (!this.e) {
                MediaSource b2 = iv.b(uri, context);
                this.g = b2;
                this.b.prepare(b2);
            }
            this.b.setPlayWhenReady(true);
        } catch (Throwable th) {
            StringBuilder L = a2.b.a.a.a.L("ExoPlayer error: ");
            L.append(th.getMessage());
            String sb = L.toString();
            ae.a(sb);
            this.d.e(sb);
        }
    }

    public void a(@NonNull Uri uri, @NonNull fq fqVar) {
        a(fqVar);
        a(uri, fqVar.getContext());
    }

    @Override // com.my.target.is
    public void a(@Nullable fq fqVar) {
        if (fqVar != null) {
            try {
                fqVar.setExoPlayer(this.b);
            } catch (Throwable th) {
                StringBuilder L = a2.b.a.a.a.L("ExoPlayer error: ");
                L.append(th.getMessage());
                String sb = L.toString();
                ae.a(sb);
                this.d.e(sb);
            }
        } else {
            this.b.setVideoTextureView(null);
        }
    }

    @Override // com.my.target.is
    public void a(@Nullable is.a aVar) {
        this.d = aVar;
        this.c.c = aVar;
    }

    @Override // com.my.target.is
    public void da() {
        try {
            this.b.setVolume(1.0f);
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("ExoPlayer error: "));
        }
        is.a aVar = this.d;
        if (aVar != null) {
            aVar.d(1.0f);
        }
    }

    @Override // com.my.target.is
    public void destroy() {
        this.h = null;
        this.e = false;
        this.f = false;
        this.d = null;
        this.b.setVideoTextureView(null);
        this.b.stop();
        this.b.release();
        this.b.removeListener(this);
        this.a.e(this.c);
    }

    @Override // com.my.target.is
    public void dk() {
        try {
            setVolume(((double) this.b.getVolume()) == 1.0d ? 0.0f : 1.0f);
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("ExoPlayer error: "));
        }
    }

    @Override // com.my.target.is
    public void fl() {
        try {
            this.b.seekTo(0);
            this.b.setPlayWhenReady(true);
        } catch (Throwable th) {
            StringBuilder L = a2.b.a.a.a.L("ExoPlayer error: ");
            L.append(th.getMessage());
            String sb = L.toString();
            ae.a(sb);
            this.d.e(sb);
        }
    }

    public float getDuration() {
        try {
            return ((float) this.b.getDuration()) / 1000.0f;
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("ExoPlayer error: "));
            return 0.0f;
        }
    }

    @Override // com.my.target.is
    public long getPosition() {
        try {
            return this.b.getCurrentPosition();
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("ExoPlayer error: "));
            return 0;
        }
    }

    @Override // com.my.target.is
    @Nullable
    public Uri getUri() {
        return this.h;
    }

    @Override // com.my.target.is
    public boolean isMuted() {
        try {
            return this.b.getVolume() == 0.0f;
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("ExoPlayer error: "));
            return false;
        }
    }

    @Override // com.my.target.is
    public boolean isPaused() {
        return this.e && this.f;
    }

    @Override // com.my.target.is
    public boolean isPlaying() {
        return this.e && !this.f;
    }

    @Override // com.my.target.is
    public boolean isStarted() {
        return this.e;
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
    public /* synthetic */ void onIsPlayingChanged(boolean z) {
        k0.$default$onIsPlayingChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
        k0.$default$onMediaItemTransition(this, mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
        k0.$default$onPlayWhenReadyChanged(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackStateChanged(int i) {
        k0.$default$onPlaybackStateChanged(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        k0.$default$onPlaybackSuppressionReasonChanged(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        this.f = false;
        this.e = false;
        if (this.d != null) {
            String message = exoPlaybackException.getMessage();
            if (message == null) {
                message = "Unknown video error";
            }
            this.d.e(message);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.f = false;
                        this.e = false;
                        float duration = getDuration();
                        is.a aVar = this.d;
                        if (aVar != null) {
                            aVar.a(duration, duration);
                        }
                        is.a aVar2 = this.d;
                        if (aVar2 != null) {
                            aVar2.onVideoCompleted();
                        }
                    } else {
                        return;
                    }
                } else if (z) {
                    is.a aVar3 = this.d;
                    if (aVar3 != null) {
                        aVar3.z();
                    }
                    if (!this.e) {
                        this.e = true;
                    } else if (this.f) {
                        this.f = false;
                        is.a aVar4 = this.d;
                        if (aVar4 != null) {
                            aVar4.B();
                        }
                    }
                } else if (!this.f) {
                    this.f = true;
                    is.a aVar5 = this.d;
                    if (aVar5 != null) {
                        aVar5.A();
                    }
                }
            } else if (!z || this.e) {
                return;
            }
            this.a.d(this.c);
            return;
        } else if (this.e) {
            this.e = false;
            is.a aVar6 = this.d;
            if (aVar6 != null) {
                aVar6.y();
            }
        }
        this.a.e(this.c);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int i) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int i) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onSeekProcessed() {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onShuffleModeEnabledChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        k0.$default$onTimelineChanged(this, timeline, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, Object obj, int i) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    @Override // com.my.target.is
    public void pause() {
        if (this.e && !this.f) {
            try {
                this.b.setPlayWhenReady(false);
            } catch (Throwable th) {
                StringBuilder L = a2.b.a.a.a.L("ExoPlayer error: ");
                L.append(th.getMessage());
                String sb = L.toString();
                ae.a(sb);
                this.d.e(sb);
            }
        }
    }

    @Override // com.my.target.is
    public void resume() {
        try {
            if (this.e) {
                this.b.setPlayWhenReady(true);
                return;
            }
            MediaSource mediaSource = this.g;
            if (mediaSource != null) {
                this.b.prepare(mediaSource, true, true);
            }
        } catch (Throwable th) {
            StringBuilder L = a2.b.a.a.a.L("ExoPlayer error: ");
            L.append(th.getMessage());
            String sb = L.toString();
            ae.a(sb);
            this.d.e(sb);
        }
    }

    @Override // com.my.target.is
    public void seekTo(long j) {
        try {
            this.b.seekTo(j);
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("ExoPlayer error: "));
        }
    }

    @Override // com.my.target.is
    public void setVolume(float f2) {
        try {
            this.b.setVolume(f2);
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("ExoPlayer error: "));
        }
        is.a aVar = this.d;
        if (aVar != null) {
            aVar.d(f2);
        }
    }

    @Override // com.my.target.is
    public void stop() {
        try {
            this.b.stop(true);
        } catch (Throwable th) {
            StringBuilder L = a2.b.a.a.a.L("ExoPlayer error: ");
            L.append(th.getMessage());
            String sb = L.toString();
            ae.a(sb);
            this.d.e(sb);
        }
    }
}
