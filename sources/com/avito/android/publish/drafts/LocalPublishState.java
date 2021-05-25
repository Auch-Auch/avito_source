package com.avito.android.publish.drafts;

import a2.b.a.a.a;
import androidx.annotation.Keep;
import com.avito.android.remote.annotations.Field;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB+\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J4\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/avito/android/publish/drafts/LocalPublishState;", "", "", "Lcom/avito/android/publish/drafts/IdValuePair;", "component1", "()Ljava/util/List;", "", "component2", "fields", LocalPublishState.CHANGED_IDS, "copy", "(Ljava/util/List;Ljava/util/List;)Lcom/avito/android/publish/drafts/LocalPublishState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getFields", "getChangedFieldIds", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Companion", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class LocalPublishState {
    @NotNull
    public static final String CHANGED_IDS = "changedFieldIds";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String FIELDS = "fields";
    @SerializedName(CHANGED_IDS)
    @Nullable
    private final List<String> changedFieldIds;
    @SerializedName("fields")
    @Nullable
    private final List<IdValuePair> fields;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/drafts/LocalPublishState$Companion;", "", "", "CHANGED_IDS", "Ljava/lang/String;", "FIELDS", "<init>", "()V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public LocalPublishState() {
        this(null, null, 3, null);
    }

    public LocalPublishState(@Nullable List<IdValuePair> list, @Nullable List<String> list2) {
        this.fields = list;
        this.changedFieldIds = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.publish.drafts.LocalPublishState */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LocalPublishState copy$default(LocalPublishState localPublishState, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = localPublishState.fields;
        }
        if ((i & 2) != 0) {
            list2 = localPublishState.changedFieldIds;
        }
        return localPublishState.copy(list, list2);
    }

    @Nullable
    public final List<IdValuePair> component1() {
        return this.fields;
    }

    @Nullable
    public final List<String> component2() {
        return this.changedFieldIds;
    }

    @NotNull
    public final LocalPublishState copy(@Nullable List<IdValuePair> list, @Nullable List<String> list2) {
        return new LocalPublishState(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalPublishState)) {
            return false;
        }
        LocalPublishState localPublishState = (LocalPublishState) obj;
        return Intrinsics.areEqual(this.fields, localPublishState.fields) && Intrinsics.areEqual(this.changedFieldIds, localPublishState.changedFieldIds);
    }

    @Field(name = CHANGED_IDS)
    @Nullable
    public final List<String> getChangedFieldIds() {
        return this.changedFieldIds;
    }

    @Field(name = "fields")
    @Nullable
    public final List<IdValuePair> getFields() {
        return this.fields;
    }

    public int hashCode() {
        List<IdValuePair> list = this.fields;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.changedFieldIds;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("LocalPublishState(fields=");
        L.append(this.fields);
        L.append(", changedFieldIds=");
        return a.w(L, this.changedFieldIds, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalPublishState(List list, List list2, int i, j jVar) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }
}
