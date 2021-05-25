package androidx.fragment.app;

import a2.b.a.a.a;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    public final FragmentManager c;
    public final int d;
    public FragmentTransaction e;
    public ArrayList<Fragment.SavedState> f;
    public ArrayList<Fragment> g;
    public Fragment h;
    public boolean i;

    @Deprecated
    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.e == null) {
            this.e = this.c.beginTransaction();
        }
        while (this.f.size() <= i2) {
            this.f.add(null);
        }
        this.f.set(i2, fragment.isAdded() ? this.c.saveFragmentInstanceState(fragment) : null);
        this.g.set(i2, null);
        this.e.remove(fragment);
        if (fragment.equals(this.h)) {
            this.h = null;
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.e;
        if (fragmentTransaction != null) {
            if (!this.i) {
                try {
                    this.i = true;
                    fragmentTransaction.commitNowAllowingStateLoss();
                    this.i = false;
                } catch (Throwable th) {
                    this.i = false;
                    throw th;
                }
            }
            this.e = null;
        }
    }

    @NonNull
    public abstract Fragment getItem(int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.g.size() > i2 && (fragment = this.g.get(i2)) != null) {
            return fragment;
        }
        if (this.e == null) {
            this.e = this.c.beginTransaction();
        }
        Fragment item = getItem(i2);
        if (this.f.size() > i2 && (savedState = this.f.get(i2)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.g.size() <= i2) {
            this.g.add(null);
        }
        item.setMenuVisibility(false);
        if (this.d == 0) {
            item.setUserVisibleHint(false);
        }
        this.g.set(i2, item);
        this.e.add(viewGroup.getId(), item);
        if (this.d == 1) {
            this.e.setMaxLifecycle(item, Lifecycle.State.STARTED);
        }
        return item;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f.clear();
            this.g.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f.add((Fragment.SavedState) parcelable2);
                }
            }
            for (T t : bundle.keySet()) {
                if (t.startsWith("f")) {
                    int parseInt = Integer.parseInt(t.substring(1));
                    Fragment fragment = this.c.getFragment(bundle, t);
                    if (fragment != null) {
                        while (this.g.size() <= parseInt) {
                            this.g.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.g.set(parseInt, fragment);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f.size()];
            this.f.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            Fragment fragment = this.g.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.c.putFragment(bundle, a.M2("f", i2), fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.h;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.d == 1) {
                    if (this.e == null) {
                        this.e = this.c.beginTransaction();
                    }
                    this.e.setMaxLifecycle(this.h, Lifecycle.State.STARTED);
                } else {
                    this.h.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.d == 1) {
                if (this.e == null) {
                    this.e = this.c.beginTransaction();
                }
                this.e.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.h = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager, int i2) {
        this.e = null;
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = null;
        this.c = fragmentManager;
        this.d = i2;
    }
}
