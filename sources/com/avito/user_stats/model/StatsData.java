package com.avito.user_stats.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\r\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/user_stats/model/StatsData;", "", "", "component1", "()F", "", "component2", "()Ljava/lang/String;", "", "Lcom/avito/user_stats/model/TemplateUnit;", "component3", "()Ljava/util/List;", "value", "label", "template", "copy", "(FLjava/lang/String;Ljava/util/List;)Lcom/avito/user_stats/model/StatsData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getTemplate", "Ljava/lang/String;", "getLabel", "F", "getValue", "<init>", "(FLjava/lang/String;Ljava/util/List;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatsData {
    @SerializedName("label")
    @NotNull
    private final String label;
    @SerializedName("template")
    @NotNull
    private final List<TemplateUnit> template;
    @SerializedName("value")
    private final float value;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.user_stats.model.TemplateUnit> */
    /* JADX WARN: Multi-variable type inference failed */
    public StatsData(float f, @NotNull String str, @NotNull List<? extends TemplateUnit> list) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(list, "template");
        this.value = f;
        this.label = str;
        this.template = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.user_stats.model.StatsData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StatsData copy$default(StatsData statsData, float f, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            f = statsData.value;
        }
        if ((i & 2) != 0) {
            str = statsData.label;
        }
        if ((i & 4) != 0) {
            list = statsData.template;
        }
        return statsData.copy(f, str, list);
    }

    public final float component1() {
        return this.value;
    }

    @NotNull
    public final String component2() {
        return this.label;
    }

    @NotNull
    public final List<TemplateUnit> component3() {
        return this.template;
    }

    @NotNull
    public final StatsData copy(float f, @NotNull String str, @NotNull List<? extends TemplateUnit> list) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(list, "template");
        return new StatsData(f, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatsData)) {
            return false;
        }
        StatsData statsData = (StatsData) obj;
        return Float.compare(this.value, statsData.value) == 0 && Intrinsics.areEqual(this.label, statsData.label) && Intrinsics.areEqual(this.template, statsData.template);
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public final List<TemplateUnit> getTemplate() {
        return this.template;
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.value) * 31;
        String str = this.label;
        int i = 0;
        int hashCode = (floatToIntBits + (str != null ? str.hashCode() : 0)) * 31;
        List<TemplateUnit> list = this.template;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("StatsData(value=");
        L.append(this.value);
        L.append(", label=");
        L.append(this.label);
        L.append(", template=");
        return a.w(L, this.template, ")");
    }
}
