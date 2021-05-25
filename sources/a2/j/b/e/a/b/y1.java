package a2.j.b.e.a.b;

import com.google.android.play.core.assetpacks.dn;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.cd;
import com.google.android.play.core.internal.ce;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
public final class y1 {
    public static final aa c = new aa("PatchSliceTaskHandler");
    public final a0 a;
    public final ce<q2> b;

    public y1(a0 a0Var, ce<q2> ceVar) {
        this.a = a0Var;
        this.b = ceVar;
    }

    public final void a(dn dnVar) {
        File a3 = this.a.a(dnVar.b, dnVar.c, dnVar.d);
        a0 a0Var = this.a;
        String str = dnVar.b;
        int i = dnVar.c;
        long j = dnVar.d;
        String str2 = dnVar.h;
        Objects.requireNonNull(a0Var);
        File file = new File(new File(a0Var.a(str, i, j), "_metadata"), str2);
        try {
            InputStream inputStream = dnVar.j;
            if (dnVar.g == 2) {
                inputStream = new GZIPInputStream(inputStream, 8192);
            }
            try {
                c0 c0Var = new c0(a3, file);
                File file2 = new File(this.a.s(dnVar.b, dnVar.e, dnVar.f, dnVar.h), "slice.zip.tmp");
                if (file2.getParentFile() != null) {
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                }
                aq.a(c0Var, inputStream, new FileOutputStream(file2), dnVar.i);
                if (file2.renameTo(this.a.r(dnVar.b, dnVar.e, dnVar.f, dnVar.h))) {
                    inputStream.close();
                    c.c("Patching finished for slice %s of pack %s.", dnVar.h, dnVar.b);
                    this.b.a().b(dnVar.a, dnVar.b, dnVar.h, 0);
                    try {
                        dnVar.j.close();
                        return;
                    } catch (IOException unused) {
                        c.d("Could not close file for slice %s of pack %s.", dnVar.h, dnVar.b);
                        return;
                    }
                } else {
                    throw new q0(String.format("Error moving patch for slice %s of pack %s.", dnVar.h, dnVar.b), dnVar.a);
                }
            } catch (Throwable th) {
                cd.a(th, th);
            }
            throw th;
        } catch (IOException e) {
            c.b("IOException during patching %s.", e.getMessage());
            throw new q0(String.format("Error patching slice %s of pack %s.", dnVar.h, dnVar.b), e, dnVar.a);
        }
    }
}
