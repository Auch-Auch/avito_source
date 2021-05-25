package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/DeleteDraftResponse;", "", "Lcom/avito/android/remote/model/DeleteDraftResponse$Draft;", AnalyticFieldsName.draft, "Lcom/avito/android/remote/model/DeleteDraftResponse$Draft;", "getDraft", "()Lcom/avito/android/remote/model/DeleteDraftResponse$Draft;", "<init>", "(Lcom/avito/android/remote/model/DeleteDraftResponse$Draft;)V", "Draft", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteDraftResponse {
    @SerializedName(AnalyticFieldsName.draft)
    @NotNull
    private final Draft draft;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/DeleteDraftResponse$Draft;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Draft {
        @SerializedName("id")
        @NotNull
        private final String id;

        public Draft(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.id = str;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    public DeleteDraftResponse(@NotNull Draft draft2) {
        Intrinsics.checkNotNullParameter(draft2, AnalyticFieldsName.draft);
        this.draft = draft2;
    }

    @NotNull
    public final Draft getDraft() {
        return this.draft;
    }
}
