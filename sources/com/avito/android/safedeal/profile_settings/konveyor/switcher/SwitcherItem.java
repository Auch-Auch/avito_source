package com.avito.android.safedeal.profile_settings.konveyor.switcher;

import a2.b.a.a.a;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JT\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\f2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b#\u0010$R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u000bR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010)\u001a\u0004\b2\u0010\u0007¨\u00065"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/CharSequence;", "component3", "Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings$Service$Content$Link;", "component4", "()Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings$Service$Content$Link;", "", "component5", "()Z", "", "component6", "()Ljava/lang/Integer;", "stringId", "title", MessengerShareContentUtility.SUBTITLE, "link", "isChecked", "imageRes", "copy", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings$Service$Content$Link;ZLjava/lang/Integer;)Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItem;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "e", "Z", "setChecked", "(Z)V", "d", "Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings$Service$Content$Link;", "getLink", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getTitle", "f", "Ljava/lang/Integer;", "getImageRes", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "c", "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings$Service$Content$Link;ZLjava/lang/Integer;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SwitcherItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final CharSequence b;
    @Nullable
    public final CharSequence c;
    @Nullable
    public final ProfileDeliverySettings.Service.Content.Link d;
    public boolean e;
    @Nullable
    public final Integer f;

    public SwitcherItem(@NotNull String str, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable ProfileDeliverySettings.Service.Content.Link link, boolean z, @DrawableRes @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = charSequence;
        this.c = charSequence2;
        this.d = link;
        this.e = z;
        this.f = num;
    }

    public static /* synthetic */ SwitcherItem copy$default(SwitcherItem switcherItem, String str, CharSequence charSequence, CharSequence charSequence2, ProfileDeliverySettings.Service.Content.Link link, boolean z, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = switcherItem.getStringId();
        }
        if ((i & 2) != 0) {
            charSequence = switcherItem.b;
        }
        if ((i & 4) != 0) {
            charSequence2 = switcherItem.c;
        }
        if ((i & 8) != 0) {
            link = switcherItem.d;
        }
        if ((i & 16) != 0) {
            z = switcherItem.e;
        }
        if ((i & 32) != 0) {
            num = switcherItem.f;
        }
        return switcherItem.copy(str, charSequence, charSequence2, link, z, num);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @Nullable
    public final CharSequence component2() {
        return this.b;
    }

    @Nullable
    public final CharSequence component3() {
        return this.c;
    }

    @Nullable
    public final ProfileDeliverySettings.Service.Content.Link component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @Nullable
    public final Integer component6() {
        return this.f;
    }

    @NotNull
    public final SwitcherItem copy(@NotNull String str, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable ProfileDeliverySettings.Service.Content.Link link, boolean z, @DrawableRes @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        return new SwitcherItem(str, charSequence, charSequence2, link, z, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwitcherItem)) {
            return false;
        }
        SwitcherItem switcherItem = (SwitcherItem) obj;
        return Intrinsics.areEqual(getStringId(), switcherItem.getStringId()) && Intrinsics.areEqual(this.b, switcherItem.b) && Intrinsics.areEqual(this.c, switcherItem.c) && Intrinsics.areEqual(this.d, switcherItem.d) && this.e == switcherItem.e && Intrinsics.areEqual(this.f, switcherItem.f);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final Integer getImageRes() {
        return this.f;
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

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        CharSequence charSequence = this.b;
        int hashCode2 = (hashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.c;
        int hashCode3 = (hashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        ProfileDeliverySettings.Service.Content.Link link = this.d;
        int hashCode4 = (hashCode3 + (link != null ? link.hashCode() : 0)) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode4 + i2) * 31;
        Integer num = this.f;
        if (num != null) {
            i = num.hashCode();
        }
        return i5 + i;
    }

    public final boolean isChecked() {
        return this.e;
    }

    public final void setChecked(boolean z) {
        this.e = z;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SwitcherItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", subtitle=");
        L.append(this.c);
        L.append(", link=");
        L.append(this.d);
        L.append(", isChecked=");
        L.append(this.e);
        L.append(", imageRes=");
        return a.p(L, this.f, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwitcherItem(String str, CharSequence charSequence, CharSequence charSequence2, ProfileDeliverySettings.Service.Content.Link link, boolean z, Integer num, int i, j jVar) {
        this(str, charSequence, (i & 4) != 0 ? null : charSequence2, (i & 8) != 0 ? null : link, z, (i & 32) != 0 ? null : num);
    }
}
