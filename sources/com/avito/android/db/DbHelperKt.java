package com.avito.android.db;

import a2.b.a.a.a;
import com.avito.android.util.Logs;
import java.io.File;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"core_release"}, k = 2, mv = {1, 4, 2})
public final class DbHelperKt {
    public static final void access$deleteSafely(File file) {
        try {
            file.delete();
        } catch (Exception unused) {
            StringBuilder L = a.L("Cannot delete file ");
            L.append(file.getName());
            Logs.error$default(L.toString(), null, 2, null);
        }
    }
}
