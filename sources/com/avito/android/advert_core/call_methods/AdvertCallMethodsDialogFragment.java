package com.avito.android.advert_core.call_methods;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.advert_core.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00112\u00020\u0001:\u0002\u0012\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment$Callback;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment$Callback;", "getCallback", "()Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment$Callback;", "setCallback", "(Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment$Callback;)V", "callback", "<init>", "()V", "Companion", "Callback", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertCallMethodsDialogFragment extends DialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    public Callback a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment$Callback;", "", "Lcom/avito/android/advert_core/call_methods/CallMethods;", "callMethods", "", "onPhoneCallSelected", "(Lcom/avito/android/advert_core/call_methods/CallMethods;)V", "onInAppCallSelected", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public interface Callback {
        void onInAppCallSelected(@NotNull CallMethods callMethods);

        void onPhoneCallSelected(@NotNull CallMethods callMethods);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment$Companion;", "", "Lcom/avito/android/advert_core/call_methods/CallMethods;", "callMethods", "Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment;", "newInstance", "(Lcom/avito/android/advert_core/call_methods/CallMethods;)Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment;", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final AdvertCallMethodsDialogFragment newInstance(@NotNull CallMethods callMethods) {
            Intrinsics.checkNotNullParameter(callMethods, "callMethods");
            AdvertCallMethodsDialogFragment advertCallMethodsDialogFragment = new AdvertCallMethodsDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("call_methods", callMethods);
            Unit unit = Unit.INSTANCE;
            advertCallMethodsDialogFragment.setArguments(bundle);
            return advertCallMethodsDialogFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<BottomSheetMenuDialog, Unit> {
        public final /* synthetic */ AdvertCallMethodsDialogFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CallMethods c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertCallMethodsDialogFragment advertCallMethodsDialogFragment, String str, CallMethods callMethods) {
            super(1);
            this.a = advertCallMethodsDialogFragment;
            this.b = str;
            this.c = callMethods;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(BottomSheetMenuDialog bottomSheetMenuDialog) {
            String str;
            WindowManager windowManager;
            Display defaultDisplay;
            BottomSheetMenuDialog bottomSheetMenuDialog2 = bottomSheetMenuDialog;
            Intrinsics.checkNotNullParameter(bottomSheetMenuDialog2, "$receiver");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            FragmentActivity activity = this.a.getActivity();
            if (!(activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
                defaultDisplay.getMetrics(displayMetrics);
            }
            bottomSheetMenuDialog2.setPeekHeight(displayMetrics.heightPixels);
            bottomSheetMenuDialog2.addHeader(true, new a2.a.a.g.c.a(this));
            if (this.c.getInApp() != null) {
                String string = this.a.getResources().getString(R.string.advert_call_methods_dialog_call_in_app);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…thods_dialog_call_in_app)");
                Integer valueOf = Integer.valueOf(com.avito.android.ui_components.R.drawable.ic_avito_logo_24);
                Integer valueOf2 = Integer.valueOf(com.avito.android.ui_components.R.drawable.ic_new_feature_badge);
                valueOf2.intValue();
                if (!this.c.getInApp().isNew()) {
                    valueOf2 = null;
                }
                BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, string, valueOf, null, null, valueOf2, new o4(0, this, bottomSheetMenuDialog2), 12, null);
            }
            if (this.c.getPhone() != null) {
                if (this.c.getPhone().getFormattedPhone() != null) {
                    str = this.a.getResources().getString(R.string.advert_call_methods_dialog_call_phone_number, this.c.getPhone().getFormattedPhone());
                } else {
                    str = this.a.getResources().getString(R.string.advert_call_methods_dialog_call_phone);
                }
                Intrinsics.checkNotNullExpressionValue(str, "if (callMethods.phone.fo…_phone)\n                }");
                BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, str, Integer.valueOf(com.avito.android.ui_components.R.drawable.ic_rds_call_24), null, null, null, new o4(1, this, bottomSheetMenuDialog2), 28, null);
            }
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public final Callback getCallback() {
        return this.a;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        String str;
        Bundle arguments = getArguments();
        CallMethods callMethods = arguments != null ? (CallMethods) arguments.getParcelable("call_methods") : null;
        if (callMethods != null) {
            if (callMethods.getPhone() == null || callMethods.getInApp() == null) {
                str = getResources().getString(R.string.advert_call_methods_dialog_title);
            } else {
                str = getResources().getString(R.string.advert_call_methods_dialog_title_multi_choice);
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (callMethods.phone !=…s_dialog_title)\n        }");
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            return new BottomSheetMenuDialog(requireContext, new a(this, str, callMethods));
        }
        throw new IllegalArgumentException("Call methods parameter is not provided".toString());
    }

    public final void setCallback(@Nullable Callback callback) {
        this.a = callback;
    }
}
