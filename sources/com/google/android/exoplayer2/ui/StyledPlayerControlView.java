package com.google.android.exoplayer2.ui;

import a2.j.b.b.c1.i0;
import a2.j.b.b.c1.l;
import a2.j.b.b.k0;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
public class StyledPlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    public final Drawable A;
    public j A0;
    public final Drawable B;
    public TrackNameProvider B0;
    public final float C;
    @Nullable
    public ImageView C0;
    public final float D;
    @Nullable
    public ImageView D0;
    public final String E;
    @Nullable
    public View E0;
    public final String F;
    public final Drawable G;
    public final Drawable H;
    public final String I;
    public final String J;
    public final Drawable K;
    public final Drawable L;
    public final String M;
    public final String N;
    @Nullable
    public Player O;
    public ControlDispatcher P;
    @Nullable
    public ProgressUpdateListener Q;
    @Nullable
    public PlaybackPreparer R;
    @Nullable
    public OnFullScreenModeChangedListener S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public final c a;
    public boolean a0;
    public final CopyOnWriteArrayList<VisibilityListener> b;
    public int b0;
    @Nullable
    public final View c;
    public int c0;
    @Nullable
    public final View d;
    public int d0;
    @Nullable
    public final View e;
    public long[] e0;
    @Nullable
    public final View f;
    public boolean[] f0;
    @Nullable
    public final View g;
    public long[] g0;
    @Nullable
    public final TextView h;
    public boolean[] h0;
    @Nullable
    public final TextView i;
    public long i0;
    @Nullable
    public final ImageView j;
    public long j0;
    @Nullable
    public final ImageView k;
    public long k0;
    @Nullable
    public final View l;
    public i0 l0;
    @Nullable
    public final TextView m;
    public Resources m0;
    @Nullable
    public final TextView n;
    public int n0;
    @Nullable
    public final TimeBar o;
    public RecyclerView o0;
    public final StringBuilder p;
    public e p0;
    public final Formatter q;
    public g q0;
    public final Timeline.Period r;
    public PopupWindow r0;
    public final Timeline.Window s;
    public List<String> s0;
    public final Runnable t;
    public List<Integer> t0;
    public final Drawable u;
    public int u0;
    public final Drawable v;
    public int v0;
    public final Drawable w;
    public boolean w0;
    public final String x;
    public int x0;
    public final String y;
    @Nullable
    public DefaultTrackSelector y0;
    public final String z;
    public j z0;

    public interface OnFullScreenModeChangedListener {
        void onFullScreenModeChanged(boolean z);
    }

    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    public final class b extends j {
        public b(a aVar) {
            super();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.j
        public void a(List<Integer> list, List<i> list2, MappingTrackSelector.MappedTrackInfo mappedTrackInfo) {
            boolean z;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    z = false;
                    break;
                }
                int intValue = list.get(i2).intValue();
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(intValue);
                DefaultTrackSelector defaultTrackSelector = StyledPlayerControlView.this.y0;
                if (defaultTrackSelector != null && defaultTrackSelector.getParameters().hasSelectionOverride(intValue, trackGroups)) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!list2.isEmpty()) {
                if (z) {
                    while (true) {
                        if (i >= list2.size()) {
                            break;
                        }
                        i iVar = list2.get(i);
                        if (iVar.e) {
                            e eVar = StyledPlayerControlView.this.p0;
                            eVar.d[1] = iVar.d;
                            break;
                        }
                        i++;
                    }
                } else {
                    StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                    e eVar2 = styledPlayerControlView.p0;
                    eVar2.d[1] = styledPlayerControlView.getResources().getString(R.string.exo_track_selection_auto);
                }
            } else {
                StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                e eVar3 = styledPlayerControlView2.p0;
                eVar3.d[1] = styledPlayerControlView2.getResources().getString(R.string.exo_track_selection_none);
            }
            this.c = list;
            this.d = list2;
            this.e = mappedTrackInfo;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.j
        public void c(k kVar) {
            boolean z;
            kVar.s.setText(R.string.exo_track_selection_auto);
            DefaultTrackSelector.Parameters parameters = ((DefaultTrackSelector) Assertions.checkNotNull(StyledPlayerControlView.this.y0)).getParameters();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= this.c.size()) {
                    z = false;
                    break;
                }
                int intValue = this.c.get(i2).intValue();
                if (parameters.hasSelectionOverride(intValue, ((MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(this.e)).getTrackGroups(intValue))) {
                    z = true;
                    break;
                }
                i2++;
            }
            View view = kVar.t;
            if (z) {
                i = 4;
            }
            view.setVisibility(i);
            kVar.itemView.setOnClickListener(new a2.j.b.b.c1.h(this));
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.j
        public void d(String str) {
            StyledPlayerControlView.this.p0.d[1] = str;
        }
    }

    public final class c implements Player.EventListener, TimeBar.OnScrubListener, View.OnClickListener, PopupWindow.OnDismissListener {
        public c(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            Player player = styledPlayerControlView.O;
            if (player != null) {
                styledPlayerControlView.l0.h();
                StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                if (styledPlayerControlView2.d == view) {
                    styledPlayerControlView2.P.dispatchNext(player);
                } else if (styledPlayerControlView2.c == view) {
                    styledPlayerControlView2.P.dispatchPrevious(player);
                } else if (styledPlayerControlView2.f == view) {
                    if (player.getPlaybackState() != 4) {
                        StyledPlayerControlView.this.P.dispatchFastForward(player);
                    }
                } else if (styledPlayerControlView2.g == view) {
                    styledPlayerControlView2.P.dispatchRewind(player);
                } else if (styledPlayerControlView2.e == view) {
                    styledPlayerControlView2.c(player);
                } else if (styledPlayerControlView2.j == view) {
                    styledPlayerControlView2.P.dispatchSetRepeatMode(player, RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), StyledPlayerControlView.this.d0));
                } else if (styledPlayerControlView2.k == view) {
                    styledPlayerControlView2.P.dispatchSetShuffleModeEnabled(player, !player.getShuffleModeEnabled());
                } else if (styledPlayerControlView2.E0 == view) {
                    styledPlayerControlView2.l0.g();
                    StyledPlayerControlView styledPlayerControlView3 = StyledPlayerControlView.this;
                    styledPlayerControlView3.d(styledPlayerControlView3.p0);
                } else if (styledPlayerControlView2.C0 == view) {
                    styledPlayerControlView2.l0.g();
                    StyledPlayerControlView styledPlayerControlView4 = StyledPlayerControlView.this;
                    styledPlayerControlView4.d(styledPlayerControlView4.z0);
                }
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            if (styledPlayerControlView.w0) {
                styledPlayerControlView.l0.h();
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
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            int i = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.j();
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
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            int i2 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.i();
            StyledPlayerControlView.this.j();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            int i = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.l();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            int i2 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.i();
            StyledPlayerControlView.this.j();
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
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            int i2 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.h();
            StyledPlayerControlView.this.o();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            int i2 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.k();
            StyledPlayerControlView.this.h();
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubMove(TimeBar timeBar, long j) {
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            TextView textView = styledPlayerControlView.n;
            if (textView != null) {
                textView.setText(Util.getStringForTime(styledPlayerControlView.p, styledPlayerControlView.q, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStart(TimeBar timeBar, long j) {
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            styledPlayerControlView.a0 = true;
            TextView textView = styledPlayerControlView.n;
            if (textView != null) {
                textView.setText(Util.getStringForTime(styledPlayerControlView.p, styledPlayerControlView.q, j));
            }
            StyledPlayerControlView.this.l0.g();
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStop(TimeBar timeBar, long j, boolean z) {
            Player player;
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            int i = 0;
            styledPlayerControlView.a0 = false;
            if (!z && (player = styledPlayerControlView.O) != null) {
                Timeline currentTimeline = player.getCurrentTimeline();
                if (styledPlayerControlView.W && !currentTimeline.isEmpty()) {
                    int windowCount = currentTimeline.getWindowCount();
                    while (true) {
                        long durationMs = currentTimeline.getWindow(i, styledPlayerControlView.s).getDurationMs();
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
                if (!styledPlayerControlView.P.dispatchSeekTo(player, i, j)) {
                    styledPlayerControlView.j();
                }
            }
            StyledPlayerControlView.this.l0.h();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            k0.$default$onSeekProcessed(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            int i = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.n();
            StyledPlayerControlView.this.h();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, int i) {
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            int i2 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.h();
            StyledPlayerControlView.this.o();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
            k0.$default$onTimelineChanged(this, timeline, obj, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            int i = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.p();
        }
    }

    public final class d extends RecyclerView.ViewHolder {
        public final TextView s;
        public final TextView t;
        public final ImageView u;

        public d(View view) {
            super(view);
            this.s = (TextView) view.findViewById(R.id.exo_main_text);
            this.t = (TextView) view.findViewById(R.id.exo_sub_text);
            this.u = (ImageView) view.findViewById(R.id.exo_icon);
            view.setOnClickListener(new a2.j.b.b.c1.i(this));
        }
    }

    public class e extends RecyclerView.Adapter<d> {
        public final String[] c;
        public final String[] d;
        public final Drawable[] e;

        public e(String[] strArr, Drawable[] drawableArr) {
            this.c = strArr;
            this.d = new String[strArr.length];
            this.e = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.c.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(d dVar, int i) {
            d dVar2 = dVar;
            dVar2.s.setText(this.c[i]);
            String[] strArr = this.d;
            if (strArr[i] == null) {
                dVar2.t.setVisibility(8);
            } else {
                dVar2.t.setText(strArr[i]);
            }
            Drawable[] drawableArr = this.e;
            if (drawableArr[i] == null) {
                dVar2.u.setVisibility(8);
            } else {
                dVar2.u.setImageDrawable(drawableArr[i]);
            }
        }

        /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public d onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new d(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R.layout.exo_styled_settings_list_item, (ViewGroup) null));
        }
    }

    public final class f extends RecyclerView.ViewHolder {
        public final TextView s;
        public final View t;

        public f(View view) {
            super(view);
            this.s = (TextView) view.findViewById(R.id.exo_text);
            this.t = view.findViewById(R.id.exo_check);
            view.setOnClickListener(new a2.j.b.b.c1.j(this));
        }
    }

    public class g extends RecyclerView.Adapter<f> {
        @Nullable
        public List<String> c;
        public int d;

        public g(a aVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<String> list = this.c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(f fVar, int i) {
            f fVar2 = fVar;
            List<String> list = this.c;
            if (list != null) {
                fVar2.s.setText(list.get(i));
            }
            fVar2.t.setVisibility(i == this.d ? 0 : 4);
        }

        /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public f onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new f(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, (ViewGroup) null));
        }
    }

    public final class h extends j {
        public h(a aVar) {
            super();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.j
        public void a(List<Integer> list, List<i> list2, MappingTrackSelector.MappedTrackInfo mappedTrackInfo) {
            Drawable drawable;
            String str;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= list2.size()) {
                    break;
                } else if (list2.get(i).e) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
            ImageView imageView = styledPlayerControlView.C0;
            if (imageView != null) {
                if (z) {
                    drawable = styledPlayerControlView.G;
                } else {
                    drawable = styledPlayerControlView.H;
                }
                imageView.setImageDrawable(drawable);
                StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                ImageView imageView2 = styledPlayerControlView2.C0;
                if (z) {
                    str = styledPlayerControlView2.I;
                } else {
                    str = styledPlayerControlView2.J;
                }
                imageView2.setContentDescription(str);
            }
            this.c = list;
            this.d = list2;
            this.e = mappedTrackInfo;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.j
        /* renamed from: b */
        public void onBindViewHolder(k kVar, int i) {
            super.onBindViewHolder(kVar, i);
            if (i > 0) {
                kVar.t.setVisibility(this.d.get(i + -1).e ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.j
        public void c(k kVar) {
            boolean z;
            kVar.s.setText(R.string.exo_track_selection_none);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= this.d.size()) {
                    z = true;
                    break;
                } else if (this.d.get(i2).e) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            View view = kVar.t;
            if (!z) {
                i = 4;
            }
            view.setVisibility(i);
            kVar.itemView.setOnClickListener(new a2.j.b.b.c1.k(this));
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.j
        public void d(String str) {
        }
    }

    public static final class i {
        public final int a;
        public final int b;
        public final int c;
        public final String d;
        public final boolean e;

        public i(int i, int i2, int i3, String str, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = str;
            this.e = z;
        }
    }

    public abstract class j extends RecyclerView.Adapter<k> {
        public List<Integer> c = new ArrayList();
        public List<i> d = new ArrayList();
        @Nullable
        public MappingTrackSelector.MappedTrackInfo e = null;

        public j() {
        }

        public abstract void a(List<Integer> list, List<i> list2, MappingTrackSelector.MappedTrackInfo mappedTrackInfo);

        /* renamed from: b */
        public void onBindViewHolder(k kVar, int i) {
            if (StyledPlayerControlView.this.y0 != null && this.e != null) {
                if (i == 0) {
                    c(kVar);
                    return;
                }
                boolean z = true;
                i iVar = this.d.get(i - 1);
                int i2 = 0;
                if (!((DefaultTrackSelector) Assertions.checkNotNull(StyledPlayerControlView.this.y0)).getParameters().hasSelectionOverride(iVar.a, this.e.getTrackGroups(iVar.a)) || !iVar.e) {
                    z = false;
                }
                kVar.s.setText(iVar.d);
                View view = kVar.t;
                if (!z) {
                    i2 = 4;
                }
                view.setVisibility(i2);
                kVar.itemView.setOnClickListener(new l(this, iVar));
            }
        }

        public abstract void c(k kVar);

        public abstract void d(String str);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.d.isEmpty()) {
                return 0;
            }
            return this.d.size() + 1;
        }

        /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public k onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new k(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, (ViewGroup) null));
        }
    }

    public static class k extends RecyclerView.ViewHolder {
        public final TextView s;
        public final View t;

        public k(View view) {
            super(view);
            this.s = (TextView) view.findViewById(R.id.exo_text);
            this.t = view.findViewById(R.id.exo_check);
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    public static void a(StyledPlayerControlView styledPlayerControlView, int i2) {
        if (styledPlayerControlView.n0 == 0 && i2 != styledPlayerControlView.v0) {
            styledPlayerControlView.setPlaybackSpeed(((float) styledPlayerControlView.t0.get(i2).intValue()) / 100.0f);
        }
        styledPlayerControlView.r0.dismiss();
    }

    private void setPlaybackSpeed(float f2) {
        Player player = this.O;
        if (player != null) {
            player.setPlaybackParameters(new PlaybackParameters(f2));
        }
    }

    public void addVisibilityListener(VisibilityListener visibilityListener) {
        Assertions.checkNotNull(visibilityListener);
        this.b.add(visibilityListener);
    }

    public final void b(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            PlaybackPreparer playbackPreparer = this.R;
            if (playbackPreparer != null) {
                playbackPreparer.preparePlayback();
            } else {
                this.P.dispatchPrepare(player);
            }
        } else if (playbackState == 4) {
            this.P.dispatchSeekTo(player, player.getCurrentWindowIndex(), C.TIME_UNSET);
        }
        this.P.dispatchSetPlayWhenReady(player, true);
    }

    public final void c(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !player.getPlayWhenReady()) {
            b(player);
        } else {
            this.P.dispatchSetPlayWhenReady(player, false);
        }
    }

    public final void d(RecyclerView.Adapter<?> adapter) {
        this.o0.setAdapter(adapter);
        m();
        this.w0 = false;
        this.r0.dismiss();
        this.w0 = true;
        this.r0.showAsDropDown(this, (getWidth() - this.r0.getWidth()) - this.x0, (-this.r0.getHeight()) - this.x0);
    }

    @Override // android.view.View, android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.O;
        if (player != null) {
            if (keyCode == 90 || keyCode == 89 || keyCode == 85 || keyCode == 79 || keyCode == 126 || keyCode == 127 || keyCode == 87 || keyCode == 88) {
                if (keyEvent.getAction() == 0) {
                    if (keyCode == 90) {
                        if (player.getPlaybackState() != 4) {
                            this.P.dispatchFastForward(player);
                        }
                    } else if (keyCode == 89) {
                        this.P.dispatchRewind(player);
                    } else if (keyEvent.getRepeatCount() == 0) {
                        if (keyCode == 79 || keyCode == 85) {
                            c(player);
                        } else if (keyCode == 87) {
                            this.P.dispatchNext(player);
                        } else if (keyCode == 88) {
                            this.P.dispatchPrevious(player);
                        } else if (keyCode == 126) {
                            b(player);
                        } else if (keyCode == 127) {
                            this.P.dispatchSetPlayWhenReady(player, false);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void e(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int i2, List<i> list) {
        TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i2);
        TrackSelection trackSelection = ((Player) Assertions.checkNotNull(this.O)).getCurrentTrackSelections().get(i2);
        for (int i3 = 0; i3 < trackGroups.length; i3++) {
            TrackGroup trackGroup = trackGroups.get(i3);
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                Format format = trackGroup.getFormat(i4);
                if (mappedTrackInfo.getTrackSupport(i2, i3, i4) == 4) {
                    list.add(new i(i2, i3, i4, this.B0.getTrackName(format), (trackSelection == null || trackSelection.indexOf(format) == -1) ? false : true));
                }
            }
        }
    }

    public void f() {
        i();
        h();
        k();
        n();
        p();
        o();
    }

    public final void g(boolean z2, @Nullable View view) {
        if (view != null) {
            view.setEnabled(z2);
            view.setAlpha(z2 ? this.C : this.D);
        }
    }

    @Nullable
    public Player getPlayer() {
        return this.O;
    }

    public int getRepeatToggleModes() {
        return this.d0;
    }

    public boolean getShowShuffleButton() {
        return this.l0.c(this.k);
    }

    public boolean getShowSubtitleButton() {
        return this.l0.c(this.C0);
    }

    public int getShowTimeoutMs() {
        return this.b0;
    }

    public boolean getShowVrButton() {
        return this.l0.c(this.l);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
        // Method dump skipped, instructions count: 249
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.StyledPlayerControlView.h():void");
    }

    public void hide() {
        i0 i0Var = this.l0;
        int i2 = i0Var.y;
        if (i2 != 3 && i2 != 2) {
            i0Var.g();
            if (!i0Var.B) {
                i0Var.j(2);
            } else if (i0Var.y == 1) {
                i0Var.l.start();
            } else {
                i0Var.m.start();
            }
        }
    }

    public void hideImmediately() {
        i0 i0Var = this.l0;
        int i2 = i0Var.y;
        if (i2 != 3 && i2 != 2) {
            i0Var.g();
            i0Var.j(2);
        }
    }

    public final void i() {
        if (isVisible() && this.U && this.e != null) {
            Player player = this.O;
            boolean z2 = true;
            if (player == null || player.getPlaybackState() == 4 || this.O.getPlaybackState() == 1 || !this.O.getPlayWhenReady()) {
                z2 = false;
            }
            if (z2) {
                ((ImageView) this.e).setImageDrawable(this.m0.getDrawable(R.drawable.exo_styled_controls_pause));
                this.e.setContentDescription(this.m0.getString(R.string.exo_controls_pause_description));
                return;
            }
            ((ImageView) this.e).setImageDrawable(this.m0.getDrawable(R.drawable.exo_styled_controls_play));
            this.e.setContentDescription(this.m0.getString(R.string.exo_controls_play_description));
        }
    }

    public boolean isAnimationEnabled() {
        return this.l0.B;
    }

    public boolean isFullyVisible() {
        i0 i0Var = this.l0;
        return i0Var.y == 0 && i0Var.a.isVisible();
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public final void j() {
        long j2;
        int i2;
        if (isVisible() && this.U) {
            Player player = this.O;
            long j3 = 0;
            if (player != null) {
                j3 = this.i0 + player.getContentPosition();
                j2 = this.i0 + player.getContentBufferedPosition();
            } else {
                j2 = 0;
            }
            TextView textView = this.n;
            if (textView != null && !this.a0) {
                textView.setText(Util.getStringForTime(this.p, this.q, j3));
            }
            TimeBar timeBar = this.o;
            if (timeBar != null) {
                timeBar.setPosition(j3);
                this.o.setBufferedPosition(j2);
            }
            ProgressUpdateListener progressUpdateListener = this.Q;
            if (progressUpdateListener != null) {
                progressUpdateListener.onProgressUpdate(j3, j2);
            }
            removeCallbacks(this.t);
            if (player == null) {
                i2 = 1;
            } else {
                i2 = player.getPlaybackState();
            }
            long j4 = 1000;
            if (player != null && player.isPlaying()) {
                TimeBar timeBar2 = this.o;
                long min = Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000, 1000 - (j3 % 1000));
                float f2 = player.getPlaybackParameters().speed;
                if (f2 > 0.0f) {
                    j4 = (long) (((float) min) / f2);
                }
                postDelayed(this.t, Util.constrainValue(j4, (long) this.c0, 1000));
            } else if (i2 != 4 && i2 != 1) {
                postDelayed(this.t, 1000);
            }
        }
    }

    public final void k() {
        ImageView imageView;
        if (isVisible() && this.U && (imageView = this.j) != null) {
            if (this.d0 == 0) {
                g(false, imageView);
                return;
            }
            Player player = this.O;
            if (player == null) {
                g(false, imageView);
                this.j.setImageDrawable(this.u);
                this.j.setContentDescription(this.x);
                return;
            }
            g(true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.j.setImageDrawable(this.u);
                this.j.setContentDescription(this.x);
            } else if (repeatMode == 1) {
                this.j.setImageDrawable(this.v);
                this.j.setContentDescription(this.y);
            } else if (repeatMode == 2) {
                this.j.setImageDrawable(this.w);
                this.j.setContentDescription(this.z);
            }
        }
    }

    public final void l() {
        Player player = this.O;
        if (player != null) {
            float f2 = player.getPlaybackParameters().speed;
            int round = Math.round(100.0f * f2);
            int indexOf = this.t0.indexOf(Integer.valueOf(round));
            if (indexOf == -1) {
                int i2 = this.u0;
                if (i2 != -1) {
                    this.t0.remove(i2);
                    this.s0.remove(this.u0);
                    this.u0 = -1;
                }
                indexOf = (-Collections.binarySearch(this.t0, Integer.valueOf(round))) - 1;
                String string = this.m0.getString(R.string.exo_controls_custom_playback_speed, Float.valueOf(f2));
                this.t0.add(indexOf, Integer.valueOf(round));
                this.s0.add(indexOf, string);
                this.u0 = indexOf;
            }
            this.v0 = indexOf;
            this.p0.d[0] = this.s0.get(indexOf);
        }
    }

    public final void m() {
        this.o0.measure(0, 0);
        this.r0.setWidth(Math.min(this.o0.getMeasuredWidth(), getWidth() - (this.x0 * 2)));
        this.r0.setHeight(Math.min(getHeight() - (this.x0 * 2), this.o0.getMeasuredHeight()));
    }

    public final void n() {
        ImageView imageView;
        String str;
        if (isVisible() && this.U && (imageView = this.k) != null) {
            Player player = this.O;
            if (!this.l0.c(imageView)) {
                g(false, this.k);
            } else if (player == null) {
                g(false, this.k);
                this.k.setImageDrawable(this.B);
                this.k.setContentDescription(this.F);
            } else {
                g(true, this.k);
                this.k.setImageDrawable(player.getShuffleModeEnabled() ? this.A : this.B);
                ImageView imageView2 = this.k;
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
    public final void o() {
        /*
        // Method dump skipped, instructions count: 356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.StyledPlayerControlView.o():void");
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i0 i0Var = this.l0;
        i0Var.a.addOnLayoutChangeListener(i0Var.w);
        this.U = true;
        if (isFullyVisible()) {
            this.l0.h();
        }
        f();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i0 i0Var = this.l0;
        i0Var.a.removeOnLayoutChangeListener(i0Var.w);
        this.U = false;
        removeCallbacks(this.t);
        this.l0.g();
    }

    public final void p() {
        DefaultTrackSelector defaultTrackSelector;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        j jVar = this.z0;
        Objects.requireNonNull(jVar);
        jVar.d = Collections.emptyList();
        jVar.e = null;
        j jVar2 = this.A0;
        Objects.requireNonNull(jVar2);
        jVar2.d = Collections.emptyList();
        jVar2.e = null;
        boolean z2 = false;
        if (!(this.O == null || (defaultTrackSelector = this.y0) == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i2 = 0; i2 < currentMappedTrackInfo.getRendererCount(); i2++) {
                if (currentMappedTrackInfo.getRendererType(i2) == 3 && this.l0.c(this.C0)) {
                    e(currentMappedTrackInfo, i2, arrayList);
                    arrayList3.add(Integer.valueOf(i2));
                } else if (currentMappedTrackInfo.getRendererType(i2) == 1) {
                    e(currentMappedTrackInfo, i2, arrayList2);
                    arrayList4.add(Integer.valueOf(i2));
                }
            }
            this.z0.a(arrayList3, arrayList, currentMappedTrackInfo);
            this.A0.a(arrayList4, arrayList2, currentMappedTrackInfo);
        }
        if (this.z0.getItemCount() > 0) {
            z2 = true;
        }
        g(z2, this.C0);
    }

    public void removeVisibilityListener(VisibilityListener visibilityListener) {
        this.b.remove(visibilityListener);
    }

    public void setAnimationEnabled(boolean z2) {
        this.l0.B = z2;
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher) {
        if (this.P != controlDispatcher) {
            this.P = controlDispatcher;
            h();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        boolean z2 = false;
        if (jArr == null) {
            this.g0 = new long[0];
            this.h0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) Assertions.checkNotNull(zArr);
            if (jArr.length == zArr2.length) {
                z2 = true;
            }
            Assertions.checkArgument(z2);
            this.g0 = jArr;
            this.h0 = zArr2;
        }
        o();
    }

    public void setOnFullScreenModeChangedListener(@Nullable OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        ImageView imageView = this.D0;
        if (imageView != null) {
            this.S = onFullScreenModeChangedListener;
            if (onFullScreenModeChangedListener == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
        }
    }

    @Deprecated
    public void setPlaybackPreparer(@Nullable PlaybackPreparer playbackPreparer) {
        this.R = playbackPreparer;
    }

    public void setPlayer(@Nullable Player player) {
        boolean z2 = true;
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        if (!(player == null || player.getApplicationLooper() == Looper.getMainLooper())) {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        Player player2 = this.O;
        if (player2 != player) {
            if (player2 != null) {
                player2.removeListener(this.a);
            }
            this.O = player;
            if (player != null) {
                player.addListener(this.a);
            }
            if (player == null || !(player.getTrackSelector() instanceof DefaultTrackSelector)) {
                this.y0 = null;
            } else {
                this.y0 = (DefaultTrackSelector) player.getTrackSelector();
            }
            f();
            l();
        }
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener) {
        this.Q = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i2) {
        this.d0 = i2;
        Player player = this.O;
        boolean z2 = false;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i2 == 0 && repeatMode != 0) {
                this.P.dispatchSetRepeatMode(this.O, 0);
            } else if (i2 == 1 && repeatMode == 2) {
                this.P.dispatchSetRepeatMode(this.O, 1);
            } else if (i2 == 2 && repeatMode == 1) {
                this.P.dispatchSetRepeatMode(this.O, 2);
            }
        }
        i0 i0Var = this.l0;
        ImageView imageView = this.j;
        if (i2 != 0) {
            z2 = true;
        }
        i0Var.i(imageView, z2);
        k();
    }

    public void setShowFastForwardButton(boolean z2) {
        this.l0.i(this.f, z2);
        h();
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        this.V = z2;
        o();
    }

    public void setShowNextButton(boolean z2) {
        this.l0.i(this.d, z2);
        h();
    }

    public void setShowPreviousButton(boolean z2) {
        this.l0.i(this.c, z2);
        h();
    }

    public void setShowRewindButton(boolean z2) {
        this.l0.i(this.g, z2);
        h();
    }

    public void setShowShuffleButton(boolean z2) {
        this.l0.i(this.k, z2);
        n();
    }

    public void setShowSubtitleButton(boolean z2) {
        this.l0.i(this.C0, z2);
    }

    public void setShowTimeoutMs(int i2) {
        this.b0 = i2;
        if (isFullyVisible()) {
            this.l0.h();
        }
    }

    public void setShowVrButton(boolean z2) {
        this.l0.i(this.l, z2);
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.c0 = Util.constrainValue(i2, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            g(onClickListener != null, this.l);
        }
    }

    public void show() {
        i0 i0Var = this.l0;
        if (!i0Var.a.isVisible()) {
            i0Var.a.setVisibility(0);
            i0Var.a.f();
            View view = i0Var.a.e;
            if (view != null) {
                view.requestFocus();
            }
        }
        i0Var.l();
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        c cVar;
        boolean z12;
        int i3 = R.layout.exo_styled_player_control_view;
        this.j0 = 5000;
        this.k0 = 15000;
        this.b0 = 5000;
        this.d0 = 0;
        this.c0 = 200;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.StyledPlayerControlView, 0, 0);
            try {
                this.j0 = (long) obtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_rewind_increment, (int) this.j0);
                this.k0 = (long) obtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_fastforward_increment, (int) this.k0);
                i3 = obtainStyledAttributes.getResourceId(R.styleable.StyledPlayerControlView_controller_layout_id, i3);
                this.b0 = obtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_show_timeout, this.b0);
                this.d0 = obtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_repeat_toggle_modes, this.d0);
                boolean z13 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z14 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z15 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z16 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_next_button, true);
                boolean z17 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z18 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z19 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_time_bar_min_update_interval, this.c0));
                boolean z20 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_animation_enabled, true);
                obtainStyledAttributes.recycle();
                z3 = z17;
                z2 = z18;
                z8 = z13;
                z7 = z14;
                z5 = z15;
                z10 = z20;
                z4 = z16;
                z9 = z19;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z10 = true;
            z9 = false;
            z8 = true;
            z7 = true;
            z5 = true;
            z4 = true;
            z3 = false;
            z2 = false;
        }
        LayoutInflater.from(context).inflate(i3, this);
        setDescendantFocusability(262144);
        c cVar2 = new c(null);
        this.a = cVar2;
        this.b = new CopyOnWriteArrayList<>();
        this.r = new Timeline.Period();
        this.s = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.p = sb;
        this.q = new Formatter(sb, Locale.getDefault());
        this.e0 = new long[0];
        this.f0 = new boolean[0];
        this.g0 = new long[0];
        this.h0 = new boolean[0];
        this.P = new DefaultControlDispatcher(this.k0, this.j0);
        this.t = new Runnable() { // from class: a2.j.b.b.c1.n
            @Override // java.lang.Runnable
            public final void run() {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                int i4 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
                styledPlayerControlView.j();
            }
        };
        this.m = (TextView) findViewById(R.id.exo_duration);
        this.n = (TextView) findViewById(R.id.exo_position);
        ImageView imageView = (ImageView) findViewById(R.id.exo_subtitle);
        this.C0 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar2);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_fullscreen);
        this.D0 = imageView2;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
            this.D0.setOnClickListener(new View.OnClickListener() { // from class: a2.j.b.b.c1.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImageView imageView3;
                    StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                    if (styledPlayerControlView.S != null && (imageView3 = styledPlayerControlView.D0) != null) {
                        boolean z21 = !styledPlayerControlView.T;
                        styledPlayerControlView.T = z21;
                        if (z21) {
                            imageView3.setImageDrawable(styledPlayerControlView.K);
                            styledPlayerControlView.D0.setContentDescription(styledPlayerControlView.M);
                        } else {
                            imageView3.setImageDrawable(styledPlayerControlView.L);
                            styledPlayerControlView.D0.setContentDescription(styledPlayerControlView.N);
                        }
                        StyledPlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener = styledPlayerControlView.S;
                        if (onFullScreenModeChangedListener != null) {
                            onFullScreenModeChangedListener.onFullScreenModeChanged(styledPlayerControlView.T);
                        }
                    }
                }
            });
        }
        View findViewById = findViewById(R.id.exo_settings);
        this.E0 = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(cVar2);
        }
        int i4 = R.id.exo_progress;
        TimeBar timeBar = (TimeBar) findViewById(i4);
        View findViewById2 = findViewById(R.id.exo_progress_placeholder);
        if (timeBar != null) {
            this.o = timeBar;
            cVar = cVar2;
            z11 = z10;
            z12 = z9;
        } else if (findViewById2 != null) {
            cVar = cVar2;
            z11 = z10;
            z12 = z9;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, R.style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(i4);
            defaultTimeBar.setLayoutParams(findViewById2.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById2.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById2);
            viewGroup.removeView(findViewById2);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.o = defaultTimeBar;
        } else {
            cVar = cVar2;
            z11 = z10;
            z12 = z9;
            this.o = null;
        }
        TimeBar timeBar2 = this.o;
        if (timeBar2 != null) {
            timeBar2.addListener(cVar);
        }
        View findViewById3 = findViewById(R.id.exo_play_pause);
        this.e = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(cVar);
        }
        View findViewById4 = findViewById(R.id.exo_prev);
        this.c = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(cVar);
        }
        View findViewById5 = findViewById(R.id.exo_next);
        this.d = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(cVar);
        }
        Typeface font = ResourcesCompat.getFont(context, R.font.roboto_medium_numbers);
        View findViewById6 = findViewById(R.id.exo_rew);
        TextView textView = findViewById6 == null ? (TextView) findViewById(R.id.exo_rew_with_amount) : null;
        this.i = textView;
        if (textView != null) {
            textView.setTypeface(font);
        }
        findViewById6 = findViewById6 == null ? textView : findViewById6;
        this.g = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(cVar);
        }
        View findViewById7 = findViewById(R.id.exo_ffwd);
        TextView textView2 = findViewById7 == null ? (TextView) findViewById(R.id.exo_ffwd_with_amount) : null;
        this.h = textView2;
        if (textView2 != null) {
            textView2.setTypeface(font);
        }
        findViewById7 = findViewById7 == null ? textView2 : findViewById7;
        this.f = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(cVar);
        }
        ImageView imageView3 = (ImageView) findViewById(R.id.exo_repeat_toggle);
        this.j = imageView3;
        if (imageView3 != null) {
            imageView3.setOnClickListener(cVar);
        }
        ImageView imageView4 = (ImageView) findViewById(R.id.exo_shuffle);
        this.k = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(cVar);
        }
        Resources resources = context.getResources();
        this.m0 = resources;
        this.C = ((float) resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled)) / 100.0f;
        this.D = ((float) this.m0.getInteger(R.integer.exo_media_button_opacity_percentage_disabled)) / 100.0f;
        View findViewById8 = findViewById(R.id.exo_vr);
        this.l = findViewById8;
        if (findViewById8 != null) {
            g(false, findViewById8);
        }
        i0 i0Var = new i0(this);
        this.l0 = i0Var;
        i0Var.B = z11;
        this.p0 = new e(new String[]{this.m0.getString(R.string.exo_controls_playback_speed), this.m0.getString(R.string.exo_track_selection_title_audio)}, new Drawable[]{this.m0.getDrawable(R.drawable.exo_styled_controls_speed), this.m0.getDrawable(R.drawable.exo_styled_controls_audiotrack)});
        this.s0 = new ArrayList(Arrays.asList(this.m0.getStringArray(R.array.exo_playback_speeds)));
        this.t0 = new ArrayList();
        for (int i5 : this.m0.getIntArray(R.array.exo_speed_multiplied_by_100)) {
            this.t0.add(Integer.valueOf(i5));
        }
        this.v0 = this.t0.indexOf(100);
        this.u0 = -1;
        this.x0 = this.m0.getDimensionPixelSize(R.dimen.exo_settings_offset);
        g gVar = new g(null);
        this.q0 = gVar;
        gVar.d = -1;
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.exo_styled_settings_list, (ViewGroup) null);
        this.o0 = recyclerView;
        recyclerView.setAdapter(this.p0);
        this.o0.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) this.o0, -2, -2, true);
        this.r0 = popupWindow;
        popupWindow.setOnDismissListener(this.a);
        this.w0 = true;
        this.B0 = new DefaultTrackNameProvider(getResources());
        this.G = this.m0.getDrawable(R.drawable.exo_styled_controls_subtitle_on);
        this.H = this.m0.getDrawable(R.drawable.exo_styled_controls_subtitle_off);
        this.I = this.m0.getString(R.string.exo_controls_cc_enabled_description);
        this.J = this.m0.getString(R.string.exo_controls_cc_disabled_description);
        this.z0 = new h(null);
        this.A0 = new b(null);
        this.K = this.m0.getDrawable(R.drawable.exo_styled_controls_fullscreen_exit);
        this.L = this.m0.getDrawable(R.drawable.exo_styled_controls_fullscreen_enter);
        this.u = this.m0.getDrawable(R.drawable.exo_styled_controls_repeat_off);
        this.v = this.m0.getDrawable(R.drawable.exo_styled_controls_repeat_one);
        this.w = this.m0.getDrawable(R.drawable.exo_styled_controls_repeat_all);
        this.A = this.m0.getDrawable(R.drawable.exo_styled_controls_shuffle_on);
        this.B = this.m0.getDrawable(R.drawable.exo_styled_controls_shuffle_off);
        this.M = this.m0.getString(R.string.exo_controls_fullscreen_exit_description);
        this.N = this.m0.getString(R.string.exo_controls_fullscreen_enter_description);
        this.x = this.m0.getString(R.string.exo_controls_repeat_off_description);
        this.y = this.m0.getString(R.string.exo_controls_repeat_one_description);
        this.z = this.m0.getString(R.string.exo_controls_repeat_all_description);
        this.E = this.m0.getString(R.string.exo_controls_shuffle_on_description);
        this.F = this.m0.getString(R.string.exo_controls_shuffle_off_description);
        this.l0.i((ViewGroup) findViewById(R.id.exo_bottom_bar), true);
        this.l0.i(this.f, z7);
        this.l0.i(this.g, z8);
        this.l0.i(this.c, z5);
        this.l0.i(this.d, z4);
        this.l0.i(this.k, z3);
        this.l0.i(this.C0, z2);
        this.l0.i(this.l, z12);
        this.l0.i(this.j, this.d0 != 0);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: a2.j.b.b.c1.o
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                int i14 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
                Objects.requireNonNull(styledPlayerControlView);
                int i15 = i9 - i7;
                int i16 = i13 - i11;
                if (!(i8 - i6 == i12 - i10 && i15 == i16) && styledPlayerControlView.r0.isShowing()) {
                    styledPlayerControlView.m();
                    styledPlayerControlView.r0.update(view, (styledPlayerControlView.getWidth() - styledPlayerControlView.r0.getWidth()) - styledPlayerControlView.x0, (-styledPlayerControlView.r0.getHeight()) - styledPlayerControlView.x0, -1, -1);
                }
            }
        });
    }
}
