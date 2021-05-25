package com.avito.android.ui.adapter;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/ui/adapter/AppendingAdapter;", "", "", "loadingRange", "", "setLoadingRange", "(I)V", "setAppendingFromTop", "()V", "setAppendingFromBottom", "getCount", "()I", "appending-list_release"}, k = 1, mv = {1, 4, 2})
public interface AppendingAdapter {
    @Override // com.avito.android.ui.adapter.AppendingAdapter
    int getCount();

    void setAppendingFromBottom();

    void setAppendingFromTop();

    void setLoadingRange(int i);
}
