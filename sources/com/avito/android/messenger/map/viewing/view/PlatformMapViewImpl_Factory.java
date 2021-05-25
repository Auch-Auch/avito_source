package com.avito.android.messenger.map.viewing.view;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PlatformMapViewImpl_Factory implements Factory<PlatformMapViewImpl> {
    public final Provider<View> a;
    public final Provider<Boolean> b;
    public final Provider<AvitoMapAttachHelper> c;
    public final Provider<FragmentManager> d;

    public PlatformMapViewImpl_Factory(Provider<View> provider, Provider<Boolean> provider2, Provider<AvitoMapAttachHelper> provider3, Provider<FragmentManager> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PlatformMapViewImpl_Factory create(Provider<View> provider, Provider<Boolean> provider2, Provider<AvitoMapAttachHelper> provider3, Provider<FragmentManager> provider4) {
        return new PlatformMapViewImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static PlatformMapViewImpl newInstance(View view, boolean z, AvitoMapAttachHelper avitoMapAttachHelper, FragmentManager fragmentManager) {
        return new PlatformMapViewImpl(view, z, avitoMapAttachHelper, fragmentManager);
    }

    @Override // javax.inject.Provider
    public PlatformMapViewImpl get() {
        return newInstance(this.a.get(), this.b.get().booleanValue(), this.c.get(), this.d.get());
    }
}
