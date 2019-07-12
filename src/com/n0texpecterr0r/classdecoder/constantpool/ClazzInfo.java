package com.n0texpecterr0r.classdecoder.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class ClazzInfo extends CpInfo {
    private short nameIndex;

    public short getNameIndex() {
        return nameIndex;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        nameIndex = in.readShort();
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        return "ClassInfo\t#"+nameIndex+"\t// "+constantPool[nameIndex-1];
    }
}
