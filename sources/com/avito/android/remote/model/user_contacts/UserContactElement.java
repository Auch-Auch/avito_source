package com.avito.android.remote.model.user_contacts;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001f B+\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/user_contacts/UserContactElement;", "Lcom/avito/android/remote/model/user_contacts/UserContactResultElement;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/user_contacts/UserContactElement$Item;", "item", "Lcom/avito/android/remote/model/user_contacts/UserContactElement$Item;", "getItem", "()Lcom/avito/android/remote/model/user_contacts/UserContactElement$Item;", "", "contact", "Ljava/lang/String;", "getContact", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/user_contacts/UserContactElement$User;", "user", "Lcom/avito/android/remote/model/user_contacts/UserContactElement$User;", "getUser", "()Lcom/avito/android/remote/model/user_contacts/UserContactElement$User;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "<init>", "(Lcom/avito/android/remote/model/user_contacts/UserContactElement$User;Lcom/avito/android/remote/model/user_contacts/UserContactElement$Item;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "Item", "User", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserContactElement extends UserContactResultElement {
    public static final Parcelable.Creator<UserContactElement> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("contact")
    @Nullable
    private final String contact;
    @SerializedName("item")
    @NotNull
    private final Item item;
    @SerializedName("user")
    @NotNull
    private final User user;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<UserContactElement> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserContactElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new UserContactElement(User.CREATOR.createFromParcel(parcel), Item.CREATOR.createFromParcel(parcel), parcel.readString(), (Action) parcel.readParcelable(UserContactElement.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserContactElement[] newArray(int i) {
            return new UserContactElement[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000f¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/user_contacts/UserContactElement$Item;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "id", "getId", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "isAuto", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "price", "getPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/lang/Boolean;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item implements Parcelable {
        public static final Parcelable.Creator<Item> CREATOR = new Creator();
        @SerializedName("action")
        @Nullable
        private final Action action;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("image")
        @Nullable
        private final Image image;
        @SerializedName("isAuto")
        @Nullable
        private final Boolean isAuto;
        @SerializedName("price")
        @Nullable
        private final String price;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Item> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Image image = (Image) parcel.readParcelable(Item.class.getClassLoader());
                String readString3 = parcel.readString();
                Action action = (Action) parcel.readParcelable(Item.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new Item(readString, readString2, image, readString3, action, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item[] newArray(int i) {
                return new Item[i];
            }
        }

        public Item(@Nullable String str, @NotNull String str2, @Nullable Image image2, @Nullable String str3, @Nullable Action action2, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(str2, "id");
            this.title = str;
            this.id = str2;
            this.image = image2;
            this.price = str3;
            this.action = action2;
            this.isAuto = bool;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Action getAction() {
            return this.action;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final Image getImage() {
            return this.image;
        }

        @Nullable
        public final String getPrice() {
            return this.price;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Boolean isAuto() {
            return this.isAuto;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.id);
            parcel.writeParcelable(this.image, i);
            parcel.writeString(this.price);
            parcel.writeParcelable(this.action, i);
            Boolean bool = this.isAuto;
            if (bool != null) {
                parcel.writeInt(1);
                z = bool.booleanValue();
            } else {
                z = false;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            parcel.writeInt(i2);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/user_contacts/UserContactElement$User;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "userKey", "Ljava/lang/String;", "getUserKey", "()Ljava/lang/String;", "name", "getName", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class User implements Parcelable {
        public static final Parcelable.Creator<User> CREATOR = new Creator();
        @SerializedName("action")
        @Nullable
        private final Action action;
        @SerializedName("avatar")
        @Nullable
        private final Image avatar;
        @SerializedName("name")
        @Nullable
        private final String name;
        @SerializedName("hashUserId")
        @NotNull
        private final String userKey;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<User> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final User createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new User((Image) parcel.readParcelable(User.class.getClassLoader()), parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(User.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final User[] newArray(int i) {
                return new User[i];
            }
        }

        public User(@Nullable Image image, @Nullable String str, @NotNull String str2, @Nullable Action action2) {
            Intrinsics.checkNotNullParameter(str2, "userKey");
            this.avatar = image;
            this.name = str;
            this.userKey = str2;
            this.action = action2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Action getAction() {
            return this.action;
        }

        @Nullable
        public final Image getAvatar() {
            return this.avatar;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getUserKey() {
            return this.userKey;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.avatar, i);
            parcel.writeString(this.name);
            parcel.writeString(this.userKey);
            parcel.writeParcelable(this.action, i);
        }
    }

    public UserContactElement(@NotNull User user2, @NotNull Item item2, @Nullable String str, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(item2, "item");
        this.user = user2;
        this.item = item2;
        this.contact = str;
        this.action = action2;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getContact() {
        return this.contact;
    }

    @NotNull
    public final Item getItem() {
        return this.item;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.user.writeToParcel(parcel, 0);
        this.item.writeToParcel(parcel, 0);
        parcel.writeString(this.contact);
        parcel.writeParcelable(this.action, i);
    }
}
