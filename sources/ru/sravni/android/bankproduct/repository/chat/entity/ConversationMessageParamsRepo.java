package ru.sravni.android.bankproduct.repository.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.chat.entity.ChatAnalyticInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ConversationMessageParamsDomain;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u0001 B\u001f\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ(\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageParamsDomain;", "toConversationMessageParamsDomain", "()Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageParamsDomain;", "", "component1", "()Ljava/lang/Boolean;", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo$AnalyticsInfoRepo;", "component2", "()Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo$AnalyticsInfoRepo;", "disableRollback", "analyticsInfo", "copy", "(Ljava/lang/Boolean;Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo$AnalyticsInfoRepo;)Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo$AnalyticsInfoRepo;", "getAnalyticsInfo", AuthSource.SEND_ABUSE, "Ljava/lang/Boolean;", "getDisableRollback", "<init>", "(Ljava/lang/Boolean;Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo$AnalyticsInfoRepo;)V", "AnalyticsInfoRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ConversationMessageParamsRepo {
    @Nullable
    public final Boolean a;
    @Nullable
    public final AnalyticsInfoRepo b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u000e\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0007¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo$AnalyticsInfoRepo;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/ChatAnalyticInfoDomain;", "toChatAnalyticInfoDomain", "()Lru/sravni/android/bankproduct/domain/chat/entity/ChatAnalyticInfoDomain;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Boolean;", AnalyticFieldsName.productName, AnalyticFieldsName.step, "isProlongation", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo$AnalyticsInfoRepo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/Boolean;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStep", AuthSource.SEND_ABUSE, "getProductName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnalyticsInfoRepo {
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final Boolean c;

        public AnalyticsInfoRepo(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
            this.a = str;
            this.b = str2;
            this.c = bool;
        }

        public static /* synthetic */ AnalyticsInfoRepo copy$default(AnalyticsInfoRepo analyticsInfoRepo, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = analyticsInfoRepo.a;
            }
            if ((i & 2) != 0) {
                str2 = analyticsInfoRepo.b;
            }
            if ((i & 4) != 0) {
                bool = analyticsInfoRepo.c;
            }
            return analyticsInfoRepo.copy(str, str2, bool);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final Boolean component3() {
            return this.c;
        }

        @NotNull
        public final AnalyticsInfoRepo copy(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
            return new AnalyticsInfoRepo(str, str2, bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnalyticsInfoRepo)) {
                return false;
            }
            AnalyticsInfoRepo analyticsInfoRepo = (AnalyticsInfoRepo) obj;
            return Intrinsics.areEqual(this.a, analyticsInfoRepo.a) && Intrinsics.areEqual(this.b, analyticsInfoRepo.b) && Intrinsics.areEqual(this.c, analyticsInfoRepo.c);
        }

        @Nullable
        public final String getProductName() {
            return this.a;
        }

        @Nullable
        public final String getStep() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool = this.c;
            if (bool != null) {
                i = bool.hashCode();
            }
            return hashCode2 + i;
        }

        @Nullable
        public final Boolean isProlongation() {
            return this.c;
        }

        @NotNull
        public final ChatAnalyticInfoDomain toChatAnalyticInfoDomain() {
            return new ChatAnalyticInfoDomain(this.a, this.b, this.c);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("AnalyticsInfoRepo(productName=");
            L.append(this.a);
            L.append(", step=");
            L.append(this.b);
            L.append(", isProlongation=");
            return a.o(L, this.c, ")");
        }
    }

    public ConversationMessageParamsRepo() {
        this(null, null, 3, null);
    }

    public ConversationMessageParamsRepo(@Nullable Boolean bool, @Nullable AnalyticsInfoRepo analyticsInfoRepo) {
        this.a = bool;
        this.b = analyticsInfoRepo;
    }

    public static /* synthetic */ ConversationMessageParamsRepo copy$default(ConversationMessageParamsRepo conversationMessageParamsRepo, Boolean bool, AnalyticsInfoRepo analyticsInfoRepo, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = conversationMessageParamsRepo.a;
        }
        if ((i & 2) != 0) {
            analyticsInfoRepo = conversationMessageParamsRepo.b;
        }
        return conversationMessageParamsRepo.copy(bool, analyticsInfoRepo);
    }

    @Nullable
    public final Boolean component1() {
        return this.a;
    }

    @Nullable
    public final AnalyticsInfoRepo component2() {
        return this.b;
    }

    @NotNull
    public final ConversationMessageParamsRepo copy(@Nullable Boolean bool, @Nullable AnalyticsInfoRepo analyticsInfoRepo) {
        return new ConversationMessageParamsRepo(bool, analyticsInfoRepo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConversationMessageParamsRepo)) {
            return false;
        }
        ConversationMessageParamsRepo conversationMessageParamsRepo = (ConversationMessageParamsRepo) obj;
        return Intrinsics.areEqual(this.a, conversationMessageParamsRepo.a) && Intrinsics.areEqual(this.b, conversationMessageParamsRepo.b);
    }

    @Nullable
    public final AnalyticsInfoRepo getAnalyticsInfo() {
        return this.b;
    }

    @Nullable
    public final Boolean getDisableRollback() {
        return this.a;
    }

    public int hashCode() {
        Boolean bool = this.a;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        AnalyticsInfoRepo analyticsInfoRepo = this.b;
        if (analyticsInfoRepo != null) {
            i = analyticsInfoRepo.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public final ConversationMessageParamsDomain toConversationMessageParamsDomain() {
        return new ConversationMessageParamsDomain(this.a);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ConversationMessageParamsRepo(disableRollback=");
        L.append(this.a);
        L.append(", analyticsInfo=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationMessageParamsRepo(Boolean bool, AnalyticsInfoRepo analyticsInfoRepo, int i, j jVar) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : analyticsInfoRepo);
    }
}
