package com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoDialogData;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/CharSequence;", "component3", "Lcom/avito/android/remote/model/Image;", "component4", "()Lcom/avito/android/remote/model/Image;", "titleText", "bodyText", "confirmButtonText", "image", "copy", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoDialogData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getBodyText", "c", "Ljava/lang/String;", "getConfirmButtonText", "d", "Lcom/avito/android/remote/model/Image;", "getImage", AuthSource.SEND_ABUSE, "getTitleText", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SoaInfoDialogData {
    @NotNull
    public final String a;
    @Nullable
    public final CharSequence b;
    @NotNull
    public final String c;
    @NotNull
    public final Image d;

    public SoaInfoDialogData(@NotNull String str, @Nullable CharSequence charSequence, @NotNull String str2, @NotNull Image image) {
        Intrinsics.checkNotNullParameter(str, "titleText");
        Intrinsics.checkNotNullParameter(str2, "confirmButtonText");
        Intrinsics.checkNotNullParameter(image, "image");
        this.a = str;
        this.b = charSequence;
        this.c = str2;
        this.d = image;
    }

    public static /* synthetic */ SoaInfoDialogData copy$default(SoaInfoDialogData soaInfoDialogData, String str, CharSequence charSequence, String str2, Image image, int i, Object obj) {
        if ((i & 1) != 0) {
            str = soaInfoDialogData.a;
        }
        if ((i & 2) != 0) {
            charSequence = soaInfoDialogData.b;
        }
        if ((i & 4) != 0) {
            str2 = soaInfoDialogData.c;
        }
        if ((i & 8) != 0) {
            image = soaInfoDialogData.d;
        }
        return soaInfoDialogData.copy(str, charSequence, str2, image);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final CharSequence component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final Image component4() {
        return this.d;
    }

    @NotNull
    public final SoaInfoDialogData copy(@NotNull String str, @Nullable CharSequence charSequence, @NotNull String str2, @NotNull Image image) {
        Intrinsics.checkNotNullParameter(str, "titleText");
        Intrinsics.checkNotNullParameter(str2, "confirmButtonText");
        Intrinsics.checkNotNullParameter(image, "image");
        return new SoaInfoDialogData(str, charSequence, str2, image);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoaInfoDialogData)) {
            return false;
        }
        SoaInfoDialogData soaInfoDialogData = (SoaInfoDialogData) obj;
        return Intrinsics.areEqual(this.a, soaInfoDialogData.a) && Intrinsics.areEqual(this.b, soaInfoDialogData.b) && Intrinsics.areEqual(this.c, soaInfoDialogData.c) && Intrinsics.areEqual(this.d, soaInfoDialogData.d);
    }

    @Nullable
    public final CharSequence getBodyText() {
        return this.b;
    }

    @NotNull
    public final String getConfirmButtonText() {
        return this.c;
    }

    @NotNull
    public final Image getImage() {
        return this.d;
    }

    @NotNull
    public final String getTitleText() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CharSequence charSequence = this.b;
        int hashCode2 = (hashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Image image = this.d;
        if (image != null) {
            i = image.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SoaInfoDialogData(titleText=");
        L.append(this.a);
        L.append(", bodyText=");
        L.append(this.b);
        L.append(", confirmButtonText=");
        L.append(this.c);
        L.append(", image=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }
}
