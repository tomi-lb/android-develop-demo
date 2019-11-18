
这是一个基于MVP架构的Android Demo项目，用于新技术的学习交流。每个Activity有不同的Demo示例，供使用时参考。

用到的第三方框架:  
Rxjava2  
Retrofit2  
okhttp  
glide  

第三方布局:  
SmartRefreshLayout  
bga-banner  



**MaterialActivity**  
基于material design设计的展示类页面：沉浸+可伸缩状态栏，运用到了以下布局:  
CoordinatorLayout  
AppBarLayout  
CollapsingToolbarLayout  
Toolbar  
NestedScrollView  
FloatingActionButton  

**TabLayoutActivity**  
标准的新闻展示类TabLayout布局，左右滑动方式切换标签，下拉上滑方式更新数据。RecyclerView多种Item布局(banner + 导航标签 + 详情展示)，运用布局：  
TabLayout + ViewPager  
RecyclerView  
SmartRefreshLayout  

**万能Adapter** 
用于RecyclerView的万能Adapter封装，可以简化代码量 
CommonAdapter 
CommonViewHolder 

**ClickEventActivity** 
点击产生一个动作，同时返回一个结果。只需要替换Presenter就可以实现不同的操作，可用于后台应用的学习。现有Presenter如下： 
OkhttpPresenter -- 演示Okhttp的以拦截器的使用示例 
