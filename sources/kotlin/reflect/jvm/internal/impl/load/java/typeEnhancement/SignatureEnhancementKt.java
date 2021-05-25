package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
public final class SignatureEnhancementKt {
    public static final boolean access$isNullabilityFlexible(KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        FlexibleType flexibleType = unwrap instanceof FlexibleType ? (FlexibleType) unwrap : null;
        if (flexibleType == null || flexibleType.getLowerBound().isMarkedNullable() == flexibleType.getUpperBound().isMarkedNullable()) {
            return false;
        }
        return true;
    }
}
