package kotlin.reflect.full;

import a2.b.a.a.a;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a=\u0010\t\u001a\u00020\b*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\" \u0010\u000f\u001a\u00020\b*\u00020\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/KClassifier;", "", "Lkotlin/reflect/KTypeProjection;", "arguments", "", "nullable", "", "annotations", "Lkotlin/reflect/KType;", "createType", "(Lkotlin/reflect/KClassifier;Ljava/util/List;ZLjava/util/List;)Lkotlin/reflect/KType;", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "getStarProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "starProjectedType", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "KClassifiers")
public final class KClassifiers {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            KVariance.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final KType createType(@NotNull KClassifier kClassifier, @NotNull List<KTypeProjection> list, boolean z, @NotNull List<? extends Annotation> list2) {
        ClassifierDescriptor descriptor;
        Annotations annotations;
        Object obj;
        Intrinsics.checkNotNullParameter(kClassifier, "$this$createType");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(list2, "annotations");
        KClassifierImpl kClassifierImpl = (KClassifierImpl) (!(kClassifier instanceof KClassifierImpl) ? null : kClassifier);
        if (kClassifierImpl == null || (descriptor = kClassifierImpl.getDescriptor()) == null) {
            throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + kClassifier + " (" + kClassifier.getClass() + ')');
        }
        TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        if (parameters.size() == list.size()) {
            if (list2.isEmpty()) {
                annotations = Annotations.Companion.getEMPTY();
            } else {
                annotations = Annotations.Companion.getEMPTY();
            }
            List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters2, "typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                KTypeImpl kTypeImpl = (KTypeImpl) t2.getType();
                KotlinType type = kTypeImpl != null ? kTypeImpl.getType() : null;
                KVariance variance = t2.getVariance();
                if (variance == null) {
                    TypeParameterDescriptor typeParameterDescriptor = parameters2.get(i);
                    Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "parameters[index]");
                    obj = new StarProjectionImpl(typeParameterDescriptor);
                } else {
                    int ordinal = variance.ordinal();
                    if (ordinal == 0) {
                        Variance variance2 = Variance.INVARIANT;
                        Intrinsics.checkNotNull(type);
                        obj = new TypeProjectionImpl(variance2, type);
                    } else if (ordinal == 1) {
                        Variance variance3 = Variance.IN_VARIANCE;
                        Intrinsics.checkNotNull(type);
                        obj = new TypeProjectionImpl(variance3, type);
                    } else if (ordinal == 2) {
                        Variance variance4 = Variance.OUT_VARIANCE;
                        Intrinsics.checkNotNull(type);
                        obj = new TypeProjectionImpl(variance4, type);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                arrayList.add(obj);
                i = i2;
            }
            return new KTypeImpl(KotlinTypeFactory.simpleType$default(annotations, typeConstructor, arrayList, z, null, 16, null), null, 2, null);
        }
        StringBuilder L = a.L("Class declares ");
        L.append(parameters.size());
        L.append(" type parameters, but ");
        L.append(list.size());
        L.append(" were provided.");
        throw new IllegalArgumentException(L.toString());
    }

    public static /* synthetic */ KType createType$default(KClassifier kClassifier, List list, boolean z, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return createType(kClassifier, list, z, list2);
    }

    @NotNull
    public static final KType getStarProjectedType(@NotNull KClassifier kClassifier) {
        ClassifierDescriptor descriptor;
        Intrinsics.checkNotNullParameter(kClassifier, "$this$starProjectedType");
        KClassifierImpl kClassifierImpl = (KClassifierImpl) (!(kClassifier instanceof KClassifierImpl) ? null : kClassifier);
        if (kClassifierImpl == null || (descriptor = kClassifierImpl.getDescriptor()) == null) {
            return createType$default(kClassifier, null, false, null, 7, null);
        }
        TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "descriptor.typeConstructor.parameters");
        if (parameters.isEmpty()) {
            return createType$default(kClassifier, null, false, null, 7, null);
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(parameters, 10));
        for (T t : parameters) {
            arrayList.add(KTypeProjection.Companion.getSTAR());
        }
        return createType$default(kClassifier, arrayList, false, null, 6, null);
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStarProjectedType$annotations(KClassifier kClassifier) {
    }
}
