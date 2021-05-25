package com.avito.android.remote;

import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B'\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/CallInfo;", "", "Lcom/avito/android/remote/CallInfo$CallContact;", "recipient", "Lcom/avito/android/remote/CallInfo$CallContact;", "getRecipient", "()Lcom/avito/android/remote/CallInfo$CallContact;", "caller", "getCaller", "Lcom/avito/android/remote/CallInfo$ItemInfo;", "item", "Lcom/avito/android/remote/CallInfo$ItemInfo;", "getItem", "()Lcom/avito/android/remote/CallInfo$ItemInfo;", "", "callId", "Ljava/lang/String;", "getCallId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/CallInfo$ItemInfo;Lcom/avito/android/remote/CallInfo$CallContact;Lcom/avito/android/remote/CallInfo$CallContact;)V", "CallContact", "ItemInfo", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallInfo {
    @SerializedName("callUUID")
    @NotNull
    private final String callId;
    @SerializedName("caller")
    @NotNull
    private final CallContact caller;
    @SerializedName("item")
    @NotNull
    private final ItemInfo item;
    @SerializedName("recipient")
    @NotNull
    private final CallContact recipient;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/CallInfo$CallContact;", "", "", "displayName", "Ljava/lang/String;", "getDisplayName", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "contact", "getContact", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class CallContact {
        @SerializedName("login")
        @NotNull
        private final String contact;
        @SerializedName("name")
        @NotNull
        private final String displayName;
        @SerializedName("imagePack")
        @Nullable
        private final Image image;

        public CallContact(@NotNull String str, @NotNull String str2, @Nullable Image image2) {
            Intrinsics.checkNotNullParameter(str, "contact");
            Intrinsics.checkNotNullParameter(str2, "displayName");
            this.contact = str;
            this.displayName = str2;
            this.image = image2;
        }

        @NotNull
        public final String getContact() {
            return this.contact;
        }

        @NotNull
        public final String getDisplayName() {
            return this.displayName;
        }

        @Nullable
        public final Image getImage() {
            return this.image;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CallContact(String str, String str2, Image image2, int i, j jVar) {
            this(str, str2, (i & 4) != 0 ? null : image2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/CallInfo$ItemInfo;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "price", "getPrice", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemInfo {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("imagePack")
        @Nullable
        private final Image image;
        @SerializedName("price")
        @Nullable
        private final String price;
        @SerializedName("title")
        @NotNull
        private final String title;

        public ItemInfo(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Image image2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.price = str3;
            this.image = image2;
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

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ItemInfo(String str, String str2, String str3, Image image2, int i, j jVar) {
            this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : image2);
        }
    }

    public CallInfo(@NotNull String str, @NotNull ItemInfo itemInfo, @NotNull CallContact callContact, @NotNull CallContact callContact2) {
        Intrinsics.checkNotNullParameter(str, "callId");
        Intrinsics.checkNotNullParameter(itemInfo, "item");
        Intrinsics.checkNotNullParameter(callContact, "caller");
        Intrinsics.checkNotNullParameter(callContact2, "recipient");
        this.callId = str;
        this.item = itemInfo;
        this.caller = callContact;
        this.recipient = callContact2;
    }

    @NotNull
    public final String getCallId() {
        return this.callId;
    }

    @NotNull
    public final CallContact getCaller() {
        return this.caller;
    }

    @NotNull
    public final ItemInfo getItem() {
        return this.item;
    }

    @NotNull
    public final CallContact getRecipient() {
        return this.recipient;
    }
}
