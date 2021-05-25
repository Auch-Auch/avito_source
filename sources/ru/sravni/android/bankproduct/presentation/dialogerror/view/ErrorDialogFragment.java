package ru.sravni.android.bankproduct.presentation.dialogerror.view;

import a7.c.a.a.o.d.b.b;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import com.avito.android.remote.auth.AuthSource;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.Provider;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.ErrorDialogFragmentSravniBinding;
import ru.sravni.android.bankproduct.presentation.dialogerror.di.PresentationDialogErrorProviderKt;
import ru.sravni.android.bankproduct.presentation.dialogerror.viewmodel.IDialogErrorViewModel;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0015\u0010\u0010J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019²\u0006\u000e\u0010\u0018\u001a\u00020\u00178\n@\nX\u0002"}, d2 = {"Lru/sravni/android/bankproduct/presentation/dialogerror/view/ErrorDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "", "onStart", "()V", "Lorg/kodein/di/Kodein;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/Kodein;", "kodein", "<init>", "Companion", "Lru/sravni/android/bankproduct/presentation/dialogerror/viewmodel/IDialogErrorViewModel;", "viewModel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ErrorDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] c = {Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(ErrorDialogFragment.class), "viewModel", "<v#0>"))};
    public final Kodein a = Kodein.Companion.invoke$default(Kodein.Companion, false, new a(this), 1, null);
    public HashMap b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/presentation/dialogerror/view/ErrorDialogFragment$Companion;", "", "", "errorMessage", "Lru/sravni/android/bankproduct/presentation/dialogerror/view/ErrorDialogFragment;", "newInstance", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/presentation/dialogerror/view/ErrorDialogFragment;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ErrorDialogFragment newInstance(@Nullable String str) {
            ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
            if (str != null) {
                Bundle bundle = new Bundle();
                bundle.putString("MESSAGE", str);
                errorDialogFragment.setArguments(bundle);
            }
            return errorDialogFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Kodein.MainBuilder, Unit> {
        public final /* synthetic */ ErrorDialogFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ErrorDialogFragment errorDialogFragment) {
            super(1);
            this.a = errorDialogFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Kodein.MainBuilder mainBuilder) {
            Kodein.MainBuilder mainBuilder2 = mainBuilder;
            Intrinsics.checkParameterIsNotNull(mainBuilder2, "$receiver");
            mainBuilder2.Bind(TypesKt.TT(new ErrorDialogFragment$kodein$1$$special$$inlined$bind$1()), null, null).with(new Provider(mainBuilder2.getContextType(), TypesKt.TT(new ErrorDialogFragment$kodein$1$$special$$inlined$provider$1()), new b(this)));
            Kodein.Builder.DefaultImpls.import$default(mainBuilder2, PresentationDialogErrorProviderKt.getPresentationDialogErrorKodeinModule(), false, 2, null);
            return Unit.INSTANCE;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.b == null) {
            this.b = new HashMap();
        }
        View view = (View) this.b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.b.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkExpressionValueIsNotNull(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.error_dialog_fragment_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…sravni, container, false)");
        ErrorDialogFragmentSravniBinding errorDialogFragmentSravniBinding = (ErrorDialogFragmentSravniBinding) inflate;
        Lazy provideDelegate = KodeinAwareKt.Instance(this.a, TypesKt.TT(new TypeReference<IDialogErrorViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.dialogerror.view.ErrorDialogFragment$onCreateView$$inlined$instance$1
        }), null).provideDelegate(null, c[0]);
        errorDialogFragmentSravniBinding.setViewModel((IDialogErrorViewModel) KodeinAwareKt.getDirect(this.a).getDkodein().Instance(TypesKt.TT(new TypeReference<IDialogErrorViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.dialogerror.view.ErrorDialogFragment$onCreateView$$inlined$instance$2
        }), null));
        ((IDialogErrorViewModel) provideDelegate.getValue()).getDialogErrorIntent().observe(getViewLifecycleOwner(), new a7.c.a.a.o.d.b.a(this));
        return errorDialogFragmentSravniBinding.getRoot();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        Window window2;
        super.onStart();
        Dialog dialog = getDialog();
        if (!(dialog == null || (window2 = dialog.getWindow()) == null)) {
            window2.setLayout(-1, -1);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }
}
