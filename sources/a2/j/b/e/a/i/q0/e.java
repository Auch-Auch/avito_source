package a2.j.b.e.a.i.q0;

import android.content.Intent;
import com.google.android.play.core.splitinstall.b;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.util.List;
public final class e implements b {
    public final /* synthetic */ List a;
    public final /* synthetic */ List b;
    public final /* synthetic */ long c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ List e;
    public final /* synthetic */ FakeSplitInstallManager f;

    public e(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, long j, boolean z, List list3) {
        this.f = fakeSplitInstallManager;
        this.a = list;
        this.b = list2;
        this.c = j;
        this.d = z;
        this.e = list3;
    }

    @Override // com.google.android.play.core.splitinstall.b
    public final void a() {
        this.f.j.addAll(this.a);
        this.f.k.addAll(this.b);
        this.f.d(5, 0, Long.valueOf(this.c), null, null, null, null);
    }

    @Override // com.google.android.play.core.splitinstall.b
    public final void b() {
        if (!this.d) {
            FakeSplitInstallManager fakeSplitInstallManager = this.f;
            List<Intent> list = this.e;
            List<String> list2 = this.a;
            List<String> list3 = this.b;
            long j = this.c;
            int i = FakeSplitInstallManager.n;
            fakeSplitInstallManager.c(list, list2, list3, j, true);
        }
    }

    @Override // com.google.android.play.core.splitinstall.b
    public final void a(int i) {
        FakeSplitInstallManager fakeSplitInstallManager = this.f;
        int i2 = FakeSplitInstallManager.n;
        fakeSplitInstallManager.d(6, i, null, null, null, null, null);
    }
}
