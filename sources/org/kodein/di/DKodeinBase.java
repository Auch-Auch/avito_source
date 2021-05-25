package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JU\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\t*\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000f\u0010\u0010JW\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\t*\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0011\u0010\u0010J9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0013\u0010\u0014J]\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\t*\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&¢\u0006\u0004\b\u0013\u0010\u0016J;\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0017\u0010\u0014J_\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\t*\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&¢\u0006\u0004\b\u0017\u0010\u0016J3\u0010\u0018\u001a\u00028\u0000\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0018\u0010\u0019JQ\u0010\u0018\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\t*\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00028\u0000H&¢\u0006\u0004\b\u0018\u0010\u001aJ5\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u001b\u0010\u0019JS\u0010\u001b\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\t*\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00028\u0000H&¢\u0006\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0016\u0010%\u001a\u00020\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lorg/kodein/di/DKodeinBase;", "Lorg/kodein/di/DKodeinAware;", "Lorg/kodein/di/KodeinContext;", "context", "Lorg/kodein/di/DKodein;", "On", "(Lorg/kodein/di/KodeinContext;)Lorg/kodein/di/DKodein;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/TypeToken;", "argType", "type", "tag", "Lkotlin/Function1;", "Factory", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "FactoryOrNull", "Lkotlin/Function0;", "Provider", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lkotlin/jvm/functions/Function0;", "arg", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lkotlin/jvm/functions/Function0;", "ProviderOrNull", "Instance", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/lang/Object;", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "InstanceOrNull", "Lorg/kodein/di/Kodein;", "getLazy", "()Lorg/kodein/di/Kodein;", "lazy", "getKodein", "kodein", "Lorg/kodein/di/KodeinContainer;", "getContainer", "()Lorg/kodein/di/KodeinContainer;", "container", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface DKodeinBase extends DKodeinAware {
    @NotNull
    <A, T> Function1<A, T> Factory(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj);

    @Nullable
    <A, T> Function1<A, T> FactoryOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj);

    @NotNull
    <T> T Instance(@NotNull TypeToken<T> typeToken, @Nullable Object obj);

    @NotNull
    <A, T> T Instance(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a);

    @Nullable
    <T> T InstanceOrNull(@NotNull TypeToken<T> typeToken, @Nullable Object obj);

    @Nullable
    <A, T> T InstanceOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a);

    @NotNull
    DKodein On(@NotNull KodeinContext<?> kodeinContext);

    @NotNull
    <T> Function0<T> Provider(@NotNull TypeToken<T> typeToken, @Nullable Object obj);

    @NotNull
    <A, T> Function0<T> Provider(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0);

    @Nullable
    <T> Function0<T> ProviderOrNull(@NotNull TypeToken<T> typeToken, @Nullable Object obj);

    @Nullable
    <A, T> Function0<T> ProviderOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0);

    @NotNull
    KodeinContainer getContainer();

    @NotNull
    Kodein getKodein();

    @NotNull
    Kodein getLazy();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ Function1 Factory$default(DKodeinBase dKodeinBase, TypeToken typeToken, TypeToken typeToken2, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                return dKodeinBase.Factory(typeToken, typeToken2, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: Factory");
        }

        public static /* synthetic */ Function1 FactoryOrNull$default(DKodeinBase dKodeinBase, TypeToken typeToken, TypeToken typeToken2, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                return dKodeinBase.FactoryOrNull(typeToken, typeToken2, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: FactoryOrNull");
        }

        public static /* synthetic */ Object Instance$default(DKodeinBase dKodeinBase, TypeToken typeToken, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    obj = null;
                }
                return dKodeinBase.Instance(typeToken, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: Instance");
        }

        public static /* synthetic */ Object InstanceOrNull$default(DKodeinBase dKodeinBase, TypeToken typeToken, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    obj = null;
                }
                return dKodeinBase.InstanceOrNull(typeToken, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: InstanceOrNull");
        }

        public static /* synthetic */ Function0 Provider$default(DKodeinBase dKodeinBase, TypeToken typeToken, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    obj = null;
                }
                return dKodeinBase.Provider(typeToken, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: Provider");
        }

        public static /* synthetic */ Function0 ProviderOrNull$default(DKodeinBase dKodeinBase, TypeToken typeToken, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    obj = null;
                }
                return dKodeinBase.ProviderOrNull(typeToken, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ProviderOrNull");
        }

        @NotNull
        public static Kodein getKodein(DKodeinBase dKodeinBase) {
            return dKodeinBase.getLazy();
        }

        public static /* synthetic */ Object Instance$default(DKodeinBase dKodeinBase, TypeToken typeToken, TypeToken typeToken2, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                return dKodeinBase.Instance(typeToken, typeToken2, obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: Instance");
        }

        public static /* synthetic */ Object InstanceOrNull$default(DKodeinBase dKodeinBase, TypeToken typeToken, TypeToken typeToken2, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                return dKodeinBase.InstanceOrNull(typeToken, typeToken2, obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: InstanceOrNull");
        }

        public static /* synthetic */ Function0 Provider$default(DKodeinBase dKodeinBase, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                return dKodeinBase.Provider(typeToken, typeToken2, obj, function0);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: Provider");
        }

        public static /* synthetic */ Function0 ProviderOrNull$default(DKodeinBase dKodeinBase, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                return dKodeinBase.ProviderOrNull(typeToken, typeToken2, obj, function0);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ProviderOrNull");
        }
    }
}
