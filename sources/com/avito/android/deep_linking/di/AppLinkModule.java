package com.avito.android.deep_linking.di;

import com.avito.android.deep_linking.AppLinkInteractor;
import com.avito.android.deep_linking.AppLinkInteractorImpl;
import com.avito.android.deep_linking.AppLinkPresenter;
import com.avito.android.deep_linking.AppLinkPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.location.di.SavedLocationInteractorModule;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/di/AppLinkModule;", "", "Lcom/avito/android/deep_linking/AppLinkInteractorImpl;", "interactor", "Lcom/avito/android/deep_linking/AppLinkInteractor;", "bindAppLinkInteractor", "(Lcom/avito/android/deep_linking/AppLinkInteractorImpl;)Lcom/avito/android/deep_linking/AppLinkInteractor;", "Lcom/avito/android/deep_linking/AppLinkPresenterImpl;", "Lcom/avito/android/deep_linking/AppLinkPresenter;", "bindAppLinkPresenter", "(Lcom/avito/android/deep_linking/AppLinkPresenterImpl;)Lcom/avito/android/deep_linking/AppLinkPresenter;", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SavedLocationInteractorModule.class, AdjustReattributionModule.class})
public interface AppLinkModule {
    @PerActivity
    @Binds
    @NotNull
    AppLinkInteractor bindAppLinkInteractor(@NotNull AppLinkInteractorImpl appLinkInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    AppLinkPresenter bindAppLinkPresenter(@NotNull AppLinkPresenterImpl appLinkPresenterImpl);
}
