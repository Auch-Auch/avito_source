package com.avito.android.remote.model.vas.applied;

import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.UniversalImage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/vas/applied/VasBundleBanner;", "", "Lcom/avito/android/remote/model/UniversalColor;", "backgroundColor", "Lcom/avito/android/remote/model/UniversalColor;", "getBackgroundColor", "()Lcom/avito/android/remote/model/UniversalColor;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/UniversalImage;", "image", "Lcom/avito/android/remote/model/UniversalImage;", "getImage", "()Lcom/avito/android/remote/model/UniversalImage;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalImage;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundleBanner {
    @SerializedName("backgroundColor")
    @NotNull
    private final UniversalColor backgroundColor;
    @SerializedName("image")
    @Nullable
    private final UniversalImage image;
    @SerializedName("text")
    @NotNull
    private final String text;

    public VasBundleBanner(@NotNull String str, @NotNull UniversalColor universalColor, @Nullable UniversalImage universalImage) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(universalColor, "backgroundColor");
        this.text = str;
        this.backgroundColor = universalColor;
        this.image = universalImage;
    }

    @NotNull
    public final UniversalColor getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final UniversalImage getImage() {
        return this.image;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }
}
