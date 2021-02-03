# Kekan瀏覽器
這是一款使用Java寫的Android APP，這是一款功能極強的網頁瀏覽器，目前也正在維護中，也有在定時更新。<br>
目前功能:<br>
1.輸入網址
2.載入JavaScript(設定)
3.啟用HTML5資料儲存(設定)
4.自動調整螢幕大小(設定)
5.啟用縮放(設定)
6.工程模式(設定)

[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger)

## 如何編譯 How to Compile
由於Android-Studio 或是其他IDE已將javac內含至此，所以只須執行就會自動編譯並執行。
### 編譯 Compile:

**Step 1.**``git clone https://github.com/mmm25002500/kesan``

**Step 2.** 打開Android-Studio

**Step 3.** 打開專案 Open Project

Step 4.Run

### 安裝 Install:

``adb install release.apk``

### 心得與建構思路:
這是我利用課餘時間使用Android Studio 利用Java寫出來的一個網頁瀏覽器，雖然目前功能只有瀏覽網頁，但我會持續將這個APP加入更多功能，優化效能，釋放記憶體，讓這一款瀏覽器可以與別人做出區隔。<br>
這我使用了兩個Activity完成的，第一個MainActivity是放置主畫面，第二個Activity是設定頁面，在activity_main.xml當中，我使用了LinearLayout將webview和btnSetting和另一個LinearLayout放在一起，另一個LinearLayout中放置搜尋和輸入網址功能，在輸入網址功能我自動在程式背後加入「http://」，這麼一來就不用手動輸入「http://」或是「https://」，可以更快到達想要去的網頁，在設定功能當中使用Intent來達成頁面疊加以及傳值，在兩個Java檔當中，我大量使用「OOP」，也就是「物件導向」，也使用了大量的方法，例如：「loadSetting() , startReadURL()...」，在設定的頁面當中，有「是否啟用載入JavaScript」，「是否啟用HTML5資料儲存」，「是否自動調整螢幕大小」...等等的。

## 關於我們 About Us

[Team Website](www.tershi.ml) <br>
[Team Facebook](https://www.facebook.com/shanling.team/) <br>
[XiaTerShi YouTube](https://www.youtube.com/channel/UCPdpFDFOp3sPbZhRkaQVaQA) <br>
[XiaTerShi FaceBook](https://www.facebook.com/Tershi25648) <br>
[Tershi MailServer](https://mail.tershi.ml) <br>
[Tershi Official WebSite](https://official.tershi.ml) <br>
[Tershi Gitbook](https://gitbook.tershi.ml) <br>
以上關於因為域名為免費域 因此隨時會網域更換！ <br>
Licence:© Tershi 2020 All right reversed 此程式除了「關於」頁面不可重製及發布之外，其餘頁面及功能可進行重製發布。
