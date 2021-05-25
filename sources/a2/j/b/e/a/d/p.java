package a2.j.b.e.a.d;

import com.google.android.play.core.internal.ap;
import com.google.android.play.core.internal.az;
import com.google.android.play.core.internal.bj;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.cd;
import com.google.android.play.core.splitinstall.v;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public final class p implements ap {
    public static void b(ClassLoader classLoader, Set<File> set, az azVar) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File file : set) {
                hashSet.add(file.getParentFile());
            }
            Object a = k.a(classLoader);
            List list = (List) bl.a(a, "nativeLibraryDirectories", List.class).a();
            hashSet.removeAll(list);
            list.addAll(hashSet);
            ArrayList arrayList = new ArrayList();
            Object[] a3 = azVar.a(a, new ArrayList<>(hashSet), arrayList);
            if (!arrayList.isEmpty()) {
                bj bjVar = new bj("Error in makePathElements");
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    cd.a(bjVar, (IOException) arrayList.get(i));
                }
                throw bjVar;
            }
            synchronized (v.class) {
                bl.b(a, "nativeLibraryPathElements", Object.class).b(Arrays.asList(a3));
            }
        }
    }

    public static boolean c(ClassLoader classLoader, File file, File file2, boolean z, String str) {
        return k.b(classLoader, file, file2, z, new m(), str, new j());
    }

    @Override // com.google.android.play.core.internal.ap
    public final void a(ClassLoader classLoader, Set<File> set) {
        b(classLoader, set, new n());
    }

    @Override // com.google.android.play.core.internal.ap
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return c(classLoader, file, file2, z, "zip");
    }
}
