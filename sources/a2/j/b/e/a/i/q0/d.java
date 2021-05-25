package a2.j.b.e.a.i.q0;

import android.os.SystemClock;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.util.List;
public final class d implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ List d;
    public final /* synthetic */ FakeSplitInstallManager e;

    public d(FakeSplitInstallManager fakeSplitInstallManager, long j, List list, List list2, List list3) {
        this.e = fakeSplitInstallManager;
        this.a = j;
        this.b = list;
        this.c = list2;
        this.d = list3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j = this.a / 3;
        long j2 = 0;
        int i = 0;
        while (((long) i) < 3) {
            j2 = Math.min(this.a, j2 + j);
            FakeSplitInstallManager fakeSplitInstallManager = this.e;
            Long valueOf = Long.valueOf(j2);
            int i2 = FakeSplitInstallManager.n;
            fakeSplitInstallManager.d(2, 0, valueOf, null, null, null, null);
            i++;
            SystemClock.sleep(FakeSplitInstallManager.m);
        }
        if (this.e.l.get()) {
            this.e.d(6, -6, null, null, null, null, null);
        } else {
            this.e.c(this.b, this.c, this.d, this.a, false);
        }
    }
}
