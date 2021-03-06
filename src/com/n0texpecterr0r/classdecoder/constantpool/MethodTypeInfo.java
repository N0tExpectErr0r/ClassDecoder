package com.n0texpecterr0r.classdecoder.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodTypeInfo extends CpInfo {
    private short descriptorIndex;

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        descriptorIndex = in.readShort();
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        return "MethodTypeInfo\t#"+descriptorIndex+"\t// "+constantPool[descriptorIndex-1];
    }
}
