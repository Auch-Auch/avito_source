package com.avito.android.remote.model;

import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/IncomeInfo;", "", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "confirmTitle", "getConfirmTitle", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "Lcom/avito/android/remote/model/text/AttributedText;", "getAttributedText", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class IncomeInfo {
    @SerializedName("attributedText")
    @NotNull
    private final AttributedText attributedText;
    @SerializedName("confirmTitle")
    @NotNull
    private final String confirmTitle;
    @SerializedName("image")
    @NotNull
    private final Image image;
    @SerializedName("title")
    @NotNull
    private final String title;

    public IncomeInfo(@NotNull String str, @NotNull AttributedText attributedText2, @NotNull String str2, @NotNull Image image2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(attributedText2, "attributedText");
        Intrinsics.checkNotNullParameter(str2, "confirmTitle");
        Intrinsics.checkNotNullParameter(image2, "image");
        this.title = str;
        this.attributedText = attributedText2;
        this.confirmTitle = str2;
        this.image = image2;
    }

    @NotNull
    public final AttributedText getAttributedText() {
        return this.attributedText;
    }

    @NotNull
    public final String getConfirmTitle() {
        return this.confirmTitle;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
