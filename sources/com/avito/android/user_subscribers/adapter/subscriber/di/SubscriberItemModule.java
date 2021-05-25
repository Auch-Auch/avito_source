package com.avito.android.user_subscribers.adapter.subscriber.di;

import com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemBlueprint;
import com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemPresenter;
import com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_subscribers/adapter/subscriber/di/SubscriberItemModule;", "", "Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindBlueprint", "(Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemPresenterImpl;", "presenter", "Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemPresenter;", "bindSubscriberPresenter", "(Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemPresenterImpl;)Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemPresenter;", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface SubscriberItemModule {
    @Binds
    @IntoSet
    @NotNull
    ItemBlueprint<?, ?> bindBlueprint(@NotNull SubscriberItemBlueprint subscriberItemBlueprint);

    @Binds
    @NotNull
    SubscriberItemPresenter bindSubscriberPresenter(@NotNull SubscriberItemPresenterImpl subscriberItemPresenterImpl);
}
