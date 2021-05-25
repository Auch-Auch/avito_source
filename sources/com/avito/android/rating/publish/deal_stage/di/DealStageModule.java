package com.avito.android.rating.publish.deal_stage.di;

import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.rating.publish.deal_stage.DealStageInteractor;
import com.avito.android.rating.publish.deal_stage.DealStageInteractorImpl;
import com.avito.android.rating.publish.deal_stage.DealStagePresenter;
import com.avito.android.rating.publish.deal_stage.DealStagePresenterImpl;
import com.avito.android.rating.publish.deal_stage.adapter.DealStageItem;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH'¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/rating/publish/deal_stage/di/DealStageModule;", "", "Lcom/avito/android/rating/publish/deal_stage/DealStageInteractorImpl;", "interactor", "Lcom/avito/android/rating/publish/deal_stage/DealStageInteractor;", "bindDealStageInteractor", "(Lcom/avito/android/rating/publish/deal_stage/DealStageInteractorImpl;)Lcom/avito/android/rating/publish/deal_stage/DealStageInteractor;", "Lcom/avito/android/rating/publish/deal_stage/DealStagePresenterImpl;", "presenter", "Lcom/avito/android/rating/publish/deal_stage/DealStagePresenter;", "bindDealStagePresenter", "(Lcom/avito/android/rating/publish/deal_stage/DealStagePresenterImpl;)Lcom/avito/android/rating/publish/deal_stage/DealStagePresenter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/publish/deal_stage/adapter/DealStageItem;", "relay", "Lio/reactivex/rxjava3/core/Observable;", "bindObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class})
public interface DealStageModule {
    @Binds
    @NotNull
    Consumer<DealStageItem> bindConsumer(@NotNull PublishRelay<DealStageItem> publishRelay);

    @Binds
    @NotNull
    DealStageInteractor bindDealStageInteractor(@NotNull DealStageInteractorImpl dealStageInteractorImpl);

    @Binds
    @NotNull
    DealStagePresenter bindDealStagePresenter(@NotNull DealStagePresenterImpl dealStagePresenterImpl);

    @Binds
    @NotNull
    Observable<DealStageItem> bindObservable(@NotNull PublishRelay<DealStageItem> publishRelay);
}
