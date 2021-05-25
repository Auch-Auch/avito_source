package com.avito.android.profile.header;

import com.avito.android.analytics.Analytics;
import com.avito.android.profile.cards.UserProfileResourceProvider;
import com.avito.android.profile.header.ProfileHeaderPresenter;
import com.avito.android.remote.model.Action;
import com.avito.android.ui_components.R;
import com.avito.android.util.ActionMenu;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/avito/android/profile/header/DefaultProfileHeaderPresenter;", "Lcom/avito/android/profile/header/ProfileHeaderPresenter;", "", "Lcom/avito/android/remote/model/Action;", "actions", "", "sharingEnabled", "Lcom/avito/android/util/ActionMenu;", "createMenuActions", "(Ljava/util/List;Z)Ljava/util/List;", "action", "", "handleMenuActionClick", "(Lcom/avito/android/util/ActionMenu;)V", "Lru/avito/component/appbar/AppBar;", "view", "onViewAttached", "(Lru/avito/component/appbar/AppBar;)V", "onViewDetached", "()V", "onResume", "Lio/reactivex/rxjava3/disposables/Disposable;", "j", "Lio/reactivex/rxjava3/disposables/Disposable;", "homeClicksDisposable", "Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "resourceProvider", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/profile/cards/UserProfileResourceProvider;Lcom/avito/android/analytics/Analytics;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultProfileHeaderPresenter extends ProfileHeaderPresenter {
    public Disposable j;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ DefaultProfileHeaderPresenter a;

        public a(DefaultProfileHeaderPresenter defaultProfileHeaderPresenter) {
            this.a = defaultProfileHeaderPresenter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            ProfileHeaderPresenter.Router router = this.a.getRouter();
            if (router != null) {
                router.onBackPressed();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public DefaultProfileHeaderPresenter(@NotNull UserProfileResourceProvider userProfileResourceProvider, @NotNull Analytics analytics) {
        super(userProfileResourceProvider, analytics);
        Intrinsics.checkNotNullParameter(userProfileResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    @NotNull
    public List<ActionMenu> createMenuActions(@NotNull List<Action> list, boolean z) {
        ArrayList i0 = a2.b.a.a.a.i0(list, "actions");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(convertActionToMenuAction(it.next()));
        }
        i0.addAll(arrayList);
        if (z) {
            i0.add(getShareMenuAction());
        }
        return i0;
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    public void handleMenuActionClick(@NotNull ActionMenu actionMenu) {
        Intrinsics.checkNotNullParameter(actionMenu, "action");
        if (Intrinsics.areEqual(actionMenu, getShareMenuAction())) {
            onShareActionClicked();
        }
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    public void onResume() {
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    public void onViewAttached(@NotNull AppBar appBar) {
        Intrinsics.checkNotNullParameter(appBar, "view");
        AppBar.DefaultImpls.setNavigationIcon$default(appBar, R.drawable.ic_back_24, null, 2, null);
        this.j = appBar.navigationCallbacks().subscribe(new a(this));
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter
    public void onViewDetached() {
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
