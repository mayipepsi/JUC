package com.mashibing.juc.c_021_03_VarHandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class T01_HelloVarHandle {

    int x = 8;
    private static VarHandle varHandle;

    static {
        try {
          varHandle =   MethodHandles.lookup().findVarHandle(T01_HelloVarHandle.class, "x", int.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        T01_HelloVarHandle handle = new T01_HelloVarHandle();
        System.out.println(varHandle.get(handle));
        varHandle.compareAndSet( handle,7, 9);
        System.out.println(handle.x);

    }
}
