# BaseLibrary

放一些基类的东西，几乎都是能帮助快速开发的。。。个人使用
 
>  - 引用 
>  - 万能 dialog
>  - 万能popuwindow
>  - 万能布局
>  - mvp Activity，MVPFragment 模板,以及模板生成工具
> 

#### 引用
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```
	dependencies {
	        compile 'com.github.LidongWen:BaseLibrary:1.0.6'
	}
  ```
  
#### mvpActivity模板下载以及使用
 1. [mvpActivity模板下载]( https://github.com/LidongWen/BaseLibrary/blob/master/doc/MVPActivity(New).rar);
 2. 解压在目录： ../android-studio\plugins\android\lib\templates\activities   
  ![](https://github.com/LidongWen/BaseLibrary/blob/master/doc/template_1.png)
 3. 使用：
  ![](https://github.com/LidongWen/BaseLibrary/blob/master/doc/template_2.png)  ![](https://github.com/LidongWen/BaseLibrary/blob/master/doc/template_3.png)
  
  1. [mvpFragment模板下载](https://github.com/LidongWen/BaseLibrary/blob/master/doc/MVP2Fragment.rar)
  2. 解压到：../android-studio\plugins\android\lib\templates\other
  3. 使用：  
   ![](https://github.com/LidongWen/BaseLibrary/blob/master/doc/template_mvp_1.png)


> ### V 1.0.6
> MVP基类
> 新增 万能 PopupWindow
> ### V 1.0.5
> 第一版 http 引擎bug修改
> http引擎回调修改
> ### V 1.0.4
> 第一版 http 引擎使用
  > ### V 1.0.3
  > 万能layout加载器 代码优化
> ### V 1.0.2
> 新增 万能layout加载器
> ### V 1.0.1
> 新增 万能Dialog、 懒加载Fragment、http请求封装规范
> ###  V 1.0.0
>  万能头部

