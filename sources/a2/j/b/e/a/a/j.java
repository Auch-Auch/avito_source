package a2.j.b.e.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.assetpacks.bc;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ak;
import com.google.android.play.core.internal.bt;
import com.google.android.play.core.internal.n;
import com.google.android.play.core.splitinstall.v;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
public final class j {
    public static final aa e = new aa("AppUpdateService");
    public static final Intent f = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");
    public ak<n> a;
    public final String b;
    public final Context c;
    public final bc d;

    public j(Context context) {
        this.b = context.getPackageName();
        this.c = context;
        if (bt.a(context)) {
            this.a = new ak<>(v.a(context), e, "AppUpdateService", f, d.a);
        }
        this.d = new bc(context);
    }

    public static Bundle a(j jVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("playcore.version.code", 10702);
        bundle.putAll(bundle2);
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(jVar.c.getPackageManager().getPackageInfo(jVar.c.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            e.b("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    public static <T> Task<T> b() {
        e.b("onError(%d)", -9);
        return Tasks.a((Exception) new InstallException(-9));
    }
}
