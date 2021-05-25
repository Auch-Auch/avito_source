package com.avito.android.shop.detailed.item;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.ActionNullable;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ProfileRating;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.serp.adapter.SpannedItem;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u00106\u001a\u00020\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010?\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0014\u0012\b\u0010K\u001a\u0004\u0018\u00010F\u0012\b\u00100\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010-\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u00103\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u000107\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010*\u001a\u0004\u0018\u00010#\u0012\b\u0010E\u001a\u0004\u0018\u00010@¢\u0006\u0004\bL\u0010MR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001c\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010-\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010\u0012R\u001b\u00100\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018R\u001b\u00103\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\n\u001a\u0004\b2\u0010\fR\u001c\u00106\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u0010\u0016\u001a\u0004\b5\u0010\u0018R!\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001078\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010?\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0016\u001a\u0004\b>\u0010\u0018R\u001b\u0010E\u001a\u0004\u0018\u00010@8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001b\u0010K\u001a\u0004\u0018\u00010F8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopGoldItem;", "Lcom/avito/android/serp/adapter/SpannedItem;", "", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "()I", "spanCount", "Lcom/avito/android/remote/model/Image;", "i", "Lcom/avito/android/remote/model/Image;", "getLogo", "()Lcom/avito/android/remote/model/Image;", "logo", "Lcom/avito/android/remote/model/Action;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/Action;", "getSite", "()Lcom/avito/android/remote/model/Action;", "site", "", g.a, "Ljava/lang/String;", "getCategory", "()Ljava/lang/String;", "category", "d", "getName", "name", "Lcom/avito/android/remote/model/ActionNullable;", "l", "Lcom/avito/android/remote/model/ActionNullable;", "getAddress", "()Lcom/avito/android/remote/model/ActionNullable;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/ProfileRating;", "n", "Lcom/avito/android/remote/model/ProfileRating;", "getRating", "()Lcom/avito/android/remote/model/ProfileRating;", "setRating", "(Lcom/avito/android/remote/model/ProfileRating;)V", "rating", "h", "getDescription", "description", "f", "getCreationDate", "creationDate", "j", "getBackground", "background", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "k", "Ljava/util/List;", "getPhones", "()Ljava/util/List;", "phones", "c", "getUserKey", "userKey", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "o", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "getSubscribeInfo", "()Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribeInfo", "Lcom/avito/android/remote/model/SellerVerification;", "e", "Lcom/avito/android/remote/model/SellerVerification;", "getSellerVerification", "()Lcom/avito/android/remote/model/SellerVerification;", "sellerVerification", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SellerVerification;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Image;Ljava/util/List;Lcom/avito/android/remote/model/ActionNullable;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/ProfileRating;Lcom/avito/android/public_profile/remote/model/SubscribeInfo;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopGoldItem implements SpannedItem {
    @NotNull
    public final String a;
    public final int b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final SellerVerification e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final Action h;
    @Nullable
    public final Image i;
    @Nullable
    public final Image j;
    @Nullable
    public final List<Action> k;
    @Nullable
    public final ActionNullable l;
    @Nullable
    public final Action m;
    @Nullable
    public ProfileRating n;
    @Nullable
    public final SubscribeInfo o;

    public ShopGoldItem(@NotNull String str, int i2, @NotNull String str2, @NotNull String str3, @Nullable SellerVerification sellerVerification, @Nullable String str4, @Nullable String str5, @Nullable Action action, @Nullable Image image, @Nullable Image image2, @Nullable List<Action> list, @Nullable ActionNullable actionNullable, @Nullable Action action2, @Nullable ProfileRating profileRating, @Nullable SubscribeInfo subscribeInfo) {
        a.Z0(str, "stringId", str2, "userKey", str3, "name");
        this.a = str;
        this.b = i2;
        this.c = str2;
        this.d = str3;
        this.e = sellerVerification;
        this.f = str4;
        this.g = str5;
        this.h = action;
        this.i = image;
        this.j = image2;
        this.k = list;
        this.l = actionNullable;
        this.m = action2;
        this.n = profileRating;
        this.o = subscribeInfo;
    }

    @Nullable
    public final ActionNullable getAddress() {
        return this.l;
    }

    @Nullable
    public final Image getBackground() {
        return this.j;
    }

    @Nullable
    public final String getCategory() {
        return this.g;
    }

    @Nullable
    public final String getCreationDate() {
        return this.f;
    }

    @Nullable
    public final Action getDescription() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SpannedItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final Image getLogo() {
        return this.i;
    }

    @NotNull
    public final String getName() {
        return this.d;
    }

    @Nullable
    public final List<Action> getPhones() {
        return this.k;
    }

    @Nullable
    public final ProfileRating getRating() {
        return this.n;
    }

    @Nullable
    public final SellerVerification getSellerVerification() {
        return this.e;
    }

    @Nullable
    public final Action getSite() {
        return this.m;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final SubscribeInfo getSubscribeInfo() {
        return this.o;
    }

    @NotNull
    public final String getUserKey() {
        return this.c;
    }

    public final void setRating(@Nullable ProfileRating profileRating) {
        this.n = profileRating;
    }
}
