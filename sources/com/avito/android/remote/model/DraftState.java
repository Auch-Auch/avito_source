package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.publish.drafts.LocalPublishState;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005JF\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0005R$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/DraftState;", "", "", "Lcom/avito/android/remote/model/DraftStep;", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/DraftField;", "component2", "", "component3", "steps", "fields", "changedIds", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/avito/android/remote/model/DraftState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getFields", "getSteps", "getChangedIds", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DraftState {
    @SerializedName(LocalPublishState.CHANGED_IDS)
    @Nullable
    private final List<String> changedIds;
    @SerializedName("fields")
    @Nullable
    private final List<DraftField> fields;
    @SerializedName("steps")
    @Nullable
    private final List<DraftStep> steps;

    public DraftState() {
        this(null, null, null, 7, null);
    }

    public DraftState(@Nullable List<DraftStep> list, @Nullable List<DraftField> list2, @Nullable List<String> list3) {
        this.steps = list;
        this.fields = list2;
        this.changedIds = list3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.DraftState */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DraftState copy$default(DraftState draftState, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = draftState.steps;
        }
        if ((i & 2) != 0) {
            list2 = draftState.fields;
        }
        if ((i & 4) != 0) {
            list3 = draftState.changedIds;
        }
        return draftState.copy(list, list2, list3);
    }

    @Nullable
    public final List<DraftStep> component1() {
        return this.steps;
    }

    @Nullable
    public final List<DraftField> component2() {
        return this.fields;
    }

    @Nullable
    public final List<String> component3() {
        return this.changedIds;
    }

    @NotNull
    public final DraftState copy(@Nullable List<DraftStep> list, @Nullable List<DraftField> list2, @Nullable List<String> list3) {
        return new DraftState(list, list2, list3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DraftState)) {
            return false;
        }
        DraftState draftState = (DraftState) obj;
        return Intrinsics.areEqual(this.steps, draftState.steps) && Intrinsics.areEqual(this.fields, draftState.fields) && Intrinsics.areEqual(this.changedIds, draftState.changedIds);
    }

    @Nullable
    public final List<String> getChangedIds() {
        return this.changedIds;
    }

    @Nullable
    public final List<DraftField> getFields() {
        return this.fields;
    }

    @Nullable
    public final List<DraftStep> getSteps() {
        return this.steps;
    }

    public int hashCode() {
        List<DraftStep> list = this.steps;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<DraftField> list2 = this.fields;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.changedIds;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DraftState(steps=");
        L.append(this.steps);
        L.append(", fields=");
        L.append(this.fields);
        L.append(", changedIds=");
        return a.w(L, this.changedIds, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DraftState(List list, List list2, List list3, int i, j jVar) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
    }
}
