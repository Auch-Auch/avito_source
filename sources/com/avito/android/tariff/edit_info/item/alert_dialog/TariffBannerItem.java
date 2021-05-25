package com.avito.android.tariff.edit_info.item.alert_dialog;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.edit.TariffBanner;
import com.avito.android.remote.model.text.AttributedText;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0004\b \u0010!R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffBannerItem;", "", "Lcom/avito/android/remote/model/edit/TariffBanner$State;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/edit/TariffBanner$State;", "getState", "()Lcom/avito/android/remote/model/edit/TariffBanner$State;", "state", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "d", "Ljava/lang/Boolean;", "isExclaimed", "()Ljava/lang/Boolean;", "", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffAlertActionItem;", "e", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "actions", "Lcom/avito/android/remote/model/text/AttributedText;", "c", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "description", "<init>", "(Lcom/avito/android/remote/model/edit/TariffBanner$State;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/util/List;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffBannerItem {
    @NotNull
    public final TariffBanner.State a;
    @NotNull
    public final String b;
    @NotNull
    public final AttributedText c;
    @Nullable
    public final Boolean d;
    @Nullable
    public final List<TariffAlertActionItem> e;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends com.avito.android.tariff.edit_info.item.alert_dialog.TariffAlertActionItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public TariffBannerItem(@NotNull TariffBanner.State state, @NotNull String str, @NotNull AttributedText attributedText, @Nullable Boolean bool, @Nullable List<? extends TariffAlertActionItem> list) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(attributedText, "description");
        this.a = state;
        this.b = str;
        this.c = attributedText;
        this.d = bool;
        this.e = list;
    }

    @Nullable
    public final List<TariffAlertActionItem> getActions() {
        return this.e;
    }

    @NotNull
    public final AttributedText getDescription() {
        return this.c;
    }

    @NotNull
    public final TariffBanner.State getState() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @Nullable
    public final Boolean isExclaimed() {
        return this.d;
    }
}
