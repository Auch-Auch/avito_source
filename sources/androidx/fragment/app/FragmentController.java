package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class FragmentController {
    public final FragmentHostCallback<?> a;

    public FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.a = fragmentHostCallback;
    }

    @NonNull
    public static FragmentController createController(@NonNull FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
    }

    public void attachHost(@Nullable Fragment fragment) {
        FragmentHostCallback<?> fragmentHostCallback = this.a;
        fragmentHostCallback.e.d(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        FragmentManager fragmentManager = this.a.e;
        fragmentManager.v = false;
        fragmentManager.w = false;
        fragmentManager.w(2);
    }

    public void dispatchConfigurationChanged(@NonNull Configuration configuration) {
        this.a.e.k(configuration);
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        return this.a.e.l(menuItem);
    }

    public void dispatchCreate() {
        this.a.e.m();
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        return this.a.e.n(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.a.e.o();
    }

    public void dispatchDestroyView() {
        this.a.e.w(1);
    }

    public void dispatchLowMemory() {
        this.a.e.p();
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        this.a.e.q(z);
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        return this.a.e.r(menuItem);
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        this.a.e.s(menu);
    }

    public void dispatchPause() {
        this.a.e.w(3);
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.a.e.u(z);
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        return this.a.e.v(menu);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        FragmentManager fragmentManager = this.a.e;
        fragmentManager.v = false;
        fragmentManager.w = false;
        fragmentManager.w(4);
    }

    public void dispatchStart() {
        FragmentManager fragmentManager = this.a.e;
        fragmentManager.v = false;
        fragmentManager.w = false;
        fragmentManager.w(3);
    }

    public void dispatchStop() {
        FragmentManager fragmentManager = this.a.e;
        fragmentManager.w = true;
        fragmentManager.w(2);
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean z) {
    }

    @Deprecated
    public void dumpLoaders(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    public boolean execPendingActions() {
        return this.a.e.B(true);
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String str) {
        return this.a.e.G(str);
    }

    @NonNull
    public List<Fragment> getActiveFragments(@SuppressLint({"UnknownNullness"}) List<Fragment> list) {
        return this.a.e.c.f();
    }

    public int getActiveFragmentsCount() {
        return this.a.e.c.b.size();
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.a.e;
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.a.e.S();
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.a.e.f.onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable List<Fragment> list) {
        this.a.e.Z(parcelable, new FragmentManagerNonConfig(list, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    public void restoreSaveState(@Nullable Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.a;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            fragmentHostCallback.e.a0(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    @Nullable
    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.a.e.b0();
    }

    @Nullable
    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig b0 = this.a.e.b0();
        if (b0 == null || b0.a == null) {
            return null;
        }
        return new ArrayList(b0.a);
    }

    @Nullable
    public Parcelable saveAllState() {
        return this.a.e.c0();
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.a.e.Z(parcelable, fragmentManagerNonConfig);
    }
}
