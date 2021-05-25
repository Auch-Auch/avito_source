package com.avito.android.app_rater.di;

import com.avito.android.app_rater.AppRaterInteractor;
import com.avito.android.app_rater.AppRaterInteractorImpl;
import com.avito.android.app_rater.AppRaterSessionStorage;
import com.avito.android.app_rater.PrefAppRaterSessionStorage;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/app_rater/di/AppRaterModule;", "", "Lcom/avito/android/app_rater/PrefAppRaterSessionStorage;", "storageImpl", "Lcom/avito/android/app_rater/AppRaterSessionStorage;", "provideAppRaterSessionStorage", "(Lcom/avito/android/app_rater/PrefAppRaterSessionStorage;)Lcom/avito/android/app_rater/AppRaterSessionStorage;", "Lcom/avito/android/app_rater/AppRaterInteractorImpl;", "interactorImpl", "Lcom/avito/android/app_rater/AppRaterInteractor;", "provideAppRaterInteractor", "(Lcom/avito/android/app_rater/AppRaterInteractorImpl;)Lcom/avito/android/app_rater/AppRaterInteractor;", "app-rater_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AppRaterModule {
    @Binds
    @NotNull
    AppRaterInteractor provideAppRaterInteractor(@NotNull AppRaterInteractorImpl appRaterInteractorImpl);

    @Binds
    @NotNull
    AppRaterSessionStorage provideAppRaterSessionStorage(@NotNull PrefAppRaterSessionStorage prefAppRaterSessionStorage);
}
