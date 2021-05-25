package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
public final class SavedStateViewModelFactory extends ViewModelProvider.a {
    public static final Class<?>[] f = {Application.class, SavedStateHandle.class};
    public static final Class<?>[] g = {SavedStateHandle.class};
    public final Application a;
    public final ViewModelProvider.AndroidViewModelFactory b;
    public final Bundle c;
    public final Lifecycle d;
    public final SavedStateRegistry e;

    public SavedStateViewModelFactory(@NonNull Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
    }

    public static <T> Constructor<T> b(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<?> constructor : cls.getConstructors()) {
            Constructor<T> constructor2 = (Constructor<T>) constructor;
            if (Arrays.equals(clsArr, constructor2.getParameterTypes())) {
                return constructor2;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.ViewModelProvider.b
    public void a(@NonNull ViewModel viewModel) {
        SavedStateHandleController.a(viewModel, this.e, this.d);
    }

    @Override // androidx.lifecycle.ViewModelProvider.a
    @NonNull
    public <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls) {
        Constructor constructor;
        T t;
        boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        if (isAssignableFrom) {
            constructor = b(cls, f);
        } else {
            constructor = b(cls, g);
        }
        if (constructor == null) {
            return (T) this.b.create(cls);
        }
        SavedStateHandleController c2 = SavedStateHandleController.c(this.e, this.d, str, this.c);
        if (isAssignableFrom) {
            try {
                t = (T) ((ViewModel) constructor.newInstance(this.a, c2.c));
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
            }
        } else {
            t = (T) ((ViewModel) constructor.newInstance(c2.c));
        }
        t.b("androidx.lifecycle.savedstate.vm.tag", c2);
        return t;
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@NonNull Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        this.e = savedStateRegistryOwner.getSavedStateRegistry();
        this.d = savedStateRegistryOwner.getLifecycle();
        this.c = bundle;
        this.a = application;
        this.b = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
    }

    @Override // androidx.lifecycle.ViewModelProvider.a, androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
