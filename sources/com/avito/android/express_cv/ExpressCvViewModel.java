package com.avito.android.express_cv;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.express_cv.events.CvDialogEvent;
import com.avito.android.express_cv.events.PhoneCallEvent;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.MessageEvent;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
import com.avito.konveyor.data_source.ListDataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013R \u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R \u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0013R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0013R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0013R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0013¨\u0006/"}, d2 = {"Lcom/avito/android/express_cv/ExpressCvViewModel;", "", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "onReload", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "action", "onDialogDismiss", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Landroidx/lifecycle/LiveData;", "", "getTabsVisibilityChanges", "()Landroidx/lifecycle/LiveData;", "tabsVisibilityChanges", "Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/android/express_cv/tabs/CvTabItem;", "getDataChanges", "dataChanges", "Lcom/avito/android/express_cv/events/PhoneCallEvent;", "getPhoneCallEvents", "phoneCallEvents", "Lcom/avito/android/util/LoadingState;", "getActivateProgressChanges", "activateProgressChanges", "getProgressChanges", "progressChanges", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", "getStartActivityEvents", "startActivityEvents", "getCvSuccessfullyPostedEvents", "cvSuccessfullyPostedEvents", "Lcom/avito/android/express_cv/events/CvDialogEvent;", "getShowDialogEvents", "showDialogEvents", "Lcom/avito/android/util/architecture_components/StartActivityForResultEvent;", "getStartActivityForResultEvents", "startActivityForResultEvents", "Lcom/avito/android/util/architecture_components/MessageEvent;", "getMessageEvents", "messageEvents", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public interface ExpressCvViewModel {
    @NotNull
    LiveData<LoadingState<?>> getActivateProgressChanges();

    @NotNull
    LiveData<Object> getCvSuccessfullyPostedEvents();

    @NotNull
    LiveData<ListDataSource<CvTabItem>> getDataChanges();

    @NotNull
    LiveData<MessageEvent> getMessageEvents();

    @NotNull
    LiveData<PhoneCallEvent> getPhoneCallEvents();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    LiveData<CvDialogEvent> getShowDialogEvents();

    @NotNull
    LiveData<StartActivityEvent> getStartActivityEvents();

    @NotNull
    LiveData<StartActivityForResultEvent> getStartActivityForResultEvents();

    @NotNull
    LiveData<Boolean> getTabsVisibilityChanges();

    void onActivityResult(int i, int i2, @Nullable Intent intent);

    void onDialogDismiss(@NotNull DeepLink deepLink);

    void onReload();
}
