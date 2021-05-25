package com.google.android.exoplayer2.ui;

import a2.j.b.b.c1.e0;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
public class TrackSelectionView extends LinearLayout {
    public static final /* synthetic */ int q = 0;
    public final int a;
    public final LayoutInflater b;
    public final CheckedTextView c;
    public final CheckedTextView d;
    public final b e;
    public final SparseArray<DefaultTrackSelector.SelectionOverride> f;
    public boolean g;
    public boolean h;
    public TrackNameProvider i;
    public CheckedTextView[][] j;
    public MappingTrackSelector.MappedTrackInfo k;
    public int l;
    public TrackGroupArray m;
    public boolean n;
    @Nullable
    public Comparator<c> o;
    @Nullable
    public TrackSelectionListener p;

    public interface TrackSelectionListener {
        void onTrackSelectionChanged(boolean z, List<DefaultTrackSelector.SelectionOverride> list);
    }

    public class b implements View.OnClickListener {
        public b(a aVar) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:37:0x00af  */
        @Override // android.view.View.OnClickListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r10) {
            /*
            // Method dump skipped, instructions count: 232
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.TrackSelectionView.b.onClick(android.view.View):void");
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final Format c;

        public c(int i, int i2, Format format) {
            this.a = i;
            this.b = i2;
            this.c = format;
        }
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    @RequiresNonNull({"mappedTrackInfo"})
    public final boolean a(int i2) {
        if (!this.g || this.m.get(i2).length <= 1 || this.k.getAdaptiveSupport(this.l, i2, false) == 0) {
            return false;
        }
        return true;
    }

    public final void b() {
        this.c.setChecked(this.n);
        this.d.setChecked(!this.n && this.f.size() == 0);
        for (int i2 = 0; i2 < this.j.length; i2++) {
            DefaultTrackSelector.SelectionOverride selectionOverride = this.f.get(i2);
            int i3 = 0;
            while (true) {
                CheckedTextView[][] checkedTextViewArr = this.j;
                if (i3 >= checkedTextViewArr[i2].length) {
                    break;
                }
                if (selectionOverride != null) {
                    this.j[i2][i3].setChecked(selectionOverride.containsTrack(((c) Assertions.checkNotNull(checkedTextViewArr[i2][i3].getTag())).b));
                } else {
                    checkedTextViewArr[i2][i3].setChecked(false);
                }
                i3++;
            }
        }
    }

    public final void c() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.k == null) {
            this.c.setEnabled(false);
            this.d.setEnabled(false);
            return;
        }
        this.c.setEnabled(true);
        this.d.setEnabled(true);
        TrackGroupArray trackGroups = this.k.getTrackGroups(this.l);
        this.m = trackGroups;
        int i2 = trackGroups.length;
        this.j = new CheckedTextView[i2][];
        boolean z = this.h && i2 > 1;
        int i3 = 0;
        while (true) {
            TrackGroupArray trackGroupArray = this.m;
            if (i3 < trackGroupArray.length) {
                TrackGroup trackGroup = trackGroupArray.get(i3);
                boolean a3 = a(i3);
                CheckedTextView[][] checkedTextViewArr = this.j;
                int i4 = trackGroup.length;
                checkedTextViewArr[i3] = new CheckedTextView[i4];
                c[] cVarArr = new c[i4];
                for (int i5 = 0; i5 < trackGroup.length; i5++) {
                    cVarArr[i5] = new c(i3, i5, trackGroup.getFormat(i5));
                }
                Comparator<c> comparator = this.o;
                if (comparator != null) {
                    Arrays.sort(cVarArr, comparator);
                }
                for (int i6 = 0; i6 < i4; i6++) {
                    if (i6 == 0) {
                        addView(this.b.inflate(R.layout.exo_list_divider, (ViewGroup) this, false));
                    }
                    CheckedTextView checkedTextView = (CheckedTextView) this.b.inflate((a3 || z) ? 17367056 : 17367055, (ViewGroup) this, false);
                    checkedTextView.setBackgroundResource(this.a);
                    checkedTextView.setText(this.i.getTrackName(cVarArr[i6].c));
                    checkedTextView.setTag(cVarArr[i6]);
                    if (this.k.getTrackSupport(this.l, i3, i6) == 4) {
                        checkedTextView.setFocusable(true);
                        checkedTextView.setOnClickListener(this.e);
                    } else {
                        checkedTextView.setFocusable(false);
                        checkedTextView.setEnabled(false);
                    }
                    this.j[i3][i6] = checkedTextView;
                    addView(checkedTextView);
                }
                i3++;
            } else {
                b();
                return;
            }
        }
    }

    public boolean getIsDisabled() {
        return this.n;
    }

    public List<DefaultTrackSelector.SelectionOverride> getOverrides() {
        ArrayList arrayList = new ArrayList(this.f.size());
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            arrayList.add(this.f.valueAt(i2));
        }
        return arrayList;
    }

    public void init(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int i2, boolean z, List<DefaultTrackSelector.SelectionOverride> list, @Nullable Comparator<Format> comparator, @Nullable TrackSelectionListener trackSelectionListener) {
        e0 e0Var;
        this.k = mappedTrackInfo;
        this.l = i2;
        this.n = z;
        if (comparator == null) {
            e0Var = null;
        } else {
            e0Var = new Comparator(comparator) { // from class: a2.j.b.b.c1.e0
                public final /* synthetic */ Comparator a;

                {
                    this.a = r1;
                }

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Comparator comparator2 = this.a;
                    int i3 = TrackSelectionView.q;
                    return comparator2.compare(((TrackSelectionView.c) obj).c, ((TrackSelectionView.c) obj2).c);
                }
            };
        }
        this.o = e0Var;
        this.p = trackSelectionListener;
        int size = this.h ? list.size() : Math.min(list.size(), 1);
        for (int i3 = 0; i3 < size; i3++) {
            DefaultTrackSelector.SelectionOverride selectionOverride = list.get(i3);
            this.f.put(selectionOverride.groupIndex, selectionOverride);
        }
        c();
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.g != z) {
            this.g = z;
            c();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.h != z) {
            this.h = z;
            if (!z && this.f.size() > 1) {
                for (int size = this.f.size() - 1; size > 0; size--) {
                    this.f.remove(size);
                }
            }
            c();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.c.setVisibility(z ? 0 : 8);
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider) {
        this.i = (TrackNameProvider) Assertions.checkNotNull(trackNameProvider);
        c();
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        setOrientation(1);
        this.f = new SparseArray<>();
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.a = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.b = from;
        b bVar = new b(null);
        this.e = bVar;
        this.i = new DefaultTrackNameProvider(getResources());
        this.m = TrackGroupArray.EMPTY;
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, (ViewGroup) this, false);
        this.c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R.string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R.layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, (ViewGroup) this, false);
        this.d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R.string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }
}
