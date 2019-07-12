package com.n0texpecterr0r.classdecoder.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class LongInfo extends CpInfo {
    private long value;

    public long getValue() {
        return value;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        value = in.readLong();
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        return "LongInfo\t"+value;
    }
}
