package a2.j.b.a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Priority;
import java.util.Objects;
public final class a<T> extends Event<T> {
    public final Integer a;
    public final T b;
    public final Priority c;

    public a(@Nullable Integer num, T t, Priority priority) {
        this.a = num;
        Objects.requireNonNull(t, "Null payload");
        this.b = t;
        Objects.requireNonNull(priority, "Null priority");
        this.c = priority;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.a;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            if (this.b.equals(event.getPayload()) && this.c.equals(event.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.Event
    @Nullable
    public Integer getCode() {
        return this.a;
    }

    @Override // com.google.android.datatransport.Event
    public T getPayload() {
        return this.b;
    }

    @Override // com.google.android.datatransport.Event
    public Priority getPriority() {
        return this.c;
    }

    public int hashCode() {
        Integer num = this.a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Event{code=");
        L.append(this.a);
        L.append(", payload=");
        L.append((Object) this.b);
        L.append(", priority=");
        L.append(this.c);
        L.append("}");
        return L.toString();
    }
}
