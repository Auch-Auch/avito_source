package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatMessageClickListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/UserMessageItemDescription;", "", "", "onClick", "()V", "", "e", "Z", "getShouldShowTime", "()Z", "shouldShowTime", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "getChatViewCard", "()Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "chatViewCard", "", AuthSource.BOOKING_ORDER, "I", "getStatusDrawable", "()I", "statusDrawable", "c", "getErrorDescriptionVisibility", "errorDescriptionVisibility", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatMessageClickListener;", "d", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatMessageClickListener;", "chatMessageClickListener", "<init>", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;IILru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatMessageClickListener;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class UserMessageItemDescription {
    @NotNull
    public final ChatViewCard a;
    public final int b;
    public final int c;
    public final IChatMessageClickListener d;
    public final boolean e;

    public UserMessageItemDescription(@NotNull ChatViewCard chatViewCard, int i, int i2, @NotNull IChatMessageClickListener iChatMessageClickListener, boolean z) {
        Intrinsics.checkParameterIsNotNull(chatViewCard, "chatViewCard");
        Intrinsics.checkParameterIsNotNull(iChatMessageClickListener, "chatMessageClickListener");
        this.a = chatViewCard;
        this.b = i;
        this.c = i2;
        this.d = iChatMessageClickListener;
        this.e = z;
    }

    @NotNull
    public final ChatViewCard getChatViewCard() {
        return this.a;
    }

    public final int getErrorDescriptionVisibility() {
        return this.c;
    }

    public final boolean getShouldShowTime() {
        return this.e;
    }

    public final int getStatusDrawable() {
        return this.b;
    }

    public final void onClick() {
        this.d.itemClicked(this.a);
    }
}
