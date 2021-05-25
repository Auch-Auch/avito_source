package com.avito.android.remote.model.edit;

import com.avito.android.remote.model.edit.TariffAlertAction;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/edit/ShowNextAction;", "Lcom/avito/android/remote/model/edit/TariffAlertAction;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "buttonStyle", "Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "getButtonStyle", "()Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "type", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class ShowNextAction extends TariffAlertAction {
    @SerializedName("buttonStyle")
    @NotNull
    private final TariffAlertAction.ButtonStyle buttonStyle;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("type")
    @NotNull
    private final String type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShowNextAction(@NotNull String str, @NotNull String str2, @NotNull TariffAlertAction.ButtonStyle buttonStyle2) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(buttonStyle2, "buttonStyle");
        this.title = str;
        this.type = str2;
        this.buttonStyle = buttonStyle2;
    }

    @NotNull
    public final TariffAlertAction.ButtonStyle getButtonStyle() {
        return this.buttonStyle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
