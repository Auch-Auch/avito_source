package com.avito.android.permissions;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FragmentPermissionHelper_Factory implements Factory<FragmentPermissionHelper> {
    public final Provider<Fragment> a;

    public FragmentPermissionHelper_Factory(Provider<Fragment> provider) {
        this.a = provider;
    }

    public static FragmentPermissionHelper_Factory create(Provider<Fragment> provider) {
        return new FragmentPermissionHelper_Factory(provider);
    }

    public static FragmentPermissionHelper newInstance(Fragment fragment) {
        return new FragmentPermissionHelper(fragment);
    }

    @Override // javax.inject.Provider
    public FragmentPermissionHelper get() {
        return newInstance(this.a.get());
    }
}
