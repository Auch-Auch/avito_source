package com.avito.android.authorization.select_profile.adapter.profile;

import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/profile/ProfileItemPresenterImpl;", "Lcom/avito/android/authorization/select_profile/adapter/profile/ProfileItemPresenter;", "Lcom/avito/android/authorization/select_profile/adapter/profile/ProfileItemView;", "view", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$Profile;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/authorization/select_profile/adapter/profile/ProfileItemView;Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$Profile;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clickConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileItemPresenterImpl implements ProfileItemPresenter {
    public final Consumer<SelectProfileField> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ ProfileItemPresenterImpl a;
        public final /* synthetic */ SelectProfileField.Profile b;

        public a(ProfileItemPresenterImpl profileItemPresenterImpl, SelectProfileField.Profile profile) {
            this.a = profileItemPresenterImpl;
            this.b = profile;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(this.b);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ProfileItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ProfileItemView profileItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = profileItemView;
            this.b = compositeDisposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.clear();
            return Unit.INSTANCE;
        }
    }

    public ProfileItemPresenterImpl(@NotNull Consumer<SelectProfileField> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clickConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull ProfileItemView profileItemView, @NotNull SelectProfileField.Profile profile, int i) {
        Intrinsics.checkNotNullParameter(profileItemView, "view");
        Intrinsics.checkNotNullParameter(profile, "item");
        profileItemView.setTitle(profile.getProfile().getName());
        String description = profile.getProfile().getDescription();
        if (description == null) {
            description = profile.getProfile().getLogin();
        }
        profileItemView.setSubtitle(description);
        profileItemView.setAvatar(profile.getProfile().getAvatar());
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        profileItemView.setUnbindListener(new b(profileItemView, compositeDisposable));
        Disposable subscribe = profileItemView.clicks().subscribe(new a(this, profile));
        Intrinsics.checkNotNullExpressionValue(subscribe, "clicks().subscribe {\n   …ccept(item)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
