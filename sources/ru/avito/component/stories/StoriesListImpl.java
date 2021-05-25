package ru.avito.component.stories;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.avito.android.remote.model.Story;
import com.avito.android.ui_components.R;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.stories.single.StoryCarouselItemBlueprint;
import ru.avito.component.stories.single.StoryCarouselItemPresenter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\n\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lru/avito/component/stories/StoriesListImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/stories/StoriesList;", "", "Lcom/avito/android/remote/model/Story;", "stories", "Lkotlin/Function1;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStories", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "storyPositionChanges", "(Lkotlin/jvm/functions/Function1;)V", "Lru/avito/component/stories/StoriesCarousel;", "s", "Lru/avito/component/stories/StoriesCarousel;", "storiesCarousel", "t", "Lkotlin/jvm/functions/Function1;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesListImpl extends BaseViewHolder implements StoriesList {
    public final StoriesCarousel s;
    public Function1<? super Integer, Unit> t;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ StoriesListImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(StoriesListImpl storiesListImpl) {
            super(1);
            this.a = storiesListImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            Function1 function1 = this.a.t;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(Integer.valueOf(intValue));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoriesListImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        view.getContext();
        View findViewById = view.findViewById(R.id.stories_list);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        ItemBinder build = new ItemBinder.Builder().registerItem(new StoryCarouselItemBlueprint(new StoryCarouselItemPresenter(new a(this), 0.75f))).build();
        StoriesCarousel storiesCarousel = new StoriesCarousel(findViewById, new SimpleAdapterPresenter(build, build), build);
        this.s = storiesCarousel;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        storiesCarousel.setHeight((int) (((float) ((displayMetrics.widthPixels - findViewById.getPaddingLeft()) - findViewById.getPaddingRight())) * (((float) displayMetrics.widthPixels) / displayMetrics.density > ((float) 360) ? 0.363f : 0.415f)));
    }

    @Override // ru.avito.component.stories.StoriesList
    public void setCurrentPosition(int i) {
        this.s.setCurrentPicture(i, false);
    }

    @Override // ru.avito.component.stories.StoriesList
    public void setStories(@NotNull List<Story> list, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "stories");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t = function1;
        this.s.setStories(list);
    }

    @Override // ru.avito.component.stories.StoriesList
    public void storyPositionChanges(@Nullable Function1<? super Integer, Unit> function1) {
        this.s.setPictureChangeListener(function1);
    }
}
