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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert_core/analytics/questionnaire/AnswerClickEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "h", "Ljava/lang/String;", "locationId", "j", "fromPage", "", "e", "I", "questionId", "f", "answerId", g.a, "categoryId", "i", BookingInfoActivity.EXTRA_ITEM_ID, "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AnswerClickEvent extends TreeClickStreamEvent {
    public final int e;
    public final int f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public AnswerClickEvent(int i2, int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j2, @Nullable TreeClickStreamParent treeClickStreamParent) {
        super(j2, treeClickStreamParent, 4522, 1);
        this.e = i2;
        this.f = i3;
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = str4;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "question_id", Integer.valueOf(this.e));
        putParam(linkedHashMap, "id_answer", Integer.valueOf(this.f));
        putParam(linkedHashMap, "cid", this.g);
        putParam(linkedHashMap, "lid", this.h);
        putParam(linkedHashMap, "iid", this.i);
        putParam(linkedHashMap, WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, this.j);
        return linkedHashMap;
    }
}
