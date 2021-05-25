package com.avito.android.epress_cv.remote.model;

import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/epress_cv/remote/model/PublishCv;", "", "", "actionText", "Ljava/lang/String;", "getActionText", "()Ljava/lang/String;", "description", "getDescription", "disableText", "getDisableText", "title", "getTitle", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "getCategoryParameters", "()Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "Lcom/avito/android/remote/model/text/AttributedText;", "disclaimer", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Ljava/lang/String;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class PublishCv {
    @SerializedName("actionText")
    @NotNull
    private final String actionText;
    @SerializedName("categoryParams")
    @NotNull
    private final CategoryParameters categoryParameters;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("disableText")
    @Nullable
    private final String disableText;
    @SerializedName("disclaimer")
    @NotNull
    private final AttributedText disclaimer;
    @SerializedName("title")
    @NotNull
    private final String title;

    public PublishCv(@NotNull String str, @Nullable String str2, @NotNull AttributedText attributedText, @NotNull String str3, @NotNull CategoryParameters categoryParameters2, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(attributedText, "disclaimer");
        Intrinsics.checkNotNullParameter(str3, "actionText");
        Intrinsics.checkNotNullParameter(categoryParameters2, "categoryParameters");
        this.title = str;
        this.description = str2;
        this.disclaimer = attributedText;
        this.actionText = str3;
        this.categoryParameters = categoryParameters2;
        this.disableText = str4;
    }

    @NotNull
    public final String getActionText() {
        return this.actionText;
    }

    @NotNull
    public final CategoryParameters getCategoryParameters() {
        return this.categoryParameters;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getDisableText() {
        return this.disableText;
    }

    @NotNull
    public final AttributedText getDisclaimer() {
        return this.disclaimer;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
