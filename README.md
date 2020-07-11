# Spring 编程思想示例项目
 ## 第一章 Spring Framework 总览
  ### 核心特性
   #### 核心特性(Core)
   * IoC 容器(IoC Container)
   * Spring 事件(Events)
   * 资源管理(Resources)
   * 国际化(i18n)
   * 校验(Validation)
   * 数据绑定(Data Binding)
   * 类型装换(Type Conversion)
   * Spring 表达式(Spring Express Language)
   * 面向切面编程(AOP)
   
   #### 数据存储(Data Access)
   * JDBC
   * 事务抽象(Transactions)
   * DAO 支持(DAO Support)
   * O/R映射(O/R Mapping)
   * XML 编列(XML Marshalling)
   
   #### Web 技术(Web)
   * Web Servlet 技术栈
     * Spring MVC
     * WebSocket
     * SockJS
   * Web Reactive 技术栈
     * Spring WebFlux
     * WebClient
     * WebSocket
    
   #### 技术整合(Integration)
   * 远程调用(Remoting)
   * Java 消息服务(JMS)
   * Java 连接架构( JCA)
   * Java 管理扩展(JMX)
   * Java 邮件客户端(Email)
   * 本地任务(Tasks)
   * 本地调度(Scheduling)
   * 缓存抽象(Caching)
   * Spring 测试(Testing)
   
   #### 测试(Testing)
   * 模拟对象(Mock Objects)
   * TestContext 框架(TestContext Framework)
   * Spring MVC 测试(Spring MVC Test)
   * Web 测试客户端(WebTestClient)
    
 ## 第二章 重新认识 IoC
  ### 什么是 IOC
  控制反转（Inversion of Control，缩写为IoC），是面向对象编程中的一种设计原则，可以用来减低计算机代码之间的耦合度。
  其中最常见的方式叫做依赖注入（Dependency Injection，简称DI），还有一种方式叫“依赖查找”（Dependency Lookup）。
  通过控制反转，对象在被创建的时候，由一个调控系统内所有对象的外界实体，将其所依赖的对象的引用传递(注入)给它。
  
  ### IoC 主要实现策略
  在面向对象的编程中，有几种实现控制反转的基本技术。 这些是：
  * 服务定位器模式
  * 使用依赖注入
    * 构造函数注入
    * 注解注入
    * set方法注入
    * 接口注入
  * 使用上下文相关的查找
  * 使用模板方法设计模式
  * 使用策略设计模式
  
  * 依赖注入
  * 依赖查找
  
  ### IoC 容器的职责
  * 通用职责
  * 依赖处理
    * 依赖查找
    * 依赖注入
  * 生命周期管理
    * 容器
    * 托管的资源(Java Beans 或其他资源) 
  * 配置
    * 容器
        * 外部化配置
        * 托管的资源(Java Beans 或其他资源)
  
  ### IoC 容器的实现
  * 主要实现 
  * Java SE
    * Java Beans
    * Java ServiceLoader SPI
    * JNDI(Java Naming and Directory Interface)
  * Java EE
    * EJB(Enterprise Java Beans)
    * Servlet
  * 开源
    * Apache Avalon(http://avalon.apache.org/closed.html)
    * PicoContainer(http://picocontainer.com/)
    * Google Guice(https://github.com/google/guice)
    * Spring Framework(https://spring.io/projects/spring-framework)
    
  ### 传统 IoC 容器的实现
  * Java Beans 作为 IoC 容器 
  * 特性
    * 依赖查找
    * 生命周期管理
    * 配置元信息
    * 事件
    * 自定义
    * 资源管理
    * 持久化
  * 规范
    * JavaBeans:https://www.oracle.com/technetwork/java/javase/tech/index-jsp-138795.html
    * BeanContext:https://docs.oracle.com/javase/8/docs/technotes/guides/beans/spec/beancontext.html

 ## 第三章 Spring IoC 容器概述
  ### Spring IoC 依赖查找
  * 根据 Bean 名称查找 
    * 实时查找
    * 延迟查找
  * 根据 Bean 类型查找
    * 单个 Bean 对象
    * 集合 Bean 对象
  * 根据 Bean 名称 + 类型查找
  * 根据 Java 注解查找
    * 单个 Bean 对象
    * 集合 Bean 对象
    
  ### Spring IoC 依赖注入
  * 根据 Bean 名称注入
  * 根据 Bean 类型注入
    * 单个 Bean 对象
    * 集合 Bean 对象
  * 注入容器內建 Bean 对象
  * 注入非 Bean 对象
  * 注入类型
    * 实时注入 
    * 延迟注入
    
  ### Spring IoC 依赖来源
  * 自定义 Bean
  * 容器內建 Bean 对象 
  * 容器內建依赖
  
  ### Spring IoC 配置元信息
  * Bean 定义配置
    * 基于 XML 文件
    * 基于 Properties 文件
    * 基于 Java 注解
    * 基于 Java API(专题讨论)
  * IoC 容器配置
    * 基于 XML 文件
    * 基于 Java 注解
    * 基于 Java API (专题讨论) 
  * 外部化属性配置
    * 基于 Java 注解
   
  # Spring 应用上下文
  * ApplicationContext 除了 IoC 容器角色，还有提供:
    * 面向切面(AOP)
    * 配置元信息(Configuration Metadata)
    * 资源管理(Resources)
    * 事件(Events)
    * 国际化(i18n)
    * 注解(Annotations)
    * Environment 抽象(Environment Abstraction)
    
  ### 使用 Spring IoC 容器
  * BeanFactory 是 Spring 底层 IoC 容器
  * ApplicationContext 是具备应用特性的 BeanFactory 超集
  
  ### Spring IoC 容器生命周期
  * 启动 
  * 运行 
  * 停止
  
 ## 第四章 Spring Bean 基础
  ### 定义 Spring Bean
  * 什么是 BeanDefinition?
  * BeanDefinition 是 Spring Framework 中定义 Bean 的配置元信息接口，包含:
    * Bean 的类名
    * Bean 行为配置元素，如作用域、自动绑定的模式，生命周期回调等
    * 其他 Bean 引用，又可称作合作者(collaborators)或者依赖(dependencies)
    * 配置设置，比如 Bean 属性(Properties)
   
  ### BeanDefinition 元信息
  * BeanDefinition 元信息
   <table>
     <thead>
       <tr>
         <th>属性(Property)</th>
         <th>说明</th>
       </tr>
     </thead>
     <tbody>
       <tr>
         <td>Class</td>
         <td>Bean 全类名，必须是具体类，不能用抽象类或接口</td>
       </tr>
       <tr>
          <td>Name</td>
          <td>Bean 的名称或者 ID</td>
       </tr>
       <tr>
         <td>Scope</td>
         <td>Bean 的作用域(如:singleton、prototype 等)</td>
       </tr>
       <tr>
         <td>Constructor arguments</td>
         <td>Bean 构造器参数(用于依赖注入)</td>
       </tr>
      <tr>
         <td>Properties</td>
         <td>Bean 属性设置(用于依赖注入)</td>
      </tr>
      <tr>
         <td>Autowiring mode</td>
         <td>Bean 自动绑定模式(如:通过名称 byName)</td>
      </tr>
      <tr>
         <td>Lazy initialization mode</td>
         <td>Bean 延迟初始化模式(延迟和非延迟)</td>
      </tr>
      <tr>
         <td>Initialization method</td>
         <td>Bean 初始化回调方法名称</td>
      </tr>
      <tr>
         <td>Destruction method</td>
         <td>Bean 销毁回调方法名称</td>
      </tr>
      </tbody>
   </table>
   
  * BeanDefinition 构建
    * 通过 BeanDefinitionBuilder
    * 通过 AbstractBeanDefinition 以及派生类
    
  ### 命名 Spring Bean
  * Bean 的名称
    * 每个 Bean 拥有一个或多个标识符(identifiers)，这些标识符在 Bean 所在的容器必须是唯一 的。通常，一个 Bean 仅有一个标识符，如果需要额外的，可考虑使用别名(Alias)来扩充。
    * 在基于 XML 的配置元信息中，开发人员可用 id 或者 name 属性来规定 Bean 的 标识符。通常 Bean 的 标识符由字母组成，允许出现特殊字符。如果要想引入 Bean 的别名的话，可在 name 属性使用半角逗号(“,”)或分号(“;”) 来间隔。
    * Bean 的 id 或 name 属性并非必须制定，如果留空的话，容器会为 Bean 自动生成一个唯一的 名称。Bean 的命名尽管没有限制，不过官方建议采用驼峰的方式，更符合 Java 的命名约定。
   
  * Bean 名称生成器(BeanNameGenerator)
  * 由 Spring Framework 2.0.3 引入，框架內建两种实现:
    * DefaultBeanNameGenerator:默认通用 BeanNameGenerator 实现
  * AnnotationBeanNameGenerator:基于注解扫描的 BeanNameGenerator 实现，起始于Spring Framework 2.5
  
  ### Spring Bean 的别名
  * Bean 别名(Alias)的价值
    * 复用现有的 BeanDefinition
    * 更具有场景化的命名方法，比如:
  ```
       <alias name="myApp-dataSource" alias="subsystemA-dataSource"/> 
       <alias name="myApp-dataSource" alias="subsystemB-dataSource"/>
  ```

  ### 注册 Spring Bean
  * BeanDefinition 注册
    * XML 配置元信息
        * <bean name=”...” ... /> 
    * Java 注解配置元信息
        * @Bean
        * @Component
        * @Import
    * Java API 配置元信息
        * 命名方式: ```BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)```
        * 非命名方式: ``` BeanDefinitionReaderUtils#registerWithGeneratedName(AbstractBeanDefinition,Be
  anDefinitionRegistry) ```
        * 配置类方式: ```AnnotatedBeanDefinitionReader#register(Class...)```
  * 外部单例对象注册
    * Java API 配置元信息
        * ```SingletonBeanRegistry#registerSingleton```
  
  ### 实例化 Spring Bean
  * Bean 实例化(Instantiation)
    * 常规方式
        * 通过构造器(配置元信息:XML、Java 注解和 Java API )
        * 通过静态工厂方法(配置元信息:XML 和 Java API )
        * 通过 Bean 工厂方法(配置元信息:XML和 Java API )
        * 通过 FactoryBean(配置元信息:XML、Java 注解和 Java API )
  * 特殊方式
    * 通过 ```ServiceLoaderFactoryBean(配置元信息:XML、Java 注解和 Java API )```
    * 通过 ```AutowireCapableBeanFactory#createBean(java.lang.Class, int, boolean)```
    * 通过 ```BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)```
    
  ### 初始化 Spring Bean
  * Bean 初始化（Initialization）
    * @PostConstruct 标注方法
    * 实现 InitializingBean 接口的 afterPropertiesSet() 方法
    * 自定义初始化方法
      * XML 配置: ```<bean init-method="initMethod"  .../>```
      * Java 注解: ```@Bean(initMethod="initMethod")``` 
      * Java API: ```AbstractBeanDefinition#setInitMethodName(String)```
  * 优先级：@PostConstruct > InitializingBean > 自定义初始化
  
  ### 延迟初始化 Spring Bean
  * Bean 延迟初始化（Lazy Initialization）
    * XML 配置：```<bean lazy-init="true" .../>```
    * Java 注解：@Lazy(true)
    
  ### 销毁 Spring Bean
  * Bean 销毁（Destroy）
    * @PostDestroy 标注方法
    * 实现 DisposableBean 接口的 destroy() 方法
    * 自定义销毁方法
      * XML 配置: ```<bean destroy-method="destroy"  .../>```
      * Java 注解: ```@Bean(destroy="destroy")``` 
      * Java API: ```AbstractBeanDefinition#setDistroyMethodName(String)```
  * 优先级：@PostDestroy > DisposableBean > 自定义销毁
  
  ### 垃圾回收 Spring Bean
  * Bean 垃圾回收（GC）
    * 关闭 Spring 容器（应用上下文）
    * 执行 GC
    * Spring Bean 覆盖的 finalize() 方法被回调
    
 ## 第五章 Spring IoC 依赖查找 (Dependency Lookup) 
  ### 依赖查找的今世前生
  * 单一类型依赖查找
    * JNDI - javax.naming.Context#lookup(javax.naming.Name)
    * JavaBeans - java.beans.beancontext.BeanContext
  * 集合类型依赖查找
    * java.beans.beancontext.BeanContext
  * 层次性依赖查找
    * java.beans.beancontext.BeanContext
    
  ### 单一类型依赖查找
  * 单一类型依赖查找接口 - BeanFactory
    * 根据 Bean 名称查找
        * getBean(String)
        * Spring 2.5 覆盖默认参数：getBean(String, Object...)
    * 根据 Bean 类型查找
        * Bean 实时查找
            * Spring 3.0 getBean(Class)
            * Spring 4.1 覆盖默认参数：getBean(Class, Object...)
        * Spring 5.1 Bean 延迟查找
            * getBeanProvider(Class)
            * getBeanProvider(ResolvableType)
    * 根据 Bean 名称 + 类型查找：getBean(String, Class)
  
  ### 集合类型依赖查找
  * 集合类型依赖查找接口 - ListableBeanFactory
    * 根据 Bean 类型查找
        * 获取同类型 Bean 名称列表
            * getBeanNamesForType(Class)
            * Spring 4.2 getBeanNamesForType(ResolvableType)
        * 获取同类型 Bean 实例列表
            * getBeansOfType(Class) 以及重载方法
    * 通过注解类型查找
        * Spring 3.0 获取标注类型 Bean 名称列表
            * getBeanNamesForAnnotation(Class<? extends Annotation>)
        * Spring 3.0 获取标注类型 Bean 实例列表
            * getBeansWithAnnotation(Class<? extends Annotation>)
        * Spring 3.0 获取指定名称 + 标注类型 Bean 实例
            * findAnnotationOnBean(String, Class<? extends Annotation>)
  
  ### 层次性依赖查找
  * 层次性依赖查找接口 - HierarchicalBeanFactory
    * 双亲 BeanFactory：getParentBeanFactory()
    * 层次性查找
        * 根据 Bean 名称查找
            * 基于 containsLocalBean 方法实现
        * 根据 Bean 类型查找实例列表
            * 单一类型：BeanFactoryUtils#beanOfType
            * 集合类型：BeanFactoryUtils#beansOfTypeIncludingAncestors
        * 根据 Java 注解查找名称列表
            * BeanFactoryUtils#beanNamesForTypeIncludingAncestros
            
  ### 延迟依赖查找
  * Bean 延迟依赖查找接口
    * org.springframework.beans.factory.ObjectFactory
    * org.springframework.beans.factory.ObjectProvider
        * Spring 5 对 Java8 特性扩展
            * 函数式接口
                * getIfAvailable(Supplier)
                * IfAvailable(Consumer)
            * Stream 扩展 - stream()    
            
  ### 安全依赖查找
  * 依赖查找安全性对比
    <table>
        <thead>
            <tr>
                <th>依赖查找类型</th>
                <th>代表实现</th>
                <th>是否安全</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>单一类型查找</td>
                <td>BeanFactory#getBean</td>
                <td><span style="color: red;">否</span></td>
            </tr>
            <tr>
                <td></td>
                <td>BeanFactory#getObject</td>
                <td><span style="color: red;">否</span></td>
            </tr>
            <tr>
                <td></td>
                <td>BeanFactory#getIfAvailable</td>
                <td><span style="color: green;">是</span></td>
            </tr>
            <tr>
                <td>集合类型查找</td>
                <td>ListableBeanFactory#getBeansOfType</td>
                <td><span style="color: green;">是</span></td>
            </tr>
            <tr>
                <td></td>
                <td>ObjectProvider#stream</td>
                <td><span style="color: green;">是</span></td>
            </tr>
        </tbody>
    </table>
   注意：层次性依赖查找的安全性取决于其扩展的单一或集合类型的 BeanFactory 接口
   
  ### 内建可查找的依赖
  * AbstractApplicationContext 内建可查找的依赖
    <table>
        <thead>
            <tr>
                <th>Bean 名称</th>
                <th>Bean 实例</th>
                <th>使用场景</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>environment</td>
                <td>Environment 对象</td>
                <td>外部化配置以及 Profiles</td>
            </tr>
            <tr>
                <td>systemProperties</td>
                <td>java.util.Properties 对象</td>
                <td>Java 系统属性</td>
            </tr>
            <tr>
                <td>systemEnvironment</td>
                <td>java.util.Map 对象</td>
                <td>操作系统环境变量</td>
            </tr>
            <tr>
                <td>messageSource</td>
                <td>MessageSource 对象</td>
                <td>国际化文案</td>
            </tr>
            <tr>
                <td>lifecycleProcessor</td>
                <td>LifecycleProcessor 对象</td>
                <td>Lifecycle Bean 处理器</td>
            </tr>
            <tr>
                <td>applicationEventMulticaster</td>
                <td>ApplicationEventMulticaster 对象</td>
                <td>Spring 事件广播器</td>
            </tr>
        </tbody>
    </table>
  * 注解驱动 Spring 应用上下文内建可查找的依赖（部分）
     <table>
      <thead>
          <tr>
              <th>Bean 名称</th>
              <th>Bean 实例</th>
              <th>使用场景</th>
          </tr>
      </thead>
      <tbody>
          <tr>
              <td>org.springframework.context.annotation.internalConfigurationAnnotationProcessor</td>
              <td>ConfigurationClassPostProcessor 对象</td>
              <td>处理 Spring 配置类</td>
          </tr>
          <tr>
              <td>org.springframework.context.annotation.internalAutowiredAnnotationProcessor</td>
              <td>AutowiredAnnotationBeanPostProcessor 对象</td>
              <td>处理 @Autowired 以及 @Value 注解</td>
          </tr>
          <tr>
              <td>org.springframework.context.annotation.internalCommonAnnotationProcessor</td>
              <td>CommonAnnotationBeanPostProcessor 对象</td>
              <td>（条件激活）处理 JSR-250 注解，如：@PostConstruct等</td>
          </tr>
          <tr>
              <td>org.springframework.context.event.internalEventListenerProcessor</td>
              <td>EventListenerMethodProcessor 对象</td>
              <td>处理标注 @EventListener 的 Spring 事件监听方法</td>
          </tr>
          <tr>
              <td>org.springframework.context.event.internalEventListenerFactory</td>
              <td>DefaultEventListenerFactory 对象</td>
              <td>@EventListener 事件监听方法适配为 ApplicationListener</td>
          </tr>
          <tr>
             <td>org.springframework.context.annotation.internalPersistenceAnnotationProcessor</td>
             <td>PersistenceAnnotationBeanPostProcessor 对象</td>
             <td>（条件激活）处理 JPA 注解场景</td>
          </tr>
      </tbody>
    </table>
    
  ### 依赖查找中的经典异常
  * BeansException 子类型
      <table>
        <thead>
            <tr>
                <th>异常类型</th>
                <th>触发条件（举例）</th>
                <th>场景举例</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>NoSuchBeanDefinitionException</td>
                <td>当查找 Bean 不存在于 IoC 容器时</td>
                <td>BeanFactory#getBeanObjectFactory#getObject</td>
            </tr>
            <tr>
                <td>NoUniqueBeanDefinitionException</td>
                <td>类型依赖查找时，IoC 容器存在多个 Bean 实例</td>
                <td>BeanFactory#getBean(Class)</td>
            </tr>
            <tr>
                <td>BeanInstantiationException</td>
                <td>当 Bean 所对应的类型非具体类时</td>
                <td>BeanFactory#getBean</td>
            </tr>
            <tr>
                <td>BeanCreationException</td>
                <td>当 Bean 初始化过程中</td>
                <td>Bean 初始化方法执行异常时</td>
            </tr>
            <tr>
                <td>BeanDefinitionStoreException</td>
                <td>当 BeanDefinition 配置元信息非法时</td>
                <td>XML 配置资源无法打开时</td>
            </tr>
        </tbody>
      </table>
  
  ### 面试题精选
   * 沙雕面试题 - ObjectFactory 与 BeanFactory 的区别？
    答：ObjectFactory 与 BeanFactory 均提供依赖查找的能力。不过 ObjectFactory 仅关注一个或一种类型的 Bean 依赖查找，
     并且自身不具备依赖查找的能力，能力则由 BeanFactory 输出。BeanFactory 则提供了单一类型、集合类型以及层次性等多种依赖查找方式。
  
   * 996 面试题 - BeanFactory.getBean 操作是否线程安全？
    答：BeanFactory.getBean 方法的执行是线程安全的，操作过程中会增加互斥锁
    
## 第六章 Spring IoC 依赖注入（Dependency Injection）
 ### 依赖注入的模式和类型
 * 手动模式 - 配置或者编程的防晒，提前安排注入规则
    * XML 资源配置元信息
    * Java 注解配置元信息
    * API 配置元信息
 * 自动模式 - 实现方提供依赖自动关联的方式，按照内建的注入规则
    * Autowiring（自动绑定）
 * 依赖注入类型
   | 依赖注入类型  | 配置元数据举例 |
   | ----------  | :---------  |
   | Setter 方法  | ```<proeprty name="user" ref="userBean"/>``` |
   | 构造器  | ```<constructor-arg name="user" ref="userBean" />``` |
   | 字段 | ```@Autowired User user;``` |
   | 方法 | ```@Autowired public void user(User user) {...}``` |
   | 接口回调 | ```class MyBean implements BeanFactoryAware {...}``` |
   
 ### 自动绑定（Autowiring）介绍
  Spring提供了一种自动检测各种bean之间关系的方法。 这可以通过在Spring配置文件中声明所有bean依赖项来完成。 因此，Spring能够利用BeanFactory来了解所有使用过的bean之间的依赖关系。
  基于XML配置的自动装配功能具有五种模式-否，byName，byType，构造函数和自动检测。 默认模式为否。
  
 ### 自动绑定（Autowiring）模式
  * Autowiring modes
    | 模式 | 说明 |
    | ----------  | :---------  |
    | no | 默认值，未激活 Autowiring，需要手动指定依赖注入对象 |
    | byName | 根据被注入属性的名称作为 Bean 名称进行依赖查找，并将对象设置到该属性 |
    | byType | 根据被注入属性的类型作为依赖类型进行查找，并将对象设置到该属性 |
    | constructor | 特殊 byType 类型，用于构造器参数 |
  参考枚举：```org.springframework.beans.factory.annotation.Autowire```
  
 ### Setter 方法注入
  * 实现方法
    * 手动模式
        * XML 资源配置元信息
        * Java 注解配置元信息
        * API 配置元信息
    * 自动模式
        * byName
        * byType
  
 ### 构造器注入
  * 实现方法
    * 手动模式
        * XML 资源配置元信息
        * Java 注解配置元信息
        * API 配置元信息
    * 自动模式
        * constructor
        
 ### 构造器注入
  * 实现方法
    * 手动模式
        * Java 注解配置元信息
            * @Autowired
            * @Resource
            * @Inject（可选）
