package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004#$%&BY\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R$\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\f¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/VerificationStatusResult;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/VerificationStatusResult$Action;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/VerificationStatusResult$Banner;", "banner", "Lcom/avito/android/remote/model/VerificationStatusResult$Banner;", "getBanner", "()Lcom/avito/android/remote/model/VerificationStatusResult$Banner;", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "footerInfo", "getFooterInfo", "Lcom/avito/android/remote/model/VerificationStatusResult$Button;", MessengerShareContentUtility.BUTTONS, "getButtons", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Lcom/avito/android/remote/model/VerificationStatusResult$Banner;Lcom/avito/android/remote/model/Image;Ljava/util/List;)V", "Action", "Banner", "Button", "DeepLinkInfo", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationStatusResult {
    @SerializedName("actions")
    @Nullable
    private final List<Action> actions;
    @SerializedName("banner")
    @Nullable
    private final Banner banner;
    @SerializedName(MessengerShareContentUtility.BUTTONS)
    @Nullable
    private final List<Button> buttons;
    @SerializedName("description")
    @Nullable
    private final AttributedText description;
    @SerializedName("footerInfo")
    @Nullable
    private final AttributedText footerInfo;
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/VerificationStatusResult$Action;", "", "Lcom/avito/android/remote/model/VerificationStatusResult$DeepLinkInfo;", "deeplink", "Lcom/avito/android/remote/model/VerificationStatusResult$DeepLinkInfo;", "getDeeplink", "()Lcom/avito/android/remote/model/VerificationStatusResult$DeepLinkInfo;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/VerificationStatusResult$DeepLinkInfo;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action {
        @SerializedName("deepLink")
        @NotNull
        private final DeepLinkInfo deeplink;
        @SerializedName("type")
        @NotNull
        private final String type;

        public Action(@NotNull String str, @NotNull DeepLinkInfo deepLinkInfo) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(deepLinkInfo, "deeplink");
            this.type = str;
            this.deeplink = deepLinkInfo;
        }

        @NotNull
        public final DeepLinkInfo getDeeplink() {
            return this.deeplink;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/VerificationStatusResult$Banner;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "detailsLink", "Lcom/avito/android/remote/model/text/AttributedText;", "getDetailsLink", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "description", "getDescription", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Banner {
        @SerializedName("description")
        @NotNull
        private final String description;
        @SerializedName("detailsLink")
        @Nullable
        private final AttributedText detailsLink;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("type")
        @NotNull
        private final String type;

        public Banner(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable AttributedText attributedText) {
            a.Z0(str, "title", str2, "type", str3, "description");
            this.title = str;
            this.type = str2;
            this.description = str3;
            this.detailsLink = attributedText;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final AttributedText getDetailsLink() {
            return this.detailsLink;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/VerificationStatusResult$Button;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "title", "getTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "isEnabled", "Z", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Z)V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Button {
        @SerializedName("deepLink")
        @NotNull
        private final DeepLink deeplink;
        @SerializedName("isEnabled")
        private final boolean isEnabled;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("type")
        @NotNull
        private final String type;

        public Button(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink, boolean z) {
            a.W0(str, "title", str2, "type", deepLink, "deeplink");
            this.title = str;
            this.type = str2;
            this.deeplink = deepLink;
            this.isEnabled = z;
        }

        @NotNull
        public final DeepLink getDeeplink() {
            return this.deeplink;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/VerificationStatusResult$DeepLinkInfo;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeepLinkInfo {
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName(ShareConstants.MEDIA_URI)
        @NotNull
        private final DeepLink uri;

        public DeepLinkInfo(@NotNull String str, @NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
            this.title = str;
            this.uri = deepLink;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final DeepLink getUri() {
            return this.uri;
        }
    }

    public VerificationStatusResult(@Nullable String str, @Nullable AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable List<Button> list, @Nullable Banner banner2, @Nullable Image image2, @Nullable List<Action> list2) {
        this.title = str;
        this.description = attributedText;
        this.footerInfo = attributedText2;
        this.buttons = list;
        this.banner = banner2;
        this.image = image2;
        this.actions = list2;
    }

    @Nullable
    public final List<Action> getActions() {
        return this.actions;
    }

    @Nullable
    public final Banner getBanner() {
        return this.banner;
    }

    @Nullable
    public final List<Button> getButtons() {
        return this.buttons;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.description;
    }

    @Nullable
    public final AttributedText getFooterInfo() {
        return this.footerInfo;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
