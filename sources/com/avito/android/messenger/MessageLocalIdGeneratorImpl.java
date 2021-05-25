package com.avito.android.messenger;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RandomKeyProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/MessageLocalIdGeneratorImpl;", "Lcom/avito/android/messenger/MessageLocalIdGenerator;", "", "nextLocalId", "()Ljava/lang/String;", "Lcom/avito/android/util/RandomKeyProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/RandomKeyProvider;", "randomKeyProvider", "<init>", "(Lcom/avito/android/util/RandomKeyProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageLocalIdGeneratorImpl implements MessageLocalIdGenerator {
    public final RandomKeyProvider a;

    public MessageLocalIdGeneratorImpl(@NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(randomKeyProvider, "randomKeyProvider");
        this.a = randomKeyProvider;
    }

    @Override // com.avito.android.messenger.MessageLocalIdGenerator
    @NotNull
    public String nextLocalId() {
        return this.a.generateKey();
    }
}
