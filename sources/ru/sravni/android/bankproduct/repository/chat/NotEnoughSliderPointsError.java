package ru.sravni.android.bankproduct.repository.chat;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/NotEnoughSliderPointsError;", "", "", AuthSource.SEND_ABUSE, "I", "getPoints", "()I", "points", AuthSource.BOOKING_ORDER, "getCardId", "cardId", "", "c", "Ljava/lang/String;", "getChatId", "()Ljava/lang/String;", "chatId", "<init>", "(IILjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class NotEnoughSliderPointsError extends Throwable {
    public final int a;
    public final int b;
    @NotNull
    public final String c;

    public NotEnoughSliderPointsError(int i, int i2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "chatId");
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public final int getCardId() {
        return this.b;
    }

    @NotNull
    public final String getChatId() {
        return this.c;
    }

    public final int getPoints() {
        return this.a;
    }
}
