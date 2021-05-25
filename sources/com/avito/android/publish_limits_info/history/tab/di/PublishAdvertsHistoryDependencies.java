package com.avito.android.publish_limits_info.history.tab.di;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.publish_limits_info.history.tab.ExtraInfoClickListener;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryProvider;
import com.avito.android.util.text.AttributedTextFormatter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/di/PublishAdvertsHistoryDependencies;", "", "Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryProvider;", "historyProvider", "()Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryProvider;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/publish_limits_info/history/tab/ExtraInfoClickListener;", "extraInfoClickListener", "()Lcom/avito/android/publish_limits_info/history/tab/ExtraInfoClickListener;", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public interface PublishAdvertsHistoryDependencies {
    @NotNull
    AttributedTextFormatter attributedTextFormatter();

    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @NotNull
    ExtraInfoClickListener extraInfoClickListener();

    @NotNull
    PublishAdvertsHistoryProvider historyProvider();
}
