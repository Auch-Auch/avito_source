package com.avito.android.di;

import com.avito.android.adapter.MoreActionsItemProcessor;
import com.avito.android.adapter.MoreActionsItemProcessorImpl;
import com.avito.android.advert.actions.AdvertItemActionsPresenter;
import com.avito.android.advert.actions.AdvertItemActionsPresenterImpl;
import com.avito.android.advert.actions.HiddenAdvertItemPresenter;
import com.avito.android.advert.actions.HiddenAdvertsInteractor;
import com.avito.android.advert.actions.HiddenAdvertsInteractorImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/di/AdvertItemActionsModule;", "", "Lcom/avito/android/advert/actions/AdvertItemActionsPresenterImpl;", "hiddenAdvertsPresenter", "Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "bindAdvertItemActionsPresenter", "(Lcom/avito/android/advert/actions/AdvertItemActionsPresenterImpl;)Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "Lcom/avito/android/advert/actions/HiddenAdvertsInteractorImpl;", "hiddenAdvertsEventInteractor", "Lcom/avito/android/advert/actions/HiddenAdvertsInteractor;", "bindHiddenAdvertsInteractor", "(Lcom/avito/android/advert/actions/HiddenAdvertsInteractorImpl;)Lcom/avito/android/advert/actions/HiddenAdvertsInteractor;", "Lcom/avito/android/adapter/MoreActionsItemProcessorImpl;", "hiddenStatusResolver", "Lcom/avito/android/adapter/MoreActionsItemProcessor;", "bindHiddenStatusResolver", "(Lcom/avito/android/adapter/MoreActionsItemProcessorImpl;)Lcom/avito/android/adapter/MoreActionsItemProcessor;", "presenter", "Lcom/avito/android/advert/actions/HiddenAdvertItemPresenter;", "bindHiddenAdvertItemPresenter", "(Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;)Lcom/avito/android/advert/actions/HiddenAdvertItemPresenter;", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertItemActionsModule {
    @Reusable
    @Binds
    @NotNull
    AdvertItemActionsPresenter bindAdvertItemActionsPresenter(@NotNull AdvertItemActionsPresenterImpl advertItemActionsPresenterImpl);

    @Reusable
    @Binds
    @NotNull
    HiddenAdvertItemPresenter bindHiddenAdvertItemPresenter(@NotNull AdvertItemActionsPresenter advertItemActionsPresenter);

    @Reusable
    @Binds
    @NotNull
    HiddenAdvertsInteractor bindHiddenAdvertsInteractor(@NotNull HiddenAdvertsInteractorImpl hiddenAdvertsInteractorImpl);

    @Reusable
    @Binds
    @NotNull
    MoreActionsItemProcessor bindHiddenStatusResolver(@NotNull MoreActionsItemProcessorImpl moreActionsItemProcessorImpl);
}
