package com.avito.android.remote.model.edit;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.edit.TariffAlertAction;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/edit/DeepLinkAction;", "Lcom/avito/android/remote/model/edit/TariffAlertAction;", "Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "buttonStyle", "Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "getButtonStyle", "()Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;Lcom/avito/android/deep_linking/links/DeepLink;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkAction extends TariffAlertAction {
    @SerializedName("buttonStyle")
    @NotNull
    private final TariffAlertAction.ButtonStyle buttonStyle;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink deeplink;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("type")
    @NotNull
    private final String type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeepLinkAction(@NotNull String str, @NotNull String str2, @NotNull TariffAlertAction.ButtonStyle buttonStyle2, @NotNull DeepLink deepLink) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(buttonStyle2, "buttonStyle");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        this.title = str;
        this.type = str2;
        this.buttonStyle = buttonStyle2;
        this.deeplink = deepLink;
    }

    @NotNull
    public final TariffAlertAction.ButtonStyle getButtonStyle() {
        return this.buttonStyle;
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
}
