package com.avito.android.remote.tariff.bar;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/tariff/bar/TariffBar;", "", "Lcom/avito/android/remote/tariff/bar/BarProgress;", "currentProgress", "Lcom/avito/android/remote/tariff/bar/BarProgress;", "getCurrentProgress", "()Lcom/avito/android/remote/tariff/bar/BarProgress;", "", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "startProgress", "getStartProgress", "Lcom/avito/android/remote/tariff/bar/BarDescription;", "description", "Lcom/avito/android/remote/tariff/bar/BarDescription;", "getDescription", "()Lcom/avito/android/remote/tariff/bar/BarDescription;", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/tariff/bar/BarProgress;Lcom/avito/android/remote/tariff/bar/BarProgress;Lcom/avito/android/remote/tariff/bar/BarDescription;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class TariffBar {
    @SerializedName("currentProgress")
    @NotNull
    private final BarProgress currentProgress;
    @SerializedName("description")
    @Nullable
    private final BarDescription description;
    @SerializedName("startProgress")
    @Nullable
    private final BarProgress startProgress;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    public TariffBar(@NotNull String str, @Nullable String str2, @NotNull BarProgress barProgress, @Nullable BarProgress barProgress2, @Nullable BarDescription barDescription) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(barProgress, "currentProgress");
        this.title = str;
        this.subtitle = str2;
        this.currentProgress = barProgress;
        this.startProgress = barProgress2;
        this.description = barDescription;
    }

    @NotNull
    public final BarProgress getCurrentProgress() {
        return this.currentProgress;
    }

    @Nullable
    public final BarDescription getDescription() {
        return this.description;
    }

    @Nullable
    public final BarProgress getStartProgress() {
        return this.startProgress;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
