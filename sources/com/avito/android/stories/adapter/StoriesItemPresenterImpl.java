package com.avito.android.stories.adapter;

import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Story;
import com.avito.android.stories.StoriesItem;
import com.avito.android.stories.analytics.StoryClickedEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B$\b\u0007\u0012\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0010¢\u0006\u0002\b\u00110\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR!\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0010¢\u0006\u0002\b\u00110\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/stories/adapter/StoriesItemPresenterImpl;", "Lcom/avito/android/stories/adapter/StoriesItemPresenter;", "Lcom/avito/android/stories/adapter/StoriesItemView;", "view", "Lcom/avito/android/stories/StoriesItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/stories/adapter/StoriesItemView;Lcom/avito/android/stories/StoriesItem;I)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Ldagger/Lazy;", "Lcom/avito/android/stories/adapter/StoriesItemListener;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesItemPresenterImpl implements StoriesItemPresenter {
    public final Lazy<StoriesItemListener> a;
    public final Analytics b;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ StoriesItem a;
        public final /* synthetic */ StoriesItemView b;
        public final /* synthetic */ StoriesItemPresenterImpl c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(StoriesItem storiesItem, StoriesItemView storiesItemView, StoriesItemPresenterImpl storiesItemPresenterImpl, StoriesItem storiesItem2) {
            super(1);
            this.a = storiesItem;
            this.b = storiesItemView;
            this.c = storiesItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            Story story = this.a.getStories().get(intValue);
            ((StoriesItemListener) this.c.a.get()).onStoryClicked(story.getId(), story.getUrl());
            this.c.b.track(new StoryClickedEvent(story.getId(), story.getTitle(), intValue));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ StoriesItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(StoriesItem storiesItem) {
            super(1);
            this.a = storiesItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            StoriesItem storiesItem = this.a;
            Story story = (Story) CollectionsKt___CollectionsKt.getOrNull(storiesItem.getStories(), intValue);
            storiesItem.setCurrentStoryId(story != null ? story.getId() : null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public StoriesItemPresenterImpl(@NotNull Lazy<StoriesItemListener> lazy, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = lazy;
        this.b = analytics;
    }

    public void bindView(@NotNull StoriesItemView storiesItemView, @NotNull StoriesItem storiesItem, int i) {
        Intrinsics.checkNotNullParameter(storiesItemView, "view");
        Intrinsics.checkNotNullParameter(storiesItem, "item");
        storiesItemView.setStories(storiesItem.getStories(), new a(storiesItem, storiesItemView, this, storiesItem));
        if (storiesItem.getCurrentStoryId() != null) {
            Iterator<Story> it = storiesItem.getStories().iterator();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getId(), storiesItem.getCurrentStoryId())) {
                    break;
                } else {
                    i2++;
                }
            }
            Integer valueOf = Integer.valueOf(i2);
            if (valueOf.intValue() >= 0) {
                z = true;
            }
            if (!z) {
                valueOf = null;
            }
            if (valueOf != null) {
                storiesItemView.setCurrentPosition(valueOf.intValue());
            }
        }
        storiesItemView.storyPositionChanges(new b(storiesItem));
    }
}
