package com.avito.android.photo_wizard;

import a2.g.r.g;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.photo_wizard.PhotoWizardViewState;
import com.avito.android.photo_wizard.analytics.FlowAction;
import com.avito.android.photo_wizard.analytics.PhotoWizardFinishClickEvent;
import com.avito.android.photo_wizard.analytics.PhotoWizardFlowActionClickEvent;
import com.avito.android.photo_wizard.converter.WizardStepsConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.VerificationStep;
import com.avito.android.util.SchedulersFactory3;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BE\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u0010I\u001a\u00020F\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020M0L\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010.\u001a\u00020+¢\u0006\u0004\bO\u0010PJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0019\u001a\u00020\u0018*\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u0018*\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u0003*\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010/R\"\u00105\u001a\b\u0012\u0004\u0012\u00020\u0018018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u00102\u001a\u0004\b3\u00104R\"\u00108\u001a\b\u0012\u0004\u0012\u00020#018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R\"\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020:098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010;R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00170=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010AR\u0016\u0010E\u001a\u00020C8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b6\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006Q"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/photo_wizard/PhotoWizardViewModel;", "Lcom/avito/android/photo_wizard/DocumentType;", "type", "", "onTypeClicked", "(Lcom/avito/android/photo_wizard/DocumentType;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "onPictureTaken", "(Landroid/net/Uri;)V", "onNextClicked", "()V", "onDoneClicked", "onCloseClicked", "onRetakeShotClicked", "onCleared", "d", "Lcom/avito/android/photo_wizard/analytics/FlowAction;", "flowAction", g.a, "(Lcom/avito/android/photo_wizard/analytics/FlowAction;)V", "Lcom/avito/android/photo_wizard/WizardStep;", "Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "h", "(Lcom/avito/android/photo_wizard/WizardStep;)Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "e", "(Lcom/avito/android/photo_wizard/WizardStep;Landroid/net/Uri;)Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "f", "(Lcom/avito/android/photo_wizard/WizardStep;)Lcom/avito/android/photo_wizard/DocumentType;", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "", "i", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;", "l", "Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;", "resourceProvider", "Lcom/avito/android/analytics/Analytics;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo_wizard/WizardStep;", "currentStep", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "getViewStateData", "()Landroidx/lifecycle/MutableLiveData;", "viewStateData", "c", "getTitleData", "titleData", "", "Lcom/avito/android/photo_wizard/TakenPicture;", "Ljava/util/Map;", "takenPictures", "", "Ljava/util/List;", "steps", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "uploadDisposable", "", "()I", "currentStepIndex", "Lcom/avito/android/photo_wizard/UploadPicturesInteractor;", "j", "Lcom/avito/android/photo_wizard/UploadPicturesInteractor;", "uploadPicturesInteractor", "Lcom/avito/android/photo_wizard/converter/WizardStepsConverter;", "stepsConverter", "", "Lcom/avito/android/remote/model/VerificationStep;", "verificationSteps", "<init>", "(Ljava/lang/String;Lcom/avito/android/photo_wizard/converter/WizardStepsConverter;Lcom/avito/android/photo_wizard/UploadPicturesInteractor;Ljava/util/List;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;Lcom/avito/android/analytics/Analytics;)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoWizardViewModelImpl extends ViewModel implements PhotoWizardViewModel {
    @NotNull
    public final MutableLiveData<String> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<PhotoWizardViewState> d = new MutableLiveData<>();
    public final List<WizardStep> e;
    public WizardStep f;
    public final Map<WizardStep, TakenPicture> g;
    public Disposable h;
    public final String i;
    public final UploadPicturesInteractor j;
    public final SchedulersFactory3 k;
    public final PhotoWizardResourceProvider l;
    public final Analytics m;

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ PhotoWizardViewModelImpl a;

        public a(PhotoWizardViewModelImpl photoWizardViewModelImpl) {
            this.a = photoWizardViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            PhotoWizardViewState photoWizardViewState;
            Boolean bool2 = bool;
            MutableLiveData<PhotoWizardViewState> viewStateData = this.a.getViewStateData();
            Intrinsics.checkNotNullExpressionValue(bool2, "success");
            if (bool2.booleanValue()) {
                photoWizardViewState = PhotoWizardViewState.ClosedWithResult.INSTANCE;
            } else {
                PhotoWizardViewModelImpl photoWizardViewModelImpl = this.a;
                photoWizardViewState = PhotoWizardViewModelImpl.access$errorViewState(photoWizardViewModelImpl, photoWizardViewModelImpl.f);
            }
            viewStateData.postValue(photoWizardViewState);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ PhotoWizardViewModelImpl a;

        public b(PhotoWizardViewModelImpl photoWizardViewModelImpl) {
            this.a = photoWizardViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            MutableLiveData<PhotoWizardViewState> viewStateData = this.a.getViewStateData();
            PhotoWizardViewModelImpl photoWizardViewModelImpl = this.a;
            viewStateData.postValue(PhotoWizardViewModelImpl.access$errorViewState(photoWizardViewModelImpl, photoWizardViewModelImpl.f));
        }
    }

    public PhotoWizardViewModelImpl(@NotNull String str, @NotNull WizardStepsConverter wizardStepsConverter, @NotNull UploadPicturesInteractor uploadPicturesInteractor, @NotNull List<VerificationStep> list, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PhotoWizardResourceProvider photoWizardResourceProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(wizardStepsConverter, "stepsConverter");
        Intrinsics.checkNotNullParameter(uploadPicturesInteractor, "uploadPicturesInteractor");
        Intrinsics.checkNotNullParameter(list, "verificationSteps");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(photoWizardResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.i = str;
        this.j = uploadPicturesInteractor;
        this.k = schedulersFactory3;
        this.l = photoWizardResourceProvider;
        this.m = analytics;
        List<WizardStep> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) wizardStepsConverter.convert(list));
        this.e = mutableList;
        this.f = (WizardStep) CollectionsKt___CollectionsKt.first((List<? extends Object>) mutableList);
        this.g = new LinkedHashMap();
        d();
    }

    public static final PhotoWizardViewState access$errorViewState(PhotoWizardViewModelImpl photoWizardViewModelImpl, WizardStep wizardStep) {
        TakenPicture takenPicture = photoWizardViewModelImpl.g.get(wizardStep);
        Intrinsics.checkNotNull(takenPicture);
        return new PhotoWizardViewState.Picture(takenPicture.getUri(), ActionsState.ERROR, photoWizardViewModelImpl.f(wizardStep).getPictureType());
    }

    public final int c() {
        return this.e.indexOf(this.f);
    }

    public final void d() {
        PhotoWizardViewState photoWizardViewState;
        getTitleData().postValue(this.l.getStepTitle(c() + 1, this.e.size()));
        TakenPicture takenPicture = this.g.get(this.f);
        MutableLiveData<PhotoWizardViewState> viewStateData = getViewStateData();
        if (takenPicture == null) {
            photoWizardViewState = h(this.f);
        } else {
            photoWizardViewState = e(this.f, takenPicture.getUri());
        }
        viewStateData.postValue(photoWizardViewState);
    }

    public final PhotoWizardViewState e(WizardStep wizardStep, Uri uri) {
        return new PhotoWizardViewState.Picture(uri, Intrinsics.areEqual(wizardStep, (WizardStep) CollectionsKt___CollectionsKt.last(this.e)) ? ActionsState.DONE : ActionsState.NEXT, f(wizardStep).getPictureType());
    }

    public final DocumentType f(WizardStep wizardStep) {
        for (T t : wizardStep.getTypes()) {
            if (t.isSelected()) {
                return t;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final void g(FlowAction flowAction) {
        this.m.track(new PhotoWizardFlowActionClickEvent(this.i, f(this.f).getId(), flowAction));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final PhotoWizardViewState h(WizardStep wizardStep) {
        Integer num;
        DocumentType f2 = f(wizardStep);
        String id = f2.getId();
        switch (id.hashCode()) {
            case -1406316789:
                if (id.equals("driver_license_new")) {
                    num = Integer.valueOf(R.drawable.mask_driver_license_new);
                    break;
                }
                num = null;
                break;
            case -1406315630:
                if (id.equals("driver_license_old")) {
                    num = Integer.valueOf(R.drawable.mask_driver_license_old);
                    break;
                }
                num = null;
                break;
            case 404885980:
                if (id.equals("sts_front")) {
                    num = Integer.valueOf(R.drawable.mask_sts_front);
                    break;
                }
                num = null;
                break;
            case 1814040276:
                if (id.equals("sts_back")) {
                    num = Integer.valueOf(R.drawable.mask_sts_back);
                    break;
                }
                num = null;
                break;
            default:
                num = null;
                break;
        }
        return new PhotoWizardViewState.TakePicture(wizardStep.getHint(), num, wizardStep.getTypes(), f2.getPictureType());
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.h;
        if (disposable != null) {
            disposable.dispose();
        }
        this.h = null;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardViewModel
    public void onCloseClicked() {
        getViewStateData().postValue(PhotoWizardViewState.ForceClosed.INSTANCE);
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardViewModel
    public void onDoneClicked() {
        g(FlowAction.PROCEED);
        this.m.track(new PhotoWizardFinishClickEvent(this.i));
        MutableLiveData<PhotoWizardViewState> viewStateData = getViewStateData();
        WizardStep wizardStep = this.f;
        TakenPicture takenPicture = this.g.get(wizardStep);
        Intrinsics.checkNotNull(takenPicture);
        viewStateData.postValue(new PhotoWizardViewState.Picture(takenPicture.getUri(), ActionsState.LOADING, f(wizardStep).getPictureType()));
        this.h = this.j.uploadPictures(this.g.values()).observeOn(this.k.mainThread()).subscribeOn(this.k.io()).subscribe(new a(this), new b(this));
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardViewModel
    public void onNextClicked() {
        g(FlowAction.PROCEED);
        this.f = this.e.get(c() + 1);
        d();
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardViewModel
    public void onPictureTaken(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Map<WizardStep, TakenPicture> map = this.g;
        WizardStep wizardStep = this.f;
        map.put(wizardStep, new TakenPicture(f(wizardStep).getId(), uri));
        getViewStateData().postValue(e(this.f, uri));
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardViewModel
    public void onRetakeShotClicked() {
        g(FlowAction.RETAKE_PICTURE);
        this.g.remove(this.f);
        getViewStateData().postValue(h(this.f));
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardViewModel
    public void onTypeClicked(@NotNull DocumentType documentType) {
        Intrinsics.checkNotNullParameter(documentType, "type");
        int c2 = c();
        WizardStep wizardStep = this.f;
        List<DocumentType> types = wizardStep.getTypes();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(types, 10));
        for (T t : types) {
            arrayList.add(DocumentType.copy$default(t, null, null, null, Intrinsics.areEqual(t.getId(), documentType.getId()), 7, null));
        }
        WizardStep copy$default = WizardStep.copy$default(wizardStep, null, arrayList, 1, null);
        this.f = copy$default;
        this.e.set(c2, copy$default);
        getViewStateData().postValue(h(this.f));
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardViewModel
    @NotNull
    public MutableLiveData<String> getTitleData() {
        return this.c;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardViewModel
    @NotNull
    public MutableLiveData<PhotoWizardViewState> getViewStateData() {
        return this.d;
    }
}
