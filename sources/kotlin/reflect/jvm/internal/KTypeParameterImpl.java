package kotlin.reflect.jvm.internal;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b*\u0010+J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR\u0016\u0010\u001e\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR#\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 8V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "Lkotlin/reflect/jvm/internal/KClassImpl;", AuthSource.SEND_ABUSE, "(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "c", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", AuthSource.BOOKING_ORDER, "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "container", "getName", "name", "isReified", "()Z", "", "Lkotlin/reflect/KType;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getUpperBounds", "()Ljava/util/List;", "upperBounds", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "variance", "<init>", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public final class KTypeParameterImpl implements KTypeParameter, KClassifierImpl {
    public static final /* synthetic */ KProperty[] d = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    @NotNull
    public final ReflectProperties.LazySoftVal a = ReflectProperties.lazySoft(new a(this));
    public final KTypeParameterOwnerImpl b;
    @NotNull
    public final TypeParameterDescriptor c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Variance.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    public static final class a extends Lambda implements Function0<List<? extends KTypeImpl>> {
        public final /* synthetic */ KTypeParameterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KTypeParameterImpl kTypeParameterImpl) {
            super(0);
            this.a = kTypeParameterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends KTypeImpl> invoke() {
            List<KotlinType> upperBounds = this.a.getDescriptor().getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "descriptor.upperBounds");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(upperBounds, 10));
            Iterator<T> it = upperBounds.iterator();
            while (it.hasNext()) {
                arrayList.add(new KTypeImpl(it.next(), null, 2, null));
            }
            return arrayList;
        }
    }

    public KTypeParameterImpl(@Nullable KTypeParameterOwnerImpl kTypeParameterOwnerImpl, @NotNull TypeParameterDescriptor typeParameterDescriptor) {
        Object obj;
        KClassImpl<?> kClassImpl;
        Class<?> klass;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "descriptor");
        this.c = typeParameterDescriptor;
        if (kTypeParameterOwnerImpl == null) {
            DeclarationDescriptor containingDeclaration = getDescriptor().getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                obj = a((ClassDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof CallableMemberDescriptor) {
                DeclarationDescriptor containingDeclaration2 = ((CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "declaration.containingDeclaration");
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    kClassImpl = a((ClassDescriptor) containingDeclaration2);
                } else {
                    ReflectKotlinClass reflectKotlinClass = null;
                    DeserializedMemberDescriptor deserializedMemberDescriptor = (DeserializedMemberDescriptor) (!(containingDeclaration instanceof DeserializedMemberDescriptor) ? null : containingDeclaration);
                    if (deserializedMemberDescriptor != null) {
                        DeserializedContainerSource containerSource = deserializedMemberDescriptor.getContainerSource();
                        JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) (!(containerSource instanceof JvmPackagePartSource) ? null : containerSource);
                        KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource != null ? jvmPackagePartSource.getKnownJvmBinaryClass() : null;
                        ReflectKotlinClass reflectKotlinClass2 = knownJvmBinaryClass instanceof ReflectKotlinClass ? knownJvmBinaryClass : reflectKotlinClass;
                        if (reflectKotlinClass2 == null || (klass = reflectKotlinClass2.getKlass()) == null) {
                            throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + deserializedMemberDescriptor);
                        }
                        KClass kotlinClass = JvmClassMappingKt.getKotlinClass(klass);
                        Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                        kClassImpl = (KClassImpl) kotlinClass;
                    } else {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                }
                obj = containingDeclaration.accept(new CreateKCallableVisitor(kClassImpl), Unit.INSTANCE);
            } else {
                throw new KotlinReflectionInternalError("Unknown type parameter container: " + containingDeclaration);
            }
            Intrinsics.checkNotNullExpressionValue(obj, "when (val declaration = … $declaration\")\n        }");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) obj;
        }
        this.b = kTypeParameterOwnerImpl;
    }

    public final KClassImpl<?> a(ClassDescriptor classDescriptor) {
        Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
        KClassImpl<?> kClassImpl = (KClassImpl) (javaClass != null ? JvmClassMappingKt.getKotlinClass(javaClass) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        StringBuilder L = a2.b.a.a.a.L("Type parameter container is not resolved: ");
        L.append(classDescriptor.getContainingDeclaration());
        throw new KotlinReflectionInternalError(L.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) obj;
            if (Intrinsics.areEqual(this.b, kTypeParameterImpl.b) && Intrinsics.areEqual(getName(), kTypeParameterImpl.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public String getName() {
        String asString = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "descriptor.name.asString()");
        return asString;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public List<KType> getUpperBounds() {
        return (List) this.a.getValue(this, d[0]);
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public KVariance getVariance() {
        int ordinal = getDescriptor().getVariance().ordinal();
        if (ordinal == 0) {
            return KVariance.INVARIANT;
        }
        if (ordinal == 1) {
            return KVariance.IN;
        }
        if (ordinal == 2) {
            return KVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        return getName().hashCode() + (this.b.hashCode() * 31);
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return getDescriptor().isReified();
    }

    @NotNull
    public String toString() {
        return TypeParameterReference.Companion.toString(this);
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    @NotNull
    public TypeParameterDescriptor getDescriptor() {
        return this.c;
    }
}
