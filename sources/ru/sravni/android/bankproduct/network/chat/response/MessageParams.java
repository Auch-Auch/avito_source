package ru.sravni.android.bankproduct.network.chat.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationMessageParamsRepo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB\u001f\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ(\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001e\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\n¨\u0006\u001f"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/MessageParams;", "", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo;", "toConversationMessageParams", "()Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo;", "", "component1", "()Ljava/lang/Boolean;", "Lru/sravni/android/bankproduct/network/chat/response/MessageParams$AnalyticsInfo;", "component2", "()Lru/sravni/android/bankproduct/network/chat/response/MessageParams$AnalyticsInfo;", "disableRollback", "analytics", "copy", "(Ljava/lang/Boolean;Lru/sravni/android/bankproduct/network/chat/response/MessageParams$AnalyticsInfo;)Lru/sravni/android/bankproduct/network/chat/response/MessageParams;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getDisableRollback", "Lru/sravni/android/bankproduct/network/chat/response/MessageParams$AnalyticsInfo;", "getAnalytics", "<init>", "(Ljava/lang/Boolean;Lru/sravni/android/bankproduct/network/chat/response/MessageParams$AnalyticsInfo;)V", "AnalyticsInfo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MessageParams {
    @SerializedName("analytics")
    @Nullable
    private final AnalyticsInfo analytics;
    @SerializedName("disableRollback")
    @Nullable
    private final Boolean disableRollback;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000e\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/MessageParams$AnalyticsInfo;", "", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo$AnalyticsInfoRepo;", "toAnalyticsInfoRepo", "()Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo$AnalyticsInfoRepo;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Boolean;", AnalyticFieldsName.productName, AnalyticFieldsName.step, "isProlongation", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lru/sravni/android/bankproduct/network/chat/response/MessageParams$AnalyticsInfo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getStep", "Ljava/lang/Boolean;", "getProductName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnalyticsInfo {
        @SerializedName("isProlongation")
        @Nullable
        private final Boolean isProlongation;
        @SerializedName(AnalyticFieldsName.productName)
        @Nullable
        private final String productName;
        @SerializedName(AnalyticFieldsName.step)
        @Nullable
        private final String step;

        public AnalyticsInfo(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
            this.productName = str;
            this.step = str2;
            this.isProlongation = bool;
        }

        public static /* synthetic */ AnalyticsInfo copy$default(AnalyticsInfo analyticsInfo, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = analyticsInfo.productName;
            }
            if ((i & 2) != 0) {
                str2 = analyticsInfo.step;
            }
            if ((i & 4) != 0) {
                bool = analyticsInfo.isProlongation;
            }
            return analyticsInfo.copy(str, str2, bool);
        }

        @Nullable
        public final String component1() {
            return this.productName;
        }

        @Nullable
        public final String component2() {
            return this.step;
        }

        @Nullable
        public final Boolean component3() {
            return this.isProlongation;
        }

        @NotNull
        public final AnalyticsInfo copy(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
            return new AnalyticsInfo(str, str2, bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnalyticsInfo)) {
                return false;
            }
            AnalyticsInfo analyticsInfo = (AnalyticsInfo) obj;
            return Intrinsics.areEqual(this.productName, analyticsInfo.productName) && Intrinsics.areEqual(this.step, analyticsInfo.step) && Intrinsics.areEqual(this.isProlongation, analyticsInfo.isProlongation);
        }

        @Nullable
        public final String getProductName() {
            return this.productName;
        }

        @Nullable
        public final String getStep() {
            return this.step;
        }

        public int hashCode() {
            String str = this.productName;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.step;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool = this.isProlongation;
            if (bool != null) {
                i = bool.hashCode();
            }
            return hashCode2 + i;
        }

        @Nullable
        public final Boolean isProlongation() {
            return this.isProlongation;
        }

        @NotNull
        public final ConversationMessageParamsRepo.AnalyticsInfoRepo toAnalyticsInfoRepo() {
            return new ConversationMessageParamsRepo.AnalyticsInfoRepo(this.productName, this.step, this.isProlongation);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("AnalyticsInfo(productName=");
            L.append(this.productName);
            L.append(", step=");
            L.append(this.step);
            L.append(", isProlongation=");
            return a.o(L, this.isProlongation, ")");
        }
    }

    public MessageParams() {
        this(null, null, 3, null);
    }

    public MessageParams(@Nullable Boolean bool, @Nullable AnalyticsInfo analyticsInfo) {
        this.disableRollback = bool;
        this.analytics = analyticsInfo;
    }

    public static /* synthetic */ MessageParams copy$default(MessageParams messageParams, Boolean bool, AnalyticsInfo analyticsInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = messageParams.disableRollback;
        }
        if ((i & 2) != 0) {
            analyticsInfo = messageParams.analytics;
        }
        return messageParams.copy(bool, analyticsInfo);
    }

    @Nullable
    public final Boolean component1() {
        return this.disableRollback;
    }

    @Nullable
    public final AnalyticsInfo component2() {
        return this.analytics;
    }

    @NotNull
    public final MessageParams copy(@Nullable Boolean bool, @Nullable AnalyticsInfo analyticsInfo) {
        return new MessageParams(bool, analyticsInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageParams)) {
            return false;
        }
        MessageParams messageParams = (MessageParams) obj;
        return Intrinsics.areEqual(this.disableRollback, messageParams.disableRollback) && Intrinsics.areEqual(this.analytics, messageParams.analytics);
    }

    @Nullable
    public final AnalyticsInfo getAnalytics() {
        return this.analytics;
    }

    @Nullable
    public final Boolean getDisableRollback() {
        return this.disableRollback;
    }

    public int hashCode() {
        Boolean bool = this.disableRollback;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        AnalyticsInfo analyticsInfo = this.analytics;
        if (analyticsInfo != null) {
            i = analyticsInfo.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public final ConversationMessageParamsRepo toConversationMessageParams() {
        Boolean bool = this.disableRollback;
        AnalyticsInfo analyticsInfo = this.analytics;
        return new ConversationMessageParamsRepo(bool, analyticsInfo != null ? analyticsInfo.toAnalyticsInfoRepo() : null);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MessageParams(disableRollback=");
        L.append(this.disableRollback);
        L.append(", analytics=");
        L.append(this.analytics);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageParams(Boolean bool, AnalyticsInfo analyticsInfo, int i, j jVar) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : analyticsInfo);
    }
}
