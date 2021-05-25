package org.kodein.di;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.VKScope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.DslMarker;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Copy;
import org.kodein.di.KodeinAware;
import org.kodein.di.KodeinContainer;
import org.kodein.di.bindings.ContextTranslator;
import org.kodein.di.bindings.ExternalSource;
import org.kodein.di.bindings.KodeinBinding;
import org.kodein.di.bindings.Scope;
import org.kodein.di.internal.KodeinImpl;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bf\u0018\u0000 \t2\u00020\u0001:\u000b\n\u000b\t\f\r\u000e\u000f\u0010\u0011\u0012\u0013R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lorg/kodein/di/Kodein;", "Lorg/kodein/di/KodeinAware;", "Lorg/kodein/di/KodeinContainer;", "getContainer", "()Lorg/kodein/di/KodeinContainer;", "container", "getKodein", "()Lorg/kodein/di/Kodein;", "kodein", "Companion", "BindBuilder", "Builder", "DependencyLoopException", "Key", "KodeinDsl", "MainBuilder", "Module", "NoResultException", "NotFoundException", "OverridingException", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface Kodein extends KodeinAware {
    public static final Companion Companion = Companion.b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0007\bR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lorg/kodein/di/Kodein$BindBuilder;", "C", "", "Lorg/kodein/di/TypeToken;", "getContextType", "()Lorg/kodein/di/TypeToken;", "contextType", "WithContext", "WithScope", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public interface BindBuilder<C> {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lorg/kodein/di/Kodein$BindBuilder$WithContext;", "C", "Lorg/kodein/di/Kodein$BindBuilder;", "Impl", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
        public interface WithContext<C> extends BindBuilder<C> {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lorg/kodein/di/Kodein$BindBuilder$WithContext$Impl;", "C", "Lorg/kodein/di/Kodein$BindBuilder$WithContext;", "Lorg/kodein/di/TypeToken;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getContextType", "()Lorg/kodein/di/TypeToken;", "contextType", "<init>", "(Lorg/kodein/di/TypeToken;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
            public static final class Impl<C> implements WithContext<C> {
                @NotNull
                public final TypeToken<C> a;

                public Impl(@NotNull TypeToken<C> typeToken) {
                    Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
                    this.a = typeToken;
                }

                @Override // org.kodein.di.Kodein.BindBuilder
                @NotNull
                public TypeToken<C> getContextType() {
                    return this.a;
                }
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002:\u0001\u0007R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lorg/kodein/di/Kodein$BindBuilder$WithScope;", "C", "Lorg/kodein/di/Kodein$BindBuilder;", "Lorg/kodein/di/bindings/Scope;", "getScope", "()Lorg/kodein/di/bindings/Scope;", "scope", "Impl", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
        public interface WithScope<C> extends BindBuilder<C> {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B#\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\t\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lorg/kodein/di/Kodein$BindBuilder$WithScope$Impl;", "C", "Lorg/kodein/di/Kodein$BindBuilder$WithScope;", "Lorg/kodein/di/bindings/Scope;", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/bindings/Scope;", "getScope", "()Lorg/kodein/di/bindings/Scope;", "scope", "Lorg/kodein/di/TypeToken;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getContextType", "()Lorg/kodein/di/TypeToken;", "contextType", "<init>", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/bindings/Scope;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
            public static final class Impl<C> implements WithScope<C> {
                @NotNull
                public final TypeToken<C> a;
                @NotNull
                public final Scope<C> b;

                /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.kodein.di.bindings.Scope<? super C> */
                /* JADX WARN: Multi-variable type inference failed */
                public Impl(@NotNull TypeToken<C> typeToken, @NotNull Scope<? super C> scope) {
                    Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
                    Intrinsics.checkParameterIsNotNull(scope, "scope");
                    this.a = typeToken;
                    this.b = scope;
                }

                @Override // org.kodein.di.Kodein.BindBuilder
                @NotNull
                public TypeToken<C> getContextType() {
                    return this.a;
                }

                @Override // org.kodein.di.Kodein.BindBuilder.WithScope
                @NotNull
                public Scope<C> getScope() {
                    return this.b;
                }
            }

            @NotNull
            Scope<C> getScope();
        }

        @NotNull
        TypeToken<C> getContextType();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003:\u0003-./JG\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0004*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000b\u001a\u00020\r2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\u000eJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001a\u001a\u00020\u00152\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0018\"\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001a\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\b\b\u0002\u0010\u0014\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\bH&¢\u0006\u0004\b\u001e\u0010\u0017J(\u0010#\u001a\u00020\u00152\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\u0002\b!H&¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\u00152\u000e\u0010&\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030%H&¢\u0006\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00060"}, d2 = {"Lorg/kodein/di/Kodein$Builder;", "Lorg/kodein/di/Kodein$BindBuilder$WithContext;", "", "Lorg/kodein/di/Kodein$BindBuilder$WithScope;", "T", "Lorg/kodein/di/TypeToken;", "type", "tag", "", "overrides", "Lorg/kodein/di/Kodein$Builder$TypeBinder;", "Bind", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Boolean;)Lorg/kodein/di/Kodein$Builder$TypeBinder;", "Lorg/kodein/di/Kodein$Builder$DirectBinder;", "(Ljava/lang/Object;Ljava/lang/Boolean;)Lorg/kodein/di/Kodein$Builder$DirectBinder;", "Lorg/kodein/di/Kodein$Builder$ConstantBinder;", "constant", "(Ljava/lang/Object;Ljava/lang/Boolean;)Lorg/kodein/di/Kodein$Builder$ConstantBinder;", "Lorg/kodein/di/Kodein$Module;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "allowOverride", "", "import", "(Lorg/kodein/di/Kodein$Module;Z)V", "", "modules", "importAll", "([Lorg/kodein/di/Kodein$Module;Z)V", "", "(Ljava/lang/Iterable;Z)V", "importOnce", "Lkotlin/Function1;", "Lorg/kodein/di/DKodein;", "Lkotlin/ExtensionFunctionType;", "cb", "onReady", "(Lkotlin/jvm/functions/Function1;)V", "Lorg/kodein/di/bindings/ContextTranslator;", "translator", "RegisterContextTranslator", "(Lorg/kodein/di/bindings/ContextTranslator;)V", "Lorg/kodein/di/KodeinContainer$Builder;", "getContainerBuilder", "()Lorg/kodein/di/KodeinContainer$Builder;", "containerBuilder", "ConstantBinder", "DirectBinder", "TypeBinder", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    @KodeinDsl
    public interface Builder extends BindBuilder.WithContext<Object>, BindBuilder.WithScope<Object> {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lorg/kodein/di/Kodein$Builder$ConstantBinder;", "", "T", "Lorg/kodein/di/TypeToken;", "valueType", "value", "", "With", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
        public interface ConstantBinder {
            <T> void With(@NotNull TypeToken<? extends T> typeToken, @NotNull T t);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JF\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0004*\u00020\u00012\u001e\u0010\u0006\u001a\u001a\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0001\u0012\u00028\u00020\u0005H¦\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lorg/kodein/di/Kodein$Builder$DirectBinder;", "", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "T", "Lorg/kodein/di/bindings/KodeinBinding;", "binding", "", "from", "(Lorg/kodein/di/bindings/KodeinBinding;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
        public interface DirectBinder {
            <C, A, T> void from(@NotNull KodeinBinding<? super C, ? super A, ? extends T> kodeinBinding);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J<\u0010\b\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u001e\u0010\u0006\u001a\u001a\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H¦\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lorg/kodein/di/Kodein$Builder$TypeBinder;", "", "T", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lorg/kodein/di/bindings/KodeinBinding;", "binding", "", "with", "(Lorg/kodein/di/bindings/KodeinBinding;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
        public interface TypeBinder<T> {
            <C, A> void with(@NotNull KodeinBinding<? super C, ? super A, ? extends T> kodeinBinding);
        }

        @NotNull
        DirectBinder Bind(@Nullable Object obj, @Nullable Boolean bool);

        @NotNull
        <T> TypeBinder<T> Bind(@NotNull TypeToken<? extends T> typeToken, @Nullable Object obj, @Nullable Boolean bool);

        void RegisterContextTranslator(@NotNull ContextTranslator<?, ?> contextTranslator);

        @NotNull
        ConstantBinder constant(@NotNull Object obj, @Nullable Boolean bool);

        @NotNull
        KodeinContainer.Builder getContainerBuilder();

        /* renamed from: import  reason: not valid java name */
        void mo696import(@NotNull Module module, boolean z);

        void importAll(@NotNull Iterable<Module> iterable, boolean z);

        void importAll(@NotNull Module[] moduleArr, boolean z);

        void importOnce(@NotNull Module module, boolean z);

        void onReady(@NotNull Function1<? super DKodein, Unit> function1);

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
        public static final class DefaultImpls {
            public static /* synthetic */ TypeBinder Bind$default(Builder builder, TypeToken typeToken, Object obj, Boolean bool, int i, Object obj2) {
                if (obj2 == null) {
                    if ((i & 2) != 0) {
                        obj = null;
                    }
                    if ((i & 4) != 0) {
                        bool = null;
                    }
                    return builder.Bind(typeToken, obj, bool);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: Bind");
            }

            public static /* synthetic */ ConstantBinder constant$default(Builder builder, Object obj, Boolean bool, int i, Object obj2) {
                if (obj2 == null) {
                    if ((i & 2) != 0) {
                        bool = null;
                    }
                    return builder.constant(obj, bool);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: constant");
            }

            public static /* synthetic */ void import$default(Builder builder, Module module, boolean z, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        z = false;
                    }
                    builder.mo696import(module, z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: import");
            }

            public static /* synthetic */ void importAll$default(Builder builder, Module[] moduleArr, boolean z, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        z = false;
                    }
                    builder.importAll(moduleArr, z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: importAll");
            }

            public static /* synthetic */ void importOnce$default(Builder builder, Module module, boolean z, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        z = false;
                    }
                    builder.importOnce(module, z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: importOnce");
            }

            public static /* synthetic */ DirectBinder Bind$default(Builder builder, Object obj, Boolean bool, int i, Object obj2) {
                if (obj2 == null) {
                    if ((i & 1) != 0) {
                        obj = null;
                    }
                    if ((i & 2) != 0) {
                        bool = null;
                    }
                    return builder.Bind(obj, bool);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: Bind");
            }

            public static /* synthetic */ void importAll$default(Builder builder, Iterable iterable, boolean z, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        z = false;
                    }
                    builder.importAll(iterable, z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: importAll");
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ0\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011JB\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lorg/kodein/di/Kodein$Companion;", "", "", "allowSilentOverride", "Lkotlin/Function1;", "Lorg/kodein/di/Kodein$MainBuilder;", "", "Lkotlin/ExtensionFunctionType;", "init", "Lorg/kodein/di/Kodein;", "invoke", "(ZLkotlin/jvm/functions/Function1;)Lorg/kodein/di/Kodein;", "Lorg/kodein/di/LazyKodein;", "lazy", "(ZLkotlin/jvm/functions/Function1;)Lorg/kodein/di/LazyKodein;", "Lorg/kodein/di/DKodein;", VKScope.DIRECT, "(ZLkotlin/jvm/functions/Function1;)Lorg/kodein/di/DKodein;", "Lkotlin/Pair;", "Lkotlin/Function0;", "withDelayedCallbacks", "(ZLkotlin/jvm/functions/Function1;)Lkotlin/Pair;", AuthSource.SEND_ABUSE, "Z", "getDefaultFullDescriptionOnError", "()Z", "setDefaultFullDescriptionOnError", "(Z)V", "defaultFullDescriptionOnError", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public static boolean a;
        public static final /* synthetic */ Companion b = new Companion();

        public static final class a extends Lambda implements Function0<KodeinImpl> {
            public final /* synthetic */ boolean a;
            public final /* synthetic */ Function1 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(boolean z, Function1 function1) {
                super(0);
                this.a = z;
                this.b = function1;
            }

            @Override // kotlin.jvm.functions.Function0
            public KodeinImpl invoke() {
                return new KodeinImpl(this.a, this.b);
            }
        }

        public static /* synthetic */ DKodein direct$default(Companion companion, boolean z, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.direct(z, function1);
        }

        public static /* synthetic */ Kodein invoke$default(Companion companion, boolean z, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.invoke(z, function1);
        }

        public static /* synthetic */ LazyKodein lazy$default(Companion companion, boolean z, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.lazy(z, function1);
        }

        public static /* synthetic */ Pair withDelayedCallbacks$default(Companion companion, boolean z, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.withDelayedCallbacks(z, function1);
        }

        @NotNull
        public final DKodein direct(boolean z, @NotNull Function1<? super MainBuilder, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "init");
            return KodeinAwareKt.getDirect(new KodeinImpl(z, function1));
        }

        public final boolean getDefaultFullDescriptionOnError() {
            return a;
        }

        @NotNull
        public final Kodein invoke(boolean z, @NotNull Function1<? super MainBuilder, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "init");
            return new KodeinImpl(z, function1);
        }

        @NotNull
        public final LazyKodein lazy(boolean z, @NotNull Function1<? super MainBuilder, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "init");
            return new LazyKodein(new a(z, function1));
        }

        public final void setDefaultFullDescriptionOnError(boolean z) {
            a = z;
        }

        @NotNull
        public final Pair<Kodein, Function0<Unit>> withDelayedCallbacks(boolean z, @NotNull Function1<? super MainBuilder, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "init");
            return KodeinImpl.Companion.withDelayedCallbacks(z, function1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @NotNull
        public static Kodein getKodein(Kodein kodein) {
            return kodein;
        }

        @NotNull
        public static KodeinContext<?> getKodeinContext(Kodein kodein) {
            return KodeinAware.DefaultImpls.getKodeinContext(kodein);
        }

        @Nullable
        public static KodeinTrigger getKodeinTrigger(Kodein kodein) {
            return KodeinAware.DefaultImpls.getKodeinTrigger(kodein);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lorg/kodein/di/Kodein$DependencyLoopException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "message", "<init>", "(Ljava/lang/String;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class DependencyLoopException extends RuntimeException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DependencyLoopException(@NotNull String str) {
            super(str);
            Intrinsics.checkParameterIsNotNull(str, "message");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u0000*\n\b\u0002\u0010\u0004 \u0001*\u00020\u00032\u00020\u0003BA\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000b\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b:\u0010;J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0018\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011Jd\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000b2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ4\u0010\"\u001a\u00020!*\u00060\u001cj\u0002`\u001d2\u001b\u0010 \u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\b0\u001e¢\u0006\u0002\b\u001fH\u0002¢\u0006\u0004\b\"\u0010#R\u0013\u0010%\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u0013\u0010'\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010\nR!\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\rR\u0016\u0010,\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010+R!\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010\rR!\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010\rR\u0013\u00102\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b1\u0010\nR\u0013\u00104\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b3\u0010\nR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0011R\u0013\u00109\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b8\u0010\n¨\u0006<"}, d2 = {"Lorg/kodein/di/Kodein$Key;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/kodein/di/TypeToken;", "component1", "()Lorg/kodein/di/TypeToken;", "component2", "component3", "component4", "()Ljava/lang/Object;", "contextType", "argType", "type", "tag", "copy", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lorg/kodein/di/Kodein$Key;", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "dispString", "", AuthSource.SEND_ABUSE, "(Ljava/lang/StringBuilder;Lkotlin/jvm/functions/Function1;)V", "getDescription", "description", "getFullDescription", "fullDescription", "d", "Lorg/kodein/di/TypeToken;", "getType", "I", "_hashCode", AuthSource.BOOKING_ORDER, "getContextType", "c", "getArgType", "getBindDescription", "bindDescription", "getBindFullDescription", "bindFullDescription", "e", "Ljava/lang/Object;", "getTag", "getInternalDescription", "internalDescription", "<init>", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Key<C, A, T> {
        public int a;
        @NotNull
        public final TypeToken<? super C> b;
        @NotNull
        public final TypeToken<? super A> c;
        @NotNull
        public final TypeToken<? extends T> d;
        @Nullable
        public final Object e;

        public static final /* synthetic */ class a extends FunctionReference implements Function1<TypeToken<? extends Object>, String> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public final String getName() {
                return "simpleDispString";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(TypeToken.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final String getSignature() {
                return "simpleDispString()Ljava/lang/String;";
            }

            @Override // kotlin.jvm.functions.Function1
            public String invoke(TypeToken<? extends Object> typeToken) {
                TypeToken<? extends Object> typeToken2 = typeToken;
                Intrinsics.checkParameterIsNotNull(typeToken2, "p1");
                return typeToken2.simpleDispString();
            }
        }

        public static final /* synthetic */ class b extends FunctionReference implements Function1<TypeToken<? extends Object>, String> {
            public static final b a = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public final String getName() {
                return "fullDispString";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(TypeToken.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final String getSignature() {
                return "fullDispString()Ljava/lang/String;";
            }

            @Override // kotlin.jvm.functions.Function1
            public String invoke(TypeToken<? extends Object> typeToken) {
                TypeToken<? extends Object> typeToken2 = typeToken;
                Intrinsics.checkParameterIsNotNull(typeToken2, "p1");
                return typeToken2.fullDispString();
            }
        }

        public Key(@NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? super A> typeToken2, @NotNull TypeToken<? extends T> typeToken3, @Nullable Object obj) {
            Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
            Intrinsics.checkParameterIsNotNull(typeToken2, "argType");
            Intrinsics.checkParameterIsNotNull(typeToken3, "type");
            this.b = typeToken;
            this.c = typeToken2;
            this.d = typeToken3;
            this.e = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.kodein.di.Kodein$Key */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Key copy$default(Key key, TypeToken typeToken, TypeToken typeToken2, TypeToken typeToken3, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                typeToken = key.b;
            }
            if ((i & 2) != 0) {
                typeToken2 = key.c;
            }
            if ((i & 4) != 0) {
                typeToken3 = key.d;
            }
            if ((i & 8) != 0) {
                obj = key.e;
            }
            return key.copy(typeToken, typeToken2, typeToken3, obj);
        }

        public final void a(@NotNull StringBuilder sb, Function1<? super TypeToken<?>, String> function1) {
            sb.append(" with ");
            if (!Intrinsics.areEqual(this.b, TypeTokenKt.getAnyToken())) {
                StringBuilder L = a2.b.a.a.a.L("?<");
                L.append(function1.invoke(this.b));
                L.append(">().");
                sb.append(L.toString());
            }
            sb.append("? { ");
            if (!Intrinsics.areEqual(this.c, TypeTokenKt.getUnitToken())) {
                sb.append(function1.invoke(this.c));
                sb.append(" -> ");
            }
            sb.append("? }");
        }

        @NotNull
        public final TypeToken<? super C> component1() {
            return this.b;
        }

        @NotNull
        public final TypeToken<? super A> component2() {
            return this.c;
        }

        @NotNull
        public final TypeToken<? extends T> component3() {
            return this.d;
        }

        @Nullable
        public final Object component4() {
            return this.e;
        }

        @NotNull
        public final Key<C, A, T> copy(@NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? super A> typeToken2, @NotNull TypeToken<? extends T> typeToken3, @Nullable Object obj) {
            Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
            Intrinsics.checkParameterIsNotNull(typeToken2, "argType");
            Intrinsics.checkParameterIsNotNull(typeToken3, "type");
            return new Key<>(typeToken, typeToken2, typeToken3, obj);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Intrinsics.areEqual(this.b, key.b) && Intrinsics.areEqual(this.c, key.c) && Intrinsics.areEqual(this.d, key.d) && Intrinsics.areEqual(this.e, key.e);
        }

        @NotNull
        public final TypeToken<? super A> getArgType() {
            return this.c;
        }

        @NotNull
        public final String getBindDescription() {
            StringBuilder L = a2.b.a.a.a.L("bind<");
            L.append(this.d.simpleDispString());
            L.append(">(");
            return a2.b.a.a.a.s(L, this.e != null ? a2.b.a.a.a.q(a2.b.a.a.a.L("tag = \""), this.e, Typography.quote) : "", ')');
        }

        @NotNull
        public final String getBindFullDescription() {
            StringBuilder L = a2.b.a.a.a.L("bind<");
            L.append(this.d.fullDispString());
            L.append(">(");
            return a2.b.a.a.a.s(L, this.e != null ? a2.b.a.a.a.q(a2.b.a.a.a.L("tag = \""), this.e, Typography.quote) : "", ')');
        }

        @NotNull
        public final TypeToken<? super C> getContextType() {
            return this.b;
        }

        @NotNull
        public final String getDescription() {
            StringBuilder sb = new StringBuilder();
            sb.append(getBindDescription());
            a(sb, a.a);
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        @NotNull
        public final String getFullDescription() {
            StringBuilder sb = new StringBuilder();
            sb.append(getBindFullDescription());
            a(sb, b.a);
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        @NotNull
        public final String getInternalDescription() {
            StringBuilder L = a2.b.a.a.a.L("(context: ");
            L.append(this.b.simpleDispString());
            L.append(", arg: ");
            L.append(this.c.simpleDispString());
            L.append(", type: ");
            L.append(this.d.simpleDispString());
            L.append(", tag: ");
            return a2.b.a.a.a.q(L, this.e, ')');
        }

        @Nullable
        public final Object getTag() {
            return this.e;
        }

        @NotNull
        public final TypeToken<? extends T> getType() {
            return this.d;
        }

        public int hashCode() {
            if (this.a == 0) {
                int hashCode = this.b.hashCode();
                this.a = hashCode;
                this.a = this.c.hashCode() + (hashCode * 31);
                int hashCode2 = this.d.hashCode() * 29;
                this.a = hashCode2;
                int i = hashCode2 * 23;
                Object obj = this.e;
                this.a = i + (obj != null ? obj.hashCode() : 0);
            }
            return this.a;
        }

        @NotNull
        public String toString() {
            return getDescription();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lorg/kodein/di/Kodein$KodeinDsl;", "", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    @Retention(RetentionPolicy.RUNTIME)
    @DslMarker
    public @interface KodeinDsl {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ+\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f8V@VX\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lorg/kodein/di/Kodein$MainBuilder;", "Lorg/kodein/di/Kodein$Builder;", "Lorg/kodein/di/Kodein;", "kodein", "", "allowOverride", "Lorg/kodein/di/Copy;", "copy", "", "extend", "(Lorg/kodein/di/Kodein;ZLorg/kodein/di/Copy;)V", "Lorg/kodein/di/DKodein;", "dkodein", "(Lorg/kodein/di/DKodein;ZLorg/kodein/di/Copy;)V", "", "Lorg/kodein/di/bindings/ExternalSource;", "getExternalSources", "()Ljava/util/List;", "externalSources", "getFullDescriptionOnError", "()Z", "setFullDescriptionOnError", "(Z)V", "fullDescriptionOnError", "value", "getExternalSource", "()Lorg/kodein/di/bindings/ExternalSource;", "setExternalSource", "(Lorg/kodein/di/bindings/ExternalSource;)V", "externalSource$annotations", "()V", "externalSource", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public interface MainBuilder extends Builder {
        void extend(@NotNull DKodein dKodein, boolean z, @NotNull Copy copy);

        void extend(@NotNull Kodein kodein, boolean z, @NotNull Copy copy);

        @Nullable
        ExternalSource getExternalSource();

        @NotNull
        List<ExternalSource> getExternalSources();

        boolean getFullDescriptionOnError();

        void setExternalSource(@Nullable ExternalSource externalSource);

        void setFullDescriptionOnError(boolean z);

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
        public static final class DefaultImpls {
            public static /* synthetic */ void extend$default(MainBuilder mainBuilder, Kodein kodein, boolean z, Copy copy, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        z = false;
                    }
                    if ((i & 4) != 0) {
                        copy = Copy.NonCached.INSTANCE;
                    }
                    mainBuilder.extend(kodein, z, copy);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: extend");
            }

            @Deprecated(message = "Use externalSources instead")
            public static /* synthetic */ void externalSource$annotations() {
            }

            @Nullable
            public static ExternalSource getExternalSource(MainBuilder mainBuilder) {
                return (ExternalSource) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mainBuilder.getExternalSources());
            }

            public static void setExternalSource(MainBuilder mainBuilder, @Nullable ExternalSource externalSource) {
                mainBuilder.getExternalSources().clear();
                if (externalSource != null) {
                    mainBuilder.getExternalSources().add(externalSource);
                }
            }

            public static /* synthetic */ void extend$default(MainBuilder mainBuilder, DKodein dKodein, boolean z, Copy copy, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        z = false;
                    }
                    if ((i & 4) != 0) {
                        copy = Copy.NonCached.INSTANCE;
                    }
                    mainBuilder.extend(dKodein, z, copy);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: extend");
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B<\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0004\b'\u0010(B,\b\u0017\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0004\b'\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J!\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJI\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R*\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u0004¨\u0006*"}, d2 = {"Lorg/kodein/di/Kodein$Module;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "Lkotlin/Function1;", "Lorg/kodein/di/Kodein$Builder;", "", "Lkotlin/ExtensionFunctionType;", "component4", "()Lkotlin/jvm/functions/Function1;", "name", "allowSilentOverride", "prefix", "init", "copy", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)Lorg/kodein/di/Kodein$Module;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "d", "Lkotlin/jvm/functions/Function1;", "getInit", AuthSource.BOOKING_ORDER, "Z", "getAllowSilentOverride", "c", "getPrefix", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(ZLkotlin/jvm/functions/Function1;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Module {
        @NotNull
        public final String a;
        public final boolean b;
        @NotNull
        public final String c;
        @NotNull
        public final Function1<Builder, Unit> d;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super org.kodein.di.Kodein$Builder, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public Module(@NotNull String str, boolean z, @NotNull String str2, @NotNull Function1<? super Builder, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "prefix");
            Intrinsics.checkParameterIsNotNull(function1, "init");
            this.a = str;
            this.b = z;
            this.c = str2;
            this.d = function1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.kodein.di.Kodein$Module */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Module copy$default(Module module, String str, boolean z, String str2, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = module.a;
            }
            if ((i & 2) != 0) {
                z = module.b;
            }
            if ((i & 4) != 0) {
                str2 = module.c;
            }
            if ((i & 8) != 0) {
                function1 = module.d;
            }
            return module.copy(str, z, str2, function1);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final Function1<Builder, Unit> component4() {
            return this.d;
        }

        @NotNull
        public final Module copy(@NotNull String str, boolean z, @NotNull String str2, @NotNull Function1<? super Builder, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "prefix");
            Intrinsics.checkParameterIsNotNull(function1, "init");
            return new Module(str, z, str2, function1);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Module) {
                    Module module = (Module) obj;
                    if (Intrinsics.areEqual(this.a, module.a)) {
                        if (!(this.b == module.b) || !Intrinsics.areEqual(this.c, module.c) || !Intrinsics.areEqual(this.d, module.d)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final boolean getAllowSilentOverride() {
            return this.b;
        }

        @NotNull
        public final Function1<Builder, Unit> getInit() {
            return this.d;
        }

        @NotNull
        public final String getName() {
            return this.a;
        }

        @NotNull
        public final String getPrefix() {
            return this.c;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.b;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = (hashCode + i2) * 31;
            String str2 = this.c;
            int hashCode2 = (i5 + (str2 != null ? str2.hashCode() : 0)) * 31;
            Function1<Builder, Unit> function1 = this.d;
            if (function1 != null) {
                i = function1.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Module(name=");
            L.append(this.a);
            L.append(", allowSilentOverride=");
            L.append(this.b);
            L.append(", prefix=");
            L.append(this.c);
            L.append(", init=");
            L.append(this.d);
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Module(String str, boolean z, String str2, Function1 function1, int i, j jVar) {
            this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? "" : str2, function1);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.WARNING, message = "You should name your modules, for debug purposes.", replaceWith = @ReplaceWith(expression = "Module(\"module name\", allowSilentOverride, init)", imports = {}))
        public Module(boolean z, @NotNull Function1<? super Builder, Unit> function1) {
            this("", z, "", function1);
            Intrinsics.checkParameterIsNotNull(function1, "init");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Module(boolean z, Function1 function1, int i, j jVar) {
            this((i & 1) != 0 ? false : z, function1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lorg/kodein/di/Kodein$NoResultException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lorg/kodein/di/SearchSpecs;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/SearchSpecs;", "getSearch", "()Lorg/kodein/di/SearchSpecs;", "search", "", "message", "<init>", "(Lorg/kodein/di/SearchSpecs;Ljava/lang/String;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class NoResultException extends RuntimeException {
        @NotNull
        public final SearchSpecs a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NoResultException(@NotNull SearchSpecs searchSpecs, @NotNull String str) {
            super(str);
            Intrinsics.checkParameterIsNotNull(searchSpecs, "search");
            Intrinsics.checkParameterIsNotNull(str, "message");
            this.a = searchSpecs;
        }

        @NotNull
        public final SearchSpecs getSearch() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0012\u0010\b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR%\u0010\b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lorg/kodein/di/Kodein$NotFoundException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lorg/kodein/di/Kodein$Key;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/Kodein$Key;", "getKey", "()Lorg/kodein/di/Kodein$Key;", "key", "", "message", "<init>", "(Lorg/kodein/di/Kodein$Key;Ljava/lang/String;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class NotFoundException extends RuntimeException {
        @NotNull
        public final Key<?, ?, ?> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotFoundException(@NotNull Key<?, ?, ?> key, @NotNull String str) {
            super(str);
            Intrinsics.checkParameterIsNotNull(key, "key");
            Intrinsics.checkParameterIsNotNull(str, "message");
            this.a = key;
        }

        @NotNull
        public final Key<?, ?, ?> getKey() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lorg/kodein/di/Kodein$OverridingException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "message", "<init>", "(Ljava/lang/String;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class OverridingException extends RuntimeException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OverridingException(@NotNull String str) {
            super(str);
            Intrinsics.checkParameterIsNotNull(str, "message");
        }
    }

    @NotNull
    KodeinContainer getContainer();

    @Override // org.kodein.di.KodeinAware
    @NotNull
    Kodein getKodein();
}
