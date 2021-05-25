package com.avito.android.authorization.login_suggests.adapter.suggest;

import com.avito.android.authorization.login_suggests.LoginSuggestsResourceProvider;
import com.avito.android.authorization.login_suggests.Suggest;
import com.avito.android.authorization.login_suggests.adapter.LoginSuggestsItem;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItemPresenterImpl;", "Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItemPresenter;", "Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItemView;", "view", "Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItemView;Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/authorization/login_suggests/adapter/LoginSuggestsItem;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "clicksConsumer", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProvider;", "resourceProvider", "<init>", "(Lio/reactivex/functions/Consumer;Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProvider;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestItemPresenterImpl implements SuggestItemPresenter {
    public final Consumer<LoginSuggestsItem> a;
    public final LoginSuggestsResourceProvider b;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ SuggestItemPresenterImpl a;
        public final /* synthetic */ SuggestItem b;

        public a(SuggestItemPresenterImpl suggestItemPresenterImpl, SuggestItem suggestItem) {
            this.a = suggestItemPresenterImpl;
            this.b = suggestItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: io.reactivex.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(this.b);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SuggestItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SuggestItemView suggestItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = suggestItemView;
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

    public SuggestItemPresenterImpl(@NotNull Consumer<LoginSuggestsItem> consumer, @NotNull LoginSuggestsResourceProvider loginSuggestsResourceProvider) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        Intrinsics.checkNotNullParameter(loginSuggestsResourceProvider, "resourceProvider");
        this.a = consumer;
        this.b = loginSuggestsResourceProvider;
    }

    public void bindView(@NotNull SuggestItemView suggestItemView, @NotNull SuggestItem suggestItem, int i) {
        String str;
        Intrinsics.checkNotNullParameter(suggestItemView, "view");
        Intrinsics.checkNotNullParameter(suggestItem, "item");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        suggestItemView.setUnbindListener(new b(suggestItemView, compositeDisposable));
        Disposable subscribe = suggestItemView.clicks().subscribe(new a(this, suggestItem));
        Intrinsics.checkNotNullExpressionValue(subscribe, "clicks().subscribe {\n   …ccept(item)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        suggestItemView.setName(suggestItem.getSuggest().getName());
        suggestItemView.setAvatar(suggestItem.getSuggest().getAvatar());
        Suggest suggest = suggestItem.getSuggest();
        if (suggest instanceof Suggest.Login) {
            suggestItemView.setHint(((Suggest.Login) suggestItem.getSuggest()).getLogin());
        } else if (suggest instanceof Suggest.Social) {
            Suggest.Social social = (Suggest.Social) suggestItem.getSuggest();
            LoginSuggestsResourceProvider loginSuggestsResourceProvider = this.b;
            String social2 = social.getSocial();
            int hashCode = social2.hashCode();
            if (hashCode == 3260) {
                if (social2.equals("fb")) {
                    str = loginSuggestsResourceProvider.facebookTitle();
                }
                StringBuilder L = a2.b.a.a.a.L("Social ");
                L.append(social.getSocial());
                L.append(" isn't supported");
                throw new IllegalArgumentException(L.toString());
            } else if (hashCode == 3305) {
                if (social2.equals("gp")) {
                    str = loginSuggestsResourceProvider.googleTitle();
                }
                StringBuilder L = a2.b.a.a.a.L("Social ");
                L.append(social.getSocial());
                L.append(" isn't supported");
                throw new IllegalArgumentException(L.toString());
            } else if (hashCode == 3548) {
                if (social2.equals("ok")) {
                    str = loginSuggestsResourceProvider.odnoklassnikiTitle();
                }
                StringBuilder L = a2.b.a.a.a.L("Social ");
                L.append(social.getSocial());
                L.append(" isn't supported");
                throw new IllegalArgumentException(L.toString());
            } else if (hashCode != 3765) {
                if (hashCode == 93029210 && social2.equals("apple")) {
                    str = loginSuggestsResourceProvider.appleTitle();
                }
                StringBuilder L = a2.b.a.a.a.L("Social ");
                L.append(social.getSocial());
                L.append(" isn't supported");
                throw new IllegalArgumentException(L.toString());
            } else {
                if (social2.equals("vk")) {
                    str = loginSuggestsResourceProvider.vkontakteTitle();
                }
                StringBuilder L = a2.b.a.a.a.L("Social ");
                L.append(social.getSocial());
                L.append(" isn't supported");
                throw new IllegalArgumentException(L.toString());
            }
            suggestItemView.setHint(str);
        }
    }
}
