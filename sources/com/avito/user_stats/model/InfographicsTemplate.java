package com.avito.user_stats.model;

import a2.b.a.a.a;
import com.avito.android.remote.model.UniversalColor;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/user_stats/model/InfographicsTemplate;", "Lcom/avito/user_stats/model/TemplateUnit;", "Lcom/avito/android/remote/model/UniversalColor;", "component1", "()Lcom/avito/android/remote/model/UniversalColor;", "component2", "color", "activeColor", "copy", "(Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)Lcom/avito/user_stats/model/InfographicsTemplate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/UniversalColor;", "getActiveColor", "getColor", "<init>", "(Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class InfographicsTemplate implements TemplateUnit {
    @SerializedName("active_color")
    @NotNull
    private final UniversalColor activeColor;
    @SerializedName("color")
    @NotNull
    private final UniversalColor color;

    public InfographicsTemplate(@NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        Intrinsics.checkNotNullParameter(universalColor2, "activeColor");
        this.color = universalColor;
        this.activeColor = universalColor2;
    }

    public static /* synthetic */ InfographicsTemplate copy$default(InfographicsTemplate infographicsTemplate, UniversalColor universalColor, UniversalColor universalColor2, int i, Object obj) {
        if ((i & 1) != 0) {
            universalColor = infographicsTemplate.color;
        }
        if ((i & 2) != 0) {
            universalColor2 = infographicsTemplate.activeColor;
        }
        return infographicsTemplate.copy(universalColor, universalColor2);
    }

    @NotNull
    public final UniversalColor component1() {
        return this.color;
    }

    @NotNull
    public final UniversalColor component2() {
        return this.activeColor;
    }

    @NotNull
    public final InfographicsTemplate copy(@NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        Intrinsics.checkNotNullParameter(universalColor2, "activeColor");
        return new InfographicsTemplate(universalColor, universalColor2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InfographicsTemplate)) {
            return false;
        }
        InfographicsTemplate infographicsTemplate = (InfographicsTemplate) obj;
        return Intrinsics.areEqual(this.color, infographicsTemplate.color) && Intrinsics.areEqual(this.activeColor, infographicsTemplate.activeColor);
    }

    @NotNull
    public final UniversalColor getActiveColor() {
        return this.activeColor;
    }

    @NotNull
    public final UniversalColor getColor() {
        return this.color;
    }

    public int hashCode() {
        UniversalColor universalColor = this.color;
        int i = 0;
        int hashCode = (universalColor != null ? universalColor.hashCode() : 0) * 31;
        UniversalColor universalColor2 = this.activeColor;
        if (universalColor2 != null) {
            i = universalColor2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("InfographicsTemplate(color=");
        L.append(this.color);
        L.append(", activeColor=");
        L.append(this.activeColor);
        L.append(")");
        return L.toString();
    }
}
