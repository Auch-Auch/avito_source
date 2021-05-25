package com.avito.android.beduin.model;

import a2.b.a.a.a;
import androidx.annotation.Keep;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/beduin/model/BeduinComponentsResponse;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "component2", "()Ljava/util/List;", "title", "components", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/beduin/model/BeduinComponentsResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getComponents", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinComponentsResponse {
    @NotNull
    private final List<BeduinModel> components;
    @Nullable
    private final String title;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.model.container.component.BeduinModel> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinComponentsResponse(@Nullable String str, @NotNull List<? extends BeduinModel> list) {
        Intrinsics.checkNotNullParameter(list, "components");
        this.title = str;
        this.components = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.beduin.model.BeduinComponentsResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeduinComponentsResponse copy$default(BeduinComponentsResponse beduinComponentsResponse, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = beduinComponentsResponse.title;
        }
        if ((i & 2) != 0) {
            list = beduinComponentsResponse.components;
        }
        return beduinComponentsResponse.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<BeduinModel> component2() {
        return this.components;
    }

    @NotNull
    public final BeduinComponentsResponse copy(@Nullable String str, @NotNull List<? extends BeduinModel> list) {
        Intrinsics.checkNotNullParameter(list, "components");
        return new BeduinComponentsResponse(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BeduinComponentsResponse)) {
            return false;
        }
        BeduinComponentsResponse beduinComponentsResponse = (BeduinComponentsResponse) obj;
        return Intrinsics.areEqual(this.title, beduinComponentsResponse.title) && Intrinsics.areEqual(this.components, beduinComponentsResponse.components);
    }

    @NotNull
    public final List<BeduinModel> getComponents() {
        return this.components;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<BeduinModel> list = this.components;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinComponentsResponse(title=");
        L.append(this.title);
        L.append(", components=");
        return a.w(L, this.components, ")");
    }
}
