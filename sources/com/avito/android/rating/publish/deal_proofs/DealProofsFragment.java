package com.avito.android.rating.publish.deal_proofs;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.photo_view.ImageListRouter;
import com.avito.android.rating.R;
import com.avito.android.rating.publish.RatingPublishStep;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepHost;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.deal_proofs.DealProofsPresenter;
import com.avito.android.rating.publish.deal_proofs.di.DaggerDealProofsComponent;
import com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent;
import com.avito.android.rating.publish.deal_proofs.di.DealProofsDependencies;
import com.avito.android.rating.publish.deal_proofs.event.DealProofsOpenEvent;
import com.avito.android.rating.publish.deal_proofs.event.RatingPhotosOpenEvent;
import com.avito.android.rating.publish.deal_proofs.event.RatingPhotosPhotopickerOpenEvent;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Bundles;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\bg\u0010\u0018J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\fJ)\u0010\"\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\u0018J\u0019\u0010'\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b)\u0010(J!\u0010+\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010*\u001a\u00020\u001dH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\nH\u0016¢\u0006\u0004\b-\u0010\u0018J%\u00100\u001a\u00020\n2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010%0.H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0007H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\nH\u0016¢\u0006\u0004\b5\u0010\u0018R\"\u00107\u001a\u0002068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010E\u001a\u00020D8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010L\u001a\u00020K8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010S\u001a\u00020R8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010a\u001a\u00020`8\u0006@\u0006X.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f¨\u0006h"}, d2 = {"Lcom/avito/android/rating/publish/deal_proofs/DealProofsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter$Router;", "Lcom/avito/android/photo_view/ImageListRouter;", "Lcom/avito/android/rating/publish/StepHost;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "", "selectedPhotoId", "showPhotoPickerForImages", "(Ljava/lang/String;)V", "showPhotoPickerForFiles", "currentPhotoCount", "openPhotoPicker", "(Ljava/lang/String;I)V", "openVideoPicker", "", "errors", "handleErrors", "(Ljava/util/Map;)V", "isLoading", "handleLoading", "(Z)V", "showHelpDialog", "Lcom/avito/android/photo_view/ImageListPresenter;", "imageListPresenter", "Lcom/avito/android/photo_view/ImageListPresenter;", "getImageListPresenter", "()Lcom/avito/android/photo_view/ImageListPresenter;", "setImageListPresenter", "(Lcom/avito/android/photo_view/ImageListPresenter;)V", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "Lcom/avito/android/rating/publish/StepListener;", "getStepListener", "()Lcom/avito/android/rating/publish/StepListener;", "setStepListener", "(Lcom/avito/android/rating/publish/StepListener;)V", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter;", "presenter", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter;", "getPresenter", "()Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter;", "setPresenter", "(Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "handler", "d", "Ljava/lang/String;", "operationId", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/ratings/RatingPublishData;", "getRatingData", "()Lcom/avito/android/ratings/RatingPublishData;", "setRatingData", "(Lcom/avito/android/ratings/RatingPublishData;)V", "<init>", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class DealProofsFragment extends BaseFragment implements DealProofsPresenter.Router, ImageListRouter, StepHost {
    @Inject
    public Analytics analytics;
    public final Handler c = new Handler();
    public String d;
    @Inject
    public ImageListPresenter imageListPresenter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public DealProofsPresenter presenter;
    @Inject
    public RatingPublishData ratingData;
    @Inject
    public StepListener stepListener;

    public static final class a implements Runnable {
        public final /* synthetic */ DealProofsFragment a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public a(DealProofsFragment dealProofsFragment, int i, int i2) {
            this.a = dealProofsFragment;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b == -1 && this.c == 42) {
                this.a.getImageListPresenter().onPhotoPickerResult(this.b == -1);
            }
        }
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final ImageListPresenter getImageListPresenter() {
        ImageListPresenter imageListPresenter2 = this.imageListPresenter;
        if (imageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        return imageListPresenter2;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final DealProofsPresenter getPresenter() {
        DealProofsPresenter dealProofsPresenter = this.presenter;
        if (dealProofsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return dealProofsPresenter;
    }

    @NotNull
    public final RatingPublishData getRatingData() {
        RatingPublishData ratingPublishData = this.ratingData;
        if (ratingPublishData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ratingData");
        }
        return ratingPublishData;
    }

    @NotNull
    public final StepListener getStepListener() {
        StepListener stepListener2 = this.stepListener;
        if (stepListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepListener");
        }
        return stepListener2;
    }

    @Override // com.avito.android.rating.publish.StepHost
    public void handleErrors(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "errors");
    }

    @Override // com.avito.android.rating.publish.StepHost
    public void handleLoading(boolean z) {
        DealProofsPresenter dealProofsPresenter = this.presenter;
        if (dealProofsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        dealProofsPresenter.handleLoading(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.c.post(new a(this, i2, i));
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter.Router
    public void onBackPressed() {
        StepListener stepListener2 = this.stepListener;
        if (stepListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepListener");
        }
        stepListener2.onBackPressed();
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            String stepId = RatingPublishStep.IMAGES.getStepId();
            RatingPublishData ratingPublishData = this.ratingData;
            if (ratingPublishData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            if (Intrinsics.areEqual(stepId, ratingPublishData.getStepId())) {
                Analytics analytics2 = this.analytics;
                if (analytics2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analytics");
                }
                RatingPublishData ratingPublishData2 = this.ratingData;
                if (ratingPublishData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ratingData");
                }
                String itemId = ratingPublishData2.getItemId();
                RatingPublishData ratingPublishData3 = this.ratingData;
                if (ratingPublishData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ratingData");
                }
                String userKey = ratingPublishData3.getUserKey();
                RatingPublishData ratingPublishData4 = this.ratingData;
                if (ratingPublishData4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ratingData");
                }
                Integer score = ratingPublishData4.getScore();
                RatingPublishData ratingPublishData5 = this.ratingData;
                if (ratingPublishData5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ratingData");
                }
                analytics2.track(new RatingPhotosOpenEvent(itemId, null, userKey, score, ratingPublishData5.getStageId(), 2, null));
                return;
            }
            Analytics analytics3 = this.analytics;
            if (analytics3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            RatingPublishData ratingPublishData6 = this.ratingData;
            if (ratingPublishData6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            String itemId2 = ratingPublishData6.getItemId();
            RatingPublishData ratingPublishData7 = this.ratingData;
            if (ratingPublishData7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            Integer score2 = ratingPublishData7.getScore();
            RatingPublishData ratingPublishData8 = this.ratingData;
            if (ratingPublishData8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            analytics3.track(new DealProofsOpenEvent(itemId2, score2, ratingPublishData8.getStageId()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.deal_proofs, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        DealProofsPresenter dealProofsPresenter = this.presenter;
        if (dealProofsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        dealProofsPresenter.detachView();
        ImageListPresenter imageListPresenter2 = this.imageListPresenter;
        if (imageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        imageListPresenter2.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        DealProofsPresenter dealProofsPresenter = this.presenter;
        if (dealProofsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", dealProofsPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        DealProofsPresenter dealProofsPresenter = this.presenter;
        if (dealProofsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        dealProofsPresenter.attachRouter(this);
        ImageListPresenter imageListPresenter2 = this.imageListPresenter;
        if (imageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        imageListPresenter2.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        DealProofsPresenter dealProofsPresenter = this.presenter;
        if (dealProofsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        dealProofsPresenter.detachRouter();
        ImageListPresenter imageListPresenter2 = this.imageListPresenter;
        if (imageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        imageListPresenter2.detachRouter();
        this.c.removeCallbacksAndMessages(null);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ImageListPresenter imageListPresenter2 = this.imageListPresenter;
        if (imageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        DealProofsViewImpl dealProofsViewImpl = new DealProofsViewImpl(view, imageListPresenter2);
        DealProofsPresenter dealProofsPresenter = this.presenter;
        if (dealProofsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        dealProofsPresenter.attachView(dealProofsViewImpl);
        ImageListPresenter imageListPresenter3 = this.imageListPresenter;
        if (imageListPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        imageListPresenter3.attachView(dealProofsViewImpl);
    }

    @Override // com.avito.android.photo_view.ImageListRouter
    public void openPhotoPicker(@Nullable String str, int i) {
        DealProofsPresenter dealProofsPresenter = this.presenter;
        if (dealProofsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        dealProofsPresenter.processPhotoPickerStep(str, i);
    }

    @Override // com.avito.android.photo_view.ImageListRouter
    public void openVideoPicker() {
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setImageListPresenter(@NotNull ImageListPresenter imageListPresenter2) {
        Intrinsics.checkNotNullParameter(imageListPresenter2, "<set-?>");
        this.imageListPresenter = imageListPresenter2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull DealProofsPresenter dealProofsPresenter) {
        Intrinsics.checkNotNullParameter(dealProofsPresenter, "<set-?>");
        this.presenter = dealProofsPresenter;
    }

    public final void setRatingData(@NotNull RatingPublishData ratingPublishData) {
        Intrinsics.checkNotNullParameter(ratingPublishData, "<set-?>");
        this.ratingData = ratingPublishData;
    }

    public final void setStepListener(@NotNull StepListener stepListener2) {
        Intrinsics.checkNotNullParameter(stepListener2, "<set-?>");
        this.stepListener = stepListener2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        RatingPublishData ratingPublishData;
        RatingPublishViewData ratingPublishViewData;
        String str;
        Bundle arguments = getArguments();
        if (arguments == null || (ratingPublishData = (RatingPublishData) arguments.getParcelable("rating_data")) == null) {
            throw new IllegalArgumentException();
        }
        Intrinsics.checkNotNullExpressionValue(ratingPublishData, "arguments?.getParcelable…llegalArgumentException()");
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (ratingPublishViewData = (RatingPublishViewData) arguments2.getParcelable("rating_view_data")) == null) {
            throw new IllegalArgumentException();
        }
        Intrinsics.checkNotNullExpressionValue(ratingPublishViewData, "arguments?.getParcelable…llegalArgumentException()");
        if (Intrinsics.areEqual(RatingPublishStep.IMAGES.getStepId(), ratingPublishData.getStepId())) {
            str = ratingPublishViewData.getImagesOperationId();
            if (str == null) {
                throw new IllegalArgumentException("imagesOperationId must be specified");
            }
        } else {
            str = ratingPublishViewData.getFilesOperationId();
            if (str == null) {
                throw new IllegalArgumentException("filesOperationId must be specified");
            }
        }
        this.d = str;
        DealProofsComponent.Builder dependentOn = DaggerDealProofsComponent.builder().dependentOn((DealProofsDependencies) ComponentDependenciesKt.getDependencies(DealProofsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DealProofsComponent.Builder with = dependentOn.with(resources);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        DealProofsComponent.Builder with2 = with.with(requireActivity);
        FragmentActivity requireActivity2 = requireActivity();
        Objects.requireNonNull(requireActivity2, "null cannot be cast to non-null type com.avito.android.rating.publish.StepListener.Holder");
        DealProofsComponent.Builder with3 = with2.with(((StepListener.Holder) requireActivity2).getStepListener());
        String str2 = this.d;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operationId");
        }
        with3.with(str2).with(ratingPublishData).with(ratingPublishViewData).build().inject(this);
        return true;
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter.Router
    public void showHelpDialog() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        bottomSheetDialog.setContentView(R.layout.deal_proof_info, true);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setPeekHeight(getResources().getDimensionPixelOffset(R.dimen.dialog_peek_height));
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, false, false, 10, null);
        bottomSheetDialog.show();
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter.Router
    public void showPhotoPickerForFiles(@Nullable String str) {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        RatingPublishData ratingPublishData = this.ratingData;
        if (ratingPublishData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ratingData");
        }
        String filesOperationId = ratingPublishData.getFilesOperationId();
        if (filesOperationId != null) {
            ImageListPresenter imageListPresenter2 = this.imageListPresenter;
            if (imageListPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
            }
            startActivityForResult(activityIntentFactory.createPhotoPickerIntentForRatingsFiles(filesOperationId, imageListPresenter2.getMaxImageCount(), str), 42);
            return;
        }
        throw new IllegalStateException("filesOperationId must be specified");
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsPresenter.Router
    public void showPhotoPickerForImages(@Nullable String str) {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        RatingPublishData ratingPublishData = this.ratingData;
        if (ratingPublishData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ratingData");
        }
        String imagesOperationId = ratingPublishData.getImagesOperationId();
        if (imagesOperationId != null) {
            ImageListPresenter imageListPresenter2 = this.imageListPresenter;
            if (imageListPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
            }
            Intent createPhotoPickerIntentForRatingImages = activityIntentFactory.createPhotoPickerIntentForRatingImages(imagesOperationId, imageListPresenter2.getMaxImageCount(), str);
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            RatingPublishData ratingPublishData2 = this.ratingData;
            if (ratingPublishData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            String itemId = ratingPublishData2.getItemId();
            RatingPublishData ratingPublishData3 = this.ratingData;
            if (ratingPublishData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            String userKey = ratingPublishData3.getUserKey();
            RatingPublishData ratingPublishData4 = this.ratingData;
            if (ratingPublishData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            Integer score = ratingPublishData4.getScore();
            RatingPublishData ratingPublishData5 = this.ratingData;
            if (ratingPublishData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            analytics2.track(new RatingPhotosPhotopickerOpenEvent(itemId, null, userKey, score, ratingPublishData5.getStageId(), 2, null));
            startActivityForResult(createPhotoPickerIntentForRatingImages, 42);
            return;
        }
        throw new IllegalStateException("imagesOperationId must be specified");
    }
}
