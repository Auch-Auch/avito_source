package com.avito.android.home.appending_item.di;

import com.avito.android.di.PerFragment;
import com.avito.android.home.appending_item.retry.AppendingLargeRetryItemBlueprint;
import com.avito.android.home.appending_item.retry.AppendingRetryItemBlueprint;
import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter;
import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenterImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/home/appending_item/di/AppendingRetryModule;", "", "Lcom/avito/android/home/appending_item/retry/AppendingRetryItemPresenter;", "appendingRetryItemPresenter", "Lcom/avito/android/home/appending_item/retry/AppendingRetryItemBlueprint;", "provideAppendingRetryItemBlueprint", "(Lcom/avito/android/home/appending_item/retry/AppendingRetryItemPresenter;)Lcom/avito/android/home/appending_item/retry/AppendingRetryItemBlueprint;", "provideAppendingRetryItemPresenter", "()Lcom/avito/android/home/appending_item/retry/AppendingRetryItemPresenter;", "presenter", "Lcom/avito/android/home/appending_item/retry/AppendingLargeRetryItemBlueprint;", "provideAppendingLargeRetryItemBlueprint", "(Lcom/avito/android/home/appending_item/retry/AppendingRetryItemPresenter;)Lcom/avito/android/home/appending_item/retry/AppendingLargeRetryItemBlueprint;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AppendingRetryModule {
    @Provides
    @PerFragment
    @NotNull
    public final AppendingLargeRetryItemBlueprint provideAppendingLargeRetryItemBlueprint(@NotNull AppendingRetryItemPresenter appendingRetryItemPresenter) {
        Intrinsics.checkNotNullParameter(appendingRetryItemPresenter, "presenter");
        return new AppendingLargeRetryItemBlueprint(appendingRetryItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AppendingRetryItemBlueprint provideAppendingRetryItemBlueprint(@NotNull AppendingRetryItemPresenter appendingRetryItemPresenter) {
        Intrinsics.checkNotNullParameter(appendingRetryItemPresenter, "appendingRetryItemPresenter");
        return new AppendingRetryItemBlueprint(appendingRetryItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AppendingRetryItemPresenter provideAppendingRetryItemPresenter() {
        return new AppendingRetryItemPresenterImpl();
    }
}
