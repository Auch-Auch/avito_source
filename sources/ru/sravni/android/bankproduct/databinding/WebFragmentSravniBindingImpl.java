package ru.sravni.android.bankproduct.databinding;

import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.presentation.webview.adapter.WebViewBidingAdapterKt;
import ru.sravni.android.bankproduct.presentation.webview.viewmodel.IWebViewViewModel;
import ru.sravni.android.bankproduct.utils.navigation.entity.WebViewNavInfo;
public class WebFragmentSravniBindingImpl extends WebFragmentSravniBinding {
    public long A = -1;
    @NonNull
    public final ConstraintLayout y;
    @NonNull
    public final ProgressBar z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WebFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r10, @androidx.annotation.NonNull android.view.View r11) {
        /*
            r9 = this;
            r0 = 4
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r0, r1, r1)
            r2 = 1
            r2 = r0[r2]
            r7 = r2
            androidx.appcompat.widget.Toolbar r7 = (androidx.appcompat.widget.Toolbar) r7
            r2 = 3
            r2 = r0[r2]
            r8 = r2
            android.webkit.WebView r8 = (android.webkit.WebView) r8
            r6 = 1
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = -1
            r9.A = r2
            r10 = 0
            r10 = r0[r10]
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            r9.y = r10
            r10.setTag(r1)
            r10 = 2
            r10 = r0[r10]
            android.widget.ProgressBar r10 = (android.widget.ProgressBar) r10
            r9.z = r10
            r10.setTag(r1)
            androidx.appcompat.widget.Toolbar r10 = r9.toolbar
            r10.setTag(r1)
            android.webkit.WebView r10 = r9.webView
            r10.setTag(r1)
            r9.setRootTag(r11)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.WebFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String str;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        IWebViewViewModel iWebViewViewModel = this.mWebViewModel;
        String str2 = null;
        int i2 = 0;
        int i3 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i3 != 0) {
            LiveData<Boolean> isWaiting = iWebViewViewModel != null ? iWebViewViewModel.isWaiting() : null;
            updateLiveDataRegistration(0, isWaiting);
            boolean safeUnbox = ViewDataBinding.safeUnbox(isWaiting != null ? isWaiting.getValue() : null);
            boolean z2 = safeUnbox;
            boolean z3 = !safeUnbox;
            if (i3 != 0) {
                j |= z2 ? 64 : 32;
            }
            if ((j & 7) != 0) {
                j |= z3 ? 16 : 8;
            }
            int i4 = z2 ? 0 : 8;
            if (!z3) {
                i2 = 8;
            }
            if ((j & 6) != 0) {
                WebViewNavInfo webViewDataInfo = iWebViewViewModel != null ? iWebViewViewModel.getWebViewDataInfo() : null;
                if (webViewDataInfo != null) {
                    String url = webViewDataInfo.getUrl();
                    i = i2;
                    i2 = i4;
                    str2 = webViewDataInfo.getTitle();
                    str = url;
                }
            }
            str = null;
            i = i2;
            i2 = i4;
        } else {
            str = null;
            i = 0;
        }
        if ((7 & j) != 0) {
            this.z.setVisibility(i2);
            this.webView.setVisibility(i);
        }
        if ((j & 6) != 0) {
            this.toolbar.setTitle(str2);
            WebViewBidingAdapterKt.setUrl(this.webView, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.A != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.A = 4;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        LiveData liveData = (LiveData) obj;
        return j(i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.webViewModel != i) {
            return false;
        }
        setWebViewModel((IWebViewViewModel) obj);
        return true;
    }

    @Override // ru.sravni.android.bankproduct.databinding.WebFragmentSravniBinding
    public void setWebViewModel(@Nullable IWebViewViewModel iWebViewViewModel) {
        this.mWebViewModel = iWebViewViewModel;
        synchronized (this) {
            this.A |= 2;
        }
        notifyPropertyChanged(BR.webViewModel);
        super.requestRebind();
    }
}
