package com.avito.android.component.profile_snippet;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b#\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0013\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bH\u0010IJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001e\u001a\u00020\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020\u00132\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u0004J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0011R\u001b\u0010#\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010.\u001a\u0004\b7\u0010\u0004R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b9\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u000eR\u001b\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010.\u001a\u0004\b>\u0010\u0004R\u0019\u0010\"\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b\"\u0010\u0015R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010.\u001a\u0004\bB\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u000bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010.\u001a\u0004\bG\u0010\u0004¨\u0006J"}, d2 = {"Lcom/avito/android/component/profile_snippet/ProfileSnippetData;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "component6", "()Lcom/avito/android/remote/model/advert_details/UserIconType;", "Lcom/avito/android/remote/model/Image;", "component7", "()Lcom/avito/android/remote/model/Image;", "", "component8", "()Ljava/lang/Float;", "component9", "", "component10", "()Z", "Lcom/avito/android/remote/model/SellerVerification;", "component11", "()Lcom/avito/android/remote/model/SellerVerification;", "title", MessengerShareContentUtility.SUBTITLE, ErrorBundle.SUMMARY_ENTRY, "contactTitle", "contactSubtitle", "iconType", "avatar", "ratingScore", "ratingText", "isVerified", "verification", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/UserIconType;Lcom/avito/android/remote/model/Image;Ljava/lang/Float;Ljava/lang/String;ZLcom/avito/android/remote/model/SellerVerification;)Lcom/avito/android/component/profile_snippet/ProfileSnippetData;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getContactTitle", "h", "Ljava/lang/Float;", "getRatingScore", "k", "Lcom/avito/android/remote/model/SellerVerification;", "getVerification", AuthSource.SEND_ABUSE, "getTitle", AuthSource.BOOKING_ORDER, "getSubtitle", g.a, "Lcom/avito/android/remote/model/Image;", "getAvatar", "i", "getRatingText", "j", "Z", "c", "getSummary", "f", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "getIconType", "e", "getContactSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/UserIconType;Lcom/avito/android/remote/model/Image;Ljava/lang/Float;Ljava/lang/String;ZLcom/avito/android/remote/model/SellerVerification;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileSnippetData {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @NotNull
    public final UserIconType f;
    @Nullable
    public final Image g;
    @Nullable
    public final Float h;
    @Nullable
    public final String i;
    public final boolean j;
    @Nullable
    public final SellerVerification k;

    public ProfileSnippetData() {
        this(null, null, null, null, null, null, null, null, null, false, null, 2047, null);
    }

    public ProfileSnippetData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull UserIconType userIconType, @Nullable Image image, @Nullable Float f2, @Nullable String str6, boolean z, @Nullable SellerVerification sellerVerification) {
        Intrinsics.checkNotNullParameter(userIconType, "iconType");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = userIconType;
        this.g = image;
        this.h = f2;
        this.i = str6;
        this.j = z;
        this.k = sellerVerification;
    }

    public static /* synthetic */ ProfileSnippetData copy$default(ProfileSnippetData profileSnippetData, String str, String str2, String str3, String str4, String str5, UserIconType userIconType, Image image, Float f2, String str6, boolean z, SellerVerification sellerVerification, int i2, Object obj) {
        return profileSnippetData.copy((i2 & 1) != 0 ? profileSnippetData.a : str, (i2 & 2) != 0 ? profileSnippetData.b : str2, (i2 & 4) != 0 ? profileSnippetData.c : str3, (i2 & 8) != 0 ? profileSnippetData.d : str4, (i2 & 16) != 0 ? profileSnippetData.e : str5, (i2 & 32) != 0 ? profileSnippetData.f : userIconType, (i2 & 64) != 0 ? profileSnippetData.g : image, (i2 & 128) != 0 ? profileSnippetData.h : f2, (i2 & 256) != 0 ? profileSnippetData.i : str6, (i2 & 512) != 0 ? profileSnippetData.j : z, (i2 & 1024) != 0 ? profileSnippetData.k : sellerVerification);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    public final boolean component10() {
        return this.j;
    }

    @Nullable
    public final SellerVerification component11() {
        return this.k;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final UserIconType component6() {
        return this.f;
    }

    @Nullable
    public final Image component7() {
        return this.g;
    }

    @Nullable
    public final Float component8() {
        return this.h;
    }

    @Nullable
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final ProfileSnippetData copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull UserIconType userIconType, @Nullable Image image, @Nullable Float f2, @Nullable String str6, boolean z, @Nullable SellerVerification sellerVerification) {
        Intrinsics.checkNotNullParameter(userIconType, "iconType");
        return new ProfileSnippetData(str, str2, str3, str4, str5, userIconType, image, f2, str6, z, sellerVerification);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileSnippetData)) {
            return false;
        }
        ProfileSnippetData profileSnippetData = (ProfileSnippetData) obj;
        return Intrinsics.areEqual(this.a, profileSnippetData.a) && Intrinsics.areEqual(this.b, profileSnippetData.b) && Intrinsics.areEqual(this.c, profileSnippetData.c) && Intrinsics.areEqual(this.d, profileSnippetData.d) && Intrinsics.areEqual(this.e, profileSnippetData.e) && Intrinsics.areEqual(this.f, profileSnippetData.f) && Intrinsics.areEqual(this.g, profileSnippetData.g) && Intrinsics.areEqual(this.h, profileSnippetData.h) && Intrinsics.areEqual(this.i, profileSnippetData.i) && this.j == profileSnippetData.j && Intrinsics.areEqual(this.k, profileSnippetData.k);
    }

    @Nullable
    public final Image getAvatar() {
        return this.g;
    }

    @Nullable
    public final String getContactSubtitle() {
        return this.e;
    }

    @Nullable
    public final String getContactTitle() {
        return this.d;
    }

    @NotNull
    public final UserIconType getIconType() {
        return this.f;
    }

    @Nullable
    public final Float getRatingScore() {
        return this.h;
    }

    @Nullable
    public final String getRatingText() {
        return this.i;
    }

    @Nullable
    public final String getSubtitle() {
        return this.b;
    }

    @Nullable
    public final String getSummary() {
        return this.c;
    }

    @Nullable
    public final String getTitle() {
        return this.a;
    }

    @Nullable
    public final SellerVerification getVerification() {
        return this.k;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        UserIconType userIconType = this.f;
        int hashCode6 = (hashCode5 + (userIconType != null ? userIconType.hashCode() : 0)) * 31;
        Image image = this.g;
        int hashCode7 = (hashCode6 + (image != null ? image.hashCode() : 0)) * 31;
        Float f2 = this.h;
        int hashCode8 = (hashCode7 + (f2 != null ? f2.hashCode() : 0)) * 31;
        String str6 = this.i;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z = this.j;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode9 + i3) * 31;
        SellerVerification sellerVerification = this.k;
        if (sellerVerification != null) {
            i2 = sellerVerification.hashCode();
        }
        return i6 + i2;
    }

    public final boolean isVerified() {
        return this.j;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileSnippetData(title=");
        L.append(this.a);
        L.append(", subtitle=");
        L.append(this.b);
        L.append(", summary=");
        L.append(this.c);
        L.append(", contactTitle=");
        L.append(this.d);
        L.append(", contactSubtitle=");
        L.append(this.e);
        L.append(", iconType=");
        L.append(this.f);
        L.append(", avatar=");
        L.append(this.g);
        L.append(", ratingScore=");
        L.append(this.h);
        L.append(", ratingText=");
        L.append(this.i);
        L.append(", isVerified=");
        L.append(this.j);
        L.append(", verification=");
        L.append(this.k);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProfileSnippetData(String str, String str2, String str3, String str4, String str5, UserIconType userIconType, Image image, Float f2, String str6, boolean z, SellerVerification sellerVerification, int i2, j jVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? UserIconType.PRIVATE : userIconType, (i2 & 64) != 0 ? null : image, (i2 & 128) != 0 ? null : f2, (i2 & 256) != 0 ? null : str6, (i2 & 512) != 0 ? false : z, (i2 & 1024) == 0 ? sellerVerification : null);
    }
}
