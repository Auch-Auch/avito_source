package a2.j.b.e.a.h;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.splitcompat.e;
import java.io.File;
import java.util.Set;
public final class a {
    public final e a;

    public a(e eVar) {
        this.a = eVar;
    }

    public static final synchronized void a(Context context, Set<File> set) {
        synchronized (a.class) {
            AssetManager assets = context.getAssets();
            for (File file : set) {
                ((Integer) bl.a(assets, "addAssetPath", Integer.class, String.class, file.getPath())).intValue();
            }
        }
    }
}
