package org.kodein.di.bindings;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.TypeToken;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\b\u0000\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0013\u0010\u0014J}\u0010\r\u001a\u00020\f\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000522\u0010\u000b\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\u001c\u0012\u001a\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0006\b\u0001\u0012\u00028\u00000\n0\t¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lorg/kodein/di/bindings/TypeBinderSubTypes;", "", "T", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lorg/kodein/di/TypeToken;", "contextType", "argType", "createdType", "Lkotlin/Function1;", "Lorg/kodein/di/bindings/KodeinBinding;", "block", "", "With", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function1;)V", "Lorg/kodein/di/Kodein$Builder$TypeBinder;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/Kodein$Builder$TypeBinder;", "_binder", "<init>", "(Lorg/kodein/di/Kodein$Builder$TypeBinder;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class TypeBinderSubTypes<T> {
    public final Kodein.Builder.TypeBinder<T> a;

    public TypeBinderSubTypes(@NotNull Kodein.Builder.TypeBinder<T> typeBinder) {
        Intrinsics.checkParameterIsNotNull(typeBinder, "_binder");
        this.a = typeBinder;
    }

    public final <C, A> void With(@NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? super A> typeToken2, @NotNull TypeToken<? extends T> typeToken3, @NotNull Function1<? super TypeToken<? extends T>, ? extends KodeinBinding<? super C, ? super A, ? extends T>> function1) {
        Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken3, "createdType");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        this.a.with(new SubTypes(typeToken, typeToken2, typeToken3, function1));
    }
}
