package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.tariff.bar.TariffBar;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b'\u0010(R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u001e\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/FeeMethodsResult;", "", "", "itemId", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/FeeMethodPackage;", "tariffPackage", "Lcom/avito/android/remote/model/FeeMethodPackage;", "getTariffPackage", "()Lcom/avito/android/remote/model/FeeMethodPackage;", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/tariff/bar/TariffBar;", "bar", "Lcom/avito/android/remote/tariff/bar/TariffBar;", "getBar", "()Lcom/avito/android/remote/tariff/bar/TariffBar;", "", "Lcom/avito/android/remote/model/FeeMethod;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "title", "getTitle", "", "isPackage", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/FeeMethodInfoAction;", "infoAction", "Lcom/avito/android/remote/model/FeeMethodInfoAction;", "getInfoAction", "()Lcom/avito/android/remote/model/FeeMethodInfoAction;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/tariff/bar/TariffBar;Lcom/avito/android/remote/model/FeeMethodInfoAction;Ljava/util/List;Ljava/lang/Boolean;Lcom/avito/android/remote/model/FeeMethodPackage;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodsResult {
    @SerializedName("bar")
    @Nullable
    private final TariffBar bar;
    @SerializedName("description")
    @Nullable
    private final AttributedText description;
    @SerializedName("infoAction")
    @Nullable
    private final FeeMethodInfoAction infoAction;
    @SerializedName("isPackage")
    @Nullable
    private final Boolean isPackage;
    @SerializedName("itemId")
    @NotNull
    private final String itemId;
    @SerializedName("list")
    @NotNull
    private final List<FeeMethod> list;
    @SerializedName("package")
    @Nullable
    private final FeeMethodPackage tariffPackage;
    @SerializedName("title")
    @NotNull
    private final String title;

    public FeeMethodsResult(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @Nullable TariffBar tariffBar, @Nullable FeeMethodInfoAction feeMethodInfoAction, @NotNull List<FeeMethod> list2, @Nullable Boolean bool, @Nullable FeeMethodPackage feeMethodPackage) {
        a.c1(str, "itemId", str2, "title", list2, "list");
        this.itemId = str;
        this.title = str2;
        this.description = attributedText;
        this.bar = tariffBar;
        this.infoAction = feeMethodInfoAction;
        this.list = list2;
        this.isPackage = bool;
        this.tariffPackage = feeMethodPackage;
    }

    @Nullable
    public final TariffBar getBar() {
        return this.bar;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.description;
    }

    @Nullable
    public final FeeMethodInfoAction getInfoAction() {
        return this.infoAction;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final List<FeeMethod> getList() {
        return this.list;
    }

    @Nullable
    public final FeeMethodPackage getTariffPackage() {
        return this.tariffPackage;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean isPackage() {
        return this.isPackage;
    }
}
