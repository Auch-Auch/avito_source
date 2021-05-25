package com.avito.android.tariff.fees_methods.items;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.HighDemandIcon;
import com.avito.android.remote.model.Image;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010*\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020\b\u0012\b\u0010-\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b.\u0010/R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001e\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010'\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b&\u0010\fR\u0019\u0010*\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b)\u0010\fR\u001b\u0010-\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010\u0012¨\u00060"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/FeeMethodItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/remote/model/HighDemandIcon;", "i", "Lcom/avito/android/remote/model/HighDemandIcon;", "getHighDemandIcon", "()Lcom/avito/android/remote/model/HighDemandIcon;", "highDemandIcon", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "e", "Ljava/lang/CharSequence;", "getPrice", "()Ljava/lang/CharSequence;", "price", "", "h", "Ljava/lang/Boolean;", "isHighDemand", "()Ljava/lang/Boolean;", "Lcom/avito/android/deep_linking/links/DeepLink;", "f", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/remote/model/Image;", g.a, "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "icon", "c", "getTitle", "title", AuthSource.BOOKING_ORDER, "getType", "type", "d", "getDescription", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;Lcom/avito/android/remote/model/HighDemandIcon;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final CharSequence d;
    @Nullable
    public final CharSequence e;
    @NotNull
    public final DeepLink f;
    @Nullable
    public final Image g;
    @Nullable
    public final Boolean h;
    @Nullable
    public final HighDemandIcon i;

    public FeeMethodItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @NotNull DeepLink deepLink, @Nullable Image image, @Nullable Boolean bool, @Nullable HighDemandIcon highDemandIcon) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = charSequence;
        this.e = charSequence2;
        this.f = deepLink;
        this.g = image;
        this.h = bool;
        this.i = highDemandIcon;
    }

    @NotNull
    public final DeepLink getDeeplink() {
        return this.f;
    }

    @Nullable
    public final CharSequence getDescription() {
        return this.d;
    }

    @Nullable
    public final HighDemandIcon getHighDemandIcon() {
        return this.i;
    }

    @Nullable
    public final Image getIcon() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final CharSequence getPrice() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    @NotNull
    public final String getType() {
        return this.b;
    }

    @Nullable
    public final Boolean isHighDemand() {
        return this.h;
    }
}
