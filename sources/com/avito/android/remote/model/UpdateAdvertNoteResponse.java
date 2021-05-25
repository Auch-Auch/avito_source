package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/UpdateAdvertNoteResponse;", "", "", "isDeleted", "Z", "()Z", "<init>", "(Z)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class UpdateAdvertNoteResponse {
    @SerializedName("isDeleted")
    private final boolean isDeleted;

    public UpdateAdvertNoteResponse(boolean z) {
        this.isDeleted = z;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }
}
