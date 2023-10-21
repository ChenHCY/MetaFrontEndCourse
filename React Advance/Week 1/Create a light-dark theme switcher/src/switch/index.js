import "./Styles.css";
import { useTheme } from "../ThemeContext";

const Switch = () => {
  //使用useTheme自定义钩子 从上下午中 来获取当前的主题和切换主题的函数的值。
  const { theme, toggleTheme } = useTheme();

  // 当触发onChange事件时, 会调用toggleTheme函数来切换主题。
  // 根据taggleTheme函数的值从而进行改变 
  return (
    <label className="switch">
      <input
        type="checkbox"
        checked={theme === "light"}
        onChange={toggleTheme} 
      />
      <span className="slider round" />
    </label>
  );
};

export default Switch;
