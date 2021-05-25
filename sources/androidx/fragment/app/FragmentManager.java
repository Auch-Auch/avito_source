package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.core.util.LogWriter;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.BuildConfig;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import l6.n.a.h;
import l6.n.a.i;
import l6.n.a.j;
import l6.n.a.l;
import l6.n.a.m;
import l6.n.a.n;
import l6.n.a.o;
import l6.n.a.p;
import l6.n.a.w;
public abstract class FragmentManager {
    public static boolean F = false;
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    public ArrayList<Boolean> A;
    public ArrayList<Fragment> B;
    public ArrayList<g> C;
    public m D;
    public Runnable E = new d();
    public final ArrayList<e> a = new ArrayList<>();
    public boolean b;
    public final p c = new p();
    public ArrayList<l6.n.a.a> d;
    public ArrayList<Fragment> e;
    public final h f = new h(this);
    public OnBackPressedDispatcher g;
    public final OnBackPressedCallback h = new a(false);
    public final AtomicInteger i = new AtomicInteger();
    public ArrayList<OnBackStackChangedListener> j;
    public ConcurrentHashMap<Fragment, HashSet<CancellationSignal>> k = new ConcurrentHashMap<>();
    public final w.a l = new b();
    public final i m = new i(this);
    public int n = -1;
    public FragmentHostCallback<?> o;
    public FragmentContainer p;
    public Fragment q;
    @Nullable
    public Fragment r;
    public FragmentFactory s = null;
    public FragmentFactory t = new c();
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public ArrayList<l6.n.a.a> z;

    public interface BackStackEntry {
        @Nullable
        @Deprecated
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Nullable
        @Deprecated
        CharSequence getBreadCrumbTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        @Nullable
        String getName();
    }

