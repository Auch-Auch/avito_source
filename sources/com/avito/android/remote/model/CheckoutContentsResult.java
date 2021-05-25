package com.avito.android.remote.model;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/CheckoutContentsResult;", "", "Lcom/avito/android/remote/model/text/AttributedText;", BaseAnalyticKt.ANALYTIC_MODULE_OFFER, "Lcom/avito/android/remote/model/text/AttributedText;", "getOffer", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "Lcom/avito/android/remote/model/CheckoutElement;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "", "closeButtonTitle", "Ljava/lang/String;", "getCloseButtonTitle", "()Ljava/lang/String;", "title", "getTitle", "description", "getDescription", "actionTitle", "getActionTitle", "price", "getPrice", "emptyActionTitle", "getEmptyActionTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "delayedAction", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDelayedAction", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "checkout_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutContentsResult {
    @SerializedName("actionTitle")
    @NotNull
    private final String actionTitle;
    @SerializedName("closeButtonTitle")
    @NotNull
    private final String closeButtonTitle;
    @SerializedName("delayedAction")
    @Nullable
    private final DeepLink delayedAction;
    @SerializedName("description")
    @Nullable
    private final AttributedText description;
    @SerializedName("emptyActionTitle")
    @Nullable
    private final String emptyActionTitle;
    @SerializedName("list")
    @NotNull
    private final List<CheckoutElement> list;
    @SerializedName(BaseAnalyticKt.ANALYTIC_MODULE_OFFER)
    @Nullable
    private final AttributedText offer;
    @SerializedName("price")
    @Nullable
    private final String price;
    @SerializedName("title")
    @NotNull
    private final String title;

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<? extends com.avito.android.remote.model.CheckoutElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public CheckoutContentsResult(@NotNull String str, @Nullable AttributedText attributedText, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable AttributedText attributedText2, @NotNull List<? extends CheckoutElement> list2, @Nullable String str5, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "actionTitle");
        Intrinsics.checkNotNullParameter(str3, "closeButtonTitle");
        Intrinsics.checkNotNullParameter(list2, "list");
        this.title = str;
        this.description = attributedText;
        this.actionTitle = str2;
        this.closeButtonTitle = str3;
        this.price = str4;
        this.offer = attributedText2;
        this.list = list2;
        this.emptyActionTitle = str5;
        this.delayedAction = deepLink;
    }

    @NotNull
    public final String getActionTitle() {
        return this.actionTitle;
    }

    @NotNull
    public final String getCloseButtonTitle() {
        return this.closeButtonTitle;
    }

    @Nullable
    public final DeepLink getDelayedAction() {
        return this.delayedAction;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.description;
    }

    @Nullable
    public final String getEmptyActionTitle() {
        return this.emptyActionTitle;
    }

    @NotNull
    public final List<CheckoutElement> getList() {
        return this.list;
    }

    @Nullable
    public final AttributedText getOffer() {
        return this.offer;
    }

    @Nullable
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckoutContentsResult(String str, AttributedText attributedText, String str2, String str3, String str4, AttributedText attributedText2, List list2, String str5, DeepLink deepLink, int i, j jVar) {
        this(str, attributedText, str2, str3, str4, attributedText2, list2, str5, (i & 256) != 0 ? null : deepLink);
    }
}
