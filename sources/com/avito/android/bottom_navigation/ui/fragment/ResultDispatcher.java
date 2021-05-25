package com.avito.android.bottom_navigation.ui.fragment;

import com.avito.android.ui.fragments.ResultFragmentData;
import com.avito.android.ui.fragments.ResultReportData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/ResultDispatcher;", "", "Lcom/avito/android/ui/fragments/ResultFragmentData;", "data", "", "setTargetFragment", "(Lcom/avito/android/ui/fragments/ResultFragmentData;)V", "Lcom/avito/android/ui/fragments/ResultReportData;", "reportResults", "(Lcom/avito/android/ui/fragments/ResultReportData;)V", "", "getId", "()Ljava/lang/String;", "id", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public interface ResultDispatcher {
    @NotNull
    String getId();

    void reportResults(@NotNull ResultReportData resultReportData);

    void setTargetFragment(@NotNull ResultFragmentData resultFragmentData);
}
