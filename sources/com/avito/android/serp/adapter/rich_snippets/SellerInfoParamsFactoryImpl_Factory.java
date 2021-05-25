package com.avito.android.serp.adapter.rich_snippets;

import android.content.res.Resources;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerInfoParamsFactoryImpl_Factory implements Factory<SellerInfoParamsFactoryImpl> {
    public final Provider<Resources> a;
    public final Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> b;

    public SellerInfoParamsFactoryImpl_Factory(Provider<Resources> provider, Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SellerInfoParamsFactoryImpl_Factory create(Provider<Resources> provider, Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> provider2) {
        return new SellerInfoParamsFactoryImpl_Factory(provider, provider2);
    }

    public static SellerInfoParamsFactoryImpl newInstance(Resources resources, SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> singleManuallyExposedAbTestGroup) {
        return new SellerInfoParamsFactoryImpl(resources, singleManuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public SellerInfoParamsFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
