package com.avito.android.rating.review_details;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.rating.R;
import com.avito.android.rating.review_details.ReviewDetailsPresenter;
import com.avito.android.rating.review_details.di.DaggerReviewDetailsComponent;
import com.avito.android.rating.review_details.di.ReviewDetailsComponent;
import com.avito.android.rating.review_details.di.ReviewDetailsDependencies;
import com.avito.android.rating.review_details.reply.ReviewReplyPresenter;
import com.avito.android.rating.review_details.reply.ReviewReplyViewImpl;
import com.avito.android.ratings.ReviewData;
import com.avito.android.remote.model.Image;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bO\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\nJ%\u0010\u001e\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R(\u0010;\u001a\b\u0012\u0004\u0012\u00020:098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/avito/android/rating/review_details/ReviewDetailsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/rating/review_details/ReviewDetailsPresenter$Router;", "Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "leaveScreen", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "showReplyDialog", "", "dialogIsShowing", "()Z", "closeReplyDialog", "", "Lcom/avito/android/remote/model/Image;", "images", "", VKApiConst.POSITION, "openGallery", "(Ljava/util/List;I)V", "Lcom/avito/android/rating/review_details/ReviewDetailsPresenter;", "presenter", "Lcom/avito/android/rating/review_details/ReviewDetailsPresenter;", "getPresenter", "()Lcom/avito/android/rating/review_details/ReviewDetailsPresenter;", "setPresenter", "(Lcom/avito/android/rating/review_details/ReviewDetailsPresenter;)V", "Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter;", "replyPresenter", "Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter;", "getReplyPresenter", "()Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter;", "setReplyPresenter", "(Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "k", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "bottomSheetDialog", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Lio/reactivex/rxjava3/functions/Consumer;", "getImageClicks", "()Lio/reactivex/rxjava3/functions/Consumer;", "setImageClicks", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewDetailsActivity extends BaseActivity implements ReviewDetailsPresenter.Router, ReviewReplyPresenter.Router {
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public Consumer<TnsGalleryItemClickAction> imageClicks;
    @Inject
    public ActivityIntentFactory intentFactory;
    public BottomSheetDialog k;
    @Inject
    public ReviewDetailsPresenter presenter;
    @Inject
    public ReviewReplyPresenter replyPresenter;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ ReviewDetailsActivity a;
        public final /* synthetic */ View b;

        public a(ReviewDetailsActivity reviewDetailsActivity, View view) {
            this.a = reviewDetailsActivity;
            this.b = view;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.getReplyPresenter().detachView();
        }
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyPresenter.Router
    public void closeReplyDialog() {
        ReviewReplyPresenter reviewReplyPresenter = this.replyPresenter;
        if (reviewReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyPresenter");
        }
        reviewReplyPresenter.detachView();
        BottomSheetDialog bottomSheetDialog = this.k;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.close();
        }
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsPresenter.Router
    public boolean dialogIsShowing() {
        BottomSheetDialog bottomSheetDialog = this.k;
        return bottomSheetDialog != null && bottomSheetDialog.isShowing();
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsPresenter.Router, com.avito.android.rating.review_details.reply.ReviewReplyPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final Consumer<TnsGalleryItemClickAction> getImageClicks() {
        Consumer<TnsGalleryItemClickAction> consumer = this.imageClicks;
        if (consumer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageClicks");
        }
        return consumer;
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
    public final ReviewDetailsPresenter getPresenter() {
        ReviewDetailsPresenter reviewDetailsPresenter = this.presenter;
        if (reviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return reviewDetailsPresenter;
    }

    @NotNull
    public final ReviewReplyPresenter getReplyPresenter() {
        ReviewReplyPresenter reviewReplyPresenter = this.replyPresenter;
        if (reviewReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyPresenter");
        }
        return reviewReplyPresenter;
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        ReviewData reviewData;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras == null || (reviewData = (ReviewData) extras.getParcelable("key_review")) == null) {
            throw new IllegalArgumentException("ReviewData must be specified!");
        }
        Intrinsics.checkNotNullExpressionValue(reviewData, "intent.extras?.getParcel…Data must be specified!\")");
        Kundle kundle = null;
        ReviewDetailsComponent.Builder withDetails = DaggerReviewDetailsComponent.builder().dependentOn((ReviewDetailsDependencies) ComponentDependenciesKt.getDependencies(ReviewDetailsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withDetails(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null);
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "reply_presenter_state");
        }
        ReviewDetailsComponent.Builder with = withDetails.withReply(kundle).with(this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        with.with(resources).with(reviewData).build().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_review_details);
        ReviewDetailsPresenter reviewDetailsPresenter = this.presenter;
        if (reviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        Consumer<TnsGalleryItemClickAction> consumer = this.imageClicks;
        if (consumer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageClicks");
        }
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        reviewDetailsPresenter.attachView(new ReviewDetailsViewImpl(findViewById, consumer, this, features2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.k = null;
        ReviewDetailsPresenter reviewDetailsPresenter = this.presenter;
        if (reviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        reviewDetailsPresenter.detachView();
        ReviewReplyPresenter reviewReplyPresenter = this.replyPresenter;
        if (reviewReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyPresenter");
        }
        reviewReplyPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ReviewDetailsPresenter reviewDetailsPresenter = this.presenter;
        if (reviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", reviewDetailsPresenter.onSaveState());
        ReviewReplyPresenter reviewReplyPresenter = this.replyPresenter;
        if (reviewReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyPresenter");
        }
        Bundles.putKundle(bundle, "reply_presenter_state", reviewReplyPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ReviewDetailsPresenter reviewDetailsPresenter = this.presenter;
        if (reviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        reviewDetailsPresenter.attachRouter(this);
        ReviewReplyPresenter reviewReplyPresenter = this.replyPresenter;
        if (reviewReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyPresenter");
        }
        reviewReplyPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ReviewDetailsPresenter reviewDetailsPresenter = this.presenter;
        if (reviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        reviewDetailsPresenter.detachRouter();
        ReviewReplyPresenter reviewReplyPresenter = this.replyPresenter;
        if (reviewReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyPresenter");
        }
        reviewReplyPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsPresenter.Router
    public void openGallery(@NotNull List<Image> list, int i) {
        Intrinsics.checkNotNullParameter(list, "images");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(activityIntentFactory.photoGalleryIntent(null, list, i));
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImageClicks(@NotNull Consumer<TnsGalleryItemClickAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "<set-?>");
        this.imageClicks = consumer;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull ReviewDetailsPresenter reviewDetailsPresenter) {
        Intrinsics.checkNotNullParameter(reviewDetailsPresenter, "<set-?>");
        this.presenter = reviewDetailsPresenter;
    }

    public final void setReplyPresenter(@NotNull ReviewReplyPresenter reviewReplyPresenter) {
        Intrinsics.checkNotNullParameter(reviewReplyPresenter, "<set-?>");
        this.replyPresenter = reviewReplyPresenter;
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsPresenter.Router, com.avito.android.rating.review_details.reply.ReviewReplyPresenter.Router
    @SuppressLint({"InflateParams"})
    public void showReplyDialog() {
        ReviewReplyViewImpl reviewReplyViewImpl;
        BottomSheetDialog bottomSheetDialog = this.k;
        if (bottomSheetDialog == null || !bottomSheetDialog.isShowing()) {
            BottomSheetDialog bottomSheetDialog2 = this.k;
            if (bottomSheetDialog2 == null) {
                View inflate = LayoutInflater.from(this).inflate(R.layout.review_reply, (ViewGroup) null, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                reviewReplyViewImpl = new ReviewReplyViewImpl(inflate);
                BottomSheetDialog bottomSheetDialog3 = new BottomSheetDialog(this, R.style.Theme_Avito_BottomSheetDialog_ReviewReply);
                bottomSheetDialog3.setContentView(inflate, true);
                bottomSheetDialog3.setPeekHeight(getResources().getDimensionPixelOffset(R.dimen.dialog_peek_height));
                bottomSheetDialog3.setOnDismissListener(new a(this, inflate));
                Unit unit = Unit.INSTANCE;
                this.k = bottomSheetDialog3;
            } else {
                Intrinsics.checkNotNull(bottomSheetDialog2);
                View findViewById = bottomSheetDialog2.findViewById(R.id.review_reply_root);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
                reviewReplyViewImpl = new ReviewReplyViewImpl(findViewById);
            }
            ReviewReplyPresenter reviewReplyPresenter = this.replyPresenter;
            if (reviewReplyPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("replyPresenter");
            }
            reviewReplyPresenter.attachView(reviewReplyViewImpl);
            BottomSheetDialog bottomSheetDialog4 = this.k;
            if (bottomSheetDialog4 != null) {
                bottomSheetDialog4.show();
            }
        }
    }
}
