package org.kodein.di.bindings;

import androidx.exifinterface.media.ExifInterface;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.bindings.KodeinBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0004*\u00020\u00032\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00060\u0005B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR.\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00050\n8 @ X \u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lorg/kodein/di/bindings/BaseMultiBinding;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/bindings/KodeinBinding;", "", "", "factoryName", "()Ljava/lang/String;", "", "getSet$kodein_di_core", "()Ljava/util/Set;", "set", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public abstract class BaseMultiBinding<C, A, T> implements KodeinBinding<C, A, Set<? extends T>> {
    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryFullName() {
        return KodeinBinding.DefaultImpls.factoryFullName(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryName() {
        return "bindingSet";
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @Nullable
    public KodeinBinding.Copier<C, A, Set<T>> getCopier() {
        return KodeinBinding.DefaultImpls.getCopier(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getDescription() {
        return KodeinBinding.DefaultImpls.getDescription(this);
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

    @NotNull
    public abstract Set<KodeinBinding<C, A, T>> getSet$kodein_di_core();

    @Override // org.kodein.di.bindings.KodeinBinding
    public boolean getSupportSubTypes() {
        return KodeinBinding.DefaultImpls.getSupportSubTypes(this);
    }
}
