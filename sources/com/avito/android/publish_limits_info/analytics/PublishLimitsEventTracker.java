package com.avito.android.publish_limits_info.analytics;

import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.remote.model.LimitsInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "", "Lcom/avito/android/publish_limits_info/ItemId;", "itemId", "Lcom/avito/android/remote/model/LimitsInfo;", "limitsInfo", "", "trackLimitsInfoShown", "(Lcom/avito/android/publish_limits_info/ItemId;Lcom/avito/android/remote/model/LimitsInfo;)V", "trackLimitsInfoExtraClicked", "trackLimitsHistoryOpen", "(Lcom/avito/android/publish_limits_info/ItemId;)V", "", "tab", "trackHistoryHelpClicked", "(Lcom/avito/android/publish_limits_info/ItemId;Ljava/lang/String;)V", "feesMethodId", "trackFeesMethodClicked", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/LimitsInfo;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public interface PublishLimitsEventTracker {
    void trackFeesMethodClicked(@NotNull String str, @NotNull String str2, @Nullable LimitsInfo limitsInfo);

    void trackHistoryHelpClicked(@NotNull ItemId itemId, @NotNull String str);

    void trackLimitsHistoryOpen(@NotNull ItemId itemId);

    void trackLimitsInfoExtraClicked(@NotNull ItemId itemId, @NotNull LimitsInfo limitsInfo);

    void trackLimitsInfoShown(@NotNull ItemId itemId, @NotNull LimitsInfo limitsInfo);
}
