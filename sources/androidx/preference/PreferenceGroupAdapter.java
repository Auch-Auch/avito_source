package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l6.u.d;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.b, PreferenceGroup.PreferencePositionCallback {
    public PreferenceGroup c;
    public List<Preference> d;
    public List<Preference> e;
    public List<c> f;
    public Handler g;
    public Runnable h = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PreferenceGroupAdapter.this.d();
        }
    }

    public class b extends DiffUtil.Callback {
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ PreferenceManager.PreferenceComparisonCallback c;

        public b(PreferenceGroupAdapter preferenceGroupAdapter, List list, List list2, PreferenceManager.PreferenceComparisonCallback preferenceComparisonCallback) {
            this.a = list;
            this.b = list2;
            this.c = preferenceComparisonCallback;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return this.c.arePreferenceContentsTheSame((Preference) this.a.get(i), (Preference) this.b.get(i2));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            return this.c.arePreferenceItemsTheSame((Preference) this.a.get(i), (Preference) this.b.get(i2));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.a.size();
        }
    }

    public static class c {
        public int a;
        public int b;
        public String c;

        public c(Preference preference) {
            this.c = preference.getClass().getName();
            this.a = preference.getLayoutResource();
            this.b = preference.getWidgetLayoutResource();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.a == cVar.a && this.b == cVar.b && TextUtils.equals(this.c, cVar.c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.c.hashCode() + ((((527 + this.a) * 31) + this.b) * 31);
        }
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this.c = preferenceGroup;
        this.g = new Handler();
        this.c.J = this;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.c;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).shouldUseGeneratedIds());
        } else {
            setHasStableIds(true);
        }
        d();
    }

    public final List<Preference> a(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i = 0;
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            Preference preference = preferenceGroup.getPreference(i2);
            if (preference.isVisible()) {
                if (!c(preferenceGroup) || i < preferenceGroup.getInitialExpandedChildrenCount()) {
                    arrayList.add(preference);
                } else {
                    arrayList2.add(preference);
                }
                if (!(preference instanceof PreferenceGroup)) {
                    i++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                    if (!preferenceGroup2.isOnSameScreenAsChildren()) {
                        continue;
                    } else if (!c(preferenceGroup) || !c(preferenceGroup2)) {
                        for (Preference preference2 : a(preferenceGroup2)) {
                            if (!c(preferenceGroup) || i < preferenceGroup.getInitialExpandedChildrenCount()) {
                                arrayList.add(preference2);
                            } else {
                                arrayList2.add(preference2);
                            }
                            i++;
                        }
                    } else {
                        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                    }
                }
            }
        }
        if (c(preferenceGroup) && i > preferenceGroup.getInitialExpandedChildrenCount()) {
            l6.u.a aVar = new l6.u.a(preferenceGroup.getContext(), arrayList2, preferenceGroup.d);
            aVar.setOnPreferenceClickListener(new d(this, preferenceGroup));
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public final void b(List<Preference> list, PreferenceGroup preferenceGroup) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.T);
        }
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = preferenceGroup.getPreference(i);
            list.add(preference);
            c cVar = new c(preference);
            if (!this.f.contains(cVar)) {
                this.f.add(cVar);
            }
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (preferenceGroup2.isOnSameScreenAsChildren()) {
                    b(list, preferenceGroup2);
                }
            }
            preference.J = this;
        }
    }

    public final boolean c(PreferenceGroup preferenceGroup) {
        return preferenceGroup.getInitialExpandedChildrenCount() != Integer.MAX_VALUE;
    }

    public void d() {
        for (Preference preference : this.d) {
            preference.J = null;
        }
        ArrayList arrayList = new ArrayList(this.d.size());
        this.d = arrayList;
        b(arrayList, this.c);
        List<Preference> list = this.e;
        List<Preference> a3 = a(this.c);
        this.e = a3;
        PreferenceManager preferenceManager = this.c.getPreferenceManager();
        if (preferenceManager == null || preferenceManager.getPreferenceComparisonCallback() == null) {
            notifyDataSetChanged();
        } else {
            DiffUtil.calculateDiff(new b(this, list, a3, preferenceManager.getPreferenceComparisonCallback())).dispatchUpdatesTo(this);
        }
        for (Preference preference2 : this.d) {
            preference2.M = false;
        }
    }

    public Preference getItem(int i) {
        if (i < 0 || i >= getItemCount()) {
            return null;
        }
        return this.e.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (!hasStableIds()) {
            return -1;
        }
        return getItem(i).a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        c cVar = new c(getItem(i));
        int indexOf = this.f.indexOf(cVar);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.f.size();
        this.f.add(cVar);
        return size;
    }

    @Override // androidx.preference.PreferenceGroup.PreferencePositionCallback
    public int getPreferenceAdapterPosition(String str) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(str, this.e.get(i).getKey())) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.preference.Preference.b
    public void onPreferenceChange(Preference preference) {
        int indexOf = this.e.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    @Override // androidx.preference.Preference.b
    public void onPreferenceHierarchyChange(Preference preference) {
        this.g.removeCallbacks(this.h);
        this.g.post(this.h);
    }

    @Override // androidx.preference.Preference.b
    public void onPreferenceVisibilityChange(Preference preference) {
        onPreferenceHierarchyChange(preference);
    }

    public void onBindViewHolder(@NonNull PreferenceViewHolder preferenceViewHolder, int i) {
        getItem(i).onBindViewHolder(preferenceViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public PreferenceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        c cVar = this.f.get(i);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(cVar.a, viewGroup, false);
        if (inflate.getBackground() == null) {
            ViewCompat.setBackground(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            int i2 = cVar.b;
            if (i2 != 0) {
                from.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(inflate);
    }

    @Override // androidx.preference.PreferenceGroup.PreferencePositionCallback
    public int getPreferenceAdapterPosition(Preference preference) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            Preference preference2 = this.e.get(i);
            if (preference2 != null && preference2.equals(preference)) {
                return i;
            }
        }
        return -1;
    }
}
