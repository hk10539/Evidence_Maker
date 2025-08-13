package org.evidencemaker;

import org.evidencemaker.frame.Frame;

public class Main {
    public static void main(String[] args) {
        try {
            Frame.frame();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}