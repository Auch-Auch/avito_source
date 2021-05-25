package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.chat.entity.MessageDomain;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b,\b\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0015\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\nJj\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b#\u0010\nJ\u0010\u0010$\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b$\u0010\u0007J\u001a\u0010&\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0011R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0004R\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u000eR\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0014R\u001b\u0010 \u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\nR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b7\u00105\u001a\u0004\b8\u0010\nR\u0019\u0010\u001f\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0017R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0007¨\u0006A"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageEnum;", "component1", "()Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageEnum;", "", "component2", "()I", "", "component3", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain;", "component4", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;", "component5", "()Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/RequestStateEnum;", "component6", "()Lru/sravni/android/bankproduct/presentation/chat/adapter/message/RequestStateEnum;", "", "component7", "()Z", "component8", "type", AnalyticFieldsName.orderId, "text", "messageViewCard", "status", "requestState", "disableRollback", "timeString", "copy", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageEnum;ILjava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;Lru/sravni/android/bankproduct/presentation/chat/adapter/message/RequestStateEnum;ZLjava/lang/String;)Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "e", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;", "getStatus", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageEnum;", "getType", "d", "Ljava/util/List;", "getMessageViewCard", "f", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/RequestStateEnum;", "getRequestState", "h", "Ljava/lang/String;", "getTimeString", "c", "getText", g.a, "Z", "getDisableRollback", AuthSource.BOOKING_ORDER, "I", "getOrderId", "<init>", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageEnum;ILjava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;Lru/sravni/android/bankproduct/presentation/chat/adapter/message/RequestStateEnum;ZLjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatViewCard {
    @NotNull
    public final ViewHolderMessageEnum a;
    public final int b;
    @Nullable
    public final String c;
    @NotNull
    public final List<MessageDomain> d;
    @NotNull
    public final ViewHolderMessageStatusEnum e;
    @NotNull
    public final RequestStateEnum f;
    public final boolean g;
    @Nullable
    public final String h;

    public ChatViewCard(@NotNull ViewHolderMessageEnum viewHolderMessageEnum, int i, @Nullable String str, @NotNull List<MessageDomain> list, @NotNull ViewHolderMessageStatusEnum viewHolderMessageStatusEnum, @NotNull RequestStateEnum requestStateEnum, boolean z, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(viewHolderMessageEnum, "type");
        Intrinsics.checkParameterIsNotNull(list, "messageViewCard");
        Intrinsics.checkParameterIsNotNull(viewHolderMessageStatusEnum, "status");
        Intrinsics.checkParameterIsNotNull(requestStateEnum, "requestState");
        this.a = viewHolderMessageEnum;
        this.b = i;
        this.c = str;
        this.d = list;
        this.e = viewHolderMessageStatusEnum;
        this.f = requestStateEnum;
        this.g = z;
        this.h = str2;
    }

    public static /* synthetic */ ChatViewCard copy$default(ChatViewCard chatViewCard, ViewHolderMessageEnum viewHolderMessageEnum, int i, String str, List list, ViewHolderMessageStatusEnum viewHolderMessageStatusEnum, RequestStateEnum requestStateEnum, boolean z, String str2, int i2, Object obj) {
        return chatViewCard.copy((i2 & 1) != 0 ? chatViewCard.a : viewHolderMessageEnum, (i2 & 2) != 0 ? chatViewCard.b : i, (i2 & 4) != 0 ? chatViewCard.c : str, (i2 & 8) != 0 ? chatViewCard.d : list, (i2 & 16) != 0 ? chatViewCard.e : viewHolderMessageStatusEnum, (i2 & 32) != 0 ? chatViewCard.f : requestStateEnum, (i2 & 64) != 0 ? chatViewCard.g : z, (i2 & 128) != 0 ? chatViewCard.h : str2);
    }

    @NotNull
    public final ViewHolderMessageEnum component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final List<MessageDomain> component4() {
        return this.d;
    }

    @NotNull
    public final ViewHolderMessageStatusEnum component5() {
        return this.e;
    }

    @NotNull
    public final RequestStateEnum component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    @Nullable
    public final String component8() {
        return this.h;
    }

    @NotNull
    public final ChatViewCard copy(@NotNull ViewHolderMessageEnum viewHolderMessageEnum, int i, @Nullable String str, @NotNull List<MessageDomain> list, @NotNull ViewHolderMessageStatusEnum viewHolderMessageStatusEnum, @NotNull RequestStateEnum requestStateEnum, boolean z, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(viewHolderMessageEnum, "type");
        Intrinsics.checkParameterIsNotNull(list, "messageViewCard");
        Intrinsics.checkParameterIsNotNull(viewHolderMessageStatusEnum, "status");
        Intrinsics.checkParameterIsNotNull(requestStateEnum, "requestState");
        return new ChatViewCard(viewHolderMessageEnum, i, str, list, viewHolderMessageStatusEnum, requestStateEnum, z, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatViewCard)) {
            return false;
        }
        ChatViewCard chatViewCard = (ChatViewCard) obj;
        return Intrinsics.areEqual(this.a, chatViewCard.a) && this.b == chatViewCard.b && Intrinsics.areEqual(this.c, chatViewCard.c) && Intrinsics.areEqual(this.d, chatViewCard.d) && Intrinsics.areEqual(this.e, chatViewCard.e) && Intrinsics.areEqual(this.f, chatViewCard.f) && this.g == chatViewCard.g && Intrinsics.areEqual(this.h, chatViewCard.h);
    }

    public final boolean getDisableRollback() {
        return this.g;
    }

    @NotNull
    public final List<MessageDomain> getMessageViewCard() {
        return this.d;
    }

    public final int getOrderId() {
        return this.b;
    }

    @NotNull
    public final RequestStateEnum getRequestState() {
        return this.f;
    }

    @NotNull
    public final ViewHolderMessageStatusEnum getStatus() {
        return this.e;
    }

    @Nullable
    public final String getText() {
        return this.c;
    }

    @Nullable
    public final String getTimeString() {
        return this.h;
    }

    @NotNull
    public final ViewHolderMessageEnum getType() {
        return this.a;
    }

    public int hashCode() {
        ViewHolderMessageEnum viewHolderMessageEnum = this.a;
        int i = 0;
        int hashCode = (((viewHolderMessageEnum != null ? viewHolderMessageEnum.hashCode() : 0) * 31) + this.b) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<MessageDomain> list = this.d;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        ViewHolderMessageStatusEnum viewHolderMessageStatusEnum = this.e;
        int hashCode4 = (hashCode3 + (viewHolderMessageStatusEnum != null ? viewHolderMessageStatusEnum.hashCode() : 0)) * 31;
        RequestStateEnum requestStateEnum = this.f;
        int hashCode5 = (hashCode4 + (requestStateEnum != null ? requestStateEnum.hashCode() : 0)) * 31;
        boolean z = this.g;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode5 + i2) * 31;
        String str2 = this.h;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChatViewCard(type=");
        L.append(this.a);
        L.append(", orderId=");
        L.append(this.b);
        L.append(", text=");
        L.append(this.c);
        L.append(", messageViewCard=");
        L.append(this.d);
        L.append(", status=");
        L.append(this.e);
        L.append(", requestState=");
        L.append(this.f);
        L.append(", disableRollback=");
        L.append(this.g);
        L.append(", timeString=");
        return a.t(L, this.h, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatViewCard(ViewHolderMessageEnum viewHolderMessageEnum, int i, String str, List list, ViewHolderMessageStatusEnum viewHolderMessageStatusEnum, RequestStateEnum requestStateEnum, boolean z, String str2, int i2, j jVar) {
        this(viewHolderMessageEnum, i, str, list, (i2 & 16) != 0 ? ViewHolderMessageStatusEnum.SUCCESS : viewHolderMessageStatusEnum, (i2 & 32) != 0 ? RequestStateEnum.NONE : requestStateEnum, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? null : str2);
    }
}
