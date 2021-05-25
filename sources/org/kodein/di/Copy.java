package org.kodein.di;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileTab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.SearchDSL;
import org.kodein.di.bindings.ContextTranslator;
import t6.n.e;
import t6.n.h;
import t6.n.q;
import t6.n.y;
import t6.n.z;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000 \b2\u00020\u0001:\u0007\t\n\u000b\b\f\r\u000eJ)\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lorg/kodein/di/Copy;", "", "Lorg/kodein/di/KodeinTree;", "tree", "", "Lorg/kodein/di/Kodein$Key;", "keySet", "(Lorg/kodein/di/KodeinTree;)Ljava/util/Set;", "Companion", "All", "AllButDSL", "BaseDSL", "DSL", "NonCached", "None", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface Copy {
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lorg/kodein/di/Copy$All;", "Lorg/kodein/di/Copy;", "Lorg/kodein/di/KodeinTree;", "tree", "", "Lorg/kodein/di/Kodein$Key;", "keySet", "(Lorg/kodein/di/KodeinTree;)Ljava/util/Set;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class All implements Copy {
        public static final All INSTANCE = new All();

        @Override // org.kodein.di.Copy
        @NotNull
        public Set<Kodein.Key<?, ?, ?>> keySet(@NotNull KodeinTree kodeinTree) {
            Intrinsics.checkParameterIsNotNull(kodeinTree, "tree");
            return kodeinTree.getBindings().keySet();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lorg/kodein/di/Copy$AllButDSL;", "Lorg/kodein/di/Copy$BaseDSL;", "Lorg/kodein/di/KodeinTree;", "tree", "", "Lorg/kodein/di/Kodein$Key;", "keySet", "(Lorg/kodein/di/KodeinTree;)Ljava/util/Set;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class AllButDSL extends BaseDSL {
        @Override // org.kodein.di.Copy
        @NotNull
        public Set<Kodein.Key<?, ?, ?>> keySet(@NotNull KodeinTree kodeinTree) {
            Intrinsics.checkParameterIsNotNull(kodeinTree, "tree");
            ArrayList<CopySpecs> copySpecs$kodein_di_core = getCopySpecs$kodein_di_core();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = copySpecs$kodein_di_core.iterator();
            while (it.hasNext()) {
                h.addAll(arrayList, Copy.Companion.specsToKeys$kodein_di_core(kodeinTree, it.next()));
            }
            ArrayList<CopySpecs> ignoreSpecs$kodein_di_core = getIgnoreSpecs$kodein_di_core();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = ignoreSpecs$kodein_di_core.iterator();
            while (it2.hasNext()) {
                h.addAll(arrayList2, Copy.Companion.specsToKeys$kodein_di_core(kodeinTree, it2.next()));
            }
            return z.minus((Set) kodeinTree.getBindings().keySet(), (Iterable) CollectionsKt___CollectionsKt.minus((Iterable) arrayList2, (Iterable) arrayList));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R,\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR,\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u001a"}, d2 = {"Lorg/kodein/di/Copy$BaseDSL;", "Lorg/kodein/di/SearchDSL;", "Lorg/kodein/di/Copy;", "Lorg/kodein/di/Copy$BaseDSL$Sentence;", "c", "Lorg/kodein/di/Copy$BaseDSL$Sentence;", "getCopy", "()Lorg/kodein/di/Copy$BaseDSL$Sentence;", "copy", "Ljava/util/ArrayList;", "Lorg/kodein/di/CopySpecs;", "Lkotlin/collections/ArrayList;", AuthSource.SEND_ABUSE, "Ljava/util/ArrayList;", "getCopySpecs$kodein_di_core", "()Ljava/util/ArrayList;", "copySpecs", AuthSource.BOOKING_ORDER, "getIgnoreSpecs$kodein_di_core", "ignoreSpecs", "d", "getIgnore", "ignore", "<init>", "()V", "Sentence", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static abstract class BaseDSL extends SearchDSL implements Copy {
        @NotNull
        public final ArrayList<CopySpecs> a;
        @NotNull
        public final ArrayList<CopySpecs> b;
        @NotNull
        public final Sentence c;
        @NotNull
        public final Sentence d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lorg/kodein/di/Copy$BaseDSL$Sentence;", "", "Lorg/kodein/di/SearchDSL$Binding;", "binding", "Lorg/kodein/di/SearchSpecs;", "the", "(Lorg/kodein/di/SearchDSL$Binding;)Lorg/kodein/di/SearchSpecs;", "Lorg/kodein/di/SearchDSL$Spec;", "spec", ProfileTab.ALL, "(Lorg/kodein/di/SearchDSL$Spec;)Lorg/kodein/di/SearchSpecs;", "", "Lorg/kodein/di/CopySpecs;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "specs", "<init>", "(Ljava/util/List;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
        public static final class Sentence {
            public final List<CopySpecs> a;

            public Sentence(@NotNull List<CopySpecs> list) {
                Intrinsics.checkParameterIsNotNull(list, "specs");
                this.a = list;
            }

            @NotNull
            public final SearchSpecs all(@NotNull SearchDSL.Spec spec) {
                Intrinsics.checkParameterIsNotNull(spec, "spec");
                CopySpecs copySpecs = new CopySpecs(true);
                spec.apply(copySpecs);
                this.a.add(copySpecs);
                return copySpecs;
            }

            @NotNull
            public final SearchSpecs the(@NotNull SearchDSL.Binding binding) {
                Intrinsics.checkParameterIsNotNull(binding, "binding");
                CopySpecs copySpecs = new CopySpecs(false);
                binding.apply(copySpecs);
                this.a.add(copySpecs);
                return copySpecs;
            }
        }

        public BaseDSL() {
            ArrayList<CopySpecs> arrayList = new ArrayList<>();
            this.a = arrayList;
            ArrayList<CopySpecs> arrayList2 = new ArrayList<>();
            this.b = arrayList2;
            this.c = new Sentence(arrayList);
            this.d = new Sentence(arrayList2);
        }

        @NotNull
        public final Sentence getCopy() {
            return this.c;
        }

        @NotNull
        public final ArrayList<CopySpecs> getCopySpecs$kodein_di_core() {
            return this.a;
        }

        @NotNull
        public final Sentence getIgnore() {
            return this.d;
        }

        @NotNull
        public final ArrayList<CopySpecs> getIgnoreSpecs$kodein_di_core() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0007\u001a\u00020\u00032\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\n\u001a\u00020\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00110\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lorg/kodein/di/Copy$Companion;", "", "Lkotlin/Function1;", "Lorg/kodein/di/Copy$DSL;", "", "Lkotlin/ExtensionFunctionType;", "f", "invoke", "(Lkotlin/jvm/functions/Function1;)Lorg/kodein/di/Copy$DSL;", "Lorg/kodein/di/Copy$AllButDSL;", "allBut", "(Lkotlin/jvm/functions/Function1;)Lorg/kodein/di/Copy$AllButDSL;", "Lorg/kodein/di/KodeinTree;", "tree", "Lorg/kodein/di/CopySpecs;", "it", "", "Lorg/kodein/di/Kodein$Key;", "specsToKeys$kodein_di_core", "(Lorg/kodein/di/KodeinTree;Lorg/kodein/di/CopySpecs;)Ljava/util/List;", "specsToKeys", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final AllButDSL allBut(@NotNull Function1<? super AllButDSL, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "f");
            AllButDSL allButDSL = new AllButDSL();
            function1.invoke(allButDSL);
            return allButDSL;
        }

        @NotNull
        public final DSL invoke(@NotNull Function1<? super DSL, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "f");
            DSL dsl = new DSL();
            function1.invoke(dsl);
            return dsl;
        }

        @NotNull
        public final List<Kodein.Key<?, ?, ?>> specsToKeys$kodein_di_core(@NotNull KodeinTree kodeinTree, @NotNull CopySpecs copySpecs) {
            Intrinsics.checkParameterIsNotNull(kodeinTree, "tree");
            Intrinsics.checkParameterIsNotNull(copySpecs, "it");
            List<Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>>> find = kodeinTree.find(copySpecs);
            if (find.isEmpty()) {
                throw new Kodein.NoResultException(copySpecs, "No binding found that match this search: " + copySpecs);
            } else if (copySpecs.getAll() || find.size() <= 1) {
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(find, 10));
                Iterator<T> it = find.iterator();
                while (it.hasNext()) {
                    arrayList.add((Kodein.Key) it.next().getFirst());
                }
                return arrayList;
            } else {
                StringBuilder L = a.L("There were ");
                L.append(find.size());
                L.append(" matches for this search: ");
                L.append(copySpecs);
                L.append('\n');
                LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(e.collectionSizeOrDefault(find, 10)), 16));
                for (T t : find) {
                    Pair pair = TuplesKt.to(t.getFirst(), t.getSecond());
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                L.append(BindingsMapKt.description$default(linkedHashMap, false, 0, 2, null));
                throw new Kodein.NoResultException(copySpecs, L.toString());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lorg/kodein/di/Copy$DSL;", "Lorg/kodein/di/Copy$BaseDSL;", "Lorg/kodein/di/KodeinTree;", "tree", "", "Lorg/kodein/di/Kodein$Key;", "keySet", "(Lorg/kodein/di/KodeinTree;)Ljava/util/Set;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class DSL extends BaseDSL {
        @Override // org.kodein.di.Copy
        @NotNull
        public Set<Kodein.Key<?, ?, ?>> keySet(@NotNull KodeinTree kodeinTree) {
            Intrinsics.checkParameterIsNotNull(kodeinTree, "tree");
            ArrayList<CopySpecs> ignoreSpecs$kodein_di_core = getIgnoreSpecs$kodein_di_core();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = ignoreSpecs$kodein_di_core.iterator();
            while (it.hasNext()) {
                h.addAll(arrayList, Copy.Companion.specsToKeys$kodein_di_core(kodeinTree, it.next()));
            }
            ArrayList<CopySpecs> copySpecs$kodein_di_core = getCopySpecs$kodein_di_core();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = copySpecs$kodein_di_core.iterator();
            while (it2.hasNext()) {
                h.addAll(arrayList2, Copy.Companion.specsToKeys$kodein_di_core(kodeinTree, it2.next()));
            }
            return CollectionsKt___CollectionsKt.toSet(CollectionsKt___CollectionsKt.minus((Iterable) arrayList2, (Iterable) arrayList));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lorg/kodein/di/Copy$NonCached;", "Lorg/kodein/di/Copy;", "Lorg/kodein/di/KodeinTree;", "tree", "", "Lorg/kodein/di/Kodein$Key;", "keySet", "(Lorg/kodein/di/KodeinTree;)Ljava/util/Set;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class NonCached implements Copy {
        public static final NonCached INSTANCE = new NonCached();

        @Override // org.kodein.di.Copy
        @NotNull
        public Set<Kodein.Key<?, ?, ?>> keySet(@NotNull KodeinTree kodeinTree) {
            Intrinsics.checkParameterIsNotNull(kodeinTree, "tree");
            Map<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>> bindings = kodeinTree.getBindings();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>> entry : bindings.entrySet()) {
                if (((KodeinDefinition) CollectionsKt___CollectionsKt.first(entry.getValue())).getBinding().getCopier() == null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap.keySet();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lorg/kodein/di/Copy$None;", "Lorg/kodein/di/Copy;", "Lorg/kodein/di/KodeinTree;", "tree", "", "Lorg/kodein/di/Kodein$Key;", "keySet", "(Lorg/kodein/di/KodeinTree;)Ljava/util/Set;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class None implements Copy {
        public static final None INSTANCE = new None();

        @Override // org.kodein.di.Copy
        @NotNull
        public Set<Kodein.Key<?, ?, ?>> keySet(@NotNull KodeinTree kodeinTree) {
            Intrinsics.checkParameterIsNotNull(kodeinTree, "tree");
            return y.emptySet();
        }
    }

    @NotNull
    Set<Kodein.Key<?, ?, ?>> keySet(@NotNull KodeinTree kodeinTree);
}
