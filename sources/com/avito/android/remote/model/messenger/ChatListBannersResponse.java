package com.avito.android.remote.model.messenger;

import a2.b.a.a.a;
import com.avito.android.remote.model.PositionedCommercialCascade;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJJ\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000bJ\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001c\u0010\u0011\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b \u0010\u000bR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\u0005R\u001c\u0010\u0010\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b#\u0010\u000b¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/messenger/ChatListBannersResponse;", "", "", "Lcom/avito/android/remote/model/PositionedCommercialCascade;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/Boolean;", "", "component3", "()I", "component4", "component5", "positions", "enableEventSampling", "chatListOffset", "secondsBeforeChange", "secondsBeforeShowAgain", "copy", "(Ljava/util/List;Ljava/lang/Boolean;III)Lcom/avito/android/remote/model/messenger/ChatListBannersResponse;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getEnableEventSampling", "I", "getSecondsBeforeChange", "getSecondsBeforeShowAgain", "Ljava/util/List;", "getPositions", "getChatListOffset", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;III)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ChatListBannersResponse {
    @SerializedName("chatListOffset")
    private final int chatListOffset;
    @SerializedName("enableEventSampling")
    @Nullable
    private final Boolean enableEventSampling;
    @SerializedName("positions")
    @NotNull
    private final List<PositionedCommercialCascade> positions;
    @SerializedName("secondsBeforeChange")
    private final int secondsBeforeChange;
    @SerializedName("secondsBeforeShowAgain")
    private final int secondsBeforeShowAgain;

    public ChatListBannersResponse(@NotNull List<PositionedCommercialCascade> list, @Nullable Boolean bool, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(list, "positions");
        this.positions = list;
        this.enableEventSampling = bool;
        this.chatListOffset = i;
        this.secondsBeforeChange = i2;
        this.secondsBeforeShowAgain = i3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.model.messenger.ChatListBannersResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatListBannersResponse copy$default(ChatListBannersResponse chatListBannersResponse, List list, Boolean bool, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = chatListBannersResponse.positions;
        }
        if ((i4 & 2) != 0) {
            bool = chatListBannersResponse.enableEventSampling;
        }
        if ((i4 & 4) != 0) {
            i = chatListBannersResponse.chatListOffset;
        }
        if ((i4 & 8) != 0) {
            i2 = chatListBannersResponse.secondsBeforeChange;
        }
        if ((i4 & 16) != 0) {
            i3 = chatListBannersResponse.secondsBeforeShowAgain;
        }
        return chatListBannersResponse.copy(list, bool, i, i2, i3);
    }

    @NotNull
    public final List<PositionedCommercialCascade> component1() {
        return this.positions;
    }

    @Nullable
    public final Boolean component2() {
        return this.enableEventSampling;
    }

    public final int component3() {
        return this.chatListOffset;
    }

    public final int component4() {
        return this.secondsBeforeChange;
    }

    public final int component5() {
        return this.secondsBeforeShowAgain;
    }

    @NotNull
    public final ChatListBannersResponse copy(@NotNull List<PositionedCommercialCascade> list, @Nullable Boolean bool, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(list, "positions");
        return new ChatListBannersResponse(list, bool, i, i2, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatListBannersResponse)) {
            return false;
        }
        ChatListBannersResponse chatListBannersResponse = (ChatListBannersResponse) obj;
        return Intrinsics.areEqual(this.positions, chatListBannersResponse.positions) && Intrinsics.areEqual(this.enableEventSampling, chatListBannersResponse.enableEventSampling) && this.chatListOffset == chatListBannersResponse.chatListOffset && this.secondsBeforeChange == chatListBannersResponse.secondsBeforeChange && this.secondsBeforeShowAgain == chatListBannersResponse.secondsBeforeShowAgain;
    }

    public final int getChatListOffset() {
        return this.chatListOffset;
    }

    @Nullable
    public final Boolean getEnableEventSampling() {
        return this.enableEventSampling;
    }

    @NotNull
    public final List<PositionedCommercialCascade> getPositions() {
        return this.positions;
    }

    public final int getSecondsBeforeChange() {
        return this.secondsBeforeChange;
    }

    public final int getSecondsBeforeShowAgain() {
        return this.secondsBeforeShowAgain;
    }

    public int hashCode() {
        List<PositionedCommercialCascade> list = this.positions;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Boolean bool = this.enableEventSampling;
        if (bool != null) {
            i = bool.hashCode();
        }
        return ((((((hashCode + i) * 31) + this.chatListOffset) * 31) + this.secondsBeforeChange) * 31) + this.secondsBeforeShowAgain;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChatListBannersResponse(positions=");
        L.append(this.positions);
        L.append(", enableEventSampling=");
        L.append(this.enableEventSampling);
        L.append(", chatListOffset=");
        L.append(this.chatListOffset);
        L.append(", secondsBeforeChange=");
        L.append(this.secondsBeforeChange);
        L.append(", secondsBeforeShowAgain=");
        return a.j(L, this.secondsBeforeShowAgain, ")");
    }
}
