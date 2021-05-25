package com.sumsub.sns.core.data.model.remote.response;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.remote.RemoteRequiredDoc;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\b\u001a\u00020\u00002\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R'\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/RequiredDocsResponse;", "", "", "Lcom/sumsub/sns/core/data/model/DocumentType;", "Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc;", "component1", "()Ljava/util/Map;", "data", "copy", "(Ljava/util/Map;)Lcom/sumsub/sns/core/data/model/remote/response/RequiredDocsResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getData", "<init>", "(Ljava/util/Map;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class RequiredDocsResponse {
    @NotNull
    public final Map<DocumentType, RemoteRequiredDoc> a;

    public RequiredDocsResponse(@NotNull Map<DocumentType, RemoteRequiredDoc> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        this.a = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.remote.response.RequiredDocsResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequiredDocsResponse copy$default(RequiredDocsResponse requiredDocsResponse, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = requiredDocsResponse.a;
        }
        return requiredDocsResponse.copy(map);
    }

    @NotNull
    public final Map<DocumentType, RemoteRequiredDoc> component1() {
        return this.a;
    }

    @NotNull
    public final RequiredDocsResponse copy(@NotNull Map<DocumentType, RemoteRequiredDoc> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        return new RequiredDocsResponse(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof RequiredDocsResponse) && Intrinsics.areEqual(this.a, ((RequiredDocsResponse) obj).a);
        }
        return true;
    }

    @NotNull
    public final Map<DocumentType, RemoteRequiredDoc> getData() {
        return this.a;
    }

    public int hashCode() {
        Map<DocumentType, RemoteRequiredDoc> map = this.a;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.x(a.L("RequiredDocsResponse(data="), this.a, ")");
    }
}
