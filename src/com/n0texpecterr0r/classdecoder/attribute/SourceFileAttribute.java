package com.n0texpecterr0r.classdecoder.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public class SourceFileAttribute extends AttributeInfo {
    private short sourceFileIndex;

    public short getSourceFileIndex() {
        return sourceFileIndex;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        sourceFileIndex = in.readShort();
    }
}
