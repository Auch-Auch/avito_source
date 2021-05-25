package com.avito.android.analytics.inhouse_transport;

import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/InMemoryEventStorage;", "", "T", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "event", "", ProductAction.ACTION_ADD, "(Ljava/lang/Object;)V", "", "events", "addAll", "(Ljava/util/List;)V", "extractAll", "()Ljava/util/List;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "lock", "", "c", "I", "defaultCapacity", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "", "isEmpty", "()Z", "getEventCount", "()I", "eventCount", "<init>", "(I)V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public class InMemoryEventStorage<T> implements InHouseEventStorage<T> {
    public final Object a = new Object();
    @GuardedBy("lock")
    public List<T> b;
    public final int c;

    public InMemoryEventStorage(int i) {
        this.c = i;
        this.b = new ArrayList((int) (((double) i) * 1.5d));
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public void add(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "event");
        synchronized (this.a) {
            this.b.add(t);
        }
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public void addAll(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        synchronized (this.a) {
            this.b.addAll(list);
        }
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    @NotNull
    public List<T> extractAll() {
        List<T> list;
        synchronized (this.a) {
            list = this.b;
            this.b = new ArrayList((int) (((double) this.c) * 1.5d));
        }
        return list;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public int getEventCount() {
        int size;
        synchronized (this.a) {
            size = this.b.size();
        }
        return size;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public boolean isEmpty() {
        boolean z;
        synchronized (this.a) {
            z = getEventCount() == 0;
        }
        return z;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public void markDirty() {
        InHouseEventStorage.DefaultImpls.markDirty(this);
    }
}
