package com.avito.android.remote.model.edit;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/edit/TariffSheet;", "", "", "Lcom/avito/android/remote/model/edit/BottomSheetAction;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "Lcom/avito/android/remote/model/text/AttributedText;", "descriptions", "getDescriptions", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", ChannelContext.Item.USER_ID, "getUserId", "", "isClosable", "Z", "()Z", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffSheet {
    @SerializedName("actions")
    @Nullable
    private final List<BottomSheetAction> actions;
    @SerializedName("descriptions")
    @NotNull
    private final List<AttributedText> descriptions;
    @SerializedName("isClosable")
    private final boolean isClosable;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName(ChannelContext.Item.USER_ID)
    @NotNull
    private final String userId;

    public TariffSheet(@NotNull String str, boolean z, @NotNull String str2, @NotNull List<AttributedText> list, @Nullable List<BottomSheetAction> list2) {
        a.c1(str, ChannelContext.Item.USER_ID, str2, "title", list, "descriptions");
        this.userId = str;
        this.isClosable = z;
        this.title = str2;
        this.descriptions = list;
        this.actions = list2;
    }

    @Nullable
    public final List<BottomSheetAction> getActions() {
        return this.actions;
    }

    @NotNull
    public final List<AttributedText> getDescriptions() {
        return this.descriptions;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public final boolean isClosable() {
        return this.isClosable;
    }
}
