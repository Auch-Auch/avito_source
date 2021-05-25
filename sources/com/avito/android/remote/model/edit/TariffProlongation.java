package com.avito.android.remote.model.edit;

import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/edit/TariffProlongation;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "offDescription", "getOffDescription", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "isSwitchActive", "Z", "()Z", "isSwitchOn", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ZZLcom/avito/android/remote/model/text/AttributedText;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffProlongation {
    @SerializedName("description")
    @NotNull
    private final AttributedText description;
    @SerializedName("isSwitchActive")
    private final boolean isSwitchActive;
    @SerializedName("isSwitchOn")
    private final boolean isSwitchOn;
    @SerializedName("offDescription")
    @Nullable
    private final AttributedText offDescription;
    @SerializedName("title")
    @NotNull
    private final String title;

    public TariffProlongation(@NotNull String str, @NotNull AttributedText attributedText, boolean z, boolean z2, @Nullable AttributedText attributedText2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(attributedText, "description");
        this.title = str;
        this.description = attributedText;
        this.isSwitchOn = z;
        this.isSwitchActive = z2;
        this.offDescription = attributedText2;
    }

    @NotNull
    public final AttributedText getDescription() {
        return this.description;
    }

    @Nullable
    public final AttributedText getOffDescription() {
        return this.offDescription;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean isSwitchActive() {
        return this.isSwitchActive;
    }

    public final boolean isSwitchOn() {
        return this.isSwitchOn;
    }
}
