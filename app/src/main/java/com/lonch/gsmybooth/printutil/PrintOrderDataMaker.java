package com.lonch.gsmybooth.printutil;

import android.content.Context;

import com.lonch.gsmybooth.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * 测试数据生成器
 * Created by ldx on 2018/4/26.
 */

public class PrintOrderDataMaker implements PrintDataMaker {


    private String qr;
    private int width;
    private int height;
    Context btService;

    public PrintOrderDataMaker(Context btService, String qr, int width, int height) {
        this.qr = qr;
        this.width = width;
        this.height = height;
        this.btService = btService;
    }


    @Override
    public List<byte[]> getPrintData(int type) {
        ArrayList<byte[]> data = new ArrayList<>();

        try {
            PrinterWriter printer;
            printer = type == PrinterWriter58mm.TYPE_58 ? new PrinterWriter58mm(height, width) : new PrinterWriter80mm(height, width);
            printer.setAlignCenter();
            data.add(printer.getDataAndReset());

            //设置二维码
            ArrayList<byte[]> image1 = printer.getImageByte(btService.getResources(), R.drawable.a1);

            data.addAll(image1);

            printer.setAlignLeft();
            printer.printLine();//线
            printer.printLineFeed();

            //公司名称
            printer.printLineFeed();//换行
            printer.setAlignCenter();//居中
            printer.setEmphasizedOn();
            printer.setFontSize(1);
            printer.print("致医健康");
            printer.printLineFeed();
            printer.setEmphasizedOff();
//            printer.printLineFeed();

            //订单编号
            printer.printLineFeed();
            printer.setFontSize(0);
            printer.setAlignCenter();
            printer.print("订单编号：" + "1234567890987654321");
            printer.printLineFeed();

            //打印时间
            printer.setAlignCenter();
            printer.print(new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault())
                    .format(new Date(System.currentTimeMillis())));
            printer.printLineFeed();
            printer.printLine();

//            printer.printLineFeed();
//            printer.setAlignLeft();
//            printer.print("订单状态: " + "已接单");
//            printer.printLineFeed();
//            printer.print("用户昵称: " + "周末先生");
//            printer.printLineFeed();
//            printer.print("用餐人数: " + "10人");
//            printer.printLineFeed();
//            printer.print("用餐桌号:" + "A3" + "号桌");
//            printer.printLineFeed();
//            printer.print("预定时间：" + "2017-10-1 17：00");
//            printer.printLineFeed();
//            printer.print("预留时间：30分钟");
//            printer.printLineFeed();
//            printer.print("联系方式：" + "18094111545454");
//            printer.printLineFeed();
//            printer.printLine();
//            printer.printLineFeed();
//
//            printer.setAlignLeft();
//            printer.print("备注：" + "记得留位置");
//            printer.printLineFeed();
//            printer.printLine();
//
//            printer.printLineFeed();
//
//            printer.setAlignCenter();
//            printer.print("菜品信息");
//            printer.printLineFeed();
//            printer.setAlignCenter();
//            printer.printInOneLine("菜名", "数量", "单价", 0);
//            printer.printLineFeed();
//            for (int i = 0; i < 3; i++) {
//
//                printer.printInOneLine("干锅包菜", "X" + 3, "￥" + 30, 0);
//                printer.printLineFeed();
//            }
//            printer.printLineFeed();
//            printer.printLine();
//            printer.printLineFeed();
//            printer.setAlignLeft();
//            printer.printInOneLine("菜品总额：", "￥" + 100, 0);
//
//
            printer.setAlignLeft();
            printer.printInOneLine("优惠金额：", "￥" + "0.00"
                    , 0);
            printer.printLineFeed();

            printer.setAlignLeft();
            printer.printInOneLine("订金/退款：", "￥" + "0.00"
                    , 0);
            printer.printLineFeed();


            printer.setAlignLeft();
            printer.printInOneLine("总计金额：", "￥" + 90, 0);
            printer.printLineFeed();

            printer.printLine();
            printer.printLineFeed();
            printer.setAlignRight();
//            printer.setAlignCenter();
            printer.print("北京致医健康信息技术有限公司");
            printer.printLineFeed();
            printer.printLineFeed();
            printer.printLineFeed();
            printer.printLineFeed();
            printer.feedPaperCutPartial();

            data.add(printer.getDataAndClose());
            return data;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


}
