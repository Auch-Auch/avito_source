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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u00109\u001a\u00020\u000e\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010\"\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\u000e\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010?\u001a\u0004\u0018\u00010:\u0012\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u000101\u0012\b\u0010E\u001a\u0004\u0018\u00010@\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010-\u001a\u0004\u0018\u00010&\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bF\u0010GR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\"\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\u0019\u0010%\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u00100\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0012R!\u00106\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u0001018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00109\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b8\u0010\u0012R\u001b\u0010?\u001a\u0004\u0018\u00010:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010E\u001a\u0004\u0018\u00010@8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopRegularItem;", "Lcom/avito/android/serp/adapter/SpannedItem;", "Lcom/avito/android/remote/model/SellerVerification;", "e", "Lcom/avito/android/remote/model/SellerVerification;", "getSellerVerification", "()Lcom/avito/android/remote/model/SellerVerification;", "sellerVerification", "Lcom/avito/android/remote/model/Action;", "k", "Lcom/avito/android/remote/model/Action;", "getSite", "()Lcom/avito/android/remote/model/Action;", "site", "", g.a, "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "getSubscribeInfo", "()Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribeInfo", "", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "()I", "spanCount", "c", "getUserKey", "userKey", "d", "getName", "name", "Lcom/avito/android/remote/model/ProfileRating;", "l", "Lcom/avito/android/remote/model/ProfileRating;", "getRating", "()Lcom/avito/android/remote/model/ProfileRating;", "setRating", "(Lcom/avito/android/remote/model/ProfileRating;)V", "rating", "f", "getCategory", "category", "", "i", "Ljava/util/List;", "getPhones", "()Ljava/util/List;", "phones", AuthSource.SEND_ABUSE, "getStringId", "stringId", "Lcom/avito/android/remote/model/Image;", "h", "Lcom/avito/android/remote/model/Image;", "getLogo", "()Lcom/avito/android/remote/model/Image;", "logo", "Lcom/avito/android/remote/model/ActionNullable;", "j", "Lcom/avito/android/remote/model/ActionNullable;", "getAddress", "()Lcom/avito/android/remote/model/ActionNullable;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SellerVerification;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/util/List;Lcom/avito/android/remote/model/ActionNullable;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/ProfileRating;Lcom/avito/android/public_profile/remote/model/SubscribeInfo;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopRegularItem implements SpannedItem {
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
    public final Image h;
    @Nullable
    public final List<Action> i;
    @Nullable
    public final ActionNullable j;
    @Nullable
    public final Action k;
    @Nullable
    public ProfileRating l;
    @Nullable
    public final SubscribeInfo m;

    public ShopRegularItem(@NotNull String str, int i2, @NotNull String str2, @NotNull String str3, @Nullable SellerVerification sellerVerification, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable List<Action> list, @Nullable ActionNullable actionNullable, @Nullable Action action, @Nullable ProfileRating profileRating, @Nullable SubscribeInfo subscribeInfo) {
        a.Z0(str, "stringId", str2, "userKey", str3, "name");
        this.a = str;
        this.b = i2;
        this.c = str2;
        this.d = str3;
        this.e = sellerVerification;
        this.f = str4;
        this.g = str5;
        this.h = image;
        this.i = list;
        this.j = actionNullable;
        this.k = action;
        this.l = profileRating;
        this.m = subscribeInfo;
    }

    @Nullable
    public final ActionNullable getAddress() {
        return this.j;
    }

    @Nullable
    public final String getCategory() {
        return this.f;
    }

    @Nullable
    public final String getDescription() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SpannedItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final Image getLogo() {
        return this.h;
    }

    @NotNull
    public final String getName() {
        return this.d;
    }

    @Nullable
    public final List<Action> getPhones() {
        return this.i;
    }

    @Nullable
    public final ProfileRating getRating() {
        return this.l;
    }

    @Nullable
    public final SellerVerification getSellerVerification() {
        return this.e;
    }

    @Nullable
    public final Action getSite() {
        return this.k;
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
        return this.m;
    }

    @NotNull
    public final String getUserKey() {
        return this.c;
    }

    public final void setRating(@Nullable ProfileRating profileRating) {
        this.l = profileRating;
    }
}
