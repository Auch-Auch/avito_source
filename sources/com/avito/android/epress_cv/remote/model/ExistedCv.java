package com.avito.android.epress_cv.remote.model;

import a2.b.a.a.a;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001aBA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/avito/android/epress_cv/remote/model/ExistedCv;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/epress_cv/remote/model/ExistedCv$CV;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "description", "getDescription", "actionText", "getActionText", "Lcom/avito/android/remote/model/text/AttributedText;", "disclaimer", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "()Lcom/avito/android/remote/model/text/AttributedText;", "disableText", "getDisableText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "CV", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class ExistedCv {
    @SerializedName("actionText")
    @NotNull
    private final String actionText;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("disableText")
    @Nullable
    private final String disableText;
    @SerializedName("disclaimer")
    @NotNull
    private final AttributedText disclaimer;
    @SerializedName("list")
    @NotNull
    private final List<CV> list;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/epress_cv/remote/model/ExistedCv$CV;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
    public static final class CV {
        @SerializedName("description")
        @NotNull
        private final String description;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("title")
        @NotNull
        private final String title;

        public CV(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            a.Z0(str, "id", str2, "title", str3, "description");
            this.id = str;
            this.title = str2;
            this.description = str3;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }

    public ExistedCv(@NotNull String str, @Nullable String str2, @NotNull AttributedText attributedText, @NotNull String str3, @NotNull List<CV> list2, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(attributedText, "disclaimer");
        Intrinsics.checkNotNullParameter(str3, "actionText");
        Intrinsics.checkNotNullParameter(list2, "list");
        this.title = str;
        this.description = str2;
        this.disclaimer = attributedText;
        this.actionText = str3;
        this.list = list2;
        this.disableText = str4;
    }

    @NotNull
    public final String getActionText() {
        return this.actionText;
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
    public final List<CV> getList() {
        return this.list;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
