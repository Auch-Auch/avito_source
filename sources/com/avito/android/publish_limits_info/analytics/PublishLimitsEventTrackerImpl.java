package com.avito.android.publish_limits_info.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.publish_limits_info.analytics.events.FeesMethodClickEvent;
import com.avito.android.publish_limits_info.analytics.events.LimitsHistoryHelpClickEvent;
import com.avito.android.publish_limits_info.analytics.events.LimitsHistoryShowEvent;
import com.avito.android.publish_limits_info.analytics.events.LimitsInfoExtraClickEvent;
import com.avito.android.publish_limits_info.analytics.events.LimitsInfoShowEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LimitsInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTrackerImpl;", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "Lcom/avito/android/publish_limits_info/ItemId;", "itemId", "Lcom/avito/android/remote/model/LimitsInfo;", "limitsInfo", "", "trackLimitsInfoShown", "(Lcom/avito/android/publish_limits_info/ItemId;Lcom/avito/android/remote/model/LimitsInfo;)V", "trackLimitsInfoExtraClicked", "trackLimitsHistoryOpen", "(Lcom/avito/android/publish_limits_info/ItemId;)V", "", "tab", "trackHistoryHelpClicked", "(Lcom/avito/android/publish_limits_info/ItemId;Ljava/lang/String;)V", "feesMethodId", "trackFeesMethodClicked", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/LimitsInfo;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class PublishLimitsEventTrackerImpl implements PublishLimitsEventTracker {
    public final Analytics a;

    public PublishLimitsEventTrackerImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker
    public void trackFeesMethodClicked(@NotNull String str, @NotNull String str2, @Nullable LimitsInfo limitsInfo) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "feesMethodId");
        this.a.track(new FeesMethodClickEvent(str, str2, limitsInfo != null ? LimitsInfoAnalyticsKt.getSeverity(limitsInfo) : null));
    }

    @Override // com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker
    public void trackHistoryHelpClicked(@NotNull ItemId itemId, @NotNull String str) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(str, "tab");
        Analytics analytics = this.a;
        String str2 = null;
        ItemId.Advert advert = (ItemId.Advert) (!(itemId instanceof ItemId.Advert) ? null : itemId);
        String advertId = advert != null ? advert.getAdvertId() : null;
        if (!(itemId instanceof ItemId.Draft)) {
            itemId = null;
        }
        ItemId.Draft draft = (ItemId.Draft) itemId;
        if (draft != null) {
            str2 = draft.getDraftId();
        }
        analytics.track(new LimitsHistoryHelpClickEvent(advertId, str2, str));
    }

    @Override // com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker
    public void trackLimitsHistoryOpen(@NotNull ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Analytics analytics = this.a;
        String str = null;
        ItemId.Advert advert = (ItemId.Advert) (!(itemId instanceof ItemId.Advert) ? null : itemId);
        String advertId = advert != null ? advert.getAdvertId() : null;
        if (!(itemId instanceof ItemId.Draft)) {
            itemId = null;
        }
        ItemId.Draft draft = (ItemId.Draft) itemId;
        if (draft != null) {
            str = draft.getDraftId();
        }
        analytics.track(new LimitsHistoryShowEvent(advertId, str));
    }

    @Override // com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker
    public void trackLimitsInfoExtraClicked(@NotNull ItemId itemId, @NotNull LimitsInfo limitsInfo) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(limitsInfo, "limitsInfo");
        Analytics analytics = this.a;
        String str = null;
        ItemId.Advert advert = (ItemId.Advert) (!(itemId instanceof ItemId.Advert) ? null : itemId);
        String advertId = advert != null ? advert.getAdvertId() : null;
        if (!(itemId instanceof ItemId.Draft)) {
            itemId = null;
        }
        ItemId.Draft draft = (ItemId.Draft) itemId;
        if (draft != null) {
            str = draft.getDraftId();
        }
        analytics.track(new LimitsInfoExtraClickEvent(advertId, str, LimitsInfoAnalyticsKt.getSeverity(limitsInfo)));
    }

    @Override // com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker
    public void trackLimitsInfoShown(@NotNull ItemId itemId, @NotNull LimitsInfo limitsInfo) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(limitsInfo, "limitsInfo");
        Analytics analytics = this.a;
        String str = null;
        ItemId.Advert advert = (ItemId.Advert) (!(itemId instanceof ItemId.Advert) ? null : itemId);
        String advertId = advert != null ? advert.getAdvertId() : null;
        if (!(itemId instanceof ItemId.Draft)) {
            itemId = null;
        }
        ItemId.Draft draft = (ItemId.Draft) itemId;
        if (draft != null) {
            str = draft.getDraftId();
        }
        analytics.track(new LimitsInfoShowEvent(advertId, str, LimitsInfoAnalyticsKt.getSeverity(limitsInfo)));
    }
}
