package a2.j.b.e.a.d;

import com.google.android.play.core.internal.ap;
import com.google.android.play.core.internal.at;
import com.google.android.play.core.internal.au;
import com.google.android.play.core.internal.bj;
import com.google.android.play.core.internal.bk;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.cd;
import com.google.android.play.core.splitinstall.v;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public final class k implements ap {
    public static Object a(ClassLoader classLoader) {
        return bl.a(classLoader, "pathList", Object.class).a();
    }

    public static boolean b(ClassLoader classLoader, File file, File file2, boolean z, au auVar, String str, at atVar) {
        ArrayList<IOException> arrayList = new ArrayList<>();
        Object a = a(classLoader);
        bk b = bl.b(a, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) b.a());
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : asList) {
            arrayList2.add((File) bl.a(obj, str, File.class).a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (!z && !atVar.a(a, file2, file)) {
            String valueOf = String.valueOf(file2.getPath());
            if (valueOf.length() == 0) {
                new String("Should be optimized ");
            } else {
                "Should be optimized ".concat(valueOf);
            }
            return false;
        }
        b.a((Collection) Arrays.asList(auVar.a(a, new ArrayList<>(Collections.singleton(file2)), file, arrayList)));
        if (arrayList.isEmpty()) {
            return true;
        }
        bj bjVar = new bj("DexPathList.makeDexElement failed");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            cd.a(bjVar, arrayList.get(i));
        }
        bl.b(a, "dexElementsSuppressedExceptions", IOException.class).a((Collection) arrayList);
        throw bjVar;
    }

    public static void c(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File file : set) {
                String valueOf = String.valueOf(file.getParentFile().getAbsolutePath());
                if (valueOf.length() == 0) {
                    new String("Adding native library parent directory: ");
                } else {
                    "Adding native library parent directory: ".concat(valueOf);
                }
                hashSet.add(file.getParentFile());
            }
            bk b = bl.b(a(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) b.a()));
            synchronized (v.class) {
                hashSet.size();
                b.b(hashSet);
            }
        }
    }

    @Override // com.google.android.play.core.internal.ap
    public final void a(ClassLoader classLoader, Set<File> set) {
        c(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.ap
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return b(classLoader, file, file2, z, new i(), "zip", new j());
    }
}
