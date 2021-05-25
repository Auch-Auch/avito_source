package org.kodein.di.bindings;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.TypeToken;
import org.kodein.di.bindings.KodeinBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005B\\\u0012\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0015\u0012\u000e\u0010 \u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0015\u0012\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u0015\u0012#\u0010\u0014\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010¢\u0006\u0002\b\u0011¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJC\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR3\u0010\u0014\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010¢\u0006\u0002\b\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R$\u0010 \u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019¨\u0006#"}, d2 = {"Lorg/kodein/di/bindings/Factory;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/bindings/KodeinBinding;", "", "factoryName", "()Ljava/lang/String;", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "key", "Lkotlin/Function1;", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "d", "Lkotlin/jvm/functions/Function2;", "creator", "Lorg/kodein/di/TypeToken;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getContextType", "()Lorg/kodein/di/TypeToken;", "contextType", "c", "getCreatedType", "createdType", AuthSource.BOOKING_ORDER, "getArgType", "argType", "<init>", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function2;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class Factory<C, A, T> implements KodeinBinding<C, A, T> {
    @NotNull
    public final TypeToken<? super C> a;
    @NotNull
    public final TypeToken<? super A> b;
    @NotNull
    public final TypeToken<? extends T> c;
    public final Function2<BindingKodein<? extends C>, A, T> d;

    public static final class a extends Lambda implements Function1<A, T> {
        public final /* synthetic */ Factory a;
        public final /* synthetic */ BindingKodein b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Factory factory, BindingKodein bindingKodein) {
            super(1);
            this.a = factory;
            this.b = bindingKodein;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final T invoke(A a3) {
            return (T) this.a.d.invoke(this.b, a3);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super org.kodein.di.bindings.BindingKodein<? extends C>, ? super A, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Factory(@NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? super A> typeToken2, @NotNull TypeToken<? extends T> typeToken3, @NotNull Function2<? super BindingKodein<? extends C>, ? super A, ? extends T> function2) {
        Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken3, "createdType");
        Intrinsics.checkParameterIsNotNull(function2, "creator");
        this.a = typeToken;
        this.b = typeToken2;
        this.c = typeToken3;
        this.d = function2;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryFullName() {
        return KodeinBinding.DefaultImpls.factoryFullName(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryName() {
        return "factory";
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super A> getArgType() {
        return this.b;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super C> getContextType() {
        return this.a;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @Nullable
    public KodeinBinding.Copier<C, A, T> getCopier() {
        return KodeinBinding.DefaultImpls.getCopier(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? extends T> getCreatedType() {
        return this.c;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getDescription() {
        return KodeinBinding.DefaultImpls.getDescription(this);
    }

    @Override // org.kodein.di.bindings.Binding
    @NotNull
    public Function1<A, T> getFactory(@NotNull BindingKodein<? extends C> bindingKodein, @NotNull Kodein.Key<? super C, ? super A, ? extends T> key) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "kodein");
        Intrinsics.checkParameterIsNotNull(key, "key");
        return new a(this, bindingKodein);
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
        return KodeinBinding.DefaultImpls.getSupportSubTypes(this);
    }
}
