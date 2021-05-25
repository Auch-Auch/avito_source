package org.kodein.di.internal;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
import org.kodein.di.bindings.ContextTranslator;
import org.kodein.di.bindings.InstanceBinding;
import org.kodein.di.bindings.KodeinBinding;
import org.kodein.di.bindings.NoScope;
import org.kodein.di.bindings.Scope;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u000b\b\u0010\u0018\u00002\u00020\u0001:\u0003EFGB1\b\u0000\u0012\b\u0010<\u001a\u0004\u0018\u000107\u0012\u0006\u0010:\u001a\u000207\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u0002070=\u0012\u0006\u00102\u001a\u00020-¢\u0006\u0004\bC\u0010DJG\u0010\n\u001a\f\u0012\u0004\u0012\u00028\u00000\tR\u00020\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\n\u001a\u00060\fR\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\rJ%\u0010\u000f\u001a\u00060\u000eR\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0019\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u0019\u001a\u00020\u00142\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u001b\"\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0016J(\u0010\"\u001a\u00020\u00142\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00140\u001e¢\u0006\u0002\b H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\u00142\u000e\u0010%\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030$H\u0016¢\u0006\u0004\b&\u0010'R$\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u00102\u001a\u00020-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u00109R\"\u0010B\u001a\b\u0012\u0004\u0012\u0002070=8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006H"}, d2 = {"Lorg/kodein/di/internal/KodeinBuilderImpl;", "Lorg/kodein/di/Kodein$Builder;", "", "T", "Lorg/kodein/di/TypeToken;", "type", "tag", "", "overrides", "Lorg/kodein/di/internal/KodeinBuilderImpl$TypeBinder;", "Bind", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Boolean;)Lorg/kodein/di/internal/KodeinBuilderImpl$TypeBinder;", "Lorg/kodein/di/internal/KodeinBuilderImpl$DirectBinder;", "(Ljava/lang/Object;Ljava/lang/Boolean;)Lorg/kodein/di/internal/KodeinBuilderImpl$DirectBinder;", "Lorg/kodein/di/internal/KodeinBuilderImpl$ConstantBinder;", "constant", "(Ljava/lang/Object;Ljava/lang/Boolean;)Lorg/kodein/di/internal/KodeinBuilderImpl$ConstantBinder;", "Lorg/kodein/di/Kodein$Module;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "allowOverride", "", "import", "(Lorg/kodein/di/Kodein$Module;Z)V", "", "modules", "importAll", "(Ljava/lang/Iterable;Z)V", "", "([Lorg/kodein/di/Kodein$Module;Z)V", "importOnce", "Lkotlin/Function1;", "Lorg/kodein/di/DKodein;", "Lkotlin/ExtensionFunctionType;", "cb", "onReady", "(Lkotlin/jvm/functions/Function1;)V", "Lorg/kodein/di/bindings/ContextTranslator;", "translator", "RegisterContextTranslator", "(Lorg/kodein/di/bindings/ContextTranslator;)V", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getContextType", "()Lorg/kodein/di/TypeToken;", "contextType", "Lorg/kodein/di/internal/KodeinContainerBuilderImpl;", "e", "Lorg/kodein/di/internal/KodeinContainerBuilderImpl;", "getContainerBuilder", "()Lorg/kodein/di/internal/KodeinContainerBuilderImpl;", "containerBuilder", "Lorg/kodein/di/bindings/Scope;", "getScope", "()Lorg/kodein/di/bindings/Scope;", "scope", "", "c", "Ljava/lang/String;", "prefix", AuthSource.BOOKING_ORDER, "moduleName", "", "d", "Ljava/util/Set;", "getImportedModules$kodein_di_core", "()Ljava/util/Set;", "importedModules", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lorg/kodein/di/internal/KodeinContainerBuilderImpl;)V", "ConstantBinder", "DirectBinder", "TypeBinder", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public class KodeinBuilderImpl implements Kodein.Builder {
    @NotNull
    public final TypeToken<Object> a = TypeTokenKt.getAnyToken();
    public final String b;
    public final String c;
    @NotNull
    public final Set<String> d;
    @NotNull
    public final KodeinContainerBuilderImpl e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lorg/kodein/di/internal/KodeinBuilderImpl$ConstantBinder;", "Lorg/kodein/di/Kodein$Builder$ConstantBinder;", "", "T", "Lorg/kodein/di/TypeToken;", "valueType", "value", "", "With", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)V", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "_tag", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Boolean;", "_overrides", "<init>", "(Lorg/kodein/di/internal/KodeinBuilderImpl;Ljava/lang/Object;Ljava/lang/Boolean;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public final class ConstantBinder implements Kodein.Builder.ConstantBinder {
        public final Object a;
        public final Boolean b;
        public final /* synthetic */ KodeinBuilderImpl c;

        public ConstantBinder(@NotNull KodeinBuilderImpl kodeinBuilderImpl, @Nullable Object obj, Boolean bool) {
            Intrinsics.checkParameterIsNotNull(obj, "_tag");
            this.c = kodeinBuilderImpl;
            this.a = obj;
            this.b = bool;
        }

        @Override // org.kodein.di.Kodein.Builder.ConstantBinder
        public <T> void With(@NotNull TypeToken<? extends T> typeToken, @NotNull T t) {
            Intrinsics.checkParameterIsNotNull(typeToken, "valueType");
            Intrinsics.checkParameterIsNotNull(t, "value");
            this.c.Bind(this.a, this.b).from(new InstanceBinding(typeToken, t));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0013JF\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00042\u001e\u0010\u0007\u001a\u001a\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0001\u0012\u00028\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lorg/kodein/di/internal/KodeinBuilderImpl$DirectBinder;", "Lorg/kodein/di/Kodein$Builder$DirectBinder;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/bindings/KodeinBinding;", "binding", "", "from", "(Lorg/kodein/di/bindings/KodeinBinding;)V", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "_tag", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Boolean;", "_overrides", "<init>", "(Lorg/kodein/di/internal/KodeinBuilderImpl;Ljava/lang/Object;Ljava/lang/Boolean;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public final class DirectBinder implements Kodein.Builder.DirectBinder {
        public final Object a;
        public final Boolean b;

        public DirectBinder(@Nullable Object obj, @Nullable Boolean bool) {
            this.a = obj;
            this.b = bool;
        }

        @Override // org.kodein.di.Kodein.Builder.DirectBinder
        public <C, A, T> void from(@NotNull KodeinBinding<? super C, ? super A, ? extends T> kodeinBinding) {
            Intrinsics.checkParameterIsNotNull(kodeinBinding, "binding");
            if (!Intrinsics.areEqual(kodeinBinding.getCreatedType(), TypeTokenKt.getUnitToken())) {
                KodeinBuilderImpl.this.getContainerBuilder().bind(new Kodein.Key<>(kodeinBinding.getContextType(), kodeinBinding.getArgType(), kodeinBinding.getCreatedType(), this.a), kodeinBinding, KodeinBuilderImpl.this.b, this.b);
                return;
            }
            StringBuilder L = a.L("Using `bind() from` with a *Unit* ");
            L.append(kodeinBinding.factoryName());
            L.append(" is most likely an error. If you are sure you want to bind the Unit type, please use `bind<Unit>() with ");
            L.append(kodeinBinding.factoryName());
            L.append("`.");
            throw new IllegalArgumentException(L.toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B-\b\u0000\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b \u0010!J<\u0010\t\u001a\u00020\b\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00052\u001e\u0010\u0007\u001a\u001a\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006H\u0004¢\u0006\u0004\b\t\u0010\nR!\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lorg/kodein/di/internal/KodeinBuilderImpl$TypeBinder;", "", "T", "Lorg/kodein/di/Kodein$Builder$TypeBinder;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lorg/kodein/di/bindings/KodeinBinding;", "binding", "", "with", "(Lorg/kodein/di/bindings/KodeinBinding;)V", "Lorg/kodein/di/TypeToken;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getType", "()Lorg/kodein/di/TypeToken;", "type", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "tag", "Lorg/kodein/di/internal/KodeinContainerBuilderImpl;", "getContainerBuilder$kodein_di_core", "()Lorg/kodein/di/internal/KodeinContainerBuilderImpl;", "containerBuilder", "", "c", "Ljava/lang/Boolean;", "getOverrides", "()Ljava/lang/Boolean;", "overrides", "<init>", "(Lorg/kodein/di/internal/KodeinBuilderImpl;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Boolean;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public final class TypeBinder<T> implements Kodein.Builder.TypeBinder<T> {
        @NotNull
        public final TypeToken<? extends T> a;
        @Nullable
        public final Object b;
        @Nullable
        public final Boolean c;
        public final /* synthetic */ KodeinBuilderImpl d;

        public TypeBinder(@NotNull KodeinBuilderImpl kodeinBuilderImpl, @Nullable TypeToken<? extends T> typeToken, @Nullable Object obj, Boolean bool) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            this.d = kodeinBuilderImpl;
            this.a = typeToken;
            this.b = obj;
            this.c = bool;
        }

        @NotNull
        public final KodeinContainerBuilderImpl getContainerBuilder$kodein_di_core() {
            return this.d.getContainerBuilder();
        }

        @Nullable
        public final Boolean getOverrides() {
            return this.c;
        }

        @Nullable
        public final Object getTag() {
            return this.b;
        }

        @NotNull
        public final TypeToken<? extends T> getType() {
            return this.a;
        }

        @Override // org.kodein.di.Kodein.Builder.TypeBinder
        public <C, A> void with(@NotNull KodeinBinding<? super C, ? super A, ? extends T> kodeinBinding) {
            Intrinsics.checkParameterIsNotNull(kodeinBinding, "binding");
            getContainerBuilder$kodein_di_core().bind(new Kodein.Key<>(kodeinBinding.getContextType(), kodeinBinding.getArgType(), this.a, this.b), kodeinBinding, this.d.b, this.c);
        }
    }

    public KodeinBuilderImpl(@Nullable String str, @NotNull String str2, @NotNull Set<String> set, @NotNull KodeinContainerBuilderImpl kodeinContainerBuilderImpl) {
        Intrinsics.checkParameterIsNotNull(str2, "prefix");
        Intrinsics.checkParameterIsNotNull(set, "importedModules");
        Intrinsics.checkParameterIsNotNull(kodeinContainerBuilderImpl, "containerBuilder");
        this.b = str;
        this.c = str2;
        this.d = set;
        this.e = kodeinContainerBuilderImpl;
    }

    @Override // org.kodein.di.Kodein.Builder
    public void RegisterContextTranslator(@NotNull ContextTranslator<?, ?> contextTranslator) {
        Intrinsics.checkParameterIsNotNull(contextTranslator, "translator");
        getContainerBuilder().registerContextTranslator(contextTranslator);
    }

    @Override // org.kodein.di.Kodein.BindBuilder
    @NotNull
    public TypeToken<Object> getContextType() {
        return this.a;
    }

    @NotNull
    public final Set<String> getImportedModules$kodein_di_core() {
        return this.d;
    }

    @Override // org.kodein.di.Kodein.BindBuilder.WithScope
    @NotNull
    public Scope<Object> getScope() {
        return new NoScope();
    }

    @Override // org.kodein.di.Kodein.Builder
    /* renamed from: import */
    public void mo696import(@NotNull Kodein.Module module, boolean z) {
        Intrinsics.checkParameterIsNotNull(module, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        String str = this.c + module.getName();
        if (!(str.length() > 0) || !this.d.contains(str)) {
            this.d.add(str);
            module.getInit().invoke(new KodeinBuilderImpl(str, this.c + module.getPrefix(), this.d, getContainerBuilder().subBuilder(z, module.getAllowSilentOverride())));
            return;
        }
        throw new IllegalStateException(a.e3("Module \"", str, "\" has already been imported!"));
    }

    @Override // org.kodein.di.Kodein.Builder
    public void importAll(@NotNull Iterable<Kodein.Module> iterable, boolean z) {
        Intrinsics.checkParameterIsNotNull(iterable, "modules");
        for (Kodein.Module module : iterable) {
            mo696import(module, z);
        }
    }

    @Override // org.kodein.di.Kodein.Builder
    public void importOnce(@NotNull Kodein.Module module, boolean z) {
        Intrinsics.checkParameterIsNotNull(module, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        if (module.getName().length() == 0) {
            throw new IllegalStateException("importOnce must be given a named module.");
        } else if (!this.d.contains(module.getName())) {
            mo696import(module, z);
        }
    }

    @Override // org.kodein.di.Kodein.Builder
    public void onReady(@NotNull Function1<? super DKodein, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "cb");
        getContainerBuilder().onReady(function1);
    }

    @Override // org.kodein.di.Kodein.Builder
    @NotNull
    public ConstantBinder constant(@NotNull Object obj, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(obj, "tag");
        return new ConstantBinder(this, obj, bool);
    }

    @Override // org.kodein.di.Kodein.Builder
    @NotNull
    public KodeinContainerBuilderImpl getContainerBuilder() {
        return this.e;
    }

    @Override // org.kodein.di.Kodein.Builder
    @NotNull
    public <T> TypeBinder<T> Bind(@NotNull TypeToken<? extends T> typeToken, @Nullable Object obj, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new TypeBinder<>(this, typeToken, obj, bool);
    }

    @Override // org.kodein.di.Kodein.Builder
    public void importAll(@NotNull Kodein.Module[] moduleArr, boolean z) {
        Intrinsics.checkParameterIsNotNull(moduleArr, "modules");
        for (Kodein.Module module : moduleArr) {
            mo696import(module, z);
        }
    }

    @Override // org.kodein.di.Kodein.Builder
    @NotNull
    public DirectBinder Bind(@Nullable Object obj, @Nullable Boolean bool) {
        return new DirectBinder(obj, bool);
    }
}
