package com.avito.android.advert.notes;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class EditAdvertNoteActivity_MembersInjector implements MembersInjector<EditAdvertNoteActivity> {
    public final Provider<EditAdvertNotePresenter> a;

    public EditAdvertNoteActivity_MembersInjector(Provider<EditAdvertNotePresenter> provider) {
        this.a = provider;
    }

    public static MembersInjector<EditAdvertNoteActivity> create(Provider<EditAdvertNotePresenter> provider) {
        return new EditAdvertNoteActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.advert.notes.EditAdvertNoteActivity.presenter")
    public static void injectPresenter(EditAdvertNoteActivity editAdvertNoteActivity, EditAdvertNotePresenter editAdvertNotePresenter) {
        editAdvertNoteActivity.presenter = editAdvertNotePresenter;
    }

    public void injectMembers(EditAdvertNoteActivity editAdvertNoteActivity) {
        injectPresenter(editAdvertNoteActivity, this.a.get());
    }
}
