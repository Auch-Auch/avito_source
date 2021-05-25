package com.avito.android.social.esia;

import com.avito.android.remote.model.Navigation;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00178&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/social/esia/EsiaAuthView;", "", "", "url", "Lcom/avito/android/social/esia/EsiaAuthConfig;", Navigation.CONFIG, "", "loadUrl", "(Ljava/lang/String;Lcom/avito/android/social/esia/EsiaAuthConfig;)V", "Lkotlin/Function1;", "Lcom/avito/android/social/esia/EsiaAuthResult;", "callback", "setAuthCallback", "(Lkotlin/jvm/functions/Function1;)V", "", "canGoBack", "()Z", "goBack", "()V", "Lio/reactivex/rxjava3/core/Observable;", "getButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "buttonClicks", "Lkotlin/Function0;", "getRefreshAction", "()Lkotlin/jvm/functions/Function0;", "setRefreshAction", "(Lkotlin/jvm/functions/Function0;)V", "refreshAction", "social_release"}, k = 1, mv = {1, 4, 2})
public interface EsiaAuthView {
    boolean canGoBack();

    @NotNull
    Observable<Unit> getButtonClicks();

    @Nullable
    Function0<Unit> getRefreshAction();

    void goBack();

    void loadUrl(@NotNull String str, @NotNull EsiaAuthConfig esiaAuthConfig);

    void setAuthCallback(@Nullable Function1<? super EsiaAuthResult, Unit> function1);

    void setRefreshAction(@Nullable Function0<Unit> function0);
}
