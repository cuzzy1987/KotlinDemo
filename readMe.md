kotlin

    1. 原生控件 RecyclerView ViewPage TabLayout
    2. 原生网络访问 anko协程 线程切换
    3. android pie 不被允许明文网络服务 需配置网络安全文件 或降级使用或使用https


ContextWrapper 装饰者模式

    1. 通过把 被装饰对象 作为 装饰器 的成员变量 
       当调用装饰器的操作时 装饰器还是会调用被装饰的对象的操作
       但是装饰器可以给对应的操作添加相关功能