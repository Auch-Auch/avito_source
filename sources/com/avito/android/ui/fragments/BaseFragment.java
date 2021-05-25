package com.avito.android.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ActionBarUtils;
import com.avito.android.util.ToastsKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010\u000eJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\b\u0001\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u0019H\b¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\u001b\u001a\u00020\u0019H\b¢\u0006\u0004\b\u001d\u0010!R\"\u0010(\u001a\u00020\u00128\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/avito/android/ui/fragments/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "onGetLayoutInflater", "(Landroid/os/Bundle;)Landroid/view/LayoutInflater;", "onDetach", "()V", "baseContext", "onCreateThemeContext", "(Landroid/content/Context;Landroid/os/Bundle;)Landroid/content/Context;", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "setSupportActionBar", "(Landroidx/appcompat/widget/Toolbar;)V", "", "messageId", "duration", "Landroid/widget/Toast;", "showToast", "(II)Landroid/widget/Toast;", "", "message", "(Ljava/lang/CharSequence;I)Landroid/widget/Toast;", AuthSource.SEND_ABUSE, "Z", "isDelegateSetUp$core_release", "()Z", "setDelegateSetUp$core_release", "(Z)V", "isDelegateSetUp", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "localContext", "<init>", "core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseFragment extends Fragment {
    public boolean a;
    public Context b;

    public static /* synthetic */ Toast showToast$default(BaseFragment baseFragment, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            Context context = baseFragment.getContext();
            if (context != null) {
                return ToastsKt.showToast(context, i, i2);
            }
            return null;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToast");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public Context getContext() {
        Context context = this.b;
        return context != null ? context : super.getContext();
    }

    public final boolean isDelegateSetUp$core_release() {
        return this.a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!this.a) {
            setUpFragmentComponent(bundle);
        }
    }

    @Nullable
    public Context onCreateThemeContext(@NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "baseContext");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.b = null;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.b = onCreateThemeContext(requireContext, bundle);
        LayoutInflater from = LayoutInflater.from(getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        return from;
    }

    public final void setDelegateSetUp$core_release(boolean z) {
        this.a = z;
    }

    public final void setSupportActionBar(@Nullable Toolbar toolbar) {
        ActionBarUtils actionBarUtils = ActionBarUtils.INSTANCE;
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        actionBarUtils.setSupportActionBar((AppCompatActivity) activity, toolbar);
    }

    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        return false;
    }

    @UiThread
    @Nullable
    public final Toast showToast(@StringRes int i, int i2) {
        Context context = getContext();
        if (context != null) {
            return ToastsKt.showToast(context, i, i2);
        }
        return null;
    }

    @UiThread
    @Nullable
    public final Toast showToast(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        Context context = getContext();
        if (context != null) {
            return ToastsKt.showToast(context, charSequence, i);
        }
        return null;
    }

    public static /* synthetic */ Toast showToast$default(BaseFragment baseFragment, CharSequence charSequence, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            Intrinsics.checkNotNullParameter(charSequence, "message");
            Context context = baseFragment.getContext();
            if (context != null) {
                return ToastsKt.showToast(context, charSequence, i);
            }
            return null;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToast");
    }
}
