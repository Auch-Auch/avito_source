package com.avito.android.publish.wizard;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.publish.wizard.analytics.CategoriesWizardTracker;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class WizardFragment_MembersInjector implements MembersInjector<WizardFragment> {
    public final Provider<Analytics> a;
    public final Provider<WizardInteractor> b;
    public final Provider<WizardPresenter> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<ItemBinder> e;
    public final Provider<ActivityIntentFactory> f;
    public final Provider<CategoriesWizardTracker> g;

    public WizardFragment_MembersInjector(Provider<Analytics> provider, Provider<WizardInteractor> provider2, Provider<WizardPresenter> provider3, Provider<AdapterPresenter> provider4, Provider<ItemBinder> provider5, Provider<ActivityIntentFactory> provider6, Provider<CategoriesWizardTracker> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<WizardFragment> create(Provider<Analytics> provider, Provider<WizardInteractor> provider2, Provider<WizardPresenter> provider3, Provider<AdapterPresenter> provider4, Provider<ItemBinder> provider5, Provider<ActivityIntentFactory> provider6, Provider<CategoriesWizardTracker> provider7) {
        return new WizardFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.publish.wizard.WizardFragment.adapterPresenter")
    public static void injectAdapterPresenter(WizardFragment wizardFragment, AdapterPresenter adapterPresenter) {
        wizardFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.wizard.WizardFragment.analytics")
    public static void injectAnalytics(WizardFragment wizardFragment, Analytics analytics) {
        wizardFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.publish.wizard.WizardFragment.intentFactory")
    public static void injectIntentFactory(WizardFragment wizardFragment, ActivityIntentFactory activityIntentFactory) {
        wizardFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.wizard.WizardFragment.interactor")
    public static void injectInteractor(WizardFragment wizardFragment, WizardInteractor wizardInteractor) {
        wizardFragment.interactor = wizardInteractor;
    }

    @InjectedFieldSignature("com.avito.android.publish.wizard.WizardFragment.itemBinder")
    public static void injectItemBinder(WizardFragment wizardFragment, ItemBinder itemBinder) {
        wizardFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.publish.wizard.WizardFragment.presenter")
    public static void injectPresenter(WizardFragment wizardFragment, WizardPresenter wizardPresenter) {
        wizardFragment.presenter = wizardPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.wizard.WizardFragment.tracker")
    public static void injectTracker(WizardFragment wizardFragment, CategoriesWizardTracker categoriesWizardTracker) {
        wizardFragment.tracker = categoriesWizardTracker;
    }

    public void injectMembers(WizardFragment wizardFragment) {
        injectAnalytics(wizardFragment, this.a.get());
        injectInteractor(wizardFragment, this.b.get());
        injectPresenter(wizardFragment, this.c.get());
        injectAdapterPresenter(wizardFragment, this.d.get());
        injectItemBinder(wizardFragment, this.e.get());
        injectIntentFactory(wizardFragment, this.f.get());
        injectTracker(wizardFragment, this.g.get());
    }
}
