package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
public class ViewModelProvider {
    public final Factory a;
    public final ViewModelStore b;

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static AndroidViewModelFactory c;
        public Application b;

        public AndroidViewModelFactory(@NonNull Application application) {
            this.b = application;
        }

        @NonNull
        public static AndroidViewModelFactory getInstance(@NonNull Application application) {
            if (c == null) {
                c = new AndroidViewModelFactory(application);
            }
            return c;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return (T) super.create(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.b);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }

    public interface Factory {
        @NonNull
        <T extends ViewModel> T create(@NonNull Class<T> cls);
    }

    public static class NewInstanceFactory implements Factory {
        public static NewInstanceFactory a;

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            }
        }
    }

    public static abstract class a extends b implements Factory {
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        @NonNull
        public abstract <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls);
    }

    public static class b {
        public void a(@NonNull ViewModel viewModel) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewModelProvider(@androidx.annotation.NonNull androidx.lifecycle.ViewModelStoreOwner r3) {
        /*
            r2 = this;
            androidx.lifecycle.ViewModelStore r0 = r3.getViewModelStore()
            boolean r1 = r3 instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory
            if (r1 == 0) goto L_0x000f
            androidx.lifecycle.HasDefaultViewModelProviderFactory r3 = (androidx.lifecycle.HasDefaultViewModelProviderFactory) r3
            androidx.lifecycle.ViewModelProvider$Factory r3 = r3.getDefaultViewModelProviderFactory()
            goto L_0x001c
        L_0x000f:
            androidx.lifecycle.ViewModelProvider$NewInstanceFactory r3 = androidx.lifecycle.ViewModelProvider.NewInstanceFactory.a
            if (r3 != 0) goto L_0x001a
            androidx.lifecycle.ViewModelProvider$NewInstanceFactory r3 = new androidx.lifecycle.ViewModelProvider$NewInstanceFactory
            r3.<init>()
            androidx.lifecycle.ViewModelProvider.NewInstanceFactory.a = r3
        L_0x001a:
            androidx.lifecycle.ViewModelProvider$NewInstanceFactory r3 = androidx.lifecycle.ViewModelProvider.NewInstanceFactory.a
        L_0x001c:
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner):void");
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull String str, @NonNull Class<T> cls) {
        T t = (T) this.b.a.get(str);
        if (cls.isInstance(t)) {
            Factory factory = this.a;
            if (factory instanceof b) {
                ((b) factory).a(t);
            }
            return t;
        }
        Factory factory2 = this.a;
        T t2 = factory2 instanceof a ? (T) ((a) factory2).create(str, cls) : (T) factory2.create(cls);
        ViewModel put = this.b.a.put(str, t2);
        if (put != null) {
            put.onCleared();
        }
        return t2;
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner, @NonNull Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull Factory factory) {
        this.a = factory;
        this.b = viewModelStore;
    }
}
