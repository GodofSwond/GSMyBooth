package com.lonch.gsmybooth.printutil;

import java.util.List;

/**
 * Print
 * Created by ldx on 2018/4/26.
 */

public interface PrintDataMaker {
    List<byte[]> getPrintData(int type);
}
