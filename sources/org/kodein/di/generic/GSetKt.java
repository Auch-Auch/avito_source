package org.kodein.di.generic;

import androidx.exifinterface.media.ExifInterface;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.TypeReference;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.ArgSetBinding;
import org.kodein.di.bindings.SetBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u001a.\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a<\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0006\b\u0000\u0010\u0006\u0018\u0001\"\n\b\u0001\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\b\u0010\t\u001a8\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\nH\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "T", "Lorg/kodein/di/Kodein$Builder;", "Lorg/kodein/di/bindings/SetBinding;", "setBinding", "(Lorg/kodein/di/Kodein$Builder;)Lorg/kodein/di/bindings/SetBinding;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lorg/kodein/di/bindings/ArgSetBinding;", "argSetBinding", "(Lorg/kodein/di/Kodein$Builder;)Lorg/kodein/di/bindings/ArgSetBinding;", "Lorg/kodein/di/Kodein$Builder$TypeBinder;", "Lorg/kodein/di/bindings/TypeBinderInSet;", "", "inSet", "(Lorg/kodein/di/Kodein$Builder$TypeBinder;)Lorg/kodein/di/bindings/TypeBinderInSet;", "kodein-di-generic-jvm"}, k = 2, mv = {1, 4, 0})
public final class GSetKt {
    @NotNull
    public static final /* synthetic */ <A, T> ArgSetBinding<Object, A, T> argSetBinding(@NotNull Kodein.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$argSetBinding");
        TypeToken<Object> anyToken = TypeTokenKt.getAnyToken();
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GSetKt$argSetBinding$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new ArgSetBinding<>(anyToken, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GSetKt$argSetBinding$$inlined$generic$2
        }), TypesKt.TT(new TypeReference<Set<? extends T>>() { // from class: org.kodein.di.generic.GSetKt$argSetBinding$$inlined$generic$3
        }));
    }

    @NotNull
    public static final /* synthetic */ <T> SetBinding<Object, T> setBinding(@NotNull Kodein.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$setBinding");
        TypeToken<Object> anyToken = TypeTokenKt.getAnyToken();
        Intrinsics.needClassReification();
        return new SetBinding<>(anyToken, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GSetKt$setBinding$$inlined$generic$1
        }), TypesKt.TT(new TypeReference<Set<? extends T>>() { // from class: org.kodein.di.generic.GSetKt$setBinding$$inlined$generic$2
        }));
    }
}
