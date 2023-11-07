# TextImageView
a image to text view  
可以将文字转换成图片。  
一般来说是为了特殊字体，但仅有数字时存在。通过该类可以方便的将ui给的数字切图直接使用，使用方法类似于TextView。  


可用xml直接使用
```
 <com.simple.text.imageView.TextImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:aspectRatio="2.0"
        app:size="30sp"
        app:text="1.23333333"/>
```


也开放了对应的api接口
