package com.avito.android.inline_filters.dialog;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InlineFilterDialogFactoryImpl_Factory implements Factory<InlineFilterDialogFactoryImpl> {
    public final Provider<Activity> a;
    public final Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> b;
    public final Provider<Features> c;

    public InlineFilterDialogFactoryImpl_Factory(Provider<Activity> provider, Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static InlineFilterDialogFactoryImpl_Factory create(Provider<Activity> provider, Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> provider2, Provider<Features> provider3) {
        return new InlineFilterDialogFactoryImpl_Factory(provider, provider2, provider3);
    }

    public static InlineFilterDialogFactoryImpl newInstance(Activity activity, SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup, Features features) {
        return new InlineFilterDialogFactoryImpl(activity, singleManuallyExposedAbTestGroup, features);
    }

    @Override // javax.inject.Provider
    public InlineFilterDialogFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
