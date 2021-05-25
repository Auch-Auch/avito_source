package com.avito.android.inline_filters.dialog;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InlineFiltersDialogItemConverterImpl_Factory implements Factory<InlineFiltersDialogItemConverterImpl> {
    public final Provider<Features> a;
    public final Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> b;

    public InlineFiltersDialogItemConverterImpl_Factory(Provider<Features> provider, Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InlineFiltersDialogItemConverterImpl_Factory create(Provider<Features> provider, Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> provider2) {
        return new InlineFiltersDialogItemConverterImpl_Factory(provider, provider2);
    }

    public static InlineFiltersDialogItemConverterImpl newInstance(Features features, SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup) {
        return new InlineFiltersDialogItemConverterImpl(features, singleManuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public InlineFiltersDialogItemConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
