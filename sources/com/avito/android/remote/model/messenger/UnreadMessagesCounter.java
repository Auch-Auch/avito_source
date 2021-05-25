package com.avito.android.remote.model.messenger;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/messenger/UnreadMessagesCounter;", "", "", "toString", "()Ljava/lang/String;", "", "messagesCount", "I", "getMessagesCount", "()I", "channelsCount", "getChannelsCount", "<init>", "(II)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class UnreadMessagesCounter {
    @SerializedName("channelsCount")
    private final int channelsCount;
    @SerializedName("messagesCount")
    private final int messagesCount;

    public UnreadMessagesCounter(int i, int i2) {
        this.channelsCount = i;
        this.messagesCount = i2;
    }

    public final int getChannelsCount() {
        return this.channelsCount;
    }

    public final int getMessagesCount() {
        return this.messagesCount;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UnreadMessagesCounter { channelsCount = ");
        L.append(this.channelsCount);
        L.append(", messagesCount = ");
        return a.j(L, this.messagesCount, " }");
    }
}
