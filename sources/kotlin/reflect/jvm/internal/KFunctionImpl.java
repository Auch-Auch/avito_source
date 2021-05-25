package kotlin.reflect.jvm.internal;

import a2.g.r.g;
import com.avito.android.util.preferences.SessionContract;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010/\u001a\u00020*¢\u0006\u0004\b9\u0010:B7\b\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\"\u001a\u00020\r\u0012\u0006\u0010%\u001a\u00020\r\u0012\b\u0010;\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b9\u0010<B+\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\"\u001a\u00020\r\u0012\u0006\u0010%\u001a\u00020\r\u0012\b\u00105\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b9\u0010=J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00168V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\fR#\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00168V@\u0016X\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR\u0016\u0010\"\u001a\u00020\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000fR\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0016\u0010)\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u001d\u0010/\u001a\u00020*8V@\u0016X\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b0\u0010'R\u0016\u00101\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b1\u0010'R\u0016\u00102\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b2\u0010'R\u0018\u00105\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006>"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "h", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/calls/Caller;", "f", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "getArity", "arity", g.a, "getDefaultCaller", "defaultCaller", "getName", "name", "i", "Ljava/lang/String;", SessionContract.SIGNATURE, "isBound", "()Z", "isInfix", "isSuspend", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "e", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor", "isInline", "isExternal", "isOperator", "getBoundReceiver", "()Ljava/lang/Object;", "boundReceiver", "j", "Ljava/lang/Object;", "rawBoundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    public static final /* synthetic */ KProperty[] k = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    @NotNull
    public final ReflectProperties.LazySoftVal e;
    @NotNull
    public final ReflectProperties.LazyVal f;
    @Nullable
    public final ReflectProperties.LazyVal g;
    @NotNull
    public final KDeclarationContainerImpl h;
    public final String i;
    public final Object j;

    public static final class a extends Lambda implements Function0<Caller<? extends Member>> {
        public final /* synthetic */ KFunctionImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KFunctionImpl kFunctionImpl) {
            super(0);
            this.a = kFunctionImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Caller<? extends Member> invoke() {
            Object obj;
            Caller caller;
            JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this.a.getDescriptor());
            if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
                if (this.a.isAnnotationConstructor()) {
                    Class<?> jClass = this.a.getContainer().getJClass();
                    List<KParameter> parameters = this.a.getParameters();
                    ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = it.next().getName();
                        Intrinsics.checkNotNull(name);
                        arrayList.add(name);
                    }
                    return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
                }
                obj = this.a.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
            } else if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
                JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature;
                obj = this.a.getContainer().findMethodBySignature(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc());
            } else if (mapSignature instanceof JvmFunctionSignature.JavaMethod) {
                obj = ((JvmFunctionSignature.JavaMethod) mapSignature).getMethod();
            } else if (mapSignature instanceof JvmFunctionSignature.JavaConstructor) {
                obj = ((JvmFunctionSignature.JavaConstructor) mapSignature).getConstructor();
            } else if (mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
                Class<?> jClass2 = this.a.getContainer().getJClass();
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(methods, 10));
                for (T t : methods) {
                    Intrinsics.checkNotNullExpressionValue(t, "it");
                    arrayList2.add(t.getName());
                }
                return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, methods);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (obj instanceof Constructor) {
                KFunctionImpl kFunctionImpl = this.a;
                caller = KFunctionImpl.access$createConstructorCaller(kFunctionImpl, (Constructor) obj, kFunctionImpl.getDescriptor());
            } else if (obj instanceof Method) {
                Method method = (Method) obj;
                if (!Modifier.isStatic(method.getModifiers())) {
                    caller = KFunctionImpl.access$createInstanceMethodCaller(this.a, method);
                } else if (this.a.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) != null) {
                    caller = KFunctionImpl.access$createJvmStaticInObjectCaller(this.a, method);
                } else {
                    caller = KFunctionImpl.access$createStaticMethodCaller(this.a, method);
                }
            } else {
                StringBuilder L = a2.b.a.a.a.L("Could not compute caller for function: ");
                L.append(this.a.getDescriptor());
                L.append(" (member = ");
                L.append(obj);
                L.append(')');
                throw new KotlinReflectionInternalError(L.toString());
            }
            return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default(caller, this.a.getDescriptor(), false, 2, null);
        }
    }

    public static final class b extends Lambda implements Function0<Caller<? extends Member>> {
        public final /* synthetic */ KFunctionImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KFunctionImpl kFunctionImpl) {
            super(0);
            this.a = kFunctionImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Caller<? extends Member> invoke() {
            Object obj;
            Caller caller;
            JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this.a.getDescriptor());
            Caller<? extends Member> caller2 = null;
            if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
                KDeclarationContainerImpl container = this.a.getContainer();
                JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature;
                String methodName = kotlinFunction.getMethodName();
                String methodDesc = kotlinFunction.getMethodDesc();
                Member member = this.a.getCaller().getMember();
                Intrinsics.checkNotNull(member);
                obj = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(member.getModifiers()));
            } else if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
                if (this.a.isAnnotationConstructor()) {
                    Class<?> jClass = this.a.getContainer().getJClass();
                    List<KParameter> parameters = this.a.getParameters();
                    ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = it.next().getName();
                        Intrinsics.checkNotNull(name);
                        arrayList.add(name);
                    }
                    return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
                }
                obj = this.a.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
            } else if (mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
                Class<?> jClass2 = this.a.getContainer().getJClass();
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(methods, 10));
                for (T t : methods) {
                    Intrinsics.checkNotNullExpressionValue(t, "it");
                    arrayList2.add(t.getName());
                }
                return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, methods);
            } else {
                obj = null;
            }
            if (obj instanceof Constructor) {
                KFunctionImpl kFunctionImpl = this.a;
                caller = KFunctionImpl.access$createConstructorCaller(kFunctionImpl, (Constructor) obj, kFunctionImpl.getDescriptor());
            } else if (obj instanceof Method) {
                if (this.a.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) != null) {
                    DeclarationDescriptor containingDeclaration = this.a.getDescriptor().getContainingDeclaration();
                    Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    if (!((ClassDescriptor) containingDeclaration).isCompanionObject()) {
                        caller = KFunctionImpl.access$createJvmStaticInObjectCaller(this.a, (Method) obj);
                    }
                }
                caller = KFunctionImpl.access$createStaticMethodCaller(this.a, (Method) obj);
            } else {
                caller = null;
            }
            if (caller != null) {
                caller2 = InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded(caller, this.a.getDescriptor(), true);
            }
            return caller2;
        }
    }

    public static final class c extends Lambda implements Function0<FunctionDescriptor> {
        public final /* synthetic */ KFunctionImpl a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KFunctionImpl kFunctionImpl, String str) {
            super(0);
            this.a = kFunctionImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public FunctionDescriptor invoke() {
            return this.a.getContainer().findFunctionDescriptor(this.b, this.a.i);
        }
    }

    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj) {
        this.h = kDeclarationContainerImpl;
        this.i = str2;
        this.j = obj;
        this.e = ReflectProperties.lazySoft(functionDescriptor, new c(this, str));
        this.f = ReflectProperties.lazy(new a(this));
        this.g = ReflectProperties.lazy(new b(this));
    }

    public static final CallerImpl access$createConstructorCaller(KFunctionImpl kFunctionImpl, Constructor constructor, FunctionDescriptor functionDescriptor) {
        Objects.requireNonNull(kFunctionImpl);
        if (InlineClassManglingRulesKt.shouldHideConstructorDueToInlineClassTypeValueParameters(functionDescriptor)) {
            if (kFunctionImpl.isBound()) {
                return new CallerImpl.AccessorForHiddenBoundConstructor(constructor, kFunctionImpl.getBoundReceiver());
            }
            return new CallerImpl.AccessorForHiddenConstructor(constructor);
        } else if (kFunctionImpl.isBound()) {
            return new CallerImpl.BoundConstructor(constructor, kFunctionImpl.getBoundReceiver());
        } else {
            return new CallerImpl.Constructor(constructor);
        }
    }

    public static final CallerImpl.Method access$createInstanceMethodCaller(KFunctionImpl kFunctionImpl, Method method) {
        return kFunctionImpl.isBound() ? new CallerImpl.Method.BoundInstance(method, kFunctionImpl.getBoundReceiver()) : new CallerImpl.Method.Instance(method);
    }

    public static final CallerImpl.Method access$createJvmStaticInObjectCaller(KFunctionImpl kFunctionImpl, Method method) {
        return kFunctionImpl.isBound() ? new CallerImpl.Method.BoundJvmStaticInObject(method) : new CallerImpl.Method.JvmStaticInObject(method);
    }

    public static final CallerImpl.Method access$createStaticMethodCaller(KFunctionImpl kFunctionImpl, Method method) {
        return kFunctionImpl.isBound() ? new CallerImpl.Method.BoundStatic(method, kFunctionImpl.getBoundReceiver()) : new CallerImpl.Method.Static(method);
    }

    public boolean equals(@Nullable Object obj) {
        KFunctionImpl asKFunctionImpl = UtilKt.asKFunctionImpl(obj);
        if (asKFunctionImpl == null || !Intrinsics.areEqual(getContainer(), asKFunctionImpl.getContainer()) || !Intrinsics.areEqual(getName(), asKFunctionImpl.getName()) || !Intrinsics.areEqual(this.i, asKFunctionImpl.i) || !Intrinsics.areEqual(this.j, asKFunctionImpl.j)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return CallerKt.getArity(getCaller());
    }

    public final Object getBoundReceiver() {
        return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.j, getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public Caller<?> getCaller() {
        return (Caller) this.f.getValue(this, k[1]);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public KDeclarationContainerImpl getContainer() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @Nullable
    public Caller<?> getDefaultCaller() {
        return (Caller) this.g.getValue(this, k[2]);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public FunctionDescriptor getDescriptor() {
        return (FunctionDescriptor) this.e.getValue(this, k[0]);
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public String getName() {
        String asString = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "descriptor.name.asString()");
        return asString;
    }

    public int hashCode() {
        int hashCode = getName().hashCode();
        return this.i.hashCode() + ((hashCode + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public Object invoke() {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return !Intrinsics.areEqual(this.j, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(getDescriptor());
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public Object invoke(@Nullable Object obj) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, SessionContract.SIGNATURE);
    }

    @Override // kotlin.jvm.functions.Function4
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KFunctionImpl(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r9) {
        /*
            r7 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r9.getName()
            java.lang.String r3 = r0.asString()
            java.lang.String r0 = "descriptor.name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            kotlin.reflect.jvm.internal.JvmFunctionSignature r0 = r0.mapSignature(r9)
            java.lang.String r4 = r0.asString()
            java.lang.Object r6 = kotlin.jvm.internal.CallableReference.NO_RECEIVER
            r1 = r7
            r2 = r8
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KFunctionImpl.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):void");
    }

    @Override // kotlin.jvm.functions.Function5
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.jvm.functions.Function9
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.jvm.functions.Function10
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function18
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // kotlin.jvm.functions.Function19
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // kotlin.jvm.functions.Function20
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // kotlin.jvm.functions.Function21
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // kotlin.jvm.functions.Function22
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21, @Nullable Object obj22) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
