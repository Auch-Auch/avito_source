package com.avito.android.home.appending_item.di;

import com.avito.android.di.PerFragment;
import com.avito.android.home.appending_item.empty.AppendingEmptyItemBlueprint;
import com.avito.android.home.appending_item.empty.AppendingEmptyItemPresenter;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/home/appending_item/di/AppendingEmptyModule;", "", "Lcom/avito/android/home/appending_item/empty/AppendingEmptyItemPresenter;", "appendingEmptyItemPresenter", "Lcom/avito/android/home/appending_item/empty/AppendingEmptyItemBlueprint;", "provideAppendingEmptyBlueprint", "(Lcom/avito/android/home/appending_item/empty/AppendingEmptyItemPresenter;)Lcom/avito/android/home/appending_item/empty/AppendingEmptyItemBlueprint;", "provideAppendingEmptyPresenter", "()Lcom/avito/android/home/appending_item/empty/AppendingEmptyItemPresenter;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AppendingEmptyModule {
    @Provides
    @PerFragment
    @NotNull
    public final AppendingEmptyItemBlueprint provideAppendingEmptyBlueprint(@NotNull AppendingEmptyItemPresenter appendingEmptyItemPresenter) {
        Intrinsics.checkNotNullParameter(appendingEmptyItemPresenter, "appendingEmptyItemPresenter");
        return new AppendingEmptyItemBlueprint(appendingEmptyItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AppendingEmptyItemPresenter provideAppendingEmptyPresenter() {
        return new AppendingEmptyItemPresenter();
    }
}
