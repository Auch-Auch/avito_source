package com.avito.android.advert_core.analytics.questionnaire;

import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert_core/analytics/questionnaire/QuestionCloseEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", g.a, "Ljava/lang/String;", "locationId", "i", "fromPage", "h", BookingInfoActivity.EXTRA_ITEM_ID, "f", "categoryId", "", "e", "I", "questionId", "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class QuestionCloseEvent extends TreeClickStreamEvent {
    public final int e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public QuestionCloseEvent(int i2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j, @Nullable TreeClickStreamParent treeClickStreamParent) {
        super(j, treeClickStreamParent, 4526, 0);
        this.e = i2;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "question_id", Integer.valueOf(this.e));
        putParam(linkedHashMap, "cid", this.f);
        putParam(linkedHashMap, "lid", this.g);
        putParam(linkedHashMap, "iid", this.h);
        putParam(linkedHashMap, WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, this.i);
        return linkedHashMap;
    }
}
