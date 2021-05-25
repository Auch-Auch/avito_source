package a2.a.a.o1.d.a0.f;

import a2.b.a.a.a;
import com.avito.android.messenger.conversation.mvi.file_upload.UploadUniqueInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class n {
    @NotNull
    public final m a;
    @NotNull
    public final UploadUniqueInfo b;
    @Nullable
    public final String c;

    public n(@NotNull m mVar, @NotNull UploadUniqueInfo uploadUniqueInfo, @Nullable String str) {
        Intrinsics.checkNotNullParameter(mVar, "status");
        Intrinsics.checkNotNullParameter(uploadUniqueInfo, "uploadUniqueInfo");
        this.a = mVar;
        this.b = uploadUniqueInfo;
        this.c = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.areEqual(this.a, nVar.a) && Intrinsics.areEqual(this.b, nVar.b) && Intrinsics.areEqual(this.c, nVar.c);
    }

    public int hashCode() {
        m mVar = this.a;
        int i = 0;
        int hashCode = (mVar != null ? mVar.hashCode() : 0) * 31;
        UploadUniqueInfo uploadUniqueInfo = this.b;
        int hashCode2 = (hashCode + (uploadUniqueInfo != null ? uploadUniqueInfo.hashCode() : 0)) * 31;
        String str = this.c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UploadStatusInfo(status=");
        L.append(this.a);
        L.append(", uploadUniqueInfo=");
        L.append(this.b);
        L.append(", filePath=");
        return a.t(L, this.c, ")");
    }
}
