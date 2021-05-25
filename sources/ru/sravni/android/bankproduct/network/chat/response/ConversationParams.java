package ru.sravni.android.bankproduct.network.chat.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/ConversationParams;", "", "", "savedSearchID", "Ljava/lang/String;", "getSavedSearchID", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ConversationParams {
    @SerializedName("savedSearch")
    @Nullable
    private final String savedSearchID;

    public ConversationParams() {
        this(null, 1, null);
    }

    public ConversationParams(@Nullable String str) {
        this.savedSearchID = str;
    }

    @Nullable
    public final String getSavedSearchID() {
        return this.savedSearchID;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationParams(String str, int i, j jVar) {
        this((i & 1) != 0 ? null : str);
    }
}
