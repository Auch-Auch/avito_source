package com.avito.android.spare_parts.bottom_sheet;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter;", "", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetView;", "view", "", "attachView", "(Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetView;)V", "detachView", "()V", "popGroupsStack", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter$Router;)V", "detachRouter", "Router", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public interface SparePartsBottomSheetPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter$Router;", "", "", "finish", "()V", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void finish();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SparePartsBottomSheetView sparePartsBottomSheetView);

    void detachRouter();

    void detachView();

    void popGroupsStack();
}
