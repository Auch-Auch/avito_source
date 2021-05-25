package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import org.jetbrains.annotations.NotNull;
import t6.w.f.a.m.c.a.d.b;
import t6.w.f.a.m.c.a.d.c;
public final class TypeEnhancementKt {
    @NotNull
    public static final b a;
    @NotNull
    public static final b b;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2};
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            MutabilityQualifier.values();
            NullabilityQualifier.values();
            int[] iArr = new int[3];
            iArr[0] = 1;
            iArr[1] = 2;
            $EnumSwitchMapping$1 = iArr;
        }
    }

    static {
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        a = new b(fqName);
        FqName fqName2 = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName2, "ENHANCED_MUTABILITY_ANNOTATION");
        b = new b(fqName2);
    }

    public static final <T> c<T> a(T t) {
        return new c<>(t, null);
    }

    public static final Annotations access$compositeAnnotationsOrSingle(List list) {
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("At least one Annotations object expected".toString());
        } else if (size != 1) {
            return new CompositeAnnotations(CollectionsKt___CollectionsKt.toList(list));
        } else {
            return (Annotations) CollectionsKt___CollectionsKt.single((List<? extends Object>) list);
        }
    }

    public static final c access$enhanceMutability(ClassifierDescriptor classifierDescriptor, JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        c cVar;
        if (!TypeComponentPositionKt.shouldEnhance(typeComponentPosition)) {
            return a(classifierDescriptor);
        }
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            return a(classifierDescriptor);
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        MutabilityQualifier mutability = javaTypeQualifiers.getMutability();
        int i = mutability == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mutability.ordinal()];
        if (i != 1) {
            if (i == 2 && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                if (javaToKotlinClassMapper.isReadOnly(classDescriptor)) {
                    cVar = new c(javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptor), b);
                }
            }
            return a(classifierDescriptor);
        }
        if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
            ClassDescriptor classDescriptor2 = (ClassDescriptor) classifierDescriptor;
            if (javaToKotlinClassMapper.isMutable(classDescriptor2)) {
                cVar = new c(javaToKotlinClassMapper.convertMutableToReadOnly(classDescriptor2), b);
            }
        }
        return a(classifierDescriptor);
        return cVar;
    }

    public static final c access$getEnhancedNullability(KotlinType kotlinType, JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        c cVar;
        if (!TypeComponentPositionKt.shouldEnhance(typeComponentPosition)) {
            return a(Boolean.valueOf(kotlinType.isMarkedNullable()));
        }
        NullabilityQualifier nullability = javaTypeQualifiers.getNullability();
        int i = nullability == null ? -1 : WhenMappings.$EnumSwitchMapping$1[nullability.ordinal()];
        if (i == 1) {
            cVar = new c(Boolean.TRUE, a);
        } else if (i != 2) {
            return a(Boolean.valueOf(kotlinType.isMarkedNullable()));
        } else {
            cVar = new c(Boolean.FALSE, a);
        }
        return cVar;
    }

    public static final boolean hasEnhancedNullability(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return TypeEnchancementUtilsKt.hasEnhancedNullability(SimpleClassicTypeSystemContext.INSTANCE, kotlinType);
    }
}
