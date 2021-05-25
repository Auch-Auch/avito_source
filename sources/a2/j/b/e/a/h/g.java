package a2.j.b.e.a.h;

import com.google.android.play.core.internal.cd;
import com.google.android.play.core.splitcompat.l;
import com.google.android.play.core.splitcompat.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
public final class g implements i {
    public final /* synthetic */ Set a;
    public final /* synthetic */ n b;
    public final /* synthetic */ ZipFile c;

    public g(Set set, n nVar, ZipFile zipFile) {
        this.a = set;
        this.b = nVar;
        this.c = zipFile;
    }

    @Override // a2.j.b.e.a.h.i
    public final void a(l lVar, File file, boolean z) throws IOException {
        this.a.add(file);
        if (!z) {
            String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", this.b.b(), lVar.a, this.b.a().getAbsolutePath(), lVar.b.getName(), file.getAbsolutePath());
            ZipFile zipFile = this.c;
            ZipEntry zipEntry = lVar.b;
            int i = m.a;
            byte[] bArr = new byte[4096];
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            fileOutputStream.close();
                            inputStream.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        cd.a(th, th);
                    }
                }
            } catch (Throwable th2) {
                cd.a(th, th2);
            }
        } else {
            return;
        }
        throw th;
        throw th;
    }
}
