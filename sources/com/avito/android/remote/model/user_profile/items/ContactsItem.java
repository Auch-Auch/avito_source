package com.avito.android.remote.model.user_profile.items;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/ContactsItem;", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/Action;", "component3", "()Lcom/avito/android/remote/model/Action;", "title", "description", "action", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)Lcom/avito/android/remote/model/user_profile/items/ContactsItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Action;", "getAction", "Ljava/lang/String;", "getDescription", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ContactsItem extends UserProfileItem {
    public static final Parcelable.Creator<ContactsItem> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ContactsItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ContactsItem(parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(ContactsItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsItem[] newArray(int i) {
            return new ContactsItem[i];
        }
    }

    public ContactsItem(@NotNull String str, @Nullable String str2, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.description = str2;
        this.action = action2;
    }

    public static /* synthetic */ ContactsItem copy$default(ContactsItem contactsItem, String str, String str2, Action action2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactsItem.title;
        }
        if ((i & 2) != 0) {
            str2 = contactsItem.description;
        }
        if ((i & 4) != 0) {
            action2 = contactsItem.action;
        }
        return contactsItem.copy(str, str2, action2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final Action component3() {
        return this.action;
    }

    @NotNull
    public final ContactsItem copy(@NotNull String str, @Nullable String str2, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new ContactsItem(str, str2, action2);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactsItem)) {
            return false;
        }
        ContactsItem contactsItem = (ContactsItem) obj;
        return Intrinsics.areEqual(this.title, contactsItem.title) && Intrinsics.areEqual(this.description, contactsItem.description) && Intrinsics.areEqual(this.action, contactsItem.action);
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Action action2 = this.action;
        if (action2 != null) {
            i = action2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContactsItem(title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", action=");
        L.append(this.action);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.action, i);
    }
}
