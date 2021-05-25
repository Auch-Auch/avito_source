package x6.d.a.o;

import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
public final /* synthetic */ class b extends PropertyReference0 {
    public b(Kodein.Key key) {
        super(key);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return ((Kodein.Key) this.receiver).getBindDescription();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "bindDescription";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Kodein.Key.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getBindDescription()Ljava/lang/String;";
    }
}
