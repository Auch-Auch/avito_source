package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/UploadResult;", "", "", "component1", "()J", "imageId", "copy", "(J)Lcom/avito/android/remote/model/UploadResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getImageId", "<init>", "(J)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class UploadResult {
    @SerializedName("imageId")
    private final long imageId;

    public UploadResult(long j) {
        this.imageId = j;
    }

    public static /* synthetic */ UploadResult copy$default(UploadResult uploadResult, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = uploadResult.imageId;
        }
        return uploadResult.copy(j);
    }

    public final long component1() {
        return this.imageId;
    }

    @NotNull
    public final UploadResult copy(long j) {
        return new UploadResult(j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof UploadResult) && this.imageId == ((UploadResult) obj).imageId;
        }
        return true;
    }

    public final long getImageId() {
        return this.imageId;
    }

    public int hashCode() {
        return c.a(this.imageId);
    }

    @NotNull
    public String toString() {
        return a.l(a.L("UploadResult(imageId="), this.imageId, ")");
    }
}
