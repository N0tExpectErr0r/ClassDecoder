package com.n0texpecterr0r.classdecoder.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class NameAndTypeInfo extends CpInfo {
    private short nameIndex;
    private short descriptorIndex;

    public short getNameIndex() {
        return nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        nameIndex = in.readShort();
        descriptorIndex = in.readShort();
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        return "NameAndTypeInfo\t#"+nameIndex+":#"+descriptorIndex+"\t// "+constantPool[nameIndex-1]+":"+constantPool[descriptorIndex-1];
    }
}
