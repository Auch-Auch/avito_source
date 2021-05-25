package com.avito.android.public_profile.adapter.loading_item;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SpannedItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/public_profile/adapter/loading_item/PageLoadingItem;", "Lcom/avito/android/serp/adapter/SpannedItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.SEND_ABUSE, "I", "getSpanCount", "()I", "spanCount", "<init>", "(ILjava/lang/String;)V", "Companion", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PageLoadingItem implements SpannedItem {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String ID = "loading_item";
    public final int a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/public_profile/adapter/loading_item/PageLoadingItem$Companion;", "", "", "ID", "Ljava/lang/String;", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public PageLoadingItem(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = i;
        this.b = str;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SpannedItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.a;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PageLoadingItem(int i, String str, int i2, j jVar) {
        this(i, (i2 & 2) != 0 ? ID : str);
    }
}
