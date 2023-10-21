# 导入所需的React模块：

createContext：用于创建一个React上下文。

useContext：用于访问上下文中的数据。

useState：用于创建状态变量。

# 创建一个ThemeContext上下文：

使用createContext函数创建一个React上下文，并初始化为undefined。

# 创建一个ThemeProvider组件：

这是一个React函数组件，接受一个名为children的属性作为其子元素。

在组件内部，使用useState创建一个名为theme的状态变量，初始值为"light"。

使用ThemeContext.Provider来包装children，将 theme state值 和 toggleTheme函数  作为值传递给上下文。

==> toggleTheme函数会根据当前theme的值切换主题，从"light"到"dark"或从"dark"到"light"。

# 创建一个useTheme自定义钩子：

这是一个自定义的React Hook，使用useContext(ThemeContext)来访问上下文中的数据。它允许组件访问当前的主题和切换主题的函数。

# 创建一个Switch组件：
这是一个函数组件，用于显示一个主题切换开关。

在Switch组件内部，使用useTheme自定义钩子来获取当前的主题和切换主题的函数。

通过input元素来显示一个复选框，其checked属性根据当前主题是否为"light"来确定是否勾选。

当用户切换复选框时，会触发onChange事件，调用toggleTheme函数来切换主题。

# 总结：
通过使用ThemeProvider组件提供的上下文，可以在整个应用程序中共享主题状态，

而Switch组件则可以根据用户的操作切换应用程序的主题。当用户切换主题时，整个应用程序中的主题都会同时更新。
