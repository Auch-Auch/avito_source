package l6.n.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.LogWriter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;
public final class a extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.e {
    public final FragmentManager t;
    public boolean u;
    public int v;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager r3) {
        /*
            r2 = this;
            androidx.fragment.app.FragmentFactory r0 = r3.getFragmentFactory()
            androidx.fragment.app.FragmentHostCallback<?> r1 = r3.o
            if (r1 == 0) goto L_0x000f
            android.content.Context r1 = r1.b
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            r2.<init>(r0, r1)
            r0 = -1
            r2.v = r0
            r2.t = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.n.a.a.<init>(androidx.fragment.app.FragmentManager):void");
    }

    public static boolean l(FragmentTransaction.a aVar) {
        Fragment fragment = aVar.b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    @Override // androidx.fragment.app.FragmentManager.e
    public boolean a(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.L(2)) {
            String str = "Run: " + this;
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.i) {
            return true;
        }
        FragmentManager fragmentManager = this.t;
        if (fragmentManager.d == null) {
            fragmentManager.d = new ArrayList<>();
        }
        fragmentManager.d.add(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return f(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return f(true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.t.C(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.t.C(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void d(int i, Fragment fragment, @Nullable String str, int i2) {
        super.d(i, fragment, str, i2);
        fragment.mFragmentManager = this.t;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.detach(fragment);
        }
        StringBuilder L = a2.b.a.a.a.L("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
        L.append(fragment.toString());
        L.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(L.toString());
    }

    public void e(int i) {
        if (this.i) {
            if (FragmentManager.L(2)) {
                String str = "Bump nesting in " + this + " by " + i;
            }
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.a aVar = this.c.get(i2);
                Fragment fragment = aVar.b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (FragmentManager.L(2)) {
                        StringBuilder L = a2.b.a.a.a.L("Bump nesting of ");
                        L.append(aVar.b);
                        L.append(" to ");
                        L.append(aVar.b.mBackStackNesting);
                        L.toString();
                    }
                }
            }
        }
    }

    public int f(boolean z) {
        if (!this.u) {
            if (FragmentManager.L(2)) {
                String str = "Commit: " + this;
                PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                g("  ", printWriter, true);
                printWriter.close();
            }
            this.u = true;
            if (this.i) {
                this.v = this.t.i.getAndIncrement();
            } else {
                this.v = -1;
            }
            this.t.z(this, z);
            return this.v;
        }
        throw new IllegalStateException("commit already called");
    }

    public void g(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.u);
            if (this.h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.h));
            }
            if (!(this.d == 0 && this.e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (!(this.f == 0 && this.g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (!(this.l == 0 && this.m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.m);
            }
            if (!(this.n == 0 && this.o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        if (!this.c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                FragmentTransaction.a aVar = this.c.get(i);
                switch (aVar.a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        StringBuilder L = a2.b.a.a.a.L("cmd=");
                        L.append(aVar.a);
                        str2 = L.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.b);
                if (z) {
                    if (!(aVar.c == 0 && aVar.d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        int i = this.n;
        if (i != 0) {
            return this.t.o.b.getText(i);
        }
        return this.o;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.n;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbTitle() {
        int i = this.l;
        if (i != 0) {
            return this.t.o.b.getText(i);
        }
        return this.m;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.l;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.v;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public String getName() {
        return this.k;
    }

    public void h() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction.a aVar = this.c.get(i);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.setNextTransition(this.h);
            }
            switch (aVar.a) {
                case 1:
                    fragment.setNextAnim(aVar.c);
                    this.t.e0(fragment, false);
                    this.t.b(fragment);
                    break;
                case 2:
                default:
                    StringBuilder L = a2.b.a.a.a.L("Unknown cmd: ");
                    L.append(aVar.a);
                    throw new IllegalArgumentException(L.toString());
                case 3:
                    fragment.setNextAnim(aVar.d);
                    this.t.W(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.d);
                    this.t.K(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.c);
                    this.t.e0(fragment, false);
                    this.t.i0(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.d);
                    this.t.j(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.c);
                    this.t.e0(fragment, false);
                    this.t.e(fragment);
                    break;
                case 8:
                    this.t.g0(fragment);
                    break;
                case 9:
                    this.t.g0(null);
                    break;
                case 10:
                    this.t.f0(fragment, aVar.h);
                    break;
            }
            if (!(this.r || aVar.a == 1 || fragment == null)) {
                this.t.P(fragment);
            }
        }
        if (!this.r) {
            FragmentManager fragmentManager = this.t;
            fragmentManager.Q(fragmentManager.n, true);
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.hide(fragment);
        }
        StringBuilder L = a2.b.a.a.a.L("Cannot hide Fragment attached to a different FragmentManager. Fragment ");
        L.append(fragment.toString());
        L.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(L.toString());
    }

    public void i(boolean z) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            FragmentTransaction.a aVar = this.c.get(size);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                int i = this.h;
                int i2 = 8194;
                if (i != 4097) {
                    i2 = i != 4099 ? i != 8194 ? 0 : 4097 : 4099;
                }
                fragment.setNextTransition(i2);
            }
            switch (aVar.a) {
                case 1:
                    fragment.setNextAnim(aVar.f);
                    this.t.e0(fragment, true);
                    this.t.W(fragment);
                    break;
                case 2:
                default:
                    StringBuilder L = a2.b.a.a.a.L("Unknown cmd: ");
                    L.append(aVar.a);
                    throw new IllegalArgumentException(L.toString());
                case 3:
                    fragment.setNextAnim(aVar.e);
                    this.t.b(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.e);
                    this.t.i0(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f);
                    this.t.e0(fragment, true);
                    this.t.K(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.e);
                    this.t.e(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f);
                    this.t.e0(fragment, true);
                    this.t.j(fragment);
                    break;
                case 8:
                    this.t.g0(null);
                    break;
                case 9:
                    this.t.g0(fragment);
                    break;
                case 10:
                    this.t.f0(fragment, aVar.g);
                    break;
            }
            if (!(this.r || aVar.a == 3 || fragment == null)) {
                this.t.P(fragment);
            }
        }
        if (!this.r && z) {
            FragmentManager fragmentManager = this.t;
            fragmentManager.Q(fragmentManager.n, true);
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    public boolean j(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.c.get(i2).b;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean k(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.c.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.c.get(i4).b;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.c.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = aVar.c.get(i7).b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.remove(fragment);
        }
        StringBuilder L = a2.b.a.a.a.L("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        L.append(fragment.toString());
        L.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(L.toString());
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.mFragmentManager == this.t) {
            Lifecycle.State state2 = Lifecycle.State.CREATED;
            if (state.isAtLeast(state2)) {
                return super.setMaxLifecycle(fragment, state);
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + state2);
        }
        StringBuilder L = a2.b.a.a.a.L("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
        L.append(this.t);
        throw new IllegalArgumentException(L.toString());
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        StringBuilder L = a2.b.a.a.a.L("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
        L.append(fragment.toString());
        L.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(L.toString());
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.show(fragment);
        }
        StringBuilder L = a2.b.a.a.a.L("Cannot show Fragment attached to a different FragmentManager. Fragment ");
        L.append(fragment.toString());
        L.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(L.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }
}
