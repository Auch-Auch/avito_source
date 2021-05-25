package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.common.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class NavGraph extends NavDestination implements Iterable<NavDestination> {
    public final SparseArrayCompat<NavDestination> j = new SparseArrayCompat<>();
    public int k;
    public String l;

    public class a implements Iterator<NavDestination> {
        public int a = -1;
        public boolean b = false;

        public a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a + 1 < NavGraph.this.j.size();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public NavDestination next() {
            if (hasNext()) {
                this.b = true;
                SparseArrayCompat<NavDestination> sparseArrayCompat = NavGraph.this.j;
                int i = this.a + 1;
                this.a = i;
                return sparseArrayCompat.valueAt(i);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.b) {
                NavGraph.this.j.valueAt(this.a).b = null;
                NavGraph.this.j.removeAt(this.a);
                this.a--;
                this.b = false;
                return;
            }
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
    }

    public NavGraph(@NonNull Navigator<? extends NavGraph> navigator) {
        super(navigator);
    }

    public final void addAll(@NonNull NavGraph navGraph) {
        Iterator<NavDestination> it = navGraph.iterator();
        while (it.hasNext()) {
            it.remove();
            addDestination(it.next());
        }
    }

    public final void addDestination(@NonNull NavDestination navDestination) {
        if (navDestination.getId() != 0) {
            NavDestination navDestination2 = this.j.get(navDestination.getId());
            if (navDestination2 != navDestination) {
                if (navDestination.getParent() == null) {
                    if (navDestination2 != null) {
                        navDestination2.b = null;
                    }
                    navDestination.b = this;
                    this.j.put(navDestination.getId(), navDestination);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
            return;
        }
        throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
    }

    public final void addDestinations(@NonNull Collection<NavDestination> collection) {
        for (NavDestination navDestination : collection) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final void clear() {
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // androidx.navigation.NavDestination
    @Nullable
    public NavDestination.a d(@NonNull Uri uri) {
        NavDestination.a d = super.d(uri);
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            NavDestination.a d2 = it.next().d(uri);
            if (d2 != null && (d == null || d2.compareTo(d) > 0)) {
                d = d2;
            }
        }
        return d;
    }

    @Nullable
    public final NavDestination f(@IdRes int i, boolean z) {
        NavDestination navDestination = this.j.get(i);
        if (navDestination != null) {
            return navDestination;
        }
        if (!z || getParent() == null) {
            return null;
        }
        return getParent().findNode(i);
    }

    @Nullable
    public final NavDestination findNode(@IdRes int i) {
        return f(i, true);
    }

    @IdRes
    public final int getStartDestination() {
        return this.k;
    }

    @Override // java.lang.Iterable
    @NonNull
    public final Iterator<NavDestination> iterator() {
        return new a();
    }

    @Override // androidx.navigation.NavDestination
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super.onInflate(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.NavGraphNavigator);
        setStartDestination(obtainAttributes.getResourceId(R.styleable.NavGraphNavigator_startDestination, 0));
        this.l = NavDestination.c(context, this.k);
        obtainAttributes.recycle();
    }

    public final void remove(@NonNull NavDestination navDestination) {
        int indexOfKey = this.j.indexOfKey(navDestination.getId());
        if (indexOfKey >= 0) {
            this.j.valueAt(indexOfKey).b = null;
            this.j.removeAt(indexOfKey);
        }
    }

    public final void setStartDestination(@IdRes int i) {
        this.k = i;
        this.l = null;
    }

    @Override // androidx.navigation.NavDestination
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        NavDestination findNode = findNode(getStartDestination());
        if (findNode == null) {
            String str = this.l;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.k));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append("}");
        }
        return sb.toString();
    }

    public final void addDestinations(@NonNull NavDestination... navDestinationArr) {
        for (NavDestination navDestination : navDestinationArr) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }
}
