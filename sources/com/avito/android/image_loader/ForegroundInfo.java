package com.avito.android.image_loader;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.text.AttributedText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/image_loader/ForegroundInfo;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "component1", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/UniversalColor;", "component2", "()Lcom/avito/android/remote/model/UniversalColor;", "text", "color", "copy", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/UniversalColor;)Lcom/avito/android/image_loader/ForegroundInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/UniversalColor;", "getColor", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/UniversalColor;)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class ForegroundInfo {
    @NotNull
    public final AttributedText a;
    @NotNull
    public final UniversalColor b;

    public ForegroundInfo(@NotNull AttributedText attributedText, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        Intrinsics.checkNotNullParameter(universalColor, "color");
        this.a = attributedText;
        this.b = universalColor;
    }

    public static /* synthetic */ ForegroundInfo copy$default(ForegroundInfo foregroundInfo, AttributedText attributedText, UniversalColor universalColor, int i, Object obj) {
        if ((i & 1) != 0) {
            attributedText = foregroundInfo.a;
        }
        if ((i & 2) != 0) {
            universalColor = foregroundInfo.b;
        }
        return foregroundInfo.copy(attributedText, universalColor);
    }

    @NotNull
    public final AttributedText component1() {
        return this.a;
    }

    @NotNull
    public final UniversalColor component2() {
        return this.b;
    }

    @NotNull
    public final ForegroundInfo copy(@NotNull AttributedText attributedText, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        Intrinsics.checkNotNullParameter(universalColor, "color");
        return new ForegroundInfo(attributedText, universalColor);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ForegroundInfo)) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        return Intrinsics.areEqual(this.a, foregroundInfo.a) && Intrinsics.areEqual(this.b, foregroundInfo.b);
    }

    @NotNull
    public final UniversalColor getColor() {
        return this.b;
    }

    @NotNull
    public final AttributedText getText() {
        return this.a;
    }

    public int hashCode() {
        AttributedText attributedText = this.a;
        int i = 0;
        int hashCode = (attributedText != null ? attributedText.hashCode() : 0) * 31;
        UniversalColor universalColor = this.b;
        if (universalColor != null) {
            i = universalColor.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ForegroundInfo(text=");
        L.append(this.a);
        L.append(", color=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
