package com.avito.android.publish.new_advert;

import com.avito.android.remote.model.DeepLinksDialogInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0002\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/avito/android/publish/new_advert/NewAdvertPresenter;", "", "Lcom/avito/android/publish/new_advert/NewAdvertPresenter$View;", "view", "", "attachView", "(Lcom/avito/android/publish/new_advert/NewAdvertPresenter$View;)V", "detachView", "()V", "Lcom/avito/android/publish/new_advert/NewAdvertPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/publish/new_advert/NewAdvertPresenter$Router;)V", "detachRouter", "onRestoreDraftRejected", "onNewAdvertViewAboutToBeExpanded", "Router", "View", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface NewAdvertPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/publish/new_advert/NewAdvertPresenter$Router;", "", "", "sessionId", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "dialogInfo", "", "showPublishDraftAvailableDialog", "(Ljava/lang/String;Lcom/avito/android/remote/model/DeepLinksDialogInfo;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void showPublishDraftAvailableDialog(@NotNull String str, @NotNull DeepLinksDialogInfo deepLinksDialogInfo);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/publish/new_advert/NewAdvertPresenter$View;", "", "", "continueExpandAddAdvert", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface View {
        void continueExpandAddAdvert();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull View view);

    void detachRouter();

    void detachView();

    void onNewAdvertViewAboutToBeExpanded();

    void onRestoreDraftRejected();
}
