package a2.g.r;

import a2.b.a.a.a;
import android.net.Uri;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.OutputStream;
public class g {
    public static final String a = "g";
    public static final String b = a.c3(g.class.getSimpleName(), "_Redirect");
    public static FileLruCache c;

    public static void a(Uri uri, Uri uri2) {
        if (uri != null && uri2 != null) {
            OutputStream outputStream = null;
            try {
                outputStream = b().openPutStream(uri.toString(), b);
                outputStream.write(uri2.toString().getBytes());
            } catch (IOException unused) {
            } catch (Throwable th) {
                Utility.closeQuietly(outputStream);
                throw th;
            }
            Utility.closeQuietly(outputStream);
        }
    }

    public static synchronized FileLruCache b() throws IOException {
        FileLruCache fileLruCache;
        synchronized (g.class) {
            if (c == null) {
                c = new FileLruCache(a, new FileLruCache.Limits());
            }
            fileLruCache = c;
        }
        return fileLruCache;
    }
}
