package com.avito.android.analytics.inhouse_transport;

import a2.a.a.i.g.a;
import a2.a.a.i.g.b;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import dagger.Lazy;
import java.util.List;
import java.util.Objects;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B=\u0012\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0!\u0012\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020&8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/HotSwapEventStorage;", "", "T", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "event", "", ProductAction.ACTION_ADD, "(Ljava/lang/Object;)V", "", "events", "addAll", "(Ljava/util/List;)V", "extractAll", "()Ljava/util/List;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "lock", "Ldagger/Lazy;", "Lcom/avito/android/analytics/inhouse_transport/OnDiskEventStorage;", "d", "Ldagger/Lazy;", "onDiskStorage", "", "getEventCount", "()I", "eventCount", "Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;", "e", "Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;", "trimmer", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "_delegate", "Ljavax/inject/Provider;", "Lcom/avito/android/analytics/inhouse_transport/InMemoryEventStorage;", "c", "Ljavax/inject/Provider;", "inMemoryStorage", "", "isEmpty", "()Z", "<init>", "(Ljavax/inject/Provider;Ldagger/Lazy;Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;)V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public final class HotSwapEventStorage<T> implements InHouseEventStorage<T> {
    public final Object a = new Object();
    @GuardedBy("lock")
    public InHouseEventStorage<T> b;
    public final Provider<InMemoryEventStorage<T>> c;
    public final Lazy<OnDiskEventStorage<T>> d;
    public final OverflowTrimmer<T> e;

    public HotSwapEventStorage(@NotNull Provider<InMemoryEventStorage<T>> provider, @NotNull Lazy<OnDiskEventStorage<T>> lazy, @NotNull OverflowTrimmer<T> overflowTrimmer) {
        Intrinsics.checkNotNullParameter(provider, "inMemoryStorage");
        Intrinsics.checkNotNullParameter(lazy, "onDiskStorage");
        Intrinsics.checkNotNullParameter(overflowTrimmer, "trimmer");
        this.c = provider;
        this.d = lazy;
        this.e = overflowTrimmer;
    }

    public static final InHouseEventStorage access$getDelegate$p(HotSwapEventStorage hotSwapEventStorage) {
        InMemoryEventStorage<T> inMemoryEventStorage;
        InHouseEventStorage<T> inHouseEventStorage = hotSwapEventStorage.b;
        if (inHouseEventStorage != null) {
            return inHouseEventStorage;
        }
        synchronized (hotSwapEventStorage.a) {
            try {
                inMemoryEventStorage = hotSwapEventStorage.d.get();
            } catch (Throwable unused) {
                inMemoryEventStorage = hotSwapEventStorage.c.get();
            }
            hotSwapEventStorage.b = inMemoryEventStorage;
            Intrinsics.checkNotNull(inMemoryEventStorage);
        }
        return inMemoryEventStorage;
    }

    public static final void access$hotSwap(HotSwapEventStorage hotSwapEventStorage) {
        InMemoryEventStorage<T> inMemoryEventStorage = hotSwapEventStorage.c.get();
        Intrinsics.checkNotNullExpressionValue(inMemoryEventStorage, "inMemoryStorage.get()");
        InMemoryEventStorage<T> inMemoryEventStorage2 = inMemoryEventStorage;
        synchronized (hotSwapEventStorage.a) {
            hotSwapEventStorage.b = inMemoryEventStorage2;
        }
    }

    public static final void access$logErrorForDelegate(HotSwapEventStorage hotSwapEventStorage, InHouseEventStorage inHouseEventStorage, Throwable th) {
        Objects.requireNonNull(hotSwapEventStorage);
        if (inHouseEventStorage instanceof OnDiskEventStorage) {
            Logs.error(new b(th));
        } else {
            Logs.error(new a(th));
        }
    }

    public static final void access$markStorageDirty(HotSwapEventStorage hotSwapEventStorage, InHouseEventStorage inHouseEventStorage) {
        Objects.requireNonNull(hotSwapEventStorage);
        inHouseEventStorage.markDirty();
    }

    public static final void access$setDelegate$p(HotSwapEventStorage hotSwapEventStorage, InHouseEventStorage inHouseEventStorage) {
        synchronized (hotSwapEventStorage.a) {
            hotSwapEventStorage.b = inHouseEventStorage;
        }
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public void add(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "event");
        synchronized (this.a) {
            try {
                access$getDelegate$p(this).add(t);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                access$logErrorForDelegate(this, access$getDelegate$p(this), th);
                access$markStorageDirty(this, access$getDelegate$p(this));
                access$hotSwap(this);
                access$getDelegate$p(this).add(t);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public void addAll(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        synchronized (this.a) {
            try {
                InHouseEventStorage access$getDelegate$p = access$getDelegate$p(this);
                access$getDelegate$p.addAll(this.e.trimToSave(list, access$getDelegate$p.getEventCount()));
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                access$logErrorForDelegate(this, access$getDelegate$p(this), th);
                access$markStorageDirty(this, access$getDelegate$p(this));
                access$hotSwap(this);
                InHouseEventStorage access$getDelegate$p2 = access$getDelegate$p(this);
                access$getDelegate$p2.addAll(this.e.trimToSave(list, access$getDelegate$p2.getEventCount()));
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    @NotNull
    public List<T> extractAll() {
        List<T> list;
        synchronized (this.a) {
            try {
                list = this.e.trimToExtract(access$getDelegate$p(this).extractAll());
            } catch (Throwable th) {
                access$logErrorForDelegate(this, access$getDelegate$p(this), th);
                access$markStorageDirty(this, access$getDelegate$p(this));
                access$hotSwap(this);
                list = this.e.trimToExtract(access$getDelegate$p(this).extractAll());
            }
        }
        return list;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public int getEventCount() {
        int i;
        synchronized (this.a) {
            try {
                i = access$getDelegate$p(this).getEventCount();
            } catch (Throwable th) {
                access$logErrorForDelegate(this, access$getDelegate$p(this), th);
                access$markStorageDirty(this, access$getDelegate$p(this));
                access$hotSwap(this);
                i = access$getDelegate$p(this).getEventCount();
            }
        }
        return i;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public boolean isEmpty() {
        boolean z;
        synchronized (this.a) {
            try {
                z = access$getDelegate$p(this).isEmpty();
            } catch (Throwable th) {
                access$logErrorForDelegate(this, access$getDelegate$p(this), th);
                access$markStorageDirty(this, access$getDelegate$p(this));
                access$hotSwap(this);
                z = access$getDelegate$p(this).isEmpty();
            }
        }
        return z;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public void markDirty() {
        InHouseEventStorage.DefaultImpls.markDirty(this);
    }
}
