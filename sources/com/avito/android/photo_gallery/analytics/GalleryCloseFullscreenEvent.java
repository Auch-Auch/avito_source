package com.avito.android.photo_gallery.analytics;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_gallery/analytics/GalleryCloseFullscreenEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "e", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "f", "categoryId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Ljava/lang/String;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryCloseFullscreenEvent extends TreeClickStreamEvent {
    public final String e;
    public final String f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryCloseFullscreenEvent(@Nullable TreeClickStreamParent treeClickStreamParent, @NotNull String str, @NotNull String str2) {
        super(0, treeClickStreamParent, 3227, 0);
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "categoryId");
        this.e = str;
        this.f = str2;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "iid", this.e);
        putParam(linkedHashMap, "cid", this.f);
        return linkedHashMap;
    }
}
