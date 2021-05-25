package com.avito.android.publish_limits_info.history.tab.di;

import com.avito.android.di.PerFragment;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/di/PublishAdvertsHistoryComponent;", "", "Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryFragment;)V", "Factory", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishAdvertsHistoryDependencies.class}, modules = {HistoryAdvertsListModule.class})
@PerFragment
public interface PublishAdvertsHistoryComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/di/PublishAdvertsHistoryComponent$Factory;", "", "Lcom/avito/android/publish_limits_info/history/tab/di/PublishAdvertsHistoryDependencies;", "dependencies", "Lcom/avito/android/publish_limits_info/history/tab/di/PublishAdvertsHistoryComponent;", "create", "(Lcom/avito/android/publish_limits_info/history/tab/di/PublishAdvertsHistoryDependencies;)Lcom/avito/android/publish_limits_info/history/tab/di/PublishAdvertsHistoryComponent;", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        PublishAdvertsHistoryComponent create(@NotNull PublishAdvertsHistoryDependencies publishAdvertsHistoryDependencies);
    }

    void inject(@NotNull PublishAdvertsHistoryFragment publishAdvertsHistoryFragment);
}
