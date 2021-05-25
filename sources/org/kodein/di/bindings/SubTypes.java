package org.kodein.di.bindings;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.AbstractMap;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.TypeToken;
import org.kodein.di.bindings.KodeinBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005Bk\u0012\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0011\u0012\u000e\u0010&\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0011\u0012\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u0011\u00122\u0010#\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u0011\u0012\u001c\u0012\u001a\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0001\u0012\u00028\u00020\u00050\n¢\u0006\u0004\b*\u0010+JC\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fRr\u0010\u0015\u001a^\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u0011\u0012\u001c\u0012\u001a\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0001\u0012\u00028\u00020\u00050\u0010j.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u0011\u0012\u001c\u0012\u001a\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0001\u0012\u00028\u00020\u0005`\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001e\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dRE\u0010#\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u0011\u0012\u001c\u0012\u001a\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0006\b\u0001\u0012\u00028\u00020\u00050\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010&\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001dR$\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\u001d¨\u0006,"}, d2 = {"Lorg/kodein/di/bindings/SubTypes;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/bindings/KodeinBinding;", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "key", "Lkotlin/Function1;", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "", "factoryName", "()Ljava/lang/String;", "Ljava/util/HashMap;", "Lorg/kodein/di/TypeToken;", "Lkotlin/collections/HashMap;", AuthSource.SEND_ABUSE, "Ljava/util/HashMap;", "bindings", "", "getSupportSubTypes", "()Z", "supportSubTypes", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/TypeToken;", "getContextType", "()Lorg/kodein/di/TypeToken;", "contextType", "e", "Lkotlin/jvm/functions/Function1;", "getBlock", "()Lkotlin/jvm/functions/Function1;", "block", "c", "getArgType", "argType", "d", "getCreatedType", "createdType", "<init>", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function1;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class SubTypes<C, A, T> implements KodeinBinding<C, A, T> {
    public final HashMap<TypeToken<? extends T>, KodeinBinding<? super C, ? super A, ? extends T>> a = new HashMap<>();
    @NotNull
    public final TypeToken<? super C> b;
    @NotNull
    public final TypeToken<? super A> c;
    @NotNull
    public final TypeToken<? extends T> d;
    @NotNull
    public final Function1<TypeToken<? extends T>, KodeinBinding<? super C, ? super A, ? extends T>> e;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super org.kodein.di.TypeToken<? extends T>, ? extends org.kodein.di.bindings.KodeinBinding<? super C, ? super A, ? extends T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public SubTypes(@NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? super A> typeToken2, @NotNull TypeToken<? extends T> typeToken3, @NotNull Function1<? super TypeToken<? extends T>, ? extends KodeinBinding<? super C, ? super A, ? extends T>> function1) {
        Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken3, "createdType");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        this.b = typeToken;
        this.c = typeToken2;
        this.d = typeToken3;
        this.e = function1;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryFullName() {
        return KodeinBinding.DefaultImpls.factoryFullName(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryName() {
        return "subTypesBindings";
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super A> getArgType() {
        return this.c;
    }

    @NotNull
    public final Function1<TypeToken<? extends T>, KodeinBinding<? super C, ? super A, ? extends T>> getBlock() {
        return this.e;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super C> getContextType() {
        return this.b;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @Nullable
    public KodeinBinding.Copier<C, A, T> getCopier() {
        return KodeinBinding.DefaultImpls.getCopier(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? extends T> getCreatedType() {
        return this.d;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getDescription() {
        return KodeinBinding.DefaultImpls.getDescription(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: kotlin.jvm.functions.Function1<org.kodein.di.TypeToken<? extends T>, org.kodein.di.bindings.KodeinBinding<? super C, ? super A, ? extends T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.kodein.di.bindings.Binding
    @NotNull
    public Function1<A, T> getFactory(@NotNull BindingKodein<? extends C> bindingKodein, @NotNull Kodein.Key<? super C, ? super A, ? extends T> key) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "kodein");
        Intrinsics.checkParameterIsNotNull(key, "key");
        AbstractMap abstractMap = (HashMap<TypeToken<? extends T>, KodeinBinding<? super C, ? super A, ? extends T>>) this.a;
        TypeToken<? extends Object> type = key.getType();
        Object obj = abstractMap.get(type);
        if (obj == null) {
            obj = (KodeinBinding) this.e.invoke(key.getType());
            abstractMap.put(type, obj);
        }
        if (obj != null) {
            return ((Binding) obj).getFactory(bindingKodein, key);
        }
        throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.bindings.Binding<C, A, T>");
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getFullDescription() {
        return KodeinBinding.DefaultImpls.getFullDescription(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @Nullable
    public Scope<C> getScope() {
        return KodeinBinding.DefaultImpls.getScope(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    public boolean getSupportSubTypes() {
        return true;
    }
}
