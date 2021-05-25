package com.avito.android.delivery.map.point_info.konveyor.service.single;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItem;", "Lcom/avito/conveyor_item/Item;", "", "c", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "label", AuthSource.SEND_ABUSE, "getStringId", "stringId", "Lcom/avito/android/remote/model/text/AttributedText;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "d", "Ljava/util/List;", "getSubtitles", "()Ljava/util/List;", "subtitles", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final AttributedText b;
    @Nullable
    public final String c;
    @NotNull
    public final List<AttributedText> d;

    public ServiceItem(@NotNull String str, @NotNull AttributedText attributedText, @Nullable String str2, @NotNull List<AttributedText> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(attributedText, "title");
        Intrinsics.checkNotNullParameter(list, "subtitles");
        this.a = str;
        this.b = attributedText;
        this.c = str2;
        this.d = list;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final String getLabel() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final List<AttributedText> getSubtitles() {
        return this.d;
    }

    @NotNull
    public final AttributedText getTitle() {
        return this.b;
    }
}
