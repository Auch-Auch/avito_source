package com.avito.android.verification.verification_status;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.annotation.AttrRes;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001:\u0003ABCBe\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\t\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b?\u0010@J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J|\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\t2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J\u0010\u0010#\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0012R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0004R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0007R!\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\fR!\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00103\u001a\u0004\b6\u0010\fR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b7\u00100\u001a\u0004\b8\u0010\u0007R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u000fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0017¨\u0006D"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "component3", "", "Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Button;", "component4", "()Ljava/util/List;", "Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Banner;", "component5", "()Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Banner;", "Lcom/avito/android/remote/model/Image;", "component6", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Action;", "component7", "", "component8", "()Ljava/lang/Integer;", "title", "description", "footerInfo", MessengerShareContentUtility.BUTTONS, "banner", "image", "actions", "actionIconAttrId", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Banner;Lcom/avito/android/remote/model/Image;Ljava/util/List;Ljava/lang/Integer;)Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Lcom/avito/android/remote/model/Image;", "getImage", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "d", "Ljava/util/List;", "getButtons", g.a, "getActions", "c", "getFooterInfo", "e", "Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Banner;", "getBanner", "h", "Ljava/lang/Integer;", "getActionIconAttrId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Banner;Lcom/avito/android/remote/model/Image;Ljava/util/List;Ljava/lang/Integer;)V", "Action", "Banner", "Button", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationStatusScreenData {
    @Nullable
    public final String a;
    @Nullable
    public final AttributedText b;
    @Nullable
    public final AttributedText c;
    @Nullable
    public final List<Button> d;
    @Nullable
    public final Banner e;
    @Nullable
    public final Image f;
    @Nullable
    public final List<Action> g;
    @Nullable
    public final Integer h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0001\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ:\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\u0010\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Action;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "component3", "()Ljava/lang/Integer;", "component4", "()I", "title", "deeplink", "iconAttrId", "iconTintColorAttrId", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Integer;I)Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Action;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "I", "getIconTintColorAttrId", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "c", "Ljava/lang/Integer;", "getIconAttrId", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Integer;I)V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action {
        @NotNull
        public final String a;
        @NotNull
        public final DeepLink b;
        @Nullable
        public final Integer c;
        public final int d;

        public Action(@NotNull String str, @NotNull DeepLink deepLink, @AttrRes @Nullable Integer num, @AttrRes int i) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            this.a = str;
            this.b = deepLink;
            this.c = num;
            this.d = i;
        }

        public static /* synthetic */ Action copy$default(Action action, String str, DeepLink deepLink, Integer num, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = action.a;
            }
            if ((i2 & 2) != 0) {
                deepLink = action.b;
            }
            if ((i2 & 4) != 0) {
                num = action.c;
            }
            if ((i2 & 8) != 0) {
                i = action.d;
            }
            return action.copy(str, deepLink, num, i);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final DeepLink component2() {
            return this.b;
        }

        @Nullable
        public final Integer component3() {
            return this.c;
        }

        public final int component4() {
            return this.d;
        }

        @NotNull
        public final Action copy(@NotNull String str, @NotNull DeepLink deepLink, @AttrRes @Nullable Integer num, @AttrRes int i) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            return new Action(str, deepLink, num, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return Intrinsics.areEqual(this.a, action.a) && Intrinsics.areEqual(this.b, action.b) && Intrinsics.areEqual(this.c, action.c) && this.d == action.d;
        }

        @NotNull
        public final DeepLink getDeeplink() {
            return this.b;
        }

        @Nullable
        public final Integer getIconAttrId() {
            return this.c;
        }

        public final int getIconTintColorAttrId() {
            return this.d;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            DeepLink deepLink = this.b;
            int hashCode2 = (hashCode + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
            Integer num = this.c;
            if (num != null) {
                i = num.hashCode();
            }
            return ((hashCode2 + i) * 31) + this.d;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Action(title=");
            L.append(this.a);
            L.append(", deeplink=");
            L.append(this.b);
            L.append(", iconAttrId=");
            L.append(this.c);
            L.append(", iconTintColorAttrId=");
            return a.j(L, this.d, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0010\u001a\u00020\t\u0012\b\b\u0001\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0010\u001a\u00020\t2\b\b\u0003\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Banner;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/text/AttributedText;", "component3", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "component4", "()I", "component5", "title", "description", "detailsLink", "iconAttrId", "styleAttrId", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;II)Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Banner;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "I", "getIconAttrId", "c", "Lcom/avito/android/remote/model/text/AttributedText;", "getDetailsLink", "e", "getStyleAttrId", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;II)V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Banner {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @Nullable
        public final AttributedText c;
        public final int d;
        public final int e;

        public Banner(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @AttrRes int i, @AttrRes int i2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            this.a = str;
            this.b = str2;
            this.c = attributedText;
            this.d = i;
            this.e = i2;
        }

        public static /* synthetic */ Banner copy$default(Banner banner, String str, String str2, AttributedText attributedText, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = banner.a;
            }
            if ((i3 & 2) != 0) {
                str2 = banner.b;
            }
            if ((i3 & 4) != 0) {
                attributedText = banner.c;
            }
            if ((i3 & 8) != 0) {
                i = banner.d;
            }
            if ((i3 & 16) != 0) {
                i2 = banner.e;
            }
            return banner.copy(str, str2, attributedText, i, i2);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final AttributedText component3() {
            return this.c;
        }

        public final int component4() {
            return this.d;
        }

        public final int component5() {
            return this.e;
        }

        @NotNull
        public final Banner copy(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @AttrRes int i, @AttrRes int i2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            return new Banner(str, str2, attributedText, i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Banner)) {
                return false;
            }
            Banner banner = (Banner) obj;
            return Intrinsics.areEqual(this.a, banner.a) && Intrinsics.areEqual(this.b, banner.b) && Intrinsics.areEqual(this.c, banner.c) && this.d == banner.d && this.e == banner.e;
        }

        @NotNull
        public final String getDescription() {
            return this.b;
        }

        @Nullable
        public final AttributedText getDetailsLink() {
            return this.c;
        }

        public final int getIconAttrId() {
            return this.d;
        }

        public final int getStyleAttrId() {
            return this.e;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            AttributedText attributedText = this.c;
            if (attributedText != null) {
                i = attributedText.hashCode();
            }
            return ((((hashCode2 + i) * 31) + this.d) * 31) + this.e;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Banner(title=");
            L.append(this.a);
            L.append(", description=");
            L.append(this.b);
            L.append(", detailsLink=");
            L.append(this.c);
            L.append(", iconAttrId=");
            L.append(this.d);
            L.append(", styleAttrId=");
            return a.j(L, this.e, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0003\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\rJ\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\rR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0010\u0010\n¨\u0006&"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Button;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "component3", "()Z", "", "component4", "()I", "title", "deeplink", "isEnabled", "styleAttrId", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;ZI)Lcom/avito/android/verification/verification_status/VerificationStatusScreenData$Button;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "d", "I", "getStyleAttrId", "c", "Z", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;ZI)V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Button {
        @NotNull
        public final String a;
        @NotNull
        public final DeepLink b;
        public final boolean c;
        public final int d;

        public Button(@NotNull String str, @NotNull DeepLink deepLink, boolean z, @AttrRes int i) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            this.a = str;
            this.b = deepLink;
            this.c = z;
            this.d = i;
        }

        public static /* synthetic */ Button copy$default(Button button, String str, DeepLink deepLink, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = button.a;
            }
            if ((i2 & 2) != 0) {
                deepLink = button.b;
            }
            if ((i2 & 4) != 0) {
                z = button.c;
            }
            if ((i2 & 8) != 0) {
                i = button.d;
            }
            return button.copy(str, deepLink, z, i);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final DeepLink component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        public final int component4() {
            return this.d;
        }

        @NotNull
        public final Button copy(@NotNull String str, @NotNull DeepLink deepLink, boolean z, @AttrRes int i) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            return new Button(str, deepLink, z, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Button)) {
                return false;
            }
            Button button = (Button) obj;
            return Intrinsics.areEqual(this.a, button.a) && Intrinsics.areEqual(this.b, button.b) && this.c == button.c && this.d == button.d;
        }

        @NotNull
        public final DeepLink getDeeplink() {
            return this.b;
        }

        public final int getStyleAttrId() {
            return this.d;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            DeepLink deepLink = this.b;
            if (deepLink != null) {
                i = deepLink.hashCode();
            }
            int i2 = (hashCode + i) * 31;
            boolean z = this.c;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return ((i2 + i3) * 31) + this.d;
        }

        public final boolean isEnabled() {
            return this.c;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Button(title=");
            L.append(this.a);
            L.append(", deeplink=");
            L.append(this.b);
            L.append(", isEnabled=");
            L.append(this.c);
            L.append(", styleAttrId=");
            return a.j(L, this.d, ")");
        }
    }

    public VerificationStatusScreenData(@Nullable String str, @Nullable AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable List<Button> list, @Nullable Banner banner, @Nullable Image image, @Nullable List<Action> list2, @AttrRes @Nullable Integer num) {
        this.a = str;
        this.b = attributedText;
        this.c = attributedText2;
        this.d = list;
        this.e = banner;
        this.f = image;
        this.g = list2;
        this.h = num;
    }

    public static /* synthetic */ VerificationStatusScreenData copy$default(VerificationStatusScreenData verificationStatusScreenData, String str, AttributedText attributedText, AttributedText attributedText2, List list, Banner banner, Image image, List list2, Integer num, int i, Object obj) {
        return verificationStatusScreenData.copy((i & 1) != 0 ? verificationStatusScreenData.a : str, (i & 2) != 0 ? verificationStatusScreenData.b : attributedText, (i & 4) != 0 ? verificationStatusScreenData.c : attributedText2, (i & 8) != 0 ? verificationStatusScreenData.d : list, (i & 16) != 0 ? verificationStatusScreenData.e : banner, (i & 32) != 0 ? verificationStatusScreenData.f : image, (i & 64) != 0 ? verificationStatusScreenData.g : list2, (i & 128) != 0 ? verificationStatusScreenData.h : num);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final AttributedText component2() {
        return this.b;
    }

    @Nullable
    public final AttributedText component3() {
        return this.c;
    }

    @Nullable
    public final List<Button> component4() {
        return this.d;
    }

    @Nullable
    public final Banner component5() {
        return this.e;
    }

    @Nullable
    public final Image component6() {
        return this.f;
    }

    @Nullable
    public final List<Action> component7() {
        return this.g;
    }

    @Nullable
    public final Integer component8() {
        return this.h;
    }

    @NotNull
    public final VerificationStatusScreenData copy(@Nullable String str, @Nullable AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable List<Button> list, @Nullable Banner banner, @Nullable Image image, @Nullable List<Action> list2, @AttrRes @Nullable Integer num) {
        return new VerificationStatusScreenData(str, attributedText, attributedText2, list, banner, image, list2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerificationStatusScreenData)) {
            return false;
        }
        VerificationStatusScreenData verificationStatusScreenData = (VerificationStatusScreenData) obj;
        return Intrinsics.areEqual(this.a, verificationStatusScreenData.a) && Intrinsics.areEqual(this.b, verificationStatusScreenData.b) && Intrinsics.areEqual(this.c, verificationStatusScreenData.c) && Intrinsics.areEqual(this.d, verificationStatusScreenData.d) && Intrinsics.areEqual(this.e, verificationStatusScreenData.e) && Intrinsics.areEqual(this.f, verificationStatusScreenData.f) && Intrinsics.areEqual(this.g, verificationStatusScreenData.g) && Intrinsics.areEqual(this.h, verificationStatusScreenData.h);
    }

    @Nullable
    public final Integer getActionIconAttrId() {
        return this.h;
    }

    @Nullable
    public final List<Action> getActions() {
        return this.g;
    }

    @Nullable
    public final Banner getBanner() {
        return this.e;
    }

    @Nullable
    public final List<Button> getButtons() {
        return this.d;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.b;
    }

    @Nullable
    public final AttributedText getFooterInfo() {
        return this.c;
    }

    @Nullable
    public final Image getImage() {
        return this.f;
    }

    @Nullable
    public final String getTitle() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AttributedText attributedText = this.b;
        int hashCode2 = (hashCode + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        AttributedText attributedText2 = this.c;
        int hashCode3 = (hashCode2 + (attributedText2 != null ? attributedText2.hashCode() : 0)) * 31;
        List<Button> list = this.d;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        Banner banner = this.e;
        int hashCode5 = (hashCode4 + (banner != null ? banner.hashCode() : 0)) * 31;
        Image image = this.f;
        int hashCode6 = (hashCode5 + (image != null ? image.hashCode() : 0)) * 31;
        List<Action> list2 = this.g;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Integer num = this.h;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode7 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("VerificationStatusScreenData(title=");
        L.append(this.a);
        L.append(", description=");
        L.append(this.b);
        L.append(", footerInfo=");
        L.append(this.c);
        L.append(", buttons=");
        L.append(this.d);
        L.append(", banner=");
        L.append(this.e);
        L.append(", image=");
        L.append(this.f);
        L.append(", actions=");
        L.append(this.g);
        L.append(", actionIconAttrId=");
        return a.p(L, this.h, ")");
    }
}
