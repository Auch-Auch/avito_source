package com.avito.user_stats.model;

import a2.b.a.a.a;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/avito/user_stats/model/DescriptionTemplate;", "Lcom/avito/user_stats/model/TemplateUnit;", "Lcom/avito/android/remote/model/text/AttributedText;", "component1", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "component2", "()Ljava/lang/String;", "description", "fromType", "copy", "(Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;)Lcom/avito/user_stats/model/DescriptionTemplate;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "Ljava/lang/String;", "getFromType", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class DescriptionTemplate implements TemplateUnit {
    @SerializedName("description")
    @NotNull
    private final AttributedText description;
    @SerializedName("from_type")
    @Nullable
    private final String fromType;

    public DescriptionTemplate(@NotNull AttributedText attributedText, @Nullable String str) {
        Intrinsics.checkNotNullParameter(attributedText, "description");
        this.description = attributedText;
        this.fromType = str;
    }

    public static /* synthetic */ DescriptionTemplate copy$default(DescriptionTemplate descriptionTemplate, AttributedText attributedText, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            attributedText = descriptionTemplate.description;
        }
        if ((i & 2) != 0) {
            str = descriptionTemplate.fromType;
        }
        return descriptionTemplate.copy(attributedText, str);
    }

    @NotNull
    public final AttributedText component1() {
        return this.description;
    }

    @Nullable
    public final String component2() {
        return this.fromType;
    }

    @NotNull
    public final DescriptionTemplate copy(@NotNull AttributedText attributedText, @Nullable String str) {
        Intrinsics.checkNotNullParameter(attributedText, "description");
        return new DescriptionTemplate(attributedText, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DescriptionTemplate)) {
            return false;
        }
        DescriptionTemplate descriptionTemplate = (DescriptionTemplate) obj;
        return Intrinsics.areEqual(this.description, descriptionTemplate.description) && Intrinsics.areEqual(this.fromType, descriptionTemplate.fromType);
    }

    @NotNull
    public final AttributedText getDescription() {
        return this.description;
    }

    @Nullable
    public final String getFromType() {
        return this.fromType;
    }

    public int hashCode() {
        AttributedText attributedText = this.description;
        int i = 0;
        int hashCode = (attributedText != null ? attributedText.hashCode() : 0) * 31;
        String str = this.fromType;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DescriptionTemplate(description=");
        L.append(this.description);
        L.append(", fromType=");
        return a.t(L, this.fromType, ")");
    }
}
