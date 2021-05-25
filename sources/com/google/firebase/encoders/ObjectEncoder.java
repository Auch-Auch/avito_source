package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;
public interface ObjectEncoder<T> {
    /* synthetic */ void encode(@NonNull TValue tvalue, @NonNull TContext tcontext) throws IOException;
}
