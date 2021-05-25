package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.util.preferences.GeoContract;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.bindings.ContextTranslator;
import org.kodein.di.bindings.KodeinBinding;
import t6.n.e;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001bJ]\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0004*\u00020\u00012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ_\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0004*\u00020\u00012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\fJc\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0004*\u00020\u00012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0010JQ\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0004*\u00020\u00012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014JS\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0004*\u00020\u00012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0014JW\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00120\u000e\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0004*\u00020\u00012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0010R\u0016\u0010\u001a\u001a\u00020\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lorg/kodein/di/KodeinContainer;", "", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "T", "Lorg/kodein/di/Kodein$Key;", "key", "context", "", "overrideLevel", "Lkotlin/Function1;", "factory", "(Lorg/kodein/di/Kodein$Key;Ljava/lang/Object;I)Lkotlin/jvm/functions/Function1;", "factoryOrNull", "", "allFactories", "(Lorg/kodein/di/Kodein$Key;Ljava/lang/Object;I)Ljava/util/List;", "", "Lkotlin/Function0;", GeoContract.PROVIDER, "(Lorg/kodein/di/Kodein$Key;Ljava/lang/Object;I)Lkotlin/jvm/functions/Function0;", "providerOrNull", "allProviders", "Lorg/kodein/di/KodeinTree;", "getTree", "()Lorg/kodein/di/KodeinTree;", "tree", "Builder", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface KodeinContainer {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001Jw\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0004*\u00020\u00012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u001e\u0010\b\u001a\u001a\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0001\u0012\u00028\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u001a\b\u0002\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000bH&¢\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u001e\u001a\u00020\r2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u001a¢\u0006\u0002\b\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\r2\u000e\u0010!\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 H&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lorg/kodein/di/KodeinContainer$Builder;", "", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "T", "Lorg/kodein/di/Kodein$Key;", "key", "Lorg/kodein/di/bindings/KodeinBinding;", "binding", "", "fromModule", "", "overrides", "", "bind", "(Lorg/kodein/di/Kodein$Key;Lorg/kodein/di/bindings/KodeinBinding;Ljava/lang/String;Ljava/lang/Boolean;)V", "Lorg/kodein/di/KodeinContainer;", "container", "allowOverride", "", "copy", "extend", "(Lorg/kodein/di/KodeinContainer;ZLjava/util/Set;)V", "silentOverride", "subBuilder", "(ZZ)Lorg/kodein/di/KodeinContainer$Builder;", "Lkotlin/Function1;", "Lorg/kodein/di/DKodein;", "Lkotlin/ExtensionFunctionType;", "cb", "onReady", "(Lkotlin/jvm/functions/Function1;)V", "Lorg/kodein/di/bindings/ContextTranslator;", "translator", "registerContextTranslator", "(Lorg/kodein/di/bindings/ContextTranslator;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public interface Builder {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
        public static final class DefaultImpls {
            public static /* synthetic */ void bind$default(Builder builder, Kodein.Key key, KodeinBinding kodeinBinding, String str, Boolean bool, int i, Object obj) {
                if (obj == null) {
                    if ((i & 4) != 0) {
                        str = null;
                    }
                    if ((i & 8) != 0) {
                        bool = null;
                    }
                    builder.bind(key, kodeinBinding, str, bool);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bind");
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.kodein.di.KodeinContainer$Builder */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void extend$default(Builder builder, KodeinContainer kodeinContainer, boolean z, Set set, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        z = false;
                    }
                    if ((i & 4) != 0) {
                        set = y.emptySet();
                    }
                    builder.extend(kodeinContainer, z, set);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: extend");
            }

            public static /* synthetic */ Builder subBuilder$default(Builder builder, boolean z, boolean z2, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        z = false;
                    }
                    if ((i & 2) != 0) {
                        z2 = false;
                    }
                    return builder.subBuilder(z, z2);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subBuilder");
            }
        }

        <C, A, T> void bind(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key, @NotNull KodeinBinding<? super C, ? super A, ? extends T> kodeinBinding, @Nullable String str, @Nullable Boolean bool);

        void extend(@NotNull KodeinContainer kodeinContainer, boolean z, @NotNull Set<? extends Kodein.Key<?, ?, ?>> set);

        void onReady(@NotNull Function1<? super DKodein, Unit> function1);

        void registerContextTranslator(@NotNull ContextTranslator<?, ?> contextTranslator);

        @NotNull
        Builder subBuilder(boolean z, boolean z2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ List allFactories$default(KodeinContainer kodeinContainer, Kodein.Key key, Object obj, int i, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                return kodeinContainer.allFactories(key, obj, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: allFactories");
        }

        @NotNull
        public static <C, T> List<Function0<T>> allProviders(KodeinContainer kodeinContainer, @NotNull Kodein.Key<? super C, ? super Unit, ? extends T> key, C c, int i) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            List<T> allFactories$default = allFactories$default(kodeinContainer, key, c, 0, 4, null);
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(allFactories$default, 10));
            for (T t : allFactories$default) {
                arrayList.add(new KodeinContainer$$special$$inlined$toProvider$1(t));
            }
            return arrayList;
        }

        public static /* synthetic */ List allProviders$default(KodeinContainer kodeinContainer, Kodein.Key key, Object obj, int i, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                return kodeinContainer.allProviders(key, obj, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: allProviders");
        }

        public static /* synthetic */ Function1 factory$default(KodeinContainer kodeinContainer, Kodein.Key key, Object obj, int i, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                return kodeinContainer.factory(key, obj, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: factory");
        }

        public static /* synthetic */ Function1 factoryOrNull$default(KodeinContainer kodeinContainer, Kodein.Key key, Object obj, int i, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                return kodeinContainer.factoryOrNull(key, obj, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: factoryOrNull");
        }

        @NotNull
        public static <C, T> Function0<T> provider(KodeinContainer kodeinContainer, @NotNull Kodein.Key<? super C, ? super Unit, ? extends T> key, C c, int i) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return new KodeinContainer$provider$$inlined$toProvider$1(factory$default(kodeinContainer, key, c, 0, 4, null));
        }

        public static /* synthetic */ Function0 provider$default(KodeinContainer kodeinContainer, Kodein.Key key, Object obj, int i, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                return kodeinContainer.provider(key, obj, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: provider");
        }

        @Nullable
        public static <C, T> Function0<T> providerOrNull(KodeinContainer kodeinContainer, @NotNull Kodein.Key<? super C, ? super Unit, ? extends T> key, C c, int i) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            Function1 factoryOrNull$default = factoryOrNull$default(kodeinContainer, key, c, 0, 4, null);
            if (factoryOrNull$default != null) {
                return new KodeinContainer$providerOrNull$$inlined$toProvider$1(factoryOrNull$default);
            }
            return null;
        }

        public static /* synthetic */ Function0 providerOrNull$default(KodeinContainer kodeinContainer, Kodein.Key key, Object obj, int i, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                return kodeinContainer.providerOrNull(key, obj, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: providerOrNull");
        }
    }

    @NotNull
    <C, A, T> List<Function1<A, T>> allFactories(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key, C c, int i);

    @NotNull
    <C, T> List<Function0<T>> allProviders(@NotNull Kodein.Key<? super C, ? super Unit, ? extends T> key, C c, int i);

    @NotNull
    <C, A, T> Function1<A, T> factory(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key, C c, int i);

    @Nullable
    <C, A, T> Function1<A, T> factoryOrNull(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key, C c, int i);

    @NotNull
    KodeinTree getTree();

    @NotNull
    <C, T> Function0<T> provider(@NotNull Kodein.Key<? super C, ? super Unit, ? extends T> key, C c, int i);

    @Nullable
    <C, T> Function0<T> providerOrNull(@NotNull Kodein.Key<? super C, ? super Unit, ? extends T> key, C c, int i);
}
