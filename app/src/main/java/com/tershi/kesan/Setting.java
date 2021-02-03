package com.tershi.kesan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Setting extends AppCompatActivity implements View.OnClickListener {

    Switch loadJS ,loadHTML5DomStorage ,UseWideViewPort ,enableDisplayZoomControls ,enableSupportZoom ,openEngineMode;
    Button saveSetting ,cancelSetting;
    TextView isEngineModeOpen;
     static boolean[] codeB = new boolean[6];
    String pass = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        loadJS = (Switch) findViewById(R.id.loadJS);
        loadHTML5DomStorage = (Switch) findViewById(R.id.loadHTML5DomStorage);
        UseWideViewPort = (Switch) findViewById(R.id.UseWideViewPort);
        enableDisplayZoomControls = (Switch) findViewById(R.id.enableDisplayZoomControls);
        enableSupportZoom = (Switch) findViewById(R.id.enableSupportZoom);
        openEngineMode = (Switch) findViewById(R.id.openEngineMode);
        saveSetting = (Button) findViewById(R.id.saveSetting);
        cancelSetting = (Button) findViewById(R.id.cancelSetting);
        isEngineModeOpen  = (TextView) findViewById(R.id.isEngineModeOpen);

        saveSetting.setOnClickListener(this);
        cancelSetting.setOnClickListener(this);

//       readSettings();
        loadSettings();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.saveSetting:  //儲存
                write(convertToFiles(),"setting.config");
                finish();
            case R.id.cancelSetting:    //取消
                finish();
            //case: 更多onClick事件在這邊寫
        }
    }

    public String convertToFiles(){
        String engineText = "";
        if (loadJS.isChecked()){
           pass += "1";
           engineText += ",loadJS has opened";
        } else{
            pass +="0";
            engineText += ",loadJS has closed";
        }

        if (loadHTML5DomStorage.isChecked()) {
            pass += "1";
            engineText += ",loadHTML5DomStorage has opened";
        }else{
            pass +="0";
            engineText += ",loadHTML5DomStorage has closed";
        }

        if (UseWideViewPort.isChecked()){
            pass +="1";
            engineText += ",UseWideViewPort has opened";
        } else{
            pass += "0";
            engineText += ",UseWideViewPort has closed";
        }

        if (enableDisplayZoomControls.isChecked()){
            pass +="1";
            engineText += ",enableDisplayZoomControls has opened";
        }else{
            pass +="0";
            engineText += ",enableDisplayZoomControls has closed";
        }

        if (enableSupportZoom.isChecked()){
            pass +="1";
            engineText += ",enableSupportZoom has opened";
        } else{
            pass +="0";
            engineText += ",enableSupportZoom has closed";
        }
        if (openEngineMode.isChecked() == true){
            pass +="1";
            engineText += ",openEngineMode has opened";
            isEngineModeOpen.setText(engineText);
        } else {
            pass +="0";
            engineText += ",openEngineMode has closed";
            isEngineModeOpen.setText("");
        }
        return pass;
    }

    public String readSettings(){
        FileInputStream fis;
        BufferedReader reader=null;//這裡要初始化null
        StringBuilder builder=new StringBuilder();
        try{
            fis=openFileInput("setting.config");
            reader=new BufferedReader(new InputStreamReader(fis));
            String lines="";
            while((lines=reader.readLine())!=null){
                builder.append(lines);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
       isEngineModeOpen.setText(builder.toString());
        //write(builder.toString(),"debug.txt");
        return builder.toString();
    }
    public void write(String inputText ,String Files){
        FileOutputStream fos;
        BufferedWriter writer=null;//這裡要初始化一個null
        try{
            fos=openFileOutput(Files, Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(inputText);//這裡寫入引數
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(writer != null){
                    writer.close();//關閉字元緩衝輸出流
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void loadSettings(){
            String[] code = readSettings().split("");
            write(readSettings(),"debug.txt");
        isEngineModeOpen.setText("loadSettings:"+code[0]);

        if (code[0] == "1"){
            loadJS.setChecked(true);
            codeB[0] = true;
        }else{
            loadJS.setChecked(false);
            codeB[0] = false;
        }

        if (code[1] == "1"){
            loadHTML5DomStorage.setChecked(true);
            codeB[1] = true;
        }else{
            loadHTML5DomStorage.setChecked(false);
            codeB[1] = false;
        }

        if (code[2] == "1"){
            UseWideViewPort.setChecked(true);
            codeB[2] = true;
        }else{
            UseWideViewPort.setChecked(false);
            codeB[2] = false;
        }

        if (code[3] == "1"){
            enableDisplayZoomControls.setChecked(true);
            codeB[3] = true;
        }else{
            enableDisplayZoomControls.setChecked(false);
            codeB[3] = false;
        }

        if (code[4] == "1"){
            enableSupportZoom.setChecked(true);
            codeB[4] = true;
        }else{
            enableSupportZoom.setChecked(false);
            codeB[4] = false;
        }

        if (code[5] == "1"){
            openEngineMode.setChecked(true);
            codeB[5] = true;
        }else{
            openEngineMode.setChecked(false);
            codeB[5] = false;
        }
    }
}
