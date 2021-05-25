package kotlin.reflect.jvm.internal.impl.types;

import com.avito.android.remote.auth.AuthSource;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;
public final class AbstractStrictEqualityTypeChecker {
    @NotNull
    public static final AbstractStrictEqualityTypeChecker INSTANCE = new AbstractStrictEqualityTypeChecker();

    public final boolean a(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        int argumentsCount;
        if (typeSystemContext.argumentsCount(simpleTypeMarker) == typeSystemContext.argumentsCount(simpleTypeMarker2) && typeSystemContext.isMarkedNullable(simpleTypeMarker) == typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            if ((typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker) == null) == (typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2) == null) && typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeSystemContext.typeConstructor(simpleTypeMarker2))) {
                if (!typeSystemContext.identicalArguments(simpleTypeMarker, simpleTypeMarker2) && (argumentsCount = typeSystemContext.argumentsCount(simpleTypeMarker)) > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        TypeArgumentMarker argument = typeSystemContext.getArgument(simpleTypeMarker, i);
                        TypeArgumentMarker argument2 = typeSystemContext.getArgument(simpleTypeMarker2, i);
                        if (typeSystemContext.isStarProjection(argument) != typeSystemContext.isStarProjection(argument2)) {
                            return false;
                        }
                        if (!typeSystemContext.isStarProjection(argument) && (typeSystemContext.getVariance(argument) != typeSystemContext.getVariance(argument2) || !b(typeSystemContext, typeSystemContext.getType(argument), typeSystemContext.getType(argument2)))) {
                            return false;
                        }
                        if (i2 >= argumentsCount) {
                            break;
                        }
                        i = i2;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean b(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        SimpleTypeMarker asSimpleType2 = typeSystemContext.asSimpleType(kotlinTypeMarker2);
        if (asSimpleType != null && asSimpleType2 != null) {
            return a(typeSystemContext, asSimpleType, asSimpleType2);
        }
        FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
        FlexibleTypeMarker asFlexibleType2 = typeSystemContext.asFlexibleType(kotlinTypeMarker2);
        if (asFlexibleType == null || asFlexibleType2 == null || !a(typeSystemContext, typeSystemContext.lowerBound(asFlexibleType), typeSystemContext.lowerBound(asFlexibleType2)) || !a(typeSystemContext, typeSystemContext.upperBound(asFlexibleType), typeSystemContext.upperBound(asFlexibleType2))) {
            return false;
        }
        return true;
    }

    public final boolean strictEqualTypes(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "context");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, AuthSource.BOOKING_ORDER);
        return b(typeSystemContext, kotlinTypeMarker, kotlinTypeMarker2);
    }
}
