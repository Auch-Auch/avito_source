package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.DKodeinBase;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J[\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\t\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000e\u0010\u000fJc\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\t\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\rH&¢\u0006\u0004\b\u000e\u0010\u0011J9\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0012\u0010\u000fJW\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lorg/kodein/di/DKodein;", "Lorg/kodein/di/DKodeinBase;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/TypeToken;", "argType", "type", "tag", "", "Lkotlin/Function1;", "AllFactories", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/util/List;", "Lkotlin/Function0;", "AllProviders", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/util/List;", "arg", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/util/List;", "AllInstances", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface DKodein extends DKodeinBase {
    @NotNull
    <A, T> List<Function1<A, T>> AllFactories(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj);

    @NotNull
    <T> List<T> AllInstances(@NotNull TypeToken<T> typeToken, @Nullable Object obj);

    @NotNull
    <A, T> List<T> AllInstances(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a);

    @NotNull
    <T> List<Function0<T>> AllProviders(@NotNull TypeToken<T> typeToken, @Nullable Object obj);

    @NotNull
    <A, T> List<Function0<T>> AllProviders(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ List AllFactories$default(DKodein dKodein, TypeToken typeToken, TypeToken typeToken2, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                return dKodein.AllFactories(typeToken, typeToken2, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: AllFactories");
        }

        public static /* synthetic */ List AllInstances$default(DKodein dKodein, TypeToken typeToken, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    obj = null;
                }
                return dKodein.AllInstances(typeToken, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: AllInstances");
        }

        public static /* synthetic */ List AllProviders$default(DKodein dKodein, TypeToken typeToken, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    obj = null;
                }
                return dKodein.AllProviders(typeToken, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: AllProviders");
        }

        @NotNull
        public static Kodein getKodein(DKodein dKodein) {
            return DKodeinBase.DefaultImpls.getKodein(dKodein);
        }

        public static /* synthetic */ List AllInstances$default(DKodein dKodein, TypeToken typeToken, TypeToken typeToken2, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                return dKodein.AllInstances(typeToken, typeToken2, obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: AllInstances");
        }

        public static /* synthetic */ List AllProviders$default(DKodein dKodein, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                return dKodein.AllProviders(typeToken, typeToken2, obj, function0);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: AllProviders");
        }
    }
}
