package com.avito.android.rating.details;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.button.Button;
import com.avito.android.rating.R;
import com.avito.android.rating.RatingParamsKt;
import com.avito.android.rating.details.RatingDetailsPresenter;
import com.avito.android.rating.details.adapter.info.InfoItem;
import com.avito.android.rating.details.di.DaggerRatingDetailsComponent;
import com.avito.android.rating.details.di.RatingDetailsComponent;
import com.avito.android.rating.details.di.RatingDetailsDependencies;
import com.avito.android.ratings.ReviewData;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.remote.model.Image;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b^\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\nJ)\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\fJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J%\u0010+\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010*\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010Q\u001a\u00020P8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006_"}, d2 = {"Lcom/avito/android/rating/details/RatingDetailsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/rating/details/RatingDetailsPresenter$Router;", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "onStart", "onStop", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "outState", "onSaveInstanceState", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "close", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/rating/details/adapter/info/InfoItem$Hint;", "hint", "showInfoHintDialog", "(Lcom/avito/android/rating/details/adapter/info/InfoItem$Hint;)V", "Lcom/avito/android/ratings/ReviewData;", "reviewData", "openReviewDetailsScreen", "(Lcom/avito/android/ratings/ReviewData;)V", "", "Lcom/avito/android/remote/model/Image;", "images", VKApiConst.POSITION, "openGallery", "(Ljava/util/List;I)V", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$rating_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$rating_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/rating/details/RatingDetailsPresenter;", "presenter", "Lcom/avito/android/rating/details/RatingDetailsPresenter;", "getPresenter", "()Lcom/avito/android/rating/details/RatingDetailsPresenter;", "setPresenter", "(Lcom/avito/android/rating/details/RatingDetailsPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "<init>", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingDetailsActivity extends BaseActivity implements RatingDetailsPresenter.Router {
    @Inject
    public ResponsiveAdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public RatingDetailsPresenter presenter;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BottomSheetDialog a;
        public final /* synthetic */ RatingDetailsActivity b;
        public final /* synthetic */ InfoItem.Hint c;

        public a(BottomSheetDialog bottomSheetDialog, RatingDetailsActivity ratingDetailsActivity, InfoItem.Hint hint) {
            this.a = bottomSheetDialog;
            this.b = ratingDetailsActivity;
            this.c = hint;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.followDeepLink(this.c.getDeepLink());
            this.a.dismiss();
        }
    }

    @Override // com.avito.android.rating.details.RatingDetailsPresenter.Router
    public void close() {
        finish();
    }

    @Override // com.avito.android.rating.details.RatingDetailsPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivityForResult(intent, 1);
        }
    }

    @NotNull
    public final ResponsiveAdapterPresenter getAdapterPresenter() {
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return responsiveAdapterPresenter;
    }

    @NotNull
    public final Analytics getAnalytics$rating_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.rating_details;
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final RatingDetailsPresenter getPresenter() {
        RatingDetailsPresenter ratingDetailsPresenter = this.presenter;
        if (ratingDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return ratingDetailsPresenter;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String message;
        super.onActivityResult(i, i2, intent);
        boolean z = true;
        if (i == 1 && intent != null && (message = RatingParamsKt.getMessage(intent)) != null) {
            if (message.length() <= 0) {
                z = false;
            }
            if (!z) {
                message = null;
            }
            if (message != null) {
                setResult(-1, RatingParamsKt.putMessage(new Intent(), message));
                close();
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        RatingDetailsPresenter ratingDetailsPresenter = this.presenter;
        if (ratingDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View containerView = getContainerView();
        Objects.requireNonNull(containerView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) containerView;
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        ratingDetailsPresenter.attachView(new RatingDetailsViewImpl(viewGroup, responsiveAdapterPresenter, itemBinder2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        RatingDetailsPresenter ratingDetailsPresenter = this.presenter;
        if (ratingDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ratingDetailsPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        RatingDetailsPresenter ratingDetailsPresenter = this.presenter;
        if (ratingDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", ratingDetailsPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        RatingDetailsPresenter ratingDetailsPresenter = this.presenter;
        if (ratingDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ratingDetailsPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        RatingDetailsPresenter ratingDetailsPresenter = this.presenter;
        if (ratingDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ratingDetailsPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.rating.details.RatingDetailsPresenter.Router
    public void openGallery(@NotNull List<Image> list, int i) {
        Intrinsics.checkNotNullParameter(list, "images");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(activityIntentFactory.photoGalleryIntent(null, list, i));
    }

    @Override // com.avito.android.rating.details.RatingDetailsPresenter.Router
    public void openReviewDetailsScreen(@NotNull ReviewData reviewData) {
        Intrinsics.checkNotNullParameter(reviewData, "reviewData");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.reviewDetails(reviewData), 2);
    }

    public final void setAdapterPresenter(@NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "<set-?>");
        this.adapterPresenter = responsiveAdapterPresenter;
    }

    public final void setAnalytics$rating_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull RatingDetailsPresenter ratingDetailsPresenter) {
        Intrinsics.checkNotNullParameter(ratingDetailsPresenter, "<set-?>");
        this.presenter = ratingDetailsPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        Kundle kundle = null;
        String string = extras != null ? extras.getString("param_user_key") : null;
        Intent intent2 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        String string2 = extras2 != null ? extras2.getString("param_shop_id") : null;
        RatingDetailsComponent.Builder dependentOn = DaggerRatingDetailsComponent.builder().dependentOn((RatingDetailsDependencies) ComponentDependenciesKt.getDependencies(RatingDetailsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        RatingDetailsComponent.Builder withShopId = dependentOn.with(resources).with(this).withUserKey(string).withShopId(string2);
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "presenter_state");
        }
        withShopId.withPresenterState(kundle).build().inject(this);
        return true;
    }

    @Override // com.avito.android.rating.details.RatingDetailsPresenter.Router
    public void showInfoHintDialog(@NotNull InfoItem.Hint hint) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        boolean z = false;
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, 0, 2, null);
        bottomSheetDialog.setContentView(R.layout.rating_info_hint, true);
        bottomSheetDialog.setPeekHeight(getResources().getDimensionPixelOffset(R.dimen.dialog_peek_height));
        View findViewById = bottomSheetDialog.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        TextViews.bindText$default((TextView) findViewById, hint.getTitle(), false, 2, null);
        View findViewById2 = bottomSheetDialog.findViewById(R.id.text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        TextViews.bindText$default((TextView) findViewById2, hint.getText(), false, 2, null);
        View findViewById3 = bottomSheetDialog.findViewById(R.id.button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(id)");
        Button button = (Button) findViewById3;
        String actionText = hint.getActionText();
        if (actionText != null) {
            if (actionText.length() > 0) {
                z = true;
            }
        }
        if (!z || hint.getDeepLink() == null) {
            Views.hide(button);
        } else {
            String actionText2 = hint.getActionText();
            Intrinsics.checkNotNull(actionText2);
            button.setText(actionText2);
            Views.show(button);
            button.setOnClickListener(new a(bottomSheetDialog, this, hint));
        }
        bottomSheetDialog.show();
    }
}
