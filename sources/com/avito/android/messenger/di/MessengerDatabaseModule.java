package com.avito.android.messenger.di;

import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.UserDataStore;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessengerDatabase;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/di/MessengerDatabaseModule;", "", "Landroid/app/Application;", "avitoApp", "Lru/avito/android/persistence/messenger/MessengerDatabase;", "provideMessengerDatabase", "(Landroid/app/Application;)Lru/avito/android/persistence/messenger/MessengerDatabase;", "<init>", "()V", AuthSource.SEND_ABUSE, "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class MessengerDatabaseModule {
    @NotNull
    public static final MessengerDatabaseModule INSTANCE = new MessengerDatabaseModule();

    public static final class a extends RoomDatabase.Callback {
        @NotNull
        public static final a a = new a();

        @Override // androidx.room.RoomDatabase.Callback
        public void onDestructiveMigration(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `channel_user`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `messages`");
            super.onDestructiveMigration(supportSQLiteDatabase);
        }
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final MessengerDatabase provideMessengerDatabase(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "avitoApp");
        RoomDatabase build = Room.databaseBuilder(application, MessengerDatabase.class, MessengerDatabaseModuleKt.MESSENGER_DATABASE_NAME).addCallback(a.a).fallbackToDestructiveMigration().build();
        Intrinsics.checkNotNullExpressionValue(build, "Room.databaseBuilder(avi…on()\n            .build()");
        return (MessengerDatabase) build;
    }
}
