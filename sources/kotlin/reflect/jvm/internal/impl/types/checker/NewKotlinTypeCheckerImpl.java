package kotlin.reflect.jvm.internal.impl.types.checker;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    @NotNull
    public final KotlinTypeRefiner a;
    @NotNull
    public final OverridingUtil b;

    public NewKotlinTypeCheckerImpl(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.a = kotlinTypeRefiner;
        OverridingUtil createWithTypeRefiner = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
        Intrinsics.checkNotNullExpressionValue(createWithTypeRefiner, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.b = createWithTypeRefiner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(kotlinType, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(kotlinType2, AuthSource.BOOKING_ORDER);
        return equalTypes(new ClassicTypeCheckerContext(false, false, false, getKotlinTypeRefiner(), 6, null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    @NotNull
    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    @NotNull
    public OverridingUtil getOverridingUtil() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(kotlinType, "subtype");
        Intrinsics.checkNotNullParameter(kotlinType2, "supertype");
        return isSubtypeOf(new ClassicTypeCheckerContext(true, false, false, getKotlinTypeRefiner(), 6, null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    @NotNull
    public final SimpleType transformToNewType(@NotNull SimpleType simpleType) {
        KotlinType type;
        Intrinsics.checkNotNullParameter(simpleType, "type");
        TypeConstructor constructor = simpleType.getConstructor();
        boolean z = true;
        boolean z2 = false;
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r6 = null;
        UnwrappedType unwrap = null;
        KotlinType kotlinType = null;
        if (constructor instanceof CapturedTypeConstructorImpl) {
            CapturedTypeConstructorImpl capturedTypeConstructorImpl = (CapturedTypeConstructorImpl) constructor;
            TypeProjection projection = capturedTypeConstructorImpl.getProjection();
            if (projection.getProjectionKind() != Variance.IN_VARIANCE) {
                z = false;
            }
            if (!z) {
                projection = null;
            }
            if (!(projection == null || (type = projection.getType()) == null)) {
                unwrap = type.unwrap();
            }
            if (capturedTypeConstructorImpl.getNewTypeConstructor() == null) {
                TypeProjection projection2 = capturedTypeConstructorImpl.getProjection();
                Collection<KotlinType> supertypes = capturedTypeConstructorImpl.getSupertypes();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(supertypes, 10));
                Iterator<T> it = supertypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().unwrap());
                }
                capturedTypeConstructorImpl.setNewTypeConstructor(new NewCapturedTypeConstructor(projection2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            NewCapturedTypeConstructor newTypeConstructor = capturedTypeConstructorImpl.getNewTypeConstructor();
            Intrinsics.checkNotNull(newTypeConstructor);
            return new NewCapturedType(captureStatus, newTypeConstructor, unwrap, simpleType.getAnnotations(), simpleType.isMarkedNullable(), false, 32, null);
        } else if (constructor instanceof IntegerValueTypeConstructor) {
            Collection<KotlinType> supertypes2 = ((IntegerValueTypeConstructor) constructor).getSupertypes();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(supertypes2, 10));
            Iterator<T> it2 = supertypes2.iterator();
            while (it2.hasNext()) {
                KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(it2.next(), simpleType.isMarkedNullable());
                Intrinsics.checkNotNullExpressionValue(makeNullableAsSpecified, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(makeNullableAsSpecified);
            }
            IntersectionTypeConstructor intersectionTypeConstructor2 = new IntersectionTypeConstructor(arrayList2);
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(simpleType.getAnnotations(), intersectionTypeConstructor2, CollectionsKt__CollectionsKt.emptyList(), false, simpleType.getMemberScope());
        } else if (!(constructor instanceof IntersectionTypeConstructor) || !simpleType.isMarkedNullable()) {
            return simpleType;
        } else {
            IntersectionTypeConstructor intersectionTypeConstructor3 = (IntersectionTypeConstructor) constructor;
            Collection<KotlinType> supertypes3 = intersectionTypeConstructor3.getSupertypes();
            ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(supertypes3, 10));
            Iterator<T> it3 = supertypes3.iterator();
            while (it3.hasNext()) {
                arrayList3.add(TypeUtilsKt.makeNullable(it3.next()));
                z2 = true;
            }
            if (z2) {
                KotlinType alternativeType = intersectionTypeConstructor3.getAlternativeType();
                if (alternativeType != null) {
                    kotlinType = TypeUtilsKt.makeNullable(alternativeType);
                }
                intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList3).setAlternative(kotlinType);
            }
            if (intersectionTypeConstructor != null) {
                intersectionTypeConstructor3 = intersectionTypeConstructor;
            }
            return intersectionTypeConstructor3.createType();
        }
    }

    public final boolean equalTypes(@NotNull ClassicTypeCheckerContext classicTypeCheckerContext, @NotNull UnwrappedType unwrappedType, @NotNull UnwrappedType unwrappedType2) {
        Intrinsics.checkNotNullParameter(classicTypeCheckerContext, "<this>");
        Intrinsics.checkNotNullParameter(unwrappedType, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(unwrappedType2, AuthSource.BOOKING_ORDER);
        return AbstractTypeChecker.INSTANCE.equalTypes(classicTypeCheckerContext, unwrappedType, unwrappedType2);
    }

    public final boolean isSubtypeOf(@NotNull ClassicTypeCheckerContext classicTypeCheckerContext, @NotNull UnwrappedType unwrappedType, @NotNull UnwrappedType unwrappedType2) {
        Intrinsics.checkNotNullParameter(classicTypeCheckerContext, "<this>");
        Intrinsics.checkNotNullParameter(unwrappedType, "subType");
        Intrinsics.checkNotNullParameter(unwrappedType2, "superType");
        return AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, classicTypeCheckerContext, unwrappedType, unwrappedType2, false, 8, null);
    }

    @NotNull
    public UnwrappedType transformToNewType(@NotNull UnwrappedType unwrappedType) {
        UnwrappedType unwrappedType2;
        Intrinsics.checkNotNullParameter(unwrappedType, "type");
        if (unwrappedType instanceof SimpleType) {
            unwrappedType2 = transformToNewType((SimpleType) unwrappedType);
        } else if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            SimpleType transformToNewType = transformToNewType(flexibleType.getLowerBound());
            SimpleType transformToNewType2 = transformToNewType(flexibleType.getUpperBound());
            if (transformToNewType == flexibleType.getLowerBound() && transformToNewType2 == flexibleType.getUpperBound()) {
                unwrappedType2 = unwrappedType;
            } else {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                unwrappedType2 = KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(unwrappedType2, unwrappedType);
    }
}
