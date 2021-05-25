package com.avito.android.advert_core.analytics.toolbar;

import a2.g.r.g;
import com.avito.android.analytics.event.BackPressTreeEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert_core/analytics/toolbar/BackPressAdvertTreeEvent;", "Lcom/avito/android/analytics/event/BackPressTreeEvent;", "", "", "", "getExtraParams", "()Ljava/util/Map;", "f", "Ljava/lang/String;", "getSrcp", "()Ljava/lang/String;", "srcp", "Lcom/avito/android/advert_core/analytics/toolbar/BackFromPage;", "h", "Lcom/avito/android/advert_core/analytics/toolbar/BackFromPage;", "getFromPage", "()Lcom/avito/android/advert_core/analytics/toolbar/BackFromPage;", "fromPage", g.a, BookingInfoActivity.EXTRA_ITEM_ID, "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "", "isFromActionBar", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;ZLcom/avito/android/advert_core/analytics/toolbar/BackFromPage;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class BackPressAdvertTreeEvent extends BackPressTreeEvent {
    @NotNull
    public final String f;
    public final String g;
    @NotNull
    public final BackFromPage h;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BackPressAdvertTreeEvent(long j, TreeClickStreamParent treeClickStreamParent, String str, boolean z, BackFromPage backFromPage, int i, j jVar) {
        this(j, treeClickStreamParent, str, z, (i & 16) != 0 ? BackFromPage.NONE : backFromPage);
    }

    @Override // com.avito.android.analytics.event.BackPressTreeEvent
    @NotNull
    public Map<String, Object> getExtraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "iid", this.g);
        if (this.h.isNotNone()) {
            putParam(linkedHashMap, WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, this.h.getValue());
        }
        return linkedHashMap;
    }

    @NotNull
    public final BackFromPage getFromPage() {
        return this.h;
    }

    @Override // com.avito.android.analytics.event.BackPressTreeEvent
    @NotNull
    public String getSrcp() {
        return this.f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackPressAdvertTreeEvent(long j, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull String str, boolean z, @NotNull BackFromPage backFromPage) {
        super(j, treeClickStreamParent, z);
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(backFromPage, "fromPage");
        this.g = str;
        this.h = backFromPage;
        this.f = "item_view";
    }
}
