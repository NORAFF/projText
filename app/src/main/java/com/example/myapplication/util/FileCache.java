package com.example.myapplication.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FileCache {

    public static boolean writeTimeCache(Context context, String time){
        try {
            File f=new File(context.getFilesDir(),"info.txt");
            FileOutputStream fos=new FileOutputStream(f);
            fos.write((time).getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 获取保存的数据
     * @param context
     * @return
     */
    public static String getTimeCache(Context context){

        File f=new File(context.getFilesDir(),"info.txt");
        try {
            FileInputStream fis=new FileInputStream(f);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            String str=br.readLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
