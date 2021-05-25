package ru.avito.component.stories.single;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lru/avito/component/stories/single/StoryCarouselItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lru/avito/component/stories/single/StoryCarouselItemView;", "Lru/avito/component/stories/single/StoryCarouselItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lru/avito/component/stories/single/StoryCarouselItemView;Lru/avito/component/stories/single/StoryCarouselItem;I)V", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "clickListener", "", AuthSource.BOOKING_ORDER, "F", "widthRatio", "<init>", "(Lkotlin/jvm/functions/Function1;F)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class StoryCarouselItemPresenter implements ItemPresenter<StoryCarouselItemView, StoryCarouselItem> {
    public final Function1<Integer, Unit> a;
    public final float b;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ StoryCarouselItemPresenter a;
        public final /* synthetic */ int b;

        public a(StoryCarouselItemPresenter storyCarouselItemPresenter, int i, StoryCarouselItem storyCarouselItem) {
            this.a = storyCarouselItemPresenter;
            this.b = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.invoke(Integer.valueOf(this.b));
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StoryCarouselItemView a;
        public final /* synthetic */ Disposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(StoryCarouselItemView storyCarouselItemView, Disposable disposable) {
            super(0);
            this.a = storyCarouselItemView;
            this.b = disposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.dispose();
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public StoryCarouselItemPresenter(@NotNull Function1<? super Integer, Unit> function1, float f) {
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        this.a = function1;
        this.b = f;
    }

    public void bindView(@NotNull StoryCarouselItemView storyCarouselItemView, @NotNull StoryCarouselItem storyCarouselItem, int i) {
        Intrinsics.checkNotNullParameter(storyCarouselItemView, "view");
        Intrinsics.checkNotNullParameter(storyCarouselItem, "item");
        storyCarouselItemView.setUnbindListener(new b(storyCarouselItemView, storyCarouselItemView.clicks().subscribe(new a(this, i, storyCarouselItem))));
        storyCarouselItemView.setWidthRatio(this.b);
        storyCarouselItemView.setImage(storyCarouselItem.getBackground(), storyCarouselItem.getPicture());
        storyCarouselItemView.setTitle(storyCarouselItem.getTitle());
        storyCarouselItemView.setViewed(storyCarouselItem.isViewed());
    }
}
