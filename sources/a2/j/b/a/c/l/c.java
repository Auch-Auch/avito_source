package a2.j.b.a.c.l;

import a2.b.a.a.a;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Objects;
public final class c extends CreationContext {
    public final Context a;
    public final Clock b;
    public final Clock c;
    public final String d;

    public c(Context context, Clock clock, Clock clock2, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.a = context;
        Objects.requireNonNull(clock, "Null wallClock");
        this.b = clock;
        Objects.requireNonNull(clock2, "Null monotonicClock");
        this.c = clock2;
        Objects.requireNonNull(str, "Null backendName");
        this.d = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        if (!this.a.equals(creationContext.getApplicationContext()) || !this.b.equals(creationContext.getWallClock()) || !this.c.equals(creationContext.getMonotonicClock()) || !this.d.equals(creationContext.getBackendName())) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Context getApplicationContext() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    @NonNull
    public String getBackendName() {
        return this.d;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock getMonotonicClock() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock getWallClock() {
        return this.b;
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        StringBuilder L = a.L("CreationContext{applicationContext=");
        L.append(this.a);
        L.append(", wallClock=");
        L.append(this.b);
        L.append(", monotonicClock=");
        L.append(this.c);
        L.append(", backendName=");
        return a.t(L, this.d, "}");
    }
}
