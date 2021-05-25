package androidx.savedstate;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.savedstate.Recreator;
@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {
    public SafeIterableMap<String, SavedStateProvider> a = new SafeIterableMap<>();
    @Nullable
    public Bundle b;
    public boolean c;
    public Recreator.a d;
    public boolean e = true;

    public interface AutoRecreated {
        void onRecreated(@NonNull SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public interface SavedStateProvider {
        @NonNull
        Bundle saveState();
    }

    @Nullable
    @MainThread
    public Bundle consumeRestoredStateForKey(@NonNull String str) {
        if (this.c) {
            Bundle bundle = this.b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.b.remove(str);
            if (this.b.isEmpty()) {
                this.b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    @MainThread
    public boolean isRestored() {
        return this.c;
    }

    @MainThread
    public void registerSavedStateProvider(@NonNull String str, @NonNull SavedStateProvider savedStateProvider) {
        if (this.a.putIfAbsent(str, savedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    @MainThread
    public void runOnNextRecreation(@NonNull Class<? extends AutoRecreated> cls) {
        if (this.e) {
            if (this.d == null) {
                this.d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.a aVar = this.d;
                aVar.a.add(cls.getName());
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException(a.E2(cls, a.L("Class"), " must have default constructor in order to be automatically recreated"), e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    @MainThread
    public void unregisterSavedStateProvider(@NonNull String str) {
        this.a.remove(str);
    }
}
