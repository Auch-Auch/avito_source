package com.avito.android.vas_performance.ui.items.banner;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.UniversalImage;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/avito/android/vas_performance/ui/items/banner/VasBundleBannerItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/remote/model/UniversalImage;", "c", "Lcom/avito/android/remote/model/UniversalImage;", "getImage", "()Lcom/avito/android/remote/model/UniversalImage;", "image", "Lcom/avito/android/remote/model/UniversalColor;", "d", "Lcom/avito/android/remote/model/UniversalColor;", "getBackgroundColor", "()Lcom/avito/android/remote/model/UniversalColor;", "backgroundColor", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", AuthSource.SEND_ABUSE, "getStringId", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/UniversalImage;Lcom/avito/android/remote/model/UniversalColor;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundleBannerItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final UniversalImage c;
    @NotNull
    public final UniversalColor d;

    public VasBundleBannerItem(@NotNull String str, @NotNull String str2, @Nullable UniversalImage universalImage, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(universalColor, "backgroundColor");
        this.a = str;
        this.b = str2;
        this.c = universalImage;
        this.d = universalColor;
    }

    @NotNull
    public final UniversalColor getBackgroundColor() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final UniversalImage getImage() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }
}
