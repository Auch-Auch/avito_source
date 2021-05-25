package com.avito.android.home;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.util.Constants;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH&¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH&¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\nH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0005H&¢\u0006\u0004\b\u001e\u0010\bJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0005H&¢\u0006\u0004\b \u0010\bJ\u000f\u0010!\u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0002H&¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/home/HomePresenterView;", "", "", "showProgress", "()V", "", "error", "showError", "(Ljava/lang/String;)V", "onDataChanged", "", "offset", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diff", "dispatchChanges", "(ILandroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "startPosition", "count", "onDataRangeChanged", "(II)V", "onDataInserted", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "setAppendingListener", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", VKApiConst.POSITION, "onRemoveItem", "onItemChanged", "(I)V", Constants.LOCATION_NAME, "setSearchHintSearchInLocation", "hint", "setSearchHintFromApi", "setSearchHintSearch", "initToolbar", "scrollToStart", "enableScroll", "updateAddButtonState", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface HomePresenterView {
    void dispatchChanges(int i, @NotNull DiffUtil.DiffResult diffResult);

    void enableScroll();

    void initToolbar();

    void onDataChanged();

    void onDataInserted(int i, int i2);

    void onDataRangeChanged(int i, int i2);

    void onItemChanged(int i);

    void onRemoveItem(int i, int i2);

    void scrollToStart();

    void setAppendingListener(@NotNull AppendingListener appendingListener);

    void setSearchHintFromApi(@NotNull String str);

    void setSearchHintSearch();

    void setSearchHintSearchInLocation(@NotNull String str);

    @Override // com.avito.android.legacy_mvp.ErrorMessageView
    void showError(@NotNull String str);

    void showProgress();

    void updateAddButtonState();
}
