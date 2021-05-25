package a2.j.b.e.a.b;

import android.os.Bundle;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ce;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
public final class i1 {
    public static final aa g = new aa("ExtractorSessionStoreView");
    public final a0 a;
    public final ce<q2> b;
    public final t0 c;
    public final ce<Executor> d;
    public final Map<Integer, f1> e = new HashMap();
    public final ReentrantLock f = new ReentrantLock();

    public i1(a0 a0Var, ce<q2> ceVar, t0 t0Var, ce<Executor> ceVar2) {
        this.a = a0Var;
        this.b = ceVar;
        this.c = t0Var;
        this.d = ceVar2;
    }

    public static String d(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new q0("Session without pack received.");
    }

    public final <T> T a(h1<T> h1Var) {
        try {
            this.f.lock();
            return h1Var.a();
        } finally {
            this.f.unlock();
        }
    }

    public final void b(int i) {
        a(new a1(this, i));
    }

    public final f1 c(int i) {
        Map<Integer, f1> map = this.e;
        Integer valueOf = Integer.valueOf(i);
        f1 f1Var = map.get(valueOf);
        if (f1Var != null) {
            return f1Var;
        }
        throw new q0(String.format("Could not find session %d while trying to get it", valueOf), i);
    }
}
