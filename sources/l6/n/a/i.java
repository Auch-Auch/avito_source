package l6.n.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
public class i {
    @NonNull
    public final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList<>();
    @NonNull
    public final FragmentManager b;

    public static final class a {
        @NonNull
        public final FragmentManager.FragmentLifecycleCallbacks a;
        public final boolean b;

        public a(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            this.a = fragmentLifecycleCallbacks;
            this.b = z;
        }
    }

    public i(@NonNull FragmentManager fragmentManager) {
        this.b = fragmentManager;
    }

    public void a(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.a(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentActivityCreated(this.b, fragment, bundle);
            }
        }
    }

    public void b(@NonNull Fragment fragment, @NonNull Context context, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.b(fragment, context, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentAttached(this.b, fragment, context);
            }
        }
    }

    public void c(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.c(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentCreated(this.b, fragment, bundle);
            }
        }
    }

    public void d(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.d(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentDestroyed(this.b, fragment);
            }
        }
    }

    public void e(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.e(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentDetached(this.b, fragment);
            }
        }
    }

    public void f(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.f(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentPaused(this.b, fragment);
            }
        }
    }

    public void g(@NonNull Fragment fragment, @NonNull Context context, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.g(fragment, context, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentPreAttached(this.b, fragment, context);
            }
        }
    }

    public void h(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.h(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentPreCreated(this.b, fragment, bundle);
            }
        }
    }

    public void i(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.i(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentResumed(this.b, fragment);
            }
        }
    }

    public void j(@NonNull Fragment fragment, @NonNull Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.j(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentSaveInstanceState(this.b, fragment, bundle);
            }
        }
    }

    public void k(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.k(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentStarted(this.b, fragment);
            }
        }
    }

    public void l(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.l(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentStopped(this.b, fragment);
            }
        }
    }

    public void m(@NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentViewCreated(this.b, fragment, view, bundle);
            }
        }
    }

    public void n(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.q;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().m.n(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.onFragmentViewDestroyed(this.b, fragment);
            }
        }
    }
}
