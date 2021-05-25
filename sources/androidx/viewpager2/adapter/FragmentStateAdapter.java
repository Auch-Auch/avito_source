package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import l6.c0.a.d;
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
    public final Lifecycle c;
    public final FragmentManager d;
    public final LongSparseArray<Fragment> e;
    public final LongSparseArray<Fragment.SavedState> f;
    public final LongSparseArray<Integer> g;
    public c h;
    public boolean i;
    public boolean j;

    public class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ FrameLayout a;
        public final /* synthetic */ FragmentViewHolder b;

        public a(FrameLayout frameLayout, FragmentViewHolder fragmentViewHolder) {
            this.a = frameLayout;
            this.b = fragmentViewHolder;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.a.getParent() != null) {
                this.a.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.e(this.b);
            }
        }
    }

    public static abstract class b extends RecyclerView.AdapterDataObserver {
        public b(a aVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onChanged();
        }
    }

    public class c {
        public ViewPager2.OnPageChangeCallback a;
        public RecyclerView.AdapterDataObserver b;
        public LifecycleEventObserver c;
        public ViewPager2 d;
        public long e = -1;

        public c() {
        }

        @NonNull
        public final ViewPager2 a(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void b(boolean z) {
            int currentItem;
            Fragment fragment;
            if (!FragmentStateAdapter.this.g() && this.d.getScrollState() == 0 && !FragmentStateAdapter.this.e.isEmpty() && FragmentStateAdapter.this.getItemCount() != 0 && (currentItem = this.d.getCurrentItem()) < FragmentStateAdapter.this.getItemCount()) {
                long itemId = FragmentStateAdapter.this.getItemId(currentItem);
                if ((itemId != this.e || z) && (fragment = FragmentStateAdapter.this.e.get(itemId)) != null && fragment.isAdded()) {
                    this.e = itemId;
                    FragmentTransaction beginTransaction = FragmentStateAdapter.this.d.beginTransaction();
                    Fragment fragment2 = null;
                    for (int i = 0; i < FragmentStateAdapter.this.e.size(); i++) {
                        long keyAt = FragmentStateAdapter.this.e.keyAt(i);
                        Fragment valueAt = FragmentStateAdapter.this.e.valueAt(i);
                        if (valueAt.isAdded()) {
                            if (keyAt != this.e) {
                                beginTransaction.setMaxLifecycle(valueAt, Lifecycle.State.STARTED);
                            } else {
                                fragment2 = valueAt;
                            }
                            valueAt.setMenuVisibility(keyAt == this.e);
                        }
                    }
                    if (fragment2 != null) {
                        beginTransaction.setMaxLifecycle(fragment2, Lifecycle.State.RESUMED);
                    }
                    if (!beginTransaction.isEmpty()) {
                        beginTransaction.commitNow();
                    }
                }
            }
        }
    }

    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    public static boolean c(@NonNull String str, @NonNull String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    public void a(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public void b() {
        Fragment fragment;
        View view;
        if (this.j && !g()) {
            ArraySet<Long> arraySet = new ArraySet();
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                long keyAt = this.e.keyAt(i2);
                if (!containsItem(keyAt)) {
                    arraySet.add(Long.valueOf(keyAt));
                    this.g.remove(keyAt);
                }
            }
            if (!this.i) {
                this.j = false;
                for (int i3 = 0; i3 < this.e.size(); i3++) {
                    long keyAt2 = this.e.keyAt(i3);
                    boolean z = true;
                    if (!this.g.containsKey(keyAt2) && ((fragment = this.e.get(keyAt2)) == null || (view = fragment.getView()) == null || view.getParent() == null)) {
                        z = false;
                    }
                    if (!z) {
                        arraySet.add(Long.valueOf(keyAt2));
                    }
                }
            }
            for (Long l : arraySet) {
                f(l.longValue());
            }
        }
    }

    public boolean containsItem(long j2) {
        return j2 >= 0 && j2 < ((long) getItemCount());
    }

    @NonNull
    public abstract Fragment createFragment(int i2);

    public final Long d(int i2) {
        Long l = null;
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            if (this.g.valueAt(i3).intValue() == i2) {
                if (l == null) {
                    l = Long.valueOf(this.g.keyAt(i3));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l;
    }

    public void e(@NonNull final FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = this.e.get(fragmentViewHolder.getItemId());
        if (fragment != null) {
            FrameLayout frameLayout = (FrameLayout) fragmentViewHolder.itemView;
            View view = fragment.getView();
            if (!fragment.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (fragment.isAdded() && view == null) {
                this.d.registerFragmentLifecycleCallbacks(new l6.c0.a.a(this, fragment, frameLayout), false);
            } else if (!fragment.isAdded() || view.getParent() == null) {
                if (fragment.isAdded()) {
                    a(view, frameLayout);
                } else if (!g()) {
                    this.d.registerFragmentLifecycleCallbacks(new l6.c0.a.a(this, fragment, frameLayout), false);
                    FragmentTransaction beginTransaction = this.d.beginTransaction();
                    StringBuilder L = a2.b.a.a.a.L("f");
                    L.append(fragmentViewHolder.getItemId());
                    beginTransaction.add(fragment, L.toString()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
                    this.h.b(false);
                } else if (!this.d.isDestroyed()) {
                    this.c.addObserver(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                        @Override // androidx.lifecycle.LifecycleEventObserver
                        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                            if (!FragmentStateAdapter.this.g()) {
                                lifecycleOwner.getLifecycle().removeObserver(this);
                                if (ViewCompat.isAttachedToWindow((FrameLayout) fragmentViewHolder.itemView)) {
                                    FragmentStateAdapter.this.e(fragmentViewHolder);
                                }
                            }
                        }
                    });
                }
            } else if (view.getParent() != frameLayout) {
                a(view, frameLayout);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public final void f(long j2) {
        ViewParent parent;
        Fragment fragment = this.e.get(j2);
        if (fragment != null) {
            if (!(fragment.getView() == null || (parent = fragment.getView().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!containsItem(j2)) {
                this.f.remove(j2);
            }
            if (!fragment.isAdded()) {
                this.e.remove(j2);
            } else if (g()) {
                this.j = true;
            } else {
                if (fragment.isAdded() && containsItem(j2)) {
                    this.f.put(j2, this.d.saveFragmentInstanceState(fragment));
                }
                this.d.beginTransaction().remove(fragment).commitNow();
                this.e.remove(j2);
            }
        }
    }

    public boolean g() {
        return this.d.isStateSaved();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return (long) i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        Preconditions.checkArgument(this.h == null);
        c cVar = new c();
        this.h = cVar;
        cVar.d = cVar.a(recyclerView);
        l6.c0.a.c cVar2 = new l6.c0.a.c(cVar);
        cVar.a = cVar2;
        cVar.d.registerOnPageChangeCallback(cVar2);
        d dVar = new d(cVar);
        cVar.b = dVar;
        FragmentStateAdapter.this.registerAdapterDataObserver(dVar);
        FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 = new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                FragmentStateAdapter.c.this.b(false);
            }
        };
        cVar.c = fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3;
        FragmentStateAdapter.this.c.addObserver(fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        int i3 = FragmentViewHolder.s;
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(ViewCompat.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new FragmentViewHolder(frameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        c cVar = this.h;
        cVar.a(recyclerView).unregisterOnPageChangeCallback(cVar.a);
        FragmentStateAdapter.this.unregisterAdapterDataObserver(cVar.b);
        FragmentStateAdapter.this.c.removeObserver(cVar.c);
        cVar.d = null;
        this.h = null;
    }

    public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    public final void onViewRecycled(@NonNull FragmentViewHolder fragmentViewHolder) {
        Long d2 = d(((FrameLayout) fragmentViewHolder.itemView).getId());
        if (d2 != null) {
            f(d2.longValue());
            this.g.remove(d2.longValue());
        }
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(@NonNull Parcelable parcelable) {
        if (!this.f.isEmpty() || !this.e.isEmpty()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (c(str, "f#")) {
                this.e.put(Long.parseLong(str.substring(2)), this.d.getFragment(bundle, str));
            } else if (c(str, "s#")) {
                long parseLong = Long.parseLong(str.substring(2));
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (containsItem(parseLong)) {
                    this.f.put(parseLong, savedState);
                }
            } else {
                throw new IllegalArgumentException(a2.b.a.a.a.c3("Unexpected key in savedState: ", str));
            }
        }
        if (!this.e.isEmpty()) {
            this.j = true;
            this.i = true;
            b();
            final Handler handler = new Handler(Looper.getMainLooper());
            final l6.c0.a.b bVar = new l6.c0.a.b(this);
            this.c.addObserver(new LifecycleEventObserver(this) { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        handler.removeCallbacks(bVar);
                        lifecycleOwner.getLifecycle().removeObserver(this);
                    }
                }
            });
            handler.postDelayed(bVar, 10000);
        }
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @NonNull
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.f.size() + this.e.size());
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            long keyAt = this.e.keyAt(i2);
            Fragment fragment = this.e.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.d.putFragment(bundle, a2.b.a.a.a.T2("f#", keyAt), fragment);
            }
        }
        for (int i3 = 0; i3 < this.f.size(); i3++) {
            long keyAt2 = this.f.keyAt(i3);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(a2.b.a.a.a.T2("s#", keyAt2), this.f.get(keyAt2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public final void onBindViewHolder(@NonNull FragmentViewHolder fragmentViewHolder, int i2) {
        long itemId = fragmentViewHolder.getItemId();
        int id = ((FrameLayout) fragmentViewHolder.itemView).getId();
        Long d2 = d(id);
        if (!(d2 == null || d2.longValue() == itemId)) {
            f(d2.longValue());
            this.g.remove(d2.longValue());
        }
        this.g.put(itemId, Integer.valueOf(id));
        long itemId2 = getItemId(i2);
        if (!this.e.containsKey(itemId2)) {
            Fragment createFragment = createFragment(i2);
            createFragment.setInitialSavedState(this.f.get(itemId2));
            this.e.put(itemId2, createFragment);
        }
        FrameLayout frameLayout = (FrameLayout) fragmentViewHolder.itemView;
        if (ViewCompat.isAttachedToWindow(frameLayout)) {
            if (frameLayout.getParent() == null) {
                frameLayout.addOnLayoutChangeListener(new a(frameLayout, fragmentViewHolder));
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        b();
    }

    public final void onViewAttachedToWindow(@NonNull FragmentViewHolder fragmentViewHolder) {
        e(fragmentViewHolder);
        b();
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.e = new LongSparseArray<>();
        this.f = new LongSparseArray<>();
        this.g = new LongSparseArray<>();
        this.i = false;
        this.j = false;
        this.d = fragmentManager;
        this.c = lifecycle;
        super.setHasStableIds(true);
    }
}
