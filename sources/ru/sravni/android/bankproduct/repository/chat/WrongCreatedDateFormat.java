package ru.sravni.android.bankproduct.repository.chat;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/WrongCreatedDateFormat;", "", "", "c", "Ljava/lang/String;", "getDateField", "()Ljava/lang/String;", "dateField", AuthSource.BOOKING_ORDER, "getChatId", "chatId", "", AuthSource.SEND_ABUSE, "I", "getCardId", "()I", "cardId", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class WrongCreatedDateFormat extends Throwable {
    public final int a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;

    public WrongCreatedDateFormat(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "chatId");
        Intrinsics.checkParameterIsNotNull(str2, "dateField");
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public final int getCardId() {
        return this.a;
    }

    @NotNull
    public final String getChatId() {
        return this.b;
    }

    @NotNull
    public final String getDateField() {
        return this.c;
    }
}
