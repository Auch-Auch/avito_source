package a2.j.b.e.a.i.q0;

import android.content.Intent;
import android.net.Uri;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public final class b implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ List b;
    public final /* synthetic */ FakeSplitInstallManager c;

    public b(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2) {
        this.c = fakeSplitInstallManager;
        this.a = list;
        this.b = list2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FakeSplitInstallManager fakeSplitInstallManager = this.c;
        List list = this.a;
        List list2 = this.b;
        int i = FakeSplitInstallManager.n;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            File file = (File) list.get(i2);
            String a3 = aq.a(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, fakeSplitInstallManager.b.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", FakeSplitInstallManager.b(a3));
            intent.putExtra("split_id", a3);
            arrayList.add(intent);
            arrayList2.add(FakeSplitInstallManager.b(aq.a(file)));
        }
        SplitInstallSessionState e = fakeSplitInstallManager.e();
        if (e != null) {
            fakeSplitInstallManager.g.execute(new d(fakeSplitInstallManager, e.totalBytesToDownload(), arrayList, arrayList2, list2));
        }
    }
}
