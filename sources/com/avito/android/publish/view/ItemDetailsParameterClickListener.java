package com.avito.android.publish.view;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.publish.view.BasicParameterClickListener;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", "Lcom/avito/android/publish/view/BasicParameterClickListener;", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener$Router;", "router", "", "attachRouter", "(Lcom/avito/android/publish/view/ItemDetailsParameterClickListener$Router;)V", "Lcom/avito/android/category_parameters/ParameterElement$Objects;", "element", "", "objectPosition", "onElementObjectClicked", "(Lcom/avito/android/category_parameters/ParameterElement$Objects;I)V", "onAddMoreObjectsClicked", "(Lcom/avito/android/category_parameters/ParameterElement$Objects;)V", "Router", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ItemDetailsParameterClickListener extends BasicParameterClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/view/ItemDetailsParameterClickListener$Router;", "Lcom/avito/android/publish/view/BasicParameterClickListener$Router;", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "parameter", "", "selectedObject", "", "showEditObjectsScreen", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;Ljava/lang/Integer;)V", "showResidentialComplexSuggestScreen", "()V", "onEditClicked", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router extends BasicParameterClickListener.Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void showEditObjectsScreen$default(Router router, CategoryParameters categoryParameters, ObjectsParameter objectsParameter, Integer num, int i, Object obj) {
                if (obj == null) {
                    if ((i & 4) != 0) {
                        num = null;
                    }
                    router.showEditObjectsScreen(categoryParameters, objectsParameter, num);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showEditObjectsScreen");
            }
        }

        void onEditClicked();

        void showEditObjectsScreen(@NotNull CategoryParameters categoryParameters, @NotNull ObjectsParameter objectsParameter, @Nullable Integer num);

        @Override // com.avito.android.publish.details.PublishDetailsPresenter.Router
        void showResidentialComplexSuggestScreen();
    }

    void attachRouter(@NotNull Router router);

    void onAddMoreObjectsClicked(@NotNull ParameterElement.Objects objects);

    void onElementObjectClicked(@NotNull ParameterElement.Objects objects, int i);
}
