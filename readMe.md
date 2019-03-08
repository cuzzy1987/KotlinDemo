kotlin

    1. 原生控件 RecyclerView ViewPage TabLayout
    2. 原生网络访问 anko协程 线程切换
    3. android pie 不被允许明文网络服务 需配置网络安全文件 或降级使用或使用https
    

cautions 

    1. kotlin anko 不可以在Fragment OnCreateView中直接使用控件名 （fvb）
    
    2. kotlin 不再支持三目运算 可转化为 if else处理 在两者作用域内 默认条件成立（有点实用）
    
    3. 关键字 apply Calls the specified function [block] with `this` value as its receiver and returns `this` value.
    
    @des 关于 anko 的一些介绍 https://www.jianshu.com/p/c4558aa7c502
    @more https://github.com/Kotlin/anko/wiki/Anko-Commons-%E2%80%93-Dialogs

ContextWrapper 装饰者模式

    1. 通过把 被装饰对象 作为 装饰器 的成员变量 
       当调用装饰器的操作时 装饰器还是会调用被装饰的对象的操作
       但是装饰器可以给对应的操作添加相关功能
       
       
(''')

(''')