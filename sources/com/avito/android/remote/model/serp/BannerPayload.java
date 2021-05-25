package com.avito.android.remote.model.serp;

import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/serp/BannerPayload;", "", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "<init>", "(Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class BannerPayload {
    @SerializedName("action")
    @NotNull
    private final Action action;
    @SerializedName("image")
    @NotNull
    private final Image image;
    @SerializedName("text")
    @NotNull
    private final String text;

    public BannerPayload(@NotNull Action action2, @NotNull Image image2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(str, "text");
        this.action = action2;
        this.image = image2;
        this.text = str;
    }

    @NotNull
    public final Action getAction() {
        return this.action;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }
}
