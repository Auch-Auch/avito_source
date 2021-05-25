package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.h;
import t6.w.f.a.m.c.a.b;
public final class AnnotationTypeQualifierResolver {
    @NotNull
    public final JavaTypeEnhancementState a;
    @NotNull
    public final MemoizedFunctionToNullable<ClassDescriptor, AnnotationDescriptor> b;

    public static final class TypeQualifierWithApplicability {
        @NotNull
        public final AnnotationDescriptor a;
        public final int b;

        public TypeQualifierWithApplicability(@NotNull AnnotationDescriptor annotationDescriptor, int i) {
            Intrinsics.checkNotNullParameter(annotationDescriptor, "typeQualifier");
            this.a = annotationDescriptor;
            this.b = i;
        }

        @NotNull
        public final AnnotationDescriptor component1() {
            return this.a;
        }

        @NotNull
        public final List<AnnotationQualifierApplicabilityType> component2() {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 6; i++) {
                AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = values[i];
                boolean z = true;
                if (!((this.b & (1 << annotationQualifierApplicabilityType.ordinal())) != 0)) {
                    if (!((this.b & 8) != 0) || annotationQualifierApplicabilityType == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(annotationQualifierApplicabilityType);
                }
            }
            return arrayList;
        }
    }

    public AnnotationTypeQualifierResolver(@NotNull StorageManager storageManager, @NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.a = javaTypeEnhancementState;
        this.b = storageManager.createMemoizedFunctionWithNullableValues(new Function1<ClassDescriptor, AnnotationDescriptor>(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.a
            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            @NotNull
            public final String getName() {
                return "computeTypeQualifierNickname";
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(AnnotationTypeQualifierResolver.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final String getSignature() {
                return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public AnnotationDescriptor invoke(ClassDescriptor classDescriptor) {
                ClassDescriptor classDescriptor2 = classDescriptor;
                Intrinsics.checkNotNullParameter(classDescriptor2, "p0");
                return AnnotationTypeQualifierResolver.access$computeTypeQualifierNickname((AnnotationTypeQualifierResolver) this.receiver, classDescriptor2);
            }
        });
    }

    public static final AnnotationDescriptor access$computeTypeQualifierNickname(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, ClassDescriptor classDescriptor) {
        Objects.requireNonNull(annotationTypeQualifierResolver);
        if (!classDescriptor.getAnnotations().hasAnnotation(AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_NICKNAME_FQNAME())) {
            return null;
        }
        for (AnnotationDescriptor annotationDescriptor : classDescriptor.getAnnotations()) {
            AnnotationDescriptor resolveTypeQualifierAnnotation = annotationTypeQualifierResolver.resolveTypeQualifierAnnotation(annotationDescriptor);
            if (resolveTypeQualifierAnnotation != null) {
                return resolveTypeQualifierAnnotation;
            }
        }
        return null;
    }

    public static final List access$toKotlinTargetNames(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, String str) {
        Objects.requireNonNull(annotationTypeQualifierResolver);
        Set<KotlinTarget> mapJavaTargetArgumentByName = JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArgumentByName(str);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(mapJavaTargetArgumentByName, 10));
        Iterator<T> it = mapJavaTargetArgumentByName.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().name());
        }
        return arrayList;
    }

