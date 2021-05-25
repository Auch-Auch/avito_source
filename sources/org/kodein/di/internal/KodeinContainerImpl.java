package org.kodein.di.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.BindingsMapKt;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.KodeinContainer;
import org.kodein.di.KodeinContext;
import org.kodein.di.KodeinDefinition;
import org.kodein.di.KodeinTree;
import org.kodein.di.SearchSpecs;
import org.kodein.di.TypeToken;
import org.kodein.di.bindings.BindingKodein;
import org.kodein.di.bindings.ContextTranslator;
import org.kodein.di.bindings.ExternalSource;
import org.kodein.di.bindings.ScopesKt;
import t6.n.e;
import t6.n.q;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0019B#\b\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b+\u0010,B/\b\u0010\u0012\u0006\u0010.\u001a\u00020-\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u00101\u001a\u00020\u001c¢\u0006\u0004\b+\u00102J]\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ[\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJa\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b0\u000f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011Jc\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0014\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R4\u0010*\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010)¨\u00063"}, d2 = {"Lorg/kodein/di/internal/KodeinContainerImpl;", "Lorg/kodein/di/KodeinContainer;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/Kodein$Key;", "key", "context", "", "overrideLevel", "Lkotlin/Function1;", "factoryOrNull", "(Lorg/kodein/di/Kodein$Key;Ljava/lang/Object;I)Lkotlin/jvm/functions/Function1;", "factory", "", "allFactories", "(Lorg/kodein/di/Kodein$Key;Ljava/lang/Object;I)Ljava/util/List;", "Lorg/kodein/di/KodeinContext;", "Lorg/kodein/di/KodeinTree;", "tree", "Lorg/kodein/di/bindings/BindingKodein;", AuthSource.SEND_ABUSE, "(Lorg/kodein/di/Kodein$Key;Lorg/kodein/di/KodeinContext;Lorg/kodein/di/KodeinTree;I)Lorg/kodein/di/bindings/BindingKodein;", "Lorg/kodein/di/internal/KodeinContainerImpl$c;", "c", "Lorg/kodein/di/internal/KodeinContainerImpl$c;", "node", "", "d", "Z", "fullDescriptionOnError", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/KodeinTree;", "getTree", "()Lorg/kodein/di/KodeinTree;", "Lkotlin/Function0;", "", "<set-?>", "Lkotlin/jvm/functions/Function0;", "getInitCallbacks", "()Lkotlin/jvm/functions/Function0;", "initCallbacks", "<init>", "(Lorg/kodein/di/KodeinTree;Lorg/kodein/di/internal/KodeinContainerImpl$c;Z)V", "Lorg/kodein/di/internal/KodeinContainerBuilderImpl;", "builder", "Lorg/kodein/di/bindings/ExternalSource;", "externalSources", "runCallbacks", "(Lorg/kodein/di/internal/KodeinContainerBuilderImpl;Ljava/util/List;ZZ)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class KodeinContainerImpl implements KodeinContainer {
    @Nullable
    public volatile Function0<Unit> a;
    @NotNull
    public final KodeinTree b;
    public final c c;
    public final boolean d;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function2<Map<Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>>, Boolean, String> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(2);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final String invoke(Map<Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>> map, Boolean bool) {
            int i = this.a;
            if (i == 0) {
                Map<Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>> map2 = map;
                boolean booleanValue = bool.booleanValue();
                Intrinsics.checkParameterIsNotNull(map2, "$receiver");
                return BindingsMapKt.fullDescription$default(map2, booleanValue, 0, 2, null);
            } else if (i == 1) {
                Map<Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>> map3 = map;
                boolean booleanValue2 = bool.booleanValue();
                Intrinsics.checkParameterIsNotNull(map3, "$receiver");
                return BindingsMapKt.description$default(map3, booleanValue2, 0, 2, null);
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ KodeinContainerImpl a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Function0 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KodeinContainerImpl kodeinContainerImpl, Object obj, Function0 function0) {
            super(0);
            this.a = kodeinContainerImpl;
            this.b = obj;
            this.c = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Object obj = this.b;
            KodeinContainerImpl kodeinContainerImpl = this.a;
            if (kodeinContainerImpl.getInitCallbacks() != null) {
                if (obj != null) {
                    synchronized (obj) {
                        if (kodeinContainerImpl.getInitCallbacks() != null) {
                            this.a.a = null;
                            this.c.invoke();
                        }
                    }
                } else if (kodeinContainerImpl.getInitCallbacks() != null) {
                    this.a.a = null;
                    this.c.invoke();
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c {
        public final Kodein.Key<?, ?, ?> a;
        public final int b;
        public final c c;
        public final boolean d;

        public c(@NotNull Kodein.Key<?, ?, ?> key, int i, @Nullable c cVar, boolean z) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            this.a = key;
            this.b = i;
            this.c = cVar;
            this.d = z;
        }

        public final void a(@NotNull Kodein.Key<?, ?, ?> key, int i) {
            int i2;
            boolean z;
            Intrinsics.checkParameterIsNotNull(key, "searchedKey");
            c cVar = this;
            while (true) {
                i2 = 0;
                if (Intrinsics.areEqual(cVar.a, key) && cVar.b == i) {
                    z = false;
                    break;
                }
                cVar = cVar.c;
                if (cVar == null) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                List emptyList = CollectionsKt__CollectionsKt.emptyList();
                c cVar2 = this;
                while (cVar2.c != null && (!Intrinsics.areEqual(key, cVar2.a) || i != cVar2.b)) {
                    c cVar3 = cVar2.c;
                    emptyList = CollectionsKt___CollectionsKt.plus((Collection) t6.n.d.listOf(b(cVar2.a, cVar2.b)), (Iterable) emptyList);
                    cVar2 = cVar3;
                }
                List plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) CollectionsKt___CollectionsKt.plus((Collection) t6.n.d.listOf(b(cVar2.a, cVar2.b)), (Iterable) emptyList), b(key, this.b));
                StringBuilder sb = new StringBuilder();
                for (Object obj : plus) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    String str = (String) obj;
                    sb.append("  ");
                    if (i2 == 0) {
                        sb.append("   ");
                    } else if (i2 != 1) {
                        sb.append("  ║");
                        sb.append(m.repeat("  ", i2 - 1));
                        sb.append("╚>");
                    } else {
                        sb.append("  ╔╩>");
                    }
                    sb.append(str);
                    sb.append("\n");
                    i2 = i3;
                }
                sb.append("    ╚");
                sb.append(m.repeat("══", plus.size() - 1));
                sb.append("╝");
                throw new Kodein.DependencyLoopException("Dependency recursion:\n" + ((Object) sb));
            }
        }

        public final String b(Kodein.Key<?, ?, ?> key, int i) {
            KProperty0 aVar = this.d ? new x6.d.a.o.a(key) : new x6.d.a.o.b(key);
            if (i == 0) {
                return (String) aVar.get();
            }
            StringBuilder L = a2.b.a.a.a.L("overridden ");
            L.append((String) aVar.get());
            return L.toString();
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ KodeinContainerImpl a;
        public final /* synthetic */ KodeinContainerBuilderImpl b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KodeinContainerImpl kodeinContainerImpl, KodeinContainerBuilderImpl kodeinContainerBuilderImpl) {
            super(0);
            this.a = kodeinContainerImpl;
            this.b = kodeinContainerBuilderImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DKodeinImpl dKodeinImpl = new DKodeinImpl(this.a, KodeinAwareKt.getAnyKodeinContext());
            Iterator<T> it = this.b.getCallbacks$kodein_di_core().iterator();
            while (it.hasNext()) {
                it.next().invoke(dKodeinImpl);
            }
            return Unit.INSTANCE;
        }
    }

    public KodeinContainerImpl(KodeinTree kodeinTree, c cVar, boolean z) {
        this.b = kodeinTree;
        this.c = cVar;
        this.d = z;
    }

    public final <C, A, T> BindingKodein<C> a(Kodein.Key<? super C, ? super A, ? extends T> key, KodeinContext<C> kodeinContext, KodeinTree kodeinTree, int i) {
        return new BindingKodeinImpl(new DKodeinImpl(new KodeinContainerImpl(kodeinTree, new c(key, i, this.c, this.d), this.d), kodeinContext), key, kodeinContext.getValue(), i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: org.kodein.di.KodeinContext$Companion */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.kodein.di.KodeinContainer
    @NotNull
    public <C, A, T> List<Function1<A, T>> allFactories(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key, C c2, int i) {
        KodeinContext<C> kodeinContext;
        Intrinsics.checkParameterIsNotNull(key, "key");
        List<Triple<Kodein.Key<Object, A, T>, KodeinDefinition<Object, A, T>, ContextTranslator<C, Object>>> find = getTree().find(key, i, true);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(find, 10));
        for (T t : find) {
            KodeinDefinition kodeinDefinition = (KodeinDefinition) t.component2();
            ContextTranslator contextTranslator = (ContextTranslator) t.component3();
            c cVar = this.c;
            if (cVar != null) {
                cVar.a(key, i);
            }
            if ((contextTranslator == null || (kodeinContext = ScopesKt.toKContext(contextTranslator, c2)) == null) && (kodeinContext = KodeinContext.Companion.invoke((TypeToken<? super TypeToken<? super Object>>) key.getContextType(), (TypeToken<? super Object>) c2)) == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.KodeinContext<kotlin.Any>");
            }
            arrayList.add(kodeinDefinition.getBinding().getFactory(a(key, kodeinContext, kodeinDefinition.getTree(), i), key));
        }
        return arrayList;
    }

    @Override // org.kodein.di.KodeinContainer
    @NotNull
    public <C, T> List<Function0<T>> allProviders(@NotNull Kodein.Key<? super C, ? super Unit, ? extends T> key, C c2, int i) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return KodeinContainer.DefaultImpls.allProviders(this, key, c2, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: org.kodein.di.KodeinContext$Companion */
    /* JADX DEBUG: Multi-variable search result rejected for r1v21, resolved type: org.kodein.di.KodeinContext$Companion */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.kodein.di.KodeinContainer
    @NotNull
    public <C, A, T> Function1<A, T> factory(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key, C c2, int i) {
        KodeinContext<C> kodeinContext;
        Intrinsics.checkParameterIsNotNull(key, "key");
        boolean z = false;
        List find$default = KodeinTree.DefaultImpls.find$default(getTree(), key, i, false, 4, null);
        if (find$default.size() == 1) {
            Triple triple = (Triple) find$default.get(0);
            KodeinDefinition kodeinDefinition = (KodeinDefinition) triple.component2();
            ContextTranslator contextTranslator = (ContextTranslator) triple.component3();
            c cVar = this.c;
            if (cVar != null) {
                cVar.a(key, i);
            }
            if (!((contextTranslator == null || (kodeinContext = ScopesKt.toKContext(contextTranslator, c2)) == null) && (kodeinContext = KodeinContext.Companion.invoke((TypeToken<? super TypeToken<? super Object>>) key.getContextType(), (TypeToken<? super Object>) c2)) == null)) {
                return kodeinDefinition.getBinding().getFactory(a(key, kodeinContext, kodeinDefinition.getTree(), i), key);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.KodeinContext<kotlin.Any>");
        }
        BindingKodein<?> a3 = a(key, KodeinContext.Companion.invoke((TypeToken<? super TypeToken<? super Object>>) key.getContextType(), (TypeToken<? super Object>) c2), getTree(), i);
        Iterator<T> it = getTree().getExternalSources().iterator();
        while (it.hasNext()) {
            Function1<Object, Object> factory = it.next().getFactory(a3, key);
            if (factory != null) {
                c cVar2 = this.c;
                if (cVar2 != null) {
                    cVar2.a(key, i);
                }
                return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(factory, 1);
            }
        }
        if (i != 0) {
            z = true;
        }
        KProperty0 cVar3 = this.d ? new PropertyReference0(key) { // from class: x6.d.a.o.c
            @Override // kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return ((Kodein.Key) this.receiver).getFullDescription();
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return "fullDescription";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(Kodein.Key.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFullDescription()Ljava/lang/String;";
            }
        } : new PropertyReference0(key) { // from class: x6.d.a.o.d
            @Override // kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return ((Kodein.Key) this.receiver).getDescription();
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return "description";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(Kodein.Key.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getDescription()Ljava/lang/String;";
            }
        };
        a aVar = this.d ? a.b : a.c;
        if (find$default.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder L = a2.b.a.a.a.L("No binding found for ");
            L.append((String) cVar3.get());
            L.append('\n');
            sb.append(L.toString());
            List<Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>>> find = getTree().find(new SearchSpecs(null, null, key.getType(), null, 11, null));
            if (true ^ find.isEmpty()) {
                StringBuilder L2 = a2.b.a.a.a.L("Available bindings for this type:\n");
                LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(e.collectionSizeOrDefault(find, 10)), 16));
                for (T t : find) {
                    Pair pair = TuplesKt.to(t.getFirst(), t.getSecond());
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                L2.append((String) aVar.invoke(linkedHashMap, Boolean.valueOf(z)));
                sb.append(L2.toString());
            }
            StringBuilder L3 = a2.b.a.a.a.L("Registered in this Kodein container:\n");
            L3.append((String) aVar.invoke(getTree().getBindings(), Boolean.valueOf(z)));
            sb.append(L3.toString());
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
            throw new Kodein.NotFoundException(key, sb2);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(e.collectionSizeOrDefault(find$default, 10)), 16));
        for (T t2 : find$default) {
            Object first = t2.getFirst();
            Triple<Kodein.Key<Object, A, T>, List<KodeinDefinition<Object, A, T>>, ContextTranslator<C, Object>> triple2 = getTree().get((Kodein.Key) t2.getFirst());
            if (triple2 == null) {
                Intrinsics.throwNpe();
            }
            Pair pair2 = TuplesKt.to(first, triple2.getSecond());
            linkedHashMap2.put(pair2.getFirst(), pair2.getSecond());
        }
        Map<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>> bindings = getTree().getBindings();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>> entry : bindings.entrySet()) {
            if (!linkedHashMap2.keySet().contains(entry.getKey())) {
                linkedHashMap3.put(entry.getKey(), entry.getValue());
            }
        }
        throw new Kodein.NotFoundException(key, linkedHashMap2.size() + " bindings found that match " + key + ":\n" + ((String) aVar.invoke(linkedHashMap2, Boolean.valueOf(z))) + "Other bindings registered in Kodein:\n" + ((String) aVar.invoke(linkedHashMap3, Boolean.valueOf(z))));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: org.kodein.di.KodeinContext$Companion */
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: org.kodein.di.KodeinContext$Companion */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.kodein.di.KodeinContainer
    @Nullable
    public <C, A, T> Function1<A, T> factoryOrNull(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key, C c2, int i) {
        KodeinContext<C> kodeinContext;
        Intrinsics.checkParameterIsNotNull(key, "key");
        List find$default = KodeinTree.DefaultImpls.find$default(getTree(), key, 0, false, 4, null);
        if (find$default.size() == 1) {
            Triple triple = (Triple) find$default.get(0);
            KodeinDefinition kodeinDefinition = (KodeinDefinition) triple.component2();
            ContextTranslator contextTranslator = (ContextTranslator) triple.component3();
            c cVar = this.c;
            if (cVar != null) {
                cVar.a(key, 0);
            }
            if ((contextTranslator != null && (kodeinContext = ScopesKt.toKContext(contextTranslator, c2)) != null) || (kodeinContext = KodeinContext.Companion.invoke((TypeToken<? super TypeToken<? super Object>>) key.getContextType(), (TypeToken<? super Object>) c2)) != null) {
                return kodeinDefinition.getBinding().getFactory(a(key, kodeinContext, kodeinDefinition.getTree(), i), key);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.KodeinContext<kotlin.Any>");
        }
        BindingKodein<?> a3 = a(key, KodeinContext.Companion.invoke((TypeToken<? super TypeToken<? super Object>>) key.getContextType(), (TypeToken<? super Object>) c2), getTree(), i);
        Iterator<T> it = getTree().getExternalSources().iterator();
        while (it.hasNext()) {
            Function1<Object, Object> factory = it.next().getFactory(a3, key);
            if (factory != null) {
                c cVar2 = this.c;
                if (cVar2 != null) {
                    cVar2.a(key, 0);
                }
                return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(factory, 1);
            }
        }
        return null;
    }

    @Nullable
    public final Function0<Unit> getInitCallbacks() {
        return this.a;
    }

    @Override // org.kodein.di.KodeinContainer
    @NotNull
    public KodeinTree getTree() {
        return this.b;
    }

    @Override // org.kodein.di.KodeinContainer
    @NotNull
    public <C, T> Function0<T> provider(@NotNull Kodein.Key<? super C, ? super Unit, ? extends T> key, C c2, int i) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return KodeinContainer.DefaultImpls.provider(this, key, c2, i);
    }

    @Override // org.kodein.di.KodeinContainer
    @Nullable
    public <C, T> Function0<T> providerOrNull(@NotNull Kodein.Key<? super C, ? super Unit, ? extends T> key, C c2, int i) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return KodeinContainer.DefaultImpls.providerOrNull(this, key, c2, i);
    }

    public KodeinContainerImpl(@NotNull KodeinContainerBuilderImpl kodeinContainerBuilderImpl, @NotNull List<? extends ExternalSource> list, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(kodeinContainerBuilderImpl, "builder");
        Intrinsics.checkParameterIsNotNull(list, "externalSources");
        this.b = new KodeinTreeImpl(kodeinContainerBuilderImpl.getBindingsMap$kodein_di_core(), list, kodeinContainerBuilderImpl.getTranslators$kodein_di_core());
        this.c = null;
        this.d = z;
        d dVar = new d(this, kodeinContainerBuilderImpl);
        if (z2) {
            dVar.invoke();
        } else {
            this.a = new b(this, new Object(), dVar);
        }
    }
}
