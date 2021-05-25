package a2.j.b.b;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;
public final /* synthetic */ class b0 implements Supplier {
    public final /* synthetic */ AtomicBoolean a;

    public /* synthetic */ b0(AtomicBoolean atomicBoolean) {
        this.a = atomicBoolean;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return Boolean.valueOf(this.a.get());
    }
}
