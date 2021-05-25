package com.avito.android.express_cv.existed_cv.di;

import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.express_cv.ExistedCvDataProvider;
import com.avito.android.express_cv.existed_cv.item.CvItemClickListener;
import com.avito.android.express_cv.existed_cv.item.DisclaimerBlueprint;
import com.avito.android.express_cv.existed_cv.item.FlatButtonBlueprint;
import com.avito.android.express_cv.existed_cv.item.TextItemBlueprint;
import com.avito.android.util.DeviceMetrics;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/express_cv/existed_cv/di/ExistedCvComponentDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/express_cv/ExistedCvDataProvider;", "existedCvDataProvider", "()Lcom/avito/android/express_cv/ExistedCvDataProvider;", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "Lcom/avito/android/express_cv/existed_cv/item/TextItemBlueprint;", "textItemBlueprint", "()Lcom/avito/android/express_cv/existed_cv/item/TextItemBlueprint;", "Lcom/avito/android/express_cv/existed_cv/item/DisclaimerBlueprint;", "disclaimerBlueprint", "()Lcom/avito/android/express_cv/existed_cv/item/DisclaimerBlueprint;", "Lcom/avito/android/express_cv/existed_cv/item/FlatButtonBlueprint;", "flatButtonBlueprint", "()Lcom/avito/android/express_cv/existed_cv/item/FlatButtonBlueprint;", "Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", "buttonItemPresenterListener", "()Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", "Lcom/avito/android/express_cv/existed_cv/item/CvItemClickListener;", "cvItemClickListener", "()Lcom/avito/android/express_cv/existed_cv/item/CvItemClickListener;", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public interface ExistedCvComponentDependencies extends ComponentDependencies {
    @NotNull
    ButtonItemPresenter.Listener buttonItemPresenterListener();

    @NotNull
    CvItemClickListener cvItemClickListener();

    @NotNull
    DeviceMetrics deviceMetrics();

    @NotNull
    DisclaimerBlueprint disclaimerBlueprint();

    @NotNull
    ExistedCvDataProvider existedCvDataProvider();

    @NotNull
    FlatButtonBlueprint flatButtonBlueprint();

    @NotNull
    TextItemBlueprint textItemBlueprint();
}
