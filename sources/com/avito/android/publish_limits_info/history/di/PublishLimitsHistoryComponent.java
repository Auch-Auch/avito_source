package com.avito.android.publish_limits_info.history.di;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.publish_limits_info.analytics.PublishLimitsAnalyticsModule;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryActivity;
import com.avito.android.publish_limits_info.history.tab.ExtraInfoClickListener;
import com.avito.android.publish_limits_info.history.tab.di.PublishAdvertsHistoryDependencies;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryComponent;", "Lcom/avito/android/publish_limits_info/history/tab/di/PublishAdvertsHistoryDependencies;", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryActivity;", "activity", "", "inject", "(Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryActivity;)V", "Factory", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishLimitsHistoryDependencies.class}, modules = {PublishLimitsHistoryModule.class, PublishLimitsAnalyticsModule.class, AttributedTextFormatterModule.class})
@PerActivity
public interface PublishLimitsHistoryComponent extends PublishAdvertsHistoryDependencies {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryComponent$Factory;", "", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/avito/android/publish_limits_info/ItemId;", "itemId", "Lcom/avito/android/publish_limits_info/history/tab/ExtraInfoClickListener;", "extraInfoClickedListener", "Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryDependencies;", "dependencies", "Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryComponent;", "create", "(Landroidx/fragment/app/FragmentActivity;Lcom/avito/android/publish_limits_info/ItemId;Lcom/avito/android/publish_limits_info/history/tab/ExtraInfoClickListener;Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryDependencies;)Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryComponent;", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        PublishLimitsHistoryComponent create(@BindsInstance @NotNull FragmentActivity fragmentActivity, @BindsInstance @NotNull ItemId itemId, @BindsInstance @NotNull ExtraInfoClickListener extraInfoClickListener, @NotNull PublishLimitsHistoryDependencies publishLimitsHistoryDependencies);
    }

    void inject(@NotNull PublishLimitsHistoryActivity publishLimitsHistoryActivity);
}
