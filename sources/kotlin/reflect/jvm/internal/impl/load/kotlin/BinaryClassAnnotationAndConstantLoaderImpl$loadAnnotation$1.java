package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
    @NotNull
    public final HashMap<Name, ConstantValue<?>> a = new HashMap<>();
    public final /* synthetic */ ClassDescriptor b;
    public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl c;
    public final /* synthetic */ List<AnnotationDescriptor> d;
    public final /* synthetic */ SourceElement e;

    public BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(ClassDescriptor classDescriptor, BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, List<AnnotationDescriptor> list, SourceElement sourceElement) {
        this.b = classDescriptor;
        this.c = binaryClassAnnotationAndConstantLoaderImpl;
        this.d = list;
        this.e = sourceElement;
    }

    public final ConstantValue<?> a(Name name, Object obj) {
        ConstantValue<?> createConstantValue = ConstantValueFactory.INSTANCE.createConstantValue(obj);
        return createConstantValue == null ? ErrorValue.Companion.create(Intrinsics.stringPlus("Unsupported annotation argument: ", name)) : createConstantValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visit(@Nullable Name name, @Nullable Object obj) {
        if (name != null) {
            this.a.put(name, a(name, obj));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name name, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ArrayList arrayList = new ArrayList();
        BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = this.c;
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation = binaryClassAnnotationAndConstantLoaderImpl.loadAnnotation(classId, sourceElement, arrayList);
        Intrinsics.checkNotNull(loadAnnotation);
        return new KotlinJvmBinaryClass.AnnotationArgumentVisitor(loadAnnotation, this, name, arrayList) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitAnnotation$1
            public final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor a;
            public final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor b;
            public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 c;
            public final /* synthetic */ Name d;
            public final /* synthetic */ ArrayList<AnnotationDescriptor> e;

            {
                this.b = r1;
                this.c = r2;
                this.d = r3;
                this.e = r4;
                this.a = r1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visit(@Nullable Name name2, @Nullable Object obj) {
                this.a.visit(name2, obj);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            @Nullable
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name name2, @NotNull ClassId classId2) {
                Intrinsics.checkNotNullParameter(name2, "name");
                Intrinsics.checkNotNullParameter(classId2, "classId");
                return this.a.visitAnnotation(name2, classId2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            @Nullable
            public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name name2) {
                Intrinsics.checkNotNullParameter(name2, "name");
                return this.a.visitArray(name2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitClassLiteral(@NotNull Name name2, @NotNull ClassLiteralValue classLiteralValue) {
                Intrinsics.checkNotNullParameter(name2, "name");
                Intrinsics.checkNotNullParameter(classLiteralValue, "value");
                this.a.visitClassLiteral(name2, classLiteralValue);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnd() {
                this.b.visitEnd();
                BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1.access$getArguments$p(this.c).put(this.d, new AnnotationValue((AnnotationDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) this.e)));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnum(@NotNull Name name2, @NotNull ClassId classId2, @NotNull Name name3) {
                Intrinsics.checkNotNullParameter(name2, "name");
                Intrinsics.checkNotNullParameter(classId2, "enumClassId");
                Intrinsics.checkNotNullParameter(name3, "enumEntryName");
                this.a.visitEnum(name2, classId2, name3);
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    @Nullable
    public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor(this, name, this.b) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitArray$1
            @NotNull
            public final ArrayList<ConstantValue<?>> a = new ArrayList<>();
            public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 b;
            public final /* synthetic */ Name c;
            public final /* synthetic */ ClassDescriptor d;

            {
                this.b = r1;
                this.c = r2;
                this.d = r3;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visit(@Nullable Object obj) {
                this.a.add(BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1.access$createConstant(this.b, this.c, obj));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitClassLiteral(@NotNull ClassLiteralValue classLiteralValue) {
                Intrinsics.checkNotNullParameter(classLiteralValue, "value");
                this.a.add(new KClassValue(classLiteralValue));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitEnd() {
                ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(this.c, this.d);
                if (annotationParameterByName != null) {
                    HashMap access$getArguments$p = BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1.access$getArguments$p(this.b);
                    Name name2 = this.c;
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                    List<? extends ConstantValue<?>> compact = CollectionsKt.compact(this.a);
                    KotlinType type = annotationParameterByName.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "parameter.type");
                    access$getArguments$p.put(name2, constantValueFactory.createArrayValue(compact, type));
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitEnum(@NotNull ClassId classId, @NotNull Name name2) {
                Intrinsics.checkNotNullParameter(classId, "enumClassId");
                Intrinsics.checkNotNullParameter(name2, "enumEntryName");
                this.a.add(new EnumValue(classId, name2));
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visitClassLiteral(@NotNull Name name, @NotNull ClassLiteralValue classLiteralValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(classLiteralValue, "value");
        this.a.put(name, new KClassValue(classLiteralValue));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visitEnd() {
        this.d.add(new AnnotationDescriptorImpl(this.b.getDefaultType(), this.a, this.e));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visitEnum(@NotNull Name name, @NotNull ClassId classId, @NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(classId, "enumClassId");
        Intrinsics.checkNotNullParameter(name2, "enumEntryName");
        this.a.put(name, new EnumValue(classId, name2));
    }
}
