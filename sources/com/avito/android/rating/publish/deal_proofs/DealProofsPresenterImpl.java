package com.avito.android.rating.publish.deal_proofs;

import a2.g.r.g;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.rating.publish.RatingPublishStep;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.deal_proofs.DealProofsPresenter;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b4\u00105J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\fJ!\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenterImpl;", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter;", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsView;", "view", "", "attachView", "(Lcom/avito/android/rating/publish/deal_proofs/DealProofsView;)V", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "isLoading", "handleLoading", "(Z)V", "updateButton", "", "selectedPhotoId", "", "currentPhotoCount", "processPhotoPickerStep", "(Ljava/lang/String;I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter$Router;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/photo_view/ImageListPresenter;", "e", "Lcom/avito/android/photo_view/ImageListPresenter;", "imageListPresenter", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/publish/deal_proofs/DealProofsView;", "Lcom/avito/android/ratings/RatingPublishData;", "f", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/rating/publish/RatingPublishViewData;", g.a, "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "Lcom/avito/android/rating/publish/StepListener;", "d", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "<init>", "(Lcom/avito/android/rating/publish/StepListener;Lcom/avito/android/photo_view/ImageListPresenter;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class DealProofsPresenterImpl implements DealProofsPresenter {
    public DealProofsView a;
    public DealProofsPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final StepListener d;
    public final ImageListPresenter e;
    public final RatingPublishData f;
    public final RatingPublishViewData g;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                DealProofsPresenter.Router router = ((DealProofsPresenterImpl) this.b).b;
                if (router != null) {
                    router.onBackPressed();
                }
            } else if (i == 1) {
                DealProofsPresenter.Router router2 = ((DealProofsPresenterImpl) this.b).b;
                if (router2 != null) {
                    router2.showHelpDialog();
                }
            } else if (i == 2) {
                ((DealProofsPresenterImpl) this.b).d.onStepDataProvided(((DealProofsPresenterImpl) this.b).f, ((DealProofsPresenterImpl) this.b).g, true);
            } else if (i == 3) {
                ((DealProofsPresenterImpl) this.b).e.addNewPhoto();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Integer> {
        public final /* synthetic */ DealProofsPresenterImpl a;
        public final /* synthetic */ DealProofsView b;

        public b(DealProofsPresenterImpl dealProofsPresenterImpl, DealProofsView dealProofsView) {
            this.a = dealProofsPresenterImpl;
            this.b = dealProofsView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            boolean z = false;
            this.b.setContentMode(num2 != null && num2.intValue() == 0);
            if (Intrinsics.areEqual(RatingPublishStep.REG_VEHICLE.getStepId(), this.a.f.getStepId())) {
                DealProofsView dealProofsView = this.b;
                if (num2.intValue() > 0 && num2.intValue() == this.a.e.getCurrentPhotoCount()) {
                    z = true;
                }
                dealProofsView.setButtonEnabled(z);
            }
            this.a.updateButton();
        }
    }

    @Inject
    public DealProofsPresenterImpl(@NotNull StepListener stepListener, @NotNull ImageListPresenter imageListPresenter, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData) {
        Intrinsics.checkNotNullParameter(stepListener, "stepListener");
        Intrinsics.checkNotNullParameter(imageListPresenter, "imageListPresenter");
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        this.d = stepListener;
        this.e = imageListPresenter;
        this.f = ratingPublishData;
        this.g = ratingPublishViewData;
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter
    public void attachRouter(@NotNull DealProofsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter
    public void attachView(@NotNull DealProofsView dealProofsView) {
        DealProofsView dealProofsView2;
        Intrinsics.checkNotNullParameter(dealProofsView, "view");
        this.a = dealProofsView;
        ImageListPresenter imageListPresenter = this.e;
        RatingPublishStep ratingPublishStep = RatingPublishStep.IMAGES;
        imageListPresenter.setMaxImageCount(Intrinsics.areEqual(ratingPublishStep.getStepId(), this.f.getStepId()) ? 20 : 5);
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = dealProofsView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…onBackPressed()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = dealProofsView.infoClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.infoClicks().subscr…howHelpDialog()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.c;
        Disposable subscribe3 = dealProofsView.buttonClicks().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.buttonClicks().subs…e\n            )\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.c;
        Disposable subscribe4 = dealProofsView.addPhotoClicks().subscribe(new a(3, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.addPhotoClicks().su…r.addNewPhoto()\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.c;
        Disposable subscribe5 = InteropKt.toV3(this.e.photoCountChanges()).subscribe(new b(this, dealProofsView));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "imageListPresenter.photo…ateButton()\n            }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        String stepId = this.f.getStepId();
        if (Intrinsics.areEqual(stepId, ratingPublishStep.getStepId())) {
            DealProofsView dealProofsView3 = this.a;
            if (dealProofsView3 != null) {
                dealProofsView3.setUploadImagesTexts();
            }
        } else if (Intrinsics.areEqual(stepId, RatingPublishStep.DEAL_PROOF.getStepId())) {
            DealProofsView dealProofsView4 = this.a;
            if (dealProofsView4 != null) {
                dealProofsView4.setDealProofsTexts();
            }
        } else if (Intrinsics.areEqual(stepId, RatingPublishStep.REG_VEHICLE.getStepId()) && (dealProofsView2 = this.a) != null) {
            dealProofsView2.setAutoDealProofsTexts();
        }
        DealProofsView dealProofsView5 = this.a;
        if (dealProofsView5 != null) {
            dealProofsView5.showInfoLinkVisible(Intrinsics.areEqual(RatingPublishStep.DEAL_PROOF.getStepId(), this.f.getStepId()));
        }
        updateButton();
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter
    public void detachView() {
        this.c.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter
    public void handleLoading(boolean z) {
        DealProofsView dealProofsView = this.a;
        if (dealProofsView != null) {
            dealProofsView.showLoadingState(z);
        }
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle();
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter
    public void processPhotoPickerStep(@Nullable String str, int i) {
        if (Intrinsics.areEqual(RatingPublishStep.IMAGES.getStepId(), this.f.getStepId())) {
            DealProofsPresenter.Router router = this.b;
            if (router != null) {
                router.showPhotoPickerForImages(str);
                return;
            }
            return;
        }
        DealProofsPresenter.Router router2 = this.b;
        if (router2 != null) {
            router2.showPhotoPickerForFiles(str);
        }
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter
    public void updateButton() {
        if (this.e.getCurrentPhotoCount() != 0 || !(!Intrinsics.areEqual(RatingPublishStep.REG_VEHICLE.getStepId(), this.f.getStepId()))) {
            if (this.f.isLastStep()) {
                DealProofsView dealProofsView = this.a;
                if (dealProofsView != null) {
                    dealProofsView.showSendButton();
                    return;
                }
                return;
            }
            DealProofsView dealProofsView2 = this.a;
            if (dealProofsView2 != null) {
                dealProofsView2.showContinueButton();
            }
        } else if (this.f.isLastStep()) {
            DealProofsView dealProofsView3 = this.a;
            if (dealProofsView3 != null) {
                dealProofsView3.showSendNoPhotosButton();
            }
        } else {
            DealProofsView dealProofsView4 = this.a;
            if (dealProofsView4 != null) {
                dealProofsView4.showContinueNoPhotosButton();
            }
        }
    }
}
