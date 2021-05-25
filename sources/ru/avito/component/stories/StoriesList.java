package ru.avito.component.stories;

import com.avito.android.remote.model.Story;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lru/avito/component/stories/StoriesList;", "", "", "Lcom/avito/android/remote/model/Story;", "stories", "Lkotlin/Function1;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStories", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "storyPositionChanges", "(Lkotlin/jvm/functions/Function1;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface StoriesList {
    void setCurrentPosition(int i);

    void setStories(@NotNull List<Story> list, @NotNull Function1<? super Integer, Unit> function1);

    void storyPositionChanges(@Nullable Function1<? super Integer, Unit> function1);
}
