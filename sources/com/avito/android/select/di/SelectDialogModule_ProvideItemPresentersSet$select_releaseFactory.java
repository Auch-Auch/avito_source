package com.avito.android.select.di;

import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class SelectDialogModule_ProvideItemPresentersSet$select_releaseFactory implements Factory<Set<ItemPresenter<?, ?>>> {

    public static final class a {
        public static final SelectDialogModule_ProvideItemPresentersSet$select_releaseFactory a = new SelectDialogModule_ProvideItemPresentersSet$select_releaseFactory();
    }

    public static SelectDialogModule_ProvideItemPresentersSet$select_releaseFactory create() {
        return a.a;
    }

    public static Set<ItemPresenter<?, ?>> provideItemPresentersSet$select_release() {
        return (Set) Preconditions.checkNotNullFromProvides(SelectDialogModule.INSTANCE.provideItemPresentersSet$select_release());
    }

    @Override // javax.inject.Provider
    public Set<ItemPresenter<?, ?>> get() {
        return provideItemPresentersSet$select_release();
    }
}
