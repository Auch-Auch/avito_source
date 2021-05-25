package com.avito.android.dialog;

import android.os.Bundle;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import com.avito.android.util.FragmentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "info", "Lcom/avito/android/dialog/DialogWithDeeplinkActions;", "createDialogWithDeepLinkActions", "(Lcom/avito/android/remote/model/DeepLinksDialogInfo;)Lcom/avito/android/dialog/DialogWithDeeplinkActions;", "setInfo", "(Lcom/avito/android/dialog/DialogWithDeeplinkActions;Lcom/avito/android/remote/model/DeepLinksDialogInfo;)Lcom/avito/android/dialog/DialogWithDeeplinkActions;", "core_release"}, k = 2, mv = {1, 4, 2})
public final class DialogWithDeeplinkActionsKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ DeepLinksDialogInfo a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeepLinksDialogInfo deepLinksDialogInfo) {
            super(1);
            this.a = deepLinksDialogInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putParcelable("key_dialog_info", this.a);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final DialogWithDeeplinkActions createDialogWithDeepLinkActions(@NotNull DeepLinksDialogInfo deepLinksDialogInfo) {
        Intrinsics.checkNotNullParameter(deepLinksDialogInfo, "info");
        return setInfo(new DialogWithDeeplinkActions(), deepLinksDialogInfo);
    }

    @NotNull
    public static final DialogWithDeeplinkActions setInfo(@NotNull DialogWithDeeplinkActions dialogWithDeeplinkActions, @NotNull DeepLinksDialogInfo deepLinksDialogInfo) {
        Intrinsics.checkNotNullParameter(dialogWithDeeplinkActions, "$this$setInfo");
        Intrinsics.checkNotNullParameter(deepLinksDialogInfo, "info");
        FragmentsKt.arguments$default(dialogWithDeeplinkActions, 0, new a(deepLinksDialogInfo), 1, null);
        return dialogWithDeeplinkActions;
    }
}
