package com.avito.android.tariff.change;

import a2.a.a.e3.a.b;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/tariff/change/ChangeConfirmationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDetach", "()V", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class ChangeConfirmationDialogFragment extends DialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public PaidServicesRouter a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/tariff/change/ChangeConfirmationDialogFragment$Companion;", "", "Lcom/avito/android/remote/model/Action$Confirmation;", "confirmation", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/tariff/change/ChangeConfirmationDialogFragment;", "newInstance", "(Lcom/avito/android/remote/model/Action$Confirmation;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/tariff/change/ChangeConfirmationDialogFragment;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ChangeConfirmationDialogFragment newInstance(@NotNull Action.Confirmation confirmation, @NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(confirmation, "confirmation");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            ChangeConfirmationDialogFragment changeConfirmationDialogFragment = new ChangeConfirmationDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", confirmation);
            bundle.putParcelable(ShareConstants.MEDIA_URI, deepLink);
            Unit unit = Unit.INSTANCE;
            changeConfirmationDialogFragment.setArguments(bundle);
            return changeConfirmationDialogFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ ChangeConfirmationDialogFragment a;
        public final /* synthetic */ Action.Confirmation b;
        public final /* synthetic */ DeepLink c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChangeConfirmationDialogFragment changeConfirmationDialogFragment, Action.Confirmation confirmation, DeepLink deepLink) {
            super(2);
            this.a = changeConfirmationDialogFragment;
            this.b = confirmation;
            this.c = deepLink;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "it");
            config2.setTitle(this.b.getTitle());
            config2.setButtonsOrientation(1);
            config2.setSubtitle(this.b.getDescription());
            config2.addPrimaryButton(this.b.getOk(), new a2.a.a.e3.a.a(this, dialogInterface2));
            config2.addSecondaryButton(this.b.getCancel(), new b(dialogInterface2));
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof PaidServicesRouter)) {
            context = null;
        }
        PaidServicesRouter paidServicesRouter = (PaidServicesRouter) context;
        if (paidServicesRouter != null) {
            this.a = paidServicesRouter;
            return;
        }
        throw new IllegalStateException("context must implement ConfirmationListener");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public android.app.Dialog onCreateDialog(@Nullable Bundle bundle) {
        Action.Confirmation confirmation;
        DeepLink deepLink;
        Bundle arguments = getArguments();
        if (arguments == null || (confirmation = (Action.Confirmation) arguments.getParcelable("data")) == null) {
            throw new IllegalArgumentException("confirmation must be set");
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (deepLink = (DeepLink) arguments2.getParcelable(ShareConstants.MEDIA_URI)) == null) {
            throw new IllegalArgumentException("deeplink must be set");
        }
        Dialog.Companion companion = Dialog.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return Dialog.Companion.create$default(companion, requireActivity, 0, 0, new a(this, confirmation, deepLink), 6, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.a = null;
    }
}
