package com.avito.android.publish.drafts;

import android.os.Bundle;
import com.avito.android.photo_picker.legacy.DraftIdProvider;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/publish/drafts/PublishDraftDataHolderImpl;", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "", "getDraftId", "()Ljava/lang/String;", "draftId", "", "setDraftId", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "bundle", "onRestoreState", "(Landroid/os/Bundle;)V", "onSaveState", "()Landroid/os/Bundle;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "Lcom/avito/android/photo_picker/legacy/DraftIdProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/DraftIdProvider;", "draftIdProvider", "<init>", "(Lcom/avito/android/photo_picker/legacy/DraftIdProvider;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDraftDataHolderImpl implements PublishDraftDataHolder {
    public String a;
    public final DraftIdProvider b;

    public PublishDraftDataHolderImpl(@NotNull DraftIdProvider draftIdProvider) {
        Intrinsics.checkNotNullParameter(draftIdProvider, "draftIdProvider");
        this.b = draftIdProvider;
    }

    @Override // com.avito.android.publish.drafts.PublishDraftDataHolder
    @NotNull
    public String getDraftId() {
        String str = this.a;
        if (str == null) {
            str = this.b.generateDraftId();
        }
        this.a = str;
        return str;
    }

    @Override // com.avito.android.publish.drafts.PublishDraftDataHolder
    public void onRestoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.a = bundle.getString("key_draft_id");
        }
    }

    @Override // com.avito.android.publish.drafts.PublishDraftDataHolder
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        bundle.putString("key_draft_id", this.a);
        return bundle;
    }

    @Override // com.avito.android.publish.drafts.PublishDraftDataHolder
    public void setDraftId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        this.a = str;
    }
}
