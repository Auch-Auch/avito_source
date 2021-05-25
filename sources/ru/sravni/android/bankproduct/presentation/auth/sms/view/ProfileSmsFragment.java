package ru.sravni.android.bankproduct.presentation.auth.sms.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.ProfileSmsFragmentSravniBinding;
import ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.di.PresentationBottomNavigationProviderKt;
import ru.sravni.android.bankproduct.utils.CommonFragment;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lru/sravni/android/bankproduct/presentation/auth/sms/view/ProfileSmsFragment;", "Lru/sravni/android/bankproduct/utils/CommonFragment;", "Lorg/kodein/di/Kodein$Module;", "initModule", "()Lorg/kodein/di/Kodein$Module;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "ru/sravni/android/bankproduct/presentation/auth/sms/view/ProfileSmsFragment$countDownTimer$1", "f", "Lru/sravni/android/bankproduct/presentation/auth/sms/view/ProfileSmsFragment$countDownTimer$1;", "countDownTimer", "Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/IProfileSmsViewModel;", "e", "Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/IProfileSmsViewModel;", "viewModel", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileSmsFragment extends CommonFragment {
    public IProfileSmsViewModel e;
    public final ProfileSmsFragment$countDownTimer$1 f = new ProfileSmsFragment$countDownTimer$1(this, 59000, 1000);
    public HashMap g;

    public static final class a extends Lambda implements Function1<Kodein.Builder, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Kodein.Builder builder) {
            Kodein.Builder builder2 = builder;
            Intrinsics.checkParameterIsNotNull(builder2, "$receiver");
            Kodein.Builder.DefaultImpls.import$default(builder2, PresentationProfileSmsProviderKt.getPresentationProfileSmsKodeinModule(), false, 2, null);
            Kodein.Builder.DefaultImpls.import$default(builder2, PresentationBottomNavigationProviderKt.getPresentationBottomNavigationKodeinModule(), false, 2, null);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Observer<Integer> {
        public final /* synthetic */ ProfileSmsFragment a;

        public b(ProfileSmsFragment profileSmsFragment) {
            this.a = profileSmsFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Integer num) {
            Integer num2 = num;
            int i = R.id.start_timer;
            if (num2 != null && num2.intValue() == i) {
                this.a.f.start();
                return;
            }
            int i2 = R.id.stop_timer;
            if (num2 != null && num2.intValue() == i2) {
                this.a.f.cancel();
            }
        }
    }

    public static final /* synthetic */ IProfileSmsViewModel access$getViewModel$p(ProfileSmsFragment profileSmsFragment) {
        IProfileSmsViewModel iProfileSmsViewModel = profileSmsFragment.e;
        if (iProfileSmsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return iProfileSmsViewModel;
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public View _$_findCachedViewById(int i) {
        if (this.g == null) {
            this.g = new HashMap();
        }
        View view = (View) this.g.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.g.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    @NotNull
    public Kodein.Module initModule() {
        return new Kodein.Module("ProfileSmsFragmentModule", false, null, a.a, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.profile_sms_fragment_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…sravni, container, false)");
        ProfileSmsFragmentSravniBinding profileSmsFragmentSravniBinding = (ProfileSmsFragmentSravniBinding) inflate;
        IProfileSmsViewModel iProfileSmsViewModel = (IProfileSmsViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IProfileSmsViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.view.ProfileSmsFragment$onCreateView$$inlined$instance$1
        }), null);
        this.e = iProfileSmsViewModel;
        if (iProfileSmsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        profileSmsFragmentSravniBinding.setViewModel(iProfileSmsViewModel);
        profileSmsFragmentSravniBinding.setLifecycleOwner(getViewLifecycleOwner());
        View root = profileSmsFragmentSravniBinding.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root, "binding.root");
        setupActionBar(root, true);
        IProfileSmsViewModel iProfileSmsViewModel2 = this.e;
        if (iProfileSmsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        iProfileSmsViewModel2.getTimerState().observe(getViewLifecycleOwner(), new b(this));
        return profileSmsFragmentSravniBinding.getRoot();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
