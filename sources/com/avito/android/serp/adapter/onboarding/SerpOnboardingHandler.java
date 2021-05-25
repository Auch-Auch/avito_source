package com.avito.android.serp.adapter.onboarding;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.remote.model.badge_bar.SerpBadgeType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingTooltipEventsProducer;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "", "bindSerpRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "badgeBar", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "bindBadgeListenerToBadgeBar", "(Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;)Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "Landroid/view/View;", "view", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;", "type", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onBadgeDataBounded", "(Landroid/view/View;Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;Lcom/avito/android/deep_linking/links/DeepLink;)V", "unbind", "()V", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerState;", "onSaveState", "()Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerState;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpOnboardingHandler extends SerpOnboardingTooltipEventsProducer {
    @Nullable
    BadgeViewListener bindBadgeListenerToBadgeBar(@Nullable SerpBadgeBar serpBadgeBar);

    void bindSerpRecyclerView(@NotNull RecyclerView recyclerView);

    void onBadgeDataBounded(@NotNull View view, @NotNull SerpBadgeType serpBadgeType, @Nullable DeepLink deepLink);

    @NotNull
    SerpOnboardingHandlerState onSaveState();

    void unbind();
}
