package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
public abstract class WebviewDialogFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final ImageView imgClose;
    @NonNull
    public final WebView webView;

    public WebviewDialogFragmentSravniBinding(Object obj, View view, int i, ImageView imageView, WebView webView2) {
        super(obj, view, i);
        this.imgClose = imageView;
        this.webView = webView2;
    }

    public static WebviewDialogFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WebviewDialogFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WebviewDialogFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (WebviewDialogFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.webview_dialog_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static WebviewDialogFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (WebviewDialogFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.webview_dialog_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static WebviewDialogFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WebviewDialogFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (WebviewDialogFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.webview_dialog_fragment_sravni, null, false, obj);
    }
}
