package ru.sravni.android.bankproduct.utils.avatar;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/utils/avatar/AvatarViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/avatar/IAvatarViewModel;", "", "changeAvatar", "()V", "", "getCurrentAvatarRes", "()Ljava/lang/Integer;", "onCleared", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "f", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "getAvatarImageSource", "()Landroidx/lifecycle/MutableLiveData;", "avatarImageSource", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "subscription", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", g.a, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/dashboard/IDashBoardInteractor;", "e", "Lru/sravni/android/bankproduct/domain/dashboard/IDashBoardInteractor;", "dashBoardInteractor", "<init>", "(Lru/sravni/android/bankproduct/domain/dashboard/IDashBoardInteractor;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AvatarViewModel extends ViewModel implements IAvatarViewModel {
    public Disposable c;
    @NotNull
    public final MutableLiveData<Integer> d = new MutableLiveData<>();
    public final IDashBoardInteractor e;
    public final IErrorLogger f;
    public final IThrowableWrapper g;

    public static final class a<T> implements Consumer<Integer> {
        public final /* synthetic */ AvatarViewModel a;

        public a(AvatarViewModel avatarViewModel) {
            this.a = avatarViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            this.a.getAvatarImageSource().setValue(num);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ AvatarViewModel a;

        public b(AvatarViewModel avatarViewModel) {
            this.a = avatarViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.f.logError(MessagePriority.ERROR, this.a.g.wrap(th));
        }
    }

    public AvatarViewModel(@NotNull IDashBoardInteractor iDashBoardInteractor, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iDashBoardInteractor, "dashBoardInteractor");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.e = iDashBoardInteractor;
        this.f = iErrorLogger;
        this.g = iThrowableWrapper;
        this.c = iDashBoardInteractor.getFaceResource().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), new b(this));
    }

    @Override // ru.sravni.android.bankproduct.utils.avatar.IAvatarProvider
    public void changeAvatar() {
        this.e.nextFaceImage();
    }

    @Override // ru.sravni.android.bankproduct.utils.avatar.IAvatarProvider
    @Nullable
    public Integer getCurrentAvatarRes() {
        return getAvatarImageSource().getValue();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.avatar.IAvatarViewModel
    @NotNull
    public MutableLiveData<Integer> getAvatarImageSource() {
        return this.d;
    }
}
