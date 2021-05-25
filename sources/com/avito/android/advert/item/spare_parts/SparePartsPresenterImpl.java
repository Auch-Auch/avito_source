package com.avito.android.advert.item.spare_parts;

import a2.a.a.f.x.c0.a;
import a2.a.a.f.x.c0.b;
import a2.g.r.g;
import com.avito.android.advert.item.spare_parts.SparePartsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.SparePartsParameters;
import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.spare_parts.SparePartsFormatter;
import com.avito.android.spare_parts.SparePartsItemClickListener;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u00104\u001a\u000201\u0012\b\u0010>\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b?\u0010@J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010(R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010\u001eRD\u0010=\u001a0\u0012\f\u0012\n 9*\u0004\u0018\u00010808 9*\u0017\u0012\f\u0012\n 9*\u0004\u0018\u00010808\u0018\u000107¢\u0006\u0002\b:07¢\u0006\u0002\b:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/SparePartsPresenterImpl;", "Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;", "Lcom/avito/android/advert/item/spare_parts/SparePartsView;", "view", "Lcom/avito/android/advert/item/spare_parts/SparePartsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/spare_parts/SparePartsView;Lcom/avito/android/advert/item/spare_parts/SparePartsItem;I)V", "Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter$Router;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "detach", "()V", "Lcom/avito/android/remote/models/SparePartsResponse;", CommonKt.EXTRA_RESPONSE, AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/models/SparePartsResponse;)V", "Lcom/avito/android/util/SchedulersFactory3;", "j", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lio/reactivex/rxjava3/disposables/Disposable;", "c", "Lio/reactivex/rxjava3/disposables/Disposable;", "loadingDisposable", "", "e", "Z", "hasLoadingError", "Lcom/avito/android/advert/item/spare_parts/SparePartsInteractor;", "h", "Lcom/avito/android/advert/item/spare_parts/SparePartsInteractor;", "interactor", "Lcom/avito/android/advert/item/spare_parts/SparePartsView;", "d", "Lcom/avito/android/remote/models/SparePartsResponse;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter$Router;", "Lcom/avito/android/spare_parts/SparePartsFormatter;", "i", "Lcom/avito/android/spare_parts/SparePartsFormatter;", "formatter", "Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;", "k", "Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;", "type", g.a, "clicksDisposable", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "f", "Lcom/jakewharton/rxrelay3/PublishRelay;", "clicksRelay", "state", "<init>", "(Lcom/avito/android/advert/item/spare_parts/SparePartsInteractor;Lcom/avito/android/spare_parts/SparePartsFormatter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;Lcom/avito/android/util/Kundle;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsPresenterImpl implements SparePartsPresenter {
    public SparePartsView a;
    public SparePartsPresenter.Router b;
    public Disposable c;
    public SparePartsResponse d;
    public boolean e;
    public final PublishRelay<SparePartsResponse.SparePartsGroup> f = PublishRelay.create();
    public Disposable g;
    public final SparePartsInteractor h;
    public final SparePartsFormatter i;
    public final SchedulersFactory3 j;
    public final SparePartsItemType k;

    @Inject
    public SparePartsPresenterImpl(@NotNull SparePartsInteractor sparePartsInteractor, @NotNull SparePartsFormatter sparePartsFormatter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SparePartsItemType sparePartsItemType, @Nullable Kundle kundle) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(sparePartsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(sparePartsFormatter, "formatter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(sparePartsItemType, "type");
        this.h = sparePartsInteractor;
        this.i = sparePartsFormatter;
        this.j = schedulersFactory3;
        this.k = sparePartsItemType;
        this.d = kundle != null ? (SparePartsResponse) kundle.getParcelable("saved_state_response") : null;
        this.e = (kundle == null || (bool = kundle.getBoolean("saved_state_error")) == null) ? false : bool.booleanValue();
    }

    public final void a(SparePartsResponse sparePartsResponse) {
        List<SparePartsResponse.Specification> specifications;
        List<SparePartsResponse.SparePartsGroup> groups = sparePartsResponse.getGroups();
        boolean z = true;
        if ((groups == null || !(!groups.isEmpty())) && ((specifications = sparePartsResponse.getSpecifications()) == null || !(!specifications.isEmpty()))) {
            SparePartsView sparePartsView = this.a;
            if (sparePartsView != null) {
                sparePartsView.hide();
                return;
            }
            return;
        }
        SparePartsView sparePartsView2 = this.a;
        if (sparePartsView2 != null) {
            sparePartsView2.showContent();
            sparePartsView2.setTitle(sparePartsResponse.getHeader());
            sparePartsView2.setSubtitle(sparePartsResponse.getSubheader());
        }
        SparePartsView sparePartsView3 = this.a;
        if (sparePartsView3 != null) {
            sparePartsView3.clearSpareParts();
            List<CharSequence> format = this.i.format(sparePartsView3.getContext(), sparePartsResponse.getGroups(), sparePartsResponse.getSpecifications(), new SparePartsItemClickListener() { // from class: com.avito.android.advert.item.spare_parts.SparePartsPresenterImpl$showSpareParts$itemClickListener$1
                @Override // com.avito.android.spare_parts.SparePartsItemClickListener
                public void onItemClicked(@NotNull SparePartsResponse.SparePartsGroup sparePartsGroup) {
                    Intrinsics.checkNotNullParameter(sparePartsGroup, Navigation.GROUP);
                    SparePartsPresenterImpl.this.f.accept(sparePartsGroup);
                }
            });
            if (format != null) {
                Disposable disposable = this.g;
                if (disposable != null) {
                    disposable.dispose();
                }
                this.g = this.f.throttleFirst(600, TimeUnit.MILLISECONDS).subscribe(new b(this));
                List<SparePartsResponse.SparePartsGroup> groups2 = sparePartsResponse.getGroups();
                if (groups2 != null && !groups2.isEmpty()) {
                    z = false;
                }
                sparePartsView3.addSpareParts(format, z);
            }
        }
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsPresenter
    public void attachRouter(@Nullable SparePartsPresenter.Router router) {
        this.b = router;
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsPresenter
    public void detach() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = null;
        Disposable disposable2 = this.g;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.g = null;
        this.a = null;
        this.b = null;
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable("saved_state_response", this.d);
        kundle.putBoolean("saved_state_error", Boolean.valueOf(this.e));
        return kundle;
    }

    public void bindView(@NotNull SparePartsView sparePartsView, @NotNull SparePartsItem sparePartsItem, int i2) {
        Intrinsics.checkNotNullParameter(sparePartsView, "view");
        Intrinsics.checkNotNullParameter(sparePartsItem, "item");
        this.a = sparePartsView;
        if (this.e) {
            sparePartsView.hide();
            return;
        }
        SparePartsParameters params = sparePartsItem.getParams();
        SparePartsResponse sparePartsResponse = this.d;
        if (sparePartsResponse != null) {
            a(sparePartsResponse);
            return;
        }
        Disposable disposable = this.c;
        if (!(disposable != null && !disposable.isDisposed())) {
            this.c = this.h.loadSpareParts(this.k, params).subscribeOn(this.j.io()).observeOn(this.j.mainThread()).doOnNext(new a(this)).subscribe();
        }
    }
}
