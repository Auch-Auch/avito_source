package com.avito.android.advert.item.note;

import a2.g.r.g;
import com.avito.android.advert.item.note.AdvertDetailsNotePresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.util.SchedulersFactory3;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010(\u001a\u00020%¢\u0006\u0004\b1\u00102J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u000eJ\u0019\u0010\u001d\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001bR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenterImpl;", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;", "Lcom/avito/android/advert/item/note/AdvertDetailsNoteView;", "view", "Lcom/avito/android/advert/item/note/AdvertDetailsNoteItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/note/AdvertDetailsNoteView;Lcom/avito/android/advert/item/note/AdvertDetailsNoteItem;I)V", "attachView", "(Lcom/avito/android/advert/item/note/AdvertDetailsNoteView;)V", "detachView", "()V", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter$Router;)V", "detachRouter", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "onAdvertLoaded", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "", VKAttachments.TYPE_NOTE, "updateNote", "(Ljava/lang/String;)V", "updateCurrentNote", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "f", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", g.a, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "e", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter$Router;", "d", "Lcom/avito/android/advert/item/note/AdvertDetailsNoteItem;", "c", "Lcom/avito/android/advert/item/note/AdvertDetailsNoteView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/AdvertDetails;", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsNotePresenterImpl implements AdvertDetailsNotePresenter {
    public Disposable a;
    public AdvertDetails b;
    public AdvertDetailsNoteView c;
    public AdvertDetailsNoteItem d;
    public AdvertDetailsNotePresenter.Router e;
    public final SchedulersFactory3 f;
    public final AdvertDetailsAnalyticsInteractor g;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ AdvertDetailsNotePresenterImpl a;

        public a(AdvertDetailsNotePresenterImpl advertDetailsNotePresenterImpl) {
            this.a = advertDetailsNotePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.g.sendClickNote(AdvertDetailsNotePresenterImpl.access$getAdvert$p(this.a));
            AdvertDetailsNotePresenter.Router router = this.a.e;
            if (router != null) {
                router.editNoteClick(AdvertDetailsNotePresenterImpl.access$getAdvert$p(this.a));
            }
        }
    }

    @Inject
    public AdvertDetailsNotePresenterImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        this.f = schedulersFactory3;
        this.g = advertDetailsAnalyticsInteractor;
    }

    public static final /* synthetic */ AdvertDetails access$getAdvert$p(AdvertDetailsNotePresenterImpl advertDetailsNotePresenterImpl) {
        AdvertDetails advertDetails = advertDetailsNotePresenterImpl.b;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        return advertDetails;
    }

    public final void a(String str) {
        if (str == null || str.length() == 0) {
            AdvertDetailsNoteView advertDetailsNoteView = this.c;
            if (advertDetailsNoteView != null) {
                advertDetailsNoteView.setContentVisible(false);
                return;
            }
            return;
        }
        AdvertDetailsNoteView advertDetailsNoteView2 = this.c;
        if (advertDetailsNoteView2 != null) {
            advertDetailsNoteView2.setContentVisible(true);
        }
        AdvertDetailsNoteView advertDetailsNoteView3 = this.c;
        if (advertDetailsNoteView3 != null) {
            advertDetailsNoteView3.updateNote(str);
        }
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNotePresenter
    public void attachRouter(@NotNull AdvertDetailsNotePresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.e = router;
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNotePresenter
    public void attachView(@NotNull AdvertDetailsNoteView advertDetailsNoteView) {
        Intrinsics.checkNotNullParameter(advertDetailsNoteView, "view");
        this.c = advertDetailsNoteView;
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = advertDetailsNoteView.getEditNoteButtonClick().observeOn(this.f.mainThread()).subscribe(new a(this));
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNotePresenter
    public void detachRouter() {
        this.e = null;
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNotePresenter
    public void detachView() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = null;
        this.c = null;
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNotePresenter
    public void onAdvertLoaded(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.b = advertDetails;
        a(advertDetails.getNote());
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNotePresenter
    public void updateCurrentNote() {
        AdvertDetails advertDetails = this.b;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        a(advertDetails.getNote());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008d, code lost:
        if ((r7 == null || r7.length() == 0) != false) goto L_0x0091;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00d1  */
    @Override // com.avito.android.advert.item.note.AdvertDetailsNotePresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateNote(@org.jetbrains.annotations.Nullable java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 216
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.note.AdvertDetailsNotePresenterImpl.updateNote(java.lang.String):void");
    }

    public void bindView(@NotNull AdvertDetailsNoteView advertDetailsNoteView, @NotNull AdvertDetailsNoteItem advertDetailsNoteItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsNoteView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsNoteItem, "item");
        this.d = advertDetailsNoteItem;
        attachView(advertDetailsNoteView);
        updateCurrentNote();
    }
}
