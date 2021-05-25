package a2.j.b.e.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.play.core.internal.aa;
public final class x1 {
    public static final aa c = new aa("PackageStateCache");
    public final Context a;
    public int b = -1;

    public x1(Context context) {
        this.a = context;
    }

    public final synchronized int a() {
        if (this.b == -1) {
            try {
                this.b = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                c.b("The current version of the app could not be retrieved", new Object[0]);
            }
        }
        return this.b;
    }
}
