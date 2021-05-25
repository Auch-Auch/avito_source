package com.avito.android.category.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ShopButtonClickEvent;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/category/analytics/CategoryAnalyticsInteractorImpl;", "Lcom/avito/android/category/analytics/CategoryAnalyticsInteractor;", "", "shortcutDescription", "categoryId", "", "sendCategoryClick", "(Ljava/lang/String;Ljava/lang/String;)V", "sendShopClick", "()V", "sendCategoryOpened", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "d", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "", AuthSource.SEND_ABUSE, "J", "stateId", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "c", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryAnalyticsInteractorImpl implements CategoryAnalyticsInteractor {
    public long a;
    public final Analytics b;
    public final TreeStateIdGenerator c;
    public TreeClickStreamParent d;

    public CategoryAnalyticsInteractorImpl(@NotNull Analytics analytics, @NotNull TreeStateIdGenerator treeStateIdGenerator, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        this.b = analytics;
        this.c = treeStateIdGenerator;
        this.d = treeClickStreamParent;
        this.a = treeStateIdGenerator.nextStateId();
    }

    @Override // com.avito.android.category.analytics.CategoryAnalyticsInteractor
    @NotNull
    public TreeClickStreamParent getParent() {
        return new TreeClickStreamParent(this.a, ScreenIdField.CATEGORY.name(), null, null);
    }

    @Override // com.avito.android.category.analytics.CategoryAnalyticsInteractor
    public void sendCategoryClick(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "shortcutDescription");
        this.b.track(new CategoryClickEvent(str, str2));
    }

    @Override // com.avito.android.category.analytics.CategoryAnalyticsInteractor
    public void sendCategoryOpened() {
        long nextStateId = this.c.nextStateId();
        this.a = nextStateId;
        this.b.track(new CategoryOpenEvent(nextStateId, this.d));
    }

    @Override // com.avito.android.category.analytics.CategoryAnalyticsInteractor
    public void sendShopClick() {
        this.b.track(new ShopButtonClickEvent("category"));
    }
}
