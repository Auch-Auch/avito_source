package com.avito.android.publish.objects;

import com.avito.android.publish.date_picker.DatePickerSheetDialog;
import com.avito.android.publish.view.BasicParameterClickListener;
import com.avito.android.publish.view.ItemDetailsView;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/publish/objects/ObjectsEditPresenter;", "Lcom/avito/android/publish/view/ItemDetailsView$Presenter;", "Lcom/avito/android/publish/view/ItemDetailsView;", "view", "", "attachView", "(Lcom/avito/android/publish/view/ItemDetailsView;)V", "detachView", "()V", "", "success", "onAuthResult", "(Z)V", "Lcom/avito/android/publish/objects/ObjectsEditPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/publish/objects/ObjectsEditPresenter$Router;)V", "detachRouter", "keyboardVisible", "handleKeyboard", "Router", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ObjectsEditPresenter extends ItemDetailsView.Presenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJI\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/publish/objects/ObjectsEditPresenter$Router;", "Lcom/avito/android/publish/view/BasicParameterClickListener$Router;", "", "leaveScreen", "()V", "navigateToAuth", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "objectsParameter", "leaveScreenWithChangedObject", "(Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;)V", "Lcom/avito/android/publish/date_picker/DatePickerSheetDialog$DialogResources;", "dialogResources", "", "value", "delimiterStart", "delimiterEnd", "Lkotlin/Function1;", "callback", "showDatePickerDialog", "(Lcom/avito/android/publish/date_picker/DatePickerSheetDialog$DialogResources;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router extends BasicParameterClickListener.Router {
        void leaveScreen();

        void leaveScreenWithChangedObject(@NotNull ObjectsParameter objectsParameter);

        void navigateToAuth();

        void showDatePickerDialog(@NotNull DatePickerSheetDialog.DialogResources dialogResources, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @NotNull Function1<? super Long, Unit> function1);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull ItemDetailsView itemDetailsView);

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    void detachRouter();

    void detachView();

    void handleKeyboard(boolean z);

    void onAuthResult(boolean z);
}
