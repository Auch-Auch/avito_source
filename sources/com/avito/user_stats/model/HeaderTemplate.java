package com.avito.user_stats.model;

import a2.b.a.a.a;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/avito/user_stats/model/HeaderTemplate;", "Lcom/avito/user_stats/model/TemplateUnit;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "component3", "title", "value", "relativeValue", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/user_stats/model/HeaderTemplate;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/remote/model/text/AttributedText;", "getRelativeValue", "getValue", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderTemplate implements TemplateUnit {
    @SerializedName("relative_value")
    @Nullable
    private final AttributedText relativeValue;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("value")
    @NotNull
    private final AttributedText value;

    public HeaderTemplate(@NotNull String str, @NotNull AttributedText attributedText, @Nullable AttributedText attributedText2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(attributedText, "value");
        this.title = str;
        this.value = attributedText;
        this.relativeValue = attributedText2;
    }

    public static /* synthetic */ HeaderTemplate copy$default(HeaderTemplate headerTemplate, String str, AttributedText attributedText, AttributedText attributedText2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headerTemplate.title;
        }
        if ((i & 2) != 0) {
            attributedText = headerTemplate.value;
        }
        if ((i & 4) != 0) {
            attributedText2 = headerTemplate.relativeValue;
        }
        return headerTemplate.copy(str, attributedText, attributedText2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final AttributedText component2() {
        return this.value;
    }

    @Nullable
    public final AttributedText component3() {
        return this.relativeValue;
    }

    @NotNull
    public final HeaderTemplate copy(@NotNull String str, @NotNull AttributedText attributedText, @Nullable AttributedText attributedText2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(attributedText, "value");
        return new HeaderTemplate(str, attributedText, attributedText2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderTemplate)) {
            return false;
        }
        HeaderTemplate headerTemplate = (HeaderTemplate) obj;
        return Intrinsics.areEqual(this.title, headerTemplate.title) && Intrinsics.areEqual(this.value, headerTemplate.value) && Intrinsics.areEqual(this.relativeValue, headerTemplate.relativeValue);
    }

    @Nullable
    public final AttributedText getRelativeValue() {
        return this.relativeValue;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final AttributedText getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AttributedText attributedText = this.value;
        int hashCode2 = (hashCode + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        AttributedText attributedText2 = this.relativeValue;
        if (attributedText2 != null) {
            i = attributedText2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("HeaderTemplate(title=");
        L.append(this.title);
        L.append(", value=");
        L.append(this.value);
        L.append(", relativeValue=");
        L.append(this.relativeValue);
        L.append(")");
        return L.toString();
    }
}
