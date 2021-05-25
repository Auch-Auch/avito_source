package com.avito.android.publish.premoderation.di;

import com.avito.android.di.PerFragment;
import com.avito.android.publish.premoderation.AdvertDuplicatePresenter;
import com.avito.android.publish.premoderation.AdvertDuplicatePresenterImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDuplicateResult;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/premoderation/di/PublishAdvertDuplicateModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter;", "provideAdvertDuplicatePresenter", "(Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter;", "Lcom/avito/android/remote/model/AdvertDuplicateResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/AdvertDuplicateResult;", "advertDuplicateData", "<init>", "(Lcom/avito/android/remote/model/AdvertDuplicateResult;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublishAdvertDuplicateModule {
    public final AdvertDuplicateResult a;

    public PublishAdvertDuplicateModule(@NotNull AdvertDuplicateResult advertDuplicateResult) {
        Intrinsics.checkNotNullParameter(advertDuplicateResult, "advertDuplicateData");
        this.a = advertDuplicateResult;
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertDuplicatePresenter provideAdvertDuplicatePresenter(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new AdvertDuplicatePresenterImpl(schedulersFactory, this.a);
    }
}
