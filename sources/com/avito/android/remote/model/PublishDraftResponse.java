package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/PublishDraftResponse;", "", "<init>", "()V", "NotFound", "Ok", "Lcom/avito/android/remote/model/PublishDraftResponse$Ok;", "Lcom/avito/android/remote/model/PublishDraftResponse$NotFound;", "publish_release"}, k = 1, mv = {1, 4, 2})
public abstract class PublishDraftResponse {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/PublishDraftResponse$NotFound;", "Lcom/avito/android/remote/model/PublishDraftResponse;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotFound extends PublishDraftResponse {
        @NotNull
        public static final NotFound INSTANCE = new NotFound();

        private NotFound() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/PublishDraftResponse$Ok;", "Lcom/avito/android/remote/model/PublishDraftResponse;", "Lcom/avito/android/remote/model/PublishDraftResponse$Ok$Draft;", "component1", "()Lcom/avito/android/remote/model/PublishDraftResponse$Ok$Draft;", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "component2", "()Lcom/avito/android/remote/model/DeepLinksDialogInfo;", AnalyticFieldsName.draft, "dialogInfo", "copy", "(Lcom/avito/android/remote/model/PublishDraftResponse$Ok$Draft;Lcom/avito/android/remote/model/DeepLinksDialogInfo;)Lcom/avito/android/remote/model/PublishDraftResponse$Ok;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "getDialogInfo", "Lcom/avito/android/remote/model/PublishDraftResponse$Ok$Draft;", "getDraft", "<init>", "(Lcom/avito/android/remote/model/PublishDraftResponse$Ok$Draft;Lcom/avito/android/remote/model/DeepLinksDialogInfo;)V", "Draft", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends PublishDraftResponse {
        @SerializedName("dialog")
        @NotNull
        private final DeepLinksDialogInfo dialogInfo;
        @SerializedName(AnalyticFieldsName.draft)
        @NotNull
        private final Draft draft;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/PublishDraftResponse$Ok$Draft;", "", "", "component1", "()Ljava/lang/String;", "sessionId", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/PublishDraftResponse$Ok$Draft;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "<init>", "(Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Draft {
            @SerializedName("publishSessionId")
            @NotNull
            private final String sessionId;

            public Draft(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "sessionId");
                this.sessionId = str;
            }

            public static /* synthetic */ Draft copy$default(Draft draft, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = draft.sessionId;
                }
                return draft.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.sessionId;
            }

            @NotNull
            public final Draft copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "sessionId");
                return new Draft(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Draft) && Intrinsics.areEqual(this.sessionId, ((Draft) obj).sessionId);
                }
                return true;
            }

            @NotNull
            public final String getSessionId() {
                return this.sessionId;
            }

            public int hashCode() {
                String str = this.sessionId;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.t(a.L("Draft(sessionId="), this.sessionId, ")");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull Draft draft2, @NotNull DeepLinksDialogInfo deepLinksDialogInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(draft2, AnalyticFieldsName.draft);
            Intrinsics.checkNotNullParameter(deepLinksDialogInfo, "dialogInfo");
            this.draft = draft2;
            this.dialogInfo = deepLinksDialogInfo;
        }

        public static /* synthetic */ Ok copy$default(Ok ok, Draft draft2, DeepLinksDialogInfo deepLinksDialogInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                draft2 = ok.draft;
            }
            if ((i & 2) != 0) {
                deepLinksDialogInfo = ok.dialogInfo;
            }
            return ok.copy(draft2, deepLinksDialogInfo);
        }

        @NotNull
        public final Draft component1() {
            return this.draft;
        }

        @NotNull
        public final DeepLinksDialogInfo component2() {
            return this.dialogInfo;
        }

        @NotNull
        public final Ok copy(@NotNull Draft draft2, @NotNull DeepLinksDialogInfo deepLinksDialogInfo) {
            Intrinsics.checkNotNullParameter(draft2, AnalyticFieldsName.draft);
            Intrinsics.checkNotNullParameter(deepLinksDialogInfo, "dialogInfo");
            return new Ok(draft2, deepLinksDialogInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ok)) {
                return false;
            }
            Ok ok = (Ok) obj;
            return Intrinsics.areEqual(this.draft, ok.draft) && Intrinsics.areEqual(this.dialogInfo, ok.dialogInfo);
        }

        @NotNull
        public final DeepLinksDialogInfo getDialogInfo() {
            return this.dialogInfo;
        }

        @NotNull
        public final Draft getDraft() {
            return this.draft;
        }

        public int hashCode() {
            Draft draft2 = this.draft;
            int i = 0;
            int hashCode = (draft2 != null ? draft2.hashCode() : 0) * 31;
            DeepLinksDialogInfo deepLinksDialogInfo = this.dialogInfo;
            if (deepLinksDialogInfo != null) {
                i = deepLinksDialogInfo.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Ok(draft=");
            L.append(this.draft);
            L.append(", dialogInfo=");
            L.append(this.dialogInfo);
            L.append(")");
            return L.toString();
        }
    }

    private PublishDraftResponse() {
    }

    public /* synthetic */ PublishDraftResponse(j jVar) {
        this();
    }
}
