package com.avito.android.messenger.blacklist.mvi.adapter;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem;", "Lcom/avito/conveyor_item/Item;", "<init>", "()V", "BlockedUser", "PaginationInProgress", "Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem$BlockedUser;", "Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem$PaginationInProgress;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class BlacklistItem implements Item {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ^\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u0016\u0010(\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\fR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010\u0004¨\u00062"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem$BlockedUser;", "Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Z", ChannelContext.Item.USER_ID, "userName", "itemTitle", "itemPrice", "itemCategory", "created", "unblockingInProgress", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem$BlockedUser;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "getItemCategory", AuthSource.SEND_ABUSE, "getUserId", "c", "getItemTitle", "d", "getItemPrice", "getStringId", "stringId", "f", "getCreated", g.a, "Z", "getUnblockingInProgress", AuthSource.BOOKING_ORDER, "getUserName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class BlockedUser extends BlacklistItem {
        @NotNull
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final String e;
        @NotNull
        public final String f;
        public final boolean g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BlockedUser(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str6, "created");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
            this.g = z;
        }

        public static /* synthetic */ BlockedUser copy$default(BlockedUser blockedUser, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = blockedUser.a;
            }
            if ((i & 2) != 0) {
                str2 = blockedUser.b;
            }
            if ((i & 4) != 0) {
                str3 = blockedUser.c;
            }
            if ((i & 8) != 0) {
                str4 = blockedUser.d;
            }
            if ((i & 16) != 0) {
                str5 = blockedUser.e;
            }
            if ((i & 32) != 0) {
                str6 = blockedUser.f;
            }
            if ((i & 64) != 0) {
                z = blockedUser.g;
            }
            return blockedUser.copy(str, str2, str3, str4, str5, str6, z);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @Nullable
        public final String component4() {
            return this.d;
        }

        @Nullable
        public final String component5() {
            return this.e;
        }

        @NotNull
        public final String component6() {
            return this.f;
        }

        public final boolean component7() {
            return this.g;
        }

        @NotNull
        public final BlockedUser copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6, boolean z) {
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str6, "created");
            return new BlockedUser(str, str2, str3, str4, str5, str6, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BlockedUser)) {
                return false;
            }
            BlockedUser blockedUser = (BlockedUser) obj;
            return Intrinsics.areEqual(this.a, blockedUser.a) && Intrinsics.areEqual(this.b, blockedUser.b) && Intrinsics.areEqual(this.c, blockedUser.c) && Intrinsics.areEqual(this.d, blockedUser.d) && Intrinsics.areEqual(this.e, blockedUser.e) && Intrinsics.areEqual(this.f, blockedUser.f) && this.g == blockedUser.g;
        }

        @NotNull
        public final String getCreated() {
            return this.f;
        }

        @Nullable
        public final String getItemCategory() {
            return this.e;
        }

        @Nullable
        public final String getItemPrice() {
            return this.d;
        }

        @Nullable
        public final String getItemTitle() {
            return this.c;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return this.a;
        }

        public final boolean getUnblockingInProgress() {
            return this.g;
        }

        @NotNull
        public final String getUserId() {
            return this.a;
        }

        @Nullable
        public final String getUserName() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.d;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.e;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.f;
            if (str6 != null) {
                i = str6.hashCode();
            }
            int i2 = (hashCode5 + i) * 31;
            boolean z = this.g;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("BlockedUser(userId=");
            L.append(this.a);
            L.append(", userName=");
            L.append(this.b);
            L.append(", itemTitle=");
            L.append(this.c);
            L.append(", itemPrice=");
            L.append(this.d);
            L.append(", itemCategory=");
            L.append(this.e);
            L.append(", created=");
            L.append(this.f);
            L.append(", unblockingInProgress=");
            return a.B(L, this.g, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem$PaginationInProgress;", "Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem;", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class PaginationInProgress extends BlacklistItem {
        @NotNull
        public static final PaginationInProgress INSTANCE = new PaginationInProgress();
        @NotNull
        public static final String a = "PaginationInProgress";
        public static final long b = -3;

        public PaginationInProgress() {
            super(null);
        }

        @Override // com.avito.android.messenger.blacklist.mvi.adapter.BlacklistItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return b;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return a;
        }
    }

    public BlacklistItem() {
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    public BlacklistItem(j jVar) {
    }
}
