package com.avito.user_stats.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/user_stats/model/SpaceTemplate;", "Lcom/avito/user_stats/model/TemplateUnit;", "", "component1", "()I", "value", "copy", "(I)Lcom/avito/user_stats/model/SpaceTemplate;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getValue", "<init>", "(I)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class SpaceTemplate implements TemplateUnit {
    public final int a;

    public SpaceTemplate(int i) {
        this.a = i;
    }

    public static /* synthetic */ SpaceTemplate copy$default(SpaceTemplate spaceTemplate, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = spaceTemplate.a;
        }
        return spaceTemplate.copy(i);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final SpaceTemplate copy(int i) {
        return new SpaceTemplate(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SpaceTemplate) && this.a == ((SpaceTemplate) obj).a;
        }
        return true;
    }

    public final int getValue() {
        return this.a;
    }

    public int hashCode() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return a.j(a.L("SpaceTemplate(value="), this.a, ")");
    }
}
