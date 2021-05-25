package com.avito.android.remote.model.messenger;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\"\u0010#J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\bR$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0005¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/messenger/PlatformSupport;", "Landroid/os/Parcelable;", "", "", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "platforms", "fallbackText", "copy", "(Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/messenger/PlatformSupport;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getFallbackText", "Ljava/util/List;", "getPlatforms", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformSupport implements Parcelable {
    public static final Parcelable.Creator<PlatformSupport> CREATOR = new Creator();
    @SerializedName("fallback")
    @Nullable
    private final AttributedText fallbackText;
    @SerializedName("platforms")
    @Nullable
    private final List<String> platforms;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PlatformSupport> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PlatformSupport createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PlatformSupport(parcel.createStringArrayList(), (AttributedText) parcel.readParcelable(PlatformSupport.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PlatformSupport[] newArray(int i) {
            return new PlatformSupport[i];
        }
    }

    public PlatformSupport(@Nullable List<String> list, @Nullable AttributedText attributedText) {
        this.platforms = list;
        this.fallbackText = attributedText;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.messenger.PlatformSupport */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformSupport copy$default(PlatformSupport platformSupport, List list, AttributedText attributedText, int i, Object obj) {
        if ((i & 1) != 0) {
            list = platformSupport.platforms;
        }
        if ((i & 2) != 0) {
            attributedText = platformSupport.fallbackText;
        }
        return platformSupport.copy(list, attributedText);
    }

    @Nullable
    public final List<String> component1() {
        return this.platforms;
    }

    @Nullable
    public final AttributedText component2() {
        return this.fallbackText;
    }

    @NotNull
    public final PlatformSupport copy(@Nullable List<String> list, @Nullable AttributedText attributedText) {
        return new PlatformSupport(list, attributedText);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformSupport)) {
            return false;
        }
        PlatformSupport platformSupport = (PlatformSupport) obj;
        return Intrinsics.areEqual(this.platforms, platformSupport.platforms) && Intrinsics.areEqual(this.fallbackText, platformSupport.fallbackText);
    }

    @Nullable
    public final AttributedText getFallbackText() {
        return this.fallbackText;
    }

    @Nullable
    public final List<String> getPlatforms() {
        return this.platforms;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<String> list = this.platforms;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        AttributedText attributedText = this.fallbackText;
        if (attributedText != null) {
            i = attributedText.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PlatformSupport(platforms=");
        L.append(this.platforms);
        L.append(", fallbackText=");
        L.append(this.fallbackText);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeStringList(this.platforms);
        parcel.writeParcelable(this.fallbackText, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlatformSupport(List list, AttributedText attributedText, int i, j jVar) {
        this(list, (i & 2) != 0 ? null : attributedText);
    }
}
