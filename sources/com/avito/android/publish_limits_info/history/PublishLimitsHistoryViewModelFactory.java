package com.avito.android.publish_limits_info.history;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/publish_limits_info/ItemId;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish_limits_info/ItemId;", "itemId", "Lcom/avito/android/util/RandomKeyProvider;", "d", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractor;", "interactor", "<init>", "(Lcom/avito/android/publish_limits_info/ItemId;Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/RandomKeyProvider;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class PublishLimitsHistoryViewModelFactory implements ViewModelProvider.Factory {
    public final ItemId a;
    public final PublishLimitsHistoryInteractor b;
    public final SchedulersFactory3 c;
    public final RandomKeyProvider d;

    @Inject
    public PublishLimitsHistoryViewModelFactory(@NotNull ItemId itemId, @NotNull PublishLimitsHistoryInteractor publishLimitsHistoryInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(publishLimitsHistoryInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        this.a = itemId;
        this.b = publishLimitsHistoryInteractor;
        this.c = schedulersFactory3;
        this.d = randomKeyProvider;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(PublishLimitsHistoryViewModel.class)) {
            return new PublishLimitsHistoryViewModel(this.a, this.b, this.c, this.d);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
