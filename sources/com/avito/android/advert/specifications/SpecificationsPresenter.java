package com.avito.android.advert.specifications;

import com.avito.android.advert_core.specifications.SpecificationsView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/specifications/SpecificationsPresenter;", "", "Lcom/avito/android/advert_core/specifications/SpecificationsView;", "view", "Lkotlin/Function0;", "", "closeAction", "attachView", "(Lcom/avito/android/advert_core/specifications/SpecificationsView;Lkotlin/jvm/functions/Function0;)V", "detachView", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface SpecificationsPresenter {
    void attachView(@NotNull SpecificationsView specificationsView, @NotNull Function0<Unit> function0);

    void detachView();
}
