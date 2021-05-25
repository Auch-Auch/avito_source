package org.kodein.di.internal;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.KodeinDefining;
import org.kodein.di.KodeinDefinition;
import org.kodein.di.bindings.ContextTranslator;
import org.kodein.di.bindings.KodeinBinding;
import t6.n.h;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001=B~\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u00120\u00107\u001a,\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003030)02\u0012\u001d\u0010.\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000e0\u001b¢\u0006\u0002\b\u001d0)\u0012\u0014\u00101\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030!0)¢\u0006\u0004\b;\u0010<Js\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u001e\u0010\t\u001a\u001a\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0001\u0012\u00028\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u001f\u001a\u00020\u000e2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000e0\u001b¢\u0006\u0002\b\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u000e2\u000e\u0010\"\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030!H\u0016¢\u0006\u0004\b#\u0010$J-\u0010%\u001a\u00020\u000e2\u0012\u0010\u0007\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010(R3\u0010.\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000e0\u001b¢\u0006\u0002\b\u001d0)8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R*\u00101\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030!0)8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u0010-RF\u00107\u001a,\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003030)028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b%\u00104\u001a\u0004\b5\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u00109¨\u0006>"}, d2 = {"Lorg/kodein/di/internal/KodeinContainerBuilderImpl;", "Lorg/kodein/di/KodeinContainer$Builder;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/Kodein$Key;", "key", "Lorg/kodein/di/bindings/KodeinBinding;", "binding", "", "fromModule", "", "overrides", "", "bind", "(Lorg/kodein/di/Kodein$Key;Lorg/kodein/di/bindings/KodeinBinding;Ljava/lang/String;Ljava/lang/Boolean;)V", "Lorg/kodein/di/KodeinContainer;", "container", "allowOverride", "", "copy", "extend", "(Lorg/kodein/di/KodeinContainer;ZLjava/util/Set;)V", "silentOverride", "subBuilder", "(ZZ)Lorg/kodein/di/internal/KodeinContainerBuilderImpl;", "Lkotlin/Function1;", "Lorg/kodein/di/DKodein;", "Lkotlin/ExtensionFunctionType;", "cb", "onReady", "(Lkotlin/jvm/functions/Function1;)V", "Lorg/kodein/di/bindings/ContextTranslator;", "translator", "registerContextTranslator", "(Lorg/kodein/di/bindings/ContextTranslator;)V", AuthSource.BOOKING_ORDER, "(Lorg/kodein/di/Kodein$Key;Ljava/lang/Boolean;)V", AuthSource.SEND_ABUSE, "(Z)V", "", "c", "Ljava/util/List;", "getCallbacks$kodein_di_core", "()Ljava/util/List;", "callbacks", "d", "getTranslators$kodein_di_core", "translators", "", "Lorg/kodein/di/KodeinDefining;", "Ljava/util/Map;", "getBindingsMap$kodein_di_core", "()Ljava/util/Map;", "bindingsMap", "Lorg/kodein/di/internal/KodeinContainerBuilderImpl$OverrideMode;", "Lorg/kodein/di/internal/KodeinContainerBuilderImpl$OverrideMode;", "_overrideMode", "<init>", "(ZZLjava/util/Map;Ljava/util/List;Ljava/util/List;)V", "OverrideMode", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class KodeinContainerBuilderImpl implements KodeinContainer.Builder {
    public final OverrideMode a;
    @NotNull
    public final Map<Kodein.Key<?, ?, ?>, List<KodeinDefining<?, ?, ?>>> b;
    @NotNull
    public final List<Function1<DKodein, Unit>> c;
    @NotNull
    public final List<ContextTranslator<?, ?>> d;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class OverrideMode extends Enum<OverrideMode> {
        public static final OverrideMode a;
        public static final OverrideMode b;
        public static final OverrideMode c;
        public static final /* synthetic */ OverrideMode[] d;
        public static final Companion e = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lorg/kodein/di/internal/KodeinContainerBuilderImpl$OverrideMode$Companion;", "", "", "allow", NotificationCompat.GROUP_KEY_SILENT, "Lorg/kodein/di/internal/KodeinContainerBuilderImpl$OverrideMode;", "get", "(ZZ)Lorg/kodein/di/internal/KodeinContainerBuilderImpl$OverrideMode;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final OverrideMode get(boolean z, boolean z2) {
                if (!z) {
                    return OverrideMode.c;
                }
                if (z2) {
                    return OverrideMode.a;
                }
                return OverrideMode.b;
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends OverrideMode {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // org.kodein.di.internal.KodeinContainerBuilderImpl.OverrideMode
            public boolean a() {
                return true;
            }

            @Override // org.kodein.di.internal.KodeinContainerBuilderImpl.OverrideMode
            @NotNull
            public Boolean b(@Nullable Boolean bool) {
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        }

        public static final class b extends OverrideMode {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // org.kodein.di.internal.KodeinContainerBuilderImpl.OverrideMode
            public boolean a() {
                return true;
            }

            @Override // org.kodein.di.internal.KodeinContainerBuilderImpl.OverrideMode
            @Nullable
            public Boolean b(@Nullable Boolean bool) {
                return bool;
            }
        }

        public static final class c extends OverrideMode {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // org.kodein.di.internal.KodeinContainerBuilderImpl.OverrideMode
            public boolean a() {
                return false;
            }

            @Override // org.kodein.di.internal.KodeinContainerBuilderImpl.OverrideMode
            @NotNull
            public Boolean b(@Nullable Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    return Boolean.FALSE;
                }
                throw new Kodein.OverridingException("Overriding has been forbidden");
            }
        }

        static {
            b bVar = new b("ALLOW_SILENT", 0);
            a = bVar;
            a aVar = new a("ALLOW_EXPLICIT", 1);
            b = aVar;
            c cVar = new c("FORBID", 2);
            c = cVar;
            d = new OverrideMode[]{bVar, aVar, cVar};
        }

        public OverrideMode(String str, int i, j jVar) {
        }

        public static OverrideMode valueOf(String str) {
            return (OverrideMode) Enum.valueOf(OverrideMode.class, str);
        }

        public static OverrideMode[] values() {
            return (OverrideMode[]) d.clone();
        }

        public abstract boolean a();

        @Nullable
        public abstract Boolean b(@Nullable Boolean bool);
    }

    public KodeinContainerBuilderImpl(boolean z, boolean z2, @NotNull Map<Kodein.Key<?, ?, ?>, List<KodeinDefining<?, ?, ?>>> map, @NotNull List<Function1<DKodein, Unit>> list, @NotNull List<ContextTranslator<?, ?>> list2) {
        Intrinsics.checkParameterIsNotNull(map, "bindingsMap");
        Intrinsics.checkParameterIsNotNull(list, "callbacks");
        Intrinsics.checkParameterIsNotNull(list2, "translators");
        this.b = map;
        this.c = list;
        this.d = list2;
        this.a = OverrideMode.e.get(z, z2);
    }

    public final void a(boolean z) {
        if (!this.a.a() && z) {
            throw new Kodein.OverridingException("Overriding has been forbidden");
        }
    }

    public final void b(Kodein.Key<?, ?, ?> key, Boolean bool) {
        Boolean b2 = this.a.b(bool);
        if (b2 == null) {
            return;
        }
        if (b2.booleanValue() && !this.b.containsKey(key)) {
            throw new Kodein.OverridingException("Binding " + key + " must override an existing binding.");
        } else if (!b2.booleanValue() && this.b.containsKey(key)) {
            throw new Kodein.OverridingException("Binding " + key + " must not override an existing binding.");
        }
    }

    @Override // org.kodein.di.KodeinContainer.Builder
    public <C, A, T> void bind(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key, @NotNull KodeinBinding<? super C, ? super A, ? extends T> kodeinBinding, @Nullable String str, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(kodeinBinding, "binding");
        key.getType().checkIsReified(key);
        key.getArgType().checkIsReified(key);
        b(key, bool);
        Map<Kodein.Key<?, ?, ?>, List<KodeinDefining<?, ?, ?>>> map = this.b;
        List<KodeinDefining<?, ?, ?>> list = map.get(key);
        if (list == null) {
            list = LangKt.newLinkedList();
            map.put(key, list);
        }
        list.add(0, new KodeinDefining<>(kodeinBinding, str));
    }

    @Override // org.kodein.di.KodeinContainer.Builder
    public void extend(@NotNull KodeinContainer kodeinContainer, boolean z, @NotNull Set<? extends Kodein.Key<?, ?, ?>> set) {
        List<KodeinDefining<?, ?, ?>> list;
        KodeinBinding kodeinBinding;
        Intrinsics.checkParameterIsNotNull(kodeinContainer, "container");
        Intrinsics.checkParameterIsNotNull(set, "copy");
        a(z);
        for (Map.Entry<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>> entry : kodeinContainer.getTree().getBindings().entrySet()) {
            Kodein.Key<?, ?, ?> key = entry.getKey();
            List<KodeinDefinition<?, ?, ?>> value = entry.getValue();
            if (!z) {
                b(key, null);
            }
            if (set.contains(key)) {
                list = LangKt.newLinkedList();
                for (T t : value) {
                    KodeinBinding.Copier copier = t.getBinding().getCopier();
                    if (copier == null || (kodeinBinding = copier.copy(this)) == null) {
                        kodeinBinding = t.getBinding();
                    }
                    list.add(new KodeinDefining<>(kodeinBinding, t.getFromModule()));
                }
            } else {
                list = LangKt.newLinkedList(value);
            }
            this.b.put(key, list);
        }
        h.addAll(this.d, kodeinContainer.getTree().getRegisteredTranslators());
    }

    @NotNull
    public final Map<Kodein.Key<?, ?, ?>, List<KodeinDefining<?, ?, ?>>> getBindingsMap$kodein_di_core() {
        return this.b;
    }

    @NotNull
    public final List<Function1<DKodein, Unit>> getCallbacks$kodein_di_core() {
        return this.c;
    }

    @NotNull
    public final List<ContextTranslator<?, ?>> getTranslators$kodein_di_core() {
        return this.d;
    }

    @Override // org.kodein.di.KodeinContainer.Builder
    public void onReady(@NotNull Function1<? super DKodein, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "cb");
        this.c.add(function1);
    }

    @Override // org.kodein.di.KodeinContainer.Builder
    public void registerContextTranslator(@NotNull ContextTranslator<?, ?> contextTranslator) {
        Intrinsics.checkParameterIsNotNull(contextTranslator, "translator");
        this.d.add(contextTranslator);
    }

    @Override // org.kodein.di.KodeinContainer.Builder
    @NotNull
    public KodeinContainerBuilderImpl subBuilder(boolean z, boolean z2) {
        a(z);
        return new KodeinContainerBuilderImpl(z, z2, this.b, this.c, this.d);
    }
}
