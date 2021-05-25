package a2.j.b.e.a.i;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ak;
import com.google.android.play.core.internal.bp;
import com.google.android.play.core.internal.bt;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.v;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public final class z {
    public static final aa c = new aa("SplitInstallService");
    public static final Intent d = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");
    public final String a;
    public ak<bp> b;

    public z(Context context) {
        this.a = context.getPackageName();
        if (bt.a(context)) {
            this.b = new ak<>(v.a(context), c, "SplitInstallService", d, h.a);
        }
    }

    public static /* synthetic */ ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static /* synthetic */ Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10702);
        return bundle;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Collection */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayList c(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("language", (String) collection.get(i));
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static <T> Task<T> d() {
        c.b("onError(%d)", -14);
        return Tasks.a((Exception) new SplitInstallException(-14));
    }
}
