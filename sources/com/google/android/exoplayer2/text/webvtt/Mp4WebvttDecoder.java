package com.google.android.exoplayer2.text.webvtt;

import a2.j.b.b.a1.j.d;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder {
    public final ParsableByteArray o = new ParsableByteArray();

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        Cue cue;
        this.o.reset(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.o.bytesLeft() > 0) {
            if (this.o.bytesLeft() >= 8) {
                int readInt = this.o.readInt();
                if (this.o.readInt() == 1987343459) {
                    ParsableByteArray parsableByteArray = this.o;
                    int i2 = readInt - 8;
                    CharSequence charSequence = null;
                    Cue.Builder builder = null;
                    while (i2 > 0) {
                        if (i2 >= 8) {
                            int readInt2 = parsableByteArray.readInt();
                            int readInt3 = parsableByteArray.readInt();
                            int i3 = readInt2 - 8;
                            String fromUtf8Bytes = Util.fromUtf8Bytes(parsableByteArray.getData(), parsableByteArray.getPosition(), i3);
                            parsableByteArray.skipBytes(i3);
                            i2 = (i2 - 8) - i3;
                            if (readInt3 == 1937011815) {
                                WebvttCueParser.e eVar = new WebvttCueParser.e();
                                WebvttCueParser.e(fromUtf8Bytes, eVar);
                                builder = eVar.a();
                            } else if (readInt3 == 1885436268) {
                                charSequence = WebvttCueParser.f(null, fromUtf8Bytes.trim(), Collections.emptyList());
                            }
                        } else {
                            throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
                        }
                    }
                    if (charSequence == null) {
                        charSequence = "";
                    }
                    if (builder != null) {
                        cue = builder.setText(charSequence).build();
                    } else {
                        Pattern pattern = WebvttCueParser.CUE_HEADER_PATTERN;
                        WebvttCueParser.e eVar2 = new WebvttCueParser.e();
                        eVar2.c = charSequence;
                        cue = eVar2.a().build();
                    }
                    arrayList.add(cue);
                } else {
                    this.o.skipBytes(readInt - 8);
                }
            } else {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new d(arrayList);
    }
}
