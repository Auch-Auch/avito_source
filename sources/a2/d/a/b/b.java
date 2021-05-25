package a2.d.a.b;

import a2.b.a.a.a;
import com.google.android.exoplayer2.C;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
public final class b {
    public static final Charset a = Charset.forName(C.ASCII_NAME);
    public static final Charset b = Charset.forName("UTF-8");

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (!file2.delete()) {
                    throw new IOException(a.Y2("failed to delete file: ", file2));
                }
            }
            return;
        }
        throw new IOException(a.Y2("not a readable directory: ", file));
    }
}
