package kotlin.reflect.jvm.internal;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.g;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\bI\u0010JJ'\u0010\u0007\u001a\u00028\u00002\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00028\u00002\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0011\u001a\u00028\u00002\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t2\f\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00168D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R0\u0010 \u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001c \u001d*\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b0\u001b0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R0\u0010&\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020% \u001d*\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001b0\u001b0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020%0\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0018R0\u0010-\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n \u001d*\n\u0012\u0004\u0012\u00020\n\u0018\u00010+0+0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u0016\u00101\u001a\u00020.8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R$\u00104\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u000102020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010\u001fR\u001a\u00108\u001a\u0006\u0012\u0002\b\u0003058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00128V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0018R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b=\u0010(R\u001c\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u0001058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u00107R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020A0\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010(R\u0016\u0010D\u001a\u00020\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u0018R\u0016\u0010H\u001a\u00020E8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "", "", "args", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "", "Lkotlin/reflect/KParameter;", "callBy", "(Ljava/util/Map;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "continuationArgument", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDefaultMethod", "Lkotlin/reflect/KType;", "type", AuthSource.SEND_ABUSE, "(Lkotlin/reflect/KType;)Ljava/lang/Object;", "", DecodeProducer.EXTRA_IS_FINAL, "()Z", "isAnnotationConstructor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "d", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "_typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "", "_annotations", "getAnnotations", "()Ljava/util/List;", "annotations", "isAbstract", "Ljava/util/ArrayList;", AuthSource.BOOKING_ORDER, "_parameters", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "c", "_returnType", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "getReturnType", "()Lkotlin/reflect/KType;", "returnType", "isOpen", "getParameters", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "getDefaultCaller", "defaultCaller", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters", "isBound", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "descriptor", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    public final ReflectProperties.LazySoftVal<List<Annotation>> a;
    public final ReflectProperties.LazySoftVal<ArrayList<KParameter>> b;
    public final ReflectProperties.LazySoftVal<KTypeImpl> c;
    public final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> d;

    public static final class a extends Lambda implements Function0<List<? extends Annotation>> {
        public final /* synthetic */ KCallableImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KCallableImpl kCallableImpl) {
            super(0);
            this.a = kCallableImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends Annotation> invoke() {
            return UtilKt.computeAnnotations(this.a.getDescriptor());
        }
    }

    public static final class b extends Lambda implements Function0<ArrayList<KParameter>> {
        public final /* synthetic */ KCallableImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KCallableImpl kCallableImpl) {
            super(0);
            this.a = kCallableImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ArrayList<KParameter> invoke() {
            int i;
            CallableMemberDescriptor descriptor = this.a.getDescriptor();
            ArrayList<KParameter> arrayList = new ArrayList<>();
            int i2 = 0;
            if (!this.a.isBound()) {
                ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(descriptor);
                if (instanceReceiverParameter != null) {
                    arrayList.add(new KParameterImpl(this.a, 0, KParameter.Kind.INSTANCE, new k5(0, instanceReceiverParameter)));
                    i = 1;
                } else {
                    i = 0;
                }
                ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
                if (extensionReceiverParameter != null) {
                    arrayList.add(new KParameterImpl(this.a, i, KParameter.Kind.EXTENSION_RECEIVER, new k5(1, extensionReceiverParameter)));
                    i++;
                }
            } else {
                i = 0;
            }
            List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            int size = valueParameters.size();
            while (i2 < size) {
                arrayList.add(new KParameterImpl(this.a, i, KParameter.Kind.VALUE, new t6.w.f.a.a(descriptor, i2)));
                i2++;
                i++;
            }
            if (this.a.isAnnotationConstructor() && (descriptor instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
                g.sortWith(arrayList, new KCallableImpl$_parameters$1$$special$$inlined$sortBy$1());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    public static final class c extends Lambda implements Function0<KTypeImpl> {
        public final /* synthetic */ KCallableImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KCallableImpl kCallableImpl) {
            super(0);
            this.a = kCallableImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public KTypeImpl invoke() {
            KotlinType returnType = this.a.getDescriptor().getReturnType();
            Intrinsics.checkNotNull(returnType);
            Intrinsics.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
            return new KTypeImpl(returnType, new t6.w.f.a.b(this));
        }
    }

    public static final class d extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
        public final /* synthetic */ KCallableImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KCallableImpl kCallableImpl) {
            super(0);
            this.a = kCallableImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends KTypeParameterImpl> invoke() {
            List<TypeParameterDescriptor> typeParameters = this.a.getDescriptor().getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(typeParameters, 10));
            for (T t : typeParameters) {
                KCallableImpl kCallableImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(t, "descriptor");
                arrayList.add(new KTypeParameterImpl(kCallableImpl, t));
            }
            return arrayList;
        }
    }

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> lazySoft = ReflectProperties.lazySoft(new a(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.a = lazySoft;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> lazySoft2 = ReflectProperties.lazySoft(new b(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.b = lazySoft2;
        ReflectProperties.LazySoftVal<KTypeImpl> lazySoft3 = ReflectProperties.lazySoft(new c(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.c = lazySoft3;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> lazySoft4 = ReflectProperties.lazySoft(new d(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft4, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this.d = lazySoft4;
    }

    public static final Type access$extractContinuationArgument(KCallableImpl kCallableImpl) {
        Type[] lowerBounds;
        CallableMemberDescriptor descriptor = kCallableImpl.getDescriptor();
        if (!(descriptor instanceof FunctionDescriptor)) {
            descriptor = null;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) descriptor;
        if (functionDescriptor == null || !functionDescriptor.isSuspend()) {
            return null;
        }
        Object lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) kCallableImpl.getCaller().getParameterTypes());
        if (!(lastOrNull instanceof ParameterizedType)) {
            lastOrNull = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) lastOrNull;
        if (!Intrinsics.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "continuationType.actualTypeArguments");
        Object single = ArraysKt___ArraysKt.single(actualTypeArguments);
        if (!(single instanceof WildcardType)) {
            single = null;
        }
        WildcardType wildcardType = (WildcardType) single;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) ArraysKt___ArraysKt.first(lowerBounds);
    }

    public final Object a(KType kType) {
        Class javaClass = JvmClassMappingKt.getJavaClass((KClass) KTypesJvm.getJvmErasure(kType));
        if (javaClass.isArray()) {
            Object newInstance = Array.newInstance(javaClass.getComponentType(), 0);
            Intrinsics.checkNotNullExpressionValue(newInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return newInstance;
        }
        throw new KotlinReflectionInternalError(a2.b.a.a.a.E2(javaClass, a2.b.a.a.a.L("Cannot instantiate the default empty array of type "), ", because it is not an array type"));
    }

    @Override // kotlin.reflect.KCallable
    public R call(@NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        try {
            return (R) getCaller().call(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(@NotNull Map<KParameter, ? extends Object> map) {
        Object obj;
        Intrinsics.checkNotNullParameter(map, "args");
        if (!isAnnotationConstructor()) {
            return callDefaultMethod$kotlin_reflection(map, null);
        }
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(parameters, 10));
        for (T t : parameters) {
            if (map.containsKey(t)) {
                obj = map.get(t);
                if (obj == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + ((Object) t) + ')');
                }
            } else if (t.isOptional()) {
                obj = null;
            } else if (t.isVararg()) {
                obj = a(t.getType());
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + ((Object) t));
            }
            arrayList.add(obj);
        }
        Caller<?> defaultCaller = getDefaultCaller();
        if (defaultCaller != null) {
            try {
                Object[] array = arrayList.toArray(new Object[0]);
                if (array != null) {
                    return (R) defaultCaller.call(array);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (IllegalAccessException e) {
                throw new IllegalCallableAccessException(e);
            }
        } else {
            StringBuilder L = a2.b.a.a.a.L("This callable does not support a default call: ");
            L.append(getDescriptor());
            throw new KotlinReflectionInternalError(L.toString());
        }
    }

    public final R callDefaultMethod$kotlin_reflection(@NotNull Map<KParameter, ? extends Object> map, @Nullable Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(map, "args");
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<KParameter> it = parameters.iterator();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            Object obj = null;
            if (it.hasNext()) {
                KParameter next = it.next();
                if (i != 0 && i % 32 == 0) {
                    arrayList2.add(Integer.valueOf(i2));
                    i2 = 0;
                }
                if (map.containsKey(next)) {
                    arrayList.add(map.get(next));
                } else if (next.isOptional()) {
                    if (!UtilKt.isInlineClassType(next.getType())) {
                        obj = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(next.getType()));
                    }
                    arrayList.add(obj);
                    i2 = (1 << (i % 32)) | i2;
                    z = true;
                } else if (next.isVararg()) {
                    arrayList.add(a(next.getType()));
                } else {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                if (next.getKind() == KParameter.Kind.VALUE) {
                    i++;
                }
            } else {
                if (continuation != null) {
                    arrayList.add(continuation);
                }
                if (!z) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i2));
                Caller<?> defaultCaller = getDefaultCaller();
                if (defaultCaller != null) {
                    arrayList.addAll(arrayList2);
                    arrayList.add(null);
                    try {
                        Object[] array2 = arrayList.toArray(new Object[0]);
                        if (array2 != null) {
                            return (R) defaultCaller.call(array2);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    } catch (IllegalAccessException e) {
                        throw new IllegalCallableAccessException(e);
                    }
                } else {
                    StringBuilder L = a2.b.a.a.a.L("This callable does not support a default call: ");
                    L.append(getDescriptor());
                    throw new KotlinReflectionInternalError(L.toString());
                }
            }
        }
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this.a.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_annotations()");
        return invoke;
    }

    @NotNull
    public abstract Caller<?> getCaller();

    @NotNull
    public abstract KDeclarationContainerImpl getContainer();

    @Nullable
    public abstract Caller<?> getDefaultCaller();

    @NotNull
    public abstract CallableMemberDescriptor getDescriptor();

    @Override // kotlin.reflect.KCallable
    @NotNull
    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this.b.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_parameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public KType getReturnType() {
        KTypeImpl invoke = this.c.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_returnType()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> invoke = this.d.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_typeParameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @Nullable
    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    public final boolean isAnnotationConstructor() {
        return Intrinsics.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    public abstract boolean isBound();

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }
}
