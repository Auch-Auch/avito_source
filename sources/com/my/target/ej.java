package com.my.target;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public interface ej {

    public interface a {
        void a(@NonNull by byVar, @NonNull View view);

        void b(@Nullable by byVar, @Nullable String str, @NonNull Context context);

        void p();
    }

    @NonNull
    View cZ();

    void destroy();

    void pause();

    void resume();

    void stop();
}
