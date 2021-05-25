package com.avito.android.publish_limits_info.history.tab.info;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u000f\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/info/InfoItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/remote/model/text/AttributedText;", "c", "Lcom/avito/android/remote/model/text/AttributedText;", "getExtra", "()Lcom/avito/android/remote/model/text/AttributedText;", "extra", "", "isEmpty", "()Z", AuthSource.BOOKING_ORDER, "getDescription", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class InfoItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final AttributedText c;

    public InfoItem(@NotNull String str, @Nullable String str2, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = str2;
        this.c = attributedText;
    }

    @Nullable
    public final String getDescription() {
        return this.b;
    }

    @Nullable
    public final AttributedText getExtra() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    public final boolean isEmpty() {
        return this.b == null && this.c == null;
    }
}
