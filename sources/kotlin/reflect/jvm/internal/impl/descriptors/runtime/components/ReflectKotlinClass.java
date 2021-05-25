package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.avito.android.lib.design.input.FormatterType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
import t6.w.f.a.m.b.d.a.a;
import t6.y.m;
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    @NotNull
    public static final Factory Factory = new Factory(null);
    @NotNull
    public final Class<?> a;
    @NotNull
    public final KotlinClassHeader b;

    public static final class Factory {
        public Factory() {
        }

        @Nullable
        public final ReflectKotlinClass create(@NotNull Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "klass");
            ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new ReadKotlinClassHeaderAnnotationVisitor();
            a.b(cls, readKotlinClassHeaderAnnotationVisitor);
            KotlinClassHeader createHeader = readKotlinClassHeaderAnnotationVisitor.createHeader();
            if (createHeader == null) {
                return null;
            }
            return new ReflectKotlinClass(cls, createHeader, null);
        }

        public Factory(j jVar) {
        }
    }

    public ReflectKotlinClass(Class cls, KotlinClassHeader kotlinClassHeader, j jVar) {
        this.a = cls;
        this.b = kotlinClassHeader;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ReflectKotlinClass) && Intrinsics.areEqual(this.a, ((ReflectKotlinClass) obj).a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public KotlinClassHeader getClassHeader() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.a);
    }

    @NotNull
    public final Class<?> getKlass() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public String getLocation() {
        String name = this.a.getName();
        Intrinsics.checkNotNullExpressionValue(name, "klass.name");
        return Intrinsics.stringPlus(m.replace$default(name, (char) FormatterType.defaultDecimalSeparator, '/', false, 4, (Object) null), ".class");
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(@NotNull KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(annotationVisitor, "visitor");
        a.b(this.a, annotationVisitor);
    }

    @NotNull
    public String toString() {
        return ReflectKotlinClass.class.getName() + ": " + this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(@NotNull KotlinJvmBinaryClass.MemberVisitor memberVisitor, @Nullable byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        Method[] methodArr;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(memberVisitor, "visitor");
        Class<?> cls = this.a;
        Intrinsics.checkNotNullParameter(cls, "klass");
        Intrinsics.checkNotNullParameter(memberVisitor, "memberVisitor");
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i5 = 0;
        while (true) {
            str = "annotations";
            str2 = "parameterType";
            if (i5 >= length) {
                break;
            }
            Method method = declaredMethods[i5];
            int i6 = i5 + 1;
            Name identifier = Name.identifier(method.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(method.name)");
            Intrinsics.checkNotNullExpressionValue(method, "method");
            Intrinsics.checkNotNullParameter(method, "method");
            StringBuilder L = a2.b.a.a.a.L("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
            int length2 = parameterTypes.length;
            int i7 = 0;
            while (i7 < length2) {
                Class<?> cls2 = parameterTypes[i7];
                i7++;
                Intrinsics.checkNotNullExpressionValue(cls2, str2);
                L.append(ReflectClassUtilKt.getDesc(cls2));
            }
            L.append(")");
            Class<?> returnType = method.getReturnType();
            Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
            L.append(ReflectClassUtilKt.getDesc(returnType));
            String sb = L.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "sb.toString()");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(identifier, sb);
            if (visitMethod == null) {
                methodArr = declaredMethods;
                i4 = length;
                i3 = i6;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "method.declaredAnnotations");
                int length3 = declaredAnnotations.length;
                int i8 = 0;
                while (i8 < length3) {
                    Annotation annotation = declaredAnnotations[i8];
                    i8++;
                    Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
                    a.c(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "method.parameterAnnotations");
                int length4 = parameterAnnotations.length;
                int i9 = 0;
                while (i9 < length4) {
                    Annotation[] annotationArr = parameterAnnotations[i9];
                    int i10 = i9 + 1;
                    Intrinsics.checkNotNullExpressionValue(annotationArr, str);
                    int length5 = annotationArr.length;
                    int i11 = 0;
                    while (i11 < length5) {
                        Annotation annotation2 = annotationArr[i11];
                        i11++;
                        Class javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                        ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                        Intrinsics.checkNotNullExpressionValue(annotation2, "annotation");
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i9, classId, new ReflectAnnotationSource(annotation2));
                        if (visitParameterAnnotation != null) {
                            a.d(visitParameterAnnotation, annotation2, javaClass);
                        }
                        declaredMethods = declaredMethods;
                        length = length;
                        i6 = i6;
                    }
                    i9 = i10;
                }
                methodArr = declaredMethods;
                i4 = length;
                i3 = i6;
                visitMethod.visitEnd();
            }
            declaredMethods = methodArr;
            length = i4;
            i5 = i3;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        int length6 = declaredConstructors.length;
        int i12 = 0;
        while (i12 < length6) {
            Constructor<?> constructor = declaredConstructors[i12];
            int i13 = i12 + 1;
            Name special = Name.special("<init>");
            Intrinsics.checkNotNullExpressionValue(special, "special(\"<init>\")");
            Intrinsics.checkNotNullExpressionValue(constructor, "constructor");
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            StringBuilder L2 = a2.b.a.a.a.L("(");
            Class<?>[] parameterTypes2 = constructor.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes2, "constructor.parameterTypes");
            int length7 = parameterTypes2.length;
            int i14 = 0;
            while (i14 < length7) {
                Class<?> cls3 = parameterTypes2[i14];
                i14++;
                Intrinsics.checkNotNullExpressionValue(cls3, str2);
                L2.append(ReflectClassUtilKt.getDesc(cls3));
                declaredConstructors = declaredConstructors;
            }
            L2.append(")V");
            String sb2 = L2.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod2 = memberVisitor.visitMethod(special, sb2);
            if (visitMethod2 == null) {
                i2 = length6;
                i = i13;
                str4 = str;
                str3 = str2;
            } else {
                Annotation[] declaredAnnotations2 = constructor.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations2, "constructor.declaredAnnotations");
                int length8 = declaredAnnotations2.length;
                int i15 = 0;
                while (i15 < length8) {
                    Annotation annotation3 = declaredAnnotations2[i15];
                    i15++;
                    Intrinsics.checkNotNullExpressionValue(annotation3, "annotation");
                    a.c(visitMethod2, annotation3);
                }
                Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations2, "parameterAnnotations");
                if (!(parameterAnnotations2.length == 0)) {
                    int length9 = constructor.getParameterTypes().length - parameterAnnotations2.length;
                    int length10 = parameterAnnotations2.length;
                    int i16 = 0;
                    while (i16 < length10) {
                        Annotation[] annotationArr2 = parameterAnnotations2[i16];
                        int i17 = i16 + 1;
                        Intrinsics.checkNotNullExpressionValue(annotationArr2, str);
                        int length11 = annotationArr2.length;
                        int i18 = 0;
                        while (i18 < length11) {
                            Annotation annotation4 = annotationArr2[i18];
                            int i19 = i18 + 1;
                            Class javaClass2 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation4));
                            int i20 = i16 + length9;
                            ClassId classId2 = ReflectClassUtilKt.getClassId(javaClass2);
                            Intrinsics.checkNotNullExpressionValue(annotation4, "annotation");
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation2 = visitMethod2.visitParameterAnnotation(i20, classId2, new ReflectAnnotationSource(annotation4));
                            if (visitParameterAnnotation2 != null) {
                                a.d(visitParameterAnnotation2, annotation4, javaClass2);
                            }
                            length11 = length11;
                            str = str;
                            i18 = i19;
                            length9 = length9;
                            str2 = str2;
                        }
                        i16 = i17;
                        length6 = length6;
                        i13 = i13;
                    }
                }
                i2 = length6;
                i = i13;
                str4 = str;
                str3 = str2;
                visitMethod2.visitEnd();
            }
            declaredConstructors = declaredConstructors;
            length6 = i2;
            i12 = i;
            str = str4;
            str2 = str3;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        int length12 = declaredFields.length;
        int i21 = 0;
        while (i21 < length12) {
            Field field = declaredFields[i21];
            i21++;
            Name identifier2 = Name.identifier(field.getName());
            Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(field.name)");
            Intrinsics.checkNotNullExpressionValue(field, AnalyticFieldsName.field);
            Intrinsics.checkNotNullParameter(field, AnalyticFieldsName.field);
            Class<?> type = field.getType();
            Intrinsics.checkNotNullExpressionValue(type, "field.type");
            KotlinJvmBinaryClass.AnnotationVisitor visitField = memberVisitor.visitField(identifier2, ReflectClassUtilKt.getDesc(type), null);
            if (visitField != null) {
                Annotation[] declaredAnnotations3 = field.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations3, "field.declaredAnnotations");
                int length13 = declaredAnnotations3.length;
                int i22 = 0;
                while (i22 < length13) {
                    Annotation annotation5 = declaredAnnotations3[i22];
                    i22++;
                    Intrinsics.checkNotNullExpressionValue(annotation5, "annotation");
                    a.c(visitField, annotation5);
                }
                visitField.visitEnd();
            }
        }
    }
}
