package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.a {
    public final SavedStateRegistry a;
    public final Lifecycle b;
    public final Bundle c;

    public AbstractSavedStateViewModelFactory(@NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        this.a = savedStateRegistryOwner.getSavedStateRegistry();
        this.b = savedStateRegistryOwner.getLifecycle();
        this.c = bundle;
    }

    @Override // androidx.lifecycle.ViewModelProvider.b
    public void a(@NonNull ViewModel viewModel) {
        SavedStateHandleController.a(viewModel, this.a, this.b);
    }

    @Override // androidx.lifecycle.ViewModelProvider.a
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls) {
        SavedStateHandleController c2 = SavedStateHandleController.c(this.a, this.b, str, this.c);
        T t = (T) create(str, cls, c2.c);
        t.b("androidx.lifecycle.savedstate.vm.tag", c2);
        return t;
    }

    @NonNull
    public abstract <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls, @NonNull SavedStateHandle savedStateHandle);

    @Override // androidx.lifecycle.ViewModelProvider.a, androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public final <T extends ViewModel> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