    public static abstract class FragmentLifecycleCallbacks {
        public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
        }

        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }
    }

    public interface OnBackStackChangedListener {
        @MainThread
        void onBackStackChanged();
    }

    public class a extends OnBackPressedCallback {
        public a(boolean z) {
            super(z);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            FragmentManager fragmentManager = FragmentManager.this;
            fragmentManager.B(true);
            if (fragmentManager.h.isEnabled()) {
                fragmentManager.popBackStackImmediate();
            } else {
                fragmentManager.g.onBackPressed();
            }
        }
    }

    public class b implements w.a {
        public b() {
        }

        public void a(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
            if (!cancellationSignal.isCanceled()) {
                FragmentManager fragmentManager = FragmentManager.this;
                HashSet<CancellationSignal> hashSet = fragmentManager.k.get(fragment);
                if (hashSet != null && hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
                    fragmentManager.k.remove(fragment);
                    if (fragment.mState < 3) {
                        fragmentManager.i(fragment);
                        fragmentManager.R(fragment, fragment.getStateAfterAnimating());
                    }
                }
            }
        }

        public void b(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
            FragmentManager fragmentManager = FragmentManager.this;
            if (fragmentManager.k.get(fragment) == null) {
                fragmentManager.k.put(fragment, new HashSet<>());
            }
            fragmentManager.k.get(fragment).add(cancellationSignal);
        }
    }

    public class c extends FragmentFactory {
        public c() {
        }

        @Override // androidx.fragment.app.FragmentFactory
        @NonNull
        public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
            FragmentHostCallback<?> fragmentHostCallback = FragmentManager.this.o;
            return fragmentHostCallback.instantiate(fragmentHostCallback.b, str, null);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.B(true);
        }
    }

    public interface e {
        boolean a(@NonNull ArrayList<l6.n.a.a> arrayList, @NonNull ArrayList<Boolean> arrayList2);
    }

    public class f implements e {
        public final String a;
        public final int b;
        public final int c;

        public f(@Nullable String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.e
        public boolean a(@NonNull ArrayList<l6.n.a.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.r;
            if (fragment == null || this.b >= 0 || this.a != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
                return FragmentManager.this.V(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    public static class g implements Fragment.e {
        public final boolean a;
        public final l6.n.a.a b;
        public int c;

        public g(@NonNull l6.n.a.a aVar, boolean z) {
            this.a = z;
            this.b = aVar;
        }

        public void a() {
            boolean z = this.c > 0;
            for (Fragment fragment : this.b.t.getFragments()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            l6.n.a.a aVar = this.b;
            aVar.t.h(aVar, this.a, !z, true);
        }
    }

    @Nullable
    public static Fragment J(@NonNull View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean L(int i2) {
        return F || Log.isLoggable("FragmentManager", i2);
    }

    @Deprecated
    public static void enableDebugLogging(boolean z2) {
        F = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <F extends androidx.fragment.app.Fragment> F findFragment(@androidx.annotation.NonNull android.view.View r3) {
        /*
            r0 = r3
        L_0x0001:
            r1 = 0
            if (r0 == 0) goto L_0x0019
            androidx.fragment.app.Fragment r2 = J(r0)
            if (r2 == 0) goto L_0x000c
            r1 = r2
            goto L_0x0019
        L_0x000c:
            android.view.ViewParent r0 = r0.getParent()
            boolean r2 = r0 instanceof android.view.View
            if (r2 == 0) goto L_0x0017
            android.view.View r0 = (android.view.View) r0
            goto L_0x0001
        L_0x0017:
            r0 = r1
            goto L_0x0001
        L_0x0019:
            if (r1 == 0) goto L_0x001c
            return r1
        L_0x001c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "View "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = " does not have a Fragment set"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.findFragment(android.view.View):androidx.fragment.app.Fragment");
    }

    public final void A(boolean z2) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.o == null) {
            if (this.x) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.o.c.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (z2 || !isStateSaved()) {
            if (this.z == null) {
                this.z = new ArrayList<>();
                this.A = new ArrayList<>();
            }
            this.b = true;
            boolean z3 = false;
            try {
                E(null, null);
            } finally {
                this.b = z3;
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean B(boolean z2) {
        boolean z3;
        A(z2);
        boolean z4 = false;
        while (true) {
            ArrayList<l6.n.a.a> arrayList = this.z;
            ArrayList<Boolean> arrayList2 = this.A;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    z3 = false;
                } else {
                    int size = this.a.size();
                    z3 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        z3 |= this.a.get(i2).a(arrayList, arrayList2);
                    }
                    this.a.clear();
                    this.o.c.removeCallbacks(this.E);
                }
            }
            if (z3) {
                this.b = true;
                try {
                    X(this.z, this.A);
                    g();
                    z4 = true;
                } catch (Throwable th) {
                    g();
                    throw th;
                }
            } else {
                l0();
                x();
                this.c.b();
                return z4;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void C(@NonNull e eVar, boolean z2) {
        if (!z2 || (this.o != null && !this.x)) {
            A(z2);
            ((l6.n.a.a) eVar).a(this.z, this.A);
            this.b = true;
            try {
                X(this.z, this.A);
                g();
                l0();
                x();
                this.c.b();
            } catch (Throwable th) {
                g();
                throw th;
            }
        }
    }

    public final void D(@NonNull ArrayList<l6.n.a.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        int i8;
        int i9;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z4 = arrayList.get(i2).r;
        ArrayList<Fragment> arrayList4 = this.B;
        if (arrayList4 == null) {
            this.B = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.B.addAll(this.c.g());
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        int i10 = i2;
        boolean z5 = false;
        while (true) {
            int i11 = 1;
            if (i10 < i3) {
                l6.n.a.a aVar = arrayList.get(i10);
                int i12 = 3;
                if (!arrayList3.get(i10).booleanValue()) {
                    ArrayList<Fragment> arrayList5 = this.B;
                    int i13 = 0;
                    while (i13 < aVar.c.size()) {
                        FragmentTransaction.a aVar2 = aVar.c.get(i13);
                        int i14 = aVar2.a;
                        if (i14 != i11) {
                            if (i14 == 2) {
                                Fragment fragment = aVar2.b;
                                int i15 = fragment.mContainerId;
                                int size = arrayList5.size() - 1;
                                boolean z7 = false;
                                while (size >= 0) {
                                    Fragment fragment2 = arrayList5.get(size);
                                    if (fragment2.mContainerId != i15) {
                                        i9 = i15;
                                    } else if (fragment2 == fragment) {
                                        i9 = i15;
                                        z7 = true;
                                    } else {
                                        if (fragment2 == primaryNavigationFragment) {
                                            i9 = i15;
                                            aVar.c.add(i13, new FragmentTransaction.a(9, fragment2));
                                            i13++;
                                            primaryNavigationFragment = null;
                                        } else {
                                            i9 = i15;
                                        }
                                        FragmentTransaction.a aVar3 = new FragmentTransaction.a(3, fragment2);
                                        aVar3.c = aVar2.c;
                                        aVar3.e = aVar2.e;
                                        aVar3.d = aVar2.d;
                                        aVar3.f = aVar2.f;
                                        aVar.c.add(i13, aVar3);
                                        arrayList5.remove(fragment2);
                                        i13++;
                                    }
                                    size--;
                                    i15 = i9;
                                }
                                if (z7) {
                                    aVar.c.remove(i13);
                                    i13--;
                                } else {
                                    i8 = 1;
                                    aVar2.a = 1;
                                    arrayList5.add(fragment);
                                    i13 += i8;
                                    i12 = 3;
                                    i11 = 1;
                                }
                            } else if (i14 == i12 || i14 == 6) {
                                arrayList5.remove(aVar2.b);
                                Fragment fragment3 = aVar2.b;
                                if (fragment3 == primaryNavigationFragment) {
                                    aVar.c.add(i13, new FragmentTransaction.a(9, fragment3));
                                    i13++;
                                    primaryNavigationFragment = null;
                                }
                            } else if (i14 != 7) {
                                if (i14 == 8) {
                                    aVar.c.add(i13, new FragmentTransaction.a(9, primaryNavigationFragment));
                                    i13++;
                                    primaryNavigationFragment = aVar2.b;
                                }
                            }
                            i8 = 1;
                            i13 += i8;
                            i12 = 3;
                            i11 = 1;
                        }
                        i8 = 1;
                        arrayList5.add(aVar2.b);
                        i13 += i8;
                        i12 = 3;
                        i11 = 1;
                    }
                } else {
                    ArrayList<Fragment> arrayList6 = this.B;
                    for (int size2 = aVar.c.size() - 1; size2 >= 0; size2--) {
                        FragmentTransaction.a aVar4 = aVar.c.get(size2);
                        int i16 = aVar4.a;
                        if (i16 != 1) {
                            if (i16 != 3) {
                                switch (i16) {
                                    case 8:
                                        primaryNavigationFragment = null;
                                        break;
                                    case 9:
                                        primaryNavigationFragment = aVar4.b;
                                        break;
                                    case 10:
                                        aVar4.h = aVar4.g;
                                        break;
                                }
                            }
                            arrayList6.add(aVar4.b);
                        }
                        arrayList6.remove(aVar4.b);
                    }
                }
                z5 = z5 || aVar.i;
                i10++;
                arrayList3 = arrayList2;
            } else {
                this.B.clear();
                if (!z4) {
                    z2 = true;
                    i4 = -1;
                    w.q(this, arrayList, arrayList2, i2, i3, false, this.l);
                } else {
                    z2 = true;
                    i4 = -1;
                }
                int i17 = i2;
                while (i17 < i3) {
                    l6.n.a.a aVar5 = arrayList.get(i17);
                    if (arrayList2.get(i17).booleanValue()) {
                        aVar5.e(i4);
                        aVar5.i(i17 == i3 + -1);
                    } else {
                        int i18 = z2 ? 1 : 0;
                        int i19 = z2 ? 1 : 0;
                        int i20 = z2 ? 1 : 0;
                        aVar5.e(i18);
                        aVar5.h();
                    }
                    i17++;
                }
                if (z4) {
                    ArraySet<Fragment> arraySet = new ArraySet<>();
                    a(arraySet);
                    i5 = i2;
                    int i21 = i3;
                    for (int i22 = i3 - 1; i22 >= i5; i22--) {
                        l6.n.a.a aVar6 = arrayList.get(i22);
                        boolean booleanValue = arrayList2.get(i22).booleanValue();
                        int i23 = 0;
                        while (true) {
                            if (i23 >= aVar6.c.size()) {
                                z3 = false;
                            } else if (l6.n.a.a.l(aVar6.c.get(i23))) {
                                z3 = true;
                            } else {
                                i23++;
                            }
                        }
                        if (z3 && !aVar6.k(arrayList, i22 + 1, i3)) {
                            if (this.C == null) {
                                this.C = new ArrayList<>();
                            }
                            g gVar = new g(aVar6, booleanValue);
                            this.C.add(gVar);
                            for (int i24 = 0; i24 < aVar6.c.size(); i24++) {
                                FragmentTransaction.a aVar7 = aVar6.c.get(i24);
                                if (l6.n.a.a.l(aVar7)) {
                                    aVar7.b.setOnStartEnterTransitionListener(gVar);
                                }
                            }
                            if (booleanValue) {
                                aVar6.h();
                            } else {
                                aVar6.i(false);
                            }
                            i21--;
                            if (i22 != i21) {
                                arrayList.remove(i22);
                                arrayList.add(i21, aVar6);
                            }
                            a(arraySet);
                        }
                    }
                    i6 = 0;
                    int size3 = arraySet.size();
                    for (int i25 = 0; i25 < size3; i25++) {
                        Fragment valueAt = arraySet.valueAt(i25);
                        if (!valueAt.mAdded) {
                            View requireView = valueAt.requireView();
                            valueAt.mPostponedAlpha = requireView.getAlpha();
                            requireView.setAlpha(0.0f);
                        }
                    }
                    i7 = i21;
                } else {
                    i5 = i2;
                    i6 = 0;
                    i7 = i3;
                }
                if (i7 != i5 && z4) {
                    w.q(this, arrayList, arrayList2, i2, i7, true, this.l);
                    Q(this.n, z2);
                }
                while (i5 < i3) {
                    l6.n.a.a aVar8 = arrayList.get(i5);
                    if (arrayList2.get(i5).booleanValue() && aVar8.v >= 0) {
                        aVar8.v = -1;
                    }
                    if (aVar8.s != null) {
                        for (int i26 = 0; i26 < aVar8.s.size(); i26++) {
                            aVar8.s.get(i26).run();
                        }
                        aVar8.s = null;
                    }
                    i5++;
                }
                if (z5 && this.j != null) {
                    while (i6 < this.j.size()) {
                        this.j.get(i6).onBackStackChanged();
                        i6++;
                    }
                    return;
                }
                return;
            }
        }
    }

    public final void E(@Nullable ArrayList<l6.n.a.a> arrayList, @Nullable ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<g> arrayList3 = this.C;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            g gVar = this.C.get(i2);
            if (arrayList == null || gVar.a || (indexOf2 = arrayList.indexOf(gVar.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if ((gVar.c == 0) || (arrayList != null && gVar.b.k(arrayList, 0, arrayList.size()))) {
                    this.C.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || gVar.a || (indexOf = arrayList.indexOf(gVar.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        gVar.a();
                    } else {
                        l6.n.a.a aVar = gVar.b;
                        aVar.t.h(aVar, gVar.a, false, false);
                    }
                }
            } else {
                this.C.remove(i2);
                i2--;
                size--;
                l6.n.a.a aVar2 = gVar.b;
                aVar2.t.h(aVar2, gVar.a, false, false);
            }
            i2++;
        }
    }

    @Nullable
    public Fragment F(@NonNull String str) {
        return this.c.e(str);
    }

    public Fragment G(@NonNull String str) {
        Fragment findFragmentByWho;
        for (o oVar : this.c.b.values()) {
            if (!(oVar == null || (findFragmentByWho = oVar.b.findFragmentByWho(str)) == null)) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public final void H() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).a();
            }
        }
    }

    public final ViewGroup I(@NonNull Fragment fragment) {
        if (fragment.mContainerId > 0 && this.p.onHasView()) {
            View onFindViewById = this.p.onFindViewById(fragment.mContainerId);
            if (onFindViewById instanceof ViewGroup) {
                return (ViewGroup) onFindViewById;
            }
        }
        return null;
    }

    public void K(@NonNull Fragment fragment) {
        if (L(2)) {
            String str = "hide: " + fragment;
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            h0(fragment);
        }
    }

    public final boolean M(@NonNull Fragment fragment) {
        boolean z2;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mChildFragmentManager;
        Iterator it = ((ArrayList) fragmentManager.c.f()).iterator();
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                z3 = fragmentManager.M(fragment2);
                continue;
            }
            if (z3) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public boolean N(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.getPrimaryNavigationFragment()) || !N(fragmentManager.q)) {
            return false;
        }
        return true;
    }

    public void O(@NonNull Fragment fragment) {
        if (!this.c.c(fragment.mWho)) {
            o oVar = new o(this.m, fragment);
            oVar.a(this.o.b.getClassLoader());
            this.c.b.put(oVar.b.mWho, oVar);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    c(fragment);
                } else {
                    Y(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            oVar.c = this.n;
            if (L(2)) {
                String str = "Added fragment to active set " + fragment;
            }
        }
    }

    public void P(@NonNull Fragment fragment) {
        Animator animator;
        ViewGroup viewGroup;
        int indexOfChild;
        int indexOfChild2;
        if (this.c.c(fragment.mWho)) {
            R(fragment, this.n);
            if (fragment.mView != null) {
                p pVar = this.c;
                Objects.requireNonNull(pVar);
                ViewGroup viewGroup2 = fragment.mContainer;
                View view = fragment.mView;
                Fragment fragment2 = null;
                if (viewGroup2 != null && view != null) {
                    int indexOf = pVar.a.indexOf(fragment);
                    while (true) {
                        indexOf--;
                        if (indexOf < 0) {
                            break;
                        }
                        Fragment fragment3 = pVar.a.get(indexOf);
                        if (fragment3.mContainer == viewGroup2 && fragment3.mView != null) {
                            fragment2 = fragment3;
                            break;
                        }
                    }
                }
                if (fragment2 != null && (indexOfChild2 = viewGroup.indexOfChild(fragment.mView)) < (indexOfChild = (viewGroup = fragment.mContainer).indexOfChild(fragment2.mView))) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.mView, indexOfChild);
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    float f2 = fragment.mPostponedAlpha;
                    if (f2 > 0.0f) {
                        fragment.mView.setAlpha(f2);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    l6.n.a.f f1 = AppCompatDelegateImpl.i.f1(this.o.b, this.p, fragment, true);
                    if (f1 != null) {
                        Animation animation = f1.a;
                        if (animation != null) {
                            fragment.mView.startAnimation(animation);
                        } else {
                            f1.b.setTarget(fragment.mView);
                            f1.b.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                if (fragment.mView != null) {
                    l6.n.a.f f12 = AppCompatDelegateImpl.i.f1(this.o.b, this.p, fragment, !fragment.mHidden);
                    if (f12 == null || (animator = f12.b) == null) {
                        if (f12 != null) {
                            fragment.mView.startAnimation(f12.a);
                            f12.a.start();
                        }
                        fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                        if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(false);
                        }
                    } else {
                        animator.setTarget(fragment.mView);
                        if (!fragment.mHidden) {
                            fragment.mView.setVisibility(0);
                        } else if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(false);
                        } else {
                            ViewGroup viewGroup3 = fragment.mContainer;
                            View view2 = fragment.mView;
                            viewGroup3.startViewTransition(view2);
                            f12.b.addListener(new j(this, viewGroup3, view2, fragment));
                        }
                        f12.b.start();
                    }
                }
                if (fragment.mAdded && M(fragment)) {
                    this.u = true;
                }
                fragment.mHiddenChanged = false;
                fragment.onHiddenChanged(fragment.mHidden);
            }
        } else if (L(3)) {
            String str = "Ignoring moving " + fragment + " to state " + this.n + "since it is not added to " + this;
        }
    }

    public void Q(int i2, boolean z2) {
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.o == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.n) {
            this.n = i2;
            for (Fragment fragment : this.c.g()) {
                P(fragment);
            }
            Iterator it = ((ArrayList) this.c.f()).iterator();
            while (it.hasNext()) {
                Fragment fragment2 = (Fragment) it.next();
                if (fragment2 != null && !fragment2.mIsNewlyAdded) {
                    P(fragment2);
                }
            }
            j0();
            if (this.u && (fragmentHostCallback = this.o) != null && this.n == 4) {
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
                this.u = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a4, code lost:
        if (r2 != 3) goto L_0x066f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0209  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void R(@androidx.annotation.NonNull androidx.fragment.app.Fragment r14, int r15) {
        /*
        // Method dump skipped, instructions count: 1695
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.R(androidx.fragment.app.Fragment, int):void");
    }

    public void S() {
        if (this.o != null) {
            this.v = false;
            this.w = false;
            for (Fragment fragment : this.c.g()) {
                if (fragment != null) {
                    fragment.noteStateNotSaved();
                }
            }
        }
    }

    public void T(@NonNull Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.b) {
            this.y = true;
            return;
        }
        fragment.mDeferStart = false;
        R(fragment, this.n);
    }

    public final boolean U(@Nullable String str, int i2, int i3) {
        B(false);
        A(true);
        Fragment fragment = this.r;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean V = V(this.z, this.A, str, i2, i3);
        if (V) {
            this.b = true;
            try {
                X(this.z, this.A);
            } finally {
                g();
            }
        }
        l0();
        x();
        this.c.b();
        return V;
    }

    public boolean V(@NonNull ArrayList<l6.n.a.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, @Nullable String str, int i2, int i3) {
        int i4;
        ArrayList<l6.n.a.a> arrayList3 = this.d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    l6.n.a.a aVar = this.d.get(size2);
                    if ((str != null && str.equals(aVar.k)) || (i2 >= 0 && i2 == aVar.v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        l6.n.a.a aVar2 = this.d.get(size2);
                        if (str == null || !str.equals(aVar2.k)) {
                            if (i2 < 0 || i2 != aVar2.v) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.d.size() - 1) {
                return false;
            }
            for (int size3 = this.d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void W(@NonNull Fragment fragment) {
        if (L(2)) {
            String str = "remove: " + fragment + " nesting=" + fragment.mBackStackNesting;
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            this.c.h(fragment);
            if (M(fragment)) {
                this.u = true;
            }
            fragment.mRemoving = true;
            h0(fragment);
        }
    }

    public final void X(@NonNull ArrayList<l6.n.a.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                E(arrayList, arrayList2);
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).r) {
                        if (i3 != i2) {
                            D(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).r) {
                                i3++;
                            }
                        }
                        D(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    D(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public void Y(@NonNull Fragment fragment) {
        if (isStateSaved()) {
            L(2);
            return;
        }
        if ((this.D.c.remove(fragment.mWho) != null) && L(2)) {
            String str = "Updating retained Fragments: Removed " + fragment;
        }
    }

    public void Z(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (!(this.o instanceof ViewModelStoreOwner)) {
            this.D.d(fragmentManagerNonConfig);
            a0(parcelable);
            return;
        }
        k0(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        throw null;
    }

    public final void a(@NonNull ArraySet<Fragment> arraySet) {
        int i2 = this.n;
        if (i2 >= 1) {
            int min = Math.min(i2, 3);
            for (Fragment fragment : this.c.g()) {
                if (fragment.mState < min) {
                    R(fragment, min);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        arraySet.add(fragment);
                    }
                }
            }
        }
    }

    public void a0(@Nullable Parcelable parcelable) {
        o oVar;
        if (parcelable != null) {
            l lVar = (l) parcelable;
            if (lVar.a != null) {
                this.c.b.clear();
                Iterator<n> it = lVar.a.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next != null) {
                        Fragment fragment = this.D.c.get(next.b);
                        if (fragment != null) {
                            if (L(2)) {
                                String str = "restoreSaveState: re-attaching retained " + fragment;
                            }
                            oVar = new o(this.m, fragment, next);
                        } else {
                            oVar = new o(this.m, this.o.b.getClassLoader(), getFragmentFactory(), next);
                        }
                        Fragment fragment2 = oVar.b;
                        fragment2.mFragmentManager = this;
                        if (L(2)) {
                            StringBuilder L = a2.b.a.a.a.L("restoreSaveState: active (");
                            L.append(fragment2.mWho);
                            L.append("): ");
                            L.append(fragment2);
                            L.toString();
                        }
                        oVar.a(this.o.b.getClassLoader());
                        this.c.b.put(oVar.b.mWho, oVar);
                        oVar.c = this.n;
                    }
                }
                for (Fragment fragment3 : this.D.c.values()) {
                    if (!this.c.c(fragment3.mWho)) {
                        if (L(2)) {
                            String str2 = "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + lVar.a;
                        }
                        R(fragment3, 1);
                        fragment3.mRemoving = true;
                        R(fragment3, -1);
                    }
                }
                p pVar = this.c;
                ArrayList<String> arrayList = lVar.b;
                pVar.a.clear();
                if (arrayList != null) {
                    for (String str3 : arrayList) {
                        Fragment e2 = pVar.e(str3);
                        if (e2 != null) {
                            if (L(2)) {
                                String str4 = "restoreSaveState: added (" + str3 + "): " + e2;
                            }
                            pVar.a(e2);
                        } else {
                            throw new IllegalStateException(a2.b.a.a.a.e3("No instantiated fragment for (", str3, ")"));
                        }
                    }
                }
                if (lVar.c != null) {
                    this.d = new ArrayList<>(lVar.c.length);
                    int i2 = 0;
                    while (true) {
                        l6.n.a.b[] bVarArr = lVar.c;
                        if (i2 >= bVarArr.length) {
                            break;
                        }
                        l6.n.a.b bVar = bVarArr[i2];
                        Objects.requireNonNull(bVar);
                        l6.n.a.a aVar = new l6.n.a.a(this);
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            int[] iArr = bVar.a;
                            if (i3 >= iArr.length) {
                                break;
                            }
                            FragmentTransaction.a aVar2 = new FragmentTransaction.a();
                            int i5 = i3 + 1;
                            aVar2.a = iArr[i3];
                            if (L(2)) {
                                String str5 = "Instantiate " + aVar + " op #" + i4 + " base fragment #" + bVar.a[i5];
                            }
                            String str6 = bVar.b.get(i4);
                            if (str6 != null) {
                                aVar2.b = this.c.e(str6);
                            } else {
                                aVar2.b = null;
                            }
                            aVar2.g = Lifecycle.State.values()[bVar.c[i4]];
                            aVar2.h = Lifecycle.State.values()[bVar.d[i4]];
                            int[] iArr2 = bVar.a;
                            int i6 = i5 + 1;
                            int i7 = iArr2[i5];
                            aVar2.c = i7;
                            int i8 = i6 + 1;
                            int i9 = iArr2[i6];
                            aVar2.d = i9;
                            int i10 = i8 + 1;
                            int i11 = iArr2[i8];
                            aVar2.e = i11;
                            int i12 = iArr2[i10];
                            aVar2.f = i12;
                            aVar.d = i7;
                            aVar.e = i9;
                            aVar.f = i11;
                            aVar.g = i12;
                            aVar.b(aVar2);
                            i4++;
                            i3 = i10 + 1;
                        }
                        aVar.h = bVar.e;
                        aVar.k = bVar.f;
                        aVar.v = bVar.g;
                        aVar.i = true;
                        aVar.l = bVar.h;
                        aVar.m = bVar.i;
                        aVar.n = bVar.j;
                        aVar.o = bVar.k;
                        aVar.p = bVar.l;
                        aVar.q = bVar.m;
                        aVar.r = bVar.n;
                        aVar.e(1);
                        if (L(2)) {
                            StringBuilder M = a2.b.a.a.a.M("restoreAllState: back stack #", i2, " (index ");
                            M.append(aVar.v);
                            M.append("): ");
                            M.append(aVar);
                            M.toString();
                            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                            aVar.g("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.d.add(aVar);
                        i2++;
                    }
                } else {
                    this.d = null;
                }
                this.i.set(lVar.d);
                String str7 = lVar.e;
                if (str7 != null) {
                    Fragment e3 = this.c.e(str7);
                    this.r = e3;
                    t(e3);
                }
            }
        }
    }

    public void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(onBackStackChangedListener);
    }

    public void b(@NonNull Fragment fragment) {
        if (L(2)) {
            String str = "add: " + fragment;
        }
        O(fragment);
        if (!fragment.mDetached) {
            this.c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (M(fragment)) {
                this.u = true;
            }
        }
    }

    @Deprecated
    public FragmentManagerNonConfig b0() {
        if (!(this.o instanceof ViewModelStoreOwner)) {
            return this.D.c();
        }
        k0(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        throw null;
    }

    @NonNull
    public FragmentTransaction beginTransaction() {
        return new l6.n.a.a(this);
    }

    public void c(@NonNull Fragment fragment) {
        boolean z2;
        if (isStateSaved()) {
            L(2);
            return;
        }
        m mVar = this.D;
        if (mVar.c.containsKey(fragment.mWho)) {
            z2 = false;
        } else {
            mVar.c.put(fragment.mWho, fragment);
            z2 = true;
        }
        if (z2 && L(2)) {
            String str = "Updating retained Fragments: Added " + fragment;
        }
    }

    public Parcelable c0() {
        ArrayList<String> arrayList;
        int size;
        H();
        y();
        B(true);
        this.v = true;
        p pVar = this.c;
        Objects.requireNonNull(pVar);
        ArrayList<n> arrayList2 = new ArrayList<>(pVar.b.size());
        for (o oVar : pVar.b.values()) {
            if (oVar != null) {
                Fragment fragment = oVar.b;
                n nVar = new n(fragment);
                Fragment fragment2 = oVar.b;
                if (fragment2.mState <= -1 || nVar.m != null) {
                    nVar.m = fragment2.mSavedFragmentState;
                } else {
                    Bundle b2 = oVar.b();
                    nVar.m = b2;
                    if (oVar.b.mTargetWho != null) {
                        if (b2 == null) {
                            nVar.m = new Bundle();
                        }
                        nVar.m.putString("android:target_state", oVar.b.mTargetWho);
                        int i2 = oVar.b.mTargetRequestCode;
                        if (i2 != 0) {
                            nVar.m.putInt("android:target_req_state", i2);
                        }
                    }
                }
                arrayList2.add(nVar);
                if (L(2)) {
                    String str = "Saved state of " + fragment + ": " + nVar.m;
                }
            }
        }
        l6.n.a.b[] bVarArr = null;
        if (arrayList2.isEmpty()) {
            L(2);
            return null;
        }
        p pVar2 = this.c;
        synchronized (pVar2.a) {
            if (pVar2.a.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(pVar2.a.size());
                Iterator<Fragment> it = pVar2.a.iterator();
                while (it.hasNext()) {
                    Fragment next = it.next();
                    arrayList.add(next.mWho);
                    if (L(2)) {
                        String str2 = "saveAllState: adding fragment (" + next.mWho + "): " + next;
                    }
                }
            }
        }
        ArrayList<l6.n.a.a> arrayList3 = this.d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new l6.n.a.b[size];
            for (int i3 = 0; i3 < size; i3++) {
                bVarArr[i3] = new l6.n.a.b(this.d.get(i3));
                if (L(2)) {
                    StringBuilder M = a2.b.a.a.a.M("saveAllState: adding back stack #", i3, ": ");
                    M.append(this.d.get(i3));
                    M.toString();
                }
            }
        }
        l lVar = new l();
        lVar.a = arrayList2;
        lVar.b = arrayList;
        lVar.c = bVarArr;
        lVar.d = this.i.get();
        Fragment fragment3 = this.r;
        if (fragment3 != null) {
            lVar.e = fragment3.mWho;
        }
        return lVar;
    }

    public void d(@NonNull FragmentHostCallback<?> fragmentHostCallback, @NonNull FragmentContainer fragmentContainer, @Nullable Fragment fragment) {
        if (this.o == null) {
            this.o = fragmentHostCallback;
            this.p = fragmentContainer;
            this.q = fragment;
            if (fragment != null) {
                l0();
            }
            if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
                OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
                OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
                this.g = onBackPressedDispatcher;
                LifecycleOwner lifecycleOwner = onBackPressedDispatcherOwner;
                if (fragment != null) {
                    lifecycleOwner = fragment;
                }
                onBackPressedDispatcher.addCallback(lifecycleOwner, this.h);
            }
            if (fragment != null) {
                m mVar = fragment.mFragmentManager.D;
                m mVar2 = mVar.d.get(fragment.mWho);
                if (mVar2 == null) {
                    mVar2 = new m(mVar.f);
                    mVar.d.put(fragment.mWho, mVar2);
                }
                this.D = mVar2;
            } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                this.D = (m) new ViewModelProvider(((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore(), m.i).get(m.class);
            } else {
                this.D = new m(false);
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public void d0() {
        synchronized (this.a) {
            ArrayList<g> arrayList = this.C;
            boolean z2 = false;
            boolean z3 = arrayList != null && !arrayList.isEmpty();
            if (this.a.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.o.c.removeCallbacks(this.E);
                this.o.c.post(this.E);
                l0();
            }
        }
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        int size2;
        String c3 = a2.b.a.a.a.c3(str, "    ");
        p pVar = this.c;
        Objects.requireNonNull(pVar);
        String str2 = str + "    ";
        if (!pVar.b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (o oVar : pVar.b.values()) {
                printWriter.print(str);
                if (oVar != null) {
                    Fragment fragment = oVar.b;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(BuildConfig.ADJUST_DEFAULT_TRACKER);
                }
            }
        }
        int size3 = pVar.a.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size3; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(pVar.a.get(i2).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.e.get(i3).toString());
            }
        }
        ArrayList<l6.n.a.a> arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                l6.n.a.a aVar = this.d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.g(c3, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            int size4 = this.a.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i5 = 0; i5 < size4; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((e) this.a.get(i5));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.v);
        printWriter.print(" mStopped=");
        printWriter.print(this.w);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.x);
        if (this.u) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.u);
        }
    }

    public void e(@NonNull Fragment fragment) {
        if (L(2)) {
            String str = "attach: " + fragment;
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.c.a(fragment);
                if (L(2)) {
                    String str2 = "add from attach: " + fragment;
                }
                if (M(fragment)) {
                    this.u = true;
                }
            }
        }
    }

    public void e0(@NonNull Fragment fragment, boolean z2) {
        ViewGroup I = I(fragment);
        if (I != null && (I instanceof FragmentContainerView)) {
            ((FragmentContainerView) I).setDrawDisappearingViewsLast(!z2);
        }
    }

    public boolean executePendingTransactions() {
        boolean B2 = B(true);
        H();
        return B2;
    }

    public final void f(@NonNull Fragment fragment) {
        HashSet<CancellationSignal> hashSet = this.k.get(fragment);
        if (hashSet != null) {
            Iterator<CancellationSignal> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            hashSet.clear();
            i(fragment);
            this.k.remove(fragment);
        }
    }

    public void f0(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (!fragment.equals(F(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    @Nullable
    public Fragment findFragmentById(@IdRes int i2) {
        p pVar = this.c;
        int size = pVar.a.size();
        while (true) {
            size--;
            if (size >= 0) {
                Fragment fragment = pVar.a.get(size);
                if (fragment != null && fragment.mFragmentId == i2) {
                    return fragment;
                }
            } else {
                for (o oVar : pVar.b.values()) {
                    if (oVar != null) {
                        Fragment fragment2 = oVar.b;
                        if (fragment2.mFragmentId == i2) {
                            return fragment2;
                        }
                    }
                }
                return null;
            }
        }
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String str) {
        p pVar = this.c;
        Objects.requireNonNull(pVar);
        if (str != null) {
            int size = pVar.a.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                Fragment fragment = pVar.a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (o oVar : pVar.b.values()) {
                if (oVar != null) {
                    Fragment fragment2 = oVar.b;
                    if (str.equals(fragment2.mTag)) {
                        return fragment2;
                    }
                }
            }
        }
        return null;
    }

    public final void g() {
        this.b = false;
        this.A.clear();
        this.z.clear();
    }

    public void g0(@Nullable Fragment fragment) {
        if (fragment == null || (fragment.equals(F(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.r;
            this.r = fragment;
            t(fragment2);
            t(this.r);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    @NonNull
    public BackStackEntry getBackStackEntryAt(int i2) {
        return this.d.get(i2);
    }

    public int getBackStackEntryCount() {
        ArrayList<l6.n.a.a> arrayList = this.d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Nullable
    public Fragment getFragment(@NonNull Bundle bundle, @NonNull String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment e2 = this.c.e(string);
        if (e2 != null) {
            return e2;
        }
        k0(new IllegalStateException(a2.b.a.a.a.d("Fragment no longer exists for key ", str, ": unique id ", string)));
        throw null;
    }

    @NonNull
    public FragmentFactory getFragmentFactory() {
        FragmentFactory fragmentFactory = this.s;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.q;
        if (fragment != null) {
            return fragment.mFragmentManager.getFragmentFactory();
        }
        return this.t;
    }

    @NonNull
    public List<Fragment> getFragments() {
        return this.c.g();
    }

    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.r;
    }

    public void h(@NonNull l6.n.a.a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.i(z4);
        } else {
            aVar.h();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            w.q(this, arrayList, arrayList2, 0, 1, true, this.l);
        }
        if (z4) {
            Q(this.n, true);
        }
        Iterator it = ((ArrayList) this.c.f()).iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.j(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z4) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    public final void h0(@NonNull Fragment fragment) {
        ViewGroup I = I(fragment);
        if (I != null) {
            int i2 = R.id.visible_removing_fragment_view_tag;
            if (I.getTag(i2) == null) {
                I.setTag(i2, fragment);
            }
            ((Fragment) I.getTag(i2)).setNextAnim(fragment.getNextAnim());
        }
    }

    public final void i(@NonNull Fragment fragment) {
        fragment.performDestroyView();
        this.m.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    public void i0(@NonNull Fragment fragment) {
        if (L(2)) {
            String str = "show: " + fragment;
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public boolean isDestroyed() {
        return this.x;
    }

    public boolean isStateSaved() {
        return this.v || this.w;
    }

    public void j(@NonNull Fragment fragment) {
        if (L(2)) {
            String str = "detach: " + fragment;
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (L(2)) {
                    String str2 = "remove from detach: " + fragment;
                }
                this.c.h(fragment);
                if (M(fragment)) {
                    this.u = true;
                }
                h0(fragment);
            }
        }
    }

    public final void j0() {
        Iterator it = ((ArrayList) this.c.f()).iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null) {
                T(fragment);
            }
        }
    }

    public void k(@NonNull Configuration configuration) {
        for (Fragment fragment : this.c.g()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public final void k0(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        FragmentHostCallback<?> fragmentHostCallback = this.o;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", null, printWriter, new String[0]);
            } catch (Exception unused) {
            }
        } else {
            dump("  ", null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    public boolean l(@NonNull MenuItem menuItem) {
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.c.g()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void l0() {
        boolean z2;
        synchronized (this.a) {
            z2 = true;
            if (!this.a.isEmpty()) {
                this.h.setEnabled(true);
                return;
            }
        }
        OnBackPressedCallback onBackPressedCallback = this.h;
        if (getBackStackEntryCount() <= 0 || !N(this.q)) {
            z2 = false;
        }
        onBackPressedCallback.setEnabled(z2);
    }

    public void m() {
        this.v = false;
        this.w = false;
        w(1);
    }

    public boolean n(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        if (this.n < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.c.g()) {
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z2;
    }

    public void o() {
        this.x = true;
        B(true);
        y();
        w(-1);
        this.o = null;
        this.p = null;
        this.q = null;
        if (this.g != null) {
            this.h.remove();
            this.g = null;
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public void p() {
        for (Fragment fragment : this.c.g()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void popBackStack() {
        z(new f(null, -1, 0), false);
    }

    public boolean popBackStackImmediate() {
        return U(null, -1, 0);
    }

    public void putFragment(@NonNull Bundle bundle, @NonNull String str, @NonNull Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
        } else {
            k0(new IllegalStateException(a2.b.a.a.a.X2("Fragment ", fragment, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public void q(boolean z2) {
        for (Fragment fragment : this.c.g()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
            }
        }
    }

    public boolean r(@NonNull MenuItem menuItem) {
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.c.g()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z2) {
        this.m.a.add(new i.a(fragmentLifecycleCallbacks, z2));
    }

    public void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList = this.j;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    public void s(@NonNull Menu menu) {
        if (this.n >= 1) {
            for (Fragment fragment : this.c.g()) {
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment fragment) {
        Bundle b2;
        o oVar = this.c.b.get(fragment.mWho);
        if (oVar == null || !oVar.b.equals(fragment)) {
            k0(new IllegalStateException(a2.b.a.a.a.X2("Fragment ", fragment, " is not currently in the FragmentManager")));
            throw null;
        } else if (oVar.b.mState <= -1 || (b2 = oVar.b()) == null) {
            return null;
        } else {
            return new Fragment.SavedState(b2);
        }
    }

    public void setFragmentFactory(@NonNull FragmentFactory fragmentFactory) {
        this.s = fragmentFactory;
    }

    public final void t(@Nullable Fragment fragment) {
        if (fragment != null && fragment.equals(F(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.q;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.q)));
            sb.append("}");
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.o;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.o)));
                sb.append("}");
            } else {
                sb.append(BuildConfig.ADJUST_DEFAULT_TRACKER);
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public void u(boolean z2) {
        for (Fragment fragment : this.c.g()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
            }
        }
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        i iVar = this.m;
        synchronized (iVar.a) {
            int i2 = 0;
            int size = iVar.a.size();
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (iVar.a.get(i2).a == fragmentLifecycleCallbacks) {
                    iVar.a.remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
    }

    public boolean v(@NonNull Menu menu) {
        boolean z2 = false;
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.c.g()) {
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX INFO: finally extract failed */
    public final void w(int i2) {
        try {
            this.b = true;
            this.c.d(i2);
            Q(i2, false);
            this.b = false;
            B(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void x() {
        if (this.y) {
            this.y = false;
            j0();
        }
    }

    public final void y() {
        if (!this.k.isEmpty()) {
            for (Fragment fragment : this.k.keySet()) {
                f(fragment);
                R(fragment, fragment.getStateAfterAnimating());
            }
        }
    }

    public void z(@NonNull e eVar, boolean z2) {
        if (!z2) {
            if (this.o == null) {
                if (this.x) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (isStateSaved()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            if (this.o != null) {
                this.a.add(eVar);
                d0();
            } else if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void popBackStack(@Nullable String str, int i2) {
        z(new f(str, -1, i2), false);
    }

    public boolean popBackStackImmediate(@Nullable String str, int i2) {
        return U(str, -1, i2);
    }

    public void popBackStack(int i2, int i3) {
        if (i2 >= 0) {
            z(new f(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.M2("Bad id: ", i2));
    }

    public boolean popBackStackImmediate(int i2, int i3) {
        if (i2 >= 0) {
            return U(null, i2, i3);
        }
        throw new IllegalArgumentException(a2.b.a.a.a.M2("Bad id: ", i2));
    }
}
