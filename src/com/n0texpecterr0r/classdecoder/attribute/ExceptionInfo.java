package com.n0texpecterr0r.classdecoder.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public class ExceptionInfo {
    private short startPc;
    private short endPc;
    private short handlerPc;
    private short catchType;

    public short getStartPc() {
        return startPc;
    }

    public short getEndPc() {
        return endPc;
    }

    public short getHandlerPc() {
        return handlerPc;
    }

    public short getCatchType() {
        return catchType;
    }

    public static ExceptionInfo read(DataInputStream in) throws IOException {
        ExceptionInfo exception = new ExceptionInfo();
        exception.startPc = in.readShort();
        exception.endPc = in.readShort();
        exception.handlerPc = in.readShort();
        exception.catchType = in.readShort();
        return exception;
    }
}
