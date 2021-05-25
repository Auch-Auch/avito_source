package com.avito.android.remote.model.edit;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/edit/TariffAlertAction;", "", "<init>", "()V", "ButtonStyle", "Lcom/avito/android/remote/model/edit/DeepLinkAction;", "Lcom/avito/android/remote/model/edit/TariffSheetAction;", "Lcom/avito/android/remote/model/edit/ShowNextAction;", "tariff_release"}, k = 1, mv = {1, 4, 2})
public abstract class TariffAlertAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "OUTLINE", "LINK_INCREASED", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public enum ButtonStyle {
        OUTLINE("outline"),
        LINK_INCREASED("linkIncreased");
        
        @NotNull
        private final String value;

        private ButtonStyle(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    private TariffAlertAction() {
    }

    public /* synthetic */ TariffAlertAction(j jVar) {
        this();
    }
}
