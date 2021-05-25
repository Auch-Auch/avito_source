package androidx.work;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ContentUriTriggers {
    public final Set<Trigger> a = new HashSet();

    public static final class Trigger {
        @NonNull
        public final Uri a;
        public final boolean b;

        public Trigger(@NonNull Uri uri, boolean z) {
            this.a = uri;
            this.b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Trigger.class != obj.getClass()) {
                return false;
            }
            Trigger trigger = (Trigger) obj;
            if (this.b != trigger.b || !this.a.equals(trigger.a)) {
                return false;
            }
            return true;
        }

        @NonNull
        public Uri getUri() {
            return this.a;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + (this.b ? 1 : 0);
        }

        public boolean shouldTriggerForDescendants() {
            return this.b;
        }
    }

    public void add(@NonNull Uri uri, boolean z) {
        this.a.add(new Trigger(uri, z));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ContentUriTriggers.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((ContentUriTriggers) obj).a);
    }

    @NonNull
    public Set<Trigger> getTriggers() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public int size() {
        return this.a.size();
    }
}
