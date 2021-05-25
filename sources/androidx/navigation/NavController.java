package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import l6.r.b;
public class NavController {
    @NonNull
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    public final Context a;
    public Activity b;
    public NavInflater c;
    public NavGraph d;
    public Bundle e;
    public Parcelable[] f;
    public boolean g;
    public final Deque<NavBackStackEntry> h = new ArrayDeque();
    public LifecycleOwner i;
    public b j;
    public final NavigatorProvider k = new NavigatorProvider();
    public final CopyOnWriteArrayList<OnDestinationChangedListener> l = new CopyOnWriteArrayList<>();
    public final LifecycleObserver m = new LifecycleEventObserver() { // from class: androidx.navigation.NavController.1
        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            Lifecycle.State state;
            NavController navController = NavController.this;
            if (navController.d != null) {
                for (NavBackStackEntry navBackStackEntry : navController.h) {
                    Objects.requireNonNull(navBackStackEntry);
                    int ordinal = event.ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 1) {
                            if (ordinal == 2) {
                                state = Lifecycle.State.RESUMED;
                            } else if (ordinal != 3) {
                                if (ordinal != 4) {
                                    if (ordinal == 5) {
                                        state = Lifecycle.State.DESTROYED;
                                    } else {
                                        throw new IllegalArgumentException("Unexpected event value " + event);
                                    }
                                }
                            }
                            navBackStackEntry.g = state;
                            navBackStackEntry.a();
                        }
                        state = Lifecycle.State.STARTED;
                        navBackStackEntry.g = state;
                        navBackStackEntry.a();
                    }
                    state = Lifecycle.State.CREATED;
                    navBackStackEntry.g = state;
                    navBackStackEntry.a();
                }
            }
        }
    };
    public final OnBackPressedCallback n = new a(false);
    public boolean o = true;

    public interface OnDestinationChangedListener {
        void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle);
    }

    public class a extends OnBackPressedCallback {
        public a(boolean z) {
            super(z);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            NavController.this.popBackStack();
        }
    }

    public NavController(@NonNull Context context) {
        this.a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.b = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        NavigatorProvider navigatorProvider = this.k;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this.k.addNavigator(new ActivityNavigator(this.a));
    }

    public final boolean a() {
        while (!this.h.isEmpty() && (this.h.peekLast().getDestination() instanceof NavGraph) && e(this.h.peekLast().getDestination().getId(), true)) {
        }
        if (this.h.isEmpty()) {
            return false;
        }
        NavDestination destination = this.h.peekLast().getDestination();
        NavDestination navDestination = null;
        if (destination instanceof FloatingWindow) {
            Iterator<NavBackStackEntry> descendingIterator = this.h.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                NavDestination destination2 = descendingIterator.next().getDestination();
                if (!((destination2 instanceof NavGraph) || (destination2 instanceof FloatingWindow))) {
                    navDestination = destination2;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<NavBackStackEntry> descendingIterator2 = this.h.descendingIterator();
        while (descendingIterator2.hasNext()) {
            NavBackStackEntry next = descendingIterator2.next();
            Lifecycle.State state = next.h;
            NavDestination destination3 = next.getDestination();
            if (destination != null && destination3.getId() == destination.getId()) {
                Lifecycle.State state2 = Lifecycle.State.RESUMED;
                if (state != state2) {
                    hashMap.put(next, state2);
                }
                destination = destination.getParent();
            } else if (navDestination == null || destination3.getId() != navDestination.getId()) {
                next.h = Lifecycle.State.CREATED;
                next.a();
            } else {
                if (state == Lifecycle.State.RESUMED) {
                    next.h = Lifecycle.State.STARTED;
                    next.a();
                } else {
                    Lifecycle.State state3 = Lifecycle.State.STARTED;
                    if (state != state3) {
                        hashMap.put(next, state3);
                    }
                }
                navDestination = navDestination.getParent();
            }
        }
        for (NavBackStackEntry navBackStackEntry : this.h) {
            Lifecycle.State state4 = (Lifecycle.State) hashMap.get(navBackStackEntry);
            if (state4 != null) {
                navBackStackEntry.h = state4;
                navBackStackEntry.a();
            }
        }
        NavBackStackEntry peekLast = this.h.peekLast();
        Iterator<OnDestinationChangedListener> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        return true;
    }

    public void addOnDestinationChangedListener(@NonNull OnDestinationChangedListener onDestinationChangedListener) {
        if (!this.h.isEmpty()) {
            NavBackStackEntry peekLast = this.h.peekLast();
            onDestinationChangedListener.onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        this.l.add(onDestinationChangedListener);
    }

    public NavDestination b(@IdRes int i2) {
        NavDestination navDestination;
        NavGraph navGraph;
        NavGraph navGraph2 = this.d;
        if (navGraph2 == null) {
            return null;
        }
        if (navGraph2.getId() == i2) {
            return this.d;
        }
        if (this.h.isEmpty()) {
            navDestination = this.d;
        } else {
            navDestination = this.h.getLast().getDestination();
        }
        if (navDestination instanceof NavGraph) {
            navGraph = navDestination;
        } else {
            navGraph = navDestination.getParent();
        }
        return navGraph.findNode(i2);
    }

    public final int c() {
        int i2 = 0;
        for (NavBackStackEntry navBackStackEntry : this.h) {
            if (!(navBackStackEntry.getDestination() instanceof NavGraph)) {
                i2++;
            }
        }
        return i2;
    }

    @NonNull
    public NavDeepLinkBuilder createDeepLink() {
        NavDeepLinkBuilder navDeepLinkBuilder = new NavDeepLinkBuilder(this.a);
        navDeepLinkBuilder.c = getGraph();
        return navDeepLinkBuilder;
    }

    public final void d(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        boolean e2 = (navOptions == null || navOptions.getPopUpTo() == -1) ? false : e(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
        Navigator navigator = this.k.getNavigator(navDestination.getNavigatorName());
        Bundle a3 = navDestination.a(bundle);
        NavDestination navigate = navigator.navigate(navDestination, a3, navOptions, extras);
        if (navigate != null) {
            if (!(navigate instanceof FloatingWindow)) {
                while (!this.h.isEmpty() && (this.h.peekLast().getDestination() instanceof FloatingWindow) && e(this.h.peekLast().getDestination().getId(), true)) {
                }
            }
            if (this.h.isEmpty()) {
                this.h.add(new NavBackStackEntry(this.a, this.d, a3, this.i, this.j));
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            NavGraph navGraph = navigate;
            while (navGraph != null && b(navGraph.getId()) == null) {
                navGraph = navGraph.getParent();
                if (navGraph != null) {
                    arrayDeque.addFirst(new NavBackStackEntry(this.a, navGraph, a3, this.i, this.j));
                }
            }
            this.h.addAll(arrayDeque);
            this.h.add(new NavBackStackEntry(this.a, navigate, navigate.a(a3), this.i, this.j));
        }
        f();
        if (e2 || navigate != null) {
            a();
        }
    }

    public boolean e(@IdRes int i2, boolean z) {
        boolean z2;
        ViewModelStore remove;
        boolean z3 = false;
        if (this.h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NavBackStackEntry> descendingIterator = this.h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            NavDestination destination = descendingIterator.next().getDestination();
            Navigator navigator = this.k.getNavigator(destination.getNavigatorName());
            if (z || destination.getId() != i2) {
                arrayList.add(navigator);
            }
            if (destination.getId() == i2) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            NavDestination.c(this.a, i2);
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((Navigator) it.next()).popBackStack()) {
            NavBackStackEntry removeLast = this.h.removeLast();
            removeLast.h = Lifecycle.State.DESTROYED;
            removeLast.a();
            b bVar = this.j;
            if (!(bVar == null || (remove = bVar.c.remove(removeLast.f)) == null)) {
                remove.clear();
            }
            z3 = true;
        }
        f();
        return z3;
    }

    public final void f() {
        OnBackPressedCallback onBackPressedCallback = this.n;
        boolean z = true;
        if (!this.o || c() <= 1) {
            z = false;
        }
        onBackPressedCallback.setEnabled(z);
    }

    @NonNull
    public NavBackStackEntry getBackStackEntry(@IdRes int i2) {
        NavBackStackEntry navBackStackEntry;
        Iterator<NavBackStackEntry> descendingIterator = this.h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = descendingIterator.next();
            if (navBackStackEntry.getDestination().getId() == i2) {
                break;
            }
        }
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("No destination with ID ", i2, " is on the NavController's back stack"));
    }

    @Nullable
    public NavDestination getCurrentDestination() {
        if (this.h.isEmpty()) {
            return null;
        }
        return this.h.getLast().getDestination();
    }

    @NonNull
    public NavGraph getGraph() {
        NavGraph navGraph = this.d;
        if (navGraph != null) {
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    @NonNull
    public NavInflater getNavInflater() {
        if (this.c == null) {
            this.c = new NavInflater(this.a, this.k);
        }
        return this.c;
    }

    @NonNull
    public NavigatorProvider getNavigatorProvider() {
        return this.k;
    }

    @NonNull
    public ViewModelStoreOwner getViewModelStoreOwner(@IdRes int i2) {
        if (this.j != null) {
            NavBackStackEntry backStackEntry = getBackStackEntry(i2);
            if (backStackEntry.getDestination() instanceof NavGraph) {
                return backStackEntry;
            }
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("No NavGraph with ID ", i2, " is on the NavController's back stack"));
        }
        throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
    }

    public boolean handleDeepLink(@Nullable Intent intent) {
        String str;
        NavGraph navGraph;
        NavGraph navGraph2;
        NavDestination.a d2;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (!((intArray != null && intArray.length != 0) || intent.getData() == null || (d2 = this.d.d(intent.getData())) == null)) {
            intArray = d2.a.b();
            bundle.putAll(d2.b);
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        NavGraph navGraph3 = this.d;
        int i2 = 0;
        while (true) {
            if (i2 >= intArray.length) {
                str = null;
                break;
            }
            int i3 = intArray[i2];
            NavDestination findNode = i2 == 0 ? this.d : navGraph3.findNode(i3);
            if (findNode == null) {
                str = NavDestination.c(this.a, i3);
                break;
            }
            if (i2 != intArray.length - 1) {
                while (true) {
                    navGraph2 = (NavGraph) findNode;
                    if (!(navGraph2.findNode(navGraph2.getStartDestination()) instanceof NavGraph)) {
                        break;
                    }
                    findNode = navGraph2.findNode(navGraph2.getStartDestination());
                }
                navGraph3 = navGraph2;
            }
            i2++;
        }
        if (str != null) {
            String str2 = "Could not find destination " + str + " in the navigation graph, ignoring the deep link from " + intent;
            return false;
        }
        bundle.putParcelable(KEY_DEEP_LINK_INTENT, intent);
        int flags = intent.getFlags();
        int i4 = 268435456 & flags;
        if (i4 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            TaskStackBuilder.create(this.a).addNextIntentWithParentStack(intent).startActivities();
            Activity activity = this.b;
            if (activity != null) {
                activity.finish();
                this.b.overridePendingTransition(0, 0);
            }
            return true;
        } else if (i4 != 0) {
            if (!this.h.isEmpty()) {
                e(this.d.getId(), true);
            }
            int i5 = 0;
            while (i5 < intArray.length) {
                int i6 = i5 + 1;
                int i7 = intArray[i5];
                NavDestination b2 = b(i7);
                if (b2 != null) {
                    d(b2, bundle, new NavOptions.Builder().setEnterAnim(0).setExitAnim(0).build(), null);
                    i5 = i6;
                } else {
                    StringBuilder L = a2.b.a.a.a.L("unknown destination during deep link: ");
                    L.append(NavDestination.c(this.a, i7));
                    throw new IllegalStateException(L.toString());
                }
            }
            return true;
        } else {
            NavGraph navGraph4 = this.d;
            int i8 = 0;
            while (i8 < intArray.length) {
                int i9 = intArray[i8];
                NavDestination findNode2 = i8 == 0 ? this.d : navGraph4.findNode(i9);
                if (findNode2 != null) {
                    if (i8 != intArray.length - 1) {
                        while (true) {
                            navGraph = (NavGraph) findNode2;
                            if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                                break;
                            }
                            findNode2 = navGraph.findNode(navGraph.getStartDestination());
                        }
                        navGraph4 = navGraph;
                    } else {
                        d(findNode2, findNode2.a(bundle), new NavOptions.Builder().setPopUpTo(this.d.getId(), true).setEnterAnim(0).setExitAnim(0).build(), null);
                    }
                    i8++;
                } else {
                    StringBuilder L2 = a2.b.a.a.a.L("unknown destination during deep link: ");
                    L2.append(NavDestination.c(this.a, i9));
                    throw new IllegalStateException(L2.toString());
                }
            }
            this.g = true;
            return true;
        }
    }

    public void navigate(@IdRes int i2) {
        navigate(i2, (Bundle) null);
    }

    public boolean navigateUp() {
        if (c() != 1) {
            return popBackStack();
        }
        NavDestination currentDestination = getCurrentDestination();
        int id = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestination() != id) {
                NavDeepLinkBuilder navDeepLinkBuilder = new NavDeepLinkBuilder(this.a);
                navDeepLinkBuilder.c = getGraph();
                navDeepLinkBuilder.setDestination(parent.getId()).createTaskStackBuilder().startActivities();
                Activity activity = this.b;
                if (activity != null) {
                    activity.finish();
                }
                return true;
            }
            id = parent.getId();
        }
        return false;
    }

    public boolean popBackStack() {
        if (this.h.isEmpty()) {
            return false;
        }
        return popBackStack(getCurrentDestination().getId(), true);
    }

    public void removeOnDestinationChangedListener(@NonNull OnDestinationChangedListener onDestinationChangedListener) {
        this.l.remove(onDestinationChangedListener);
    }

    @CallSuper
    public void restoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.a.getClassLoader());
            this.e = bundle.getBundle("android-support-nav:controller:navigatorState");
            this.f = bundle.getParcelableArray("android-support-nav:controller:backStack");
            this.g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
        }
    }

    @Nullable
    @CallSuper
    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this.k.a.entrySet()) {
            String key = entry.getKey();
            Bundle onSaveState = entry.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, onSaveState);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        } else {
            bundle = null;
        }
        if (!this.h.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.h.size()];
            int i2 = 0;
            for (NavBackStackEntry navBackStackEntry : this.h) {
                parcelableArr[i2] = new l6.r.a(navBackStackEntry);
                i2++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (this.g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.g);
        }
        return bundle;
    }

    @CallSuper
    public void setGraph(@NavigationRes int i2) {
        setGraph(i2, (Bundle) null);
    }

    public void navigate(@IdRes int i2, @Nullable Bundle bundle) {
        navigate(i2, bundle, (NavOptions) null);
    }

    @CallSuper
    public void setGraph(@NavigationRes int i2, @Nullable Bundle bundle) {
        setGraph(getNavInflater().inflate(i2), bundle);
    }

    public void navigate(@IdRes int i2, @Nullable Bundle bundle, @Nullable NavOptions navOptions) {
        navigate(i2, bundle, navOptions, null);
    }

    public boolean popBackStack(@IdRes int i2, boolean z) {
        return e(i2, z) && a();
    }

    @CallSuper
    public void setGraph(@NonNull NavGraph navGraph) {
        setGraph(navGraph, (Bundle) null);
    }

    public void navigate(@IdRes int i2, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination navDestination;
        int i3;
        String str;
        if (this.h.isEmpty()) {
            navDestination = this.d;
        } else {
            navDestination = this.h.getLast().getDestination();
        }
        if (navDestination != null) {
            NavAction action = navDestination.getAction(i2);
            Bundle bundle2 = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                i3 = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(defaultArguments);
                }
            } else {
                i3 = i2;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i3 == 0 && navOptions != null && navOptions.getPopUpTo() != -1) {
                popBackStack(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
            } else if (i3 != 0) {
                NavDestination b2 = b(i3);
                if (b2 == null) {
                    StringBuilder Q = a2.b.a.a.a.Q("navigation destination ", NavDestination.c(this.a, i3));
                    if (action != null) {
                        StringBuilder L = a2.b.a.a.a.L(" referenced from action ");
                        L.append(NavDestination.c(this.a, i2));
                        str = L.toString();
                    } else {
                        str = "";
                    }
                    throw new IllegalArgumentException(a2.b.a.a.a.t(Q, str, " is unknown to this NavController"));
                }
                d(b2, bundle2, navOptions, extras);
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            }
        } else {
            throw new IllegalStateException("no current navigation node");
        }
    }

    @CallSuper
    public void setGraph(@NonNull NavGraph navGraph, @Nullable Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        NavGraph navGraph2 = this.d;
        boolean z = true;
        if (navGraph2 != null) {
            e(navGraph2.getId(), true);
        }
        this.d = navGraph;
        Bundle bundle2 = this.e;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Navigator navigator = this.k.getNavigator(next);
                Bundle bundle3 = this.e.getBundle(next);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                l6.r.a aVar = (l6.r.a) parcelable;
                NavDestination b2 = b(aVar.b);
                if (b2 != null) {
                    Bundle bundle4 = aVar.c;
                    if (bundle4 != null) {
                        bundle4.setClassLoader(this.a.getClassLoader());
                    }
                    this.h.add(new NavBackStackEntry(this.a, b2, bundle4, this.i, this.j, aVar.a, aVar.d));
                } else {
                    StringBuilder L = a2.b.a.a.a.L("unknown destination during restore: ");
                    L.append(this.a.getResources().getResourceName(aVar.b));
                    throw new IllegalStateException(L.toString());
                }
            }
            f();
            this.f = null;
        }
        if (this.d != null && this.h.isEmpty()) {
            if (this.g || (activity = this.b) == null || !handleDeepLink(activity.getIntent())) {
                z = false;
            }
            if (!z) {
                d(this.d, bundle, null, null);
            }
        }
    }

    public void navigate(@NonNull Uri uri) {
        navigate(uri, (NavOptions) null);
    }

    public void navigate(@NonNull Uri uri, @Nullable NavOptions navOptions) {
        navigate(uri, navOptions, (Navigator.Extras) null);
    }

    public void navigate(@NonNull Uri uri, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination.a d2 = this.d.d(uri);
        if (d2 != null) {
            d(d2.a, d2.b, navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("navigation destination with deepLink " + uri + " is unknown to this NavController");
    }

    public void navigate(@NonNull NavDirections navDirections) {
        navigate(navDirections.getActionId(), navDirections.getArguments());
    }

    public void navigate(@NonNull NavDirections navDirections, @Nullable NavOptions navOptions) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    public void navigate(@NonNull NavDirections navDirections, @NonNull Navigator.Extras extras) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), null, extras);
    }
}
