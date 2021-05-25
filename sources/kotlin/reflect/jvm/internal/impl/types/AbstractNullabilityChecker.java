package kotlin.reflect.jvm.internal.impl.types;

import a2.b.a.a.a;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
public final class AbstractNullabilityChecker {
    @NotNull
    public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();

    public final boolean a(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        if (abstractTypeCheckerContext.isNothing(simpleTypeMarker)) {
            return true;
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (!abstractTypeCheckerContext.isStubTypeEqualsToAnything() || !abstractTypeCheckerContext.isStubType(simpleTypeMarker)) {
            return abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker);
        }
        return true;
    }

    public final boolean hasNotNullSupertype(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "<this>");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "type");
        Intrinsics.checkNotNullParameter(supertypesPolicy, "supertypesPolicy");
        if (!((abstractTypeCheckerContext.isClassType(simpleTypeMarker) && !abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) || abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker))) {
            abstractTypeCheckerContext.initialize();
            ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
            Intrinsics.checkNotNull(supertypesDeque);
            Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
            Intrinsics.checkNotNull(supertypesSet);
            supertypesDeque.push(simpleTypeMarker);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() <= 1000) {
                    SimpleTypeMarker pop = supertypesDeque.pop();
                    Intrinsics.checkNotNullExpressionValue(pop, "current");
                    if (supertypesSet.add(pop)) {
                        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy2 = abstractTypeCheckerContext.isMarkedNullable(pop) ? AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE : supertypesPolicy;
                        if (!(!Intrinsics.areEqual(supertypesPolicy2, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                            supertypesPolicy2 = null;
                        }
                        if (supertypesPolicy2 == null) {
                            continue;
                        } else {
                            for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                                SimpleTypeMarker transformType = supertypesPolicy2.transformType(abstractTypeCheckerContext, kotlinTypeMarker);
                                if ((abstractTypeCheckerContext.isClassType(transformType) && !abstractTypeCheckerContext.isMarkedNullable(transformType)) || abstractTypeCheckerContext.isDefinitelyNotNullType(transformType)) {
                                    abstractTypeCheckerContext.clear();
                                } else {
                                    supertypesDeque.add(transformType);
                                }
                            }
                            continue;
                        }
                    }
                } else {
                    StringBuilder X = a.X("Too many supertypes for type: ", simpleTypeMarker, ". Supertypes = ");
                    X.append(CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                    throw new IllegalStateException(X.toString().toString());
                }
            }
            abstractTypeCheckerContext.clear();
            return false;
        }
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "<this>");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, Tracker.Events.CREATIVE_START);
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "end");
        if (a(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker)) {
            return true;
        }
        abstractTypeCheckerContext.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(pop, "current");
                if (supertypesSet.add(pop)) {
                    AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy = abstractTypeCheckerContext.isMarkedNullable(pop) ? AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE : AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    if (!(!Intrinsics.areEqual(supertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy == null) {
                        continue;
                    } else {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                            SimpleTypeMarker transformType = supertypesPolicy.transformType(abstractTypeCheckerContext, kotlinTypeMarker);
                            if (a(abstractTypeCheckerContext, transformType, typeConstructorMarker)) {
                                abstractTypeCheckerContext.clear();
                                return true;
                            }
                            supertypesDeque.add(transformType);
                        }
                        continue;
                    }
                }
            } else {
                StringBuilder X = a.X("Too many supertypes for type: ", simpleTypeMarker, ". Supertypes = ");
                X.append(CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(X.toString().toString());
            }
        }
        abstractTypeCheckerContext.clear();
        return false;
    }

    public final boolean isPossibleSubtype(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "context");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "superType");
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker) && !abstractTypeCheckerContext.isIntersection(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker))) {
                abstractTypeCheckerContext.isAllowedTypeVariable(simpleTypeMarker);
            }
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker2)) {
                abstractTypeCheckerContext.isAllowedTypeVariable(simpleTypeMarker2);
            }
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2) || abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker)) {
            return true;
        }
        if (((simpleTypeMarker instanceof CapturedTypeMarker) && abstractTypeCheckerContext.isProjectionNotNull((CapturedTypeMarker) simpleTypeMarker)) || hasNotNullSupertype(abstractTypeCheckerContext, simpleTypeMarker, AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if (!abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker2) && !hasNotNullSupertype(abstractTypeCheckerContext, simpleTypeMarker2, AbstractTypeCheckerContext.SupertypesPolicy.UpperIfFlexible.INSTANCE) && !abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
            return hasPathByNotMarkedNullableNodes(abstractTypeCheckerContext, simpleTypeMarker, abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2));
        }
        return false;
    }
}
