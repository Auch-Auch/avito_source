package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
import t6.r.a.j;
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    public static final /* synthetic */ KProperty<Object>[] i = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull
    public final LazyJavaResolverContext a;
    @NotNull
    public final JavaAnnotation b;
    @NotNull
    public final NullableLazyValue c;
    @NotNull
    public final NotNullLazyValue d;
    @NotNull
    public final JavaSourceElement e;
    @NotNull
    public final NotNullLazyValue f;
    public final boolean g;
    public final boolean h;

    public static final class a extends Lambda implements Function0<Map<Name, ? extends ConstantValue<?>>> {
        public final /* synthetic */ LazyJavaAnnotationDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
            super(0);
            this.a = lazyJavaAnnotationDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Map<Name, ? extends ConstantValue<?>> invoke() {
            Collection<JavaAnnotationArgument> arguments = this.a.b.getArguments();
            LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = this.a;
            ArrayList arrayList = new ArrayList();
            for (T t : arguments) {
                Name name = t.getName();
                if (name == null) {
                    name = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
                }
                ConstantValue a3 = lazyJavaAnnotationDescriptor.a(t);
                Pair pair = a3 == null ? null : TuplesKt.to(name, a3);
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            return r.toMap(arrayList);
        }
    }

    public static final class b extends Lambda implements Function0<FqName> {
        public final /* synthetic */ LazyJavaAnnotationDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
            super(0);
            this.a = lazyJavaAnnotationDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public FqName invoke() {
            ClassId classId = this.a.b.getClassId();
            if (classId == null) {
                return null;
            }
            return classId.asSingleFqName();
        }
    }

    public static final class c extends Lambda implements Function0<SimpleType> {
        public final /* synthetic */ LazyJavaAnnotationDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
            super(0);
            this.a = lazyJavaAnnotationDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SimpleType invoke() {
            FqName fqName = this.a.getFqName();
            if (fqName == null) {
                return ErrorUtils.createErrorType(Intrinsics.stringPlus("No fqName: ", this.a.b));
            }
            ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(JavaToKotlinClassMapper.INSTANCE, fqName, this.a.a.getModule().getBuiltIns(), null, 4, null);
            if (mapJavaToKotlin$default == null) {
                JavaClass resolve = this.a.b.resolve();
                mapJavaToKotlin$default = resolve == null ? null : this.a.a.getComponents().getModuleClassResolver().resolveClass(resolve);
                if (mapJavaToKotlin$default == null) {
                    mapJavaToKotlin$default = LazyJavaAnnotationDescriptor.access$createTypeForMissingDependencies(this.a, fqName);
                }
            }
            return mapJavaToKotlin$default.getDefaultType();
        }
    }

    public LazyJavaAnnotationDescriptor(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaAnnotation javaAnnotation, boolean z) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaAnnotation, "javaAnnotation");
        this.a = lazyJavaResolverContext;
        this.b = javaAnnotation;
        this.c = lazyJavaResolverContext.getStorageManager().createNullableLazyValue(new b(this));
        this.d = lazyJavaResolverContext.getStorageManager().createLazyValue(new c(this));
        this.e = lazyJavaResolverContext.getComponents().getSourceElementFactory().source(javaAnnotation);
        this.f = lazyJavaResolverContext.getStorageManager().createLazyValue(new a(this));
        this.g = javaAnnotation.isIdeExternalAnnotation();
        this.h = javaAnnotation.isFreshlySupportedTypeUseAnnotation() || z;
    }

    public static final ClassDescriptor access$createTypeForMissingDependencies(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor, FqName fqName) {
        ModuleDescriptor module = lazyJavaAnnotationDescriptor.a.getModule();
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(fqName)");
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(module, classId, lazyJavaAnnotationDescriptor.a.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    public final ConstantValue<?> a(JavaAnnotationArgument javaAnnotationArgument) {
        ConstantValue<?> constantValue;
        SimpleType simpleType = null;
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            return ConstantValueFactory.INSTANCE.createConstantValue(((JavaLiteralAnnotationArgument) javaAnnotationArgument).getValue());
        }
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
            ClassId enumClassId = javaEnumValueAnnotationArgument.getEnumClassId();
            Name entryName = javaEnumValueAnnotationArgument.getEntryName();
            if (enumClassId == null || entryName == null) {
                return null;
            }
            return new EnumValue(enumClassId, entryName);
        }
        if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            Name name = javaAnnotationArgument.getName();
            if (name == null) {
                name = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            Intrinsics.checkNotNullExpressionValue(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            List<JavaAnnotationArgument> elements = ((JavaArrayAnnotationArgument) javaAnnotationArgument).getElements();
            SimpleType type = getType();
            Intrinsics.checkNotNullExpressionValue(type, "type");
            if (KotlinTypeKt.isError(type)) {
                return null;
            }
            ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(this);
            Intrinsics.checkNotNull(annotationClass);
            ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name, annotationClass);
            if (annotationParameterByName != null) {
                simpleType = annotationParameterByName.getType();
            }
            if (simpleType == null) {
                simpleType = this.a.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType("Unknown array element type"));
            }
            Intrinsics.checkNotNullExpressionValue(simpleType, "DescriptorResolverUtils.getAnnotationParameterByName(argumentName, annotationClass!!)?.type\n            // Try to load annotation arguments even if the annotation class is not found\n                ?: c.components.module.builtIns.getArrayType(\n                    Variance.INVARIANT,\n                    ErrorUtils.createErrorType(\"Unknown array element type\")\n                )");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(elements, 10));
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                ConstantValue<?> a3 = a(it.next());
                if (a3 == null) {
                    a3 = new NullValue();
                }
                arrayList.add(a3);
            }
            constantValue = ConstantValueFactory.INSTANCE.createArrayValue(arrayList, simpleType);
        } else if (javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument) {
            constantValue = new AnnotationValue(new LazyJavaAnnotationDescriptor(this.a, ((JavaAnnotationAsAnnotationArgument) javaAnnotationArgument).getAnnotation(), false, 4, null));
        } else if (!(javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument)) {
            return null;
        } else {
            return KClassValue.Companion.create(this.a.getTypeResolver().transformJavaType(((JavaClassObjectAnnotationArgument) javaAnnotationArgument).getReferencedType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null)));
        }
        return constantValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map) StorageKt.getValue(this.f, this, i[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @Nullable
    public FqName getFqName() {
        return (FqName) StorageKt.getValue(this.c, this, i[0]);
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.g;
    }

    @NotNull
    public String toString() {
        return DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public JavaSourceElement getSource() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.d, this, i[1]);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaAnnotationDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation, boolean z, int i2, j jVar) {
        this(lazyJavaResolverContext, javaAnnotation, (i2 & 4) != 0 ? false : z);
    }
}
