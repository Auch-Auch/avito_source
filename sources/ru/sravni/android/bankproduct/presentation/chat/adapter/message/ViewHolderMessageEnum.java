package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageEnum;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "SRAVNI", "USER", "DOCUMENT", "BOT_FACE", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public enum ViewHolderMessageEnum {
    SRAVNI(0),
    USER(1),
    DOCUMENT(2),
    BOT_FACE(4);
    
    private final int value;

    private ViewHolderMessageEnum(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
