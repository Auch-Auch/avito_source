package com.avito.android.advert.notes;

import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditAdvertNotePresenterImpl_Factory implements Factory<EditAdvertNotePresenterImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<EditAdvertNoteInteractor> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<FavoriteAdvertsInteractor> e;
    public final Provider<Boolean> f;
    public final Provider<Boolean> g;

    public EditAdvertNotePresenterImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<EditAdvertNoteInteractor> provider3, Provider<SchedulersFactory3> provider4, Provider<FavoriteAdvertsInteractor> provider5, Provider<Boolean> provider6, Provider<Boolean> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static EditAdvertNotePresenterImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<EditAdvertNoteInteractor> provider3, Provider<SchedulersFactory3> provider4, Provider<FavoriteAdvertsInteractor> provider5, Provider<Boolean> provider6, Provider<Boolean> provider7) {
        return new EditAdvertNotePresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static EditAdvertNotePresenterImpl newInstance(String str, String str2, EditAdvertNoteInteractor editAdvertNoteInteractor, SchedulersFactory3 schedulersFactory3, FavoriteAdvertsInteractor favoriteAdvertsInteractor, boolean z, boolean z2) {
        return new EditAdvertNotePresenterImpl(str, str2, editAdvertNoteInteractor, schedulersFactory3, favoriteAdvertsInteractor, z, z2);
    }

    @Override // javax.inject.Provider
    public EditAdvertNotePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get().booleanValue(), this.g.get().booleanValue());
    }
}
