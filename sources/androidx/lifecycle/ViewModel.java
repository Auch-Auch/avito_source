package androidx.lifecycle;

import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public abstract class ViewModel {
    @Nullable
    public final Map<String, Object> a = new HashMap();
    public volatile boolean b = false;

    public <T> T a(String str) {
        T t;
        Map<String, Object> map = this.a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.a.get(str);
        }
        return t;
    }

    public <T> T b(String str, T t) {
        Object obj;
        synchronized (this.a) {
            obj = this.a.get(str);
            if (obj == null) {
                this.a.put(str, t);
            }
        }
        if (obj != null) {
            t = obj;
        }
        if (this.b && (t instanceof Closeable)) {
            try {
                t.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return t;
    }

    public void onCleared() {
    }
}
