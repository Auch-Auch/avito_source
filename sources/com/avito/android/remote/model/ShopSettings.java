package com.avito.android.remote.model;

import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/ShopSettings;", "", "Lcom/avito/android/remote/model/ShopSettingsExitWarning;", "exitWarning", "Lcom/avito/android/remote/model/ShopSettingsExitWarning;", "getExitWarning", "()Lcom/avito/android/remote/model/ShopSettingsExitWarning;", "Lcom/avito/android/remote/model/ShopSettingsButton;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/android/remote/model/ShopSettingsButton;", "getButton", "()Lcom/avito/android/remote/model/ShopSettingsButton;", "Lcom/avito/android/remote/model/ShopSettingsAlert;", "alert", "Lcom/avito/android/remote/model/ShopSettingsAlert;", "getAlert", "()Lcom/avito/android/remote/model/ShopSettingsAlert;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/ShopSettingsForm;", "form", "Ljava/util/List;", "getForm", "()Ljava/util/List;", "info", "getInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ShopSettingsExitWarning;Lcom/avito/android/remote/model/ShopSettingsAlert;Lcom/avito/android/remote/model/ShopSettingsButton;Ljava/util/List;)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettings {
    @SerializedName("alert")
    @Nullable
    private final ShopSettingsAlert alert;
    @SerializedName(PhonePageSourceKt.PHONE_SOURCE_BUTTON)
    @NotNull
    private final ShopSettingsButton button;
    @SerializedName("exitWarning")
    @Nullable
    private final ShopSettingsExitWarning exitWarning;
    @SerializedName("form")
    @NotNull
    private final List<ShopSettingsForm> form;
    @SerializedName("info")
    @Nullable
    private final String info;
    @SerializedName("title")
    @Nullable
    private final String title;

    public ShopSettings(@Nullable String str, @Nullable String str2, @Nullable ShopSettingsExitWarning shopSettingsExitWarning, @Nullable ShopSettingsAlert shopSettingsAlert, @NotNull ShopSettingsButton shopSettingsButton, @NotNull List<ShopSettingsForm> list) {
        Intrinsics.checkNotNullParameter(shopSettingsButton, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        Intrinsics.checkNotNullParameter(list, "form");
        this.title = str;
        this.info = str2;
        this.exitWarning = shopSettingsExitWarning;
        this.alert = shopSettingsAlert;
        this.button = shopSettingsButton;
        this.form = list;
    }

    @Nullable
    public final ShopSettingsAlert getAlert() {
        return this.alert;
    }

    @NotNull
    public final ShopSettingsButton getButton() {
        return this.button;
    }

    @Nullable
    public final ShopSettingsExitWarning getExitWarning() {
        return this.exitWarning;
    }

    @NotNull
    public final List<ShopSettingsForm> getForm() {
        return this.form;
    }

    @Nullable
    public final String getInfo() {
        return this.info;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
