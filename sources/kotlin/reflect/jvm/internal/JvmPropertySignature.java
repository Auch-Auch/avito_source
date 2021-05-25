package kotlin.reflect.jvm.internal;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import com.avito.android.util.preferences.db_preferences.Types;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "", "asString", "()Ljava/lang/String;", "<init>", "()V", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public abstract class JvmPropertySignature {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "asString", "()Ljava/lang/String;", "Ljava/lang/reflect/Field;", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Field;", "getField", "()Ljava/lang/reflect/Field;", AnalyticFieldsName.field, "<init>", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class JavaField extends JvmPropertySignature {
        @NotNull
        public final Field a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public JavaField(@NotNull Field field) {
            super(null);
            Intrinsics.checkNotNullParameter(field, AnalyticFieldsName.field);
            this.a = field;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        @NotNull
        public String asString() {
            StringBuilder sb = new StringBuilder();
            String name = this.a.getName();
            Intrinsics.checkNotNullExpressionValue(name, "field.name");
            sb.append(JvmAbi.getterName(name));
            sb.append("()");
            Class<?> type = this.a.getType();
            Intrinsics.checkNotNullExpressionValue(type, "field.type");
            sb.append(ReflectClassUtilKt.getDesc(type));
            return sb.toString();
        }

        @NotNull
        public final Field getField() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "asString", "()Ljava/lang/String;", "Ljava/lang/reflect/Method;", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Method;", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getterMethod", AuthSource.BOOKING_ORDER, "getSetterMethod", "setterMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class JavaMethodProperty extends JvmPropertySignature {
        @NotNull
        public final Method a;
        @Nullable
        public final Method b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public JavaMethodProperty(@NotNull Method method, @Nullable Method method2) {
            super(null);
            Intrinsics.checkNotNullParameter(method, "getterMethod");
            this.a = method;
            this.b = method2;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        @NotNull
        public String asString() {
            return RuntimeTypeMapperKt.access$getSignature$p(this.a);
        }

        @NotNull
        public final Method getGetterMethod() {
            return this.a;
        }

        @Nullable
        public final Method getSetterMethod() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "asString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "f", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", AuthSource.BOOKING_ORDER, "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "c", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "d", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", SessionContract.SIGNATURE, "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "e", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "nameResolver", AuthSource.SEND_ABUSE, "Ljava/lang/String;", Types.STRING, "<init>", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class KotlinProperty extends JvmPropertySignature {
        public final String a;
        @NotNull
        public final PropertyDescriptor b;
        @NotNull
        public final ProtoBuf.Property c;
        @NotNull
        public final JvmProtoBuf.JvmPropertySignature d;
        @NotNull
        public final NameResolver e;
        @NotNull
        public final TypeTable f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public KotlinProperty(@NotNull PropertyDescriptor propertyDescriptor, @NotNull ProtoBuf.Property property, @NotNull JvmProtoBuf.JvmPropertySignature jvmPropertySignature, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
            super(null);
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(property, "proto");
            Intrinsics.checkNotNullParameter(jvmPropertySignature, SessionContract.SIGNATURE);
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(typeTable, "typeTable");
            this.b = propertyDescriptor;
            this.c = property;
            this.d = jvmPropertySignature;
            this.e = nameResolver;
            this.f = typeTable;
            if (jvmPropertySignature.hasGetter()) {
                StringBuilder sb = new StringBuilder();
                JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                Intrinsics.checkNotNullExpressionValue(getter, "signature.getter");
                sb.append(nameResolver.getString(getter.getName()));
                JvmProtoBuf.JvmMethodSignature getter2 = jvmPropertySignature.getGetter();
                Intrinsics.checkNotNullExpressionValue(getter2, "signature.getter");
                sb.append(nameResolver.getString(getter2.getDesc()));
                str = sb.toString();
            } else {
                JvmMemberSignature.Field jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, property, nameResolver, typeTable, false, 8, null);
                if (jvmFieldSignature$default != null) {
                    String component1 = jvmFieldSignature$default.component1();
                    String component2 = jvmFieldSignature$default.component2();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(JvmAbi.getterName(component1));
                    DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
                    Intrinsics.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
                    if (!Intrinsics.areEqual(propertyDescriptor.getVisibility(), DescriptorVisibilities.INTERNAL) || !(containingDeclaration instanceof DeserializedClassDescriptor)) {
                        if (Intrinsics.areEqual(propertyDescriptor.getVisibility(), DescriptorVisibilities.PRIVATE) && (containingDeclaration instanceof PackageFragmentDescriptor)) {
                            Objects.requireNonNull(propertyDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                            DeserializedContainerSource containerSource = ((DeserializedPropertyDescriptor) propertyDescriptor).getContainerSource();
                            if (containerSource instanceof JvmPackagePartSource) {
                                JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) containerSource;
                                if (jvmPackagePartSource.getFacadeClassName() != null) {
                                    StringBuilder L = a.L("$");
                                    L.append(jvmPackagePartSource.getSimpleName().asString());
                                    str2 = L.toString();
                                }
                            }
                        }
                        str2 = "";
                    } else {
                        ProtoBuf.Class classProto = ((DeserializedClassDescriptor) containingDeclaration).getClassProto();
                        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> generatedExtension = JvmProtoBuf.classModuleName;
                        Intrinsics.checkNotNullExpressionValue(generatedExtension, "JvmProtoBuf.classModuleName");
                        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(classProto, generatedExtension);
                        String str3 = (num == null || (str3 = nameResolver.getString(num.intValue())) == null) ? "main" : str3;
                        StringBuilder L2 = a.L("$");
                        L2.append(NameUtils.sanitizeAsJavaIdentifier(str3));
                        str2 = L2.toString();
                    }
                    str = a.u(sb2, str2, "()", component2);
                } else {
                    throw new KotlinReflectionInternalError("No field signature for property: " + propertyDescriptor);
                }
            }
            this.a = str;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        @NotNull
        public String asString() {
            return this.a;
        }

        @NotNull
        public final PropertyDescriptor getDescriptor() {
            return this.b;
        }

        @NotNull
        public final NameResolver getNameResolver() {
            return this.e;
        }

        @NotNull
        public final ProtoBuf.Property getProto() {
            return this.c;
        }

        @NotNull
        public final JvmProtoBuf.JvmPropertySignature getSignature() {
            return this.d;
        }

        @NotNull
        public final TypeTable getTypeTable() {
            return this.f;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "asString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", AuthSource.BOOKING_ORDER, "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", AuthSource.SEND_ABUSE, "getGetterSignature", "getterSignature", "<init>", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class MappedKotlinProperty extends JvmPropertySignature {
        @NotNull
        public final JvmFunctionSignature.KotlinFunction a;
        @Nullable
        public final JvmFunctionSignature.KotlinFunction b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MappedKotlinProperty(@NotNull JvmFunctionSignature.KotlinFunction kotlinFunction, @Nullable JvmFunctionSignature.KotlinFunction kotlinFunction2) {
            super(null);
            Intrinsics.checkNotNullParameter(kotlinFunction, "getterSignature");
            this.a = kotlinFunction;
            this.b = kotlinFunction2;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        @NotNull
        public String asString() {
            return this.a.asString();
        }

        @NotNull
        public final JvmFunctionSignature.KotlinFunction getGetterSignature() {
            return this.a;
        }

        @Nullable
        public final JvmFunctionSignature.KotlinFunction getSetterSignature() {
            return this.b;
        }
    }

    public JvmPropertySignature() {
    }

    @NotNull
    public abstract String asString();

    public JvmPropertySignature(j jVar) {
    }
}
