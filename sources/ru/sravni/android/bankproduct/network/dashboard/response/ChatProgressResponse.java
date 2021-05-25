package ru.sravni.android.bankproduct.network.dashboard.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J4\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0017\u0010\u0005¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/network/dashboard/response/ChatProgressResponse;", "", "", "Lru/sravni/android/bankproduct/network/dashboard/response/Draft;", "component1", "()Ljava/util/List;", "component2", "finance", "insurance", "copy", "(Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/network/dashboard/response/ChatProgressResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getInsurance", "getFinance", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatProgressResponse {
    @SerializedName("finance")
    @Nullable
    private final List<Draft> finance;
    @SerializedName("insurance")
    @Nullable
    private final List<Draft> insurance;

    public ChatProgressResponse(@Nullable List<Draft> list, @Nullable List<Draft> list2) {
        this.finance = list;
        this.insurance = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.dashboard.response.ChatProgressResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatProgressResponse copy$default(ChatProgressResponse chatProgressResponse, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = chatProgressResponse.finance;
        }
        if ((i & 2) != 0) {
            list2 = chatProgressResponse.insurance;
        }
        return chatProgressResponse.copy(list, list2);
    }

    @Nullable
    public final List<Draft> component1() {
        return this.finance;
    }

    @Nullable
    public final List<Draft> component2() {
        return this.insurance;
    }

    @NotNull
    public final ChatProgressResponse copy(@Nullable List<Draft> list, @Nullable List<Draft> list2) {
        return new ChatProgressResponse(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatProgressResponse)) {
            return false;
        }
        ChatProgressResponse chatProgressResponse = (ChatProgressResponse) obj;
        return Intrinsics.areEqual(this.finance, chatProgressResponse.finance) && Intrinsics.areEqual(this.insurance, chatProgressResponse.insurance);
    }

    @Nullable
    public final List<Draft> getFinance() {
        return this.finance;
    }

    @Nullable
    public final List<Draft> getInsurance() {
        return this.insurance;
    }

    public int hashCode() {
        List<Draft> list = this.finance;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Draft> list2 = this.insurance;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChatProgressResponse(finance=");
        L.append(this.finance);
        L.append(", insurance=");
        return a.w(L, this.insurance, ")");
    }
}
