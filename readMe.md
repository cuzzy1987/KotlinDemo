kotlin

    1. 原生控件 RecyclerView ViewPage TabLayout
    2. 原生网络访问 anko协程 线程切换
    3. android pie 不被允许明文网络服务 需配置网络安全文件 或降级使用或使用https
    

cautions 

    0. ? 变量是否可以为空  !!变量不可以为空  A?: B表示当对象值为null时那么会返回对象B

    1. kotlin anko 不可以在Fragment OnCreateView中直接使用控件名 （fvb）
    
    2. kotlin 不再支持三目运算 可转化为 if else处理 在两者作用域内 默认条件成立（有点实用）
    
    3. 关键字 apply Calls the specified function [block] with `this` value as its receiver and returns `this` value.
    
    4. startActivity<SomeOtherActivity>(
           "id" to 5,
           "city" to "Denpasar"
       ) @anko  
           
    @des 关于 anko 的一些介绍 https://www.jianshu.com/p/c4558aa7c502
    @more https://github.com/Kotlin/anko/wiki/Anko-Commons-%E2%80%93-Dialogs



note 

    0. 监听应用内截屏 可收集文件名  
    1. manifest https://blog.csdn.net/maosidiaoxian/article/details/42671999
    2. glide提高图片质量的方法 
       i. 全局设置 提高所有图片质量 
          public class MyGlideModule implements GlideModule{  
              @Override  
              public void applyOptions(Context context, GlideBuilder builder) {  
                  builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);  
              }    
              @Override  
              public void registerComponents(Context context, Glide glide) {  
          
              }  
          }
          
          添加在清单文件 mete-data下 
          <meta-data  
              android:name="youpackagename.MyGlideModule "  
              android:value="GlideModule"/>
          
       i. Glide.with(context).load(url).asBitmap().format(PREFER_ARGB_8888)


ContextWrapper 装饰者模式

    1. 通过把 被装饰对象 作为 装饰器 的成员变量 
       当调用装饰器的操作时 装饰器还是会调用被装饰的对象的操作
       但是装饰器可以给对应的操作添加相关功能
       
       
