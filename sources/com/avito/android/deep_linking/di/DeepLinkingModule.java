package com.avito.android.deep_linking.di;

import com.avito.android.deep_linking.DeepLinkingPresenter;
import com.avito.android.deep_linking.DeepLinkingPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.location.di.SavedLocationInteractorModule;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/di/DeepLinkingModule;", "", "Lcom/avito/android/deep_linking/DeepLinkingPresenterImpl;", "presenter", "Lcom/avito/android/deep_linking/DeepLinkingPresenter;", "bindDeepLinkingPresenter", "(Lcom/avito/android/deep_linking/DeepLinkingPresenterImpl;)Lcom/avito/android/deep_linking/DeepLinkingPresenter;", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SavedLocationInteractorModule.class, AdjustReattributionModule.class})
public interface DeepLinkingModule {
    @PerActivity
    @Binds
    @NotNull
    DeepLinkingPresenter bindDeepLinkingPresenter(@NotNull DeepLinkingPresenterImpl deepLinkingPresenterImpl);
}
