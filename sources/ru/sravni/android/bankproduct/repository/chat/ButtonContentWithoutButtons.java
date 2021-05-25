package ru.sravni.android.bankproduct.repository.chat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/ButtonContentWithoutButtons;", "", "", "cardId", "", "chatId", "<init>", "(ILjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ButtonContentWithoutButtons extends Throwable {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonContentWithoutButtons(int i, @NotNull String str) {
        super("No buttons in button in card " + i + " in chat " + str);
        Intrinsics.checkParameterIsNotNull(str, "chatId");
    }
}
