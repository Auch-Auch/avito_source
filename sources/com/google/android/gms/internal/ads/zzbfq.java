package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;
@VisibleForTesting
@ParametersAreNonnullByDefault
public interface zzbfq extends zzk, zzajk, zzakh, zzbde, zzbgs, zzbgt, zzbgw, zzbha, zzbhb, zzbhd, zzqu {
    void destroy();

    @Override // com.google.android.gms.internal.ads.zzbde, com.google.android.gms.internal.ads.zzbgt
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    @Override // com.google.android.gms.internal.ads.zzbhd
    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzbde
    void setBackgroundColor(int i);

    @Override // com.google.android.gms.internal.ads.zzbfq
    void setOnClickListener(View.OnClickListener onClickListener);

    @Override // com.google.android.gms.internal.ads.zzbfq
    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(ViewGroup viewGroup, Activity activity, String str, String str2);

    void zza(zzc zzc);

    void zza(zzadf zzadf);

    void zza(zzadk zzadk);

    @Override // com.google.android.gms.internal.ads.zzbde
    void zza(zzbgk zzbgk);

    void zza(zzbhj zzbhj);

    void zza(zzsc zzsc);

    void zza(String str, Predicate<zzahf<? super zzbfq>> predicate);

    void zza(String str, zzahf<? super zzbfq> zzahf);

    @Override // com.google.android.gms.internal.ads.zzbde
    void zza(String str, zzbev zzbev);

    void zzaax();

    void zzaay();

    Context zzaaz();

    zzc zzaba();

    zzc zzabb();

    @Override // com.google.android.gms.internal.ads.zzbgy
    zzbhj zzabc();

    String zzabd();

    @Nullable
    zzbhc zzabe();

    WebViewClient zzabf();

    boolean zzabg();

    @Override // com.google.android.gms.internal.ads.zzbhb
    zzeg zzabh();

    @Nullable
    IObjectWrapper zzabi();

    @Override // com.google.android.gms.internal.ads.zzbgs
    boolean zzabj();

    void zzabk();

    boolean zzabl();

    boolean zzabm();

    void zzabn();

    void zzabo();

    zzadk zzabp();

    void zzabq();

    void zzabr();

    zzsc zzabs();

    boolean zzabt();

    zzsq zzabu();

    boolean zzabv();

    void zzal(boolean z);

    void zzap(IObjectWrapper iObjectWrapper);

    void zzax(boolean z);

    void zzay(boolean z);

    void zzaz(boolean z);

    void zzb(zzc zzc);

    void zzb(String str, zzahf<? super zzbfq> zzahf);

    void zzb(String str, String str2, @Nullable String str3);

    boolean zzb(boolean z, int i);

    void zzba(boolean z);

    void zzbv(Context context);

    void zzdu(int i);

    void zzuv();

    @Override // com.google.android.gms.internal.ads.zzbde
    @Nullable
    zzbgk zzzo();

    @Override // com.google.android.gms.internal.ads.zzbde, com.google.android.gms.internal.ads.zzbgt
    Activity zzzq();

    @Override // com.google.android.gms.internal.ads.zzbde
    zzb zzzr();

    @Override // com.google.android.gms.internal.ads.zzbde
    zzabh zzzs();

    @Override // com.google.android.gms.internal.ads.zzbde, com.google.android.gms.internal.ads.zzbha
    zzbbg zzzt();
}
