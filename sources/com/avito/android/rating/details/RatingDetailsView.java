package com.avito.android.rating.details;

import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0018\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/avito/android/rating/details/RatingDetailsView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lio/reactivex/rxjava3/core/Observable;", "", "closeEvents", "()Lio/reactivex/rxjava3/core/Observable;", "commentClicks", "reviewRequestClicks", "updateItems", "()V", "", VKApiConst.POSITION, "scrollToPosition", "(I)V", "Lkotlin/Function0;", "", "canAppend", "floatingViewsStateChanges", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/core/Observable;", "", "text", "showCommentButton", "(Ljava/lang/String;)V", "showRequestReviewButton", "notifyItemAtPositionChanged", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface RatingDetailsView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull RatingDetailsView ratingDetailsView) {
            ItemView.DefaultImpls.onUnbind(ratingDetailsView);
        }
    }

    @NotNull
    Observable<Unit> closeEvents();

    @NotNull
    Observable<Unit> commentClicks();

    @NotNull
    Observable<Boolean> floatingViewsStateChanges(@NotNull Function0<Boolean> function0);

    void notifyItemAtPositionChanged(int i);

    @NotNull
    Observable<Unit> reviewRequestClicks();

    void scrollToPosition(int i);

    void showCommentButton(@Nullable String str);

    void showRequestReviewButton(@NotNull String str);

    void updateItems();
}
