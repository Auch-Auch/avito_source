package com.avito.android.publish.drafts;

import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "", "", "getDraftId", "()Ljava/lang/String;", "draftId", "", "setDraftId", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "bundle", "onRestoreState", "(Landroid/os/Bundle;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public interface PublishDraftDataHolder {
    @NotNull
    String getDraftId();

    void onRestoreState(@Nullable Bundle bundle);

    @NotNull
    Bundle onSaveState();

    void setDraftId(@NotNull String str);
}
