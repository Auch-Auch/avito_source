package a2.j.b.e.a.b;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ak;
import com.google.android.play.core.internal.bt;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.splitinstall.v;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
public final class r implements q2 {
    public static final aa f = new aa("AssetPackServiceImpl");
    public static final Intent g = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    public final String a;
    public final t0 b;
    public ak<s> c;
    public ak<s> d;
    public final AtomicBoolean e = new AtomicBoolean();

    public r(Context context, t0 t0Var) {
        this.a = context.getPackageName();
        this.b = t0Var;
        if (bt.a(context)) {
            Context a3 = v.a(context);
            aa aaVar = f;
            Intent intent = g;
            this.c = new ak<>(a3, aaVar, "AssetPackService", intent, r2.a);
            this.d = new ak<>(v.a(context), aaVar, "AssetPackService-keepAlive", intent, s2.a);
        }
        f.a("AssetPackService initiated.", new Object[0]);
    }

    public static /* synthetic */ ArrayList e(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static /* synthetic */ Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10702);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList<>());
        return bundle;
    }

    public static Bundle h(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID, i);
        bundle.putString("module_name", str);
        bundle.putString("slice_id", str2);
        bundle.putInt("chunk_number", i2);
        return bundle;
    }

    public static <T> Task<T> i() {
        f.b("onError(%d)", -11);
        return Tasks.a((Exception) new AssetPackException(-11));
    }

    @Override // a2.j.b.e.a.b.q2
    public final Task<List<String>> a() {
        if (this.c == null) {
            return i();
        }
        i H1 = a.H1(f, "syncPacks", new Object[0]);
        this.c.a(new d(this, H1, H1));
        return H1.a();
    }

    @Override // a2.j.b.e.a.b.q2
    public final Task<ParcelFileDescriptor> a(int i, String str, String str2, int i2) {
        if (this.c == null) {
            return i();
        }
        i H1 = a.H1(f, "getChunkFileDescriptor(%s, %s, %d, session=%d)", new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i)});
        this.c.a(new i(this, H1, i, str, str2, i2, H1));
        return H1.a();
    }

    @Override // a2.j.b.e.a.b.q2
    public final void a(int i) {
        if (this.c != null) {
            i H1 = a.H1(f, "notifySessionFailed", new Object[0]);
            this.c.a(new h(this, H1, i, H1));
            return;
        }
        throw new q0("The Play Store app is not installed or is an unofficial version.", i);
    }

    @Override // a2.j.b.e.a.b.q2
    public final void a(int i, String str) {
        f(i, str, 10);
    }

    @Override // a2.j.b.e.a.b.q2
    public final void a(String str) {
        if (this.c != null) {
            i H1 = a.H1(f, "removePack(%s)", new Object[]{str});
            this.c.a(new a(this, H1, str, H1));
        }
    }

    @Override // a2.j.b.e.a.b.q2
    public final void a(List<String> list) {
        if (this.c != null) {
            i H1 = a.H1(f, "cancelDownloads(%s)", new Object[]{list});
            this.c.a(new c(this, H1, list, H1));
        }
    }

    @Override // a2.j.b.e.a.b.q2
    public final synchronized void b() {
        if (this.d != null) {
            aa aaVar = f;
            aaVar.c("keepAlive", new Object[0]);
            if (!this.e.compareAndSet(false, true)) {
                aaVar.c("Service is already kept alive.", new Object[0]);
                return;
            }
            i iVar = new i();
            this.d.a(new j(this, iVar, iVar));
            return;
        }
        f.d("Keep alive connection manager is not initialized.", new Object[0]);
    }

    @Override // a2.j.b.e.a.b.q2
    public final void b(int i, String str, String str2, int i2) {
        if (this.c != null) {
            i H1 = a.H1(f, "notifyChunkTransferred", new Object[0]);
            this.c.a(new f(this, H1, i, str, str2, i2, H1));
            return;
        }
        throw new q0("The Play Store app is not installed or is an unofficial version.", i);
    }

    @Override // a2.j.b.e.a.b.q2
    public final Task<AssetPackStates> c(List<String> list, List<String> list2) {
        if (this.c == null) {
            return i();
        }
        i H1 = a.H1(f, "startDownload(%s)", new Object[]{list2});
        this.c.a(new b(this, H1, list2, H1, list));
        H1.a().addOnSuccessListener(new OnSuccessListener(this) { // from class: a2.j.b.e.a.b.t2
            public final r a;

            {
                this.a = r1;
            }

            @Override // com.google.android.play.core.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                AssetPackStates assetPackStates = (AssetPackStates) obj;
                this.a.b();
            }
        });
        return H1.a();
    }

    @Override // a2.j.b.e.a.b.q2
    public final Task<AssetPackStates> d(List<String> list, x xVar) {
        if (this.c == null) {
            return i();
        }
        i H1 = a.H1(f, "getPackStates(%s)", new Object[]{list});
        this.c.a(new e(this, H1, list, H1, xVar));
        return H1.a();
    }

    public final void f(int i, String str, int i2) {
        if (this.c != null) {
            i H1 = a.H1(f, "notifyModuleCompleted", new Object[0]);
            this.c.a(new g(this, H1, i, str, H1, i2));
            return;
        }
        throw new q0("The Play Store app is not installed or is an unofficial version.", i);
    }
}
