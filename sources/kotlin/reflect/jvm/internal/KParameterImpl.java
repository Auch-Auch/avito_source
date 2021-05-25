package kotlin.reflect.jvm.internal;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001a\u0012\u0006\u00101\u001a\u00020\u0007\u0012\u0006\u0010+\u001a\u00020&\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001102¢\u0006\u0004\b4\u00105J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00048V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00048V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u001d\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 8V@\u0016X\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010$R\u001c\u0010+\u001a\u00020&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\fR\u001c\u00101\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\t¨\u00066"}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", AuthSource.SEND_ABUSE, "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor", "isVararg", "()Z", "isOptional", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "c", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "callable", "", "", AuthSource.BOOKING_ORDER, "getAnnotations", "()Ljava/util/List;", "annotations", "Lkotlin/reflect/KParameter$Kind;", "e", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", MessageBody.Location.KIND, "getName", "name", "d", "I", "getIndex", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function0;", "computeDescriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public final class KParameterImpl implements KParameter {
    public static final /* synthetic */ KProperty[] f = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    public final ReflectProperties.LazySoftVal a;
    @NotNull
    public final ReflectProperties.LazySoftVal b = ReflectProperties.lazySoft(new a(this));
    @NotNull
    public final KCallableImpl<?> c;
    public final int d;
    @NotNull
    public final KParameter.Kind e;

    public static final class a extends Lambda implements Function0<List<? extends Annotation>> {
        public final /* synthetic */ KParameterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KParameterImpl kParameterImpl) {
            super(0);
            this.a = kParameterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends Annotation> invoke() {
            return UtilKt.computeAnnotations(this.a.a());
        }
    }

    public static final class b extends Lambda implements Function0<Type> {
        public final /* synthetic */ KParameterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KParameterImpl kParameterImpl) {
            super(0);
            this.a = kParameterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Type invoke() {
            ParameterDescriptor a3 = this.a.a();
            if (!(a3 instanceof ReceiverParameterDescriptor) || !Intrinsics.areEqual(UtilKt.getInstanceReceiverParameter(this.a.getCallable().getDescriptor()), a3) || this.a.getCallable().getDescriptor().getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                return this.a.getCallable().getCaller().getParameterTypes().get(this.a.getIndex());
            }
            DeclarationDescriptor containingDeclaration = this.a.getCallable().getDescriptor().getContainingDeclaration();
            Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) containingDeclaration);
            if (javaClass != null) {
                return javaClass;
            }
            throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + a3);
        }
    }

    public KParameterImpl(@NotNull KCallableImpl<?> kCallableImpl, int i, @NotNull KParameter.Kind kind, @NotNull Function0<? extends ParameterDescriptor> function0) {
        Intrinsics.checkNotNullParameter(kCallableImpl, "callable");
        Intrinsics.checkNotNullParameter(kind, MessageBody.Location.KIND);
        Intrinsics.checkNotNullParameter(function0, "computeDescriptor");
        this.c = kCallableImpl;
        this.d = i;
        this.e = kind;
        this.a = ReflectProperties.lazySoft(function0);
    }

    public final ParameterDescriptor a() {
        return (ParameterDescriptor) this.a.getValue(this, f[0]);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            if (Intrinsics.areEqual(this.c, kParameterImpl.c) && getIndex() == kParameterImpl.getIndex()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return (List) this.b.getValue(this, f[1]);
    }

    @NotNull
    public final KCallableImpl<?> getCallable() {
        return this.c;
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.d;
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public KParameter.Kind getKind() {
        return this.e;
    }

    @Override // kotlin.reflect.KParameter
    @Nullable
    public String getName() {
        ParameterDescriptor a3 = a();
        if (!(a3 instanceof ValueParameterDescriptor)) {
            a3 = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) a3;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name = valueParameterDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "valueParameter.name");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public KType getType() {
        KotlinType type = a().getType();
        Intrinsics.checkNotNullExpressionValue(type, "descriptor.type");
        return new KTypeImpl(type, new b(this));
    }

    public int hashCode() {
        return Integer.valueOf(getIndex()).hashCode() + (this.c.hashCode() * 31);
    }

    @Override // kotlin.reflect.KParameter
    public boolean isOptional() {
        ParameterDescriptor a3 = a();
        if (!(a3 instanceof ValueParameterDescriptor)) {
            a3 = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) a3;
        if (valueParameterDescriptor != null) {
            return DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    public boolean isVararg() {
        ParameterDescriptor a3 = a();
        return (a3 instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) a3).getVarargElementType() != null;
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }
}
