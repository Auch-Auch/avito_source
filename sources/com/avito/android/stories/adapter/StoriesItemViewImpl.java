package com.avito.android.stories.adapter;

import android.view.View;
import com.avito.android.remote.model.Story;
import com.avito.android.serp.BaseSerpViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.stories.StoriesList;
import ru.avito.component.stories.StoriesListImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\t\u0010\nJ2\u0010\u0010\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0012\u0010\u0013R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/stories/adapter/StoriesItemViewImpl;", "Lcom/avito/android/stories/adapter/StoriesItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lru/avito/component/stories/StoriesList;", "", "onUnbind", "()V", "", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "", "Lcom/avito/android/remote/model/Story;", "stories", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStories", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "storyPositionChanges", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "s", "Lkotlin/jvm/functions/Function0;", "getUnbindListener", "()Lkotlin/jvm/functions/Function0;", "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "unbindListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesItemViewImpl extends BaseSerpViewHolder implements StoriesItemView, StoriesList {
    @Nullable
    public Function0<Unit> s;
    public final /* synthetic */ StoriesListImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoriesItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new StoriesListImpl(view);
    }

    @Override // com.avito.android.stories.adapter.StoriesItemView
    @Nullable
    public Function0<Unit> getUnbindListener() {
        return this.s;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> unbindListener = getUnbindListener();
        if (unbindListener != null) {
            unbindListener.invoke();
        }
    }

    @Override // ru.avito.component.stories.StoriesList
    public void setCurrentPosition(int i) {
        this.t.setCurrentPosition(i);
    }

    @Override // ru.avito.component.stories.StoriesList
    public void setStories(@NotNull List<Story> list, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "stories");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setStories(list, function1);
    }

    @Override // com.avito.android.stories.adapter.StoriesItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // ru.avito.component.stories.StoriesList
    public void storyPositionChanges(@Nullable Function1<? super Integer, Unit> function1) {
        this.t.storyPositionChanges(function1);
    }
}
