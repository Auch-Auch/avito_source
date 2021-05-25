package ru.sravni.android.bankproduct.presentation.webview.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.WebFragmentSravniBinding;
import ru.sravni.android.bankproduct.presentation.webview.di.PresentationWebViewKodeinModuleKt;
import ru.sravni.android.bankproduct.presentation.webview.viewmodel.IWebViewViewModel;
import ru.sravni.android.bankproduct.utils.CommonFragment;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/presentation/webview/view/WebViewFragment;", "Lru/sravni/android/bankproduct/utils/CommonFragment;", "Lorg/kodein/di/Kodein$Module;", "initModule", "()Lorg/kodein/di/Kodein$Module;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class WebViewFragment extends CommonFragment {
    public HashMap e;

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public View _$_findCachedViewById(int i) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        View view = (View) this.e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    @NotNull
    public Kodein.Module initModule() {
        return PresentationWebViewKodeinModuleKt.getPresentationWebViewKodeinModule();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.web_fragment_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…sravni, container, false)");
        WebFragmentSravniBinding webFragmentSravniBinding = (WebFragmentSravniBinding) inflate;
        IWebViewViewModel iWebViewViewModel = (IWebViewViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IWebViewViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.webview.view.WebViewFragment$onCreateView$$inlined$instance$1
        }), null);
        iWebViewViewModel.setWaiting(true);
        WebViewFragment$onCreateView$webViewClient$1 webViewFragment$onCreateView$webViewClient$1 = new WebViewClient(iWebViewViewModel) { // from class: ru.sravni.android.bankproduct.presentation.webview.view.WebViewFragment$onCreateView$webViewClient$1
            public final /* synthetic */ IWebViewViewModel a;

            {
                this.a = r1;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
                this.a.setWaiting(false);
            }
        };
        WebView webView = webFragmentSravniBinding.webView;
        if (webView != null) {
            webView.setWebViewClient(webViewFragment$onCreateView$webViewClient$1);
        }
        webFragmentSravniBinding.setLifecycleOwner(getViewLifecycleOwner());
        webFragmentSravniBinding.setWebViewModel(iWebViewViewModel);
        View root = webFragmentSravniBinding.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root, "binding.root");
        setupActionBar(root, true);
        return webFragmentSravniBinding.getRoot();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
