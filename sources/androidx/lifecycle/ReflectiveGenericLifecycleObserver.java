package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import l6.p.a;
public class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    public final Object a;
    public final a.C0533a b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.b = a.c.b(obj.getClass());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        a.C0533a aVar = this.b;
        Object obj = this.a;
        a.C0533a.a(aVar.a.get(event), lifecycleOwner, event, obj);
        a.C0533a.a(aVar.a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
    }
}
