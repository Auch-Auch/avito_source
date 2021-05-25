package com.avito.android.in_app_calls.ui.callReview;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReview;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragmentComponent;", "", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragment;", "fragment", "", "inject", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragment;)V", "Builder", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CallReviewComponentDependencies.class}, modules = {CallReviewFragmentModule.class})
@PerFragment
public interface CallReviewFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragmentComponent$Builder;", "", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragmentComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragmentComponent$Builder;", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;", "callReview", "params", "(Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragmentComponent$Builder;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewComponentDependencies;", "deps", "dependencies", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewComponentDependencies;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragmentComponent$Builder;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragmentComponent;", "build", "()Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragmentComponent;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        CallReviewFragmentComponent build();

        @NotNull
        Builder dependencies(@NotNull CallReviewComponentDependencies callReviewComponentDependencies);

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder params(@NotNull CallReview callReview);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);
    }

    void inject(@NotNull CallReviewFragment callReviewFragment);
}
