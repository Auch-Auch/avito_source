package com.avito.android.remote.model;

import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B/\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/FeeMethodBottomSheet;", "", "Lcom/avito/android/remote/model/FeeMethodAction;", "primaryAction", "Lcom/avito/android/remote/model/FeeMethodAction;", "getPrimaryAction", "()Lcom/avito/android/remote/model/FeeMethodAction;", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "secondaryAction", "getSecondaryAction", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/FeeMethodAction;Lcom/avito/android/remote/model/FeeMethodAction;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodBottomSheet {
    @SerializedName("description")
    @Nullable
    private final AttributedText description;
    @SerializedName("primaryAction")
    @Nullable
    private final FeeMethodAction primaryAction;
    @SerializedName("secondaryAction")
    @Nullable
    private final FeeMethodAction secondaryAction;
    @SerializedName("title")
    @Nullable
    private final String title;

    public FeeMethodBottomSheet(@Nullable String str, @Nullable AttributedText attributedText, @Nullable FeeMethodAction feeMethodAction, @Nullable FeeMethodAction feeMethodAction2) {
        this.title = str;
        this.description = attributedText;
        this.primaryAction = feeMethodAction;
        this.secondaryAction = feeMethodAction2;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.description;
    }

    @Nullable
    public final FeeMethodAction getPrimaryAction() {
        return this.primaryAction;
    }

    @Nullable
    public final FeeMethodAction getSecondaryAction() {
        return this.secondaryAction;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
