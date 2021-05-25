package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SaveDraftResponse;", "", "<init>", "()V", "Conflict", "Ok", "Lcom/avito/android/remote/model/SaveDraftResponse$Ok;", "Lcom/avito/android/remote/model/SaveDraftResponse$Conflict;", "publish_release"}, k = 1, mv = {1, 4, 2})
public abstract class SaveDraftResponse {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/SaveDraftResponse$Conflict;", "Lcom/avito/android/remote/model/SaveDraftResponse;", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "component1", "()Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "dialogInfo", "copy", "(Lcom/avito/android/remote/model/DeepLinksDialogInfo;)Lcom/avito/android/remote/model/SaveDraftResponse$Conflict;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "getDialogInfo", "<init>", "(Lcom/avito/android/remote/model/DeepLinksDialogInfo;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Conflict extends SaveDraftResponse {
        @SerializedName("dialog")
        @NotNull
        private final DeepLinksDialogInfo dialogInfo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Conflict(@NotNull DeepLinksDialogInfo deepLinksDialogInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLinksDialogInfo, "dialogInfo");
            this.dialogInfo = deepLinksDialogInfo;
        }

        public static /* synthetic */ Conflict copy$default(Conflict conflict, DeepLinksDialogInfo deepLinksDialogInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                deepLinksDialogInfo = conflict.dialogInfo;
            }
            return conflict.copy(deepLinksDialogInfo);
        }

        @NotNull
        public final DeepLinksDialogInfo component1() {
            return this.dialogInfo;
        }

        @NotNull
        public final Conflict copy(@NotNull DeepLinksDialogInfo deepLinksDialogInfo) {
            Intrinsics.checkNotNullParameter(deepLinksDialogInfo, "dialogInfo");
            return new Conflict(deepLinksDialogInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Conflict) && Intrinsics.areEqual(this.dialogInfo, ((Conflict) obj).dialogInfo);
            }
            return true;
        }

        @NotNull
        public final DeepLinksDialogInfo getDialogInfo() {
            return this.dialogInfo;
        }

        public int hashCode() {
            DeepLinksDialogInfo deepLinksDialogInfo = this.dialogInfo;
            if (deepLinksDialogInfo != null) {
                return deepLinksDialogInfo.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Conflict(dialogInfo=");
            L.append(this.dialogInfo);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/SaveDraftResponse$Ok;", "Lcom/avito/android/remote/model/SaveDraftResponse;", "Lcom/avito/android/remote/model/SaveDraftResponse$Ok$Draft;", "component1", "()Lcom/avito/android/remote/model/SaveDraftResponse$Ok$Draft;", "", "component2", "()Ljava/lang/String;", AnalyticFieldsName.draft, "message", "copy", "(Lcom/avito/android/remote/model/SaveDraftResponse$Ok$Draft;Ljava/lang/String;)Lcom/avito/android/remote/model/SaveDraftResponse$Ok;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/SaveDraftResponse$Ok$Draft;", "getDraft", "Ljava/lang/String;", "getMessage", "<init>", "(Lcom/avito/android/remote/model/SaveDraftResponse$Ok$Draft;Ljava/lang/String;)V", "Draft", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends SaveDraftResponse {
        @SerializedName(AnalyticFieldsName.draft)
        @NotNull
        private final Draft draft;
        @SerializedName("message")
        @Nullable
        private final String message;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/SaveDraftResponse$Ok$Draft;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "id", "version", "copy", "(Ljava/lang/String;I)Lcom/avito/android/remote/model/SaveDraftResponse$Ok$Draft;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getVersion", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;I)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Draft {
            @SerializedName("id")
            @NotNull
            private final String id;
            @SerializedName("version")
            private final int version;

            public Draft(@NotNull String str, int i) {
                Intrinsics.checkNotNullParameter(str, "id");
                this.id = str;
                this.version = i;
            }

            public static /* synthetic */ Draft copy$default(Draft draft, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = draft.id;
                }
                if ((i2 & 2) != 0) {
                    i = draft.version;
                }
                return draft.copy(str, i);
            }

            @NotNull
            public final String component1() {
                return this.id;
            }

            public final int component2() {
                return this.version;
            }

            @NotNull
            public final Draft copy(@NotNull String str, int i) {
                Intrinsics.checkNotNullParameter(str, "id");
                return new Draft(str, i);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Draft)) {
                    return false;
                }
                Draft draft = (Draft) obj;
                return Intrinsics.areEqual(this.id, draft.id) && this.version == draft.version;
            }

            @NotNull
            public final String getId() {
                return this.id;
            }

            public final int getVersion() {
                return this.version;
            }

            public int hashCode() {
                String str = this.id;
                return ((str != null ? str.hashCode() : 0) * 31) + this.version;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Draft(id=");
                L.append(this.id);
                L.append(", version=");
                return a.j(L, this.version, ")");
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Ok(Draft draft2, String str, int i, j jVar) {
            this(draft2, (i & 2) != 0 ? null : str);
        }

        public static /* synthetic */ Ok copy$default(Ok ok, Draft draft2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                draft2 = ok.draft;
            }
            if ((i & 2) != 0) {
                str = ok.message;
            }
            return ok.copy(draft2, str);
        }

        @NotNull
        public final Draft component1() {
            return this.draft;
        }

        @Nullable
        public final String component2() {
            return this.message;
        }

        @NotNull
        public final Ok copy(@NotNull Draft draft2, @Nullable String str) {
            Intrinsics.checkNotNullParameter(draft2, AnalyticFieldsName.draft);
            return new Ok(draft2, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ok)) {
                return false;
            }
            Ok ok = (Ok) obj;
            return Intrinsics.areEqual(this.draft, ok.draft) && Intrinsics.areEqual(this.message, ok.message);
        }

        @NotNull
        public final Draft getDraft() {
            return this.draft;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            Draft draft2 = this.draft;
            int i = 0;
            int hashCode = (draft2 != null ? draft2.hashCode() : 0) * 31;
            String str = this.message;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Ok(draft=");
            L.append(this.draft);
            L.append(", message=");
            return a.t(L, this.message, ")");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull Draft draft2, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(draft2, AnalyticFieldsName.draft);
            this.draft = draft2;
            this.message = str;
        }
    }

    private SaveDraftResponse() {
    }

    public /* synthetic */ SaveDraftResponse(j jVar) {
        this();
    }
}
