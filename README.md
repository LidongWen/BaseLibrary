# BaseLibrary
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
	        compile 'com.github.LidongWen:BaseLibrary:1.0.4'
	}
  ```
  
  ## 通用网络引擎
  **网络引擎框架，API调用不变，悄无声息切换底层网络技术**
  封装自己的调用方式，随时一键切换网络技术，实现网络技术的更新交替
  <img width="320" height="500" src="https://github.com/LidongWen/BaseLibrary/blob/master/doc/httpUml.png"></img> 
  
  如上所示 可以创建    `OkHttpEngine，VolleyHttpEngine ,HttpClientEngine...` 都是实现`IHttpEngine`接口

  在Appcation内 选择网络  
   ```HttpUtils.initHttpEngine(new XXXXXXHttpEngine());```
  使用：
  ```
          //网络请求
          HttpUtils.getInstance().post()
                  .url("xxxxxx")
                  .addParam("param1", "param1")
                  .addParam("param2", "param2")
                  .build()
                  .execute(new EngineCallBack<BaseDataModel>() {
                      @Override
                      public void onError(Exception e, int id) {
                         ...
                      }
  
                      @Override
                      public void onResponse(BaseDataModel response, int id) {
                         ...
                      }
                  });
  
          HttpUtils.getInstance().post().url("https:xxxx.img")
                  .build()
                  .execute(new FileCallBack(directory, name) {
                        public void onResponse(File response, int id) {
                            ...
                        }
                        @Override
                        public void onError(Exception e, int id) {
                            ...
                        }
                        @Override
                        public void inProgress(float progress, long total, int id) {
                            ...
                        }
                  });
  ```


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

