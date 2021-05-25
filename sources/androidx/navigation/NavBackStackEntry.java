package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.UUID;
import l6.r.b;
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public final Context a;
    public final NavDestination b;
    public final Bundle c;
    public final LifecycleRegistry d;
    public final SavedStateRegistryController e;
    @NonNull
    public final UUID f;
    public Lifecycle.State g;
    public Lifecycle.State h;
    public b i;
    public ViewModelProvider.Factory j;

    public NavBackStackEntry(@NonNull Context context, @NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable LifecycleOwner lifecycleOwner, @Nullable b bVar) {
        this(context, navDestination, bundle, lifecycleOwner, bVar, UUID.randomUUID(), null);
    }

    public final void a() {
        if (this.g.ordinal() < this.h.ordinal()) {
            this.d.setCurrentState(this.g);
        } else {
            this.d.setCurrentState(this.h);
        }
    }

    @Nullable
    public Bundle getArguments() {
        return this.c;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.j == null) {
            this.j = new SavedStateViewModelFactory((Application) this.a.getApplicationContext(), this, this.c);
        }
        return this.j;
    }

    @NonNull
    public NavDestination getDestination() {
        return this.b;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.d;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.e.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        b bVar = this.i;
        if (bVar != null) {
            UUID uuid = this.f;
            ViewModelStore viewModelStore = bVar.c.get(uuid);
            if (viewModelStore != null) {
                return viewModelStore;
            }
            ViewModelStore viewModelStore2 = new ViewModelStore();
            bVar.c.put(uuid, viewModelStore2);
            return viewModelStore2;
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    public NavBackStackEntry(@NonNull Context context, @NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable LifecycleOwner lifecycleOwner, @Nullable b bVar, @NonNull UUID uuid, @Nullable Bundle bundle2) {
        this.d = new LifecycleRegistry(this);
        SavedStateRegistryController create = SavedStateRegistryController.create(this);
        this.e = create;
        this.g = Lifecycle.State.CREATED;
        this.h = Lifecycle.State.RESUMED;
        this.a = context;
        this.f = uuid;
        this.b = navDestination;
        this.c = bundle;
        this.i = bVar;
        create.performRestore(bundle2);
        if (lifecycleOwner != null) {
            this.g = lifecycleOwner.getLifecycle().getCurrentState();
        }
        a();
    }
}
