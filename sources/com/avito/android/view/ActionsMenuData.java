package com.avito.android.view;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ItemAction;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b:\u0010;J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010Jb\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0010J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b!\u0010\u0010J \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b&\u0010'R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\rR\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u0010\u0004R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\b¨\u0006<"}, d2 = {"Lcom/avito/android/view/ActionsMenuData;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/ItemAction;", "component2", "()Ljava/util/List;", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "component6", "component7", "()I", "title", "actions", "id", "categoryId", "locationId", "feedId", VKApiConst.POSITION, "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;I)Lcom/avito/android/view/ActionsMenuData;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "f", "getFeedId", "d", "getCategoryId", "e", "Ljava/lang/Integer;", "getLocationId", g.a, "I", "getPosition", "c", "getId", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getActions", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;I)V", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public final class ActionsMenuData implements Parcelable {
    public static final Parcelable.Creator<ActionsMenuData> CREATOR = new Creator();
    @Nullable
    public final String a;
    @NotNull
    public final List<ItemAction> b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final Integer e;
    @NotNull
    public final String f;
    public final int g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ActionsMenuData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ActionsMenuData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((ItemAction) parcel.readParcelable(ActionsMenuData.class.getClassLoader()));
                readInt--;
            }
            return new ActionsMenuData(readString, arrayList, parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ActionsMenuData[] newArray(int i) {
            return new ActionsMenuData[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ItemAction> */
    /* JADX WARN: Multi-variable type inference failed */
    public ActionsMenuData(@Nullable String str, @NotNull List<? extends ItemAction> list, @NotNull String str2, @Nullable String str3, @Nullable Integer num, @NotNull String str4, int i) {
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str4, "feedId");
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = str3;
        this.e = num;
        this.f = str4;
        this.g = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.view.ActionsMenuData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionsMenuData copy$default(ActionsMenuData actionsMenuData, String str, List list, String str2, String str3, Integer num, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = actionsMenuData.a;
        }
        if ((i2 & 2) != 0) {
            list = actionsMenuData.b;
        }
        if ((i2 & 4) != 0) {
            str2 = actionsMenuData.c;
        }
        if ((i2 & 8) != 0) {
            str3 = actionsMenuData.d;
        }
        if ((i2 & 16) != 0) {
            num = actionsMenuData.e;
        }
        if ((i2 & 32) != 0) {
            str4 = actionsMenuData.f;
        }
        if ((i2 & 64) != 0) {
            i = actionsMenuData.g;
        }
        return actionsMenuData.copy(str, list, str2, str3, num, str4, i);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<ItemAction> component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final Integer component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    public final int component7() {
        return this.g;
    }

    @NotNull
    public final ActionsMenuData copy(@Nullable String str, @NotNull List<? extends ItemAction> list, @NotNull String str2, @Nullable String str3, @Nullable Integer num, @NotNull String str4, int i) {
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str4, "feedId");
        return new ActionsMenuData(str, list, str2, str3, num, str4, i);
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
        if (!(obj instanceof ActionsMenuData)) {
            return false;
        }
        ActionsMenuData actionsMenuData = (ActionsMenuData) obj;
        return Intrinsics.areEqual(this.a, actionsMenuData.a) && Intrinsics.areEqual(this.b, actionsMenuData.b) && Intrinsics.areEqual(this.c, actionsMenuData.c) && Intrinsics.areEqual(this.d, actionsMenuData.d) && Intrinsics.areEqual(this.e, actionsMenuData.e) && Intrinsics.areEqual(this.f, actionsMenuData.f) && this.g == actionsMenuData.g;
    }

    @NotNull
    public final List<ItemAction> getActions() {
        return this.b;
    }

    @Nullable
    public final String getCategoryId() {
        return this.d;
    }

    @NotNull
    public final String getFeedId() {
        return this.f;
    }

    @NotNull
    public final String getId() {
        return this.c;
    }

    @Nullable
    public final Integer getLocationId() {
        return this.e;
    }

    public final int getPosition() {
        return this.g;
    }

    @Nullable
    public final String getTitle() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ItemAction> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.e;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        String str4 = this.f;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((hashCode5 + i) * 31) + this.g;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ActionsMenuData(title=");
        L.append(this.a);
        L.append(", actions=");
        L.append(this.b);
        L.append(", id=");
        L.append(this.c);
        L.append(", categoryId=");
        L.append(this.d);
        L.append(", locationId=");
        L.append(this.e);
        L.append(", feedId=");
        L.append(this.f);
        L.append(", position=");
        return a.j(L, this.g, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        Iterator n0 = a.n0(this.b, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((ItemAction) n0.next(), i);
        }
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        Integer num = this.e;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
    }
}
