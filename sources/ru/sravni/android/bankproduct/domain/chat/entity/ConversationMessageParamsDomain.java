package ru.sravni.android.bankproduct.domain.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageParamsDomain;", "", "", "component1", "()Ljava/lang/Boolean;", "disableRollback", "copy", "(Ljava/lang/Boolean;)Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageParamsDomain;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Boolean;", "getDisableRollback", "<init>", "(Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ConversationMessageParamsDomain {
    @Nullable
    public final Boolean a;

    public ConversationMessageParamsDomain() {
        this(null, 1, null);
    }

    public ConversationMessageParamsDomain(@Nullable Boolean bool) {
        this.a = bool;
    }

    public static /* synthetic */ ConversationMessageParamsDomain copy$default(ConversationMessageParamsDomain conversationMessageParamsDomain, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = conversationMessageParamsDomain.a;
        }
        return conversationMessageParamsDomain.copy(bool);
    }

    @Nullable
    public final Boolean component1() {
        return this.a;
    }

    @NotNull
    public final ConversationMessageParamsDomain copy(@Nullable Boolean bool) {
        return new ConversationMessageParamsDomain(bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ConversationMessageParamsDomain) && Intrinsics.areEqual(this.a, ((ConversationMessageParamsDomain) obj).a);
        }
        return true;
    }

    @Nullable
    public final Boolean getDisableRollback() {
        return this.a;
    }

    public int hashCode() {
        Boolean bool = this.a;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.o(a.L("ConversationMessageParamsDomain(disableRollback="), this.a, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationMessageParamsDomain(Boolean bool, int i, j jVar) {
        this((i & 1) != 0 ? null : bool);
    }
}
