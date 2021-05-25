package x6.d.a.o;

import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
public final /* synthetic */ class a extends PropertyReference0 {
    public a(Kodein.Key key) {
        super(key);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return ((Kodein.Key) this.receiver).getBindFullDescription();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "bindFullDescription";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Kodein.Key.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getBindFullDescription()Ljava/lang/String;";
    }
}
