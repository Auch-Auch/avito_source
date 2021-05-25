package com.avito.android.select;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.SelectDialogPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/select/SelectDialogPresenterResourceProvider;", "Lcom/avito/android/select/SelectDialogPresenter$ResourceProvider;", "", "getSaveTitle", "()Ljava/lang/String;", "getClearItemTitle", "getClearActionTitle", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectDialogPresenterResourceProvider implements SelectDialogPresenter.ResourceProvider {
    public final Resources a;

    @Inject
    public SelectDialogPresenterResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.select.SelectDialogPresenter.ResourceProvider
    @NotNull
    public String getClearActionTitle() {
        String string = this.a.getString(R.string.clear_select_hint);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.clear_select_hint)");
        return string;
    }

    @Override // com.avito.android.select.SelectDialogPresenter.ResourceProvider
    @NotNull
    public String getClearItemTitle() {
        String string = this.a.getString(R.string.clear_item);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.clear_item)");
        return string;
    }

    @Override // com.avito.android.select.SelectDialogPresenter.ResourceProvider
    @NotNull
    public String getSaveTitle() {
        String string = this.a.getString(R.string.save);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.save)");
        return string;
    }
}
