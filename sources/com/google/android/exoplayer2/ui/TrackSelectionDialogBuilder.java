package com.google.android.exoplayer2.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public final class TrackSelectionDialogBuilder {
    public final Context a;
    @StyleRes
    public int b;
    public final CharSequence c;
    public final MappingTrackSelector.MappedTrackInfo d;
    public final int e;
    public final DialogCallback f;
    public boolean g;
    public boolean h;
    public boolean i;
    @Nullable
    public TrackNameProvider j;
    public boolean k;
    public List<DefaultTrackSelector.SelectionOverride> l;
    @Nullable
    public Comparator<Format> m;

    public interface DialogCallback {
        void onTracksSelected(boolean z, List<DefaultTrackSelector.SelectionOverride> list);
    }

    public TrackSelectionDialogBuilder(Context context, CharSequence charSequence, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int i2, DialogCallback dialogCallback) {
        this.a = context;
        this.c = charSequence;
        this.d = mappedTrackInfo;
        this.e = i2;
        this.f = dialogCallback;
        this.l = Collections.emptyList();
    }

    public final DialogInterface.OnClickListener a(View view) {
        TrackSelectionView trackSelectionView = (TrackSelectionView) view.findViewById(R.id.exo_track_selection_view);
        trackSelectionView.setAllowMultipleOverrides(this.h);
        trackSelectionView.setAllowAdaptiveSelections(this.g);
        trackSelectionView.setShowDisableOption(this.i);
        TrackNameProvider trackNameProvider = this.j;
        if (trackNameProvider != null) {
            trackSelectionView.setTrackNameProvider(trackNameProvider);
        }
        trackSelectionView.init(this.d, this.e, this.k, this.l, this.m, null);
        return new DialogInterface.OnClickListener(trackSelectionView) { // from class: a2.j.b.b.c1.d0
            public final /* synthetic */ TrackSelectionView b;

            {
                this.b = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                TrackSelectionDialogBuilder trackSelectionDialogBuilder = TrackSelectionDialogBuilder.this;
                TrackSelectionView trackSelectionView2 = this.b;
                trackSelectionDialogBuilder.f.onTracksSelected(trackSelectionView2.getIsDisabled(), trackSelectionView2.getOverrides());
            }
        };
    }

    public Dialog build() {
        Dialog dialog;
        try {
            Class<?> cls = Class.forName("androidx.appcompat.app.AlertDialog$Builder");
            Class<?> cls2 = Integer.TYPE;
            Object newInstance = cls.getConstructor(Context.class, cls2).newInstance(this.a, Integer.valueOf(this.b));
            View inflate = LayoutInflater.from((Context) cls.getMethod("getContext", new Class[0]).invoke(newInstance, new Object[0])).inflate(R.layout.exo_track_selection_dialog, (ViewGroup) null);
            DialogInterface.OnClickListener a3 = a(inflate);
            cls.getMethod("setTitle", CharSequence.class).invoke(newInstance, this.c);
            cls.getMethod("setView", View.class).invoke(newInstance, inflate);
            cls.getMethod("setPositiveButton", cls2, DialogInterface.OnClickListener.class).invoke(newInstance, 17039370, a3);
            cls.getMethod("setNegativeButton", cls2, DialogInterface.OnClickListener.class).invoke(newInstance, 17039360, null);
            dialog = (Dialog) cls.getMethod("create", new Class[0]).invoke(newInstance, new Object[0]);
        } catch (ClassNotFoundException unused) {
            dialog = null;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
        if (dialog != null) {
            return dialog;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a, this.b);
        View inflate2 = LayoutInflater.from(builder.getContext()).inflate(R.layout.exo_track_selection_dialog, (ViewGroup) null);
        return builder.setTitle(this.c).setView(inflate2).setPositiveButton(17039370, a(inflate2)).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).create();
    }

    public TrackSelectionDialogBuilder setAllowAdaptiveSelections(boolean z) {
        this.g = z;
        return this;
    }

    public TrackSelectionDialogBuilder setAllowMultipleOverrides(boolean z) {
        this.h = z;
        return this;
    }

    public TrackSelectionDialogBuilder setIsDisabled(boolean z) {
        this.k = z;
        return this;
    }

    public TrackSelectionDialogBuilder setOverride(@Nullable DefaultTrackSelector.SelectionOverride selectionOverride) {
        return setOverrides(selectionOverride == null ? Collections.emptyList() : Collections.singletonList(selectionOverride));
    }

    public TrackSelectionDialogBuilder setOverrides(List<DefaultTrackSelector.SelectionOverride> list) {
        this.l = list;
        return this;
    }

    public TrackSelectionDialogBuilder setShowDisableOption(boolean z) {
        this.i = z;
        return this;
    }

    public TrackSelectionDialogBuilder setTheme(@StyleRes int i2) {
        this.b = i2;
        return this;
    }

    public void setTrackFormatComparator(@Nullable Comparator<Format> comparator) {
        this.m = comparator;
    }

    public TrackSelectionDialogBuilder setTrackNameProvider(@Nullable TrackNameProvider trackNameProvider) {
        this.j = trackNameProvider;
        return this;
    }

    public TrackSelectionDialogBuilder(Context context, CharSequence charSequence, DefaultTrackSelector defaultTrackSelector, int i2) {
        this.a = context;
        this.c = charSequence;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo = (MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(defaultTrackSelector.getCurrentMappedTrackInfo());
        this.d = mappedTrackInfo;
        this.e = i2;
        TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i2);
        DefaultTrackSelector.Parameters parameters = defaultTrackSelector.getParameters();
        this.k = parameters.getRendererDisabled(i2);
        DefaultTrackSelector.SelectionOverride selectionOverride = parameters.getSelectionOverride(i2, trackGroups);
        this.l = selectionOverride == null ? Collections.emptyList() : Collections.singletonList(selectionOverride);
        this.f = new DialogCallback(parameters, i2, trackGroups) { // from class: a2.j.b.b.c1.c0
            public final /* synthetic */ DefaultTrackSelector.Parameters b;
            public final /* synthetic */ int c;
            public final /* synthetic */ TrackGroupArray d;

            {
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder.DialogCallback
            public final void onTracksSelected(boolean z, List list) {
                DefaultTrackSelector.this.setParameters(TrackSelectionUtil.updateParametersWithOverride(this.b, this.c, this.d, z, list.isEmpty() ? null : (DefaultTrackSelector.SelectionOverride) list.get(0)));
            }
        };
    }
}
