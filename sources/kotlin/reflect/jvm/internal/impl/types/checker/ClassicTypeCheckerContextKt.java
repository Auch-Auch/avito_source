package kotlin.reflect.jvm.internal.impl.types.checker;

import a2.b.a.a.a;
import kotlin.jvm.internal.Reflection;
public final class ClassicTypeCheckerContextKt {
    public static final String access$errorMessage(Object obj) {
        StringBuilder L = a.L("ClassicTypeCheckerContext couldn't handle ");
        L.append(Reflection.getOrCreateKotlinClass(obj.getClass()));
        L.append(' ');
        L.append(obj);
        return L.toString();
    }
}
