package com.avito.android.beduin.model;

import a2.b.a.a.a;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/avito/android/beduin/model/BeduinActionsResponse;", "", "", "Lcom/avito/android/beduin/core/action/BeduinAction;", "component1", "()Ljava/util/List;", "actions", "copy", "(Ljava/util/List;)Lcom/avito/android/beduin/model/BeduinActionsResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getActions", "<init>", "(Ljava/util/List;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinActionsResponse {
    @NotNull
    public final List<BeduinAction> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.action.BeduinAction> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinActionsResponse(@NotNull List<? extends BeduinAction> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.a = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.beduin.model.BeduinActionsResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeduinActionsResponse copy$default(BeduinActionsResponse beduinActionsResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = beduinActionsResponse.a;
        }
        return beduinActionsResponse.copy(list);
    }

    @NotNull
    public final List<BeduinAction> component1() {
        return this.a;
    }

    @NotNull
    public final BeduinActionsResponse copy(@NotNull List<? extends BeduinAction> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        return new BeduinActionsResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof BeduinActionsResponse) && Intrinsics.areEqual(this.a, ((BeduinActionsResponse) obj).a);
        }
        return true;
    }

    @NotNull
    public final List<BeduinAction> getActions() {
        return this.a;
    }

    public int hashCode() {
        List<BeduinAction> list = this.a;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.w(a.L("BeduinActionsResponse(actions="), this.a, ")");
    }
}
