package kotlin.reflect.full;

import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0003\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0004\u001a-\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\f\u0010\u000b\u001a#\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0007¢\u0006\u0004\b\r\u0010\u000e\".\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\".\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012\"&\u0010\u001b\u001a\u0004\u0018\u00010\u0007*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0019\u0010\u000e\"@\u0010\u001f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u001c0\u000f\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001d\u0010\u0012\"D\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030 0\u000f\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0014\u001a\u0004\b!\u0010\u0012\".\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010\u0012\".\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0014\u001a\u0004\b(\u0010\u0012\".\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0014\u001a\u0004\b+\u0010\u0012\"D\u00100\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030 0\u000f\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0014\u001a\u0004\b.\u0010\u0012\".\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0014\u001a\u0004\b1\u0010\u0012\".\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0014\u001a\u0004\b4\u0010\u0012\"@\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u001c0\u000f\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0014\u001a\u0004\b7\u0010\u0012\".\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b:\u0010\u0012\"$\u0010A\u001a\u00020=*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0014\u001a\u0004\b>\u0010?\".\u0010F\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000B*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0014\u001a\u0004\bC\u0010D\"8\u0010J\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\bI\u0010\u0014\u001a\u0004\bG\u0010H\"*\u0010N\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\bM\u0010\u0014\u001a\u0004\bK\u0010L\"\u001e\u0010R\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030O8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bP\u0010Q\"*\u0010U\u001a\b\u0012\u0004\u0012\u00020=0\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\bT\u0010\u0014\u001a\u0004\bS\u0010\u0012\"\u001e\u0010W\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030O8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bV\u0010Q\".\u0010Z\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\bY\u0010\u0014\u001a\u0004\bX\u0010\u0012\".\u0010^\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030[0\u000f*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b]\u0010\u0014\u001a\u0004\b\\\u0010\u0012¨\u0006_"}, d2 = {"Lkotlin/reflect/KClass;", "base", "", "isSubclassOf", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)Z", "derived", "isSuperclassOf", "", "T", "value", "cast", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "createInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "", "Lkotlin/reflect/KFunction;", "getFunctions", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "getFunctions$annotations", "(Lkotlin/reflect/KClass;)V", "functions", "getMemberFunctions", "getMemberFunctions$annotations", "memberFunctions", "getCompanionObjectInstance", "getCompanionObjectInstance$annotations", "companionObjectInstance", "Lkotlin/reflect/KProperty1;", "getMemberProperties", "getMemberProperties$annotations", "memberProperties", "Lkotlin/reflect/KProperty2;", "getDeclaredMemberExtensionProperties", "getDeclaredMemberExtensionProperties$annotations", "declaredMemberExtensionProperties", "getDeclaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "declaredMemberExtensionFunctions", "Lkotlin/reflect/KCallable;", "getDeclaredMembers", "getDeclaredMembers$annotations", "declaredMembers", "getStaticFunctions", "getStaticFunctions$annotations", "staticFunctions", "getMemberExtensionProperties", "getMemberExtensionProperties$annotations", "memberExtensionProperties", "getDeclaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "declaredMemberFunctions", "getMemberExtensionFunctions", "getMemberExtensionFunctions$annotations", "memberExtensionFunctions", "getDeclaredMemberProperties", "getDeclaredMemberProperties$annotations", "declaredMemberProperties", "getDeclaredFunctions", "getDeclaredFunctions$annotations", "declaredFunctions", "Lkotlin/reflect/KType;", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "getDefaultType$annotations", "defaultType", "", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "getSuperclasses$annotations", "superclasses", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "getPrimaryConstructor$annotations", "primaryConstructor", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "getCompanionObject$annotations", "companionObject", "Lkotlin/reflect/jvm/internal/KCallableImpl;", AuthSource.BOOKING_ORDER, "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "getAllSupertypes", "getAllSupertypes$annotations", "allSupertypes", AuthSource.SEND_ABUSE, "isExtension", "getAllSuperclasses", "getAllSuperclasses$annotations", "allSuperclasses", "Lkotlin/reflect/KProperty0;", "getStaticProperties", "getStaticProperties$annotations", "staticProperties", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "KClasses")
public final class KClasses {

