package a2.j.e.d.d.a;

import a2.b.a.a.a;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;
public class h0 {
    public final String a;
    public final FileStore b;

    public h0(String str, FileStore fileStore) {
        this.a = str;
        this.b = fileStore;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            StringBuilder L = a.L("Error creating marker: ");
            L.append(this.a);
            logger.e(L.toString(), e);
            return false;
        }
    }

    public final File b() {
        return new File(this.b.getFilesDir(), this.a);
    }
}
