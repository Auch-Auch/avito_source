package org.kodein.di.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileTab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinDefining;
import org.kodein.di.KodeinDefinition;
import org.kodein.di.KodeinTree;
import org.kodein.di.SearchSpecs;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
import org.kodein.di.bindings.CompositeContextTranslator;
import org.kodein.di.bindings.ContextTranslator;
import org.kodein.di.bindings.ExternalSource;
import org.kodein.di.internal.TypeChecker;
import t6.n.q;
import t6.n.s;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B]\u00120\u0010@\u001a,\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030?0\f0)\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\f\u0012\u0014\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\f¢\u0006\u0004\bA\u0010BJ\u0001\u0010\u0010\u001aL\u0012H\u0012F\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f0\r0\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011JW\u0010\u0010\u001aB\u0012>\u0012<\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e0\f\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f0\r0\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0010\u0010\u0014J\u0001\u0010\u0015\u001aN\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e0\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0018\u00010\r\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u0019\u001a*\u0012&\u0012$\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f0\u00180\f2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0014J;\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d2\u0012\u0010\u001a\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR*\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#RJ\u0010/\u001a0\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e0\f0)j\u0002`*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.RV\u00105\u001aB\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003 1*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f0\u000f00j \u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003 1*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f0\u000f`28\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104Rd\u0010=\u001aP\u0012\u0004\u0012\u000207\u0012B\u0012@\u0012\u0004\u0012\u000208\u00122\u00120\u0012\u0004\u0012\u000208\u0012\"\u0012 \u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000606j\u0002`906j\u0002`:06j\u0002`;06j\u0002`<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010,Rh\u0010>\u001aT\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0012>\u0012<\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e0\f\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f0\r068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010,¨\u0006C"}, d2 = {"Lorg/kodein/di/internal/KodeinTreeImpl;", "Lorg/kodein/di/KodeinTree;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/Kodein$Key;", "key", "", "overrideLevel", "", ProfileTab.ALL, "", "Lkotlin/Triple;", "Lorg/kodein/di/KodeinDefinition;", "Lorg/kodein/di/bindings/ContextTranslator;", "find", "(Lorg/kodein/di/Kodein$Key;IZ)Ljava/util/List;", "Lorg/kodein/di/SearchSpecs;", "search", "(Lorg/kodein/di/SearchSpecs;)Ljava/util/List;", "get", "(Lorg/kodein/di/Kodein$Key;)Lkotlin/Triple;", "specs", "Lkotlin/Pair;", AuthSource.SEND_ABUSE, "result", "request", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", AuthSource.BOOKING_ORDER, "(Lorg/kodein/di/Kodein$Key;Lorg/kodein/di/Kodein$Key;)Ljava/lang/IllegalStateException;", "f", "Ljava/util/List;", "getRegisteredTranslators", "()Ljava/util/List;", "registeredTranslators", "Lorg/kodein/di/bindings/ExternalSource;", "e", "getExternalSources", "externalSources", "", "Lorg/kodein/di/BindingsMap;", "c", "Ljava/util/Map;", "getBindings", "()Ljava/util/Map;", "bindings", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "translators", "", "Lorg/kodein/di/internal/TypeChecker;", "Lorg/kodein/di/internal/TypeChecker$Down;", "Lorg/kodein/di/internal/TagTree;", "Lorg/kodein/di/internal/ArgumentTypeTree;", "Lorg/kodein/di/internal/ContextTypeTree;", "Lorg/kodein/di/internal/BoundTypeTree;", "_typeTree", "_cache", "Lorg/kodein/di/KodeinDefining;", "map", "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/util/List;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class KodeinTreeImpl implements KodeinTree {
    public final Map<Kodein.Key<?, ?, ?>, Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>>> a = LangKt.newConcurrentMap();
    public final Map<TypeChecker, Map<TypeChecker.Down, Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>>> b = new HashMap();
    @NotNull
    public final Map<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>> c;
    public final ArrayList<ContextTranslator<?, ?>> d = new ArrayList<>(getRegisteredTranslators());
    @NotNull
    public final List<ExternalSource> e;
    @NotNull
    public final List<ContextTranslator<?, ?>> f;

    public static final class a extends Lambda implements Function1<Map.Entry<? extends TypeChecker, ? extends Map<TypeChecker.Down, Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>>>, Boolean> {
        public final /* synthetic */ TypeToken a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TypeToken typeToken) {
            super(1);
            this.a = typeToken;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Map.Entry<? extends TypeChecker, ? extends Map<TypeChecker.Down, Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>>> entry) {
            Map.Entry<? extends TypeChecker, ? extends Map<TypeChecker.Down, Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>>> entry2 = entry;
            Intrinsics.checkParameterIsNotNull(entry2, "<name for destructuring parameter 0>");
            return Boolean.valueOf(((TypeChecker) entry2.getKey()).check(this.a));
        }
    }

    public static final class b extends Lambda implements Function1<Triple<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>, ? extends ContextTranslator<?, ?>>, Triple<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>, ? extends ContextTranslator<?, ?>>> {
        public final /* synthetic */ KodeinTreeImpl a;
        public final /* synthetic */ TypeToken b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KodeinTreeImpl kodeinTreeImpl, TypeToken typeToken) {
            super(1);
            this.a = kodeinTreeImpl;
            this.b = typeToken;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Triple<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>, ? extends ContextTranslator<?, ?>> invoke(Triple<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>, ? extends ContextTranslator<?, ?>> triple) {
            Object obj;
            boolean z;
            Triple<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>, ? extends ContextTranslator<?, ?>> triple2 = triple;
            Intrinsics.checkParameterIsNotNull(triple2, "triple");
            TypeChecker.Down down = (TypeChecker.Down) triple2.component1();
            if (down.check(this.b)) {
                return triple2;
            }
            Iterator it = this.a.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                ContextTranslator contextTranslator = (ContextTranslator) obj;
                if (!contextTranslator.getContextType().isAssignableFrom(this.b) || !down.check(contextTranslator.getScopeType())) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            ContextTranslator contextTranslator2 = (ContextTranslator) obj;
            if (contextTranslator2 != null) {
                return Triple.copy$default(triple2, null, null, contextTranslator2, 3, null);
            }
            return null;
        }
    }

    public static final class c extends Lambda implements Function1<Triple<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>, ? extends ContextTranslator<?, ?>>, Boolean> {
        public final /* synthetic */ TypeToken a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(TypeToken typeToken) {
            super(1);
            this.a = typeToken;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Triple<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>, ? extends ContextTranslator<?, ?>> triple) {
            Triple<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>, ? extends ContextTranslator<?, ?>> triple2 = triple;
            Intrinsics.checkParameterIsNotNull(triple2, "<name for destructuring parameter 0>");
            return Boolean.valueOf(((TypeChecker.Down) triple2.component1()).check(this.a));
        }
    }

    public static final class d extends Lambda implements Function1<Triple<? extends Object, ? extends Kodein.Key<?, ?, ?>, ? extends ContextTranslator<?, ?>>, Boolean> {
        public final /* synthetic */ Object a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Object obj) {
            super(1);
            this.a = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Triple<? extends Object, ? extends Kodein.Key<?, ?, ?>, ? extends ContextTranslator<?, ?>> triple) {
            Triple<? extends Object, ? extends Kodein.Key<?, ?, ?>, ? extends ContextTranslator<?, ?>> triple2 = triple;
            Intrinsics.checkParameterIsNotNull(triple2, "<name for destructuring parameter 0>");
            return Boolean.valueOf(Intrinsics.areEqual(triple2.component1(), this.a));
        }
    }

    public static final class e extends Lambda implements Function1<Triple<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>, ? extends ContextTranslator<?, ?>>, Sequence<? extends Triple<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>, ? extends ContextTranslator<?, ?>>>> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Sequence<? extends Triple<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>, ? extends ContextTranslator<?, ?>>> invoke(Triple<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>, ? extends ContextTranslator<?, ?>> triple) {
            Triple<? extends TypeChecker.Down, ? extends Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>, ? extends ContextTranslator<?, ?>> triple2 = triple;
            Intrinsics.checkParameterIsNotNull(triple2, "<name for destructuring parameter 0>");
            return SequencesKt___SequencesKt.map(s.asSequence((Map) triple2.component2()), new x6.d.a.o.e((ContextTranslator) triple2.component3()));
        }
    }

    public static final class f extends Lambda implements Function1<Map.Entry<? extends TypeChecker, ? extends Map<TypeChecker.Down, Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>>>, Sequence<? extends Triple>> {
        public static final f a = new f();

        public f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Sequence<? extends Triple> invoke(Map.Entry<? extends TypeChecker, ? extends Map<TypeChecker.Down, Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>>> entry) {
            Map.Entry<? extends TypeChecker, ? extends Map<TypeChecker.Down, Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>>> entry2 = entry;
            Intrinsics.checkParameterIsNotNull(entry2, "<name for destructuring parameter 0>");
            return SequencesKt___SequencesKt.map(s.asSequence((Map) entry2.getValue()), x6.d.a.o.f.a);
        }
    }

    public static final class g extends Lambda implements Function1<Triple<? extends Object, ? extends Kodein.Key<?, ?, ?>, ? extends ContextTranslator<?, ?>>, Pair<? extends Kodein.Key<?, ?, ?>, ? extends ContextTranslator<?, ?>>> {
        public static final g a = new g();

        public g() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Pair<? extends Kodein.Key<?, ?, ?>, ? extends ContextTranslator<?, ?>> invoke(Triple<? extends Object, ? extends Kodein.Key<?, ?, ?>, ? extends ContextTranslator<?, ?>> triple) {
            Triple<? extends Object, ? extends Kodein.Key<?, ?, ?>, ? extends ContextTranslator<?, ?>> triple2 = triple;
            Intrinsics.checkParameterIsNotNull(triple2, "<name for destructuring parameter 0>");
            return TuplesKt.to((Kodein.Key) triple2.component2(), (ContextTranslator) triple2.component3());
        }
    }

    public static final class h extends Lambda implements Function1<Triple<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>, ? extends ContextTranslator<?, ?>>, Sequence<? extends Triple<? extends Object, ? extends Kodein.Key<?, ?, ?>, ? extends ContextTranslator<?, ?>>>> {
        public static final h a = new h();

        public h() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Sequence<? extends Triple<? extends Object, ? extends Kodein.Key<?, ?, ?>, ? extends ContextTranslator<?, ?>>> invoke(Triple<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>, ? extends ContextTranslator<?, ?>> triple) {
            Triple<? extends TypeChecker.Down, ? extends Map<Object, Kodein.Key<?, ?, ?>>, ? extends ContextTranslator<?, ?>> triple2 = triple;
            Intrinsics.checkParameterIsNotNull(triple2, "<name for destructuring parameter 0>");
            return SequencesKt___SequencesKt.map(s.asSequence((Map) triple2.component2()), new x6.d.a.o.g((ContextTranslator) triple2.component3()));
        }
    }

    public static final class i extends Lambda implements Function1<Kodein.Key<?, ?, ?>, String> {
        public static final i a = new i();

        public i() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(Kodein.Key<?, ?, ?> key) {
            Kodein.Key<?, ?, ?> key2 = key;
            Intrinsics.checkParameterIsNotNull(key2, "it");
            return key2.getInternalDescription();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends org.kodein.di.bindings.ExternalSource> */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.List<? extends org.kodein.di.bindings.ContextTranslator<?, ?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public KodeinTreeImpl(@NotNull Map<Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefining<?, ?, ?>>> map, @NotNull List<? extends ExternalSource> list, @NotNull List<? extends ContextTranslator<?, ?>> list2) {
        ArrayList arrayList;
        boolean z;
        KodeinDefinition kodeinDefinition;
        Intrinsics.checkParameterIsNotNull(map, "map");
        Intrinsics.checkParameterIsNotNull(list, "externalSources");
        Intrinsics.checkParameterIsNotNull(list2, "registeredTranslators");
        this.e = list;
        this.f = list2;
        for (Map.Entry<Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefining<?, ?, ?>>> entry : map.entrySet()) {
            Kodein.Key<?, ?, ?> key = entry.getKey();
            List<KodeinDefining> list3 = (List) entry.getValue();
            ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(list3, 10));
            for (KodeinDefining kodeinDefining : list3) {
                if (kodeinDefining instanceof KodeinDefinition) {
                    kodeinDefinition = (KodeinDefinition) kodeinDefining;
                } else {
                    kodeinDefinition = new KodeinDefinition(kodeinDefining.getBinding(), kodeinDefining.getFromModule(), this);
                }
                arrayList2.add(kodeinDefinition);
            }
            this.a.put(key, new Triple<>(key, arrayList2, null));
            TypeChecker down = ((KodeinDefining) CollectionsKt___CollectionsKt.first(list3)).getBinding().getSupportSubTypes() ? new TypeChecker.Down(key.getType()) : new TypeChecker.Up(key.getType());
            Map<TypeChecker, Map<TypeChecker.Down, Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>>> map2 = this.b;
            Map<TypeChecker.Down, Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>> map3 = map2.get(down);
            if (map3 == null) {
                map3 = new HashMap<>();
                map2.put(down, map3);
            }
            Map<TypeChecker.Down, Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>>> map4 = map3;
            TypeChecker.Down down2 = new TypeChecker.Down(key.getContextType());
            Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>> map5 = map4.get(down2);
            if (map5 == null) {
                map5 = new HashMap<>();
                map4.put(down2, map5);
            }
            Map<TypeChecker.Down, Map<Object, Kodein.Key<?, ?, ?>>> map6 = map5;
            TypeChecker.Down down3 = new TypeChecker.Down(key.getArgType());
            Map<Object, Kodein.Key<?, ?, ?>> map7 = map6.get(down3);
            if (map7 == null) {
                map7 = new HashMap<>();
                map6.put(down3, map7);
            }
            map7.put(key.getTag(), key);
        }
        Map<Kodein.Key<?, ?, ?>, Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>>> map8 = this.a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(map8.size()));
        for (T t : map8.entrySet()) {
            linkedHashMap.put(t.getKey(), (List) ((Triple) t.getValue()).getSecond());
        }
        this.c = new HashMap(linkedHashMap);
        do {
            arrayList = new ArrayList();
            Iterator<ContextTranslator<?, ?>> it = this.d.iterator();
            while (it.hasNext()) {
                ContextTranslator<?, ?> next = it.next();
                Iterator<ContextTranslator<?, ?>> it2 = this.d.iterator();
                while (it2.hasNext()) {
                    ContextTranslator<?, ?> next2 = it2.next();
                    if (next2.getContextType().isAssignableFrom(next.getScopeType())) {
                        boolean z2 = true;
                        if (!Intrinsics.areEqual(next.getContextType(), next2.getScopeType())) {
                            ArrayList<ContextTranslator<?, ?>> arrayList3 = this.d;
                            if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                                Iterator<T> it3 = arrayList3.iterator();
                                while (true) {
                                    if (!it3.hasNext()) {
                                        break;
                                    }
                                    T next3 = it3.next();
                                    if (!Intrinsics.areEqual(next3.getContextType(), next.getContextType()) || !Intrinsics.areEqual(next3.getScopeType(), next2.getScopeType())) {
                                        z = false;
                                        continue;
                                    } else {
                                        z = true;
                                        continue;
                                    }
                                    if (z) {
                                        z2 = false;
                                        break;
                                    }
                                }
                            }
                            if (z2) {
                                arrayList.add(new CompositeContextTranslator(next, next2));
                            }
                        }
                    }
                }
            }
            t6.n.h.addAll(this.d, arrayList);
        } while (!arrayList.isEmpty());
    }

    public final List<Pair<Kodein.Key<?, ?, ?>, ContextTranslator<?, ?>>> a(SearchSpecs searchSpecs) {
        Sequence asSequence = s.asSequence(this.b);
        TypeToken<?> type = searchSpecs.getType();
        if (type != null && (!Intrinsics.areEqual(type, TypeTokenKt.getAnyToken()))) {
            asSequence = SequencesKt___SequencesKt.filter(asSequence, new a(type));
        }
        Sequence flatMap = SequencesKt___SequencesKt.flatMap(asSequence, f.a);
        TypeToken<?> contextType = searchSpecs.getContextType();
        if (contextType != null) {
            flatMap = SequencesKt___SequencesKt.mapNotNull(flatMap, new b(this, contextType));
        }
        Sequence flatMap2 = SequencesKt___SequencesKt.flatMap(flatMap, e.a);
        TypeToken<?> argType = searchSpecs.getArgType();
        if (argType != null) {
            flatMap2 = SequencesKt___SequencesKt.filter(flatMap2, new c(argType));
        }
        Sequence flatMap3 = SequencesKt___SequencesKt.flatMap(flatMap2, h.a);
        Object tag = searchSpecs.getTag();
        if (!Intrinsics.areEqual(tag, SearchSpecs.NoDefinedTag.INSTANCE)) {
            flatMap3 = SequencesKt___SequencesKt.filter(flatMap3, new d(tag));
        }
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(flatMap3, g.a));
    }

    public final IllegalStateException b(Kodein.Key<?, ?, ?> key, Kodein.Key<?, ?, ?> key2) {
        StringBuilder L = a2.b.a.a.a.L("Tree returned key ");
        L.append(key.getInternalDescription());
        L.append(" that is not in cache when searching for ");
        L.append(key2.getInternalDescription());
        L.append(".\nKeys in cache:\n");
        L.append(CollectionsKt___CollectionsKt.joinToString$default(this.a.keySet(), "\n", null, null, 0, null, i.a, 30, null));
        return new IllegalStateException(L.toString());
    }

    @Override // org.kodein.di.KodeinTree
    @NotNull
    public <C, A, T> List<Triple<Kodein.Key<Object, A, T>, KodeinDefinition<Object, A, T>, ContextTranslator<C, Object>>> find(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key, int i2, boolean z) {
        Triple triple;
        Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>> copy$default;
        Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>> triple2;
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (!z) {
            Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>> triple3 = this.a.get(key);
            if (triple3 != null) {
                Kodein.Key<?, ?, ?> component1 = triple3.component1();
                ContextTranslator<?, ?> component3 = triple3.component3();
                KodeinDefinition kodeinDefinition = (KodeinDefinition) CollectionsKt___CollectionsKt.getOrNull(triple3.component2(), i2);
                if (kodeinDefinition == null) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                if (component1 != null) {
                    return t6.n.d.listOf(new Triple(component1, kodeinDefinition, component3));
                }
                throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.Kodein.Key<kotlin.Any, A, T>");
            }
            if ((!Intrinsics.areEqual(key.getContextType(), TypeTokenKt.getAnyToken())) && (triple2 = this.a.get(Kodein.Key.copy$default(key, TypeTokenKt.getAnyToken(), null, null, null, 14, null))) != null) {
                Kodein.Key<?, ?, ?> component12 = triple2.component1();
                List<KodeinDefinition<?, ?, ?>> component2 = triple2.component2();
                ContextTranslator<?, ?> component32 = triple2.component3();
                if ((component32 == null || !(!Intrinsics.areEqual(component32.getContextType(), key.getContextType()))) && (component32 != null || !(!Intrinsics.areEqual(component12.getContextType(), key.getContextType())))) {
                    this.a.put(key, triple2);
                    KodeinDefinition kodeinDefinition2 = (KodeinDefinition) CollectionsKt___CollectionsKt.getOrNull(component2, i2);
                    if (kodeinDefinition2 == null) {
                        return CollectionsKt__CollectionsKt.emptyList();
                    }
                    if (component12 != null) {
                        return t6.n.d.listOf(new Triple(component12, kodeinDefinition2, component32));
                    }
                    throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.Kodein.Key<kotlin.Any, A, T>");
                }
            }
            ArrayList<ContextTranslator<?, ?>> arrayList = this.d;
            ArrayList arrayList2 = new ArrayList();
            for (T t : arrayList) {
                if (Intrinsics.areEqual(t.getContextType(), key.getContextType())) {
                    arrayList2.add(t);
                }
            }
            ArrayList<ContextTranslator<?, ?>> arrayList3 = this.d;
            ArrayList arrayList4 = new ArrayList();
            for (T t2 : arrayList3) {
                if (Intrinsics.areEqual(t2.getContextType(), TypeTokenKt.getAnyToken())) {
                    arrayList4.add(t2);
                }
            }
            for (ContextTranslator contextTranslator : CollectionsKt___CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList4)) {
                Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>> triple4 = this.a.get(new Kodein.Key(contextTranslator.getScopeType(), key.getArgType(), key.getType(), key.getTag()));
                if (triple4 != null) {
                    Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>> triple5 = triple4.getThird() == null ? triple4 : null;
                    if (triple5 != null && triple5.getThird() == null) {
                        this.a.put(key, Triple.copy$default(triple5, null, null, contextTranslator, 3, null));
                        Kodein.Key<?, ?, ?> component13 = triple5.component1();
                        KodeinDefinition kodeinDefinition3 = (KodeinDefinition) CollectionsKt___CollectionsKt.getOrNull(triple5.component2(), i2);
                        if (kodeinDefinition3 == null) {
                            return CollectionsKt__CollectionsKt.emptyList();
                        }
                        if (component13 != null) {
                            return t6.n.d.listOf(new Triple(component13, kodeinDefinition3, contextTranslator));
                        }
                        throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.Kodein.Key<kotlin.Any, A, T>");
                    }
                }
            }
        }
        List<Pair<Kodein.Key<?, ?, ?>, ContextTranslator<?, ?>>> a3 = a(new SearchSpecs(key.getContextType(), key.getArgType(), key.getType(), key.getTag()));
        if (a3.size() == 1) {
            Pair pair = (Pair) CollectionsKt___CollectionsKt.first((List<? extends Object>) a3);
            Kodein.Key<?, ?, ?> key2 = (Kodein.Key) pair.component1();
            ContextTranslator contextTranslator2 = (ContextTranslator) pair.component2();
            Map<Kodein.Key<?, ?, ?>, Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>>> map = this.a;
            Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>> triple6 = map.get(key2);
            if (triple6 == null || (copy$default = Triple.copy$default(triple6, null, null, contextTranslator2, 3, null)) == null) {
                throw b(key2, key);
            }
            map.put(key, copy$default);
        }
        ArrayList arrayList5 = new ArrayList();
        for (T t3 : a3) {
            Kodein.Key<?, ?, ?> key3 = (Kodein.Key) t3.component1();
            ContextTranslator contextTranslator3 = (ContextTranslator) t3.component2();
            Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>> triple7 = this.a.get(key3);
            if (triple7 != null) {
                KodeinDefinition kodeinDefinition4 = (KodeinDefinition) CollectionsKt___CollectionsKt.getOrNull(triple7.component2(), i2);
                if (kodeinDefinition4 == null) {
                    triple = null;
                } else if (key3 != null) {
                    triple = new Triple(key3, kodeinDefinition4, contextTranslator3);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.Kodein.Key<kotlin.Any, A, T>");
                }
                if (triple != null) {
                    arrayList5.add(triple);
                }
            } else {
                throw b(key3, key);
            }
        }
        return arrayList5;
    }

    @Override // org.kodein.di.KodeinTree
    @Nullable
    public <C, A, T> Triple<Kodein.Key<Object, A, T>, List<KodeinDefinition<Object, A, T>>, ContextTranslator<C, Object>> get(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.a.get(key);
    }

    @Override // org.kodein.di.KodeinTree
    @NotNull
    public Map<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>> getBindings() {
        return this.c;
    }

    @Override // org.kodein.di.KodeinTree
    @NotNull
    public List<ExternalSource> getExternalSources() {
        return this.e;
    }

    @Override // org.kodein.di.KodeinTree
    @NotNull
    public List<ContextTranslator<?, ?>> getRegisteredTranslators() {
        return this.f;
    }

    @Override // org.kodein.di.KodeinTree
    @NotNull
    public List<Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>>> find(@NotNull SearchSpecs searchSpecs) {
        Intrinsics.checkParameterIsNotNull(searchSpecs, "search");
        List<Pair<Kodein.Key<?, ?, ?>, ContextTranslator<?, ?>>> a3 = a(searchSpecs);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(a3, 10));
        for (T t : a3) {
            Kodein.Key key = (Kodein.Key) t.component1();
            ContextTranslator contextTranslator = (ContextTranslator) t.component2();
            Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>> triple = this.a.get(key);
            if (triple == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(new Triple(key, triple.getSecond(), contextTranslator));
        }
        return arrayList;
    }
}
