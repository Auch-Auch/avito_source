package com.google.android.exoplayer2.ui;

import a2.j.b.b.f1.j;
import a2.j.b.b.k0;
import a2.j.b.b.z0.u.f;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.spherical.SingleTapListener;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
public class PlayerView extends FrameLayout implements AdsLoader.AdViewProvider {
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;
    public boolean A;
    public final a a;
    @Nullable
    public final AspectRatioFrameLayout b;
    @Nullable
    public final View c;
    @Nullable
    public final View d;
    @Nullable
    public final ImageView e;
    @Nullable
    public final SubtitleView f;
    @Nullable
    public final View g;
    @Nullable
    public final TextView h;
    @Nullable
    public final PlayerControlView i;
    @Nullable
    public final FrameLayout j;
    @Nullable
    public final FrameLayout k;
    @Nullable
    public Player l;
    public boolean m;
    @Nullable
    public PlayerControlView.VisibilityListener n;
    public boolean o;
    @Nullable
    public Drawable p;
    public int q;
    public boolean r;
    public boolean s;
    @Nullable
    public ErrorMessageProvider<? super ExoPlaybackException> t;
    @Nullable
    public CharSequence u;
    public int v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowBuffering {
    }

    public final class a implements Player.EventListener, TextOutput, VideoListener, View.OnLayoutChangeListener, SingleTapListener, PlayerControlView.VisibilityListener {
        public final Timeline.Period a = new Timeline.Period();
        @Nullable
        public Object b;

