package androidx.navigation;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import l6.r.b;
public final class NavHostController extends NavController {
    public NavHostController(@NonNull Context context) {
        super(context);
    }

    public void enableOnBackPressed(boolean z) {
        this.o = z;
        f();
    }

    public void setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
        this.i = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this.m);
    }

    public void setOnBackPressedDispatcher(@NonNull OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.i != null) {
            this.n.remove();
            onBackPressedDispatcher.addCallback(this.i, this.n);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    public void setViewModelStore(@NonNull ViewModelStore viewModelStore) {
        if (this.h.isEmpty()) {
            this.j = (b) new ViewModelProvider(viewModelStore, b.d).get(b.class);
            return;
        }
        throw new IllegalStateException("ViewModelStore should be set before setGraph call");
    }
}
