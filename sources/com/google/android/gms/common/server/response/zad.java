package com.google.android.gms.common.server.response;

import androidx.annotation.Nullable;
import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;
public final class zad implements FastParser.zaa<Boolean> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.server.response.FastParser.zaa
    @Nullable
    public final /* synthetic */ Boolean zaa(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        return Boolean.valueOf(FastParser.zaa(fastParser, bufferedReader, false));
    }
}
