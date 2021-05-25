package com.avito.android.publish.drafts.di;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Looper;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.app.work.PublishDraftsSyncWorkFactory;
import com.avito.android.app.work.PublishDraftsSyncWorkFactoryImpl;
import com.avito.android.di.module.publish.PublishDraftUpdateObservable;
import com.avito.android.photo_picker.legacy.DraftIdProvider;
import com.avito.android.photo_picker.legacy.DraftIdProviderImpl;
import com.avito.android.photo_picker.legacy.DraftPhotosWiper;
import com.avito.android.photo_picker.legacy.DraftPhotosWiperImpl;
import com.avito.android.photo_picker.legacy.PhotoInteractorImpl;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractorImpl;
import com.avito.android.photo_picker.legacy.service.UploadingInteractorImpl;
import com.avito.android.publish.PhotoSyncDelegateImpl;
import com.avito.android.publish.PhotoUploadObserverImpl;
import com.avito.android.publish.drafts.LocalDraft;
import com.avito.android.publish.drafts.PublishDraftAvailabilityChecker;
import com.avito.android.publish.drafts.PublishDraftAvailabilityCheckerImpl;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftRepositoryImpl;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.PublishDraftWiperImpl;
import com.avito.android.publish.drafts.PublishMessageHandler;
import com.avito.android.publish.drafts.PublishMessageHandlerImpl;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGeneratorImpl;
import com.avito.android.publish.drafts.db.LocalDraftTypeAdapter;
import com.avito.android.publish.drafts.db.PublishDraftsDaoImpl;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.AttributeNode;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.remote.parse.adapter.AttributeNodeDeserializer;
import com.avito.android.remote.parse.adapter.AttributeNodeSerializer;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.PrivatePhotosStorageImpl;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Names;
import com.avito.android.util.preferences.PreferenceFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJq\u0010\"\u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u000e\b\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b*\u0010+J%\u00101\u001a\u0002002\u0006\u0010-\u001a\u00020,2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020!0.H\u0007¢\u0006\u0004\b1\u00102J'\u00103\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b3\u00104J\u001d\u00107\u001a\u0002062\f\u00105\u001a\b\u0012\u0004\u0012\u00020!0.H\u0007¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b9\u0010:J'\u0010@\u001a\u00020?2\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/avito/android/publish/drafts/di/PublishDraftsModule;", "", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "provideCategoryParametersConverter", "()Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "", "providePublishDraftUpdateObservable", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;", "provideAttributesTreeConverter", "()Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;", "Lcom/google/gson/Gson;", "provideStreamGson", "()Lcom/google/gson/Gson;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "gson", "Lcom/avito/android/remote/PublishApi;", "publishApi", "categoryParametersConverter", "attributesTreeConverter", "Lcom/avito/android/app/work/PublishDraftsSyncWorkFactory;", "draftsSyncWorker", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "draftUpdateConsumer", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "providePublishDraftRepository", "(Landroid/app/Application;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/util/preferences/PreferenceFactory;Lcom/google/gson/Gson;Lcom/avito/android/remote/PublishApi;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;Lcom/avito/android/app/work/PublishDraftsSyncWorkFactory;Lcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/util/SchedulersFactory;Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/publish/drafts/PublishDraftRepository;", "Lcom/avito/android/photo_picker/legacy/DraftIdProvider;", "provideDraftIdProvider", "()Lcom/avito/android/photo_picker/legacy/DraftIdProvider;", "Landroid/content/Context;", "context", "Lcom/avito/android/publish/drafts/PublishMessageHandler;", "provideMessageHandler", "(Landroid/content/Context;)Lcom/avito/android/publish/drafts/PublishMessageHandler;", "Lcom/avito/android/photo_picker/legacy/DraftPhotosWiper;", "draftPhotosWiper", "Ldagger/Lazy;", "publishDraftRepository", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "providePublishDraftWiper", "(Lcom/avito/android/photo_picker/legacy/DraftPhotosWiper;Ldagger/Lazy;)Lcom/avito/android/publish/drafts/PublishDraftWiper;", "provideDraftWiper", "(Landroid/app/Application;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/photo_picker/legacy/DraftPhotosWiper;", "publishDraftRepositoryLazy", "Lcom/avito/android/publish/drafts/PublishDraftAvailabilityChecker;", "providePublishDraftAvailabilityChecker", "(Ldagger/Lazy;)Lcom/avito/android/publish/drafts/PublishDraftAvailabilityChecker;", "providePublishDraftsSyncWorkFactory", "(Landroid/content/Context;)Lcom/avito/android/app/work/PublishDraftsSyncWorkFactory;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "provideAdvertIdGenerator", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/remote/DeviceIdProvider;)Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "<init>", "()V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublishDraftsModule {
    @NotNull
    public static final PublishDraftsModule INSTANCE = new PublishDraftsModule();

    public static final class a extends Lambda implements Function1<String, PhotoSyncDelegateImpl> {
        public final /* synthetic */ Application a;
        public final /* synthetic */ BuildInfo b;
        public final /* synthetic */ SchedulersFactory c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Application application, BuildInfo buildInfo, SchedulersFactory schedulersFactory) {
            super(1);
            this.a = application;
            this.b = buildInfo;
            this.c = schedulersFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PhotoSyncDelegateImpl invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "draftId");
            UploadingInteractorImpl uploadingInteractorImpl = new UploadingInteractorImpl(this.a, str2, false, 4, null);
            Looper mainLooper = this.a.getMainLooper();
            Intrinsics.checkNotNullExpressionValue(mainLooper, "application.mainLooper");
            BuildInfo buildInfo = this.b;
            ContentResolver contentResolver = this.a.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
            return new PhotoSyncDelegateImpl(uploadingInteractorImpl, new PhotoUploadObserverImpl(new UploadingProgressInteractorImpl(str2, new PhotoInteractorImpl(mainLooper, buildInfo, contentResolver, null, 8, null), this.c), this.c), this.c);
        }
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final PublishSessionIdGenerator provideAdvertIdGenerator(@NotNull TimeSource timeSource, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull DeviceIdProvider deviceIdProvider) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        return new PublishSessionIdGeneratorImpl(timeSource, accountStorageInteractor, deviceIdProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final AttributesTreeConverter provideAttributesTreeConverter() {
        return new AttributesTreeConverter(null, null, null, null, 15, null);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final CategoryParametersConverter provideCategoryParametersConverter() {
        return new CategoryParametersConverter(null, null, null, 7, null);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final DraftIdProvider provideDraftIdProvider() {
        return new DraftIdProviderImpl();
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final DraftPhotosWiper provideDraftWiper(@NotNull Application application, @NotNull BuildInfo buildInfo, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Looper mainLooper = application.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "application.mainLooper");
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
        return new DraftPhotosWiperImpl(new PhotoInteractorImpl(mainLooper, buildInfo, contentResolver, null, 8, null), new PrivatePhotosStorageImpl(application), schedulersFactory);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final PublishMessageHandler provideMessageHandler(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PublishMessageHandlerImpl(context);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final PublishDraftAvailabilityChecker providePublishDraftAvailabilityChecker(@NotNull Lazy<PublishDraftRepository> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "publishDraftRepositoryLazy");
        return new PublishDraftAvailabilityCheckerImpl(lazy);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final PublishDraftRepository providePublishDraftRepository(@NotNull Application application, @NotNull BuildInfo buildInfo, @NotNull PreferenceFactory preferenceFactory, @PublishDraftsGson @NotNull Gson gson, @NotNull PublishApi publishApi, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull AttributesTreeConverter attributesTreeConverter, @NotNull PublishDraftsSyncWorkFactory publishDraftsSyncWorkFactory, @NotNull DeviceIdProvider deviceIdProvider, @NotNull SchedulersFactory schedulersFactory, @PublishDraftUpdateObservable @NotNull PublishRelay<String> publishRelay) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "categoryParametersConverter");
        Intrinsics.checkNotNullParameter(attributesTreeConverter, "attributesTreeConverter");
        Intrinsics.checkNotNullParameter(publishDraftsSyncWorkFactory, "draftsSyncWorker");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishRelay, "draftUpdateConsumer");
        return new PublishDraftRepositoryImpl(publishApi, new PublishDraftsDaoImpl(preferenceFactory.getCustomPreferences(application, Names.PUBLISH_DRAFTS), gson), categoryParametersConverter, attributesTreeConverter, publishDraftsSyncWorkFactory, deviceIdProvider, schedulersFactory, publishRelay, new a(application, buildInfo, schedulersFactory));
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    @PublishDraftUpdateObservable
    public static final PublishRelay<String> providePublishDraftUpdateObservable() {
        PublishRelay<String> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final PublishDraftWiper providePublishDraftWiper(@NotNull DraftPhotosWiper draftPhotosWiper, @NotNull Lazy<PublishDraftRepository> lazy) {
        Intrinsics.checkNotNullParameter(draftPhotosWiper, "draftPhotosWiper");
        Intrinsics.checkNotNullParameter(lazy, "publishDraftRepository");
        return new PublishDraftWiperImpl(draftPhotosWiper, lazy);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final PublishDraftsSyncWorkFactory providePublishDraftsSyncWorkFactory(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PublishDraftsSyncWorkFactoryImpl(context);
    }

    @PublishDraftsGson
    @Provides
    @JvmStatic
    @NotNull
    public static final Gson provideStreamGson() {
        GsonBuilder registerTypeAdapter = new GsonBuilder().registerTypeAdapter(LocalDraft.class, new LocalDraftTypeAdapter());
        Intrinsics.checkNotNullExpressionValue(registerTypeAdapter, "GsonBuilder()\n          … LocalDraftTypeAdapter())");
        registerTypeAdapter.registerTypeAdapter(AttributeNode.class, new AttributeNodeDeserializer());
        registerTypeAdapter.registerTypeAdapter(AttributeNode.class, new AttributeNodeSerializer());
        Gson create = registerTypeAdapter.create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder()\n          …())\n            .create()");
        return create;
    }
}
