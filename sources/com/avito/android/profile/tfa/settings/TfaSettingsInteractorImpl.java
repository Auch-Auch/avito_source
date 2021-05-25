package com.avito.android.profile.tfa.settings;

import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TfaSettingsResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/tfa/settings/TfaSettingsInteractorImpl;", "Lcom/avito/android/profile/tfa/settings/TfaSettingsInteractor;", "", "isEnabled", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/profile/tfa/settings/TfaSettingsData;", "setTfaEnabled", "(Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory3;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class TfaSettingsInteractorImpl implements TfaSettingsInteractor {
    public final ProfileApi a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<TfaSettingsResult, TfaSettingsData> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public TfaSettingsData apply(TfaSettingsResult tfaSettingsResult) {
            TfaSettingsResult tfaSettingsResult2 = tfaSettingsResult;
            return new TfaSettingsData(tfaSettingsResult2.isEnabled(), tfaSettingsResult2.getWarning());
        }
    }

    @Inject
    public TfaSettingsInteractorImpl(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = profileApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsInteractor
    @NotNull
    public Observable<TfaSettingsData> setTfaEnabled(boolean z) {
        return a2.b.a.a.a.a2(this.b, TypedObservablesKt.toTyped(this.a.setTfaEnabled(z)).map(a.a), "api.setTfaEnabled(isEnab…scribeOn(schedulers.io())");
    }
}
