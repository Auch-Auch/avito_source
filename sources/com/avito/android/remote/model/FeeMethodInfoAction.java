package com.avito.android.remote.model;

import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/FeeMethodInfoAction;", "", "", "actionTitle", "Ljava/lang/String;", "getActionTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/HighDemandIcon;", "icon", "Lcom/avito/android/remote/model/HighDemandIcon;", "getIcon", "()Lcom/avito/android/remote/model/HighDemandIcon;", "Lcom/avito/android/remote/model/FeeMethodBottomSheet;", "bottomSheet", "Lcom/avito/android/remote/model/FeeMethodBottomSheet;", "getBottomSheet", "()Lcom/avito/android/remote/model/FeeMethodBottomSheet;", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/remote/model/FeeMethodBottomSheet;Lcom/avito/android/remote/model/HighDemandIcon;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodInfoAction {
    @SerializedName("actionTitle")
    @Nullable
    private final String actionTitle;
    @SerializedName("bottomSheet")
    @Nullable
    private final FeeMethodBottomSheet bottomSheet;
    @SerializedName("icon")
    @Nullable
    private final HighDemandIcon icon;
    @SerializedName("title")
    @Nullable
    private final AttributedText title;

    public FeeMethodInfoAction(@Nullable AttributedText attributedText, @Nullable String str, @Nullable FeeMethodBottomSheet feeMethodBottomSheet, @Nullable HighDemandIcon highDemandIcon) {
        this.title = attributedText;
        this.actionTitle = str;
        this.bottomSheet = feeMethodBottomSheet;
        this.icon = highDemandIcon;
    }

    @Nullable
    public final String getActionTitle() {
        return this.actionTitle;
    }

    @Nullable
    public final FeeMethodBottomSheet getBottomSheet() {
        return this.bottomSheet;
    }

    @Nullable
    public final HighDemandIcon getIcon() {
        return this.icon;
    }

    @Nullable
    public final AttributedText getTitle() {
        return this.title;
    }
}
