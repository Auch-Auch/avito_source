package org.kodein.di.bindings;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinDefining;
import org.kodein.di.TypeToken;
import org.kodein.di.internal.KodeinBuilderImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B%\b\u0000\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u0012\u0010\u0013J2\u0010\b\u001a\u00020\u0007\"\u0004\b\u0002\u0010\u00042\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0004¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\b@\bX\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lorg/kodein/di/bindings/TypeBinderInSet;", "", "T", ExifInterface.LATITUDE_SOUTH, "C", "Lorg/kodein/di/bindings/KodeinBinding;", "binding", "", "with", "(Lorg/kodein/di/bindings/KodeinBinding;)V", "Lorg/kodein/di/TypeToken;", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/TypeToken;", "_colTypeToken", "Lorg/kodein/di/Kodein$Builder$TypeBinder;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/Kodein$Builder$TypeBinder;", "_binder", "<init>", "(Lorg/kodein/di/Kodein$Builder$TypeBinder;Lorg/kodein/di/TypeToken;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class TypeBinderInSet<T, S> {
    public final Kodein.Builder.TypeBinder<T> a;
    public final TypeToken<S> b;

    public TypeBinderInSet(@NotNull Kodein.Builder.TypeBinder<T> typeBinder, @NotNull TypeToken<S> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeBinder, "_binder");
        Intrinsics.checkParameterIsNotNull(typeToken, "_colTypeToken");
        this.a = typeBinder;
        this.b = typeToken;
    }

    public final <C> void with(@NotNull KodeinBinding<? super C, ?, ? extends T> kodeinBinding) {
        KodeinDefining kodeinDefining;
        Intrinsics.checkParameterIsNotNull(kodeinBinding, "binding");
        Kodein.Builder.TypeBinder<T> typeBinder = this.a;
        if (typeBinder != null) {
            KodeinBuilderImpl.TypeBinder typeBinder2 = (KodeinBuilderImpl.TypeBinder) typeBinder;
            Kodein.Key key = new Kodein.Key(kodeinBinding.getContextType(), kodeinBinding.getArgType(), this.b, ((KodeinBuilderImpl.TypeBinder) this.a).getTag());
            List<KodeinDefining<?, ?, ?>> list = ((KodeinBuilderImpl.TypeBinder) this.a).getContainerBuilder$kodein_di_core().getBindingsMap$kodein_di_core().get(key);
            if (list == null || (kodeinDefining = (KodeinDefining) CollectionsKt___CollectionsKt.first((List<? extends Object>) list)) == null) {
                throw new IllegalStateException("No set binding to " + key);
            }
            KodeinBinding binding = kodeinDefining.getBinding();
            if (!(binding instanceof BaseMultiBinding)) {
                binding = null;
            }
            if (((BaseMultiBinding) binding) != null) {
                Set set$kodein_di_core = ((BaseMultiBinding) kodeinDefining.getBinding()).getSet$kodein_di_core();
                if (set$kodein_di_core != null) {
                    TypeIntrinsics.asMutableSet(set$kodein_di_core).add(kodeinBinding);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<org.kodein.di.bindings.KodeinBinding<*, *, *>>");
            }
            throw new IllegalStateException(key + " is associated to a " + kodeinDefining.getBinding().factoryName() + " while it should be associated with bindingSet");
        }
        throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.internal.KodeinBuilderImpl.TypeBinder<T>");
    }
}
