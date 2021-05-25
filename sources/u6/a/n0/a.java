package u6.a.n0;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a implements Comparable<a>, Runnable, ThreadSafeHeapNode {
    @Nullable
    public ThreadSafeHeap<?> a;
    public int b;
    public final Runnable c;
    public final long d;
    @JvmField
    public final long e;

    public a(@NotNull Runnable runnable, long j, long j2) {
        this.c = runnable;
        this.d = j;
        this.e = j2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        a aVar2 = aVar;
        long j = this.e;
        long j2 = aVar2.e;
        if (j == j2) {
            j = this.d;
            j2 = aVar2.d;
        }
        return (j > j2 ? 1 : (j == j2 ? 0 : -1));
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    @Nullable
    public ThreadSafeHeap<?> getHeap() {
        return this.a;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public int getIndex() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.run();
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setHeap(@Nullable ThreadSafeHeap<?> threadSafeHeap) {
        this.a = threadSafeHeap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setIndex(int i) {
        this.b = i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("TimedRunnable(time=");
        L.append(this.e);
        L.append(", run=");
        L.append(this.c);
        L.append(')');
        return L.toString();
    }

    public a(Runnable runnable, long j, long j2, int i) {
        j = (i & 2) != 0 ? 0 : j;
        j2 = (i & 4) != 0 ? 0 : j2;
        this.c = runnable;
        this.d = j;
        this.e = j2;
    }
}
