package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B#\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavArgsLazy;", "Landroidx/navigation/NavArgs;", "Args", "Lkotlin/Lazy;", "", "isInitialized", "()Z", "Lkotlin/reflect/KClass;", AuthSource.BOOKING_ORDER, "Lkotlin/reflect/KClass;", "navArgsClass", "Lkotlin/Function0;", "Landroid/os/Bundle;", "c", "Lkotlin/jvm/functions/Function0;", "argumentProducer", "getValue", "()Landroidx/navigation/NavArgs;", "value", AuthSource.SEND_ABUSE, "Landroidx/navigation/NavArgs;", "cached", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "navigation-common-ktx_release"}, k = 1, mv = {1, 4, 0})
public final class NavArgsLazy<Args extends NavArgs> implements Lazy<Args> {
    public Args a;
    public final KClass<Args> b;
    public final Function0<Bundle> c;

    public NavArgsLazy(@NotNull KClass<Args> kClass, @NotNull Function0<Bundle> function0) {
        Intrinsics.checkParameterIsNotNull(kClass, "navArgsClass");
        Intrinsics.checkParameterIsNotNull(function0, "argumentProducer");
        this.b = kClass;
        this.c = function0;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.a != null;
    }

    @Override // kotlin.Lazy
    @NotNull
    public Args getValue() {
        Args args = this.a;
        if (args != null) {
            return args;
        }
        Bundle invoke = this.c.invoke();
        Method method = NavArgsLazyKt.getMethodMap().get(this.b);
        if (method == null) {
            Class javaClass = JvmClassMappingKt.getJavaClass((KClass) this.b);
            Class<Bundle>[] methodSignature = NavArgsLazyKt.getMethodSignature();
            method = javaClass.getMethod("fromBundle", (Class[]) Arrays.copyOf(methodSignature, methodSignature.length));
            NavArgsLazyKt.getMethodMap().put(this.b, method);
            Intrinsics.checkExpressionValueIsNotNull(method, "navArgsClass.java.getMet…hod\n                    }");
        }
        Object invoke2 = method.invoke(null, invoke);
        if (invoke2 != null) {
            Args args2 = (Args) ((NavArgs) invoke2);
            this.a = args2;
            return args2;
        }
        throw new TypeCastException("null cannot be cast to non-null type Args");
    }
}
