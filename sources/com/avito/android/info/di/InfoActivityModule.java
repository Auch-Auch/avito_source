package com.avito.android.info.di;

import com.avito.android.di.PerActivity;
import com.avito.android.info.business.InfoInteractor;
import com.avito.android.info.business.InfoInteractorImpl;
import com.avito.android.info.ui.InfoPresenter;
import com.avito.android.info.ui.InfoPresenterImpl;
import dagger.Binds;
import dagger.Module;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/info/di/InfoActivityModule;", "", "Declarations", "InfoPath", "InfoState", "InfoTitle", "info_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public interface InfoActivityModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/info/di/InfoActivityModule$Declarations;", "", "Lcom/avito/android/info/ui/InfoPresenterImpl;", "presenter", "Lcom/avito/android/info/ui/InfoPresenter;", "bindPresenter", "(Lcom/avito/android/info/ui/InfoPresenterImpl;)Lcom/avito/android/info/ui/InfoPresenter;", "Lcom/avito/android/info/business/InfoInteractorImpl;", "Lcom/avito/android/info/business/InfoInteractor;", "bindInteractor", "(Lcom/avito/android/info/business/InfoInteractorImpl;)Lcom/avito/android/info/business/InfoInteractor;", "info_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        InfoInteractor bindInteractor(@NotNull InfoInteractorImpl infoInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        InfoPresenter bindPresenter(@NotNull InfoPresenterImpl infoPresenterImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/info/di/InfoActivityModule$InfoPath;", "", "<init>", "()V", "info_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface InfoPath {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/info/di/InfoActivityModule$InfoState;", "", "<init>", "()V", "info_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface InfoState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/info/di/InfoActivityModule$InfoTitle;", "", "<init>", "()V", "info_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface InfoTitle {
    }
}
