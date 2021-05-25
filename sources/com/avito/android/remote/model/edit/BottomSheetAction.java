package com.avito.android.remote.model.edit;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/edit/BottomSheetAction;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/edit/BottomSheetAction$ActionType;", "type", "Lcom/avito/android/remote/model/edit/BottomSheetAction$ActionType;", "getType", "()Lcom/avito/android/remote/model/edit/BottomSheetAction$ActionType;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/edit/BottomSheetAction$ActionType;)V", "ActionType", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class BottomSheetAction {
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("type")
    @NotNull
    private final ActionType type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/edit/BottomSheetAction$ActionType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "APPLY_CHANGES", "SHOW_NEXT", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public enum ActionType {
        APPLY_CHANGES("applyChanges"),
        SHOW_NEXT("showNext");
        
        @NotNull
        private final String value;

        private ActionType(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    public BottomSheetAction(@NotNull String str, @NotNull ActionType actionType) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(actionType, "type");
        this.title = str;
        this.type = actionType;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final ActionType getType() {
        return this.type;
    }
}
