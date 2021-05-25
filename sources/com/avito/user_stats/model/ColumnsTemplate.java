package com.avito.user_stats.model;

import a2.b.a.a.a;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/user_stats/model/ColumnsTemplate;", "Lcom/avito/user_stats/model/TemplateUnit;", "Lcom/avito/android/remote/model/text/AttributedText;", "component1", "()Lcom/avito/android/remote/model/text/AttributedText;", "component2", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "copy", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/user_stats/model/ColumnsTemplate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/text/AttributedText;", "getLeft", "getRight", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class ColumnsTemplate implements TemplateUnit {
    @SerializedName(ViewHierarchyConstants.DIMENSION_LEFT_KEY)
    @Nullable
    private final AttributedText left;
    @SerializedName("right")
    @Nullable
    private final AttributedText right;

    public ColumnsTemplate(@Nullable AttributedText attributedText, @Nullable AttributedText attributedText2) {
        this.left = attributedText;
        this.right = attributedText2;
    }

    public static /* synthetic */ ColumnsTemplate copy$default(ColumnsTemplate columnsTemplate, AttributedText attributedText, AttributedText attributedText2, int i, Object obj) {
        if ((i & 1) != 0) {
            attributedText = columnsTemplate.left;
        }
        if ((i & 2) != 0) {
            attributedText2 = columnsTemplate.right;
        }
        return columnsTemplate.copy(attributedText, attributedText2);
    }

    @Nullable
    public final AttributedText component1() {
        return this.left;
    }

    @Nullable
    public final AttributedText component2() {
        return this.right;
    }

    @NotNull
    public final ColumnsTemplate copy(@Nullable AttributedText attributedText, @Nullable AttributedText attributedText2) {
        return new ColumnsTemplate(attributedText, attributedText2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColumnsTemplate)) {
            return false;
        }
        ColumnsTemplate columnsTemplate = (ColumnsTemplate) obj;
        return Intrinsics.areEqual(this.left, columnsTemplate.left) && Intrinsics.areEqual(this.right, columnsTemplate.right);
    }

    @Nullable
    public final AttributedText getLeft() {
        return this.left;
    }

    @Nullable
    public final AttributedText getRight() {
        return this.right;
    }

    public int hashCode() {
        AttributedText attributedText = this.left;
        int i = 0;
        int hashCode = (attributedText != null ? attributedText.hashCode() : 0) * 31;
        AttributedText attributedText2 = this.right;
        if (attributedText2 != null) {
            i = attributedText2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ColumnsTemplate(left=");
        L.append(this.left);
        L.append(", right=");
        L.append(this.right);
        L.append(")");
        return L.toString();
    }
}
