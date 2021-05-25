package com.my.target;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public interface is {

    public interface a {
        void A();

        void B();

        void C();

        void D();

        void a(float f, float f2);

        void d(float f);

        void e(String str);

        void onVideoCompleted();

        void y();

        void z();
    }

    void M();

    void N();

    void a(@NonNull Uri uri, @NonNull Context context);

    void a(@Nullable fq fqVar);

    void a(@Nullable a aVar);

    void da();

    void destroy();

    void dk();

    void fl();

    long getPosition();

    @Nullable
    Uri getUri();

    boolean isMuted();

    boolean isPaused();

    boolean isPlaying();

    boolean isStarted();

    void pause();

    void resume();

    void seekTo(long j);

    void setVolume(float f);

    void stop();
}
