package com.avito.android.social.apple;

import android.view.View;
import com.avito.android.remote.model.Navigation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R*\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/social/apple/AppleAuthWebViewClient;", "", "Landroid/view/View;", "getProgressView", "()Landroid/view/View;", "setProgressView", "(Landroid/view/View;)V", "progressView", "Lkotlin/Function1;", "Lcom/avito/android/social/apple/AppleAuthResult;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "callback", "Lcom/avito/android/social/apple/AppleAuthRequestConfig;", "getConfig", "()Lcom/avito/android/social/apple/AppleAuthRequestConfig;", "setConfig", "(Lcom/avito/android/social/apple/AppleAuthRequestConfig;)V", Navigation.CONFIG, "social_release"}, k = 1, mv = {1, 4, 2})
public interface AppleAuthWebViewClient {
    @Nullable
    Function1<AppleAuthResult, Unit> getCallback();

    @Nullable
    AppleAuthRequestConfig getConfig();

    @Nullable
    View getProgressView();

    void setCallback(@Nullable Function1<? super AppleAuthResult, Unit> function1);

    void setConfig(@Nullable AppleAuthRequestConfig appleAuthRequestConfig);

    void setProgressView(@Nullable View view);
}
