package com.avito.android.cart.summary.konveyor.text;

import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TextItemPresenter_Factory implements Factory<TextItemPresenter> {
    public final Provider<OnDeepLinkClickListener> a;

    public TextItemPresenter_Factory(Provider<OnDeepLinkClickListener> provider) {
        this.a = provider;
    }

    public static TextItemPresenter_Factory create(Provider<OnDeepLinkClickListener> provider) {
        return new TextItemPresenter_Factory(provider);
    }

    public static TextItemPresenter newInstance(OnDeepLinkClickListener onDeepLinkClickListener) {
        return new TextItemPresenter(onDeepLinkClickListener);
    }

    @Override // javax.inject.Provider
    public TextItemPresenter get() {
        return newInstance(this.a.get());
    }
}
