package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import org.jetbrains.annotations.NotNull;
public final class DeprecationKt {
    @NotNull
    public static final CallableDescriptor.UserDataKey<Object> a = new CallableDescriptor.UserDataKey<Object>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationKt$DEPRECATED_FUNCTION_KEY$1
    };

    @NotNull
    public static final CallableDescriptor.UserDataKey<Object> getDEPRECATED_FUNCTION_KEY() {
        return a;
    }
}