    public static final class a<N> implements DFS.Neighbors<KType> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Iterable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
        public Iterable<? extends KType> getNeighbors(KType kType) {
            KType kType2 = kType;
            KClassifier classifier = kType2.getClassifier();
            if (!(classifier instanceof KClass)) {
                classifier = null;
            }
            KClass kClass = (KClass) classifier;
            if (kClass != null) {
                List<KType> supertypes = kClass.getSupertypes();
                if (kType2.getArguments().isEmpty()) {
                    return supertypes;
                }
                TypeSubstitutor create = TypeSubstitutor.create(((KTypeImpl) kType2).getType());
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(supertypes, 10));
                for (T t : supertypes) {
                    Objects.requireNonNull(t, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                    KotlinType substitute = create.substitute(t.getType(), Variance.INVARIANT);
                    if (substitute != null) {
                        Intrinsics.checkNotNullExpressionValue(substitute, "substitutor.substitute((…: $supertype ($current)\")");
                        arrayList.add(new KTypeImpl(substitute, null, 2, null));
                    } else {
                        throw new KotlinReflectionInternalError("Type substitution failed: " + ((Object) t) + " (" + kType2 + ')');
                    }
                }
                return arrayList;
            }
            throw new KotlinReflectionInternalError("Supertype not a class: " + kType2);
        }
    }

    public static final class b extends Lambda implements Function0<Type> {
        public final /* synthetic */ KClass a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KClass kClass) {
            super(0);
            this.a = kClass;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Type invoke() {
            return ((KClassImpl) this.a).getJClass();
        }
    }

    public static final class c extends Lambda implements Function1<KClass<?>, Boolean> {
        public final /* synthetic */ KClass a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KClass kClass) {
            super(1);
            this.a = kClass;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(KClass<?> kClass) {
            return Boolean.valueOf(Intrinsics.areEqual(kClass, this.a));
        }
    }

    public static final boolean a(KCallableImpl<?> kCallableImpl) {
        return kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null;
    }

    public static final boolean b(KCallableImpl<?> kCallableImpl) {
        return !a(kCallableImpl);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> T cast(@NotNull KClass<T> kClass, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "$this$cast");
        if (kClass.isInstance(obj)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type T");
            return obj;
        }
        StringBuilder L = a2.b.a.a.a.L("Value cannot be cast to ");
        L.append(kClass.getQualifiedName());
        throw new TypeCastException(L.toString());
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> T createInstance(@NotNull KClass<T> kClass) {
        boolean z;
        Intrinsics.checkNotNullParameter(kClass, "$this$createInstance");
        Iterator<T> it = kClass.getConstructors().iterator();
        T t = null;
        T t2 = null;
        boolean z2 = false;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                List<KParameter> parameters = next.getParameters();
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    Iterator<T> it2 = parameters.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!it2.next().isOptional()) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    if (z2) {
                        break;
                    }
                    t2 = next;
                    z2 = true;
                }
            } else if (z2) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 != null) {
            return (T) t3.callBy(r.emptyMap());
        }
        throw new IllegalArgumentException("Class should have a single no-arg constructor: " + kClass);
    }

    @NotNull
    public static final Collection<KClass<?>> getAllSuperclasses(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$allSuperclasses");
        Collection<KType> allSupertypes = getAllSupertypes(kClass);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(allSupertypes, 10));
        for (T t : allSupertypes) {
            KClassifier classifier = t.getClassifier();
            if (!(classifier instanceof KClass)) {
                classifier = null;
            }
            KClass kClass2 = (KClass) classifier;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            } else {
                throw new KotlinReflectionInternalError("Supertype not a class: " + ((Object) t));
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getAllSuperclasses$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KType> getAllSupertypes(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$allSupertypes");
        Object dfs = DFS.dfs(kClass.getSupertypes(), a.a, new DFS.VisitedWithSet(), new DFS.NodeHandlerWithListResult<KType, KType>() { // from class: kotlin.reflect.full.KClasses$allSupertypes$2
            public boolean beforeChildren(@NotNull KType kType) {
                Intrinsics.checkNotNullParameter(kType, "current");
                ((LinkedList) this.result).add(kType);
                return true;
            }
        });
        Intrinsics.checkNotNullExpressionValue(dfs, "DFS.dfs(\n            sup…    }\n            }\n    )");
        return (Collection) dfs;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getAllSupertypes$annotations(KClass kClass) {
    }

    @Nullable
    public static final KClass<?> getCompanionObject(@NotNull KClass<?> kClass) {
        T t;
        Intrinsics.checkNotNullParameter(kClass, "$this$companionObject");
        Iterator<T> it = kClass.getNestedClasses().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            T t2 = t;
            Objects.requireNonNull(t2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            if (t2.getDescriptor().isCompanionObject()) {
                break;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getCompanionObject$annotations(KClass kClass) {
    }

    @Nullable
    public static final Object getCompanionObjectInstance(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$companionObjectInstance");
        KClass<?> companionObject = getCompanionObject(kClass);
        if (companionObject != null) {
            return companionObject.getObjectInstance();
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getCompanionObjectInstance$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$declaredFunctions");
        Collection<KCallableImpl<?>> declaredMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : declaredMembers) {
            if (t instanceof KFunction) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$declaredMemberExtensionFunctions");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : declaredNonStaticMembers) {
            T t2 = t;
            if (a(t2) && (t2 instanceof KFunction)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$declaredMemberExtensionProperties");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : declaredNonStaticMembers) {
            T t2 = t;
            if (a(t2) && (t2 instanceof KProperty2)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$declaredMemberFunctions");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : declaredNonStaticMembers) {
            T t2 = t;
            if (b(t2) && (t2 instanceof KFunction)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$declaredMemberProperties");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : declaredNonStaticMembers) {
            T t2 = t;
            if (b(t2) && (t2 instanceof KProperty1)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KCallable<?>> getDeclaredMembers(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$declaredMembers");
        return ((KClassImpl) kClass).getData().invoke().getDeclaredMembers();
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMembers$annotations(KClass kClass) {
    }

    @NotNull
    public static final KType getDefaultType(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$defaultType");
        SimpleType defaultType = ((KClassImpl) kClass).getDescriptor().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "(this as KClassImpl<*>).descriptor.defaultType");
        return new KTypeImpl(defaultType, new b(kClass));
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDefaultType$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$functions");
        Collection<KCallable<?>> members = kClass.getMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : members) {
            if (t instanceof KFunction) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getMemberExtensionFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$memberExtensionFunctions");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allNonStaticMembers) {
            T t2 = t;
            if (a(t2) && (t2 instanceof KFunction)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberExtensionFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$memberExtensionProperties");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allNonStaticMembers) {
            T t2 = t;
            if (a(t2) && (t2 instanceof KProperty2)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberExtensionProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getMemberFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$memberFunctions");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allNonStaticMembers) {
            T t2 = t;
            if (b(t2) && (t2 instanceof KFunction)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$memberProperties");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allNonStaticMembers) {
            T t2 = t;
            if (b(t2) && (t2 instanceof KProperty1)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberProperties$annotations(KClass kClass) {
    }

    @Nullable
    public static final <T> KFunction<T> getPrimaryConstructor(@NotNull KClass<T> kClass) {
        T t;
        Intrinsics.checkNotNullParameter(kClass, "$this$primaryConstructor");
        Iterator<T> it = ((KClassImpl) kClass).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            T t2 = t;
            Objects.requireNonNull(t2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
            FunctionDescriptor descriptor = t2.getDescriptor();
            Objects.requireNonNull(descriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
            if (((ConstructorDescriptor) descriptor).isPrimary()) {
                break;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getPrimaryConstructor$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getStaticFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$staticFunctions");
        Collection<KCallableImpl<?>> allStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allStaticMembers) {
            if (t instanceof KFunction) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStaticFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KProperty0<?>> getStaticProperties(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$staticProperties");
        Collection<KCallableImpl<?>> allStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allStaticMembers) {
            T t2 = t;
            if (b(t2) && (t2 instanceof KProperty0)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStaticProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final List<KClass<?>> getSuperclasses(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$superclasses");
        List<KType> supertypes = kClass.getSupertypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            KClassifier classifier = it.next().getClassifier();
            if (!(classifier instanceof KClass)) {
                classifier = null;
            }
            KClass kClass2 = (KClass) classifier;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getSuperclasses$annotations(KClass kClass) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [t6.w.e.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.1")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isSubclassOf(@org.jetbrains.annotations.NotNull kotlin.reflect.KClass<?> r2, @org.jetbrains.annotations.NotNull kotlin.reflect.KClass<?> r3) {
        /*
            java.lang.String r0 = "$this$isSubclassOf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "base"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r0 != 0) goto L_0x0037
            java.util.List r2 = t6.n.d.listOf(r2)
            kotlin.reflect.KProperty1 r0 = t6.w.e.a.a
            if (r0 == 0) goto L_0x001e
            t6.w.e.b r1 = new t6.w.e.b
            r1.<init>(r0)
            r0 = r1
        L_0x001e:
            kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors r0 = (kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors) r0
            kotlin.reflect.full.KClasses$c r1 = new kotlin.reflect.full.KClasses$c
            r1.<init>(r3)
            java.lang.Boolean r2 = kotlin.reflect.jvm.internal.impl.utils.DFS.ifAny(r2, r0, r1)
            java.lang.String r3 = "DFS.ifAny(listOf(this), …erclasses) { it == base }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r2 = 0
            goto L_0x0038
        L_0x0037:
            r2 = 1
        L_0x0038:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KClasses.isSubclassOf(kotlin.reflect.KClass, kotlin.reflect.KClass):boolean");
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSuperclassOf(@NotNull KClass<?> kClass, @NotNull KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(kClass, "$this$isSuperclassOf");
        Intrinsics.checkNotNullParameter(kClass2, "derived");
        return isSubclassOf(kClass2, kClass);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final <T> T safeCast(@NotNull KClass<T> kClass, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "$this$safeCast");
        if (!kClass.isInstance(obj)) {
            return null;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type T");
        return obj;
    }
}
