package com.avito.android.safedeal.profile_settings.konveyor.list_item;

import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.remote.model.ProfileDeliverySettings;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItem;", "Lcom/avito/conveyor_item/Item;", "", "c", "Ljava/lang/CharSequence;", "getSubtitle", "()Ljava/lang/CharSequence;", MessengerShareContentUtility.SUBTITLE, "", "e", "Ljava/lang/Integer;", "getImageRes", "()Ljava/lang/Integer;", "imageRes", "Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings$Service$Content$Link;", "d", "Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings$Service$Content$Link;", "getLink", "()Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings$Service$Content$Link;", "link", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", AuthSource.BOOKING_ORDER, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings$Service$Content$Link;Ljava/lang/Integer;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ListItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final CharSequence b;
    @Nullable
    public final CharSequence c;
    @Nullable
    public final ProfileDeliverySettings.Service.Content.Link d;
    @Nullable
    public final Integer e;

    public ListItem(@NotNull String str, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable ProfileDeliverySettings.Service.Content.Link link, @DrawableRes @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = charSequence;
        this.c = charSequence2;
        this.d = link;
        this.e = num;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final Integer getImageRes() {
        return this.e;
    }

    @Nullable
    public final ProfileDeliverySettings.Service.Content.Link getLink() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final CharSequence getSubtitle() {
        return this.c;
    }

    @Nullable
    public final CharSequence getTitle() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListItem(String str, CharSequence charSequence, CharSequence charSequence2, ProfileDeliverySettings.Service.Content.Link link, Integer num, int i, j jVar) {
        this(str, charSequence, (i & 4) != 0 ? null : charSequence2, (i & 8) != 0 ? null : link, (i & 16) != 0 ? null : num);
    }
}
