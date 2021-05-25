package a2.j.b.e.a.d;

import com.google.android.play.core.internal.at;
import com.google.android.play.core.internal.bl;
import java.io.File;
public final class t implements at {
    @Override // com.google.android.play.core.internal.at
    public final boolean a(Object obj, File file, File file2) {
        try {
            return !((Boolean) bl.a(Class.forName("dalvik.system.DexFile"), "isDexOptNeeded", Boolean.class, String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
