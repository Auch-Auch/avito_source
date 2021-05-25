package com.avito.android.publish.start_publish;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemPresenter;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class StartPublishSheet_MembersInjector implements MembersInjector<StartPublishSheet> {
    public final Provider<RecyclerView.Adapter<?>> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<CategoryShortcutItemPresenter> c;

    public StartPublishSheet_MembersInjector(Provider<RecyclerView.Adapter<?>> provider, Provider<AdapterPresenter> provider2, Provider<CategoryShortcutItemPresenter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<StartPublishSheet> create(Provider<RecyclerView.Adapter<?>> provider, Provider<AdapterPresenter> provider2, Provider<CategoryShortcutItemPresenter> provider3) {
        return new StartPublishSheet_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.publish.start_publish.StartPublishSheet.adapter")
    public static void injectAdapter(StartPublishSheet startPublishSheet, RecyclerView.Adapter<?> adapter) {
        startPublishSheet.adapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.publish.start_publish.StartPublishSheet.adapterPresenter")
    public static void injectAdapterPresenter(StartPublishSheet startPublishSheet, AdapterPresenter adapterPresenter) {
        startPublishSheet.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.start_publish.StartPublishSheet.categoryShortcutItemPresenter")
    public static void injectCategoryShortcutItemPresenter(StartPublishSheet startPublishSheet, CategoryShortcutItemPresenter categoryShortcutItemPresenter) {
        startPublishSheet.categoryShortcutItemPresenter = categoryShortcutItemPresenter;
    }

    public void injectMembers(StartPublishSheet startPublishSheet) {
        injectAdapter(startPublishSheet, this.a.get());
        injectAdapterPresenter(startPublishSheet, this.b.get());
        injectCategoryShortcutItemPresenter(startPublishSheet, this.c.get());
    }
}
