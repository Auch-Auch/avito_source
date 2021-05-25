package com.avito.android.publish.details.di;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.html_editor.EditorHistoryProvider;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.SubmissionPresenter;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.validate_advert.remote.ValidateAdvertApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H&¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H&¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H&¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H&¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H&¢\u0006\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/avito/android/publish/details/di/PublishDetailsDependencies;", "", "Lcom/avito/android/remote/PublishLimitsApi;", "publishLimitsApi", "()Lcom/avito/android/remote/PublishLimitsApi;", "Lcom/avito/android/validate_advert/remote/ValidateAdvertApi;", "validateAdvertApi", "()Lcom/avito/android/validate_advert/remote/ValidateAdvertApi;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "()Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "()Lcom/avito/android/account/AccountStorageInteractor;", "Lcom/avito/android/publish/SubmissionPresenter;", "submissionPresenter", "()Lcom/avito/android/publish/SubmissionPresenter;", "Lcom/avito/android/publish/ProfileSourceInteractor;", "profileSource", "()Lcom/avito/android/publish/ProfileSourceInteractor;", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "computerVisionInteractor", "()Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "publishDraftWiper", "()Lcom/avito/android/publish/drafts/PublishDraftWiper;", "Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;", "attributesConverter", "()Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "()Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "Lcom/avito/android/analytics/screens/TimerFactory;", "timerFactory", "()Lcom/avito/android/analytics/screens/TimerFactory;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers3", "()Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "()Lcom/avito/android/html_formatter/HtmlRenderer;", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "()Lcom/avito/android/html_formatter/HtmlCleaner;", "Lcom/avito/android/html_editor/EditorHistoryProvider;", "editorHistoryProvider", "()Lcom/avito/android/html_editor/EditorHistoryProvider;", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishDetailsDependencies {
    @NotNull
    AccountStorageInteractor accountStorageInteractor();

    @NotNull
    AttributesTreeConverter attributesConverter();

    @NotNull
    BuildInfo buildInfo();

    @NotNull
    ComputerVisionInteractor computerVisionInteractor();

    @NotNull
    DeepLinkFactory deepLinkFactory();

    @NotNull
    EditorHistoryProvider editorHistoryProvider();

    @NotNull
    HtmlCleaner htmlCleaner();

    @NotNull
    HtmlRenderer htmlRenderer();

    @NotNull
    ProfileSourceInteractor profileSource();

    @NotNull
    PublishDraftWiper publishDraftWiper();

    @NotNull
    PublishLimitsApi publishLimitsApi();

    @NotNull
    SchedulersFactory3 schedulers3();

    @NotNull
    ScreenTrackerFactory screenTrackerFactory();

    @NotNull
    SubmissionPresenter submissionPresenter();

    @NotNull
    TimerFactory timerFactory();

    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();

    @NotNull
    ValidateAdvertApi validateAdvertApi();
}
