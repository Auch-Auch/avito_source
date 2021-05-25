package com.avito.android.advert.notes.di;

import com.avito.android.advert.notes.EditAdvertNoteInteractor;
import com.avito.android.advert.notes.EditAdvertNoteInteractorImpl;
import com.avito.android.advert.notes.EditAdvertNotePresenter;
import com.avito.android.advert.notes.EditAdvertNotePresenterImpl;
import com.avito.android.di.PerFragment;
import dagger.Binds;
import dagger.Module;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0004\f\r\u000e\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/notes/di/AdvertDetailsNoteModule;", "", "Lcom/avito/android/advert/notes/EditAdvertNotePresenterImpl;", "editAdvertNotePresenter", "Lcom/avito/android/advert/notes/EditAdvertNotePresenter;", "bindsEditAdvertNotePresenter", "(Lcom/avito/android/advert/notes/EditAdvertNotePresenterImpl;)Lcom/avito/android/advert/notes/EditAdvertNotePresenter;", "Lcom/avito/android/advert/notes/EditAdvertNoteInteractorImpl;", "editAdvertNoteInteractor", "Lcom/avito/android/advert/notes/EditAdvertNoteInteractor;", "bindsEditAdvertNoteInteractor", "(Lcom/avito/android/advert/notes/EditAdvertNoteInteractorImpl;)Lcom/avito/android/advert/notes/EditAdvertNoteInteractor;", "AdvertId", "AdvertNote", "IsFavorite", "IsRestored", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertDetailsNoteModule {

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/notes/di/AdvertDetailsNoteModule$AdvertId;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface AdvertId {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/notes/di/AdvertDetailsNoteModule$AdvertNote;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface AdvertNote {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/notes/di/AdvertDetailsNoteModule$IsFavorite;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface IsFavorite {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/notes/di/AdvertDetailsNoteModule$IsRestored;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface IsRestored {
    }

    @PerFragment
    @Binds
    @NotNull
    EditAdvertNoteInteractor bindsEditAdvertNoteInteractor(@NotNull EditAdvertNoteInteractorImpl editAdvertNoteInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    EditAdvertNotePresenter bindsEditAdvertNotePresenter(@NotNull EditAdvertNotePresenterImpl editAdvertNotePresenterImpl);
}
