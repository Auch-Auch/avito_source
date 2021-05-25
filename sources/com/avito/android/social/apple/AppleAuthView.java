package com.avito.android.social.apple;

import com.avito.android.remote.model.Navigation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rR$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/social/apple/AppleAuthView;", "", "", "url", "Lcom/avito/android/social/apple/AppleAuthRequestConfig;", Navigation.CONFIG, "", "loadUrl", "(Ljava/lang/String;Lcom/avito/android/social/apple/AppleAuthRequestConfig;)V", "Lkotlin/Function1;", "Lcom/avito/android/social/apple/AppleAuthResult;", "callback", "setAuthCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "getCloseAction", "()Lkotlin/jvm/functions/Function0;", "setCloseAction", "(Lkotlin/jvm/functions/Function0;)V", "closeAction", "getRefreshAction", "setRefreshAction", "refreshAction", "social_release"}, k = 1, mv = {1, 4, 2})
public interface AppleAuthView {
    @Nullable
    Function0<Unit> getCloseAction();

    @Nullable
    Function0<Unit> getRefreshAction();

    void loadUrl(@NotNull String str, @NotNull AppleAuthRequestConfig appleAuthRequestConfig);

    void setAuthCallback(@Nullable Function1<? super AppleAuthResult, Unit> function1);

    void setCloseAction(@Nullable Function0<Unit> function0);

    void setRefreshAction(@Nullable Function0<Unit> function0);
}
