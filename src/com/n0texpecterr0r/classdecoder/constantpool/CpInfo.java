package com.n0texpecterr0r.classdecoder.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class CpInfo {
    protected byte tag;

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public abstract void read(DataInputStream in) throws IOException;

    public abstract String toString(CpInfo[] constantPool);
}
