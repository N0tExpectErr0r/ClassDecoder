package com.n0texpecterr0r.classdecoder.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public class LineNumberInfo {
    private short startPc;
    private short lineNumber;

    public short getStartPc() {
        return startPc;
    }

    public short getLineNumber() {
        return lineNumber;
    }

    public static LineNumberInfo read(DataInputStream in) throws IOException {
        LineNumberInfo lineNumber = new LineNumberInfo();
        lineNumber.startPc = in.readShort();
        lineNumber.lineNumber = in.readShort();
        return lineNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append("line ").append(lineNumber).append(": ").append(startPc);
        return sb.toString();
    }
}
