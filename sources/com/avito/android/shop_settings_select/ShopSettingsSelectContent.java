package com.avito.android.shop_settings_select;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/avito/android/shop_settings_select/ShopSettingsSelectContent;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/shop_settings_select/blueprints/shop_settings_selection/ShopSettingsSelectionItem;", "component2", "()Ljava/util/List;", "title", "selections", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/shop_settings_select/ShopSettingsSelectContent;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getSelections", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectContent implements Parcelable {
    public static final Parcelable.Creator<ShopSettingsSelectContent> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final List<ShopSettingsSelectionItem> b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsSelectContent> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSelectContent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(ShopSettingsSelectionItem.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new ShopSettingsSelectContent(readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSelectContent[] newArray(int i) {
            return new ShopSettingsSelectContent[i];
        }
    }

    public ShopSettingsSelectContent(@NotNull String str, @NotNull List<ShopSettingsSelectionItem> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "selections");
        this.a = str;
        this.b = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.shop_settings_select.ShopSettingsSelectContent */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShopSettingsSelectContent copy$default(ShopSettingsSelectContent shopSettingsSelectContent, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopSettingsSelectContent.a;
        }
        if ((i & 2) != 0) {
            list = shopSettingsSelectContent.b;
        }
        return shopSettingsSelectContent.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<ShopSettingsSelectionItem> component2() {
        return this.b;
    }

    @NotNull
    public final ShopSettingsSelectContent copy(@NotNull String str, @NotNull List<ShopSettingsSelectionItem> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "selections");
        return new ShopSettingsSelectContent(str, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopSettingsSelectContent)) {
            return false;
        }
        ShopSettingsSelectContent shopSettingsSelectContent = (ShopSettingsSelectContent) obj;
        return Intrinsics.areEqual(this.a, shopSettingsSelectContent.a) && Intrinsics.areEqual(this.b, shopSettingsSelectContent.b);
    }

    @NotNull
    public final List<ShopSettingsSelectionItem> getSelections() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ShopSettingsSelectionItem> list = this.b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopSettingsSelectContent(title=");
        L.append(this.a);
        L.append(", selections=");
        return a.w(L, this.b, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        Iterator n0 = a.n0(this.b, parcel);
        while (n0.hasNext()) {
            ((ShopSettingsSelectionItem) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
