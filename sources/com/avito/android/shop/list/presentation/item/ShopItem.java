package com.avito.android.shop.list.presentation.item;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.SpannedItem;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\"\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010(\u001a\u0004\u0018\u00010#¢\u0006\u0004\b)\u0010*R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\fR\u001b\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/shop/list/presentation/item/ShopItem;", "Lcom/avito/android/serp/adapter/SpannedItem;", "Lcom/avito/android/remote/model/Image;", "f", "Lcom/avito/android/remote/model/Image;", "getLogo", "()Lcom/avito/android/remote/model/Image;", "logo", "", "c", "Ljava/lang/String;", "getItemsCountDescription", "()Ljava/lang/String;", "itemsCountDescription", AuthSource.BOOKING_ORDER, "getName", "name", "", g.a, "I", "getSpanCount", "()I", "spanCount", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "d", "Ljava/lang/Long;", "getItemsCount", "()Ljava/lang/Long;", "itemsCount", "e", "getCategory", "category", "Lcom/avito/android/deep_linking/links/DeepLink;", "h", "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ILcom/avito/android/deep_linking/links/DeepLink;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopItem implements SpannedItem {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final Long d;
    @Nullable
    public final String e;
    @Nullable
    public final Image f;
    public final int g;
    @Nullable
    public final DeepLink h;

    public ShopItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Long l, @Nullable String str4, @Nullable Image image, int i, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = l;
        this.e = str4;
        this.f = image;
        this.g = i;
        this.h = deepLink;
    }

    @Nullable
    public final String getCategory() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SpannedItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final Long getItemsCount() {
        return this.d;
    }

    @Nullable
    public final String getItemsCountDescription() {
        return this.c;
    }

    @Nullable
    public final Image getLogo() {
        return this.f;
    }

    @NotNull
    public final String getName() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final DeepLink getUri() {
        return this.h;
    }
}
