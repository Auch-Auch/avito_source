package kotlin.reflect.jvm.internal;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "", "asString", "()Ljava/lang/String;", "<init>", "()V", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public abstract class JvmFunctionSignature {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\r¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R'\u0010\f\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getMethods", "()Ljava/util/List;", "methods", "Ljava/lang/Class;", AuthSource.BOOKING_ORDER, "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class FakeJavaAnnotationConstructor extends JvmFunctionSignature {
        @NotNull
        public final List<Method> a;
        @NotNull
        public final Class<?> b;

        public static final class a extends Lambda implements Function1<Method, CharSequence> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public CharSequence invoke(Method method) {
                Method method2 = method;
                Intrinsics.checkNotNullExpressionValue(method2, "it");
                Class<?> returnType = method2.getReturnType();
                Intrinsics.checkNotNullExpressionValue(returnType, "it.returnType");
                return ReflectClassUtilKt.getDesc(returnType);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FakeJavaAnnotationConstructor(@NotNull Class<?> cls) {
            super(null);
            Intrinsics.checkNotNullParameter(cls, "jClass");
            this.b = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "jClass.declaredMethods");
            this.a = ArraysKt___ArraysKt.sortedWith(declaredMethods, new JvmFunctionSignature$FakeJavaAnnotationConstructor$$special$$inlined$sortedBy$1());
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String asString() {
            return CollectionsKt___CollectionsKt.joinToString$default(this.a, "", "<init>(", ")V", 0, null, a.a, 24, null);
        }

        @NotNull
        public final List<Method> getMethods() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", "Ljava/lang/reflect/Constructor;", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Constructor;", "getConstructor", "()Ljava/lang/reflect/Constructor;", "constructor", "<init>", "(Ljava/lang/reflect/Constructor;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class JavaConstructor extends JvmFunctionSignature {
        @NotNull
        public final Constructor<?> a;

        public static final class a extends Lambda implements Function1<Class<?>, CharSequence> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public CharSequence invoke(Class<?> cls) {
                Class<?> cls2 = cls;
                Intrinsics.checkNotNullExpressionValue(cls2, "it");
                return ReflectClassUtilKt.getDesc(cls2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public JavaConstructor(@NotNull Constructor<?> constructor) {
            super(null);
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            this.a = constructor;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String asString() {
            Class<?>[] parameterTypes = this.a.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
            return ArraysKt___ArraysKt.joinToString$default(parameterTypes, "", "<init>(", ")V", 0, (CharSequence) null, a.a, 24, (Object) null);
        }

        @NotNull
        public final Constructor<?> getConstructor() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", "Ljava/lang/reflect/Method;", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Method;", "getMethod", "()Ljava/lang/reflect/Method;", "method", "<init>", "(Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class JavaMethod extends JvmFunctionSignature {
        @NotNull
        public final Method a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public JavaMethod(@NotNull Method method) {
            super(null);
            Intrinsics.checkNotNullParameter(method, "method");
            this.a = method;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String asString() {
            return RuntimeTypeMapperKt.access$getSignature$p(this.a);
        }

        @NotNull
        public final Method getMethod() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0013\u0010\t\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "_signature", "getConstructorDesc", "constructorDesc", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", AuthSource.BOOKING_ORDER, "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", SessionContract.SIGNATURE, "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class KotlinConstructor extends JvmFunctionSignature {
        public final String a;
        @NotNull
        public final JvmMemberSignature.Method b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public KotlinConstructor(@NotNull JvmMemberSignature.Method method) {
            super(null);
            Intrinsics.checkNotNullParameter(method, SessionContract.SIGNATURE);
            this.b = method;
            this.a = method.asString();
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String asString() {
            return this.a;
        }

        @NotNull
        public final String getConstructorDesc() {
            return this.b.getDesc();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", "getMethodDesc", "methodDesc", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", AuthSource.BOOKING_ORDER, "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", SessionContract.SIGNATURE, "getMethodName", "methodName", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "_signature", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class KotlinFunction extends JvmFunctionSignature {
        public final String a;
        @NotNull
        public final JvmMemberSignature.Method b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public KotlinFunction(@NotNull JvmMemberSignature.Method method) {
            super(null);
            Intrinsics.checkNotNullParameter(method, SessionContract.SIGNATURE);
            this.b = method;
            this.a = method.asString();
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String asString() {
            return this.a;
        }

        @NotNull
        public final String getMethodDesc() {
            return this.b.getDesc();
        }

        @NotNull
        public final String getMethodName() {
            return this.b.getName();
        }
    }

    public JvmFunctionSignature() {
    }

    @NotNull
    public abstract String asString();

    public JvmFunctionSignature(j jVar) {
    }
}
