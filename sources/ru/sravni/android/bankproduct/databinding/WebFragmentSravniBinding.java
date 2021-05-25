package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.webview.viewmodel.IWebViewViewModel;
public abstract class WebFragmentSravniBinding extends ViewDataBinding {
    @Bindable
    public IWebViewViewModel mWebViewModel;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final WebView webView;

    public WebFragmentSravniBinding(Object obj, View view, int i, Toolbar toolbar2, WebView webView2) {
        super(obj, view, i);
        this.toolbar = toolbar2;
        this.webView = webView2;
    }

    public static WebFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WebFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IWebViewViewModel getWebViewModel() {
        return this.mWebViewModel;
    }

    public abstract void setWebViewModel(@Nullable IWebViewViewModel iWebViewViewModel);

    @Deprecated
    public static WebFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (WebFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.web_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static WebFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (WebFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.web_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static WebFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WebFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (WebFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.web_fragment_sravni, null, false, obj);
    }
}
