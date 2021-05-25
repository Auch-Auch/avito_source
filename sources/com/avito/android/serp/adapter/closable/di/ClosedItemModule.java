package com.avito.android.serp.adapter.closable.di;

import com.avito.android.di.PerFragment;
import com.avito.android.serp.adapter.closable.ClosedItemEventInteractor;
import com.avito.android.serp.adapter.closable.ClosedItemEventInteractorImpl;
import com.avito.android.serp.adapter.closable.ClosedItemInteractor;
import com.avito.android.serp.adapter.closable.ClosedItemInteractorImpl;
import com.avito.android.serp.adapter.closable.ClosedItemPresenter;
import com.avito.android.serp.adapter.closable.ClosedItemPresenterImpl;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/adapter/closable/di/ClosedItemModule;", "", "Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;", "eventInteractor", "Lcom/avito/android/serp/adapter/closable/ClosedItemInteractor;", "provideClosedItemInteractor", "(Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;)Lcom/avito/android/serp/adapter/closable/ClosedItemInteractor;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", "provideViewedAdvertsPresenter", "(Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", "provideClosedItemEventInteractor", "()Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ClosedItemModule {
    @NotNull
    public static final ClosedItemModule INSTANCE = new ClosedItemModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ClosedItemEventInteractor provideClosedItemEventInteractor() {
        return new ClosedItemEventInteractorImpl();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ClosedItemInteractor provideClosedItemInteractor(@NotNull ClosedItemEventInteractor closedItemEventInteractor) {
        Intrinsics.checkNotNullParameter(closedItemEventInteractor, "eventInteractor");
        return new ClosedItemInteractorImpl(closedItemEventInteractor);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ClosedItemPresenter provideViewedAdvertsPresenter(@NotNull ClosedItemEventInteractor closedItemEventInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(closedItemEventInteractor, "eventInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        return new ClosedItemPresenterImpl(closedItemEventInteractor, schedulersFactory3);
    }
}
