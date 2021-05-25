package a2.j.b.a.c.m.d;

import a2.b.a.a.a;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import java.util.Objects;
public final class b extends PersistedEvent {
    public final long a;
    public final TransportContext b;
    public final EventInternal c;

    public b(long j, TransportContext transportContext, EventInternal eventInternal) {
        this.a = j;
        Objects.requireNonNull(transportContext, "Null transportContext");
        this.b = transportContext;
        Objects.requireNonNull(eventInternal, "Null event");
        this.c = eventInternal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        if (this.a != persistedEvent.getId() || !this.b.equals(persistedEvent.getTransportContext()) || !this.c.equals(persistedEvent.getEvent())) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public EventInternal getEvent() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public long getId() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public TransportContext getTransportContext() {
        return this.b;
    }

    public int hashCode() {
        long j = this.a;
        return this.c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder L = a.L("PersistedEvent{id=");
        L.append(this.a);
        L.append(", transportContext=");
        L.append(this.b);
        L.append(", event=");
        L.append(this.c);
        L.append("}");
        return L.toString();
    }
}
