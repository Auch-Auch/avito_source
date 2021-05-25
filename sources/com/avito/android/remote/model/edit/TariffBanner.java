package com.avito.android.remote.model.edit;

import com.avito.android.payment.SberbankOnlineKt;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/edit/TariffBanner;", "", "Lcom/avito/android/remote/model/edit/TariffBanner$State;", "state", "Lcom/avito/android/remote/model/edit/TariffBanner$State;", "getState", "()Lcom/avito/android/remote/model/edit/TariffBanner$State;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "isExclaimed", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "Lcom/avito/android/remote/model/edit/TariffAlertAction;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "<init>", "(Lcom/avito/android/remote/model/edit/TariffBanner$State;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/util/List;)V", "State", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffBanner {
    @SerializedName("actions")
    @Nullable
    private final List<TariffAlertAction> actions;
    @SerializedName("description")
    @NotNull
    private final AttributedText description;
    @SerializedName("isExclaimed")
    @Nullable
    private final Boolean isExclaimed;
    @SerializedName("state")
    @NotNull
    private final State state;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/edit/TariffBanner$State;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", SberbankOnlineKt.RESULT_SUCCESS, "NORMAL", "WARNING", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public enum State {
        SUCCESS("success"),
        NORMAL("normal"),
        WARNING("warning");
        
        @NotNull
        private final String value;

        private State(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends com.avito.android.remote.model.edit.TariffAlertAction> */
    /* JADX WARN: Multi-variable type inference failed */
    public TariffBanner(@NotNull State state2, @NotNull String str, @NotNull AttributedText attributedText, @Nullable Boolean bool, @Nullable List<? extends TariffAlertAction> list) {
        Intrinsics.checkNotNullParameter(state2, "state");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(attributedText, "description");
        this.state = state2;
        this.title = str;
        this.description = attributedText;
        this.isExclaimed = bool;
        this.actions = list;
    }

    @Nullable
    public final List<TariffAlertAction> getActions() {
        return this.actions;
    }

    @NotNull
    public final AttributedText getDescription() {
        return this.description;
    }

    @NotNull
    public final State getState() {
        return this.state;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean isExclaimed() {
        return this.isExclaimed;
    }
}
