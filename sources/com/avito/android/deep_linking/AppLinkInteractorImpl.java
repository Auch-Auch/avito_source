package com.avito.android.deep_linking;

import a2.b.a.a.a;
import com.avito.android.deep_linking.remote.AppLink;
import com.avito.android.deep_linking.remote.DeeplinkApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/deep_linking/AppLinkInteractorImpl;", "Lcom/avito/android/deep_linking/AppLinkInteractor;", "", "url", "referrerUrl", "Lio/reactivex/Observable;", "Lcom/avito/android/deep_linking/remote/AppLink;", "getAppLink", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/deep_linking/remote/DeeplinkApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/remote/DeeplinkApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/android/deep_linking/remote/DeeplinkApi;Lcom/avito/android/util/SchedulersFactory;)V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class AppLinkInteractorImpl implements AppLinkInteractor {
    public final DeeplinkApi a;
    public final SchedulersFactory b;

    @Inject
    public AppLinkInteractorImpl(@NotNull DeeplinkApi deeplinkApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(deeplinkApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = deeplinkApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.deep_linking.AppLinkInteractor
    @NotNull
    public Observable<AppLink> getAppLink(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        return a.S1(this.b, TypedObservablesKt.toTyped(InteropKt.toV2(this.a.getAppLink(str, str2))), "api.getAppLink(url, refe…n(schedulersFactory.io())");
    }
}
