package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    public static final a f = new a();
    public static final b g = new b();
    public final Context a;
    public final List<ImageHeaderParser> b;
    public final b c;
    public final a d;
    public final GifBitmapProvider e;

    @VisibleForTesting
    public static class a {
    }

    @VisibleForTesting
    public static class b {
        public final Queue<GifHeaderParser> a = Util.createQueue(0);
    }

    public ByteBufferGifDecoder(Context context) {
        this(context, Glide.get(context).getRegistry().getImageHeaderParsers(), Glide.get(context).getBitmapPool(), Glide.get(context).getArrayPool());
    }

    @Nullable
    public final GifDrawableResource a(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        Bitmap.Config config;
        int i3;
        String str = "BufferGifDecoder";
        long logTime = LogTime.getLogTime();
        int i4 = 2;
        try {
            GifHeader parseHeader = gifHeaderParser.parseHeader();
            if (parseHeader.getNumFrames() > 0) {
                if (parseHeader.getStatus() == 0) {
                    if (options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    int min = Math.min(parseHeader.getHeight() / i2, parseHeader.getWidth() / i);
                    if (min == 0) {
                        i3 = 0;
                    } else {
                        i3 = Integer.highestOneBit(min);
                    }
                    int max = Math.max(1, i3);
                    if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
                        parseHeader.getWidth();
                        parseHeader.getHeight();
                    }
                    a aVar = this.d;
                    GifBitmapProvider gifBitmapProvider = this.e;
                    Objects.requireNonNull(aVar);
                    StandardGifDecoder standardGifDecoder = new StandardGifDecoder(gifBitmapProvider, parseHeader, byteBuffer, max);
                    standardGifDecoder.setDefaultBitmapConfig(config);
                    standardGifDecoder.advance();
                    Bitmap nextFrame = standardGifDecoder.getNextFrame();
                    if (nextFrame == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            LogTime.getElapsedMillis(logTime);
                        }
                        return null;
                    }
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.a, standardGifDecoder, UnitTransformation.get(), i, i2, nextFrame));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        LogTime.getElapsedMillis(logTime);
                    }
                    return gifDrawableResource;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable(str, i4)) {
                LogTime.getElapsedMillis(logTime);
            }
        }
    }

    public GifDrawableResource decode(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Options options) {
        GifHeaderParser data;
        b bVar = this.c;
        synchronized (bVar) {
            GifHeaderParser poll = bVar.a.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            data = poll.setData(byteBuffer);
        }
        try {
            GifDrawableResource a3 = a(byteBuffer, i, i2, data, options);
            b bVar2 = this.c;
            synchronized (bVar2) {
                data.clear();
                bVar2.a.offer(data);
            }
            return a3;
        } catch (Throwable th) {
            b bVar3 = this.c;
            synchronized (bVar3) {
                data.clear();
                bVar3.a.offer(data);
                throw th;
            }
        }
    }

    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        return !((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        b bVar = g;
        a aVar = f;
        this.a = context.getApplicationContext();
        this.b = list;
        this.d = aVar;
        this.e = new GifBitmapProvider(bitmapPool, arrayPool);
        this.c = bVar;
    }
}