        public a() {
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            SubtitleView subtitleView = PlayerView.this.f;
            if (subtitleView != null) {
                subtitleView.onCues(list);
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
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            k0.$default$onIsPlayingChanged(this, z);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            PlayerView.a((TextureView) view, PlayerView.this.z);
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
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.SHOW_BUFFERING_NEVER;
            playerView.j();
            PlayerView playerView2 = PlayerView.this;
            if (!playerView2.d() || !playerView2.x) {
                playerView2.e(false);
            } else {
                playerView2.hideController();
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            k0.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.SHOW_BUFFERING_NEVER;
            playerView.j();
            PlayerView.this.l();
            PlayerView playerView2 = PlayerView.this;
            if (!playerView2.d() || !playerView2.x) {
                playerView2.e(false);
            } else {
                playerView2.hideController();
            }
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
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.SHOW_BUFFERING_NEVER;
            if (playerView.d()) {
                PlayerView playerView2 = PlayerView.this;
                if (playerView2.x) {
                    playerView2.hideController();
                }
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public void onRenderedFirstFrame() {
            View view = PlayerView.this.c;
            if (view != null) {
                view.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onRepeatModeChanged(int i) {
            k0.$default$onRepeatModeChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            k0.$default$onSeekProcessed(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            k0.$default$onShuffleModeEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.ui.spherical.SingleTapListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            PlayerView playerView = PlayerView.this;
            int i = PlayerView.SHOW_BUFFERING_NEVER;
            return playerView.i();
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            j.$default$onSurfaceSizeChanged(this, i, i2);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            k0.$default$onTimelineChanged(this, timeline, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
            k0.$default$onTimelineChanged(this, timeline, obj, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player player = (Player) Assertions.checkNotNull(PlayerView.this.l);
            Timeline currentTimeline = player.getCurrentTimeline();
            if (currentTimeline.isEmpty()) {
                this.b = null;
            } else if (!player.getCurrentTrackGroups().isEmpty()) {
                this.b = currentTimeline.getPeriod(player.getCurrentPeriodIndex(), this.a, true).uid;
            } else {
                Object obj = this.b;
                if (obj != null) {
                    int indexOfPeriod = currentTimeline.getIndexOfPeriod(obj);
                    if (indexOfPeriod == -1 || player.getCurrentWindowIndex() != currentTimeline.getPeriod(indexOfPeriod, this.a).windowIndex) {
                        this.b = null;
                    } else {
                        return;
                    }
                }
            }
            PlayerView.this.m(false);
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            float f2 = (i2 == 0 || i == 0) ? 1.0f : (((float) i) * f) / ((float) i2);
            PlayerView playerView = PlayerView.this;
            View view = playerView.d;
            if (view instanceof TextureView) {
                if (i3 == 90 || i3 == 270) {
                    f2 = 1.0f / f2;
                }
                if (playerView.z != 0) {
                    view.removeOnLayoutChangeListener(this);
                }
                PlayerView playerView2 = PlayerView.this;
                playerView2.z = i3;
                if (i3 != 0) {
                    playerView2.d.addOnLayoutChangeListener(this);
                }
                PlayerView playerView3 = PlayerView.this;
                PlayerView.a((TextureView) playerView3.d, playerView3.z);
            }
            PlayerView playerView4 = PlayerView.this;
            playerView4.onContentAspectRatioChanged(f2, playerView4.b, playerView4.d);
        }

        @Override // com.google.android.exoplayer2.ui.PlayerControlView.VisibilityListener
        public void onVisibilityChange(int i) {
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.SHOW_BUFFERING_NEVER;
            playerView.k();
        }
    }

    public PlayerView(Context context) {
        this(context, null);
    }

    public static void a(TextureView textureView, int i2) {
        Matrix matrix = new Matrix();
        float width = (float) textureView.getWidth();
        float height = (float) textureView.getHeight();
        if (!(width == 0.0f || height == 0.0f || i2 == 0)) {
            float f2 = width / 2.0f;
            float f3 = height / 2.0f;
            matrix.postRotate((float) i2, f2, f3);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f2, f3);
        }
        textureView.setTransform(matrix);
    }

    public static void switchTargetView(Player player, @Nullable PlayerView playerView, @Nullable PlayerView playerView2) {
        if (playerView != playerView2) {
            if (playerView2 != null) {
                playerView2.setPlayer(player);
            }
            if (playerView != null) {
                playerView.setPlayer(null);
            }
        }
    }

    public final void b() {
        View view = this.c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void c() {
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.e.setVisibility(4);
        }
    }

    public final boolean d() {
        Player player = this.l;
        return player != null && player.isPlayingAd() && this.l.getPlayWhenReady();
    }

    @Override // android.view.View, android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player player = this.l;
        if (player != null && player.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z2 = keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23;
        if (z2 && n() && !this.i.isVisible()) {
            e(true);
        } else if (dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            e(true);
        } else if (!z2 || !n()) {
            return false;
        } else {
            e(true);
            return false;
        }
        return true;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        return n() && this.i.dispatchMediaKeyEvent(keyEvent);
    }

    public final void e(boolean z2) {
        if ((!d() || !this.x) && n()) {
            boolean z3 = this.i.isVisible() && this.i.getShowTimeoutMs() <= 0;
            boolean g2 = g();
            if (z2 || z3 || g2) {
                h(g2);
            }
        }
    }

    @RequiresNonNull({"artworkView"})
    public final boolean f(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                onContentAspectRatioChanged(((float) intrinsicWidth) / ((float) intrinsicHeight), this.b, this.e);
                this.e.setImageDrawable(drawable);
                this.e.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        Player player = this.l;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        if (!this.w || (playbackState != 1 && playbackState != 4 && this.l.getPlayWhenReady())) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider
    public List<AdsLoader.OverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            arrayList.add(new AdsLoader.OverlayInfo(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        PlayerControlView playerControlView = this.i;
        if (playerControlView != null) {
            arrayList.add(new AdsLoader.OverlayInfo(playerControlView, 0));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider
    public /* synthetic */ View[] getAdOverlayViews() {
        return f.$default$getAdOverlayViews(this);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider
    public ViewGroup getAdViewGroup() {
        return (ViewGroup) Assertions.checkStateNotNull(this.j, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.w;
    }

    public boolean getControllerHideOnTouch() {
        return this.y;
    }

    public int getControllerShowTimeoutMs() {
        return this.v;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.p;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.k;
    }

    @Nullable
    public Player getPlayer() {
        return this.l;
    }

    public int getResizeMode() {
        Assertions.checkStateNotNull(this.b);
        return this.b.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f;
    }

    public boolean getUseArtwork() {
        return this.o;
    }

    public boolean getUseController() {
        return this.m;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.d;
    }

    public final void h(boolean z2) {
        if (n()) {
            this.i.setShowTimeoutMs(z2 ? 0 : this.v);
            this.i.show();
        }
    }

    public void hideController() {
        PlayerControlView playerControlView = this.i;
        if (playerControlView != null) {
            playerControlView.hide();
        }
    }

    public final boolean i() {
        if (!n() || this.l == null) {
            return false;
        }
        if (!this.i.isVisible()) {
            e(true);
        } else if (this.y) {
            this.i.hide();
        }
        return true;
    }

    public boolean isControllerVisible() {
        PlayerControlView playerControlView = this.i;
        return playerControlView != null && playerControlView.isVisible();
    }

    public final void j() {
        int i2;
        if (this.g != null) {
            Player player = this.l;
            boolean z2 = true;
            int i3 = 0;
            if (player == null || player.getPlaybackState() != 2 || ((i2 = this.q) != 2 && (i2 != 1 || !this.l.getPlayWhenReady()))) {
                z2 = false;
            }
            View view = this.g;
            if (!z2) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public final void k() {
        PlayerControlView playerControlView = this.i;
        String str = null;
        if (playerControlView == null || !this.m) {
            setContentDescription(null);
        } else if (playerControlView.getVisibility() == 0) {
            if (this.y) {
                str = getResources().getString(R.string.exo_controls_hide);
            }
            setContentDescription(str);
        } else {
            setContentDescription(getResources().getString(R.string.exo_controls_show));
        }
    }

    public final void l() {
        ErrorMessageProvider<? super ExoPlaybackException> errorMessageProvider;
        TextView textView = this.h;
        if (textView != null) {
            CharSequence charSequence = this.u;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.h.setVisibility(0);
                return;
            }
            Player player = this.l;
            ExoPlaybackException playerError = player != null ? player.getPlayerError() : null;
            if (playerError == null || (errorMessageProvider = this.t) == null) {
                this.h.setVisibility(8);
                return;
            }
            this.h.setText((CharSequence) errorMessageProvider.getErrorMessage(playerError).second);
            this.h.setVisibility(0);
        }
    }

    public final void m(boolean z2) {
        boolean z3;
        byte[] bArr;
        int i2;
        Player player = this.l;
        if (player != null && !player.getCurrentTrackGroups().isEmpty()) {
            if (z2 && !this.r) {
                b();
            }
            TrackSelectionArray currentTrackSelections = player.getCurrentTrackSelections();
            for (int i3 = 0; i3 < currentTrackSelections.length; i3++) {
                if (player.getRendererType(i3) == 2 && currentTrackSelections.get(i3) != null) {
                    c();
                    return;
                }
            }
            b();
            if (this.o) {
                Assertions.checkStateNotNull(this.e);
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                for (int i4 = 0; i4 < currentTrackSelections.length; i4++) {
                    TrackSelection trackSelection = currentTrackSelections.get(i4);
                    if (trackSelection != null) {
                        for (int i5 = 0; i5 < trackSelection.length(); i5++) {
                            Metadata metadata = trackSelection.getFormat(i5).metadata;
                            if (metadata != null) {
                                int i6 = -1;
                                boolean z4 = false;
                                for (int i7 = 0; i7 < metadata.length(); i7++) {
                                    Metadata.Entry entry = metadata.get(i7);
                                    if (entry instanceof ApicFrame) {
                                        ApicFrame apicFrame = (ApicFrame) entry;
                                        bArr = apicFrame.pictureData;
                                        i2 = apicFrame.pictureType;
                                    } else if (entry instanceof PictureFrame) {
                                        PictureFrame pictureFrame = (PictureFrame) entry;
                                        bArr = pictureFrame.pictureData;
                                        i2 = pictureFrame.pictureType;
                                    } else {
                                        continue;
                                    }
                                    if (i6 == -1 || i2 == 3) {
                                        z4 = f(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                                        if (i2 == 3) {
                                            break;
                                        }
                                        i6 = i2;
                                    }
                                }
                                if (z4) {
                                    return;
                                }
                            }
                        }
                        continue;
                    }
                }
                if (f(this.p)) {
                    return;
                }
            }
            c();
        } else if (!this.r) {
            c();
            b();
        }
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = true)
    public final boolean n() {
        if (!this.m) {
            return false;
        }
        Assertions.checkStateNotNull(this.i);
        return true;
    }

    public void onContentAspectRatioChanged(float f2, @Nullable AspectRatioFrameLayout aspectRatioFrameLayout, @Nullable View view) {
        if (aspectRatioFrameLayout != null) {
            if (view instanceof SphericalGLSurfaceView) {
                f2 = 0.0f;
            }
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    public void onPause() {
        View view = this.d;
        if (view instanceof SphericalGLSurfaceView) {
            ((SphericalGLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.d;
        if (view instanceof SphericalGLSurfaceView) {
            ((SphericalGLSurfaceView) view).onResume();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!n() || this.l == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.A = true;
            return true;
        } else if (action != 1 || !this.A) {
            return false;
        } else {
            this.A = false;
            performClick();
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!n() || this.l == null) {
            return false;
        }
        e(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return i();
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.checkStateNotNull(this.b);
        this.b.setAspectRatioListener(aspectRatioListener);
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher) {
        Assertions.checkStateNotNull(this.i);
        this.i.setControlDispatcher(controlDispatcher);
    }

    public void setControllerAutoShow(boolean z2) {
        this.w = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.x = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        Assertions.checkStateNotNull(this.i);
        this.y = z2;
        k();
    }

    public void setControllerShowTimeoutMs(int i2) {
        Assertions.checkStateNotNull(this.i);
        this.v = i2;
        if (this.i.isVisible()) {
            showController();
        }
    }

    public void setControllerVisibilityListener(@Nullable PlayerControlView.VisibilityListener visibilityListener) {
        Assertions.checkStateNotNull(this.i);
        PlayerControlView.VisibilityListener visibilityListener2 = this.n;
        if (visibilityListener2 != visibilityListener) {
            if (visibilityListener2 != null) {
                this.i.removeVisibilityListener(visibilityListener2);
            }
            this.n = visibilityListener;
            if (visibilityListener != null) {
                this.i.addVisibilityListener(visibilityListener);
            }
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        Assertions.checkState(this.h != null);
        this.u = charSequence;
        l();
    }

    @Deprecated
    public void setDefaultArtwork(@Nullable Bitmap bitmap) {
        setDefaultArtwork(bitmap == null ? null : new BitmapDrawable(getResources(), bitmap));
    }

    public void setErrorMessageProvider(@Nullable ErrorMessageProvider<? super ExoPlaybackException> errorMessageProvider) {
        if (this.t != errorMessageProvider) {
            this.t = errorMessageProvider;
            l();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        Assertions.checkStateNotNull(this.i);
        this.i.setExtraAdGroupMarkers(jArr, zArr);
    }

    @Deprecated
    public void setFastForwardIncrementMs(int i2) {
        Assertions.checkStateNotNull(this.i);
        this.i.setFastForwardIncrementMs(i2);
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            m(false);
        }
    }

    @Deprecated
    public void setPlaybackPreparer(@Nullable PlaybackPreparer playbackPreparer) {
        Assertions.checkStateNotNull(this.i);
        this.i.setPlaybackPreparer(playbackPreparer);
    }

    public void setPlayer(@Nullable Player player) {
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        Assertions.checkArgument(player == null || player.getApplicationLooper() == Looper.getMainLooper());
        Player player2 = this.l;
        if (player2 != player) {
            if (player2 != null) {
                player2.removeListener(this.a);
                Player.VideoComponent videoComponent = player2.getVideoComponent();
                if (videoComponent != null) {
                    videoComponent.removeVideoListener(this.a);
                    View view = this.d;
                    if (view instanceof TextureView) {
                        videoComponent.clearVideoTextureView((TextureView) view);
                    } else if (view instanceof SphericalGLSurfaceView) {
                        ((SphericalGLSurfaceView) view).setVideoComponent(null);
                    } else if (view instanceof VideoDecoderGLSurfaceView) {
                        videoComponent.setVideoDecoderOutputBufferRenderer(null);
                    } else if (view instanceof SurfaceView) {
                        videoComponent.clearVideoSurfaceView((SurfaceView) view);
                    }
                }
                Player.TextComponent textComponent = player2.getTextComponent();
                if (textComponent != null) {
                    textComponent.removeTextOutput(this.a);
                }
            }
            SubtitleView subtitleView = this.f;
            if (subtitleView != null) {
                subtitleView.setCues(null);
            }
            this.l = player;
            if (n()) {
                this.i.setPlayer(player);
            }
            j();
            l();
            m(true);
            if (player != null) {
                Player.VideoComponent videoComponent2 = player.getVideoComponent();
                if (videoComponent2 != null) {
                    View view2 = this.d;
                    if (view2 instanceof TextureView) {
                        videoComponent2.setVideoTextureView((TextureView) view2);
                    } else if (view2 instanceof SphericalGLSurfaceView) {
                        ((SphericalGLSurfaceView) view2).setVideoComponent(videoComponent2);
                    } else if (view2 instanceof VideoDecoderGLSurfaceView) {
                        videoComponent2.setVideoDecoderOutputBufferRenderer(((VideoDecoderGLSurfaceView) view2).getVideoDecoderOutputBufferRenderer());
                    } else if (view2 instanceof SurfaceView) {
                        videoComponent2.setVideoSurfaceView((SurfaceView) view2);
                    }
                    videoComponent2.addVideoListener(this.a);
                }
                Player.TextComponent textComponent2 = player.getTextComponent();
                if (textComponent2 != null) {
                    textComponent2.addTextOutput(this.a);
                    SubtitleView subtitleView2 = this.f;
                    if (subtitleView2 != null) {
                        subtitleView2.setCues(textComponent2.getCurrentCues());
                    }
                }
                player.addListener(this.a);
                e(false);
                return;
            }
            hideController();
        }
    }

    public void setRepeatToggleModes(int i2) {
        Assertions.checkStateNotNull(this.i);
        this.i.setRepeatToggleModes(i2);
    }

    public void setResizeMode(int i2) {
        Assertions.checkStateNotNull(this.b);
        this.b.setResizeMode(i2);
    }

    @Deprecated
    public void setRewindIncrementMs(int i2) {
        Assertions.checkStateNotNull(this.i);
        this.i.setRewindIncrementMs(i2);
    }

    @Deprecated
    public void setShowBuffering(boolean z2) {
        setShowBuffering(z2 ? 1 : 0);
    }

    public void setShowFastForwardButton(boolean z2) {
        Assertions.checkStateNotNull(this.i);
        this.i.setShowFastForwardButton(z2);
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        Assertions.checkStateNotNull(this.i);
        this.i.setShowMultiWindowTimeBar(z2);
    }

    public void setShowNextButton(boolean z2) {
        Assertions.checkStateNotNull(this.i);
        this.i.setShowNextButton(z2);
    }

    public void setShowPreviousButton(boolean z2) {
        Assertions.checkStateNotNull(this.i);
        this.i.setShowPreviousButton(z2);
    }

    public void setShowRewindButton(boolean z2) {
        Assertions.checkStateNotNull(this.i);
        this.i.setShowRewindButton(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        Assertions.checkStateNotNull(this.i);
        this.i.setShowShuffleButton(z2);
    }

    public void setShutterBackgroundColor(int i2) {
        View view = this.c;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void setUseArtwork(boolean z2) {
        Assertions.checkState(!z2 || this.e != null);
        if (this.o != z2) {
            this.o = z2;
            m(false);
        }
    }

    public void setUseController(boolean z2) {
        Assertions.checkState(!z2 || this.i != null);
        if (this.m != z2) {
            this.m = z2;
            if (n()) {
                this.i.setPlayer(this.l);
            } else {
                PlayerControlView playerControlView = this.i;
                if (playerControlView != null) {
                    playerControlView.hide();
                    this.i.setPlayer(null);
                }
            }
            k();
        }
    }

    public void setUseSensorRotation(boolean z2) {
        if (this.s != z2) {
            this.s = z2;
            View view = this.d;
            if (view instanceof SphericalGLSurfaceView) {
                ((SphericalGLSurfaceView) view).setUseSensorRotation(z2);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        View view = this.d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i2);
        }
    }

    public void showController() {
        h(g());
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setShowBuffering(int i2) {
        if (this.q != i2) {
            this.q = i2;
            j();
        }
    }

    /* JADX INFO: finally extract failed */
    public PlayerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        int i7;
        int i8;
        boolean z7;
        boolean z8;
        a aVar = new a();
        this.a = aVar;
        if (isInEditMode()) {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            ImageView imageView = new ImageView(context);
            if (Util.SDK_INT >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(resources.getDrawable(R.drawable.exo_edit_mode_logo, null));
                imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color, null));
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(resources2.getDrawable(R.drawable.exo_edit_mode_logo));
                imageView.setBackgroundColor(resources2.getColor(R.color.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i9 = R.layout.exo_player_view;
        this.s = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PlayerView, 0, 0);
            try {
                int i10 = R.styleable.PlayerView_shutter_background_color;
                boolean hasValue = obtainStyledAttributes.hasValue(i10);
                int color = obtainStyledAttributes.getColor(i10, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PlayerView_player_layout_id, i9);
                boolean z9 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.PlayerView_default_artwork, 0);
                boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_controller, true);
                int i11 = obtainStyledAttributes.getInt(R.styleable.PlayerView_surface_type, 1);
                int i12 = obtainStyledAttributes.getInt(R.styleable.PlayerView_resize_mode, 0);
                int i13 = obtainStyledAttributes.getInt(R.styleable.PlayerView_show_timeout, 5000);
                boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_hide_on_touch, true);
                boolean z12 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_auto_show, true);
                i8 = obtainStyledAttributes.getInteger(R.styleable.PlayerView_show_buffering, 0);
                this.r = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_keep_content_on_player_reset, this.r);
                boolean z13 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_hide_during_ads, true);
                this.s = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_sensor_rotation, this.s);
                obtainStyledAttributes.recycle();
                i6 = i11;
                i9 = resourceId;
                z8 = z12;
                i3 = i13;
                z2 = z10;
                z7 = z13;
                i4 = resourceId2;
                z3 = z9;
                z4 = hasValue;
                i5 = color;
                z5 = z11;
                i7 = i12;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z8 = true;
            z7 = true;
            i8 = 0;
            i7 = 0;
            i6 = 1;
            z5 = true;
            i5 = 0;
            z4 = false;
            z3 = true;
            i4 = 0;
            i3 = 5000;
            z2 = true;
        }
        LayoutInflater.from(context).inflate(i9, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.exo_content_frame);
        this.b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i7);
        }
        View findViewById = findViewById(R.id.exo_shutter);
        this.c = findViewById;
        if (findViewById != null && z4) {
            findViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout == null || i6 == 0) {
            this.d = null;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i6 == 2) {
                this.d = new TextureView(context);
            } else if (i6 == 3) {
                SphericalGLSurfaceView sphericalGLSurfaceView = new SphericalGLSurfaceView(context);
                sphericalGLSurfaceView.setSingleTapListener(aVar);
                sphericalGLSurfaceView.setUseSensorRotation(this.s);
                this.d = sphericalGLSurfaceView;
            } else if (i6 != 4) {
                this.d = new SurfaceView(context);
            } else {
                this.d = new VideoDecoderGLSurfaceView(context);
            }
            this.d.setLayoutParams(layoutParams);
            aspectRatioFrameLayout.addView(this.d, 0);
        }
        this.j = (FrameLayout) findViewById(R.id.exo_ad_overlay);
        this.k = (FrameLayout) findViewById(R.id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_artwork);
        this.e = imageView2;
        this.o = z3 && imageView2 != null;
        if (i4 != 0) {
            this.p = ContextCompat.getDrawable(getContext(), i4);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.exo_subtitles);
        this.f = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View findViewById2 = findViewById(R.id.exo_buffering);
        this.g = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.q = i8;
        TextView textView = (TextView) findViewById(R.id.exo_error_message);
        this.h = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i14 = R.id.exo_controller;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i14);
        View findViewById3 = findViewById(R.id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.i = playerControlView;
        } else if (findViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.i = playerControlView2;
            playerControlView2.setId(i14);
            playerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(playerControlView2, indexOfChild);
        } else {
            this.i = null;
        }
        PlayerControlView playerControlView3 = this.i;
        this.v = playerControlView3 != null ? i3 : 0;
        this.y = z5;
        this.w = z8;
        this.x = z7;
        this.m = z2 && playerControlView3 != null;
        hideController();
        k();
        PlayerControlView playerControlView4 = this.i;
        if (playerControlView4 != null) {
            playerControlView4.addVisibilityListener(aVar);
        }
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.p != drawable) {
            this.p = drawable;
            m(false);
        }
    }
}
