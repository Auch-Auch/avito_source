package com.avito.android.tariff.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.paid_services.routing.BarInfo;
import com.avito.android.paid_services.routing.DialogInfo;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.view.TariffCountBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/tariff/dialog/TariffDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "dialog", "", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lcom/avito/android/tariff/view/TariffCountBar;", AuthSource.SEND_ABUSE, "Lcom/avito/android/tariff/view/TariffCountBar;", "countBar", "Lcom/avito/android/paid_services/routing/BarInfo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/paid_services/routing/BarInfo;", "barInfo", "<init>", "()V", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffDialogFragment extends DialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public TariffCountBar a;
    public BarInfo b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/tariff/dialog/TariffDialogFragment$Companion;", "", "Lcom/avito/android/paid_services/routing/DialogInfo;", "dialogInfo", "Lcom/avito/android/tariff/dialog/TariffDialogFragment;", "newInstance", "(Lcom/avito/android/paid_services/routing/DialogInfo;)Lcom/avito/android/tariff/dialog/TariffDialogFragment;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TariffDialogFragment newInstance(@NotNull DialogInfo dialogInfo) {
            Intrinsics.checkNotNullParameter(dialogInfo, "dialogInfo");
            TariffDialogFragment tariffDialogFragment = new TariffDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("dialog_params", dialogInfo);
            Unit unit = Unit.INSTANCE;
            tariffDialogFragment.setArguments(bundle);
            return tariffDialogFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements DialogInterface.OnShowListener {
        public final /* synthetic */ TariffDialogFragment a;

        public a(TariffDialogFragment tariffDialogFragment) {
            this.a = tariffDialogFragment;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface dialogInterface) {
            TariffDialogFragment.access$showBarAnimation(this.a);
        }
    }

    public static final class b extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ TariffDialogFragment a;
        public final /* synthetic */ DialogInfo b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TariffDialogFragment tariffDialogFragment, DialogInfo dialogInfo) {
            super(2);
            this.a = tariffDialogFragment;
            this.b = dialogInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface, "it");
            config2.setTitle(this.b.getTitle());
            config2.setSubtitle(this.b.getDescription());
            config2.addDefaultButton(this.b.getActionTitle(), new a2.a.a.e3.c.a(this));
            TariffCountBar tariffCountBar = this.a.a;
            if (tariffCountBar != null) {
                config2.setCustomView(tariffCountBar);
            }
            config2.setCancelable(true);
            return Unit.INSTANCE;
        }
    }

    public static final void access$showBarAnimation(TariffDialogFragment tariffDialogFragment) {
        BarInfo barInfo;
        Float startProgress;
        android.app.Dialog dialog = tariffDialogFragment.getDialog();
        if (!(dialog instanceof Dialog)) {
            dialog = null;
        }
        Dialog dialog2 = (Dialog) dialog;
        long enterAnimationDuration = dialog2 != null ? dialog2.getEnterAnimationDuration() : 0;
        TariffCountBar tariffCountBar = tariffDialogFragment.a;
        if (tariffCountBar != null && (barInfo = tariffDialogFragment.b) != null && (startProgress = barInfo.getStartProgress()) != null) {
            float floatValue = startProgress.floatValue();
            ProgressState startProgressState = barInfo.getStartProgressState();
            if (startProgressState != null) {
                tariffCountBar.showProgressAnimation(floatValue, startProgressState, barInfo.getProgress(), barInfo.getProgressState(), 250 + enterAnimationDuration);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public android.app.Dialog onCreateDialog(@Nullable Bundle bundle) {
        TariffCountBar tariffCountBar;
        Float f;
        ProgressState progressState;
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Illeg…ption(\"args must be set\")");
            DialogInfo dialogInfo = (DialogInfo) arguments.getParcelable("dialog_params");
            if (dialogInfo != null) {
                BarInfo barInfo = dialogInfo.getBarInfo();
                this.b = barInfo;
                if (barInfo != null) {
                    if (bundle != null || barInfo.getStartProgress() == null) {
                        f = Float.valueOf(barInfo.getProgress());
                    } else {
                        f = barInfo.getStartProgress();
                    }
                    float floatValue = f != null ? f.floatValue() : 0.0f;
                    if (bundle != null || barInfo.getStartProgressState() == null) {
                        progressState = barInfo.getProgressState();
                    } else {
                        progressState = barInfo.getStartProgressState();
                    }
                    if (progressState == null) {
                        progressState = ProgressState.NORMAL;
                    }
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    tariffCountBar = new TariffCountBar(requireContext, null, 0, 6, null);
                    tariffCountBar.setTitle(barInfo.getTitle());
                    tariffCountBar.bindDescription(barInfo.getDescription());
                    tariffCountBar.setDescriptionStatus(barInfo.getDescriptionStatus());
                    tariffCountBar.setProgress(floatValue);
                    tariffCountBar.setProgressState(progressState);
                } else {
                    tariffCountBar = null;
                }
                this.a = tariffCountBar;
                Dialog.Companion companion = Dialog.Companion;
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                Dialog create$default = Dialog.Companion.create$default(companion, requireContext2, 0, 0, new b(this, dialogInfo), 6, null);
                if (bundle == null) {
                    create$default.setOnShowListener(new a(this));
                }
                return create$default;
            }
            throw new IllegalArgumentException("dialog params must be set");
        }
        throw new IllegalArgumentException("args must be set");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "it");
            if (!activity.isFinishing() && !activity.isChangingConfigurations()) {
                activity.finish();
            }
        }
    }
}
