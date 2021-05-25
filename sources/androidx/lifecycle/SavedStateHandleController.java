package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
public final class SavedStateHandleController implements LifecycleEventObserver {
    public final String a;
    public boolean b = false;
    public final SavedStateHandle c;

    public static final class a implements SavedStateRegistry.AutoRecreated {
        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(@NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
            if (savedStateRegistryOwner instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
                SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                Objects.requireNonNull(viewModelStore);
                Iterator it = new HashSet(viewModelStore.a.keySet()).iterator();
                while (it.hasNext()) {
                    SavedStateHandleController.a(viewModelStore.a.get((String) it.next()), savedStateRegistry, savedStateRegistryOwner.getLifecycle());
                }
                if (!new HashSet(viewModelStore.a.keySet()).isEmpty()) {
                    savedStateRegistry.runOnNextRecreation(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    public SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        this.a = str;
        this.c = savedStateHandle;
    }

    public static void a(ViewModel viewModel, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.a("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.b) {
            savedStateHandleController.b(savedStateRegistry, lifecycle);
            d(savedStateRegistry, lifecycle);
        }
    }

    public static SavedStateHandleController c(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandle savedStateHandle;
        Bundle consumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey(str);
        Class[] clsArr = SavedStateHandle.d;
        if (consumeRestoredStateForKey == null && bundle == null) {
            savedStateHandle = new SavedStateHandle();
        } else {
            HashMap hashMap = new HashMap();
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    hashMap.put(str2, bundle.get(str2));
                }
            }
            if (consumeRestoredStateForKey == null) {
                savedStateHandle = new SavedStateHandle(hashMap);
            } else {
                ArrayList parcelableArrayList = consumeRestoredStateForKey.getParcelableArrayList("keys");
                ArrayList parcelableArrayList2 = consumeRestoredStateForKey.getParcelableArrayList(ResidentialComplexModuleKt.VALUES);
                if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                    throw new IllegalStateException("Invalid bundle passed as restored state");
                }
                for (int i = 0; i < parcelableArrayList.size(); i++) {
                    hashMap.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
                }
                savedStateHandle = new SavedStateHandle(hashMap);
            }
        }
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, savedStateHandle);
        savedStateHandleController.b(savedStateRegistry, lifecycle);
        d(savedStateRegistry, lifecycle);
        return savedStateHandleController;
    }

    public static void d(final SavedStateRegistry savedStateRegistry, final Lifecycle lifecycle) {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState == Lifecycle.State.INITIALIZED || currentState.isAtLeast(Lifecycle.State.STARTED)) {
            savedStateRegistry.runOnNextRecreation(a.class);
        } else {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        lifecycle.removeObserver(this);
                        savedStateRegistry.runOnNextRecreation(a.class);
                    }
                }
            });
        }
    }

    public void b(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if (!this.b) {
            this.b = true;
            lifecycle.addObserver(this);
            savedStateRegistry.registerSavedStateProvider(this.a, this.c.c);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.b = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