    public final List<AnnotationQualifierApplicabilityType> a(ConstantValue<?> constantValue, Function2<? super EnumValue, ? super AnnotationQualifierApplicabilityType, Boolean> function2) {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        if (constantValue instanceof ArrayValue) {
            ArrayList arrayList = new ArrayList();
            for (ConstantValue<?> constantValue2 : (Iterable) ((ArrayValue) constantValue).getValue()) {
                h.addAll(arrayList, a(constantValue2, function2));
            }
            return arrayList;
        } else if (!(constantValue instanceof EnumValue)) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            int i = 0;
            while (true) {
                if (i >= 6) {
                    annotationQualifierApplicabilityType = null;
                    break;
                }
                annotationQualifierApplicabilityType = values[i];
                if (function2.invoke(constantValue, annotationQualifierApplicabilityType).booleanValue()) {
                    break;
                }
                i++;
            }
            return CollectionsKt__CollectionsKt.listOfNotNull(annotationQualifierApplicabilityType);
        }
    }

    @Nullable
    public final TypeQualifierWithApplicability resolveAnnotation(@NotNull AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null) {
            return null;
        }
        Annotations annotations = annotationClass.getAnnotations();
        FqName fqName = JvmAnnotationNames.TARGET_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "TARGET_ANNOTATION");
        AnnotationDescriptor findAnnotation = annotations.findAnnotation(fqName);
        if (findAnnotation == null) {
            return null;
        }
        Map<Name, ConstantValue<?>> allValueArguments = findAnnotation.getAllValueArguments();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<Name, ConstantValue<?>> entry : allValueArguments.entrySet()) {
            h.addAll(arrayList, a(entry.getValue(), new b(this)));
        }
        int i = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        return new TypeQualifierWithApplicability(annotationDescriptor, i);
    }

    @NotNull
    public final ReportLevel resolveJsr305AnnotationState(@NotNull AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        ReportLevel resolveJsr305CustomState = resolveJsr305CustomState(annotationDescriptor);
        return resolveJsr305CustomState == null ? this.a.getGlobalJsr305Level() : resolveJsr305CustomState;
    }

    @Nullable
    public final ReportLevel resolveJsr305CustomState(@NotNull AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        Map<String, ReportLevel> userDefinedLevelForSpecificJsr305Annotation = this.a.getUserDefinedLevelForSpecificJsr305Annotation();
        FqName fqName = annotationDescriptor.getFqName();
        ReportLevel reportLevel = userDefinedLevelForSpecificJsr305Annotation.get(fqName == null ? null : fqName.asString());
        if (reportLevel != null) {
            return reportLevel;
        }
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null) {
            return null;
        }
        AnnotationDescriptor findAnnotation = annotationClass.getAnnotations().findAnnotation(AnnotationQualifiersFqNamesKt.getMIGRATION_ANNOTATION_FQNAME());
        ConstantValue<?> firstArgument = findAnnotation == null ? null : DescriptorUtilsKt.firstArgument(findAnnotation);
        EnumValue enumValue = firstArgument instanceof EnumValue ? (EnumValue) firstArgument : null;
        if (enumValue == null) {
            return null;
        }
        ReportLevel migrationLevelForJsr305 = this.a.getMigrationLevelForJsr305();
        if (migrationLevelForJsr305 != null) {
            return migrationLevelForJsr305;
        }
        String asString = enumValue.getEnumEntryName().asString();
        int hashCode = asString.hashCode();
        if (hashCode != -2137067054) {
            if (hashCode != -1838656823) {
                if (hashCode == 2656902 && asString.equals("WARN")) {
                    return ReportLevel.WARN;
                }
                return null;
            } else if (!asString.equals("STRICT")) {
                return null;
            } else {
                return ReportLevel.STRICT;
            }
        } else if (!asString.equals("IGNORE")) {
            return null;
        } else {
            return ReportLevel.IGNORE;
        }
    }

    @Nullable
    public final JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(@NotNull AnnotationDescriptor annotationDescriptor) {
        JavaDefaultQualifiers javaDefaultQualifiers;
        ReportLevel reportLevel;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        if (this.a.getDisabledDefaultAnnotations() || (javaDefaultQualifiers = AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(annotationDescriptor.getFqName())) == null) {
            return null;
        }
        if (AnnotationQualifiersFqNamesKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(annotationDescriptor.getFqName())) {
            reportLevel = this.a.getJspecifyReportLevel();
        } else {
            reportLevel = resolveJsr305AnnotationState(annotationDescriptor);
        }
        if (!(reportLevel != ReportLevel.IGNORE)) {
            reportLevel = null;
        }
        if (reportLevel == null) {
            return null;
        }
        return JavaDefaultQualifiers.copy$default(javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus.copy$default(javaDefaultQualifiers.getNullabilityQualifier(), null, reportLevel.isWarning(), 1, null), null, false, 6, null);
    }

    @Nullable
    public final AnnotationDescriptor resolveTypeQualifierAnnotation(@NotNull AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor annotationClass;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        if (this.a.getDisabledJsr305() || (annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor)) == null) {
            return null;
        }
        if (AnnotationTypeQualifierResolverKt.access$isAnnotatedWithTypeQualifier(annotationClass)) {
            return annotationDescriptor;
        }
        if (annotationClass.getKind() != ClassKind.ANNOTATION_CLASS) {
            return null;
        }
        return this.b.invoke(annotationClass);
    }

    @Nullable
    public final TypeQualifierWithApplicability resolveTypeQualifierDefaultAnnotation(@NotNull AnnotationDescriptor annotationDescriptor) {
        Object obj;
        boolean z;
        List<AnnotationQualifierApplicabilityType> list;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        if (this.a.getDisabledJsr305()) {
            return null;
        }
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null || !annotationClass.getAnnotations().hasAnnotation(AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_DEFAULT_FQNAME())) {
            annotationClass = null;
        }
        if (annotationClass == null) {
            return null;
        }
        ClassDescriptor annotationClass2 = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        Intrinsics.checkNotNull(annotationClass2);
        AnnotationDescriptor findAnnotation = annotationClass2.getAnnotations().findAnnotation(AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        Intrinsics.checkNotNull(findAnnotation);
        Map<Name, ConstantValue<?>> allValueArguments = findAnnotation.getAllValueArguments();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<Name, ConstantValue<?>> entry : allValueArguments.entrySet()) {
            ConstantValue<?> value = entry.getValue();
            if (Intrinsics.areEqual(entry.getKey(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                list = a(value, t6.w.f.a.m.c.a.a.a);
            } else {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            h.addAll(arrayList, list);
        }
        int i = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        Iterator it = annotationClass.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (resolveTypeQualifierAnnotation((AnnotationDescriptor) obj) != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        AnnotationDescriptor annotationDescriptor2 = (AnnotationDescriptor) obj;
        if (annotationDescriptor2 == null) {
            return null;
        }
        return new TypeQualifierWithApplicability(annotationDescriptor2, i);
    }
}
