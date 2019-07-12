package com.n0texpecterr0r.classdecoder.attribute;

import com.n0texpecterr0r.classdecoder.constantpool.CpInfo;

import java.io.DataInputStream;
import java.io.IOException;

public class LineNumberAttribute extends AttributeInfo {
    private short lineNumberTableLength;
    private LineNumberInfo[] lineNumberTable;

    @Override
    public void read(DataInputStream in) throws IOException {
        lineNumberTableLength = in.readShort();
        lineNumberTable = new LineNumberInfo[lineNumberTableLength];
        for (int i = 0; i < lineNumberTableLength; i++) {
            lineNumberTable[i] = LineNumberInfo.read(in);
        }
    }
}
