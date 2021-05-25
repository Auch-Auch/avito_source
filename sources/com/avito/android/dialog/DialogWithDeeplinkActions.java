package com.avito.android.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lastclick.LastClick;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u000fJ\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/avito/android/dialog/DialogWithDeeplinkActions;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/lib/design/dialog/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Lcom/avito/android/lib/design/dialog/Dialog;", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "onDialogCreate", "()V", "setUpDialogComponent", "onCloseButtonClicked", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "onDeepLinkClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/dialog/DialogWithDeeplinkActionsRouter;", AuthSource.BOOKING_ORDER, "()Lcom/avito/android/dialog/DialogWithDeeplinkActionsRouter;", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "info", "<init>", "core_release"}, k = 1, mv = {1, 4, 2})
public class DialogWithDeeplinkActions extends DialogFragment {
    public DeepLinksDialogInfo a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            DeepLinksDialogInfo.ControlsDirection.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            DeepLinksDialogInfo.ControlsDirection controlsDirection = DeepLinksDialogInfo.ControlsDirection.HORIZONTAL;
            iArr[0] = 1;
            DeepLinksDialogInfo.ControlsDirection controlsDirection2 = DeepLinksDialogInfo.ControlsDirection.VERTICAL;
            iArr[1] = 2;
            DeepLinksDialogInfo.ActionType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            DeepLinksDialogInfo.ActionType actionType = DeepLinksDialogInfo.ActionType.POSITIVE;
            iArr2[0] = 1;
            DeepLinksDialogInfo.ActionType actionType2 = DeepLinksDialogInfo.ActionType.NEGATIVE;
            iArr2[1] = 2;
            DeepLinksDialogInfo.ActionType actionType3 = DeepLinksDialogInfo.ActionType.NEUTRAL;
            iArr2[2] = 3;
        }
    }

    public static final class a extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ DialogWithDeeplinkActions a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DialogWithDeeplinkActions dialogWithDeeplinkActions) {
            super(2);
            this.a = dialogWithDeeplinkActions;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0087  */
        @Override // kotlin.jvm.functions.Function2
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public kotlin.Unit invoke(com.avito.android.lib.design.dialog.Dialog.Config r7, android.content.DialogInterface r8) {
            /*
                r6 = this;
                com.avito.android.lib.design.dialog.Dialog$Config r7 = (com.avito.android.lib.design.dialog.Dialog.Config) r7
                android.content.DialogInterface r8 = (android.content.DialogInterface) r8
                java.lang.String r0 = "$receiver"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.String r0 = "it"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                com.avito.android.dialog.DialogWithDeeplinkActions r8 = r6.a
                com.avito.android.remote.model.DeepLinksDialogInfo r8 = com.avito.android.dialog.DialogWithDeeplinkActions.access$getInfo$p(r8)
                java.lang.String r8 = r8.getTitle()
                r7.setTitle(r8)
                com.avito.android.dialog.DialogWithDeeplinkActions r8 = r6.a
                com.avito.android.remote.model.DeepLinksDialogInfo r8 = com.avito.android.dialog.DialogWithDeeplinkActions.access$getInfo$p(r8)
                java.lang.String r8 = r8.getDescription()
                r7.setSubtitle(r8)
                com.avito.android.dialog.DialogWithDeeplinkActions r8 = r6.a
                com.avito.android.remote.model.DeepLinksDialogInfo r8 = com.avito.android.dialog.DialogWithDeeplinkActions.access$getInfo$p(r8)
                java.lang.Boolean r8 = r8.isCancellable()
                r0 = 0
                if (r8 == 0) goto L_0x003a
                boolean r8 = r8.booleanValue()
                goto L_0x003b
            L_0x003a:
                r8 = 0
            L_0x003b:
                r7.setCancelable(r8)
                com.avito.android.dialog.DialogWithDeeplinkActions r8 = r6.a
                com.avito.android.remote.model.DeepLinksDialogInfo r8 = com.avito.android.dialog.DialogWithDeeplinkActions.access$getInfo$p(r8)
                com.avito.android.remote.model.DeepLinksDialogInfo$ControlsDirection r8 = r8.getControlsDirection()
                r1 = 1
                if (r8 != 0) goto L_0x004c
                goto L_0x0054
            L_0x004c:
                int r8 = r8.ordinal()
                if (r8 == 0) goto L_0x005c
                if (r8 != r1) goto L_0x0056
            L_0x0054:
                r8 = 1
                goto L_0x005d
            L_0x0056:
                kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
                r7.<init>()
                throw r7
            L_0x005c:
                r8 = 0
            L_0x005d:
                r7.setButtonsOrientation(r8)
                com.avito.android.dialog.DialogWithDeeplinkActions r8 = r6.a
                com.avito.android.remote.model.DeepLinksDialogInfo r8 = com.avito.android.dialog.DialogWithDeeplinkActions.access$getInfo$p(r8)
                java.lang.Boolean r8 = r8.getShouldShowCloseControl()
                if (r8 == 0) goto L_0x0073
                boolean r8 = r8.booleanValue()
                r7.setCloseButtonVisible(r8)
            L_0x0073:
                com.avito.android.dialog.DialogWithDeeplinkActions r8 = r6.a
                com.avito.android.remote.model.DeepLinksDialogInfo r8 = com.avito.android.dialog.DialogWithDeeplinkActions.access$getInfo$p(r8)
                java.util.List r8 = r8.getItems()
                java.util.Iterator r8 = r8.iterator()
            L_0x0081:
                boolean r2 = r8.hasNext()
                if (r2 == 0) goto L_0x00db
                java.lang.Object r2 = r8.next()
                com.avito.android.remote.model.DeepLinksDialogInfo$Action r2 = (com.avito.android.remote.model.DeepLinksDialogInfo.Action) r2
                com.avito.android.remote.model.DeepLinksDialogInfo$ActionType r3 = r2.getType()
                int r3 = r3.ordinal()
                if (r3 == 0) goto L_0x00ce
                if (r3 == r1) goto L_0x00bf
                r4 = 2
                if (r3 == r4) goto L_0x00b2
                java.lang.String r3 = "Can't process link for button "
                java.lang.StringBuilder r3 = a2.b.a.a.a.L(r3)
                com.avito.android.remote.model.DeepLinksDialogInfo$ActionType r2 = r2.getType()
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r3 = 0
                com.avito.android.util.Logs.error$default(r2, r3, r4, r3)
                goto L_0x0081
            L_0x00b2:
                java.lang.String r3 = r2.getTitle()
                i4 r5 = new i4
                r5.<init>(r4, r2, r6, r7)
                r7.addSecondaryButton(r3, r5)
                goto L_0x0081
            L_0x00bf:
                java.lang.String r3 = r2.getTitle()
                int r4 = com.avito.android.lib.design.avito.R.style.Avito_Button_DangerLarge
                i4 r5 = new i4
                r5.<init>(r1, r2, r6, r7)
                r7.addButton(r3, r4, r5)
                goto L_0x0081
            L_0x00ce:
                java.lang.String r3 = r2.getTitle()
                i4 r4 = new i4
                r4.<init>(r0, r2, r6, r7)
                r7.addPrimaryButton(r3, r4)
                goto L_0x0081
            L_0x00db:
                a2.a.a.o0.a r8 = new a2.a.a.o0.a
                r8.<init>(r6)
                r7.setOnDismissListener(r8)
                a2.a.a.o0.b r8 = new a2.a.a.o0.b
                r8.<init>(r6)
                r7.setOnCloseClickedListener(r8)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.dialog.DialogWithDeeplinkActions.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final /* synthetic */ DeepLinksDialogInfo access$getInfo$p(DialogWithDeeplinkActions dialogWithDeeplinkActions) {
        DeepLinksDialogInfo deepLinksDialogInfo = dialogWithDeeplinkActions.a;
        if (deepLinksDialogInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
        }
        return deepLinksDialogInfo;
    }

    public static final void access$onButtonClick(DialogWithDeeplinkActions dialogWithDeeplinkActions, DeepLink deepLink) {
        if (deepLink == null) {
            dialogWithDeeplinkActions.a();
        } else if (dialogWithDeeplinkActions.onDeepLinkClicked(deepLink)) {
            dialogWithDeeplinkActions.a();
        } else {
            dialogWithDeeplinkActions.a();
            DialogWithDeeplinkActionsRouter b = dialogWithDeeplinkActions.b();
            if (b != null) {
                b.openDeepLink(deepLink);
            }
        }
    }

    public final void a() {
        LastClick.Updater.update();
        dismiss();
        DialogWithDeeplinkActionsRouter b = b();
        if (b != null) {
            b.onDialogDismiss();
        }
    }

    public final DialogWithDeeplinkActionsRouter b() {
        Fragment parentFragment = getParentFragment();
        DialogWithDeeplinkActionsRouter dialogWithDeeplinkActionsRouter = null;
        if (parentFragment != null) {
            if (!(parentFragment instanceof DialogWithDeeplinkActionsRouter)) {
                parentFragment = null;
            }
            DialogWithDeeplinkActionsRouter dialogWithDeeplinkActionsRouter2 = (DialogWithDeeplinkActionsRouter) parentFragment;
            if (dialogWithDeeplinkActionsRouter2 != null) {
                return dialogWithDeeplinkActionsRouter2;
            }
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof DialogWithDeeplinkActionsRouter) {
            dialogWithDeeplinkActionsRouter = activity;
        }
        return dialogWithDeeplinkActionsRouter;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        LastClick.Updater.update();
        a();
    }

    public void onCloseButtonClicked() {
        a();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setUpDialogComponent();
        Bundle arguments = getArguments();
        DeepLinksDialogInfo deepLinksDialogInfo = arguments != null ? (DeepLinksDialogInfo) arguments.getParcelable("key_dialog_info") : null;
        Intrinsics.checkNotNull(deepLinksDialogInfo);
        this.a = deepLinksDialogInfo;
    }

    public boolean onDeepLinkClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return false;
    }

    public void onDialogCreate() {
    }

    public void setUpDialogComponent() {
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (bundle == null) {
            onDialogCreate();
        }
        Dialog.Companion companion = Dialog.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Dialog create$default = Dialog.Companion.create$default(companion, requireContext, 0, 0, new a(this), 6, null);
        DeepLinksDialogInfo deepLinksDialogInfo = this.a;
        if (deepLinksDialogInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
        }
        Boolean isCancellable = deepLinksDialogInfo.isCancellable();
        create$default.setCanceledOnTouchOutside(isCancellable != null ? isCancellable.booleanValue() : false);
        return create$default;
    }
}
