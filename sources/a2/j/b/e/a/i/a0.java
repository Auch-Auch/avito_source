package a2.j.b.e.a.i;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;
public final class a0 {
    public final Context a;

    public a0(Context context) {
        this.a = context;
    }

    public final synchronized Set<String> a() {
        Set<String> stringSet;
        try {
            stringSet = this.a.getSharedPreferences("playcore_split_install_internal", 0).getStringSet("deferred_uninstall_module_list", new HashSet());
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
        } catch (Exception unused) {
            return new HashSet();
        }
        return stringSet;
    }
}
