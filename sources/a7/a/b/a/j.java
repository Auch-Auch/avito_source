package a7.a.b.a;

import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.entity.messenger.SystemEvent;
public final /* synthetic */ class j extends PropertyReference1Impl {
    public static final KProperty1 a = new j();

    public j() {
        super(SystemEvent.class, "value", "getValue()Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    @Nullable
    public Object get(@Nullable Object obj) {
        return ((SystemEvent) obj).getValue();
    }
}
