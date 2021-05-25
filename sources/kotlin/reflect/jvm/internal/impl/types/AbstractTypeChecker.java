package kotlin.reflect.jvm.internal.impl.types;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.h;
public final class AbstractTypeChecker {
    @NotNull
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {3, 2, 1};
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = {1, 2, 3};

        static {
            TypeVariance.values();
            AbstractTypeCheckerContext.LowerCapturedTypePolicy.values();
        }
    }

    public static final boolean a(AbstractTypeCheckerContext abstractTypeCheckerContext, AbstractTypeChecker abstractTypeChecker, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, boolean z) {
        boolean z2;
        Collection<KotlinTypeMarker> possibleIntegerTypes = abstractTypeCheckerContext.possibleIntegerTypes(simpleTypeMarker);
        if ((possibleIntegerTypes instanceof Collection) && possibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (T t : possibleIntegerTypes) {
            if (Intrinsics.areEqual(abstractTypeCheckerContext.typeConstructor((KotlinTypeMarker) t), abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2)) || (z && isSubtypeOf$default(abstractTypeChecker, abstractTypeCheckerContext, simpleTypeMarker2, t, false, 8, null))) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker abstractTypeChecker, AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return abstractTypeChecker.isSubtypeOf(abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    public final List<SimpleTypeMarker> b(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        List<SimpleTypeMarker> fastCorrespondingSupertypes = abstractTypeCheckerContext.fastCorrespondingSupertypes(simpleTypeMarker, typeConstructorMarker);
        if (fastCorrespondingSupertypes == null) {
            if (!abstractTypeCheckerContext.isClassTypeConstructor(typeConstructorMarker) && abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (!abstractTypeCheckerContext.isCommonFinalClassConstructor(typeConstructorMarker)) {
                fastCorrespondingSupertypes = new SmartList<>();
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
                            SimpleTypeMarker captureFromArguments = abstractTypeCheckerContext.captureFromArguments(pop, CaptureStatus.FOR_SUBTYPING);
                            if (captureFromArguments == null) {
                                captureFromArguments = pop;
                            }
                            if (abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(captureFromArguments), typeConstructorMarker)) {
                                fastCorrespondingSupertypes.add(captureFromArguments);
                                supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                            } else if (abstractTypeCheckerContext.argumentsCount(captureFromArguments) == 0) {
                                supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                            } else {
                                supertypesPolicy = abstractTypeCheckerContext.substitutionSupertypePolicy(captureFromArguments);
                            }
                            if (!(!Intrinsics.areEqual(supertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                                supertypesPolicy = null;
                            }
                            if (supertypesPolicy != null) {
                                for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                                    supertypesDeque.add(supertypesPolicy.transformType(abstractTypeCheckerContext, kotlinTypeMarker));
                                }
                            }
                        }
                    } else {
                        StringBuilder X = a.X("Too many supertypes for type: ", simpleTypeMarker, ". Supertypes = ");
                        X.append(CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                        throw new IllegalStateException(X.toString().toString());
                    }
                }
                abstractTypeCheckerContext.clear();
            } else if (!abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker)) {
                return CollectionsKt__CollectionsKt.emptyList();
            } else {
                SimpleTypeMarker captureFromArguments2 = abstractTypeCheckerContext.captureFromArguments(simpleTypeMarker, CaptureStatus.FOR_SUBTYPING);
                if (captureFromArguments2 != null) {
                    simpleTypeMarker = captureFromArguments2;
                }
                return d.listOf(simpleTypeMarker);
            }
        }
        return fastCorrespondingSupertypes;
    }

    public final List<SimpleTypeMarker> c(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        List<SimpleTypeMarker> b = b(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        if (b.size() < 2) {
            return b;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = b.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            TypeArgumentListMarker asArgumentList = abstractTypeCheckerContext.asArgumentList(next);
            int size = abstractTypeCheckerContext.size(asArgumentList);
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (!(abstractTypeCheckerContext.asFlexibleType(abstractTypeCheckerContext.getType(abstractTypeCheckerContext.get(asArgumentList, i))) == null)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : b;
    }

    public final boolean d(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
        return abstractTypeCheckerContext.isDenotable(abstractTypeCheckerContext.typeConstructor(kotlinTypeMarker)) && !abstractTypeCheckerContext.isDynamic(kotlinTypeMarker) && !abstractTypeCheckerContext.isDefinitelyNotNullType(kotlinTypeMarker) && Intrinsics.areEqual(abstractTypeCheckerContext.typeConstructor(abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker)), abstractTypeCheckerContext.typeConstructor(abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker)));
    }

    @Nullable
    public final TypeVariance effectiveVariance(@NotNull TypeVariance typeVariance, @NotNull TypeVariance typeVariance2) {
        Intrinsics.checkNotNullParameter(typeVariance, "declared");
        Intrinsics.checkNotNullParameter(typeVariance2, "useSite");
        TypeVariance typeVariance3 = TypeVariance.INV;
        if (typeVariance == typeVariance3) {
            return typeVariance2;
        }
        if (typeVariance2 == typeVariance3 || typeVariance == typeVariance2) {
            return typeVariance;
        }
        return null;
    }

    public final boolean equalTypes(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "context");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, AuthSource.BOOKING_ORDER);
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (d(abstractTypeCheckerContext, kotlinTypeMarker) && d(abstractTypeCheckerContext, kotlinTypeMarker2)) {
            KotlinTypeMarker refineType = abstractTypeCheckerContext.refineType(kotlinTypeMarker);
            KotlinTypeMarker refineType2 = abstractTypeCheckerContext.refineType(kotlinTypeMarker2);
            SimpleTypeMarker lowerBoundIfFlexible = abstractTypeCheckerContext.lowerBoundIfFlexible(refineType);
            if (!abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(refineType), abstractTypeCheckerContext.typeConstructor(refineType2))) {
                return false;
            }
            if (abstractTypeCheckerContext.argumentsCount(lowerBoundIfFlexible) == 0) {
                if (abstractTypeCheckerContext.hasFlexibleNullability(refineType) || abstractTypeCheckerContext.hasFlexibleNullability(refineType2) || abstractTypeCheckerContext.isMarkedNullable(lowerBoundIfFlexible) == abstractTypeCheckerContext.isMarkedNullable(abstractTypeCheckerContext.lowerBoundIfFlexible(refineType2))) {
                    return true;
                }
                return false;
            }
        }
        if (!isSubtypeOf$default(this, abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, false, 8, null) || !isSubtypeOf$default(this, abstractTypeCheckerContext, kotlinTypeMarker2, kotlinTypeMarker, false, 8, null)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final List<SimpleTypeMarker> findCorrespondingSupertypes(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "<this>");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "superConstructor");
        if (abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
            return c(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        }
        if (!(abstractTypeCheckerContext.isClassTypeConstructor(typeConstructorMarker) || abstractTypeCheckerContext.isIntegerLiteralTypeConstructor(typeConstructorMarker))) {
            return b(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        }
        SmartList<SimpleTypeMarker> smartList = new SmartList();
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
                    if (abstractTypeCheckerContext.isClassType(pop)) {
                        smartList.add(pop);
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual(supertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                            supertypesDeque.add(supertypesPolicy.transformType(abstractTypeCheckerContext, kotlinTypeMarker));
                        }
                    }
                }
            } else {
                StringBuilder X = a.X("Too many supertypes for type: ", simpleTypeMarker, ". Supertypes = ");
                X.append(CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(X.toString().toString());
            }
        }
        abstractTypeCheckerContext.clear();
        ArrayList arrayList = new ArrayList();
        for (SimpleTypeMarker simpleTypeMarker2 : smartList) {
            Intrinsics.checkNotNullExpressionValue(simpleTypeMarker2, "it");
            h.addAll(arrayList, c(abstractTypeCheckerContext, simpleTypeMarker2, typeConstructorMarker));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, @NotNull SimpleTypeMarker simpleTypeMarker) {
        boolean z;
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "<this>");
        Intrinsics.checkNotNullParameter(typeArgumentListMarker, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "superType");
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker);
        int parametersCount = abstractTypeCheckerContext.parametersCount(typeConstructor);
        if (parametersCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                TypeArgumentMarker argument = abstractTypeCheckerContext.getArgument(simpleTypeMarker, i);
                if (!abstractTypeCheckerContext.isStarProjection(argument)) {
                    KotlinTypeMarker type = abstractTypeCheckerContext.getType(argument);
                    TypeArgumentMarker typeArgumentMarker = abstractTypeCheckerContext.get(typeArgumentListMarker, i);
                    abstractTypeCheckerContext.getVariance(typeArgumentMarker);
                    TypeVariance typeVariance = TypeVariance.INV;
                    KotlinTypeMarker type2 = abstractTypeCheckerContext.getType(typeArgumentMarker);
                    TypeVariance effectiveVariance = effectiveVariance(abstractTypeCheckerContext.getVariance(abstractTypeCheckerContext.getParameter(typeConstructor, i)), abstractTypeCheckerContext.getVariance(argument));
                    if (effectiveVariance == null) {
                        return abstractTypeCheckerContext.isErrorTypeEqualsToAnything();
                    }
                    if (abstractTypeCheckerContext.a <= 100) {
                        abstractTypeCheckerContext.a = abstractTypeCheckerContext.a + 1;
                        int ordinal = effectiveVariance.ordinal();
                        if (ordinal == 0) {
                            z = isSubtypeOf$default(this, abstractTypeCheckerContext, type, type2, false, 8, null);
                        } else if (ordinal == 1) {
                            z = isSubtypeOf$default(this, abstractTypeCheckerContext, type2, type, false, 8, null);
                        } else if (ordinal == 2) {
                            z = equalTypes(abstractTypeCheckerContext, type2, type);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        abstractTypeCheckerContext.a = abstractTypeCheckerContext.a - 1;
                        if (!z) {
                            return false;
                        }
                    } else {
                        throw new IllegalStateException(Intrinsics.stringPlus("Arguments depth is too high. Some related argument: ", type2).toString());
                    }
                }
                if (i2 >= parametersCount) {
                    break;
                }
                i = i2;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0291, code lost:
        if ((r27.getVariance(r14) == kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV) != false) goto L_0x0296;
     */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x03f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isSubtypeOf(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext r27, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r28, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r29, boolean r30) {
        /*
        // Method dump skipped, instructions count: 1036
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.isSubtypeOf(kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, boolean):boolean");
    }
}
