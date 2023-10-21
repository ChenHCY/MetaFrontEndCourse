import { createContext, useContext, useState } from "react";

// 使用createContext创建一个React的上下文数据，进行传递
//export const ThemeContext = React.createContext();
const ThemeContext = createContext(undefined);

export const ThemeProvider = ({ children }) => {
    //初始化一个变量来记录主题的颜色
    const [theme, setTheme] = useState("light");

    // toggleTheme function 判断当前的主题颜色，然后进行改变
    const toggleTheme = () => {
        setTheme((prevTheme) => (prevTheme === "light" ? "dark" : "light"));
    };
    
    // 使用ThemeContext.Provider来包装children
    // 将 theme 和 toggleTheme函数 作为值传递给上下文。
    return (
        <ThemeContext.Provider value={{ theme, toggleTheme }}>
            {children}
        </ThemeContext.Provider>
    );
};

/*这里是一个自定义的React fn hooks，
==> 通过使用useContext(ThemeContext); 来接收 上下文的数据，
==> 从而改变主题的颜色 */
export const useTheme = () => {
  const themeContext = useContext(ThemeContext);
  return themeContext;
};