package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.Objects;
public class LoaderManagerImpl extends LoaderManager {
    public static boolean c = false;
    @NonNull
    public final LifecycleOwner a;
    @NonNull
    public final b b;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        public final int l;
        @Nullable
        public final Bundle m;
        @NonNull
        public final Loader<D> n;
        public LifecycleOwner o;
        public a<D> p;
        public Loader<D> q;

        public LoaderInfo(int i, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
            this.l = i;
            this.m = bundle;
            this.n = loader;
            this.q = loader2;
            loader.registerListener(i, this);
        }

        @MainThread
        public Loader<D> d(boolean z) {
            if (LoaderManagerImpl.c) {
                String str = "  Destroying: " + this;
            }
            this.n.cancelLoad();
            this.n.abandon();
            a<D> aVar = this.p;
            if (aVar != null) {
                removeObserver(aVar);
                if (z && aVar.c) {
                    if (LoaderManagerImpl.c) {
                        StringBuilder L = a2.b.a.a.a.L("  Resetting: ");
                        L.append(aVar.a);
                        L.toString();
                    }
                    aVar.b.onLoaderReset(aVar.a);
                }
            }
            this.n.unregisterListener(this);
            if ((aVar == null || aVar.c) && !z) {
                return this.n;
            }
            this.n.reset();
            return this.q;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: androidx.loader.content.Loader<D> */
        /* JADX WARN: Multi-variable type inference failed */
        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.l);
            printWriter.print(" mArgs=");
            printWriter.println(this.m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.n);
            this.n.dump(a2.b.a.a.a.c3(str, "  "), fileDescriptor, printWriter, strArr);
            if (this.p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.p);
                a<D> aVar = this.p;
                Objects.requireNonNull(aVar);
                printWriter.print(str + "  ");
                printWriter.print("mDeliveredData=");
                printWriter.println(aVar.c);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.n.dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        public void e() {
            LifecycleOwner lifecycleOwner = this.o;
            a<D> aVar = this.p;
            if (lifecycleOwner != null && aVar != null) {
                super.removeObserver(aVar);
                observe(lifecycleOwner, aVar);
            }
        }

        @NonNull
        @MainThread
        public Loader<D> f(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            a<D> aVar = new a<>(this.n, loaderCallbacks);
            observe(lifecycleOwner, aVar);
            a<D> aVar2 = this.p;
            if (aVar2 != null) {
                removeObserver(aVar2);
            }
            this.o = lifecycleOwner;
            this.p = aVar;
            return this.n;
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            if (LoaderManagerImpl.c) {
                String str = "  Starting: " + this;
            }
            this.n.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            if (LoaderManagerImpl.c) {
                String str = "  Stopping: " + this;
            }
            this.n.stopLoading();
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d) {
            if (LoaderManagerImpl.c) {
                String str = "onLoadComplete: " + this;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d);
                return;
            }
            boolean z = LoaderManagerImpl.c;
            postValue(d);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: androidx.lifecycle.Observer<? super D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(@NonNull Observer<? super D> observer) {
            super.removeObserver(observer);
            this.o = null;
            this.p = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D d) {
            super.setValue(d);
            Loader<D> loader = this.q;
            if (loader != null) {
                loader.reset();
                this.q = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.l);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.n, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public static class a<D> implements Observer<D> {
        @NonNull
        public final Loader<D> a;
        @NonNull
        public final LoaderManager.LoaderCallbacks<D> b;
        public boolean c = false;

        public a(@NonNull Loader<D> loader, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.a = loader;
            this.b = loaderCallbacks;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable D d) {
            if (LoaderManagerImpl.c) {
                StringBuilder L = a2.b.a.a.a.L("  onLoadFinished in ");
                L.append(this.a);
                L.append(": ");
                L.append(this.a.dataToString(d));
                L.toString();
            }
            this.b.onLoadFinished(this.a, d);
            this.c = true;
        }

        public String toString() {
            return this.b.toString();
        }
    }

    public static class b extends ViewModel {
        public static final ViewModelProvider.Factory e = new a();
        public SparseArrayCompat<LoaderInfo> c = new SparseArrayCompat<>();
        public boolean d = false;

        public static class a implements ViewModelProvider.Factory {
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                return new b();
            }
        }

        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.valueAt(i).d(true);
            }
            this.c.clear();
        }
    }

    public LoaderManagerImpl(@NonNull LifecycleOwner lifecycleOwner, @NonNull ViewModelStore viewModelStore) {
        this.a = lifecycleOwner;
        this.b = (b) new ViewModelProvider(viewModelStore, b.e).get(b.class);
    }

    /* JADX INFO: finally extract failed */
    @NonNull
    @MainThread
    public final <D> Loader<D> a(int i, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks, @Nullable Loader<D> loader) {
        try {
            this.b.d = true;
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                }
                LoaderInfo loaderInfo = new LoaderInfo(i, bundle, onCreateLoader, loader);
                if (c) {
                    String str = "  Created new loader " + loaderInfo;
                }
                this.b.c.put(i, loaderInfo);
                this.b.d = false;
                return loaderInfo.f(this.a, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.b.d = false;
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @MainThread
    public void destroyLoader(int i) {
        if (this.b.d) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (c) {
                String str = "destroyLoader in " + this + " of " + i;
            }
            LoaderInfo loaderInfo = this.b.c.get(i);
            if (loaderInfo != null) {
                loaderInfo.d(true);
                this.b.c.remove(i);
            }
        } else {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        b bVar = this.b;
        if (bVar.c.size() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < bVar.c.size(); i++) {
                LoaderInfo valueAt = bVar.c.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(bVar.c.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @Nullable
    public <D> Loader<D> getLoader(int i) {
        b bVar = this.b;
        if (!bVar.d) {
            LoaderInfo loaderInfo = bVar.c.get(i);
            if (loaderInfo != null) {
                return loaderInfo.n;
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public boolean hasRunningLoaders() {
        a<D> aVar;
        b bVar = this.b;
        int size = bVar.c.size();
        for (int i = 0; i < size; i++) {
            LoaderInfo valueAt = bVar.c.valueAt(i);
            if (valueAt.hasActiveObservers() && (aVar = valueAt.p) != null && !aVar.c) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> initLoader(int i, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.b.d) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            LoaderInfo loaderInfo = this.b.c.get(i);
            if (c) {
                String str = "initLoader in " + this + ": args=" + ((Object) null);
            }
            if (loaderInfo == null) {
                return a(i, null, loaderCallbacks, null);
            }
            if (c) {
                String str2 = "  Re-using existing loader " + loaderInfo;
            }
            return loaderInfo.f(this.a, loaderCallbacks);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    @Override // androidx.loader.app.LoaderManager
    public void markForRedelivery() {
        b bVar = this.b;
        int size = bVar.c.size();
        for (int i = 0; i < size; i++) {
            bVar.c.valueAt(i).e();
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> restartLoader(int i, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.b.d) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (c) {
                String str = "restartLoader in " + this + ": args=" + bundle;
            }
            LoaderInfo loaderInfo = this.b.c.get(i);
            Loader<D> loader = null;
            if (loaderInfo != null) {
                loader = loaderInfo.d(false);
            }
            return a(i, bundle, loaderCallbacks, loader);
        } else {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
