package com.avito.android.conveyor_shared_item.single_text;

import a2.b.a.a.a;
import com.avito.android.conveyor_shared_item.single_text.SingleTextItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/avito/android/conveyor_shared_item/single_text/SpannedSingleTextItem;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Lcom/avito/android/serp/adapter/SerpViewType;", "d", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "c", "I", "getSpanCount", "()I", "spanCount", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/avito/android/serp/adapter/SerpViewType;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SpannedSingleTextItem implements SingleTextItem, ViewTypeSerpItem {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final int c;
    @NotNull
    public final SerpViewType d;

    public SpannedSingleTextItem(@NotNull String str, @NotNull String str2, int i, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "stringId");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = serpViewType;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SingleTextItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.conveyor_shared_item.single_text.SingleTextItem
    @NotNull
    public String getTitle() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpannedSingleTextItem(String str, String str2, int i, SerpViewType serpViewType, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? a.I2("UUID.randomUUID().toString()") : str2, i, (i2 & 8) != 0 ? SerpViewType.SINGLE : serpViewType);
    }
}
