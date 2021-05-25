package com.avito.android.user_advert.advert;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_advert/advert/DraftId;", "Lcom/avito/android/user_advert/advert/DetailsId;", "", "component1", "()Ljava/lang/String;", "draftId", "copy", "(Ljava/lang/String;)Lcom/avito/android/user_advert/advert/DraftId;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDraftId", "<init>", "(Ljava/lang/String;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class DraftId extends DetailsId {
    @NotNull
    public final String a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DraftId(@NotNull String str) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "draftId");
        this.a = str;
    }

    public static /* synthetic */ DraftId copy$default(DraftId draftId, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = draftId.a;
        }
        return draftId.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final DraftId copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        return new DraftId(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof DraftId) && Intrinsics.areEqual(this.a, ((DraftId) obj).a);
        }
        return true;
    }

    @NotNull
    public final String getDraftId() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.t(a.L("DraftId(draftId="), this.a, ")");
    }
}
