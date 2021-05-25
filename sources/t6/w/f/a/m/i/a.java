package t6.w.f.a.m.i;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
public class a implements Function1<LockBasedStorageManager.f<K, V>, V> {
    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return ((LockBasedStorageManager.f) obj).b.invoke();
    }
}
