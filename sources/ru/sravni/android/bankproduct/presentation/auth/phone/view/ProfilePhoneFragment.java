package ru.sravni.android.bankproduct.presentation.auth.phone.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
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
import ru.sravni.android.bankproduct.databinding.ProfilePhoneFragmentSravniBinding;
import ru.sravni.android.bankproduct.presentation.auth.phone.di.PresentationProfilePhoneProviderKt;
import ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.di.PresentationBottomNavigationProviderKt;
import ru.sravni.android.bankproduct.utils.CommonFragment;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/presentation/auth/phone/view/ProfilePhoneFragment;", "Lru/sravni/android/bankproduct/utils/CommonFragment;", "Lorg/kodein/di/Kodein$Module;", "initModule", "()Lorg/kodein/di/Kodein$Module;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onResume", "()V", "", "getFragmentModuleName", "()Ljava/lang/String;", "fragmentModuleName", "Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/IProfilePhoneViewModel;", "e", "Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/IProfilePhoneViewModel;", "viewModel", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfilePhoneFragment extends CommonFragment {
    public IProfilePhoneViewModel e;
    public HashMap f;

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
            Kodein.Builder.DefaultImpls.import$default(builder2, PresentationProfilePhoneProviderKt.getPresentationProfilePhoneKodeinModule(), false, 2, null);
            Kodein.Builder.DefaultImpls.import$default(builder2, PresentationBottomNavigationProviderKt.getPresentationBottomNavigationKodeinModule(), false, 2, null);
            return Unit.INSTANCE;
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public View _$_findCachedViewById(int i) {
        if (this.f == null) {
            this.f = new HashMap();
        }
        View view = (View) this.f.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.f.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    @Nullable
    public String getFragmentModuleName() {
        return "login";
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    @NotNull
    public Kodein.Module initModule() {
        return new Kodein.Module("ProfilePhoneFragmentModule", false, null, a.a, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.profile_phone_fragment_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…sravni, container, false)");
        ProfilePhoneFragmentSravniBinding profilePhoneFragmentSravniBinding = (ProfilePhoneFragmentSravniBinding) inflate;
        this.e = (IProfilePhoneViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IProfilePhoneViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.auth.phone.view.ProfilePhoneFragment$onCreateView$$inlined$instance$1
        }), null);
        profilePhoneFragmentSravniBinding.setLifecycleOwner(getViewLifecycleOwner());
        return profilePhoneFragmentSravniBinding.getRoot();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IProfilePhoneViewModel iProfilePhoneViewModel = this.e;
        if (iProfilePhoneViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        iProfilePhoneViewModel.fragmentStartAction();
    }
}
