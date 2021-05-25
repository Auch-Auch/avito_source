package ru.sravni.android.bankproduct.repository.chat;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/NullSavedSearchInContentCard;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getChatId", "()Ljava/lang/String;", "chatId", "", AuthSource.SEND_ABUSE, "I", "getCardId", "()I", "cardId", "<init>", "(ILjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class NullSavedSearchInContentCard extends Throwable {
    public final int a;
    @NotNull
    public final String b;

    public NullSavedSearchInContentCard(int i, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "chatId");
        this.a = i;
        this.b = str;
    }

    public final int getCardId() {
        return this.a;
    }

    @NotNull
    public final String getChatId() {
        return this.b;
    }
}
