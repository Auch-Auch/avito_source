package com.avito.android.publish.premoderation;

import com.avito.android.publish.premoderation.SelectListWidget;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0005J'\u0010\r\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\f\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/premoderation/WrongCategoryView;", "", "Lio/reactivex/Observable;", "", "continueButtonClicks", "()Lio/reactivex/Observable;", "backClicks", "", "categoryWizardIdSelection", "", "Lcom/avito/android/publish/premoderation/SelectListWidget$Data;", "suggestedItems", "initialCheckedItem", "fillCategoryList", "(Ljava/util/List;Lcom/avito/android/publish/premoderation/SelectListWidget$Data;)V", "", "isEnable", "continueButtonAvailability", "(Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface WrongCategoryView {
    @NotNull
    Observable<Unit> backClicks();

    @NotNull
    Observable<String> categoryWizardIdSelection();

    void continueButtonAvailability(boolean z);

    @NotNull
    Observable<Unit> continueButtonClicks();

    void fillCategoryList(@NotNull List<SelectListWidget.Data> list, @Nullable SelectListWidget.Data data);
}
