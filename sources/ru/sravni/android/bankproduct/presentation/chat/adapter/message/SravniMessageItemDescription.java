package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001c"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/SravniMessageItemDescription;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;", "getStatus", "()Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;", "status", "", "c", "Z", "getIconFaceVisible", "()Z", "iconFaceVisible", "e", "getMessageTimeVisible", "messageTimeVisible", "d", "getMessageTime", "messageTime", "<init>", "(Ljava/lang/String;Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;ZLjava/lang/String;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SravniMessageItemDescription {
    @Nullable
    public final String a;
    @NotNull
    public final ViewHolderMessageStatusEnum b;
    public final boolean c;
    @Nullable
    public final String d;
    public final boolean e;

    public SravniMessageItemDescription(@Nullable String str, @NotNull ViewHolderMessageStatusEnum viewHolderMessageStatusEnum, boolean z, @Nullable String str2, boolean z2) {
        Intrinsics.checkParameterIsNotNull(viewHolderMessageStatusEnum, "status");
        this.a = str;
        this.b = viewHolderMessageStatusEnum;
        this.c = z;
        this.d = str2;
        this.e = z2;
    }

    public final boolean getIconFaceVisible() {
        return this.c;
    }

    @Nullable
    public final String getMessageTime() {
        return this.d;
    }

    public final boolean getMessageTimeVisible() {
        return this.e;
    }

    @NotNull
    public final ViewHolderMessageStatusEnum getStatus() {
        return this.b;
    }

    @Nullable
    public final String getText() {
        return this.a;
    }
}
