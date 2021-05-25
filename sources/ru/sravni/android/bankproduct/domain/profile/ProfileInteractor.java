package ru.sravni.android.bankproduct.domain.profile;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.profile.entity.ProfileDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateAccountElementDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateFieldAccount;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDetailedInfoDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDocumentInfoDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileV2Domain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenRepository;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b/\u00100J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R6\u0010*\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020$ %*\n\u0012\u0004\u0012\u00020$\u0018\u00010#0#0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/ProfileInteractor;", "Lru/sravni/android/bankproduct/domain/profile/IProfileInteractor;", "", "documentID", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain;", "loadDocument", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain;", "getProfile", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain;", "getProfileDetailInfo", "", "refreshProfileData", "()V", "Lru/sravni/android/bankproduct/domain/profile/entity/UpdateAccountElementDomain;", "updateAccountElementDomain", "Lru/sravni/android/bankproduct/domain/profile/entity/UpdateFieldAccount;", "updateFieldAccount", "(Lru/sravni/android/bankproduct/domain/profile/entity/UpdateAccountElementDomain;)Lio/reactivex/Observable;", "logout", "Lio/reactivex/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/Disposable;", "profileDataSubscription", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/token/ITokenRepository;", "d", "Lru/sravni/android/bankproduct/domain/token/ITokenRepository;", "tokenRepository", "Lio/reactivex/subjects/BehaviorSubject;", "Lru/sravni/android/bankproduct/domain/DataContainer;", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDomain;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lio/reactivex/subjects/BehaviorSubject;", "getProfileDataChannel", "()Lio/reactivex/subjects/BehaviorSubject;", "profileDataChannel", "Lru/sravni/android/bankproduct/domain/profile/IProfileRepository;", "c", "Lru/sravni/android/bankproduct/domain/profile/IProfileRepository;", "profileRepository", "<init>", "(Lru/sravni/android/bankproduct/domain/profile/IProfileRepository;Lru/sravni/android/bankproduct/domain/token/ITokenRepository;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileInteractor implements IProfileInteractor {
    @NotNull
    public final BehaviorSubject<DataContainer<ProfileDomain>> a;
    public Disposable b;
    public final IProfileRepository c;
    public final ITokenRepository d;
    public final IThrowableWrapper e;

    public static final class a<T> implements Consumer<ProfileDomain> {
        public final /* synthetic */ ProfileInteractor a;

        public a(ProfileInteractor profileInteractor) {
            this.a = profileInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ProfileDomain profileDomain) {
            this.a.getProfileDataChannel().onNext(new DataContainer<>(profileDomain, null));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileInteractor a;

        public b(ProfileInteractor profileInteractor) {
            this.a = profileInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getProfileDataChannel().onNext(new DataContainer<>(null, this.a.e.wrap(th)));
        }
    }

    public ProfileInteractor(@NotNull IProfileRepository iProfileRepository, @NotNull ITokenRepository iTokenRepository, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iProfileRepository, "profileRepository");
        Intrinsics.checkParameterIsNotNull(iTokenRepository, "tokenRepository");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.c = iProfileRepository;
        this.d = iTokenRepository;
        this.e = iThrowableWrapper;
        BehaviorSubject<DataContainer<ProfileDomain>> create = BehaviorSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "BehaviorSubject.create<D…ntainer<ProfileDomain>>()");
        this.a = create;
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileInteractor
    @NotNull
    public Observable<ProfileV2Domain> getProfile() {
        return this.c.getAccountBrief();
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileInteractor
    @NotNull
    public Observable<ProfileDetailedInfoDomain> getProfileDetailInfo() {
        return this.c.getAccountDetailInfo();
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileInteractor
    @NotNull
    public Observable<ProfileDocumentInfoDomain> loadDocument(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "documentID");
        return this.c.getAccountDocument(str);
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileInteractor
    public void logout() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d.clear();
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileInteractor
    public void refreshProfileData() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = this.c.getAccountInfo().subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).subscribe(new a(this), new b(this));
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileInteractor
    @NotNull
    public Observable<UpdateFieldAccount> updateFieldAccount(@NotNull UpdateAccountElementDomain updateAccountElementDomain) {
        Intrinsics.checkParameterIsNotNull(updateAccountElementDomain, "updateAccountElementDomain");
        return this.c.updateFieldAccount(updateAccountElementDomain);
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileInteractor
    @NotNull
    public BehaviorSubject<DataContainer<ProfileDomain>> getProfileDataChannel() {
        return this.a;
    }
}
