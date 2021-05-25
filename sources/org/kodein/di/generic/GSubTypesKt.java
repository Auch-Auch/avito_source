package org.kodein.di.generic;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.TypeReference;
import org.kodein.di.TypeToken;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.KodeinBinding;
import org.kodein.di.bindings.TypeBinderSubTypes;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001al\u0010\n\u001a\u00020\t\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\n\b\u0002\u0010\u0003\u0018\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u00028\u00020\u000424\b\b\u0010\b\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0001\u0012\u00028\u00020\u00070\u0005H\f¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/bindings/TypeBinderSubTypes;", "Lkotlin/Function1;", "Lorg/kodein/di/TypeToken;", "Lorg/kodein/di/bindings/KodeinBinding;", "block", "", "with", "(Lorg/kodein/di/bindings/TypeBinderSubTypes;Lkotlin/jvm/functions/Function1;)V", "kodein-di-generic-jvm"}, k = 2, mv = {1, 4, 0})
public final class GSubTypesKt {
    public static final /* synthetic */ <C, A, T> void with(@NotNull TypeBinderSubTypes<T> typeBinderSubTypes, @NotNull Function1<? super TypeToken<? extends T>, ? extends KodeinBinding<? super C, ? super A, ? extends T>> function1) {
        Intrinsics.checkParameterIsNotNull(typeBinderSubTypes, "$this$with");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Intrinsics.needClassReification();
        TypeToken<? super C> TT = TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GSubTypesKt$with$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        TypeToken<? super A> TT2 = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GSubTypesKt$with$$inlined$generic$2
        });
        Intrinsics.needClassReification();
        typeBinderSubTypes.With(TT, TT2, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GSubTypesKt$with$$inlined$generic$3
        }), function1);
    }
}
