package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import a2.b.a.a.a;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
public class TransientReceiver extends AbstractReceiverValue {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransientReceiver(@NotNull KotlinType kotlinType) {
        super(kotlinType, null);
        if (kotlinType == null) {
            a(0);
            throw null;
        } else if (kotlinType != null) {
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        StringBuilder L = a.L("{Transient} : ");
        L.append(getType());
        return L.toString();
    }
}
