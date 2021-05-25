package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.avito.android.remote.model.SimpleAction;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JJ\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u0007R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\n¨\u0006&"}, d2 = {"Lru/avito/messenger/api/entity/ChannelInfo;", "", "", "component1", "()Ljava/lang/String;", "Lru/avito/messenger/api/entity/Image;", "component2", "()Lru/avito/messenger/api/entity/Image;", "Lcom/avito/android/remote/model/SimpleAction;", "component3", "()Lcom/avito/android/remote/model/SimpleAction;", "component4", "component5", "name", "avatar", "link", "status", ChannelContext.Item.USER_ID, "copy", "(Ljava/lang/String;Lru/avito/messenger/api/entity/Image;Lcom/avito/android/remote/model/SimpleAction;Ljava/lang/String;Ljava/lang/String;)Lru/avito/messenger/api/entity/ChannelInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getStatus", "getName", "getUserId", "Lru/avito/messenger/api/entity/Image;", "getAvatar", "Lcom/avito/android/remote/model/SimpleAction;", "getLink", "<init>", "(Ljava/lang/String;Lru/avito/messenger/api/entity/Image;Lcom/avito/android/remote/model/SimpleAction;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelInfo {
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName("link")
    @Nullable
    private final SimpleAction link;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("status")
    @Nullable
    private final String status;
    @SerializedName(ChannelContext.Item.USER_ID)
    @Nullable
    private final String userId;

    public ChannelInfo(@NotNull String str, @Nullable Image image, @Nullable SimpleAction simpleAction, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.avatar = image;
        this.link = simpleAction;
        this.status = str2;
        this.userId = str3;
    }

    public static /* synthetic */ ChannelInfo copy$default(ChannelInfo channelInfo, String str, Image image, SimpleAction simpleAction, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelInfo.name;
        }
        if ((i & 2) != 0) {
            image = channelInfo.avatar;
        }
        if ((i & 4) != 0) {
            simpleAction = channelInfo.link;
        }
        if ((i & 8) != 0) {
            str2 = channelInfo.status;
        }
        if ((i & 16) != 0) {
            str3 = channelInfo.userId;
        }
        return channelInfo.copy(str, image, simpleAction, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final Image component2() {
        return this.avatar;
    }

    @Nullable
    public final SimpleAction component3() {
        return this.link;
    }

    @Nullable
    public final String component4() {
        return this.status;
    }

    @Nullable
    public final String component5() {
        return this.userId;
    }

    @NotNull
    public final ChannelInfo copy(@NotNull String str, @Nullable Image image, @Nullable SimpleAction simpleAction, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new ChannelInfo(str, image, simpleAction, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelInfo)) {
            return false;
        }
        ChannelInfo channelInfo = (ChannelInfo) obj;
        return Intrinsics.areEqual(this.name, channelInfo.name) && Intrinsics.areEqual(this.avatar, channelInfo.avatar) && Intrinsics.areEqual(this.link, channelInfo.link) && Intrinsics.areEqual(this.status, channelInfo.status) && Intrinsics.areEqual(this.userId, channelInfo.userId);
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final SimpleAction getLink() {
        return this.link;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Image image = this.avatar;
        int hashCode2 = (hashCode + (image != null ? image.hashCode() : 0)) * 31;
        SimpleAction simpleAction = this.link;
        int hashCode3 = (hashCode2 + (simpleAction != null ? simpleAction.hashCode() : 0)) * 31;
        String str2 = this.status;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.userId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelInfo(name=");
        L.append(this.name);
        L.append(", avatar=");
        L.append(this.avatar);
        L.append(", link=");
        L.append(this.link);
        L.append(", status=");
        L.append(this.status);
        L.append(", userId=");
        return a.t(L, this.userId, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelInfo(String str, Image image, SimpleAction simpleAction, String str2, String str3, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : image, (i & 4) != 0 ? null : simpleAction, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }
}
